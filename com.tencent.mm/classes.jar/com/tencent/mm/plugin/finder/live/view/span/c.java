package com.tencent.mm.plugin.finder.live.view.span;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan;", "Landroid/text/style/ImageSpan;", "Lcom/tencent/mm/plugin/finder/live/view/span/IFinderLiveSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "drawBackgroung", "canvasHeight", "drawLeftIcon", "drawLevelText", "drawNamesText", "drawRightIcon", "spanWidth", "Builder", "Companion", "FinderLiveFansSpanParams", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends ImageSpan
  implements k
{
  public static final c.b DWh;
  c DWi;
  
  static
  {
    AppMethodBeat.i(358420);
    DWh = new c.b((byte)0);
    AppMethodBeat.o(358420);
  }
  
  public c(Drawable paramDrawable)
  {
    super(paramDrawable);
    AppMethodBeat.i(358413);
    this.DWi = new c();
    AppMethodBeat.o(358413);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(358442);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramInt2 = paramPaint.getColor();
    float f1 = paramPaint.getTextSize();
    paramInt4 = paramInt5 - paramInt3;
    float f2 = paramFloat + this.DWi.bmt;
    paramPaint.setColor(this.DWi.bgColor);
    float f3;
    float f4;
    if (paramInt4 > this.DWi.pQi)
    {
      paramInt1 = (paramInt4 - this.DWi.pQi) / 2;
      paramFloat = paramInt1 + paramInt3;
      f3 = this.DWi.pQi + paramFloat;
      paramCanvas.drawRoundRect(new RectF(f2, paramFloat, this.DWi.ewq() + f2, f3), 45.0F, 45.0F, paramPaint);
      paramCharSequence = a.DJT;
      a.hQ("FinderLiveFansSpan", "drawBackgroung: top:" + paramInt3 + ",bottom:" + paramInt5 + ",bgHeight:" + this.DWi.pQi + ",topPos:" + paramFloat + ",bottomPos:" + f3);
      paramCharSequence = this.DWi.DWp;
      if (paramCharSequence != null)
      {
        paramInt1 = (paramInt4 - this.DWi.DWr) / 2;
        paramInt5 = paramInt3 + paramInt1;
        paramCharSequence.setBounds(new Rect((int)f2, paramInt5, (int)(this.DWi.DWq + f2), this.DWi.DWr + paramInt5));
        paramCharSequence.draw(paramCanvas);
        paramCharSequence = a.DJT;
        a.hQ("FinderLiveFansSpan", "drawLeftIcon: topMargin:" + paramInt1 + ",topPos:" + paramInt5 + ",bottomPos:" + (paramInt5 + this.DWi.DWr) + ",leftIconHeight:" + this.DWi.DWr);
      }
      aw.a(paramPaint, 0.8F);
      paramPaint.setColor(this.DWi.DWk);
      paramPaint.setTextSize(this.DWi.DWl);
      f3 = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      f4 = paramInt4 / 2;
      paramFloat = paramPaint.measureText(this.DWi.sdL, 0, this.DWi.sdL.length());
      if (this.DWi.DWq <= paramFloat) {
        break label779;
      }
      paramFloat = (this.DWi.DWq - paramFloat) / 2.0F;
      label467:
      paramCanvas.drawText(this.DWi.sdL, paramFloat + f2, f4 + f3, paramPaint);
      aw.e(paramPaint);
      aw.a(paramPaint, 0.8F);
      paramPaint.setColor(this.DWi.DWn);
      paramPaint.setTextSize(this.DWi.DWo);
      if (paramInt4 <= this.DWi.pQi) {
        break label785;
      }
    }
    label779:
    label785:
    for (paramInt1 = (paramInt4 - this.DWi.pQi) / 2;; paramInt1 = 0)
    {
      paramFloat = Math.abs(paramPaint.ascent() + paramPaint.descent()) / 2.0F;
      f3 = this.DWi.pQi / 2;
      f4 = paramInt1;
      float f5 = this.DWi.DWq + 1;
      paramCanvas.drawText(this.DWi.DWm, f5 + f2, f4 + (paramFloat + f3), paramPaint);
      aw.e(paramPaint);
      paramCharSequence = this.DWi.tGb;
      if (paramCharSequence != null)
      {
        paramPaint.setTextSize(this.DWi.DWo);
        paramFloat = paramPaint.measureText(this.DWi.DWm, 0, this.DWi.DWm.length());
        paramFloat = f2 + this.DWi.DWq + 1.0F + paramFloat;
        paramInt1 = (paramInt4 - this.DWi.DWt) / 2 + paramInt3;
        paramCharSequence.setBounds(new Rect((int)paramFloat, paramInt1, (int)(paramFloat + this.DWi.DWs), this.DWi.DWt + paramInt1));
        paramCharSequence.draw(paramCanvas);
      }
      paramPaint.setColor(paramInt2);
      paramPaint.setTextSize(f1);
      AppMethodBeat.o(358442);
      return;
      paramInt1 = 0;
      break;
      paramFloat = 0.0F;
      break label467;
    }
  }
  
  public final int ewo()
  {
    AppMethodBeat.i(358449);
    int i = this.DWi.ewr();
    AppMethodBeat.o(358449);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$Builder;", "", "()V", "params", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;", "getParams", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;", "setParams", "(Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;)V", "build", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan;", "setBgHeight", "bgHeight", "", "setFansName", "fansName", "", "setLeftIconHeight", "height", "setLeftIconWidth", "width", "setLeftMargin", "leftMargin", "setLevel", "userLevel", "config", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansConfig;", "setLevelTextSize", "levelSize", "setRightMargin", "rightMargin", "setServerBgColor", "serverColorStr", "setTextSize", "textSize", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a DWj;
    c.c DWi;
    
    static
    {
      AppMethodBeat.i(358349);
      DWj = new a((byte)0);
      AppMethodBeat.o(358349);
    }
    
    public a()
    {
      AppMethodBeat.i(358341);
      this.DWi = new c.c();
      AppMethodBeat.o(358341);
    }
    
    public final a a(int paramInt, b paramb)
    {
      AppMethodBeat.i(358376);
      s.u(paramb, "config");
      Object localObject1 = this.DWi;
      Object localObject2 = String.valueOf(paramInt);
      s.u(localObject2, "<set-?>");
      ((c.c)localObject1).sdL = ((String)localObject2);
      this.DWi.DWk = b.ewk();
      localObject1 = this.DWi;
      int i;
      label150:
      int m;
      label267:
      int n;
      switch (paramb.CId)
      {
      default: 
        localObject2 = h.DWP;
        i = h.ewD();
        ((c.c)localObject1).DWl = i;
        this.DWi.DWn = b.ewk();
        this.DWi.DWo = paramb.ewl();
        i = b.PJ(paramInt);
        localObject2 = this.DWi;
        if (i != 0)
        {
          localObject1 = (Drawable)new BitmapDrawable(MMApplicationContext.getResources(), BitmapUtil.getBitmapNative(i));
          ((c.c)localObject2).DWp = ((Drawable)localObject1);
          localObject2 = paramb.ewm();
          if (localObject2.length == 2)
          {
            this.DWi.DWq = localObject2[0];
            this.DWi.DWr = localObject2[1];
            localObject1 = a.DJT;
            a.hQ("FinderLiveLevelImageSpan", "setLevel iconSize:" + localObject2[0] + '-' + localObject2[1]);
          }
          paramInt = b.PK(paramInt);
          c.c localc = this.DWi;
          if (paramInt == 0) {
            break label519;
          }
          localObject1 = (Drawable)new BitmapDrawable(MMApplicationContext.getResources(), BitmapUtil.getBitmapNative(paramInt));
          localc.tGb = ((Drawable)localObject1);
          if ((this.DWi.tGb != null) && (localObject2.length == 2))
          {
            localObject1 = h.DWP;
            paramInt = h.ewJ();
            localObject1 = h.DWP;
            i = h.ewD();
            localObject1 = h.DWP;
            int j = h.ewK();
            localObject1 = h.DWP;
            int k = h.ewE();
            localObject1 = h.DWP;
            m = h.ewG();
            localObject1 = h.DWP;
            n = h.ewA();
            switch (paramb.CId)
            {
            case 1: 
            default: 
              localObject1 = new int[2];
              localObject1[0] = k;
              localObject1[1] = j;
            }
          }
        }
        break;
      }
      for (;;)
      {
        this.DWi.DWs = localObject1[0];
        this.DWi.DWt = localObject1[1];
        localObject1 = a.DJT;
        a.hQ("FinderLiveLevelImageSpan", "setLevel rightIconSize:" + localObject2[0] + '-' + localObject2[1]);
        this.DWi.pQi = paramb.ewn();
        this.DWi.bgColor = paramb.ewj();
        AppMethodBeat.o(358376);
        return this;
        localObject2 = h.DWP;
        i = h.ewF();
        break;
        localObject2 = h.DWP;
        i = h.ewA();
        break;
        localObject1 = null;
        break label150;
        label519:
        localObject1 = null;
        break label267;
        localObject1 = new int[2];
        localObject1[0] = i;
        localObject1[1] = paramInt;
        continue;
        localObject1 = new int[2];
        localObject1[0] = n;
        localObject1[1] = m;
      }
    }
    
    public final a ayd(String paramString)
    {
      AppMethodBeat.i(358383);
      c.c localc = this.DWi;
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      s.u(str, "<set-?>");
      localc.DWm = str;
      AppMethodBeat.o(358383);
      return this;
    }
    
    public final a aye(String paramString)
    {
      AppMethodBeat.i(358395);
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
          this.DWi.bgColor = Color.parseColor(paramString);
          AppMethodBeat.o(358395);
          return this;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.DWi.bgColor = 0;
            Log.e("FinderLiveFansSpan", localException + ",serverColor:" + paramString);
          }
        }
      }
    }
    
    public final c ewp()
    {
      AppMethodBeat.i(358402);
      Object localObject = h.DWP;
      localObject = new c(h.PP(this.DWi.ewr()));
      c.c localc = this.DWi;
      s.u(localc, "<set-?>");
      ((c)localObject).DWi = localc;
      AppMethodBeat.o(358402);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$Builder$Companion;", "", "()V", "DESIGN_ICON_HEIGH", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveFansSpan$FinderLiveFansSpanParams;", "", "level", "", "levelColor", "", "levelSize", "fansName", "fansNameColor", "fansNameSize", "leftIcon", "Landroid/graphics/drawable/Drawable;", "leftIconWidth", "leftIconHeight", "rightIcon", "rightIconWidth", "rightIconHeight", "bgColor", "bgHeight", "leftMargin", "rightMargin", "(Ljava/lang/String;IILjava/lang/String;IILandroid/graphics/drawable/Drawable;IILandroid/graphics/drawable/Drawable;IIIIII)V", "DEFAULT_MARGIN", "getDEFAULT_MARGIN", "()I", "backgroundWidth", "getBackgroundWidth", "setBackgroundWidth", "(I)V", "getBgColor", "setBgColor", "getBgHeight", "setBgHeight", "getFansName", "()Ljava/lang/String;", "setFansName", "(Ljava/lang/String;)V", "getFansNameColor", "setFansNameColor", "getFansNameSize", "setFansNameSize", "getLeftIcon", "()Landroid/graphics/drawable/Drawable;", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLeftIconHeight", "setLeftIconHeight", "getLeftIconWidth", "setLeftIconWidth", "getLeftMargin", "setLeftMargin", "getLevel", "setLevel", "getLevelColor", "setLevelColor", "getLevelSize", "setLevelSize", "getRightIcon", "setRightIcon", "getRightIconHeight", "setRightIconHeight", "getRightIconWidth", "setRightIconWidth", "getRightMargin", "setRightMargin", "spanWidth", "getSpanWidth", "setSpanWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    int DWk;
    int DWl;
    String DWm;
    int DWn;
    int DWo;
    Drawable DWp;
    int DWq;
    int DWr;
    int DWs;
    int DWt;
    private final int DWu;
    int bgColor;
    int bmt;
    private int bmu;
    int pQi;
    String sdL;
    Drawable tGb;
    
    private c(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
    {
      AppMethodBeat.i(358343);
      this.sdL = paramString1;
      this.DWk = paramInt1;
      this.DWl = paramInt2;
      this.DWm = paramString2;
      this.DWn = paramInt3;
      this.DWo = paramInt4;
      this.DWp = null;
      this.DWq = paramInt5;
      this.DWr = paramInt6;
      this.tGb = null;
      this.DWs = paramInt7;
      this.DWt = paramInt8;
      this.bgColor = paramInt9;
      this.pQi = paramInt10;
      this.bmt = paramInt11;
      this.bmu = paramInt12;
      this.DWu = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
      AppMethodBeat.o(358343);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(358403);
      if (this == paramObject)
      {
        AppMethodBeat.o(358403);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(358403);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.sdL, paramObject.sdL))
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWk != paramObject.DWk)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWl != paramObject.DWl)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (!s.p(this.DWm, paramObject.DWm))
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWn != paramObject.DWn)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWo != paramObject.DWo)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (!s.p(this.DWp, paramObject.DWp))
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWq != paramObject.DWq)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWr != paramObject.DWr)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (!s.p(this.tGb, paramObject.tGb))
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWs != paramObject.DWs)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.DWt != paramObject.DWt)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.bgColor != paramObject.bgColor)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.pQi != paramObject.pQi)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.bmt != paramObject.bmt)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      if (this.bmu != paramObject.bmu)
      {
        AppMethodBeat.o(358403);
        return false;
      }
      AppMethodBeat.o(358403);
      return true;
    }
    
    public final int ewq()
    {
      AppMethodBeat.i(358364);
      int i;
      if (this.DWp == null)
      {
        i = this.DWu;
        if (this.tGb != null) {
          break label71;
        }
      }
      label71:
      for (int j = this.DWu;; j = this.DWs)
      {
        float f = i;
        h localh = h.DWP;
        i = (int)(f + h.f(this.DWm, this.DWo) + j);
        AppMethodBeat.o(358364);
        return i;
        i = this.DWq;
        break;
      }
    }
    
    public final int ewr()
    {
      AppMethodBeat.i(358373);
      int i = ewq();
      int j = this.bmt;
      int k = this.bmu;
      AppMethodBeat.o(358373);
      return i + j + k;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(358392);
      int k = this.sdL.hashCode();
      int m = this.DWk;
      int n = this.DWl;
      int i1 = this.DWm.hashCode();
      int i2 = this.DWn;
      int i3 = this.DWo;
      int i;
      int i4;
      int i5;
      if (this.DWp == null)
      {
        i = 0;
        i4 = this.DWq;
        i5 = this.DWr;
        if (this.tGb != null) {
          break label220;
        }
      }
      for (;;)
      {
        int i6 = this.DWs;
        int i7 = this.DWt;
        int i8 = this.bgColor;
        int i9 = this.pQi;
        int i10 = this.bmt;
        int i11 = this.bmu;
        AppMethodBeat.o(358392);
        return (((((((((i + (((((k * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31) * 31 + i4) * 31 + i5) * 31 + j) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11;
        i = this.DWp.hashCode();
        break;
        label220:
        j = this.tGb.hashCode();
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(358385);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FinderLiveFansSpanParams(level=").append(this.sdL).append(", levelColor=").append(this.DWk).append(", levelSize=").append(this.DWl).append(", fansName=").append(this.DWm).append(", fansNameColor=").append(this.DWn).append(", fansNameSize=").append(this.DWo).append(", leftIcon=").append(this.DWp).append(", leftIconWidth=").append(this.DWq).append(", leftIconHeight=").append(this.DWr).append(", rightIcon=").append(this.tGb).append(", rightIconWidth=").append(this.DWs).append(", rightIconHeight=");
      ((StringBuilder)localObject).append(this.DWt).append(", bgColor=").append(this.bgColor).append(", bgHeight=").append(this.pQi).append(", leftMargin=").append(this.bmt).append(", rightMargin=").append(this.bmu).append(')');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(358385);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.c
 * JD-Core Version:    0.7.0.1
 */