package com.tencent.map.tools.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(209790);
    if (paramHandler == null) {}
    for (paramHandler = null; (paramHandler != null) && (paramHandler.getThread().isAlive()); paramHandler = paramHandler.getLooper())
    {
      AppMethodBeat.o(209790);
      return true;
    }
    AppMethodBeat.o(209790);
    return false;
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    AppMethodBeat.i(209791);
    if (paramHandler == null) {}
    for (Message localMessage = null;; localMessage = paramHandler.obtainMessage(paramInt))
    {
      boolean bool = a(paramHandler, localMessage, paramLong);
      AppMethodBeat.o(209791);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(209793);
    if (paramHandler == null)
    {
      AppMethodBeat.o(209793);
      return false;
    }
    if (paramHandler == null) {}
    for (Message localMessage = new Message();; localMessage = paramHandler.obtainMessage(paramInt))
    {
      localMessage.what = paramInt;
      localMessage.arg1 = 0;
      localMessage.arg2 = 0;
      localMessage.obj = paramObject;
      boolean bool = a(paramHandler, localMessage, 0L);
      AppMethodBeat.o(209793);
      return bool;
    }
  }
  
  private static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(209792);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(209792);
      return bool;
    }
    AppMethodBeat.o(209792);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.q
 * JD-Core Version:    0.7.0.1
 */