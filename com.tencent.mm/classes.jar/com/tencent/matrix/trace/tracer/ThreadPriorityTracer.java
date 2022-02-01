package com.tencent.matrix.trace.tracer;

import com.tencent.matrix.trace.b;
import com.tencent.matrix.trace.b.a.a;
import org.json.JSONObject;

public class ThreadPriorityTracer
  extends g
{
  public static a fgY;
  
  static
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("trace-canary");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/trace/tracer/ThreadPriorityTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/trace/tracer/ThreadPriorityTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  private static native void nativeInitMainThreadPriorityDetective();
  
  private static void onMainThreadPriorityModified(int paramInt1, int paramInt2)
  {
    if (fgY != null) {
      fgY.onMainThreadPriorityModified(paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      try
      {
        b localb = (b)com.tencent.matrix.c.avW().ai(b.class);
        if (localb != null)
        {
          Object localObject2 = com.tencent.matrix.trace.f.c.aAf();
          JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
          localJSONObject.put("detail", a.a.fed);
          localJSONObject.put("threadStack", localObject2);
          localJSONObject.put("processPriority", paramInt2);
          localObject2 = new com.tencent.matrix.report.g();
          ((com.tencent.matrix.report.g)localObject2).tag = "Trace_EvilMethod";
          ((com.tencent.matrix.report.g)localObject2).eYz = localJSONObject;
          localb.onDetectIssue((com.tencent.matrix.report.g)localObject2);
          return;
        }
      }
      finally
      {
        com.tencent.matrix.e.c.e("ThreadPriorityTracer", "onMainThreadPriorityModified error: %s", new Object[] { localObject1.getMessage() });
      }
    }
  }
  
  private static void onMainThreadTimerSlackModified(long paramLong)
  {
    try
    {
      if (fgY != null) {
        return;
      }
      b localb = (b)com.tencent.matrix.c.avW().ai(b.class);
      if (localb != null)
      {
        Object localObject2 = com.tencent.matrix.trace.f.c.aAf();
        JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
        localJSONObject.put("detail", a.a.fef);
        localJSONObject.put("threadStack", localObject2);
        localJSONObject.put("processTimerSlack", paramLong);
        localObject2 = new com.tencent.matrix.report.g();
        ((com.tencent.matrix.report.g)localObject2).tag = "Trace_EvilMethod";
        ((com.tencent.matrix.report.g)localObject2).eYz = localJSONObject;
        localb.onDetectIssue((com.tencent.matrix.report.g)localObject2);
        return;
      }
    }
    finally
    {
      com.tencent.matrix.e.c.e("ThreadPriorityTracer", "onMainThreadPriorityModified error: %s", new Object[] { localObject1.getMessage() });
    }
  }
  
  protected final void onAlive()
  {
    super.onAlive();
    nativeInitMainThreadPriorityDetective();
  }
  
  protected final void onDead()
  {
    super.onDead();
  }
  
  public static abstract interface a
  {
    public abstract void onMainThreadPriorityModified(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.ThreadPriorityTracer
 * JD-Core Version:    0.7.0.1
 */