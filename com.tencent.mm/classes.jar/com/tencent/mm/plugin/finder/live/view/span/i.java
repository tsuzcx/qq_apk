package com.tencent.mm.plugin.finder.live.view.span;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "Landroid/text/style/ImageSpan;", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackground", "drawText", "spanWidth", "Builder", "Companion", "FinderLiveTagImageSpanConfig", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends ImageSpan
  implements k
{
  public static final b DXh;
  private c DXi;
  
  static
  {
    AppMethodBeat.i(358355);
    DXh = new b((byte)0);
    AppMethodBeat.o(358355);
  }
  
  public i(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(358345);
    this.DXi = new c();
    AppMethodBeat.o(358345);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(358365);
    s.u(paramc, "<set-?>");
    this.DXi = paramc;
    AppMethodBeat.o(358365);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(358386);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    try
    {
      paramInt2 = paramPaint.getColor();
      float f1 = paramPaint.getTextSize();
      paramCharSequence = paramPaint.getTypeface();
      paramPaint.setColor(this.DXi.bgColor);
      paramPaint.setTextSize(this.DXi.textSize);
      if (this.DXi.DXm <= 0)
      {
        String str = this.DXi.DXj + this.DXi.DXk;
        c localc = this.DXi;
        f2 = this.DXi.DWz;
        localc.DXm = ((int)(paramPaint.measureText(str, 0, str.length()) + f2 + this.DXi.DXl + this.DXi.DWA));
      }
      float f2 = this.DXi.pQi / 2.0F;
      float f3 = (paramInt5 - paramInt3) / 2.0F;
      float f4 = this.DXi.bmt + paramFloat;
      paramCanvas.drawRoundRect(new RectF(f4, f3 - f2, this.DXi.DXm + f4, f3 + f2), f2, f2, paramPaint);
      if (this.DXi.DWD) {
        com.tencent.mm.ui.aw.a(paramPaint, 0.8F);
      }
      paramPaint.setColor(this.DXi.textColor);
      paramPaint.setTextSize(this.DXi.textSize);
      f2 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      f2 = (paramInt5 - paramInt3) / 2 + f2;
      f3 = this.DXi.bmt;
      paramFloat = this.DXi.DWz + (f3 + paramFloat);
      paramCanvas.drawText(this.DXi.DXj.toString(), paramFloat, f2, paramPaint);
      if (this.DXi.DXk.length() > 0) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          f3 = paramPaint.measureText(this.DXi.DXj, 0, this.DXi.DXj.length());
          f4 = this.DXi.DXl;
          paramCanvas.drawText(this.DXi.DXk.toString(), f3 + paramFloat + f4, f2, paramPaint);
        }
        if (this.DXi.DWD) {
          com.tencent.mm.ui.aw.e(paramPaint);
        }
        paramPaint.setColor(paramInt2);
        paramPaint.setTextSize(f1);
        paramPaint.setTypeface(paramCharSequence);
        AppMethodBeat.o(358386);
        return;
      }
      return;
    }
    catch (Exception paramCanvas)
    {
      e.a.a((e)b.HbT, "liveInvalidBadgeTag", false, null, false, null, 60);
      paramCharSequence = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      com.tencent.mm.plugin.finder.utils.aw.a(paramCanvas, "FinderLiveTagImageSpan.draw");
      AppMethodBeat.o(358386);
    }
  }
  
  public final int ewo()
  {
    return this.DXi.DWF;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;)V", "build", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan;", "setBadgeLevel", "badgeLevel", "", "config", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpanConfig;", "setBgColor", "bgColor", "setBgHeight", "bgHeight", "setCenterPadding", "centerPading", "setLeftMargin", "leftMargin", "setPadding", "padding", "setServerBgColor", "serverColorStr", "", "setTextColor", "textColor", "setTextContent", "content", "", "setTextNum", "number", "setTextSize", "textSize", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    i.c DXi;
    
    public a()
    {
      AppMethodBeat.i(358450);
      this.DXi = new i.c();
      AppMethodBeat.o(358450);
    }
    
    public final a PR(int paramInt)
    {
      this.DXi.bgColor = paramInt;
      return this;
    }
    
    public final a PS(int paramInt)
    {
      this.DXi.textColor = paramInt;
      return this;
    }
    
    public final a PT(int paramInt)
    {
      this.DXi.textSize = paramInt;
      return this;
    }
    
    public final a PU(int paramInt)
    {
      this.DXi.DWA = paramInt;
      this.DXi.DWz = paramInt;
      return this;
    }
    
    public final a ad(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(358485);
      s.u(paramCharSequence, "content");
      this.DXi.ae(paramCharSequence);
      AppMethodBeat.o(358485);
      return this;
    }
    
    public final a ayh(String paramString)
    {
      AppMethodBeat.i(358459);
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
          this.DXi.bgColor = Color.parseColor(paramString);
          AppMethodBeat.o(358459);
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
    
    public final i ewM()
    {
      AppMethodBeat.i(358511);
      Object localObject = this.DXi;
      float f = this.DXi.DWz;
      h localh = h.DWP;
      ((i.c)localObject).DXm = ((int)(f + h.f(this.DXi.DXj + this.DXi.DXk, this.DXi.textSize) + this.DXi.DXl + this.DXi.DWA));
      this.DXi.DWF = (this.DXi.bmt + this.DXi.DXm + this.DXi.bmu);
      localObject = h.DWP;
      localObject = new i(h.PP(this.DXi.DWF));
      ((i)localObject).a(this.DXi);
      AppMethodBeat.o(358511);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$Companion;", "", "()V", "TAG", "", "createBuilder", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$Builder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveTagImageSpan$FinderLiveTagImageSpanConfig;", "", "textContent", "", "number", "textColor", "", "textSize", "textBold", "", "leftMargin", "rightMargin", "leftPading", "rightPading", "centerPading", "bgColor", "bgHeight", "radius", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZIIIIIIII)V", "backgroundWidth", "getBackgroundWidth", "()I", "setBackgroundWidth", "(I)V", "getBgColor", "setBgColor", "getBgHeight", "setBgHeight", "getCenterPading", "setCenterPading", "getLeftMargin", "setLeftMargin", "getLeftPading", "setLeftPading", "getNumber", "()Ljava/lang/CharSequence;", "setNumber", "(Ljava/lang/CharSequence;)V", "getRadius", "setRadius", "getRightMargin", "setRightMargin", "getRightPading", "setRightPading", "spanWidth", "getSpanWidth", "setSpanWidth", "getTextBold", "()Z", "setTextBold", "(Z)V", "getTextColor", "setTextColor", "getTextContent", "setTextContent", "getTextSize", "setTextSize", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    int DWA;
    boolean DWD;
    int DWF;
    int DWz;
    CharSequence DXj;
    CharSequence DXk;
    int DXl;
    int DXm;
    int bgColor;
    int bmt;
    int bmu;
    int pQi;
    private int radius;
    int textColor;
    int textSize;
    
    private c(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
    {
      AppMethodBeat.i(358443);
      this.DXj = paramCharSequence1;
      this.DXk = paramCharSequence2;
      this.textColor = paramInt1;
      this.textSize = paramInt2;
      this.DWD = false;
      this.bmt = 0;
      this.bmu = paramInt3;
      this.DWz = paramInt4;
      this.DWA = paramInt5;
      this.DXl = 0;
      this.bgColor = 0;
      this.pQi = paramInt6;
      this.radius = paramInt7;
      AppMethodBeat.o(358443);
    }
    
    public final void ae(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(358458);
      s.u(paramCharSequence, "<set-?>");
      this.DXj = paramCharSequence;
      AppMethodBeat.o(358458);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(358490);
      if (this == paramObject)
      {
        AppMethodBeat.o(358490);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(358490);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.DXj, paramObject.DXj))
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (!s.p(this.DXk, paramObject.DXk))
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.textColor != paramObject.textColor)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.textSize != paramObject.textSize)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.DWD != paramObject.DWD)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.bmt != paramObject.bmt)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.bmu != paramObject.bmu)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.DWz != paramObject.DWz)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.DWA != paramObject.DWA)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.DXl != paramObject.DXl)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.bgColor != paramObject.bgColor)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.pQi != paramObject.pQi)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      if (this.radius != paramObject.radius)
      {
        AppMethodBeat.o(358490);
        return false;
      }
      AppMethodBeat.o(358490);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(358468);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FinderLiveTagImageSpanConfig(textContent=").append(this.DXj).append(", number=").append(this.DXk).append(", textColor=").append(this.textColor).append(", textSize=").append(this.textSize).append(", textBold=").append(this.DWD).append(", leftMargin=").append(this.bmt).append(", rightMargin=").append(this.bmu).append(", leftPading=").append(this.DWz).append(", rightPading=").append(this.DWA).append(", centerPading=").append(this.DXl).append(", bgColor=").append(this.bgColor).append(", bgHeight=");
      ((StringBuilder)localObject).append(this.pQi).append(", radius=").append(this.radius).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(358468);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.i
 * JD-Core Version:    0.7.0.1
 */