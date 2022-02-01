package c.t.m.sapp.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
{
  public static boolean a(Handler paramHandler)
  {
    AppMethodBeat.i(190501);
    if (paramHandler == null) {}
    for (paramHandler = null;; paramHandler = paramHandler.getLooper())
    {
      boolean bool = a(paramHandler);
      AppMethodBeat.o(190501);
      return bool;
    }
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage)
  {
    AppMethodBeat.i(190503);
    boolean bool = a(paramHandler, paramMessage, 0L);
    AppMethodBeat.o(190503);
    return bool;
  }
  
  public static boolean a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(190504);
    if ((paramMessage != null) && (a(paramHandler)))
    {
      boolean bool = paramHandler.sendMessageDelayed(paramMessage, paramLong);
      AppMethodBeat.o(190504);
      return bool;
    }
    AppMethodBeat.o(190504);
    return false;
  }
  
  public static boolean a(Looper paramLooper)
  {
    AppMethodBeat.i(190502);
    if ((paramLooper != null) && (paramLooper.getThread().isAlive()))
    {
      AppMethodBeat.o(190502);
      return true;
    }
    AppMethodBeat.o(190502);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.o
 * JD-Core Version:    0.7.0.1
 */