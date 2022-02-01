package androidx.compose.ui.m.e;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/TypefaceAdapterHelperMethods;", "", "()V", "create", "Landroid/graphics/Typeface;", "typeface", "finalFontWeight", "", "finalFontStyle", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g bdU;
  
  static
  {
    AppMethodBeat.i(205322);
    bdU = new g();
    AppMethodBeat.o(205322);
  }
  
  public final Typeface a(Typeface paramTypeface, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205324);
    s.u(paramTypeface, "typeface");
    paramTypeface = Typeface.create(paramTypeface, paramInt, paramBoolean);
    s.s(paramTypeface, "create(typeface, finalFontWeight, finalFontStyle)");
    AppMethodBeat.o(205324);
    return paramTypeface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.g
 * JD-Core Version:    0.7.0.1
 */