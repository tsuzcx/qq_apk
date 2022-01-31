package com.tencent.mm.d.a;

import android.os.Looper;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  implements d
{
  private d.a cbn;
  private final h.a cbo;
  private final Looper mLooper;
  
  h(Looper paramLooper)
  {
    AppMethodBeat.i(113805);
    this.cbn = null;
    this.mLooper = paramLooper;
    this.cbo = new h.a(this, paramLooper);
    AppMethodBeat.o(113805);
  }
  
  public final boolean Cl()
  {
    AppMethodBeat.i(113807);
    if (this.mLooper.getThread().getId() == Thread.currentThread().getId())
    {
      AppMethodBeat.o(113807);
      return true;
    }
    AppMethodBeat.o(113807);
    return false;
  }
  
  public final void a(d.a parama)
  {
    this.cbn = parama;
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(113811);
    if (this.cbn != null) {
      this.cbn.b(paramV8ScriptException);
    }
    AppMethodBeat.o(113811);
  }
  
  public final void g(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(113809);
    this.cbo.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(113809);
  }
  
  public final void loop()
  {
    AppMethodBeat.i(113806);
    Looper.loop();
    AppMethodBeat.o(113806);
  }
  
  public final void m(Runnable paramRunnable)
  {
    AppMethodBeat.i(113808);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(113808);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        AppMethodBeat.o(113808);
        return;
      }
      catch (V8ScriptException paramRunnable)
      {
        c(paramRunnable);
        AppMethodBeat.o(113808);
        return;
      }
    }
    this.cbo.post(paramRunnable);
    AppMethodBeat.o(113808);
  }
  
  public final void pause() {}
  
  public final void quit()
  {
    AppMethodBeat.i(113810);
    this.mLooper.quitSafely();
    AppMethodBeat.o(113810);
  }
  
  public final void resume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.h
 * JD-Core Version:    0.7.0.1
 */