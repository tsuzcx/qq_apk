package androidx.compose.ui.m.a.b;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/TypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "typeface", "Landroid/graphics/Typeface;", "(Landroid/graphics/Typeface;)V", "getTypeface", "()Landroid/graphics/Typeface;", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "updateTypeface", "Landroid/graphics/Paint;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends MetricAffectingSpan
{
  private final Typeface bbO;
  
  public j(Typeface paramTypeface)
  {
    AppMethodBeat.i(205215);
    this.bbO = paramTypeface;
    AppMethodBeat.o(205215);
  }
  
  private final void a(Paint paramPaint)
  {
    AppMethodBeat.i(205220);
    paramPaint.setTypeface(this.bbO);
    AppMethodBeat.o(205220);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205224);
    s.u(paramTextPaint, "ds");
    a((Paint)paramTextPaint);
    AppMethodBeat.o(205224);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205227);
    s.u(paramTextPaint, "paint");
    a((Paint)paramTextPaint);
    AppMethodBeat.o(205227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.j
 * JD-Core Version:    0.7.0.1
 */