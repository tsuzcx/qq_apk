package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/LetterSpacingSpanEm;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "(F)V", "getLetterSpacing", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MetricAffectingSpan
{
  private final float bbz;
  
  public c(float paramFloat)
  {
    this.bbz = paramFloat;
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205204);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setLetterSpacing(this.bbz);
    AppMethodBeat.o(205204);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205212);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setLetterSpacing(this.bbz);
    AppMethodBeat.o(205212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.c
 * JD-Core Version:    0.7.0.1
 */