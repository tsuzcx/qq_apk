package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.e.c;
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
  private final com.tencent.matrix.trace.a.b deE;
  private Handler dga;
  private Handler dgb;
  private volatile a dgc = new a();
  private volatile b dgd = new b();
  private boolean dge;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.deE = paramb;
    this.dge = paramb.deQ;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.deE.deR)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.q(paramLong4 - paramLong2, paramLong1) });
    }
    if (this.dgc != null)
    {
      this.dgc.dgf.release();
      this.dga.removeCallbacks(this.dgc);
    }
    if (this.dgd != null) {
      this.dgb.removeCallbacks(this.dgd);
    }
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.dgc.dgf = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
    this.dgc.dfo = paramLong3;
    if (this.deE.deR) {
      c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.dgc.dgf.index) });
    }
    paramLong1 = (System.nanoTime() - paramLong3) / 1000000L;
    this.dga.postDelayed(this.dgc, 5000L - paramLong1);
    this.dgb.postDelayed(this.dgd, 2000L - paramLong1);
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.dge)
    {
      com.tencent.matrix.trace.core.b.Ya().a(this);
      this.dga = new Handler(com.tencent.matrix.e.b.Yu().getLooper());
      this.dgb = new Handler(com.tencent.matrix.e.b.Yu().getLooper());
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.dge)
    {
      com.tencent.matrix.trace.core.b.Ya().b(this);
      if (this.dgc != null) {
        this.dgc.dgf.release();
      }
      this.dga.removeCallbacksAndMessages(null);
      this.dgb.removeCallbacksAndMessages(null);
    }
  }
  
  final class a
    implements Runnable
  {
    long dfo;
    AppMethodBeat.a dgf;
    
    a() {}
    
    public final void run()
    {
      long l1 = SystemClock.uptimeMillis();
      boolean bool = com.tencent.matrix.a.cQs.cQt;
      Object localObject2 = com.tencent.matrix.trace.g.b.jJ(Process.myPid());
      Object localObject5 = AppMethodBeat.getInstance().copyData(this.dgf);
      this.dgf.release();
      String str = AppMethodBeat.getVisibleScene();
      Object localObject1 = new long[3];
      localObject1[0] = com.tencent.matrix.e.a.getDalvikHeap();
      localObject1[1] = com.tencent.matrix.e.a.getNativeHeap();
      localObject1[2] = com.tencent.matrix.e.a.Yr();
      Object localObject3 = Looper.getMainLooper().getThread().getState();
      StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
      Object localObject4 = com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement, "|*\t\t", 12);
      Object localObject6 = com.tencent.matrix.trace.core.b.Ya();
      long l2 = ((com.tencent.matrix.trace.core.b)localObject6).t(0, this.dfo);
      long l3 = ((com.tencent.matrix.trace.core.b)localObject6).t(1, this.dfo);
      long l4 = ((com.tencent.matrix.trace.core.b)localObject6).t(2, this.dfo);
      Object localObject7 = new LinkedList();
      if (localObject5.length > 0)
      {
        com.tencent.matrix.trace.g.a.a((long[])localObject5, (LinkedList)localObject7, true, l1);
        com.tencent.matrix.trace.g.a.a((List)localObject7, new com.tencent.matrix.trace.g.a.a()
        {
          public final boolean c(long paramAnonymousLong, int paramAnonymousInt)
          {
            return paramAnonymousLong < paramAnonymousInt * 5;
          }
          
          public final void d(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
          {
            c.w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
      localObject6 = com.tencent.matrix.trace.g.a.a((List)localObject7, l5);
      long l6 = ((LinkedList)localObject7).size();
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l5) }));
      ((StringBuilder)localObject7).append("|* [Status]\n");
      ((StringBuilder)localObject7).append("|*\t\tScene: ").append(str).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tPriority: ").append(localObject2[0]).append("\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.e.a.is64BitRuntime()).append("\n");
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
        c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.dfo / 1000000L), Long.valueOf(l1) });
        if (l5 < 6000L) {
          break label661;
        }
        c.w("Matrix.AnrTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
      }
      for (;;)
      {
        return;
        ((StringBuilder)localObject7).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
        break;
        try
        {
          label661:
          localObject3 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.b.Vu().application);
            ((JSONObject)localObject4).put("detail", com.tencent.matrix.trace.b.a.a.deX);
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
            localObject1 = new com.tencent.matrix.report.f();
            ((com.tencent.matrix.report.f)localObject1).key = this.dfo;
            ((com.tencent.matrix.report.f)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.f)localObject1).cZZ = ((JSONObject)localObject4);
            ((com.tencent.matrix.trace.b)localObject3).onDetectIssue((com.tencent.matrix.report.f)localObject1);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
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
      boolean bool = com.tencent.matrix.a.cQs.cQt;
      try
      {
        com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
        if (localb == null) {
          return;
        }
        StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.b.Vu().application);
        localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.deZ);
        localJSONObject.put("scene", localObject);
        localJSONObject.put("threadStack", com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement));
        localJSONObject.put("isProcessForeground", bool);
        localObject = new com.tencent.matrix.report.f();
        ((com.tencent.matrix.report.f)localObject).tag = "Trace_EvilMethod";
        ((com.tencent.matrix.report.f)localObject).cZZ = localJSONObject;
        localb.onDetectIssue((com.tencent.matrix.report.f)localObject);
        c.e("Matrix.AnrTracer", "happens lag : %s ", new Object[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */