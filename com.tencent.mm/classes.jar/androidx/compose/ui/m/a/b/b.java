package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/FontFeatureSpan;", "Landroid/text/style/MetricAffectingSpan;", "fontFeatureSettings", "", "(Ljava/lang/String;)V", "getFontFeatureSettings", "()Ljava/lang/String;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MetricAffectingSpan
{
  private final String ban;
  
  public b(String paramString)
  {
    AppMethodBeat.i(205195);
    this.ban = paramString;
    AppMethodBeat.o(205195);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205205);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setFontFeatureSettings(this.ban);
    AppMethodBeat.o(205205);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205199);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setFontFeatureSettings(this.ban);
    AppMethodBeat.o(205199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.b
 * JD-Core Version:    0.7.0.1
 */