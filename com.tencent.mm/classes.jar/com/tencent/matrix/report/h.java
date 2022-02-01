package com.tencent.matrix.report;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.e;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class h
  extends com.tencent.matrix.e.a
{
  private Long cWo;
  private String cWp;
  private volatile boolean cWq;
  private Long cWr;
  private f cWs = new f();
  private final ConcurrentHashMap<c, Object> cWt = new ConcurrentHashMap();
  public b cWu;
  private final ConcurrentLinkedQueue<d> cWv = new ConcurrentLinkedQueue();
  public final ConcurrentLinkedDeque<d> cWw = new ConcurrentLinkedDeque();
  private final Context context;
  public volatile boolean isInit = false;
  
  public h(Context paramContext, Long paramLong1, String paramString, Boolean paramBoolean, Long paramLong2)
  {
    super(paramContext);
    this.context = paramContext;
    this.cWo = paramLong1;
    this.cWp = paramString;
    this.cWq = paramBoolean.booleanValue();
    this.cWr = paramLong2;
    if (MMApplicationContext.isMainProcess()) {
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
    e.addAction(paramLong1);
    paramString = new MatrixStrategyNotifyBroadcast();
    try
    {
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.dag, null);
      return;
    }
    catch (Throwable paramBoolean)
    {
      paramContext.unregisterReceiver(paramString);
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.dag, null);
    }
  }
  
  private static void a(c paramc, o paramo)
  {
    if (paramc != null) {}
    try
    {
      if (!paramo.exists())
      {
        com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramc, paramo });
        return;
      }
      MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
      localMatrixUploadIssue.setTag(paramc.tag);
      localMatrixUploadIssue.setCanSplitSlice(true);
      localMatrixUploadIssue.setDataType(1);
      localMatrixUploadIssue.setNeedDeleteFileAfterSucc(true);
      localMatrixUploadIssue.setType(paramc.type);
      localMatrixUploadIssue.setDesKey(paramc.key);
      localMatrixUploadIssue.setFilePath(aa.z(paramo.her()));
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
    if ((paramc.cWf instanceof com.tencent.matrix.trace.a))
    {
      this.cWw.addFirst(paramc);
      if (this.cWw.size() >= 30) {
        this.cWw.removeLast();
      }
    }
    try
    {
      if ((this.cWu != null) && (this.cWu.c(paramc)))
      {
        Log.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", new Object[] { paramc.tag });
        return;
      }
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.MatrixReporter", paramc, "", new Object[0]);
      return;
    }
    Object localObject = this.cWt.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).a(paramc);
    }
    localObject = paramc.filePath;
    try
    {
      if (MMApplicationContext.isMainProcess())
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
    localIntent.putExtra("value", paramc.cWe.toString());
    localIntent.putExtra("filePath", (String)localObject);
    com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", new Object[] { paramc.tag });
    this.context.sendBroadcast(localIntent);
  }
  
  public final void a(c paramc, String paramString)
  {
    if ((!this.isInit) && (MMApplicationContext.isMainProcess()))
    {
      com.tencent.matrix.g.c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", new Object[] { paramc.tag });
      paramc = d.d(paramc);
      paramc.filePath = paramString;
      this.cWv.add(paramc);
    }
    do
    {
      return;
      if (!this.cWv.isEmpty())
      {
        Iterator localIterator = this.cWv.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", new Object[] { locald.tag, locald.cWe, Integer.valueOf(d.KyO) });
          MrsLogic.collectData(locald.tag, locald.cWe.toString().getBytes());
          if (!TextUtils.isEmpty(paramString)) {
            a(locald, new o(locald.filePath));
          }
        }
        this.cWv.clear();
      }
      com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", new Object[] { paramc.tag, paramc.cWe, Integer.valueOf(d.KyO) });
      MrsLogic.collectData(paramc.tag, paramc.cWe.toString().getBytes());
      this.cWs.g(paramc.tag, paramc.cWe);
    } while (TextUtils.isEmpty(paramString));
    a(paramc, new o(paramString));
  }
  
  public final void a(c paramc)
  {
    this.cWt.put(paramc, new Object());
  }
  
  public final String toString()
  {
    return "clientVersion=" + this.cWo + " revision=" + this.cWp + " isDebug=" + this.cWq + " publishType" + this.cWr;
  }
  
  public static final class a
  {
    public Long cWo;
    public String cWp;
    public Long cWr;
    public Boolean cWx;
    public final Context context;
    
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
      locald.cWe = paramc.cWe;
      locald.tag = paramc.tag;
      locald.cWf = paramc.cWf;
      locald.key = paramc.key;
      locald.type = paramc.type;
      return locald;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.h
 * JD-Core Version:    0.7.0.1
 */