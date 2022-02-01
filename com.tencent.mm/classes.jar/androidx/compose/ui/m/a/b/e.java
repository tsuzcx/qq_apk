package androidx.compose.ui.m.a.b;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/LineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "(I)V", "getLineHeight", "()I", "chooseHeight", "", "text", "", "start", "end", "spanstartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements LineHeightSpan
{
  private final int lineHeight;
  
  public e(int paramInt)
  {
    this.lineHeight = paramInt;
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(205206);
    s.u(paramCharSequence, "text");
    s.u(paramFontMetricsInt, "fontMetricsInt");
    paramInt1 = paramFontMetricsInt.descent - paramFontMetricsInt.ascent;
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(205206);
      return;
    }
    float f = this.lineHeight * 1.0F / paramInt1;
    double d = paramFontMetricsInt.descent;
    paramFontMetricsInt.descent = ((int)Math.ceil(f * d));
    paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - this.lineHeight);
    AppMethodBeat.o(205206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.e
 * JD-Core Version:    0.7.0.1
 */