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
  private c.a cMB;
  private final a cMC;
  k cMD;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.cMB = null;
    this.cMD = new k();
    this.mLooper = paramLooper;
    this.cMC = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String AV()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.cMD.cMT.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final boolean LH()
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
    this.cMB = parama;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200807);
    this.cMC.post(paramRunnable);
    AppMethodBeat.o(200807);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.cMB != null) {
      this.cMB.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final void ci(boolean paramBoolean)
  {
    this.cMD.enable = paramBoolean;
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
    AppMethodBeat.i(200806);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(200806);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.cMD.enable) {
          this.cMD.cMT.remove(null);
        }
        AppMethodBeat.o(200806);
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
    this.cMC.post(paramRunnable);
    AppMethodBeat.o(200806);
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
        if (g.this.cMD.enable) {
          g.this.cMD.cMT.pollFirst();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.g
 * JD-Core Version:    0.7.0.1
 */