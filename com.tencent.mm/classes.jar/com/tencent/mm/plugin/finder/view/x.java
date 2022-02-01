package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/LineHeightStandard;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "getHeight", "()I", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-finder_release"})
public final class x
  implements LineHeightSpan
{
  private final int height;
  
  public x(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(266841);
    p.k(paramCharSequence, "text");
    p.k(paramFontMetricsInt, "fm");
    paramInt1 = paramFontMetricsInt.descent - paramFontMetricsInt.ascent;
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(266841);
      return;
    }
    paramFontMetricsInt.descent = a.dm(this.height * 1.0F / paramInt1 * paramFontMetricsInt.descent);
    paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - this.height);
    AppMethodBeat.o(266841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.x
 * JD-Core Version:    0.7.0.1
 */