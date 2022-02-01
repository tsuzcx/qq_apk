package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/LetterSpacingSpanPx;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "(F)V", "getLetterSpacing", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "updatePaint", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MetricAffectingSpan
{
  private final float bbz;
  
  public d(float paramFloat)
  {
    this.bbz = paramFloat;
  }
  
  private final void a(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205200);
    float f = paramTextPaint.getTextSize();
    f = paramTextPaint.getTextScaleX() * f;
    if (f == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramTextPaint.setLetterSpacing(this.bbz / f);
      }
      AppMethodBeat.o(205200);
      return;
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205209);
    s.u(paramTextPaint, "textPaint");
    a(paramTextPaint);
    AppMethodBeat.o(205209);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205216);
    s.u(paramTextPaint, "textPaint");
    a(paramTextPaint);
    AppMethodBeat.o(205216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.d
 * JD-Core Version:    0.7.0.1
 */