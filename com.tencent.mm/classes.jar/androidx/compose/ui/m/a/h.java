package androidx.compose.ui.m.a;

import android.text.StaticLayout.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory26;", "", "()V", "setJustificationMode", "", "builder", "Landroid/text/StaticLayout$Builder;", "justificationMode", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
{
  public static final h baV;
  
  static
  {
    AppMethodBeat.i(205183);
    baV = new h();
    AppMethodBeat.o(205183);
  }
  
  public static void a(StaticLayout.Builder paramBuilder, int paramInt)
  {
    AppMethodBeat.i(205178);
    s.u(paramBuilder, "builder");
    paramBuilder.setJustificationMode(paramInt);
    AppMethodBeat.o(205178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.compose.ui.m.a.h
 * JD-Core Version:    0.7.0.1
 */