package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/BaselineShiftSpan;", "Landroid/text/style/MetricAffectingSpan;", "multiplier", "", "(F)V", "getMultiplier", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends MetricAffectingSpan
{
  private final float bby;
  
  public a(float paramFloat)
  {
    this.bby = paramFloat;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205197);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.baselineShift += (int)(float)Math.ceil(paramTextPaint.ascent() * this.bby);
    AppMethodBeat.o(205197);
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205193);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.baselineShift += (int)(float)Math.ceil(paramTextPaint.ascent() * this.bby);
    AppMethodBeat.o(205193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.a
 * JD-Core Version:    0.7.0.1
 */