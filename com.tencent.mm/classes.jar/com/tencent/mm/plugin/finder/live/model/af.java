package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "plugin-finder_release"})
public final class af
  extends ImageSpan
{
  public static final a ygY;
  private final String TAG;
  private final ag ygX;
  
  static
  {
    AppMethodBeat.i(291280);
    ygY = new a((byte)0);
    AppMethodBeat.o(291280);
  }
  
  public af(Drawable paramDrawable, ag paramag)
  {
    super(paramDrawable);
    AppMethodBeat.i(291279);
    this.ygX = paramag;
    this.TAG = "FinderLiveRoundImageSpan";
    AppMethodBeat.o(291279);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(291278);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    for (;;)
    {
      float f5;
      try
      {
        paramInt4 = paramPaint.getColor();
        float f7 = paramPaint.getTextSize();
        paramPaint.setTextSize(this.ygX.textSize);
        paramPaint.setColor(this.ygX.bgColor);
        f3 = paramInt3;
        float f4 = paramInt5;
        f5 = this.ygX.radius;
        float f2 = f4;
        float f1 = f3;
        if (this.ygX.mTB > 0)
        {
          f1 = (f4 - f3) / 2.0F;
          float f6 = this.ygX.mTB / 2.0F;
          f3 = f1 - f6;
          f4 = f1 + f6;
          paramCharSequence = ag.yhb;
          f2 = f4;
          f1 = f3;
          if (f5 == ag.dze())
          {
            f1 = f3;
            f2 = f4;
            f3 = f6;
            paramCanvas.drawRoundRect(new RectF(paramFloat, f1, paramPaint.measureText(this.ygX.LV, paramInt1, paramInt2) + this.ygX.yfY + this.ygX.yfZ + paramFloat, f2), f3, f3, paramPaint);
            paramPaint.setColor(this.ygX.textColor);
            f1 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
            f2 = (paramInt5 - paramInt3) / 2;
            paramCanvas.drawText(this.ygX.LV, paramInt1, paramInt2, paramFloat + this.ygX.yfY, f1 + f2 + 1.0F, paramPaint);
            paramPaint.setColor(paramInt4);
            paramPaint.setTextSize(f7);
            AppMethodBeat.o(291278);
            return;
          }
        }
      }
      catch (Exception paramCanvas)
      {
        f.a.a(b.BuZ, "liveInvalidBadgeTag", false, false, null, 28);
        paramCharSequence = aj.AGc;
        aj.a(paramCanvas, this.TAG + ".draw");
        AppMethodBeat.o(291278);
        return;
      }
      float f3 = f5;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "textSize", "", "textPading", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.af
 * JD-Core Version:    0.7.0.1
 */