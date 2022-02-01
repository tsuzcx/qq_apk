package com.tencent.matrix.trace.tracer;

import android.os.Handler;
import com.tencent.matrix.trace.b.a.a;
import org.json.JSONObject;

public class TouchEventLagTracer
  extends g
{
  private static com.tencent.matrix.trace.a.b fdo;
  private static long fgZ = 0L;
  private static String fha;
  
  static
  {
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("trace-canary");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/matrix/trace/tracer/TouchEventLagTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/matrix/trace/tracer/TouchEventLagTracer", "<clinit>", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
  }
  
  public TouchEventLagTracer(com.tencent.matrix.trace.a.b paramb)
  {
    fdo = paramb;
  }
  
  public static native void nativeInitTouchEventLagDetective(int paramInt);
  
  private static void onTouchEventLag(int paramInt)
  {
    com.tencent.matrix.e.c.e("Matrix.TouchEventLagTracer", "onTouchEventLag, fd = ".concat(String.valueOf(paramInt)), new Object[0]);
    com.tencent.matrix.e.b.aAp().post(new Runnable()
    {
      public final void run()
      {
        try
        {
          if (System.currentTimeMillis() - TouchEventLagTracer.fgZ < 4000L) {
            return;
          }
          com.tencent.matrix.e.c.i("Matrix.TouchEventLagTracer", "onTouchEventLag report", new Object[0]);
          TouchEventLagTracer.dL(System.currentTimeMillis());
          com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          if (localb != null)
          {
            Object localObject2 = TouchEventLagTracer.fha;
            boolean bool = com.tencent.matrix.trace.f.a.aAc();
            String str = com.tencent.matrix.a.eLw.eLy;
            JSONObject localJSONObject = com.tencent.matrix.e.a.a(new JSONObject(), com.tencent.matrix.c.avW().application);
            localJSONObject.put("detail", a.a.fec);
            localJSONObject.put("scene", str);
            localJSONObject.put("threadStack", localObject2);
            localJSONObject.put("isProcessForeground", bool);
            localObject2 = new com.tencent.matrix.report.g();
            ((com.tencent.matrix.report.g)localObject2).tag = "Trace_EvilMethod";
            ((com.tencent.matrix.report.g)localObject2).eYz = localJSONObject;
            localb.onDetectIssue((com.tencent.matrix.report.g)localObject2);
            return;
          }
        }
        finally
        {
          com.tencent.matrix.e.c.e("Matrix.TouchEventLagTracer", "Matrix error, error = " + localObject1.getMessage(), new Object[0]);
        }
      }
    });
  }
  
  private static void onTouchEventLagDumpTrace(int paramInt)
  {
    com.tencent.matrix.e.c.e("Matrix.TouchEventLagTracer", "onTouchEventLagDumpTrace, fd = ".concat(String.valueOf(paramInt)), new Object[0]);
    fha = com.tencent.matrix.trace.f.c.aAf();
  }
  
  public final void onAlive()
  {
    try
    {
      super.onAlive();
      if (fdo.fdJ) {
        nativeInitTouchEventLagDetective(fdo.fdI);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void onDead()
  {
    super.onDead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.tracer.TouchEventLagTracer
 * JD-Core Version:    0.7.0.1
 */