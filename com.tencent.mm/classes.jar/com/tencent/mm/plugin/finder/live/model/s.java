package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpanConfig;", "", "normalText", "", "italicText", "leftMargin", "", "rightMargin", "leftPading", "", "rightPading", "bgColor", "bgHeight", "textColor", "textSize", "radius", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIFFIIIII)V", "getBgColor", "()I", "setBgColor", "(I)V", "getBgHeight", "setBgHeight", "getItalicText", "()Ljava/lang/CharSequence;", "setItalicText", "(Ljava/lang/CharSequence;)V", "getLeftMargin", "setLeftMargin", "getLeftPading", "()F", "setLeftPading", "(F)V", "getNormalText", "setNormalText", "getRadius", "setRadius", "getRightMargin", "setRightMargin", "getRightPading", "setRightPading", "getTextColor", "setTextColor", "getTextSize", "setTextSize", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class s
{
  public int Gp;
  public int Gq;
  public int bgColor;
  public int mTB;
  private int radius;
  public int textColor;
  public int textSize;
  public CharSequence yfW;
  public CharSequence yfX;
  public float yfY;
  public float yfZ;
  
  private s(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(290217);
    this.yfW = paramCharSequence1;
    this.yfX = paramCharSequence2;
    this.Gp = 0;
    this.Gq = paramInt1;
    this.yfY = paramFloat1;
    this.yfZ = paramFloat2;
    this.bgColor = 0;
    this.mTB = paramInt2;
    this.textColor = paramInt3;
    this.textSize = paramInt4;
    this.radius = paramInt5;
    AppMethodBeat.o(290217);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290221);
    if (this != paramObject)
    {
      if ((paramObject instanceof s))
      {
        paramObject = (s)paramObject;
        if ((!p.h(this.yfW, paramObject.yfW)) || (!p.h(this.yfX, paramObject.yfX)) || (this.Gp != paramObject.Gp) || (this.Gq != paramObject.Gq) || (Float.compare(this.yfY, paramObject.yfY) != 0) || (Float.compare(this.yfZ, paramObject.yfZ) != 0) || (this.bgColor != paramObject.bgColor) || (this.mTB != paramObject.mTB) || (this.textColor != paramObject.textColor) || (this.textSize != paramObject.textSize) || (this.radius != paramObject.radius)) {}
      }
    }
    else
    {
      AppMethodBeat.o(290221);
      return true;
    }
    AppMethodBeat.o(290221);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(290220);
    CharSequence localCharSequence = this.yfW;
    if (localCharSequence != null) {}
    for (int i = localCharSequence.hashCode();; i = 0)
    {
      localCharSequence = this.yfX;
      if (localCharSequence != null) {
        j = localCharSequence.hashCode();
      }
      int k = this.Gp;
      int m = this.Gq;
      int n = Float.floatToIntBits(this.yfY);
      int i1 = Float.floatToIntBits(this.yfZ);
      int i2 = this.bgColor;
      int i3 = this.mTB;
      int i4 = this.textColor;
      int i5 = this.textSize;
      int i6 = this.radius;
      AppMethodBeat.o(290220);
      return (((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290219);
    String str = "FinderLiveItalicImageSpanConfig(normalText=" + this.yfW + ", italicText=" + this.yfX + ", leftMargin=" + this.Gp + ", rightMargin=" + this.Gq + ", leftPading=" + this.yfY + ", rightPading=" + this.yfZ + ", bgColor=" + this.bgColor + ", bgHeight=" + this.mTB + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", radius=" + this.radius + ")";
    AppMethodBeat.o(290219);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.s
 * JD-Core Version:    0.7.0.1
 */