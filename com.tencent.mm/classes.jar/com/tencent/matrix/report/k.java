package com.tencent.matrix.report;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.d.a;
import com.tencent.matrix.e;
import com.tencent.matrix.e.c;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class k
  extends a
{
  private final Context context;
  private Long daj;
  private String dak;
  private volatile boolean dal;
  private Long dam;
  private i dan = new i();
  private final ConcurrentHashMap<com.tencent.matrix.d.b, d> dao = new ConcurrentHashMap();
  public c dap;
  private final ConcurrentLinkedQueue<b> daq = new ConcurrentLinkedQueue();
  public final ConcurrentLinkedDeque<b> dar = new ConcurrentLinkedDeque();
  public volatile boolean isInit = false;
  
  public k(Context paramContext, Long paramLong1, String paramString, Boolean paramBoolean, Long paramLong2)
  {
    super(paramContext);
    this.context = paramContext;
    this.daj = paramLong1;
    this.dak = paramString;
    this.dal = paramBoolean.booleanValue();
    this.dam = paramLong2;
    if (MMApplicationContext.isMainProcess()) {
      try
      {
        MrsLogic.init(paramLong1.longValue(), paramString, paramBoolean.booleanValue(), paramLong2.longValue());
        return;
      }
      catch (Throwable paramContext)
      {
        c.printErrStackTrace("MicroMsg.MatrixReporter", paramContext, "", new Object[0]);
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
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.dez, null);
      return;
    }
    catch (Throwable paramBoolean)
    {
      paramContext.unregisterReceiver(paramString);
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.dez, null);
    }
  }
  
  private static void a(f paramf, q paramq)
  {
    if (paramf != null) {}
    try
    {
      if (!paramq.ifE())
      {
        c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramf, paramq });
        return;
      }
      MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
      localMatrixUploadIssue.setTag(paramf.tag);
      localMatrixUploadIssue.setCanSplitSlice(true);
      localMatrixUploadIssue.setDataType(1);
      localMatrixUploadIssue.setNeedDeleteFileAfterSucc(true);
      localMatrixUploadIssue.setType(paramf.type);
      localMatrixUploadIssue.setDesKey(paramf.key);
      localMatrixUploadIssue.setFilePath(paramq.bOF());
      MrsLogic.uploadMatrixIssue(localMatrixUploadIssue);
      return;
    }
    catch (Throwable paramf)
    {
      c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramf)), new Object[0]);
    }
  }
  
  public final void a(com.tencent.matrix.d.b paramb, d paramd)
  {
    this.dao.put(paramb, paramd);
  }
  
  public final void a(f paramf)
  {
    paramf = b.d(paramf);
    if ((paramf.daa instanceof com.tencent.matrix.trace.b))
    {
      this.dar.addFirst(paramf);
      if (this.dar.size() >= 30) {
        this.dar.removeLast();
      }
    }
    try
    {
      if ((this.dap != null) && (this.dap.c(paramf)))
      {
        Log.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", new Object[] { paramf.tag });
        return;
      }
    }
    catch (Exception paramf)
    {
      Log.printErrStackTrace("MicroMsg.MatrixReporter", paramf, "", new Object[0]);
      return;
    }
    Object localObject = (d)this.dao.get(paramf.daa);
    if (localObject != null) {
      ((d)localObject).a(paramf);
    }
    localObject = paramf.dat;
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        a(paramf, (String)localObject);
        return;
      }
    }
    catch (Throwable paramf)
    {
      c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramf)), new Object[0]);
      return;
    }
    Intent localIntent = new Intent(this.context, MatrixReportBroadcast.class);
    localIntent.putExtra("tag", paramf.tag);
    localIntent.putExtra("key", paramf.key);
    localIntent.putExtra("type", paramf.type);
    localIntent.putExtra("value", paramf.cZZ.toString());
    localIntent.putExtra("filePath", (String)localObject);
    c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", new Object[] { paramf.tag });
    this.context.sendBroadcast(localIntent);
  }
  
  public final void a(f paramf, String paramString)
  {
    if ((!this.isInit) && (MMApplicationContext.isMainProcess()))
    {
      c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", new Object[] { paramf.tag });
      paramf = b.d(paramf);
      paramf.dat = paramString;
      this.daq.add(paramf);
    }
    do
    {
      return;
      if (!this.daq.isEmpty())
      {
        Iterator localIterator = this.daq.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", new Object[] { localb.tag, localb.cZZ, Integer.valueOf(d.RAD) });
          MrsLogic.collectData(localb.tag, localb.cZZ.toString().getBytes());
          if (!TextUtils.isEmpty(paramString)) {
            a(localb, new q(localb.dat));
          }
        }
        this.daq.clear();
      }
      c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", new Object[] { paramf.tag, paramf.cZZ, Integer.valueOf(d.RAD) });
      MrsLogic.collectData(paramf.tag, paramf.cZZ.toString().getBytes());
      this.dan.f(paramf.tag, paramf.cZZ);
    } while (TextUtils.isEmpty(paramString));
    a(paramf, new q(paramString));
  }
  
  public final String toString()
  {
    return "clientVersion=" + this.daj + " revision=" + this.dak + " isDebug=" + this.dal + " publishType" + this.dam;
  }
  
  public static final class a
  {
    public final Context context;
    public Long daj;
    public String dak;
    public Long dam;
    public Boolean das;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new RuntimeException("matrix report init, context is null");
      }
      this.context = paramContext;
    }
  }
  
  public static final class b
    extends f
  {
    String dat;
    
    public static b d(f paramf)
    {
      b localb = new b();
      localb.cZZ = paramf.cZZ;
      localb.tag = paramf.tag;
      localb.daa = paramf.daa;
      localb.key = paramf.key;
      localb.type = paramf.type;
      return localb;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean c(f paramf);
  }
  
  public static abstract interface d
  {
    public abstract void a(k.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.k
 * JD-Core Version:    0.7.0.1
 */