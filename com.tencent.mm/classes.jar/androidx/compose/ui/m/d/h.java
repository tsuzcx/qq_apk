package androidx.compose.ui.m.d;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"platformLocaleDelegate", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "getPlatformLocaleDelegate", "()Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final g bdF;
  
  static
  {
    AppMethodBeat.i(205123);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (g localg = (g)new c();; localg = (g)new b())
    {
      bdF = localg;
      AppMethodBeat.o(205123);
      return;
    }
  }
  
  public static final g BM()
  {
    return bdF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d.h
 * JD-Core Version:    0.7.0.1
 */