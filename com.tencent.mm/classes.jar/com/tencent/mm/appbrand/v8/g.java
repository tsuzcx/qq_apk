package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.BlockingDeque;

public final class g
  implements c
{
  private c.a cXR;
  private final a cXS;
  k cXT;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.cXR = null;
    this.cXT = new k();
    this.mLooper = paramLooper;
    this.cXS = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String Cu()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.cXT.cYj.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final boolean Np()
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
    this.cXR = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(198679);
    this.cXS.post(paramRunnable);
    AppMethodBeat.o(198679);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.cXR != null) {
      this.cXR.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final void cj(boolean paramBoolean)
  {
    this.cXT.enable = paramBoolean;
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
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(198678);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(198678);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.cXT.enable) {
          this.cXT.cYj.remove(null);
        }
        AppMethodBeat.o(198678);
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
    this.cXS.post(paramRunnable);
    AppMethodBeat.o(198678);
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
        if (g.this.cXT.enable) {
          g.this.cXT.cYj.pollFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */