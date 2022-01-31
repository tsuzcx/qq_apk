package c.t.m.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
{
  public static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(136395);
    if (paramHandler == null) {}
    for (paramHandler = null;; paramHandler = paramHandler.getLooper())
    {
      boolean bool = a(paramHandler);
      AppMethodBeat.o(136395);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage)
  {
    AppMethodBeat.i(136397);
    boolean bool = a(paramHandler, paramMessage, 0L);
    AppMethodBeat.o(136397);
    return bool;
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(136398);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(136398);
      return bool;
    }
    AppMethodBeat.o(136398);
    return false;
  }
  
  public static boolean a(Looper paramLooper)
  {
    AppMethodBeat.i(136396);
    if ((paramLooper != null) && (paramLooper.getThread().isAlive()))
    {
      AppMethodBeat.o(136396);
      return true;
    }
    AppMethodBeat.o(136396);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     c.t.m.c.o
 * JD-Core Version:    0.7.0.1
 */