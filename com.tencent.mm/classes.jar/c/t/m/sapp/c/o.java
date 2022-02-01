package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
{
  public static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(210766);
    if (paramHandler == null) {}
    for (paramHandler = null;; paramHandler = paramHandler.getLooper())
    {
      boolean bool = a(paramHandler);
      AppMethodBeat.o(210766);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage)
  {
    AppMethodBeat.i(210768);
    boolean bool = a(paramHandler, paramMessage, 0L);
    AppMethodBeat.o(210768);
    return bool;
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(210769);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(210769);
      return bool;
    }
    AppMethodBeat.o(210769);
    return false;
  }
  
  public static boolean a(Looper paramLooper)
  {
    AppMethodBeat.i(210767);
    if ((paramLooper != null) && (paramLooper.getThread().isAlive()))
    {
      AppMethodBeat.o(210767);
      return true;
    }
    AppMethodBeat.o(210767);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.o
 * JD-Core Version:    0.7.0.1
 */