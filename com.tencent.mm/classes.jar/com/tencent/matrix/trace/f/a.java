package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends f
{
  private final com.tencent.matrix.trace.a.b daC;
  private Handler dbY;
  private Handler dbZ;
  private volatile a dca = new a();
  private volatile b dcb = new b();
  private boolean dcc;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.daC = paramb;
    this.dcc = paramb.daN;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.daC.daO)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      com.tencent.matrix.g.c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.q(paramLong4 - paramLong2, paramLong1) });
    }
    if (this.dca != null)
    {
      this.dca.dcd.release();
      this.dbY.removeCallbacks(this.dca);
    }
    if (this.dcb != null) {
      this.dbZ.removeCallbacks(this.dcb);
    }
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.dca.dcd = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
    this.dca.dbl = paramLong3;
    if (this.daC.daO) {
      com.tencent.matrix.g.c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.dca.dcd.index) });
    }
    paramLong1 = (System.nanoTime() - paramLong3) / 1000000L;
    this.dbY.postDelayed(this.dca, 5000L - paramLong1);
    this.dbZ.postDelayed(this.dcb, 2000L - paramLong1);
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.dcc)
    {
      com.tencent.matrix.trace.core.b.Tw().a(this);
      this.dbY = new Handler(com.tencent.matrix.g.b.TQ().getLooper());
      this.dbZ = new Handler(com.tencent.matrix.g.b.TQ().getLooper());
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.dcc)
    {
      com.tencent.matrix.trace.core.b.Tw().b(this);
      if (this.dca != null) {
        this.dca.dcd.release();
      }
      this.dbY.removeCallbacksAndMessages(null);
      this.dbZ.removeCallbacksAndMessages(null);
    }
  }
  
  final class a
    implements Runnable
  {
    long dbl;
    AppMethodBeat.a dcd;
    
    public a() {}
    
    public final void run()
    {
      long l1 = SystemClock.uptimeMillis();
      boolean bool = com.tencent.matrix.a.cPA.cPB;
      Object localObject2 = com.tencent.matrix.trace.g.b.ix(Process.myPid());
      Object localObject5 = AppMethodBeat.getInstance().copyData(this.dcd);
      this.dcd.release();
      String str = AppMethodBeat.getVisibleScene();
      Object localObject1 = new long[3];
      localObject1[0] = com.tencent.matrix.g.a.getDalvikHeap();
      localObject1[1] = com.tencent.matrix.g.a.getNativeHeap();
      localObject1[2] = com.tencent.matrix.g.a.TN();
      Object localObject3 = Looper.getMainLooper().getThread().getState();
      StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
      Object localObject4 = com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement, "|*\t\t", 12);
      Object localObject6 = com.tencent.matrix.trace.core.b.Tw();
      long l2 = ((com.tencent.matrix.trace.core.b)localObject6).u(0, this.dbl);
      long l3 = ((com.tencent.matrix.trace.core.b)localObject6).u(1, this.dbl);
      long l4 = ((com.tencent.matrix.trace.core.b)localObject6).u(2, this.dbl);
      Object localObject7 = new LinkedList();
      if (localObject5.length > 0)
      {
        com.tencent.matrix.trace.g.a.a((long[])localObject5, (LinkedList)localObject7, true, l1);
        com.tencent.matrix.trace.g.a.a((List)localObject7, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean b(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            com.tencent.matrix.g.c.w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
            paramAnonymousList = paramAnonymousList.listIterator(Math.min(paramAnonymousInt, 30));
            while (paramAnonymousList.hasNext())
            {
              paramAnonymousList.next();
              paramAnonymousList.remove();
            }
          }
        });
      }
      localObject5 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      long l5 = Math.max(5000L, com.tencent.matrix.trace.g.a.a((LinkedList)localObject7, (StringBuilder)localObject5, localStringBuilder));
      localObject6 = com.tencent.matrix.trace.g.a.b((List)localObject7, l5);
      long l6 = ((LinkedList)localObject7).size();
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l5) }));
      ((StringBuilder)localObject7).append("|* [Status]\n");
      ((StringBuilder)localObject7).append("|*\t\tScene: ").append(str).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tPriority: ").append(localObject2[0]).append("\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.g.a.is64BitRuntime()).append("\n");
      ((StringBuilder)localObject7).append("|* [Memory]\n");
      ((StringBuilder)localObject7).append("|*\t\tDalvikHeap: ").append(localObject1[0]).append("kb\n");
      ((StringBuilder)localObject7).append("|*\t\tNativeHeap: ").append(localObject1[1]).append("kb\n");
      ((StringBuilder)localObject7).append("|*\t\tVmSize: ").append(localObject1[2]).append("kb\n");
      ((StringBuilder)localObject7).append("|* [doFrame]\n");
      ((StringBuilder)localObject7).append("|*\t\tinputCost:animationCost:traversalCost\n");
      ((StringBuilder)localObject7).append("|*\t\t").append(l2).append(":").append(l3).append(":").append(l4).append("\n");
      ((StringBuilder)localObject7).append("|* [Thread]\n");
      ((StringBuilder)localObject7).append(String.format("|*\t\tStack(%s): ", new Object[] { localObject3 })).append((String)localObject4);
      ((StringBuilder)localObject7).append("|* [Trace]\n");
      if (l6 > 0L)
      {
        ((StringBuilder)localObject7).append("|*\t\tStackKey: ").append((String)localObject6).append("\n");
        ((StringBuilder)localObject7).append(localStringBuilder.toString());
        ((StringBuilder)localObject7).append("=========================================================================");
        com.tencent.matrix.g.c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.dbl / 1000000L), Long.valueOf(l1) });
        if (l5 < 6000L) {
          break label661;
        }
        com.tencent.matrix.g.c.w("Matrix.AnrTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
      }
      for (;;)
      {
        return;
        ((StringBuilder)localObject7).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
        break;
        try
        {
          label661:
          localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
            ((JSONObject)localObject4).put("detail", com.tencent.matrix.trace.b.a.a.daU);
            ((JSONObject)localObject4).put("cost", l5);
            ((JSONObject)localObject4).put("stackKey", localObject6);
            ((JSONObject)localObject4).put("scene", str);
            ((JSONObject)localObject4).put("stack", ((StringBuilder)localObject5).toString());
            ((JSONObject)localObject4).put("threadStack", com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement));
            ((JSONObject)localObject4).put("processPriority", localObject2[0]);
            ((JSONObject)localObject4).put("processNice", localObject2[1]);
            ((JSONObject)localObject4).put("isProcessForeground", bool);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("dalvik_heap", localObject1[0]);
            ((JSONObject)localObject2).put("native_heap", localObject1[1]);
            ((JSONObject)localObject2).put("vm_size", localObject1[2]);
            ((JSONObject)localObject4).put("memory", localObject2);
            localObject1 = new com.tencent.matrix.report.c();
            ((com.tencent.matrix.report.c)localObject1).key = this.dbl;
            ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.c)localObject1).cWe = ((JSONObject)localObject4);
            ((com.tencent.matrix.trace.a)localObject3).onDetectIssue((com.tencent.matrix.report.c)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          com.tencent.matrix.g.c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      Object localObject = AppMethodBeat.getVisibleScene();
      boolean bool = com.tencent.matrix.a.cPA.cPB;
      try
      {
        com.tencent.matrix.trace.a locala = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
        if (locala == null) {
          return;
        }
        StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.RG().application);
        localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.daW);
        localJSONObject.put("scene", localObject);
        localJSONObject.put("threadStack", com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement));
        localJSONObject.put("isProcessForeground", bool);
        localObject = new com.tencent.matrix.report.c();
        ((com.tencent.matrix.report.c)localObject).tag = "Trace_EvilMethod";
        ((com.tencent.matrix.report.c)localObject).cWe = localJSONObject;
        locala.onDetectIssue((com.tencent.matrix.report.c)localObject);
        com.tencent.matrix.g.c.e("Matrix.AnrTracer", "happens lag : %s ", new Object[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.matrix.g.c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */