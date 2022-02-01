package com.tencent.mm.plugin.finder.live.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.plugin.finder.utils.y;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpanConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "plugin-finder_release"})
public final class m
  extends ImageSpan
{
  public static final a ujk;
  private final String TAG;
  private final n uiH;
  
  static
  {
    AppMethodBeat.i(246181);
    ujk = new a((byte)0);
    AppMethodBeat.o(246181);
  }
  
  public m(Drawable paramDrawable, n paramn)
  {
    super(paramDrawable);
    AppMethodBeat.i(246180);
    this.uiH = paramn;
    this.TAG = "FinderLiveRoundImageSpan";
    AppMethodBeat.o(246180);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(246179);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    for (;;)
    {
      float f5;
      try
      {
        paramInt4 = paramPaint.getColor();
        float f7 = paramPaint.getTextSize();
        paramPaint.setTextSize(this.uiH.textSize);
        paramPaint.setColor(this.uiH.bgColor);
        f3 = paramInt3;
        float f4 = paramInt5;
        f5 = this.uiH.radius;
        float f2 = f4;
        float f1 = f3;
        if (this.uiH.kcc > 0)
        {
          f1 = (f4 - f3) / 2.0F;
          float f6 = this.uiH.kcc / 2.0F;
          f3 = f1 - f6;
          f4 = f1 + f6;
          paramCharSequence = n.ujr;
          f2 = f4;
          f1 = f3;
          if (f5 == n.dfT())
          {
            f1 = f3;
            f2 = f4;
            f3 = f6;
            paramCanvas.drawRoundRect(new RectF(paramFloat, f1, paramPaint.measureText(this.uiH.text, paramInt1, paramInt2) + this.uiH.ujl + this.uiH.ujm + paramFloat, f2), f3, f3, paramPaint);
            paramPaint.setColor(this.uiH.textColor);
            f1 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
            f2 = (paramInt5 - paramInt3) / 2;
            paramCanvas.drawText(this.uiH.text, paramInt1, paramInt2, paramFloat + this.uiH.ujl, f1 + f2 + 1.0F, paramPaint);
            paramPaint.setColor(paramInt4);
            paramPaint.setTextSize(f7);
            AppMethodBeat.o(246179);
            return;
          }
        }
      }
      catch (Exception paramCanvas)
      {
        f.a.a(c.vVc, "liveInvalidBadgeTag", false, false, null, 28);
        paramCharSequence = y.vXH;
        y.a(paramCanvas, this.TAG + ".draw");
        AppMethodBeat.o(246179);
        return;
      }
      float f3 = f5;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "textSize", "", "textPading", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.m
 * JD-Core Version:    0.7.0.1
 */