package c.t.m.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
{
  public static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(39966);
    if (paramHandler == null) {}
    for (paramHandler = null;; paramHandler = paramHandler.getLooper())
    {
      boolean bool = a(paramHandler);
      AppMethodBeat.o(39966);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage)
  {
    AppMethodBeat.i(39968);
    boolean bool = a(paramHandler, paramMessage, 0L);
    AppMethodBeat.o(39968);
    return bool;
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(39969);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(39969);
      return bool;
    }
    AppMethodBeat.o(39969);
    return false;
  }
  
  public static boolean a(Looper paramLooper)
  {
    AppMethodBeat.i(39967);
    if ((paramLooper != null) && (paramLooper.getThread().isAlive()))
    {
      AppMethodBeat.o(39967);
      return true;
    }
    AppMethodBeat.o(39967);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.c.o
 * JD-Core Version:    0.7.0.1
 */