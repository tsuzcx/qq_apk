package androidx.camera.core.impl.a.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ScheduledExecutorService;

public final class f
{
  private static volatile ScheduledExecutorService Po;
  
  public static ScheduledExecutorService kR()
  {
    AppMethodBeat.i(199085);
    ScheduledExecutorService localScheduledExecutorService;
    if (Po != null)
    {
      localScheduledExecutorService = Po;
      AppMethodBeat.o(199085);
      return localScheduledExecutorService;
    }
    try
    {
      if (Po == null) {
        Po = new c(new Handler(Looper.getMainLooper()));
      }
      localScheduledExecutorService = Po;
      AppMethodBeat.o(199085);
      return localScheduledExecutorService;
    }
    finally
    {
      AppMethodBeat.o(199085);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.a.a.f
 * JD-Core Version:    0.7.0.1
 */