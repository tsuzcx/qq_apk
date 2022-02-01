package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "Config", "plugin-finder_release"})
public final class ar
  extends ImageSpan
{
  public static final a yis;
  private final b yir;
  
  static
  {
    AppMethodBeat.i(273326);
    yis = new a((byte)0);
    AppMethodBeat.o(273326);
  }
  
  public ar(Drawable paramDrawable, b paramb)
  {
    super(paramDrawable);
    AppMethodBeat.i(273325);
    this.yir = paramb;
    AppMethodBeat.o(273325);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(273324);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    paramInt4 = paramPaint.getColor();
    float f1 = paramPaint.getTextSize();
    paramPaint.setTextSize(this.yir.textSize);
    paramPaint.setColor(this.yir.bgColor);
    paramCanvas.drawRoundRect(new RectF(paramFloat, paramInt3, paramPaint.measureText(this.yir.LV, paramInt1, paramInt2) + this.yir.yfY + this.yir.yfZ + paramFloat, paramInt5), this.yir.radius, this.yir.radius, paramPaint);
    paramPaint.setColor(this.yir.textColor);
    float f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
    float f3 = (paramInt5 - paramInt3) / 2;
    paramCanvas.drawText(this.yir.LV, paramInt1, paramInt2, paramFloat + this.yir.yfY, f2 + f3 + 1.0F, paramPaint);
    paramPaint.setColor(paramInt4);
    paramPaint.setTextSize(f1);
    AppMethodBeat.o(273324);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/RoundImageSpan$Config;", "", "text", "", "leftPading", "", "rightPading", "topPading", "bottomPading", "leftMargin", "rightMargin", "topMargin", "bottomMargin", "radius", "bgColor", "", "textColor", "textSize", "(Ljava/lang/CharSequence;FFFFFFFFFIII)V", "getBgColor", "()I", "getBottomMargin", "()F", "getBottomPading", "getLeftMargin", "getLeftPading", "getRadius", "getRightMargin", "getRightPading", "getText", "()Ljava/lang/CharSequence;", "getTextColor", "getTextSize", "getTopMargin", "getTopPading", "plugin-finder_release"})
  public static final class b
  {
    final CharSequence LV;
    final int bgColor;
    private final float bottomMargin;
    private final float leftMargin;
    final float radius;
    private final float rightMargin;
    final int textColor;
    final int textSize;
    private final float topMargin;
    final float yfY;
    final float yfZ;
    private final float yit;
    private final float yiu;
    
    public b(CharSequence paramCharSequence, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(280545);
      this.LV = paramCharSequence;
      this.yfY = paramFloat1;
      this.yfZ = paramFloat2;
      this.yit = paramFloat3;
      this.yiu = paramFloat4;
      this.leftMargin = paramFloat5;
      this.rightMargin = 0.0F;
      this.topMargin = 0.0F;
      this.bottomMargin = 0.0F;
      this.radius = paramFloat6;
      this.bgColor = paramInt1;
      this.textColor = paramInt2;
      this.textSize = paramInt3;
      AppMethodBeat.o(280545);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ar
 * JD-Core Version:    0.7.0.1
 */