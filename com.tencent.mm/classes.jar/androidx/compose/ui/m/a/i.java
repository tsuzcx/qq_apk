package androidx.compose.ui.m.a;

import android.text.StaticLayout.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory28;", "", "()V", "setUseLineSpacingFromFallbacks", "", "builder", "Landroid/text/StaticLayout$Builder;", "useFallbackLineSpacing", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class i
{
  public static final i baW;
  
  static
  {
    AppMethodBeat.i(205185);
    baW = new i();
    AppMethodBeat.o(205185);
  }
  
  public static void a(StaticLayout.Builder paramBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(205179);
    s.u(paramBuilder, "builder");
    paramBuilder.setUseLineSpacingFromFallbacks(paramBoolean);
    AppMethodBeat.o(205179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.compose.ui.m.a.i
 * JD-Core Version:    0.7.0.1
 */