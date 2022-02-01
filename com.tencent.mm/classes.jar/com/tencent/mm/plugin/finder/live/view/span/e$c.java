package com.tencent.mm.plugin.finder.live.view.span;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveLevelImageSpan$FinderLiveImageSpanParams;", "", "leftMargin", "", "rightMargin", "leftPading", "rightPading", "itemPading", "bgColor", "bgDrawableId", "bgHeight", "bgRadius", "text", "", "textColor", "textSize", "textBold", "", "leftIcon", "Landroid/graphics/drawable/Drawable;", "leftIconWidth", "leftIconHeight", "leftIconColor", "(IIIIIIIIILjava/lang/CharSequence;IIZLandroid/graphics/drawable/Drawable;III)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgDrawableId", "setBgDrawableId", "getBgHeight", "setBgHeight", "getBgRadius", "setBgRadius", "getItemPading", "setItemPading", "getLeftIcon", "()Landroid/graphics/drawable/Drawable;", "setLeftIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLeftIconColor", "setLeftIconColor", "getLeftIconHeight", "setLeftIconHeight", "getLeftIconWidth", "setLeftIconWidth", "getLeftMargin", "setLeftMargin", "getLeftPading", "setLeftPading", "getRightMargin", "setRightMargin", "getRightPading", "setRightPading", "spanWidth", "getSpanWidth", "setSpanWidth", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextBold", "()Z", "setTextBold", "(Z)V", "getTextColor", "setTextColor", "getTextSize", "setTextSize", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$c
{
  int DWA;
  int DWB;
  int DWC;
  boolean DWD;
  int DWE;
  public int DWF;
  Drawable DWp;
  int DWq;
  int DWr;
  int DWz;
  CharSequence bba;
  int bgColor;
  int bgRadius;
  int bmt;
  int bmu;
  int pQi;
  int textColor;
  int textSize;
  
  private e$c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CharSequence paramCharSequence, int paramInt7, int paramInt8, int paramInt9)
  {
    AppMethodBeat.i(358329);
    this.bmt = 0;
    this.bmu = paramInt1;
    this.DWz = paramInt2;
    this.DWA = paramInt3;
    this.DWB = paramInt4;
    this.bgColor = 0;
    this.DWC = 0;
    this.pQi = paramInt5;
    this.bgRadius = paramInt6;
    this.bba = paramCharSequence;
    this.textColor = 0;
    this.textSize = paramInt7;
    this.DWD = false;
    this.DWp = null;
    this.DWq = paramInt8;
    this.DWr = paramInt9;
    this.DWE = 0;
    AppMethodBeat.o(358329);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(358368);
    if (this == paramObject)
    {
      AppMethodBeat.o(358368);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(358368);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.bmt != paramObject.bmt)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.bmu != paramObject.bmu)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWz != paramObject.DWz)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWA != paramObject.DWA)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWB != paramObject.DWB)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.bgColor != paramObject.bgColor)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWC != paramObject.DWC)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.pQi != paramObject.pQi)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.bgRadius != paramObject.bgRadius)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (!s.p(this.bba, paramObject.bba))
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.textColor != paramObject.textColor)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.textSize != paramObject.textSize)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWD != paramObject.DWD)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (!s.p(this.DWp, paramObject.DWp))
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWq != paramObject.DWq)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWr != paramObject.DWr)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    if (this.DWE != paramObject.DWE)
    {
      AppMethodBeat.o(358368);
      return false;
    }
    AppMethodBeat.o(358368);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(358346);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FinderLiveImageSpanParams(leftMargin=").append(this.bmt).append(", rightMargin=").append(this.bmu).append(", leftPading=").append(this.DWz).append(", rightPading=").append(this.DWA).append(", itemPading=").append(this.DWB).append(", bgColor=").append(this.bgColor).append(", bgDrawableId=").append(this.DWC).append(", bgHeight=").append(this.pQi).append(", bgRadius=").append(this.bgRadius).append(", text=").append(this.bba).append(", textColor=").append(this.textColor).append(", textSize=");
    ((StringBuilder)localObject).append(this.textSize).append(", textBold=").append(this.DWD).append(", leftIcon=").append(this.DWp).append(", leftIconWidth=").append(this.DWq).append(", leftIconHeight=").append(this.DWr).append(", leftIconColor=").append(this.DWE).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(358346);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.span.e.c
 * JD-Core Version:    0.7.0.1
 */