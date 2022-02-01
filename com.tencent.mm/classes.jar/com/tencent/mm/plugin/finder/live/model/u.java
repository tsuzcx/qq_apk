package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan;", "Landroid/text/style/ReplacementSpan;", "config", "Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;", "(Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Config", "plugin-finder_release"})
public final class u
  extends ReplacementSpan
{
  private final a ukf;
  
  public u(a parama)
  {
    AppMethodBeat.i(246279);
    this.ukf = parama;
    AppMethodBeat.o(246279);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(246278);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (paramCharSequence == null) {
      paramCharSequence = (CharSequence)"";
    }
    for (;;)
    {
      paramInt4 = paramPaint.getColor();
      float f1 = paramPaint.getTextSize();
      paramPaint.setTextSize(this.ukf.textSize);
      paramPaint.setColor(this.ukf.bgColor);
      paramCanvas.drawRoundRect(new RectF(paramFloat, paramInt3, paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.ukf.ujl + this.ukf.ujm + paramFloat, paramInt5), this.ukf.radius, this.ukf.radius, paramPaint);
      paramPaint.setColor(this.ukf.textColor);
      float f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      float f3 = (paramInt5 - paramInt3) / 2;
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + this.ukf.ujl, f2 + f3 + 1.0F, paramPaint);
      paramPaint.setColor(paramInt4);
      paramPaint.setTextSize(f1);
      AppMethodBeat.o(246278);
      return;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(246277);
    p.h(paramPaint, "paint");
    float f = paramPaint.getTextSize();
    paramPaint.setTextSize(this.ukf.textSize);
    paramInt1 = (int)(paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + this.ukf.ujl + this.ukf.ujm + this.ukf.leftMargin + this.ukf.rightMargin);
    paramPaint.setTextSize(f);
    AppMethodBeat.o(246277);
    return paramInt1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/RoundBackgroundSpan$Config;", "", "leftPading", "", "rightPading", "topPading", "bottomPading", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "radius", "bgColor", "", "textColor", "textSize", "(FFFFFFFFFIII)V", "getBgColor", "()I", "getBottomMargin", "()F", "getBottomPading", "getLeftMargin", "getLeftPading", "getRadius", "getRightMargin", "getRightPading", "getTextColor", "getTextSize", "getTopMargin", "getTopPading", "plugin-finder_release"})
  public static final class a
  {
    final int bgColor;
    private final float bottomMargin;
    final float leftMargin;
    final float radius;
    final float rightMargin;
    final int textColor;
    final int textSize;
    private final float topMargin;
    final float ujl;
    final float ujm;
    private final float ukg;
    private final float ukh;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, int paramInt3)
    {
      this.ujl = paramFloat1;
      this.ujm = paramFloat2;
      this.ukg = paramFloat3;
      this.ukh = paramFloat4;
      this.leftMargin = paramFloat5;
      this.rightMargin = 0.0F;
      this.topMargin = 0.0F;
      this.bottomMargin = 0.0F;
      this.radius = paramFloat6;
      this.bgColor = paramInt1;
      this.textColor = paramInt2;
      this.textSize = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.u
 * JD-Core Version:    0.7.0.1
 */