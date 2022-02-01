package com.tencent.mm.plugin.finder.live.view.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFixWidthTextSpan;", "Landroid/text/style/ReplacementSpan;", "minWidth", "", "(I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends ReplacementSpan
{
  private final int DWv;
  
  public d(int paramInt)
  {
    this.DWv = paramInt;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(358408);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramInt3 = (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2);
    if (paramInt3 < this.DWv)
    {
      paramFloat += (this.DWv - paramInt3) / 2;
      if (paramCharSequence != null) {
        break label88;
      }
      paramCharSequence = (CharSequence)"";
    }
    label88:
    for (;;)
    {
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt4, paramPaint);
      AppMethodBeat.o(358408);
      return;
      break;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(358398);
    s.u(paramPaint, "paint");
    paramInt1 = k.qu((int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2), this.DWv);
    AppMethodBeat.o(358398);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.d
 * JD-Core Version:    0.7.0.1
 */