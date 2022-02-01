package com.tencent.mm.danmaku.f;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  @SuppressLint({"HandlerLeak"})
  public static final Handler sHandler;
  
  static
  {
    AppMethodBeat.i(241782);
    sHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(241780);
        if ((paramAnonymousMessage.obj instanceof Runnable)) {
          ((Runnable)paramAnonymousMessage.obj).run();
        }
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(241780);
      }
    };
    AppMethodBeat.o(241782);
  }
  
  public static void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(241781);
    sHandler.post(paramRunnable);
    AppMethodBeat.o(241781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.b
 * JD-Core Version:    0.7.0.1
 */