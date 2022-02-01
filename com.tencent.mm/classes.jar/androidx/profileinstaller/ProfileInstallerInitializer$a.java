package androidx.profileinstaller;

import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProfileInstallerInitializer$a
{
  public static void h(Runnable paramRunnable)
  {
    AppMethodBeat.i(194264);
    Choreographer.getInstance().postFrameCallback(new ProfileInstallerInitializer.a..ExternalSyntheticLambda0(paramRunnable));
    AppMethodBeat.o(194264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.profileinstaller.ProfileInstallerInitializer.a
 * JD-Core Version:    0.7.0.1
 */