package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan01;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackgroung", "drawText", "Builder", "Companion", "plugin-finder_release"})
public final class r
  extends ImageSpan
{
  private static final int yfO;
  private static final int yfP;
  private static final int yfQ;
  private static final int yfR;
  private static final int yfS;
  private static final float yfT;
  private static final float yfU;
  public static final b yfV;
  public s yfN;
  
  static
  {
    AppMethodBeat.i(287065);
    yfV = new b((byte)0);
    int i = d.e(MMApplicationContext.getContext(), 2.0F);
    yfO = i;
    yfP = i * 2;
    i = d.e(MMApplicationContext.getContext(), 18.0F);
    yfQ = i;
    yfR = i / 2;
    yfS = d.e(MMApplicationContext.getContext(), 12.0F);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    yfT = localContext.getResources().getDimension(b.d.Edge_0_5_A);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    yfU = localContext.getResources().getDimension(b.d.Edge_0_5_A);
    AppMethodBeat.o(287065);
  }
  
  public r(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(287064);
    this.yfN = new s();
    AppMethodBeat.o(287064);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(287063);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    try
    {
      paramInt1 = paramPaint.getColor();
      float f1 = paramPaint.getTextSize();
      paramCharSequence = paramPaint.getTypeface();
      paramPaint.setColor(this.yfN.bgColor);
      paramPaint.setTextSize(this.yfN.textSize);
      String str = this.yfN.yfW + this.yfN.yfX;
      float f2 = this.yfN.mTB / 2.0F;
      float f3 = (paramInt5 - paramInt3) / 2.0F;
      float f4 = this.yfN.Gp + paramFloat;
      float f5 = this.yfN.yfY;
      paramCanvas.drawRoundRect(new RectF(f4, f3 - f2, paramPaint.measureText(str, 0, str.length()) + (f5 + f4) + this.yfN.yfZ + yfP, f3 + f2), f2, f2, paramPaint);
      paramPaint.setColor(this.yfN.textColor);
      paramPaint.setTextSize(this.yfN.textSize);
      f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F + (paramInt5 - paramInt3) / 2 + 1.0F;
      paramFloat = this.yfN.Gp + paramFloat + this.yfN.yfY;
      paramCanvas.drawText(this.yfN.yfW.toString(), paramFloat, f2, paramPaint);
      paramPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 2));
      f3 = yfO;
      f4 = paramPaint.measureText(this.yfN.yfW, 0, this.yfN.yfW.length());
      paramCanvas.drawText(this.yfN.yfX.toString(), paramFloat + f3 + f4, f2, paramPaint);
      paramPaint.setColor(paramInt1);
      paramPaint.setTextSize(f1);
      paramPaint.setTypeface(paramCharSequence);
      AppMethodBeat.o(287063);
      return;
    }
    catch (Exception paramCanvas)
    {
      f.a.a(b.BuZ, "liveInvalidBadgeTag", false, false, null, 28);
      paramCharSequence = aj.AGc;
      aj.a(paramCanvas, "FinderLiveItalicImageSpan01.draw");
      AppMethodBeat.o(287063);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan01$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;)V", "build", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan01;", "setBadgeLevel", "badgeLevel", "", "config", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveSpanConfig;", "setBgColor", "bgColor", "setBgHeight", "bgHeight", "setItalicText", "italicText", "", "setLeftMargin", "leftMargin", "setNormalText", "normalText", "setServerBgColor", "serverColorStr", "", "setTextColor", "textColor", "plugin-finder_release"})
  public static final class a
  {
    public s yfN;
    
    public a()
    {
      AppMethodBeat.i(287271);
      this.yfN = new s();
      AppMethodBeat.o(287271);
    }
    
    public final a aCe(String paramString)
    {
      AppMethodBeat.i(287270);
      CharSequence localCharSequence = (CharSequence)paramString;
      int i;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {}
        try
        {
          this.yfN.bgColor = Color.parseColor(paramString);
          AppMethodBeat.o(287270);
          return this;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("FinderLiveLevelImageSpan", localException + ",serverColor:" + paramString);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan01$Companion;", "", "()V", "DEFAULT_BG_MARGIN", "", "getDEFAULT_BG_MARGIN", "()F", "DEFAULT_BG_PADING", "getDEFAULT_BG_PADING", "DEFAULT_SPAN_HEIGHT", "", "getDEFAULT_SPAN_HEIGHT", "()I", "DEFAULT_SPAN_RADIUS", "getDEFAULT_SPAN_RADIUS", "DEFAULT_TEXT_SIZE", "getDEFAULT_TEXT_SIZE", "DOUBLE_ITALIC_PADDING", "getDOUBLE_ITALIC_PADDING", "ITALIC_PADDING", "getITALIC_PADDING", "TAG", "", "createBuilder", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan01$Builder;", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "leftMargin", "rightMargin", "width", "height", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.r
 * JD-Core Version:    0.7.0.1
 */