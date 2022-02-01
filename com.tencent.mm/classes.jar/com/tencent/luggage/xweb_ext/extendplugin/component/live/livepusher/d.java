package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "highLightAlpha", "", "shadowAlpha", "highLightContourPath", "", "highLightContourPathMd5", "shadowContourPath", "shadowContourPathMd5", "faceModel", "", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFaceModel", "()I", "getHighLightAlpha", "()F", "getHighLightContourPath", "()Ljava/lang/String;", "getHighLightContourPathMd5", "getShadowAlpha", "getShadowContourPath", "getShadowContourPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class d
  implements h
{
  public final int cGI;
  public final float cGZ;
  public final float cHa;
  public final String cHb;
  private final String cHc;
  public final String cHd;
  private final String cHe;
  
  public d(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(221947);
    this.cGZ = paramFloat1;
    this.cHa = paramFloat2;
    this.cHb = paramString1;
    this.cHc = paramString2;
    this.cHd = paramString3;
    this.cHe = paramString4;
    this.cGI = paramInt;
    AppMethodBeat.o(221947);
  }
  
  public final String TD()
  {
    AppMethodBeat.i(221945);
    String str = "FaceContourInfo(highLightContourPath='" + this.cHb + "', highLightContourPathMd5='" + this.cHc + "', shadowContourPath='" + this.cHd + "', shadowContourPathMd5='" + this.cHe + '\'' + ")";
    AppMethodBeat.o(221945);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221959);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((Float.compare(this.cGZ, paramObject.cGZ) != 0) || (Float.compare(this.cHa, paramObject.cHa) != 0) || (!p.h(this.cHb, paramObject.cHb)) || (!p.h(this.cHc, paramObject.cHc)) || (!p.h(this.cHd, paramObject.cHd)) || (!p.h(this.cHe, paramObject.cHe)) || (this.cGI != paramObject.cGI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(221959);
      return true;
    }
    AppMethodBeat.o(221959);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(221955);
    int n = Float.floatToIntBits(this.cGZ);
    int i1 = Float.floatToIntBits(this.cHa);
    String str = this.cHb;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cHc;
      if (str == null) {
        break label147;
      }
      j = str.hashCode();
      label60:
      str = this.cHd;
      if (str == null) {
        break label152;
      }
    }
    label147:
    label152:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.cHe;
      if (str != null) {
        m = str.hashCode();
      }
      int i2 = this.cGI;
      AppMethodBeat.o(221955);
      return ((k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label60;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221950);
    String str = "FaceContourInfo(highLightAlpha=" + this.cGZ + ", shadowAlpha=" + this.cHa + ", highLightContourPath=" + this.cHb + ", highLightContourPathMd5=" + this.cHc + ", shadowContourPath=" + this.cHd + ", shadowContourPathMd5=" + this.cHe + ", faceModel=" + this.cGI + ")";
    AppMethodBeat.o(221950);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d
 * JD-Core Version:    0.7.0.1
 */