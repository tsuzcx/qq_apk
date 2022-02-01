package com.tencent.map.tools.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(236536);
    if (paramHandler == null) {}
    for (paramHandler = null; (paramHandler != null) && (paramHandler.getThread().isAlive()); paramHandler = paramHandler.getLooper())
    {
      AppMethodBeat.o(236536);
      return true;
    }
    AppMethodBeat.o(236536);
    return false;
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    AppMethodBeat.i(236538);
    if (paramHandler == null) {}
    for (Message localMessage = null;; localMessage = paramHandler.obtainMessage(paramInt))
    {
      boolean bool = a(paramHandler, localMessage, paramLong);
      AppMethodBeat.o(236538);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(236543);
    if (paramHandler == null)
    {
      AppMethodBeat.o(236543);
      return false;
    }
    boolean bool = a(paramHandler, b(paramHandler, paramInt, paramObject), 0L);
    AppMethodBeat.o(236543);
    return bool;
  }
  
  private static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(236540);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(236540);
      return bool;
    }
    AppMethodBeat.o(236540);
    return false;
  }
  
  private static Message b(Handler paramHandler, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(236546);
    if (paramHandler == null) {}
    for (paramHandler = new Message();; paramHandler = paramHandler.obtainMessage(paramInt))
    {
      paramHandler.what = paramInt;
      paramHandler.arg1 = 0;
      paramHandler.arg2 = 0;
      paramHandler.obj = paramObject;
      AppMethodBeat.o(236546);
      return paramHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.q
 * JD-Core Version:    0.7.0.1
 */