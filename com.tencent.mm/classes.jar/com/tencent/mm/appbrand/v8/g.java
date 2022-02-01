package com.tencent.mm.appbrand.v8;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.eclipsesource.mmv8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingDeque;

public final class g
  implements c
{
  private c.a hmo;
  private final a hmp;
  k hmq;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.hmo = null;
    this.hmq = new k();
    this.mLooper = paramLooper;
    this.hmp = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final void a(c.a parama)
  {
    this.hmo = parama;
  }
  
  public final boolean aDX()
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
  
  public final void aEa()
  {
    AppMethodBeat.i(144003);
    Looper.loop();
    AppMethodBeat.o(144003);
  }
  
  public final String aoO()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.hmq.hmG.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(238669);
    this.hmp.post(paramRunnable);
    AppMethodBeat.o(238669);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.hmo != null) {
      this.hmo.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(238693);
    Log.e("doInnerLoopTask", "should not to be here");
    AppMethodBeat.o(238693);
    return true;
  }
  
  public final void eb(boolean paramBoolean)
  {
    this.hmq.enable = paramBoolean;
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
    AppMethodBeat.i(238688);
    Log.e("resumeLoopTasks", "should not to be here");
    AppMethodBeat.o(238688);
  }
  
  public final void x(Runnable paramRunnable)
  {
    AppMethodBeat.i(238665);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(238665);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.hmq.enable) {
          this.hmq.hmG.remove(null);
        }
        AppMethodBeat.o(238665);
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
    this.hmp.post(paramRunnable);
    AppMethodBeat.o(238665);
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
        if (g.this.hmq.enable) {
          g.this.hmq.hmG.pollFirst();
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