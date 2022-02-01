package androidx.camera.core.impl.a;

import android.os.Looper;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static void checkMainThread()
  {
    AppMethodBeat.i(198979);
    f.b(isMainThread(), "Not in application's main thread");
    AppMethodBeat.o(198979);
  }
  
  public static boolean isMainThread()
  {
    AppMethodBeat.i(198967);
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      AppMethodBeat.o(198967);
      return true;
    }
    AppMethodBeat.o(198967);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.a.l
 * JD-Core Version:    0.7.0.1
 */