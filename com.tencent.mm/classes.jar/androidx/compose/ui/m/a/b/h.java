package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/SkewXSpan;", "Landroid/text/style/MetricAffectingSpan;", "skewX", "", "(F)V", "getSkewX", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends MetricAffectingSpan
{
  private final float bbL;
  
  public h(float paramFloat)
  {
    this.bbL = paramFloat;
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205203);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setTextSkewX(this.bbL + paramTextPaint.getTextSkewX());
    AppMethodBeat.o(205203);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205208);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setTextSkewX(this.bbL + paramTextPaint.getTextSkewX());
    AppMethodBeat.o(205208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.h
 * JD-Core Version:    0.7.0.1
 */