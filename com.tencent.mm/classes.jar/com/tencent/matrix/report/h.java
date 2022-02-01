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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class h
  extends com.tencent.matrix.e.a
{
  public volatile boolean cBE = false;
  private Long cFQ;
  private String cFR;
  private volatile boolean cFS;
  private Long cFT;
  private f cFU = new f();
  private final ConcurrentHashMap<c, Object> cFV = new ConcurrentHashMap();
  public b cFW;
  private final ConcurrentLinkedQueue<d> cFX = new ConcurrentLinkedQueue();
  public final ConcurrentLinkedDeque<d> cFY = new ConcurrentLinkedDeque();
  private final Context context;
  
  public h(Context paramContext, Long paramLong1, String paramString, Boolean paramBoolean, Long paramLong2)
  {
    super(paramContext);
    this.context = paramContext;
    this.cFQ = paramLong1;
    this.cFR = paramString;
    this.cFS = paramBoolean.booleanValue();
    this.cFT = paramLong2;
    if (ak.coh()) {
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
      paramContext.registerReceiver(paramString, paramLong1, "com.tencent.mm.matrix.strategynotify", null);
      return;
    }
    catch (Throwable paramBoolean)
    {
      paramContext.unregisterReceiver(paramString);
      paramContext.registerReceiver(paramString, paramLong1, "com.tencent.mm.matrix.strategynotify", null);
    }
  }
  
  private static void a(c paramc, k paramk)
  {
    if (paramc != null) {}
    try
    {
      if (!paramk.exists())
      {
        com.tencent.matrix.g.c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramc, paramk });
        return;
      }
      MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
      localMatrixUploadIssue.setTag(paramc.tag);
      localMatrixUploadIssue.setCanSplitSlice(true);
      localMatrixUploadIssue.setDataType(1);
      localMatrixUploadIssue.setNeedDeleteFileAfterSucc(true);
      localMatrixUploadIssue.setType(paramc.type);
      localMatrixUploadIssue.setDesKey(paramc.key);
      localMatrixUploadIssue.setFilePath(w.B(paramk.fTh()));
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
    if ((paramc.cFH instanceof com.tencent.matrix.trace.a))
    {
      this.cFY.addFirst(paramc);
      if (this.cFY.size() >= 30) {
        this.cFY.removeLast();
      }
    }
    try
    {
      if ((this.cFW != null) && (this.cFW.c(paramc)))
      {
        ae.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", new Object[] { paramc.tag });
        return;
      }
    }
    catch (Exception paramc)
    {
      ae.printErrStackTrace("MicroMsg.MatrixReporter", paramc, "", new Object[0]);
      return;
    }
    Object localObject = this.cFV.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((c)((Iterator)localObject).next()).a(paramc);
    }
    localObject = paramc.filePath;
    try
    {
      if (ak.coh())
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
    localIntent.putExtra("value", paramc.cFG.toString());
    localIntent.putExtra("filePath", (String)localObject);
    com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", new Object[] { paramc.tag });
    this.context.sendBroadcast(localIntent);
  }
  
  public final void a(c paramc, String paramString)
  {
    if ((!this.cBE) && (ak.coh()))
    {
      com.tencent.matrix.g.c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", new Object[] { paramc.tag });
      paramc = d.d(paramc);
      paramc.filePath = paramString;
      this.cFX.add(paramc);
    }
    do
    {
      return;
      if (!this.cFX.isEmpty())
      {
        Iterator localIterator = this.cFX.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", new Object[] { locald.tag, locald.cFG, Integer.valueOf(d.FFH) });
          MrsLogic.collectData(locald.tag, locald.cFG.toString().getBytes());
          if (!TextUtils.isEmpty(paramString)) {
            a(locald, new k(locald.filePath));
          }
        }
        this.cFX.clear();
      }
      com.tencent.matrix.g.c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", new Object[] { paramc.tag, paramc.cFG, Integer.valueOf(d.FFH) });
      MrsLogic.collectData(paramc.tag, paramc.cFG.toString().getBytes());
      this.cFU.d(paramc.tag, paramc.cFG);
    } while (TextUtils.isEmpty(paramString));
    a(paramc, new k(paramString));
  }
  
  public final void a(c paramc)
  {
    this.cFV.put(paramc, new Object());
  }
  
  public final String toString()
  {
    return "clientVersion=" + this.cFQ + " revision=" + this.cFR + " isDebug=" + this.cFS + " publishType" + this.cFT;
  }
  
  public static final class a
  {
    public Long cFQ;
    public String cFR;
    public Long cFT;
    public Boolean cFZ;
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
      locald.cFG = paramc.cFG;
      locald.tag = paramc.tag;
      locald.cFH = paramc.cFH;
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