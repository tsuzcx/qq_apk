package com.tencent.matrix.trace.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.g.c;
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
  final com.tencent.matrix.trace.a.a bQN;
  private Handler bRP;
  private volatile a bRQ;
  private boolean bRR;
  
  public a(com.tencent.matrix.trace.a.a parama)
  {
    this.bQN = parama;
    this.bRR = parama.bQW;
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, boolean paramBoolean)
  {
    super.a(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramBoolean);
    if (this.bQN.bQX) {
      c.v("Matrix.AnrTracer", "[dispatchEnd] token:%s cost:%sms cpu:%sms usage:%s", new Object[] { Long.valueOf(paramLong5), Long.valueOf(paramLong3 - paramLong1), Long.valueOf(paramLong4 - paramLong2), com.tencent.matrix.trace.g.b.r(paramLong4 - paramLong2, paramLong3 - paramLong1) });
    }
    if (this.bRQ != null)
    {
      this.bRQ.bRS.release();
      this.bRP.removeCallbacks(this.bRQ);
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.bQN.bQX) {
      c.v("Matrix.AnrTracer", "--> [doFrame] activityName:%s frameCost:%sms [%s:%s:%s]ns", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4) });
    }
  }
  
  public final void c(long paramLong1, long paramLong2, long paramLong3)
  {
    super.c(paramLong1, paramLong2, paramLong3);
    this.bRQ = new a(AppMethodBeat.getInstance().maskIndex("AnrTracer#dispatchBegin"), paramLong3);
    if (this.bQN.bQX) {
      c.v("Matrix.AnrTracer", "* [dispatchBegin] token:%s index:%s", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(this.bRQ.bRS.index) });
    }
    this.bRP.postDelayed(this.bRQ, 5000L - (SystemClock.uptimeMillis() - paramLong3));
  }
  
  public final void zy()
  {
    super.zy();
    if (this.bRR)
    {
      com.tencent.matrix.trace.core.b.zt().a(this);
      this.bRP = new Handler(com.tencent.matrix.g.b.cD("Matrix#AnrTracer").getLooper());
    }
  }
  
  public final void zz()
  {
    super.zz();
    if (this.bRR)
    {
      com.tencent.matrix.trace.core.b.zt().b(this);
      if (this.bRQ != null) {
        this.bRQ.bRS.release();
      }
      this.bRP.removeCallbacksAndMessages(null);
      this.bRP.getLooper().quit();
    }
  }
  
  final class a
    implements Runnable
  {
    AppMethodBeat.a bRS;
    long bRq;
    
    a(AppMethodBeat.a parama, long paramLong)
    {
      this.bRS = parama;
      this.bRq = paramLong;
    }
    
    public final void run()
    {
      long l1 = SystemClock.uptimeMillis();
      boolean bool = com.tencent.matrix.a.bLP.bLR;
      Object localObject2 = com.tencent.matrix.trace.g.b.fS(Process.myPid());
      Object localObject5 = AppMethodBeat.getInstance().copyData(this.bRS);
      this.bRS.release();
      String str = AppMethodBeat.getVisibleScene();
      Object localObject1 = new long[3];
      localObject1[0] = com.tencent.matrix.g.a.getDalvikHeap();
      localObject1[1] = com.tencent.matrix.g.a.getNativeHeap();
      localObject1[2] = com.tencent.matrix.g.a.zG();
      Object localObject3 = Looper.getMainLooper().getThread().getState();
      StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
      Object localObject4 = com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement, "|*\t\t", 12);
      Object localObject6 = com.tencent.matrix.trace.core.b.zt();
      long l2 = ((com.tencent.matrix.trace.core.b)localObject6).r(0, this.bRq);
      long l3 = ((com.tencent.matrix.trace.core.b)localObject6).r(1, this.bRq);
      long l4 = ((com.tencent.matrix.trace.core.b)localObject6).r(2, this.bRq);
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
          
          public final void e(List<com.tencent.matrix.trace.d.a> paramAnonymousList, int paramAnonymousInt)
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
      ((StringBuilder)localObject7).append("|* [ProcessStat]\n");
      ((StringBuilder)localObject7).append("|*\t\tPriority: ").append(localObject2[0]).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tNice: ").append(localObject2[1]).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tForeground: ").append(bool).append("\n");
      ((StringBuilder)localObject7).append("|* [Memory]\n");
      ((StringBuilder)localObject7).append("|*\t\tDalvikHeap: ").append(localObject1[0]).append("kb\n");
      ((StringBuilder)localObject7).append("|*\t\tNativeHeap: ").append(localObject1[1]).append("kb\n");
      ((StringBuilder)localObject7).append("|*\t\tVmSize: ").append(localObject1[2]).append("kb\n");
      ((StringBuilder)localObject7).append("|* [doFrame]\n");
      ((StringBuilder)localObject7).append("|*\t\tinputCost: ").append(l2).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tanimationCost: ").append(l3).append("\n");
      ((StringBuilder)localObject7).append("|*\t\ttraversalCost: ").append(l4).append("\n");
      ((StringBuilder)localObject7).append("|* [Thread]\n");
      ((StringBuilder)localObject7).append("|*\t\tState: ").append(localObject3).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tStack: ").append((String)localObject4);
      ((StringBuilder)localObject7).append("|* [Trace]\n");
      ((StringBuilder)localObject7).append("|*\t\tStackSize: ").append(l6).append("\n");
      ((StringBuilder)localObject7).append("|*\t\tStackKey: ").append((String)localObject6).append("\n");
      if (a.this.bQN.isDebug) {
        ((StringBuilder)localObject7).append(localStringBuilder.toString());
      }
      ((StringBuilder)localObject7).append("=========================================================================");
      c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.bRq), Long.valueOf(l1) });
      if ((l5 >= 5500L) || (localObject2[0] > 10)) {
        c.w("Matrix.AnrTracer", "The checked anr task was not executed on time. The possible reason is that the current process has a low priority. just pass this report", new Object[0]);
      }
      for (;;)
      {
        return;
        try
        {
          localObject3 = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.yD().application);
            ((JSONObject)localObject4).put("detail", com.tencent.matrix.trace.b.a.a.bRc);
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
            localObject1 = new com.tencent.matrix.e.b();
            ((com.tencent.matrix.e.b)localObject1).key = this.bRq;
            ((com.tencent.matrix.e.b)localObject1).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.e.b)localObject1).bOx = ((JSONObject)localObject4);
            ((com.tencent.matrix.trace.b)localObject3).onDetectIssue((com.tencent.matrix.e.b)localObject1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a
 * JD-Core Version:    0.7.0.1
 */