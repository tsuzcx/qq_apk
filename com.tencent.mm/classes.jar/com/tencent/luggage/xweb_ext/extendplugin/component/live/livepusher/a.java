package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "leftBlusherPath", "", "leftBlusherPathMd5", "rightBlusherPath", "rightBlusherPathMd5", "faceModel", "", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftBlusherPath", "()Ljava/lang/String;", "getLeftBlusherPathMd5", "getRightBlusherPath", "getRightBlusherPathMd5", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "BlusherStickType", "luggage-xweb-ext_release"})
public final class a
  implements h
{
  public final float alpha;
  public final a.a cGD;
  public final String cGE;
  private final String cGF;
  public final String cGG;
  private final String cGH;
  public final int cGI;
  
  public a(float paramFloat, a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(226668);
    this.alpha = paramFloat;
    this.cGD = parama;
    this.cGE = paramString1;
    this.cGF = paramString2;
    this.cGG = paramString3;
    this.cGH = paramString4;
    this.cGI = paramInt;
    AppMethodBeat.o(226668);
  }
  
  public final String TD()
  {
    AppMethodBeat.i(226664);
    String str = "BlusherStickInfo(leftBlusherPath='" + this.cGE + "', leftBlusherPathMd5='" + this.cGF + "', rightBlusherPath='" + this.cGG + "', rightBlusherPathMd5='" + this.cGH + '\'' + ")";
    AppMethodBeat.o(226664);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(226678);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.h(this.cGD, paramObject.cGD)) || (!p.h(this.cGE, paramObject.cGE)) || (!p.h(this.cGF, paramObject.cGF)) || (!p.h(this.cGG, paramObject.cGG)) || (!p.h(this.cGH, paramObject.cGH)) || (this.cGI != paramObject.cGI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(226678);
      return true;
    }
    AppMethodBeat.o(226678);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(226673);
    int i1 = Float.floatToIntBits(this.alpha);
    Object localObject = this.cGD;
    int i;
    int j;
    label51:
    int k;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.cGE;
      if (localObject == null) {
        break label156;
      }
      j = localObject.hashCode();
      localObject = this.cGF;
      if (localObject == null) {
        break label161;
      }
      k = localObject.hashCode();
      label68:
      localObject = this.cGG;
      if (localObject == null) {
        break label166;
      }
    }
    label156:
    label161:
    label166:
    for (int m = localObject.hashCode();; m = 0)
    {
      localObject = this.cGH;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      int i2 = this.cGI;
      AppMethodBeat.o(226673);
      return ((m + (k + (j + (i + i1 * 31) * 31) * 31) * 31) * 31 + n) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label68;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226671);
    String str = "BlusherStickInfo(alpha=" + this.alpha + ", type=" + this.cGD + ", leftBlusherPath=" + this.cGE + ", leftBlusherPathMd5=" + this.cGF + ", rightBlusherPath=" + this.cGG + ", rightBlusherPathMd5=" + this.cGH + ", faceModel=" + this.cGI + ")";
    AppMethodBeat.o(226671);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
 * JD-Core Version:    0.7.0.1
 */