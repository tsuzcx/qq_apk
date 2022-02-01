package androidx.compose.ui.platform;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"isMainThread", "", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  static final boolean isMainThread()
  {
    AppMethodBeat.i(206913);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      AppMethodBeat.o(206913);
      return true;
    }
    AppMethodBeat.o(206913);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.n
 * JD-Core Version:    0.7.0.1
 */