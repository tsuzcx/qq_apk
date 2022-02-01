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
  private final com.tencent.matrix.trace.a.b cKe;
  private Handler cLA;
  private Handler cLB;
  private volatile a cLC;
  private volatile b cLD;
  private boolean cLE;
  
  public a(com.tencent.matrix.trace.a.b paramb)
  {
    this.cKe = paramb;
    this.cLE = paramb.cKp;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.cKe.cKq)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      com.tencent.matrix.g.c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.p(paramLong4 - paramLong2, paramLong1) });
    }
    if (this.cLC != null)
    {
      this.cLC.cLF.release();
      this.cLA.removeCallbacks(this.cLC);
    }
    if (this.cLD != null) {
      this.cLB.removeCallbacks(this.cLD);
    }
  }
  
  public final void d(long paramLong1, long paramLong2, long paramLong3)
  {
    super.d(paramLong1, paramLong2, paramLong3);
    this.cLC = new a(AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin"), paramLong3);
    this.cLD = new b();
    if (this.cKe.cKq) {
      com.tencent.matrix.g.c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.cLC.cLF.index) });
    }
    this.cLA.postDelayed(this.cLC, 5000L - (System.nanoTime() - paramLong3) / 1000000L);
    this.cLB.postDelayed(this.cLD, 2000L - (System.nanoTime() - paramLong3) / 1000000L);
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.cLE)
    {
      com.tencent.matrix.trace.core.b.Ji().a(this);
      this.cLA = new Handler(com.tencent.matrix.g.b.JC().getLooper());
      this.cLB = new Handler(com.tencent.matrix.g.b.JC().getLooper());
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.cLE)
    {
      com.tencent.matrix.trace.core.b.Ji().b(this);
      if (this.cLC != null) {
        this.cLC.cLF.release();
      }
      this.cLA.removeCallbacksAndMessages(null);
      this.cLB.removeCallbacksAndMessages(null);
    }
  }
  
  final class a
    implements Runnable
  {
    long cKO;
    AppMethodBeat.a cLF;
    
    a(AppMethodBeat.a parama, long paramLong)
    {
      this.cLF = parama;
      this.cKO = paramLong;
    }
    
    public final void run()
    {
      long l1 = SystemClock.uptimeMillis();
      boolean bool = com.tencent.matrix.a.cBz.cBB;
      Object localObject2 = com.tencent.matrix.trace.g.b.hd(Process.myPid());
      Object localObject5 = AppMethodBeat.getInstance().copyData(this.cLF);
      this.cLF.release();
      String str = AppMethodBeat.getVisibleScene();
      Object localObject1 = new long[3];
      localObject1[0] = com.tencent.matrix.g.a.getDalvikHeap();
      localObject1[1] = com.tencent.matrix.g.a.getNativeHeap();
      localObject1[2] = com.tencent.matrix.g.a.Jz();
      Object localObject3 = Looper.getMainLooper().getThread().getState();
      StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
      Object localObject4 = com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement, "|*\t\t", 12);
      Object localObject6 = com.tencent.matrix.trace.core.b.Ji();
      long l2 = ((com.tencent.matrix.trace.core.b)localObject6).s(0, this.cKO);
      long l3 = ((com.tencent.matrix.trace.core.b)localObject6).s(1, this.cKO);
      long l4 = ((com.tencent.matrix.trace.core.b)localObject6).s(2, this.cKO);
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
      localObject6 = com.tencent.matrix.trace.g.a.a((List)localObject7, l5);
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
        com.tencent.matrix.g.c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.cKO / 1000000L), Long.valueOf(l1) });
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
          localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HT().application);
            ((JSONObject)localObject4).put("detail", com.tencent.matrix.trace.b.a.a.cKw);
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
            ((com.tencent.matrix.report.c)localObject1).key = this.cKO;
            ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.c)localObject1).cFG = ((JSONObject)localObject4);
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
      boolean bool = com.tencent.matrix.a.cBz.cBB;
      try
      {
        com.tencent.matrix.trace.a locala = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
        if (locala == null) {
          return;
        }
        StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject localJSONObject = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.HT().application);
        localJSONObject.put("detail", com.tencent.matrix.trace.b.a.a.cKy);
        localJSONObject.put("scene", localObject);
        localJSONObject.put("threadStack", com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement));
        localJSONObject.put("isProcessForeground", bool);
        localObject = new com.tencent.matrix.report.c();
        ((com.tencent.matrix.report.c)localObject).tag = "Trace_EvilMethod";
        ((com.tencent.matrix.report.c)localObject).cFG = localJSONObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */