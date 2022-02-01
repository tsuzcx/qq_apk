package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.svg.a.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLevelImageSpan;", "Landroid/text/style/ImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;)V", "spanWidth", "", "getSpanWidth", "()I", "setSpanWidth", "(I)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackgroung", "drawLeftIcon", "drawRightText", "Builder", "Companion", "plugin-finder_release"})
public final class u
  extends ImageSpan
{
  private static final int yfQ;
  private static final int yfR;
  private static final int yfS;
  private static final int ygm;
  private static final int ygn;
  private static final int ygo;
  private static final int ygp;
  public static final b ygq;
  public int ygk;
  p ygl;
  
  static
  {
    AppMethodBeat.i(271264);
    ygq = new b((byte)0);
    Context localContext = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localContext, "MMApplicationContext.getContext()");
    int i = localContext.getResources().getDimensionPixelOffset(b.d.Edge_A);
    ygm = i;
    i /= 2;
    ygn = i;
    ygo = i / 2;
    i = d.e(MMApplicationContext.getContext(), 18.0F);
    yfQ = i;
    yfR = i / 2;
    yfS = d.e(MMApplicationContext.getContext(), 13.0F);
    ygp = d.e(MMApplicationContext.getContext(), 16.0F);
    AppMethodBeat.o(271264);
  }
  
  public u(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(271263);
    this.ygl = new p();
    AppMethodBeat.o(271263);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(271261);
    kotlin.g.b.p.k(paramCanvas, "canvas");
    kotlin.g.b.p.k(paramPaint, "paint");
    for (;;)
    {
      try
      {
        paramInt2 = paramPaint.getColor();
        float f1 = paramPaint.getTextSize();
        paramCharSequence = paramPaint.getTypeface();
        paramPaint.setTextSize(this.ygl.textSize);
        f3 = paramPaint.measureText(this.ygl.LV.toString());
        f2 = this.ygl.Gp + paramFloat;
        f3 = f3 + (this.ygl.yfF + f2 + this.ygl.yfL + this.ygl.yfH) + this.ygl.yfG;
        f5 = this.ygl.mTB / 2.0F;
        f6 = (paramInt5 - paramInt3) / 2.0F;
        f4 = f6 - f5;
        f5 += f6;
        Object localObject;
        if (this.ygl.bgColor != 0)
        {
          paramPaint.setColor(this.ygl.bgColor);
          paramCanvas.drawRoundRect(new RectF(f2, f4, f3, f5), this.ygl.bgRadius, this.ygl.bgRadius, paramPaint);
          localObject = this.ygl.yfK;
          if (localObject != null)
          {
            ((Drawable)localObject).setColorFilter((ColorFilter)new PorterDuffColorFilter(this.ygl.yfM, PorterDuff.Mode.SRC_ATOP));
            f2 = this.ygl.Gp + paramFloat + this.ygl.yfF;
            f3 = this.ygl.yfL;
            paramInt1 = (paramInt5 - paramInt3 - this.ygl.yfL) / 2;
            paramInt4 = this.ygl.yfL;
            ((Drawable)localObject).setBounds(new Rect((int)f2, paramInt1, (int)(f3 + f2), paramInt4 + paramInt1));
            ((Drawable)localObject).draw(paramCanvas);
            if (this.ygl.LV.length() != 0) {
              break label673;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label520;
            }
            Log.e("FinderLiveLevelImageSpan", "drawRightText text is empty!");
            paramPaint.setColor(paramInt2);
            paramPaint.setTextSize(f1);
            paramPaint.setTypeface(paramCharSequence);
            AppMethodBeat.o(271261);
          }
        }
        else
        {
          localObject = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
          localObject = ((Context)localObject).getResources().getDrawable(this.ygl.yfI, null);
          kotlin.g.b.p.j(localObject, "this");
          ((Drawable)localObject).setBounds(new Rect((int)f2, (int)f4, (int)f3, (int)f5));
          ((Drawable)localObject).draw(paramCanvas);
          continue;
        }
        Log.e("FinderLiveLevelImageSpan", "drawLeftIcon bitmap is empty!");
      }
      catch (Exception paramCanvas)
      {
        f.a.a(b.BuZ, "liveInvalidBadgeTag", false, false, null, 28);
        paramCharSequence = aj.AGc;
        aj.a(paramCanvas, "FinderLiveLevelImageSpan.draw");
        AppMethodBeat.o(271261);
        return;
      }
      continue;
      label520:
      if (this.ygl.yfJ) {
        ar.a(paramPaint, 0.8F);
      }
      paramPaint.setColor(this.ygl.textColor);
      float f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      float f3 = (paramInt5 - paramInt3) / 2;
      float f4 = this.ygl.Gp;
      float f5 = this.ygl.yfF;
      float f6 = this.ygl.yfL;
      float f7 = this.ygl.yfH;
      paramCanvas.drawText(this.ygl.LV.toString(), f4 + paramFloat + f5 + f6 + f7, f2 + f3 + 1.0F, paramPaint);
      if (this.ygl.yfJ)
      {
        ar.b(paramPaint);
        continue;
        label673:
        paramInt1 = 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLevelImageSpan$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;)V", "build", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLevelImageSpan;", "setBgHeight", "bgHeight", "", "setBgRadius", "bgRadius", "setLeftIcon", "leftIcon", "Landroid/graphics/drawable/Drawable;", "setLeftIconColor", "leftIconColor", "setLeftIconRes", "leftIconId", "setLeftIconSize", "leftIconSize", "setLeftMargin", "leftMargin", "setLevel", "userLevel", "config", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveSpanConfig;", "setRightMargin", "rightMargin", "setServerBgColor", "serverColorStr", "", "setText", "text", "", "setTextBold", "bold", "", "setTextColor", "textColor", "setTextSize", "textSize", "plugin-finder_release"})
  public static final class a
  {
    private p ygl;
    
    public a()
    {
      AppMethodBeat.i(285318);
      this.ygl = new p();
      AppMethodBeat.o(285318);
    }
    
    public final a Np(int paramInt)
    {
      this.ygl.Gp = paramInt;
      return this;
    }
    
    public final a Nq(int paramInt)
    {
      this.ygl.mTB = paramInt;
      return this;
    }
    
    public final a Nr(int paramInt)
    {
      this.ygl.textSize = paramInt;
      return this;
    }
    
    public final a Ns(int paramInt)
    {
      this.ygl.yfL = paramInt;
      return this;
    }
    
    public final a a(int paramInt, ap<Integer, Integer> paramap)
    {
      AppMethodBeat.i(285315);
      kotlin.g.b.p.k(paramap, "config");
      this.ygl.yfI = ((Number)paramap.dj(Integer.valueOf(paramInt))).intValue();
      this.ygl.mTB = ((Number)paramap.jdMethod_do(Integer.valueOf(paramInt))).intValue();
      this.ygl.textColor = ((Number)paramap.dk(Integer.valueOf(paramInt))).intValue();
      this.ygl.textSize = ((Number)paramap.dl(Integer.valueOf(paramInt))).intValue();
      Object localObject = this.ygl;
      if (((Number)paramap.dm(Integer.valueOf(paramInt))).intValue() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((p)localObject).yfJ = bool;
        this.ygl.yfK = a.h(MMApplicationContext.getResources(), ((Number)paramap.dn(Integer.valueOf(paramInt))).intValue());
        paramap = this.ygl;
        localObject = (CharSequence)String.valueOf(paramInt);
        kotlin.g.b.p.k(localObject, "<set-?>");
        paramap.LV = ((CharSequence)localObject);
        AppMethodBeat.o(285315);
        return this;
      }
    }
    
    public final a aCf(String paramString)
    {
      AppMethodBeat.i(285316);
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
          this.ygl.bgColor = Color.parseColor(paramString);
          AppMethodBeat.o(285316);
          return this;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.ygl.bgColor = 0;
            Log.e("FinderLiveLevelImageSpan", localException + ",serverColor:" + paramString);
          }
        }
      }
    }
    
    public final u dyT()
    {
      AppMethodBeat.i(285317);
      float f = this.ygl.Gp + this.ygl.yfF + this.ygl.yfL + this.ygl.yfH;
      Object localObject = u.ygq;
      int i = (int)(f + u.b.e(this.ygl.LV.toString(), this.ygl.textSize) + this.ygl.yfG + this.ygl.Gq);
      localObject = u.ygq;
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setBounds(0, 0, i, 1);
      localObject = new u((Drawable)localObject);
      ((u)localObject).ygk = i;
      p localp = this.ygl;
      kotlin.g.b.p.k(localp, "<set-?>");
      ((u)localObject).ygl = localp;
      AppMethodBeat.o(285317);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLevelImageSpan$Companion;", "", "()V", "DEFAULT_IMAGE_SIZE", "", "getDEFAULT_IMAGE_SIZE", "()I", "DEFAULT_SPAN_HEIGHT", "getDEFAULT_SPAN_HEIGHT", "DEFAULT_SPAN_RADIUS", "getDEFAULT_SPAN_RADIUS", "DEFAULT_TEXT_SIZE", "getDEFAULT_TEXT_SIZE", "D_0_2_5_A", "getD_0_2_5_A", "D_0_5_A", "getD_0_5_A", "D_A", "getD_A", "TAG", "", "createBuilder", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLevelImageSpan$Builder;", "generateDrawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "getTextWidth", "", "text", "textSize", "plugin-finder_release"})
  public static final class b
  {
    public static float e(String paramString, float paramFloat)
    {
      AppMethodBeat.i(288095);
      kotlin.g.b.p.k(paramString, "text");
      Paint localPaint = new Paint();
      localPaint.setTextSize(paramFloat);
      paramFloat = localPaint.measureText(paramString, 0, paramString.length());
      AppMethodBeat.o(288095);
      return paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.u
 * JD-Core Version:    0.7.0.1
 */