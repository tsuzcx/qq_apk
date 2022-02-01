package com.tencent.mm.plugin.finder.view;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/LineHeightStandard;", "Landroid/text/style/LineHeightSpan;", "height", "", "(I)V", "getHeight", "()I", "chooseHeight", "", "text", "", "start", "end", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-finder_release"})
public final class q
  implements LineHeightSpan
{
  private final int height;
  
  public q(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void chooseHeight(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(255045);
    p.h(paramCharSequence, "text");
    p.h(paramFontMetricsInt, "fm");
    paramInt1 = paramFontMetricsInt.descent - paramFontMetricsInt.ascent;
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(255045);
      return;
    }
    paramFontMetricsInt.descent = a.cR(this.height * 1.0F / paramInt1 * paramFontMetricsInt.descent);
    paramFontMetricsInt.ascent = (paramFontMetricsInt.descent - this.height);
    AppMethodBeat.o(255045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.q
 * JD-Core Version:    0.7.0.1
 */