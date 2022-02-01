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
    AppMethodBeat.i(287361);
    sHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(279069);
        if ((paramAnonymousMessage.obj instanceof Runnable)) {
          ((Runnable)paramAnonymousMessage.obj).run();
        }
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(279069);
      }
    };
    AppMethodBeat.o(287361);
  }
  
  public static void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(287360);
    sHandler.post(paramRunnable);
    AppMethodBeat.o(287360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.danmaku.f.b
 * JD-Core Version:    0.7.0.1
 */