package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftMaskPath", "", "leftMaskPathMd5", "rightMaskPath", "rightMaskPathMd5", "shimmerPosPath", "shimmerPosPathMd5", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getLeftMaskPath", "()Ljava/lang/String;", "getLeftMaskPathMd5", "getRightMaskPath", "getRightMaskPathMd5", "getShimmerPosPath", "getShimmerPosPathMd5", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "", "toString", "EyeShadowType", "luggage-xweb-ext_release"})
public final class c
  implements h
{
  public final float alpha;
  private final a cGP;
  public final String cGQ;
  private final String cGR;
  public final String cGS;
  private final String cGT;
  public final String cGU;
  private final String cGV;
  
  public c(float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(225098);
    this.alpha = paramFloat;
    this.cGQ = paramString1;
    this.cGR = paramString2;
    this.cGS = paramString3;
    this.cGT = paramString4;
    this.cGU = paramString5;
    this.cGV = paramString6;
    paramString1 = (CharSequence)this.cGU;
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label124;
      }
    }
    label124:
    for (paramString1 = a.cGW;; paramString1 = a.cGX)
    {
      this.cGP = paramString1;
      AppMethodBeat.o(225098);
      return;
      i = 0;
      break;
    }
  }
  
  public final String TD()
  {
    AppMethodBeat.i(225094);
    String str = "EyeShadowInfo(leftMaskPath='" + this.cGQ + "', leftMaskPathMd5='" + this.cGR + "', rightMaskPath='" + this.cGS + "', rightMaskPathMd5='" + this.cGT + "', shimmerPosPath=" + this.cGU + ", shimmerPosPathMd5='" + this.cGV + '\'' + ")";
    AppMethodBeat.o(225094);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225110);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.h(this.cGQ, paramObject.cGQ)) || (!p.h(this.cGR, paramObject.cGR)) || (!p.h(this.cGS, paramObject.cGS)) || (!p.h(this.cGT, paramObject.cGT)) || (!p.h(this.cGU, paramObject.cGU)) || (!p.h(this.cGV, paramObject.cGV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(225110);
      return true;
    }
    AppMethodBeat.o(225110);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(225108);
    int i2 = Float.floatToIntBits(this.alpha);
    String str = this.cGQ;
    int i;
    int j;
    label51:
    int k;
    label68:
    int m;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cGR;
      if (str == null) {
        break label168;
      }
      j = str.hashCode();
      str = this.cGS;
      if (str == null) {
        break label173;
      }
      k = str.hashCode();
      str = this.cGT;
      if (str == null) {
        break label178;
      }
      m = str.hashCode();
      label86:
      str = this.cGU;
      if (str == null) {
        break label184;
      }
    }
    label168:
    label173:
    label178:
    label184:
    for (int n = str.hashCode();; n = 0)
    {
      str = this.cGV;
      if (str != null) {
        i1 = str.hashCode();
      }
      AppMethodBeat.o(225108);
      return (n + (m + (k + (j + (i + i2 * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label68;
      m = 0;
      break label86;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225103);
    String str = "EyeShadowInfo(alpha=" + this.alpha + ", leftMaskPath=" + this.cGQ + ", leftMaskPathMd5=" + this.cGR + ", rightMaskPath=" + this.cGS + ", rightMaskPathMd5=" + this.cGT + ", shimmerPosPath=" + this.cGU + ", shimmerPosPathMd5=" + this.cGV + ")";
    AppMethodBeat.o(225103);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "FINE_FLASH", "luggage-xweb-ext_release"})
  public static enum a
  {
    private final int jsonVal;
    
    static
    {
      AppMethodBeat.i(226065);
      a locala1 = new a("MATTE", 0, 0);
      cGW = locala1;
      a locala2 = new a("FINE_FLASH", 1, 1);
      cGX = locala2;
      cGY = new a[] { locala1, locala2 };
      AppMethodBeat.o(226065);
    }
    
    private a(int paramInt)
    {
      this.jsonVal = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c
 * JD-Core Version:    0.7.0.1
 */