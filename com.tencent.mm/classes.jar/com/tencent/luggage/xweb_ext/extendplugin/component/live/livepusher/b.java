package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftEyeBrowPath", "", "leftEyeBrowPathMd5", "rightEyeBrowPath", "rightEyeBrowPathMd5", "faceModel", "", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftEyeBrowPath", "()Ljava/lang/String;", "getLeftEyeBrowPathMd5", "getRightEyeBrowPath", "getRightEyeBrowPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class b
  implements h
{
  public final float alpha;
  public final int cGI;
  public final String cGL;
  private final String cGM;
  public final String cGN;
  private final String cGO;
  
  public b(float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(226274);
    this.alpha = paramFloat;
    this.cGL = paramString1;
    this.cGM = paramString2;
    this.cGN = paramString3;
    this.cGO = paramString4;
    this.cGI = paramInt;
    AppMethodBeat.o(226274);
  }
  
  public final String TD()
  {
    AppMethodBeat.i(226271);
    String str = "EyeBrowInfo(leftEyeBrowPath='" + this.cGL + "', leftEyeBrowPathMd5='" + this.cGM + "', rightEyeBrowPath='" + this.cGN + "', rightEyeBrowPathMd5='" + this.cGO + '\'' + ")";
    AppMethodBeat.o(226271);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(226277);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.h(this.cGL, paramObject.cGL)) || (!p.h(this.cGM, paramObject.cGM)) || (!p.h(this.cGN, paramObject.cGN)) || (!p.h(this.cGO, paramObject.cGO)) || (this.cGI != paramObject.cGI)) {}
      }
    }
    else
    {
      AppMethodBeat.o(226277);
      return true;
    }
    AppMethodBeat.o(226277);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(226276);
    int n = Float.floatToIntBits(this.alpha);
    String str = this.cGL;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cGM;
      if (str == null) {
        break label132;
      }
      j = str.hashCode();
      label51:
      str = this.cGN;
      if (str == null) {
        break label137;
      }
    }
    label132:
    label137:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.cGO;
      if (str != null) {
        m = str.hashCode();
      }
      int i1 = this.cGI;
      AppMethodBeat.o(226276);
      return ((k + (j + (i + n * 31) * 31) * 31) * 31 + m) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label51;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226275);
    String str = "EyeBrowInfo(alpha=" + this.alpha + ", leftEyeBrowPath=" + this.cGL + ", leftEyeBrowPathMd5=" + this.cGM + ", rightEyeBrowPath=" + this.cGN + ", rightEyeBrowPathMd5=" + this.cGO + ", faceModel=" + this.cGI + ")";
    AppMethodBeat.o(226275);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
 * JD-Core Version:    0.7.0.1
 */