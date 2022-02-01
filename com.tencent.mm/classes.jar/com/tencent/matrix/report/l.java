package com.tencent.matrix.report;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.matrix.d.a;
import com.tencent.matrix.e.c;
import com.tencent.matrix.f;
import com.tencent.matrix.mrs.core.MatrixUploadIssue;
import com.tencent.matrix.mrs.core.MrsLogic;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class l
  extends a
{
  private final Context context;
  private Long eYJ;
  private String eYK;
  private volatile boolean eYL;
  private Long eYM;
  private j eYN = new j();
  private final ConcurrentHashMap<com.tencent.matrix.d.b, d> eYO = new ConcurrentHashMap();
  public c eYP;
  private final ConcurrentLinkedQueue<b> eYQ = new ConcurrentLinkedQueue();
  public final ConcurrentLinkedDeque<b> eYR = new ConcurrentLinkedDeque();
  public volatile boolean isInit = false;
  
  public l(Context paramContext, Long paramLong1, String paramString, Boolean paramBoolean, Long paramLong2)
  {
    super(paramContext);
    this.context = paramContext;
    this.eYJ = paramLong1;
    this.eYK = paramString;
    this.eYL = paramBoolean.booleanValue();
    this.eYM = paramLong2;
    if (MMApplicationContext.isMainProcess()) {
      try
      {
        MrsLogic.init(paramLong1.longValue(), paramString, paramBoolean.booleanValue(), paramLong2.longValue());
        return;
      }
      finally
      {
        c.printErrStackTrace("MicroMsg.MatrixReporter", paramContext, "", new Object[0]);
        MrsLogic.init(paramLong1.longValue(), paramString, paramBoolean.booleanValue(), paramLong2.longValue());
        return;
      }
    }
    paramLong1 = new IntentFilter();
    paramLong1.addAction("strategyNotify");
    paramLong1.addAction("statusNotify");
    f.addAction(paramLong1);
    paramString = new MatrixStrategyNotifyBroadcast();
    try
    {
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.fdj, null);
      return;
    }
    finally
    {
      paramContext.unregisterReceiver(paramString);
      paramContext.registerReceiver(paramString, paramLong1, MatrixStrategyNotifyBroadcast.fdj, null);
    }
  }
  
  private static void a(g paramg, u paramu)
  {
    if (paramg != null) {}
    try
    {
      if (!paramu.jKS())
      {
        c.e("MicroMsg.MatrixReporter", "Matrix report, tag %s or file %s is null, just return", new Object[] { paramg, paramu });
        return;
      }
      MatrixUploadIssue localMatrixUploadIssue = new MatrixUploadIssue();
      localMatrixUploadIssue.setTag(paramg.tag);
      localMatrixUploadIssue.setCanSplitSlice(true);
      localMatrixUploadIssue.setDataType(1);
      localMatrixUploadIssue.setNeedDeleteFileAfterSucc(true);
      localMatrixUploadIssue.setType(paramg.type);
      localMatrixUploadIssue.setDesKey(paramg.key);
      localMatrixUploadIssue.setFilePath(ah.v(paramu.jKT()));
      MrsLogic.uploadMatrixIssue(localMatrixUploadIssue);
      return;
    }
    finally
    {
      c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramg)), new Object[0]);
    }
  }
  
  public final void a(com.tencent.matrix.d.b paramb, d paramd)
  {
    this.eYO.put(paramb, paramd);
  }
  
  public final void a(g paramg)
  {
    paramg = b.d(paramg);
    if ((paramg.eYA instanceof com.tencent.matrix.trace.b))
    {
      this.eYR.addFirst(paramg);
      if (this.eYR.size() >= 30) {
        this.eYR.removeLast();
      }
    }
    try
    {
      if ((this.eYP != null) && (this.eYP.c(paramg)))
      {
        Log.w("MicroMsg.MatrixReporter", "[reportJson] pass this report! tag=%s", new Object[] { paramg.tag });
        return;
      }
    }
    catch (Exception paramg)
    {
      Log.printErrStackTrace("MicroMsg.MatrixReporter", paramg, "", new Object[0]);
      return;
    }
    Object localObject = (d)this.eYO.get(paramg.eYA);
    if (localObject != null) {
      ((d)localObject).a(paramg);
    }
    localObject = paramg.eYT;
    try
    {
      if (MMApplicationContext.isMainProcess())
      {
        a(paramg, (String)localObject);
        return;
      }
    }
    finally
    {
      c.e("MicroMsg.MatrixReporter", "Matrix report occur error:".concat(String.valueOf(paramg)), new Object[0]);
      return;
    }
    Intent localIntent = new Intent(this.context, MatrixReportBroadcast.class);
    localIntent.putExtra("tag", paramg.tag);
    localIntent.putExtra("key", paramg.key);
    localIntent.putExtra("type", paramg.type);
    localIntent.putExtra("value", paramg.eYz.toString());
    localIntent.putExtra("filePath", (String)localObject);
    c.i("MicroMsg.MatrixReporter", "Matrix report with broadcast tag:%s", new Object[] { paramg.tag });
    this.context.sendBroadcast(localIntent);
  }
  
  public final void a(g paramg, String paramString)
  {
    if ((!this.isInit) && (MMApplicationContext.isMainProcess()))
    {
      c.w("MicroMsg.MatrixReporter", "MatrixReportBroadcast, matrix report is not init, wait to report plugin:%s", new Object[] { paramg.tag });
      paramg = b.d(paramg);
      paramg.eYT = paramString;
      this.eYQ.add(paramg);
    }
    do
    {
      return;
      if (!this.eYQ.isEmpty())
      {
        Iterator localIterator = this.eYQ.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          c.i("MicroMsg.MatrixReporter", "Matrix report pending list! tag:%s, key:%s, data:%s", new Object[] { localb.tag, localb.eYz, Integer.valueOf(d.Yxh) });
          MrsLogic.collectData(localb.tag, localb.eYz.toString().getBytes());
          if (!TextUtils.isEmpty(paramString)) {
            a(localb, new u(localb.eYT));
          }
        }
        this.eYQ.clear();
      }
      c.i("MicroMsg.MatrixReporter", "Matrix reportLocal tag:%s, key:%s, data:%s", new Object[] { paramg.tag, paramg.eYz, Integer.valueOf(d.Yxh) });
      MrsLogic.collectData(paramg.tag, paramg.eYz.toString().getBytes());
      this.eYN.f(paramg.tag, paramg.eYz);
    } while (TextUtils.isEmpty(paramString));
    a(paramg, new u(paramString));
  }
  
  public final String toString()
  {
    return "clientVersion=" + this.eYJ + " revision=" + this.eYK + " isDebug=" + this.eYL + " publishType" + this.eYM;
  }
  
  public static final class a
  {
    public final Context context;
    public Long eYJ;
    public String eYK;
    public Long eYM;
    public Boolean eYS;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new RuntimeException("matrix report init, context is null");
      }
      this.context = paramContext;
    }
  }
  
  public static final class b
    extends g
  {
    String eYT;
    
    public static b d(g paramg)
    {
      b localb = new b();
      localb.eYz = paramg.eYz;
      localb.tag = paramg.tag;
      localb.eYA = paramg.eYA;
      localb.key = paramg.key;
      localb.type = paramg.type;
      return localb;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean c(g paramg);
  }
  
  public static abstract interface d
  {
    public abstract void a(l.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.l
 * JD-Core Version:    0.7.0.1
 */