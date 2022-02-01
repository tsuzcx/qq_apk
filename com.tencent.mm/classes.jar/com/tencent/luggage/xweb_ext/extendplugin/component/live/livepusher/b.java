package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftEyeBrowPath", "", "leftEyeBrowPathMd5", "rightEyeBrowPath", "rightEyeBrowPathMd5", "faceModel", "", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftEyeBrowPath", "()Ljava/lang/String;", "getLeftEyeBrowPathMd5", "getRightEyeBrowPath", "getRightEyeBrowPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class b
  implements h
{
  public final float alpha;
  public final int cGc;
  public final String cGf;
  private final String cGg;
  public final String cGh;
  private final String cGi;
  
  public b(float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(215918);
    this.alpha = paramFloat;
    this.cGf = paramString1;
    this.cGg = paramString2;
    this.cGh = paramString3;
    this.cGi = paramString4;
    this.cGc = paramInt;
    AppMethodBeat.o(215918);
  }
  
  public final String Qc()
  {
    AppMethodBeat.i(215917);
    String str = "EyeBrowInfo(leftEyeBrowPath='" + this.cGf + "', leftEyeBrowPathMd5='" + this.cGg + "', rightEyeBrowPath='" + this.cGh + "', rightEyeBrowPathMd5='" + this.cGi + '\'' + ")";
    AppMethodBeat.o(215917);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215921);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.j(this.cGf, paramObject.cGf)) || (!p.j(this.cGg, paramObject.cGg)) || (!p.j(this.cGh, paramObject.cGh)) || (!p.j(this.cGi, paramObject.cGi)) || (this.cGc != paramObject.cGc)) {}
      }
    }
    else
    {
      AppMethodBeat.o(215921);
      return true;
    }
    AppMethodBeat.o(215921);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(215920);
    int n = Float.floatToIntBits(this.alpha);
    String str = this.cGf;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cGg;
      if (str == null) {
        break label132;
      }
      j = str.hashCode();
      label51:
      str = this.cGh;
      if (str == null) {
        break label137;
      }
    }
    label132:
    label137:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.cGi;
      if (str != null) {
        m = str.hashCode();
      }
      int i1 = this.cGc;
      AppMethodBeat.o(215920);
      return ((k + (j + (i + n * 31) * 31) * 31) * 31 + m) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label51;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215919);
    String str = "EyeBrowInfo(alpha=" + this.alpha + ", leftEyeBrowPath=" + this.cGf + ", leftEyeBrowPathMd5=" + this.cGg + ", rightEyeBrowPath=" + this.cGh + ", rightEyeBrowPathMd5=" + this.cGi + ", faceModel=" + this.cGc + ")";
    AppMethodBeat.o(215919);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
 * JD-Core Version:    0.7.0.1
 */