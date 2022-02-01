package com.tencent.matrix.report;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class h
  extends com.tencent.matrix.e.a
{
  private final Context context;
  public volatile boolean cqf = false;
  private Long cum;
  private String cun;
  private volatile boolean cuo;
  private Long cup;
  private f cuq = new f();
  private final ConcurrentHashMap<c, Object> cur = new ConcurrentHashMap();
  public b cus;
  private final ConcurrentLinkedQueue<d> cut = new ConcurrentLinkedQueue();
  public final ConcurrentLinkedDeque<d> cuu = new ConcurrentLinkedDeque();
  
  public h(Context paramContext, Long paramLong1, String paramString, Boolean paramBoolean, Long paramLong2)
  {
    super(paramContext);
    this.context = paramContext;
    this.cum = paramLong1;
    this.cun = paramString;
    this.cuo = paramBoolean.booleanValue();
    this.cup = paramLong2;
    if (ai.cin()) {
      try
      {
        MrsLogic.init(paramLong1.longValue(), paramString, paramBoolean.booleanValue(), paramLong2.longValue());
        return;
      }
      catch (Throwable paramContext)
      {
        com.tencent.matrix.g.c.printErrStackTrace("MicroMsg.MatrixReporter", paramContext, "", new Object[0]);
        MrsLogic.init(paramLong1.longValue(), paramString, paramBoolean.booleanValue(), paramLong2.longValue());
        return;
      }
    }
    paramLong1 = new IntentFilter();
    paramLong1.addAction("strategyNotify");
    paramLong1.addAction("statusNotify");
    com.tencent.matrix.e.addAction(paramLong1);
    paramString = new MatrixStrategyNotifyBroadcast();
    try
    {
      paramContext.registerReceiver(paramString, paramLong1, "com.tencent.mm.matrix.strategynotify", null);
      return;
    }
    catch (Throwable paramBoolean)
    {
      paramContext.unregisterReceiver(paramString);
      paramContext.registerReceiver(paramString, paramLong1, "com.tencent.mm.matrix.strategynotify", null);
    }
  }
  
  private static void a(c paramc, com.tencent.mm.vfs.e parame)
  {
    if (paramc != null) {}
    try
    {
      if (!parame.exists())
      {
        com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramc, parame });
        return;
      }
      MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
      localMatrixUploadIssue.setTag(paramc.tag);
      localMatrixUploadIssue.setCanSplitSlice(true);
      localMatrixUploadIssue.setDataType(1);
      localMatrixUploadIssue.setNeedDeleteFileAfterSucc(true);
      localMatrixUploadIssue.setType(paramc.type);
      localMatrixUploadIssue.setDesKey(paramc.key);
      localMatrixUploadIssue.setFilePath(q.B(parame.fxV()));
      MrsLogic.uploadMatrixIssue(localMatrixUploadIssue);
      return;
    }
    catch (Throwable paramc)
    {
      com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramc)), new Object[0]);
    }
  }
  
  public final void a(c paramc)
  {
    paramc = d.d(paramc);
    if ((paramc.cuf instanceof com.tencent.matrix.trace.a))
    {
      this.cuu.addFirst(paramc);
      if (this.cuu.size() >= 30) {
        this.cuu.removeLast();
      }
    }
    try
    {
      if ((this.cus != null) && (this.cus.c(paramc)))
      {
        ac.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", new Object[] { paramc.tag });
        return;
      }
    }
    catch (Exception paramc)
    {
      ac.printErrStackTrace("MicroMsg.MatrixReporter", paramc, "", new Object[0]);
      return;
    }
    Object localObject = this.cur.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).a(paramc);
    }
    localObject = paramc.filePath;
    try
    {
      if (ai.cin())
      {
        a(paramc, (String)localObject);
        return;
      }
    }
    catch (Throwable paramc)
    {
      com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramc)), new Object[0]);
      return;
    }
    Intent localIntent = new Intent(this.context, MatrixReportBroadcast.class);
    localIntent.putExtra("tag", paramc.tag);
    localIntent.putExtra("key", paramc.key);
    localIntent.putExtra("type", paramc.type);
    localIntent.putExtra("value", paramc.cue.toString());
    localIntent.putExtra("filePath", (String)localObject);
    com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", new Object[] { paramc.tag });
    this.context.sendBroadcast(localIntent);
  }
  
  public final void a(c paramc, String paramString)
  {
    if ((!this.cqf) && (ai.cin()))
    {
      com.tencent.matrix.g.c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", new Object[] { paramc.tag });
      paramc = d.d(paramc);
      paramc.filePath = paramString;
      this.cut.add(paramc);
    }
    do
    {
      return;
      if (!this.cut.isEmpty())
      {
        Iterator localIterator = this.cut.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", new Object[] { locald.tag, locald.cue, Integer.valueOf(d.DIc) });
          MrsLogic.collectData(locald.tag, locald.cue.toString().getBytes());
          if (!TextUtils.isEmpty(paramString)) {
            a(locald, new com.tencent.mm.vfs.e(locald.filePath));
          }
        }
        this.cut.clear();
      }
      com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", new Object[] { paramc.tag, paramc.cue, Integer.valueOf(d.DIc) });
      MrsLogic.collectData(paramc.tag, paramc.cue.toString().getBytes());
      this.cuq.d(paramc.tag, paramc.cue);
    } while (TextUtils.isEmpty(paramString));
    a(paramc, new com.tencent.mm.vfs.e(paramString));
  }
  
  public final void a(c paramc)
  {
    this.cur.put(paramc, new Object());
  }
  
  public final String toString()
  {
    return "clientVersion=" + this.cum + " revision=" + this.cun + " isDebug=" + this.cuo + " publishType" + this.cup;
  }
  
  public static final class a
  {
    public final Context context;
    public Long cum;
    public String cun;
    public Long cup;
    public Boolean cuv;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new RuntimeException("matrix report init, context is null");
      }
      this.context = paramContext;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean c(c paramc);
  }
  
  public static abstract interface c
  {
    public abstract void a(h.d paramd);
  }
  
  public static final class d
    extends c
  {
    public String filePath;
    
    public static d d(c paramc)
    {
      d locald = new d();
      locald.cue = paramc.cue;
      locald.tag = paramc.tag;
      locald.cuf = paramc.cuf;
      locald.key = paramc.key;
      locald.type = paramc.type;
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.h
 * JD-Core Version:    0.7.0.1
 */