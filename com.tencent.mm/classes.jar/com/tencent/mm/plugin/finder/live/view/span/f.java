package com.tencent.mm.plugin.finder.live.view.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "config", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpanConfig;", "(Landroid/graphics/drawable/Drawable;Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpanConfig;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends ImageSpan
{
  public static final a DWG;
  private final g DWH;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(358366);
    DWG = new a((byte)0);
    AppMethodBeat.o(358366);
  }
  
  public f(Drawable paramDrawable, g paramg)
  {
    super(paramDrawable);
    AppMethodBeat.i(358356);
    this.DWH = paramg;
    this.TAG = "FinderLiveRoundImageSpan";
    AppMethodBeat.o(358356);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(358382);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    for (;;)
    {
      float f3;
      float f4;
      float f6;
      try
      {
        int i = paramPaint.getColor();
        float f7 = paramPaint.getTextSize();
        paramPaint.setTextSize(this.DWH.textSize);
        paramPaint.setColor(this.DWH.bgColor);
        f3 = paramInt3;
        f4 = paramInt5;
        f5 = this.DWH.radius;
        f2 = f4;
        f1 = f3;
        if (this.DWH.pQi > 0)
        {
          f1 = (f4 - f3) / 2.0F;
          f6 = this.DWH.pQi / 2.0F;
          f3 = f1 - f6;
          f4 = f1 + f6;
          g.a locala = g.DWI;
          if (f5 == g.eww())
          {
            paramInt4 = 1;
            break label427;
            paramCanvas.drawRoundRect(new RectF(paramFloat, f1, paramPaint.measureText(this.DWH.bba, paramInt1, this.DWH.bba.length() + paramInt1) + this.DWH.DWJ + this.DWH.DWK + paramFloat, f2), f5, f5, paramPaint);
            paramPaint.setColor(this.DWH.textColor);
            f1 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
            f2 = (paramInt5 - paramInt3) / 2;
            paramCanvas.drawText(this.DWH.bba, paramInt1, paramInt1 + this.DWH.bba.length(), paramFloat + this.DWH.DWJ, f1 + f2 + 1.0F, paramPaint);
            paramPaint.setColor(i);
            paramPaint.setTextSize(f7);
            AppMethodBeat.o(358382);
          }
          else
          {
            paramInt4 = 0;
          }
        }
      }
      catch (Exception paramCanvas)
      {
        e.a.a((e)b.HbT, "liveInvalidBadgeTag", false, null, false, null, 60);
        paramPaint = aw.Gjk;
        aw.a(paramCanvas, this.TAG + ".draw(config:" + this.DWH + ",draw text:" + paramCharSequence + ",start:" + paramInt1 + ",end:" + paramInt2 + ')');
        AppMethodBeat.o(358382);
        return;
      }
      label427:
      do
      {
        break;
        f2 = f4;
        f1 = f3;
      } while (paramInt4 == 0);
      float f5 = f6;
      float f2 = f4;
      float f1 = f3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan$Companion;", "", "()V", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "spanStr", "", "textSize", "", "textPading", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static Drawable c(String paramString, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(358431);
      s.u(paramString, "spanStr");
      Paint localPaint = new Paint();
      localPaint.setTextSize(paramFloat1);
      paramFloat1 = localPaint.measureText(paramString, 0, paramString.length());
      paramString = new GradientDrawable();
      paramString.setBounds(0, 0, (int)(paramFloat1 + 2.0F * paramFloat2 + paramFloat2), 1);
      paramString = (Drawable)paramString;
      AppMethodBeat.o(358431);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.f
 * JD-Core Version:    0.7.0.1
 */