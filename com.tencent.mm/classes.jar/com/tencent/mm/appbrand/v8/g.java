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
  private c.a fib;
  private final a fic;
  k fid;
  private final Looper mLooper;
  
  g(Looper paramLooper)
  {
    AppMethodBeat.i(144002);
    this.fib = null;
    this.fid = new k();
    this.mLooper = paramLooper;
    this.fic = new a(paramLooper);
    AppMethodBeat.o(144002);
  }
  
  public final String OG()
  {
    AppMethodBeat.i(185101);
    String str = (String)this.fid.fiu.peek();
    AppMethodBeat.o(185101);
    return str;
  }
  
  public final void a(c.a parama)
  {
    this.fib = parama;
  }
  
  public final boolean abY()
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
  
  public final void acb()
  {
    AppMethodBeat.i(144003);
    Looper.loop();
    AppMethodBeat.o(144003);
  }
  
  public final void b(Runnable paramRunnable, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(262447);
    this.fic.post(paramRunnable);
    AppMethodBeat.o(262447);
  }
  
  final void c(V8ScriptException paramV8ScriptException)
  {
    AppMethodBeat.i(144008);
    if (this.fib != null) {
      this.fib.b(paramV8ScriptException);
    }
    AppMethodBeat.o(144008);
  }
  
  public final boolean doInnerLoopTask()
  {
    AppMethodBeat.i(262449);
    Log.e("doInnerLoopTask", "should not to be here");
    AppMethodBeat.o(262449);
    return true;
  }
  
  public final void dp(boolean paramBoolean)
  {
    this.fid.enable = paramBoolean;
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
    AppMethodBeat.i(262448);
    Log.e("resumeLoopTasks", "should not to be here");
    AppMethodBeat.o(262448);
  }
  
  public final void t(Runnable paramRunnable)
  {
    AppMethodBeat.i(262445);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(262445);
      return;
    }
    if (Thread.currentThread().getId() == this.mLooper.getThread().getId()) {
      try
      {
        paramRunnable.run();
        if (this.fid.enable) {
          this.fid.fiu.remove(null);
        }
        AppMethodBeat.o(262445);
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
    this.fic.post(paramRunnable);
    AppMethodBeat.o(262445);
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
        if (g.this.fid.enable) {
          g.this.fid.fiu.pollFirst();
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