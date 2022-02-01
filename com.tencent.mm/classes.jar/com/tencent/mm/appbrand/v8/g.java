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
  private c.a cPg;
  private final a cPh;
  k cPi;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.cPg = null;
    this.cPi = new k();
    this.mLooper = paramLooper;
    this.cPh = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String Br()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.cPi.cPy.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final boolean LJ()
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
    this.cPg = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(193481);
    this.cPh.post(paramRunnable);
    AppMethodBeat.o(193481);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.cPg != null) {
      this.cPg.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final void cg(boolean paramBoolean)
  {
    this.cPi.enable = paramBoolean;
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
  
  public final void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(193480);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(193480);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.cPi.enable) {
          this.cPi.cPy.remove(null);
        }
        AppMethodBeat.o(193480);
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
    this.cPh.post(paramRunnable);
    AppMethodBeat.o(193480);
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
        if (g.this.cPi.enable) {
          g.this.cPi.cPy.pollFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */