package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingDeque;

public final class g
  implements c
{
  private c.a dpu;
  private final a dpv;
  k dpw;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.dpu = null;
    this.dpw = new k();
    this.mLooper = paramLooper;
    this.dpv = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String LP()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.dpw.dpM.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final boolean Xw()
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
    this.dpu = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(216876);
    this.dpv.post(paramRunnable);
    AppMethodBeat.o(216876);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.dpu != null) {
      this.dpu.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final void cS(boolean paramBoolean)
  {
    this.dpw.enable = paramBoolean;
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(216878);
    Log.e("doInnerLoopTask", "should not to be here");
    AppMethodBeat.o(216878);
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
    AppMethodBeat.i(216877);
    Log.e("resumeLoopTasks", "should not to be here");
    AppMethodBeat.o(216877);
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(216875);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(216875);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.dpw.enable) {
          this.dpw.dpM.remove(null);
        }
        AppMethodBeat.o(216875);
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
    this.dpv.post(paramRunnable);
    AppMethodBeat.o(216875);
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
        if (g.this.dpw.enable) {
          g.this.dpw.dpM.pollFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */