package androidx.compose.ui.m.e;

import android.graphics.Typeface;
import android.text.style.TypefaceSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/Api28Impl;", "", "()V", "createTypefaceSpan", "Landroid/text/style/TypefaceSpan;", "typeface", "Landroid/graphics/Typeface;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
{
  public static final e bdO;
  
  static
  {
    AppMethodBeat.i(205333);
    bdO = new e();
    AppMethodBeat.o(205333);
  }
  
  public final TypefaceSpan c(Typeface paramTypeface)
  {
    AppMethodBeat.i(205336);
    s.u(paramTypeface, "typeface");
    paramTypeface = new TypefaceSpan(paramTypeface);
    AppMethodBeat.o(205336);
    return paramTypeface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.e
 * JD-Core Version:    0.7.0.1
 */