package com.tencent.matrix.trace.f;

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

final class a$a
  implements Runnable
{
  AppMethodBeat.a cCP;
  long cCa;
  
  a$a(a parama, AppMethodBeat.a parama1, long paramLong)
  {
    this.cCP = parama1;
    this.cCa = paramLong;
  }
  
  public final void run()
  {
    long l1 = SystemClock.uptimeMillis();
    boolean bool = com.tencent.matrix.a.csS.csU;
    Object localObject2 = com.tencent.matrix.trace.g.b.ho(Process.myPid());
    Object localObject5 = AppMethodBeat.getInstance().copyData(this.cCP);
    this.cCP.release();
    String str = AppMethodBeat.getVisibleScene();
    Object localObject1 = new long[3];
    localObject1[0] = com.tencent.matrix.g.a.getDalvikHeap();
    localObject1[1] = com.tencent.matrix.g.a.getNativeHeap();
    localObject1[2] = com.tencent.matrix.g.a.In();
    Object localObject3 = Looper.getMainLooper().getThread().getState();
    StackTraceElement[] arrayOfStackTraceElement = Looper.getMainLooper().getThread().getStackTrace();
    Object localObject4 = com.tencent.matrix.trace.g.b.a(arrayOfStackTraceElement, "|*\t\t", 12);
    Object localObject6 = com.tencent.matrix.trace.core.b.HU();
    long l2 = ((com.tencent.matrix.trace.core.b)localObject6).t(0, this.cCa);
    long l3 = ((com.tencent.matrix.trace.core.b)localObject6).t(1, this.cCa);
    long l4 = ((com.tencent.matrix.trace.core.b)localObject6).t(2, this.cCa);
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
      com.tencent.matrix.g.c.w("Matrix.AnrTracer", "%s \npostTime:%s curTime:%s", new Object[] { ((StringBuilder)localObject7).toString(), Long.valueOf(this.cCa / 1000000L), Long.valueOf(l1) });
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
        localObject3 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class);
        if (localObject3 != null)
        {
          localObject4 = com.tencent.matrix.g.a.a(new JSONObject(), com.tencent.matrix.b.GF().application);
          ((JSONObject)localObject4).put("detail", com.tencent.matrix.trace.b.a.a.cBJ);
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
          ((com.tencent.matrix.report.c)localObject1).key = this.cCa;
          ((com.tencent.matrix.report.c)localObject1).tag = "Trace_EvilMethod";
          ((com.tencent.matrix.report.c)localObject1).cwV = ((JSONObject)localObject4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.f.a.a
 * JD-Core Version:    0.7.0.1
 */