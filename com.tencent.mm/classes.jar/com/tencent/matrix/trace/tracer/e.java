package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.AppMethodBeat.a;
import com.tencent.matrix.trace.f.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends g
{
  final com.tencent.matrix.trace.a.b fdo;
  private Handler fgn;
  private Handler fgo;
  private final a fgp = new a();
  private final b fgq = new b();
  private boolean fgr;
  
  public e(com.tencent.matrix.trace.a.b paramb)
  {
    this.fdo = paramb;
    this.fgr = paramb.fdF;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.fdo.fdK)
    {
      paramLong1 = (paramLong3 - paramLong1) / 1000000L;
      com.tencent.matrix.e.c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.f.c.N(paramLong4 - paramLong2, paramLong1) });
    }
    this.fgp.fgs.release();
    this.fgn.removeCallbacks(this.fgp);
    this.fgo.removeCallbacks(this.fgq);
  }
  
  public final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    super.e(paramLong1, paramLong2, paramLong3);
    this.fgp.fgs = AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin");
    this.fgp.feC = paramLong3;
    if (this.fdo.fdK) {
      com.tencent.matrix.e.c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.fgp.fgs.index) });
    }
    paramLong1 = (System.nanoTime() - paramLong3) / 1000000L;
    this.fgn.postDelayed(this.fgp, 5000L - paramLong1);
    this.fgo.postDelayed(this.fgq, 2000L - paramLong1);
  }
  
  public final void onAlive()
  {
    super.onAlive();
    if (this.fgr)
    {
      com.tencent.matrix.trace.core.b.azL().a(this);
      this.fgn = new Handler(com.tencent.matrix.e.b.aAp().getLooper());
      this.fgo = new Handler(com.tencent.matrix.e.b.aAp().getLooper());
    }
  }
  
  public final void onDead()
  {
    super.onDead();
    if (this.fgr)
    {
      com.tencent.matrix.trace.core.b.azL().b(this);
      this.fgp.fgs.release();
      this.fgn.removeCallbacksAndMessages(null);
      this.fgo.removeCallbacksAndMessages(null);
    }
  }
  
  final class a
    implements Runnable
  {
    long feC;
    AppMethodBeat.a fgs;
    
    a() {}
    
    public final void run()
    {
      long l1 = SystemClock.uptimeMillis();
      boolean bool = com.tencent.matrix.a.eLw.eLx;
      Object localObject3 = com.tencent.matrix.trace.f.c.ny(Process.myPid());
      Object localObject5 = AppMethodBeat.getInstance().copyData(this.fgs);
      this.fgs.release();
      String str = com.tencent.matrix.a.eLw.eLy;
      Object localObject2 = new long[3];
      localObject2[0] = com.tencent.matrix.e.a.getDalvikHeap();
      localObject2[1] = com.tencent.matrix.e.a.getNativeHeap();
      localObject2[2] = com.tencent.matrix.e.a.aAm();
      Object localObject4 = Looper.getMainLooper().getThread().getState();
      StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
      Object localObject1;
      Object localObject6;
      Object localObject7;
      long l5;
      if (e.this.fdo.fdM == 1) {
        if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length < 3))
        {
          localObject1 = "";
          localObject6 = com.tencent.matrix.trace.core.b.azL();
          long l2 = ((com.tencent.matrix.trace.core.b)localObject6).x(0, this.feC);
          long l3 = ((com.tencent.matrix.trace.core.b)localObject6).x(1, this.feC);
          long l4 = ((com.tencent.matrix.trace.core.b)localObject6).x(2, this.feC);
          localObject7 = new LinkedList();
          if (localObject5.length > 0)
          {
            com.tencent.matrix.trace.f.b.a((long[])localObject5, (LinkedList)localObject7, true, l1);
            com.tencent.matrix.trace.f.b.a((List)localObject7, new b.a()
            {
              public final int azV()
              {
                return 60;
              }
              
              public final boolean k(long paramAnonymousLong, int paramAnonymousInt)
              {
                return paramAnonymousLong < paramAnonymousInt * 5;
              }
              
              public final void l(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
              {
                com.tencent.matrix.e.c.w("Matrix.AnrTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(30), paramAnonymousList });
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
          l5 = Math.max(5000L, com.tencent.matrix.trace.f.b.a((LinkedList)localObject7, (StringBuilder)localObject5, localStringBuilder));
          localObject6 = com.tencent.matrix.trace.f.b.b((List)localObject7, l5);
          long l6 = ((LinkedList)localObject7).size();
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(String.format("-\n>>>>>>>>>>>>>>>>>>>>>>> maybe happens ANR(%s ms)! <<<<<<<<<<<<<<<<<<<<<<<\n", new Object[] { Long.valueOf(l5) }));
          ((StringBuilder)localObject7).append("|* [Status]\n");
          ((StringBuilder)localObject7).append("|*\t\tScene: ").append(str).append("\n");
          ((StringBuilder)localObject7).append("|*\t\tForeground: ").append(bool).append("\n");
          ((StringBuilder)localObject7).append("|*\t\tPriority: ").append(localObject3[0]).append("\tNice: ").append(localObject3[1]).append("\n");
          ((StringBuilder)localObject7).append("|*\t\tis64BitRuntime: ").append(com.tencent.matrix.e.a.awm()).append("\n");
          ((StringBuilder)localObject7).append("|* [Memory]\n");
          ((StringBuilder)localObject7).append("|*\t\tDalvikHeap: ").append(localObject2[0]).append("kb\n");
          ((StringBuilder)localObject7).append("|*\t\tNativeHeap: ").append(localObject2[1]).append("kb\n");
          ((StringBuilder)localObject7).append("|*\t\tVmSize: ").append(localObject2[2]).append("kb\n");
          ((StringBuilder)localObject7).append("|* [doFrame]\n");
          ((StringBuilder)localObject7).append("|*\t\tinputCost:animationCost:traversalCost\n");
          ((StringBuilder)localObject7).append("|*\t\t").append(l2).append(":").append(l3).append(":").append(l4).append("\n");
          ((StringBuilder)localObject7).append("|* [Thread]\n");
          ((StringBuilder)localObject7).append(String.format("|*\t\tStack(%s): ", new Object[] { localObject4 })).append((String)localObject1);
          ((StringBuilder)localObject7).append("|* [Trace]\n");
          if (l6 <= 0L) {
            break label797;
          }
          ((StringBuilder)localObject7).append("|*\t\tStackKey: ").append((String)localObject6).append("\n");
          ((StringBuilder)localObject7).append(localStringBuilder.toString());
        }
      }
      for (;;)
      {
        ((StringBuilder)localObject7).append("=========================================================================");
        com.tencent.matrix.e.c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.feC / 1000000L), Long.valueOf(l1) });
        if (l5 < 6000L) {
          break label833;
        }
        com.tencent.matrix.e.c.w("Matrix.AnrTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
        return;
        localObject1 = new StringBuilder(" \n");
        int i = 0;
        while (i < arrayOfStackTraceElement.length)
        {
          ((StringBuilder)localObject1).append("|*\t\t");
          ((StringBuilder)localObject1).append("at ");
          ((StringBuilder)localObject1).append(arrayOfStackTraceElement[i].getClassName());
          ((StringBuilder)localObject1).append(":");
          ((StringBuilder)localObject1).append(arrayOfStackTraceElement[i].getMethodName());
          ((StringBuilder)localObject1).append("(" + arrayOfStackTraceElement[i].getLineNumber() + ")");
          ((StringBuilder)localObject1).append("\n");
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        break;
        localObject1 = com.tencent.matrix.trace.f.c.a(arrayOfStackTraceElement, "|*\t\t", 12);
        break;
        label797:
        ((StringBuilder)localObject7).append(String.format("AppMethodBeat is close[%s].", new Object[] { Boolean.valueOf(AppMethodBeat.getInstance().isAlive()) })).append("\n");
      }
      for (;;)
      {
        try
        {
          label833:
          localObject1 = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          if (localObject1 == null) {
            break;
          }
          localObject4 = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
          ((JSONObject)localObject4).put("detail", a.a.fdW);
          ((JSONObject)localObject4).put("cost", l5);
          ((JSONObject)localObject4).put("stackKey", localObject6);
          ((JSONObject)localObject4).put("scene", str);
          ((JSONObject)localObject4).put("stack", ((StringBuilder)localObject5).toString());
          if (e.this.fdo.fdM == 1)
          {
            ((JSONObject)localObject4).put("threadStack", com.tencent.matrix.trace.f.c.b(arrayOfStackTraceElement));
            ((JSONObject)localObject4).put("processPriority", localObject3[0]);
            ((JSONObject)localObject4).put("processNice", localObject3[1]);
            ((JSONObject)localObject4).put("isProcessForeground", bool);
            localObject3 = new JSONObject();
            ((JSONObject)localObject3).put("dalvik_heap", localObject2[0]);
            ((JSONObject)localObject3).put("native_heap", localObject2[1]);
            ((JSONObject)localObject3).put("vm_size", localObject2[2]);
            ((JSONObject)localObject4).put("memory", localObject3);
            localObject2 = new com.tencent.matrix.report.g();
            ((com.tencent.matrix.report.g)localObject2).key = this.feC;
            ((com.tencent.matrix.report.g)localObject2).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.g)localObject2).eYz = ((JSONObject)localObject4);
            ((com.tencent.matrix.trace.b)localObject1).onDetectIssue((com.tencent.matrix.report.g)localObject2);
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          com.tencent.matrix.e.c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
          return;
        }
        ((JSONObject)localObject4).put("threadStack", com.tencent.matrix.trace.f.c.a(arrayOfStackTraceElement));
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      String str1 = com.tencent.matrix.a.eLw.eLy;
      boolean bool = com.tencent.matrix.a.eLw.eLx;
      try
      {
        com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
        if (localb == null) {
          return;
        }
        String str2 = com.tencent.matrix.trace.f.c.b(Looper.getMainLooper().getThread().getStackTrace());
        JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
        localJSONObject.put("detail", a.a.fdY);
        localJSONObject.put("scene", str1);
        localJSONObject.put("threadStack", str2);
        localJSONObject.put("isProcessForeground", bool);
        com.tencent.matrix.report.g localg = new com.tencent.matrix.report.g();
        localg.tag = "Trace_EvilMethod";
        localg.eYz = localJSONObject;
        localb.onDetectIssue(localg);
        com.tencent.matrix.e.c.e("Matrix.AnrTracer", "happens lag : %s, scene : %s ", new Object[] { str2, str1 });
        return;
      }
      catch (JSONException localJSONException)
      {
        com.tencent.matrix.e.c.e("Matrix.AnrTracer", "[JSONException error: %s", new Object[] { localJSONException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.e
 * JD-Core Version:    0.7.0.1
 */