package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.BlockingDeque;

public final class g
  implements c
{
  private c.a cYP;
  private final a cYQ;
  k cYR;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.cYP = null;
    this.cYR = new k();
    this.mLooper = paramLooper;
    this.cYQ = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String Cx()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.cYR.cZh.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final boolean Nk()
  {
    AppMethodBeat.i(144004);
    if (this.mLooper.getThread().getId() == Thread.currentThread().getId())
    {
      AppMethodBeat.o(144004);
      return true;
    }
    AppMethodBeat.o(144004);
    return false;
  }
  
  public final void a(c.a parama)
  {
    this.cYP = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(194156);
    this.cYQ.post(paramRunnable);
    AppMethodBeat.o(194156);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.cYP != null) {
      this.cYP.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final void c(Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(194155);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(194155);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.cYR.enable) {
          this.cYR.cZh.remove(null);
        }
        AppMethodBeat.o(194155);
        return;
      }
      catch (V8ScriptException paramRunnable)
      {
        for (;;)
        {
          c(paramRunnable);
        }
      }
    }
    this.cYQ.post(paramRunnable);
    AppMethodBeat.o(194155);
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cYR.enable = paramBoolean;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(194158);
    ae.e("doInnerLoopTask", "should not to be here");
    AppMethodBeat.o(194158);
    return true;
  }
  
  public final void loop()
  {
    AppMethodBeat.i(144003);
    Looper.loop();
    AppMethodBeat.o(144003);
  }
  
  public final void pause() {}
  
  public final void quit()
  {
    AppMethodBeat.i(144007);
    this.mLooper.quitSafely();
    AppMethodBeat.o(144007);
  }
  
  public final void resume() {}
  
  public final void resumeLoopTasks()
  {
    AppMethodBeat.i(194157);
    ae.e("resumeLoopTasks", "should not to be here");
    AppMethodBeat.o(194157);
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void dispatchMessage(Message paramMessage)
    {
      AppMethodBeat.i(144001);
      try
      {
        super.dispatchMessage(paramMessage);
        if (g.this.cYR.enable) {
          g.this.cYR.cZh.pollFirst();
        }
        AppMethodBeat.o(144001);
        return;
      }
      catch (V8ScriptException paramMessage)
      {
        for (;;)
        {
          g.this.c(paramMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */