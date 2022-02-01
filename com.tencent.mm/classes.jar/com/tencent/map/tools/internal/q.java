package com.tencent.map.tools.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  private static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(193529);
    if (paramHandler == null) {}
    for (paramHandler = null; (paramHandler != null) && (paramHandler.getThread().isAlive()); paramHandler = paramHandler.getLooper())
    {
      AppMethodBeat.o(193529);
      return true;
    }
    AppMethodBeat.o(193529);
    return false;
  }
  
  public static boolean a(Handler paramHandler, int paramInt, long paramLong)
  {
    AppMethodBeat.i(193530);
    if (paramHandler == null) {}
    for (Message localMessage = null;; localMessage = paramHandler.obtainMessage(paramInt))
    {
      boolean bool = a(paramHandler, localMessage, paramLong);
      AppMethodBeat.o(193530);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(193532);
    if (paramHandler == null)
    {
      AppMethodBeat.o(193532);
      return false;
    }
    boolean bool = a(paramHandler, b(paramHandler, paramInt, paramObject), 0L);
    AppMethodBeat.o(193532);
    return bool;
  }
  
  private static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(193531);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(193531);
      return bool;
    }
    AppMethodBeat.o(193531);
    return false;
  }
  
  private static Message b(Handler paramHandler, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(193533);
    if (paramHandler == null) {}
    for (paramHandler = new Message();; paramHandler = paramHandler.obtainMessage(paramInt))
    {
      paramHandler.what = paramInt;
      paramHandler.arg1 = 0;
      paramHandler.arg2 = 0;
      paramHandler.obj = paramObject;
      AppMethodBeat.o(193533);
      return paramHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.internal.q
 * JD-Core Version:    0.7.0.1
 */