package com.tencent.mm.plugin.finder.live.model;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveImageSpanParams;", "", "leftMargin", "", "rightMargin", "leftPading", "rightPading", "itemPading", "bgColor", "bgDrawableId", "bgHeight", "bgRadius", "text", "", "textColor", "textSize", "textBold", "", "leftIcon", "Landroid/graphics/drawable/Drawable;", "leftIconSize", "leftIconColor", "(IIIIIIIIILjava/lang/CharSequence;IIZLandroid/graphics/drawable/Drawable;II)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgDrawableId", "setBgDrawableId", "getBgHeight", "setBgHeight", "getBgRadius", "setBgRadius", "getItemPading", "setItemPading", "getLeftIcon", "()Landroid/graphics/drawable/Drawable;", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLeftIconColor", "setLeftIconColor", "getLeftIconSize", "setLeftIconSize", "getLeftMargin", "setLeftMargin", "getLeftPading", "setLeftPading", "getRightMargin", "setRightMargin", "getRightPading", "setRightPading", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextBold", "()Z", "setTextBold", "(Z)V", "getTextColor", "setTextColor", "getTextSize", "setTextSize", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class p
{
  int Gp;
  int Gq;
  CharSequence LV;
  int bgColor;
  int bgRadius;
  int mTB;
  int textColor;
  int textSize;
  int yfF;
  int yfG;
  int yfH;
  int yfI;
  boolean yfJ;
  Drawable yfK;
  int yfL;
  int yfM;
  
  private p(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CharSequence paramCharSequence, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(277530);
    this.Gp = 0;
    this.Gq = paramInt1;
    this.yfF = paramInt2;
    this.yfG = paramInt3;
    this.yfH = paramInt4;
    this.bgColor = 0;
    this.yfI = 0;
    this.mTB = paramInt5;
    this.bgRadius = paramInt6;
    this.LV = paramCharSequence;
    this.textColor = 0;
    this.textSize = paramInt7;
    this.yfJ = false;
    this.yfK = null;
    this.yfL = paramInt8;
    this.yfM = 0;
    AppMethodBeat.o(277530);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(277534);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.Gp != paramObject.Gp) || (this.Gq != paramObject.Gq) || (this.yfF != paramObject.yfF) || (this.yfG != paramObject.yfG) || (this.yfH != paramObject.yfH) || (this.bgColor != paramObject.bgColor) || (this.yfI != paramObject.yfI) || (this.mTB != paramObject.mTB) || (this.bgRadius != paramObject.bgRadius) || (!kotlin.g.b.p.h(this.LV, paramObject.LV)) || (this.textColor != paramObject.textColor) || (this.textSize != paramObject.textSize) || (this.yfJ != paramObject.yfJ) || (!kotlin.g.b.p.h(this.yfK, paramObject.yfK)) || (this.yfL != paramObject.yfL) || (this.yfM != paramObject.yfM)) {}
      }
    }
    else
    {
      AppMethodBeat.o(277534);
      return true;
    }
    AppMethodBeat.o(277534);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(277532);
    String str = "FinderLiveImageSpanParams(leftMargin=" + this.Gp + ", rightMargin=" + this.Gq + ", leftPading=" + this.yfF + ", rightPading=" + this.yfG + ", itemPading=" + this.yfH + ", bgColor=" + this.bgColor + ", bgDrawableId=" + this.yfI + ", bgHeight=" + this.mTB + ", bgRadius=" + this.bgRadius + ", text=" + this.LV + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", textBold=" + this.yfJ + ", leftIcon=" + this.yfK + ", leftIconSize=" + this.yfL + ", leftIconColor=" + this.yfM + ")";
    AppMethodBeat.o(277532);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.p
 * JD-Core Version:    0.7.0.1
 */