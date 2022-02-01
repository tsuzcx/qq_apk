package androidx.camera.core.impl.a;

import android.os.Handler;
import android.os.Looper;
import androidx.core.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static volatile Handler sHandler;
  
  public static Handler kO()
  {
    AppMethodBeat.i(198963);
    Handler localHandler;
    if (sHandler != null)
    {
      localHandler = sHandler;
      AppMethodBeat.o(198963);
      return localHandler;
    }
    try
    {
      if (sHandler == null) {
        sHandler = c.b(Looper.getMainLooper());
      }
      localHandler = sHandler;
      AppMethodBeat.o(198963);
      return localHandler;
    }
    finally
    {
      AppMethodBeat.o(198963);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.camera.core.impl.a.k
 * JD-Core Version:    0.7.0.1
 */