package androidx.profileinstaller;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProfileInstallerInitializer$b
{
  public static Handler b(Looper paramLooper)
  {
    AppMethodBeat.i(194265);
    paramLooper = Handler.createAsync(paramLooper);
    AppMethodBeat.o(194265);
    return paramLooper;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.profileinstaller.ProfileInstallerInitializer.b
 * JD-Core Version:    0.7.0.1
 */