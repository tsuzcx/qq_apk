package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "Config", "plugin-finder_release"})
public final class v
  extends ImageSpan
{
  public static final a ukj;
  private final b uki;
  
  static
  {
    AppMethodBeat.i(246283);
    ukj = new a((byte)0);
    AppMethodBeat.o(246283);
  }
  
  public v(Drawable paramDrawable, b paramb)
  {
    super(paramDrawable);
    AppMethodBeat.i(246282);
    this.uki = paramb;
    AppMethodBeat.o(246282);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(246281);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    paramInt4 = paramPaint.getColor();
    float f1 = paramPaint.getTextSize();
    paramPaint.setTextSize(this.uki.textSize);
    paramPaint.setColor(this.uki.bgColor);
    paramCanvas.drawRoundRect(new RectF(paramFloat, paramInt3, paramPaint.measureText(this.uki.text, paramInt1, paramInt2) + this.uki.ujl + this.uki.ujm + paramFloat, paramInt5), this.uki.radius, this.uki.radius, paramPaint);
    paramPaint.setColor(this.uki.textColor);
    float f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
    float f3 = (paramInt5 - paramInt3) / 2;
    paramCanvas.drawText(this.uki.text, paramInt1, paramInt2, paramFloat + this.uki.ujl, f2 + f3 + 1.0F, paramPaint);
    paramPaint.setColor(paramInt4);
    paramPaint.setTextSize(f1);
    AppMethodBeat.o(246281);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "", "text", "", "leftPading", "", "rightPading", "topPading", "bottomPading", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "radius", "bgColor", "", "textColor", "textSize", "(Ljava/lang/CharSequence;FFFFFFFFFIII)V", "getBgColor", "()I", "getBottomMargin", "()F", "getBottomPading", "getLeftMargin", "getLeftPading", "getRadius", "getRightMargin", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "getTextColor", "getTextSize", "getTopMargin", "getTopPading", "plugin-finder_release"})
  public static final class b
  {
    final int bgColor;
    private final float bottomMargin;
    private final float leftMargin;
    final float radius;
    private final float rightMargin;
    final CharSequence text;
    final int textColor;
    final int textSize;
    private final float topMargin;
    final float ujl;
    final float ujm;
    private final float ukg;
    private final float ukh;
    
    public b(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(246280);
      this.text = paramCharSequence;
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
      AppMethodBeat.o(246280);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.v
 * JD-Core Version:    0.7.0.1
 */