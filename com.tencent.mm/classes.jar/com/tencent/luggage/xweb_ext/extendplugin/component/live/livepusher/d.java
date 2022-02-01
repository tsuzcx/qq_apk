package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "highLightAlpha", "", "shadowAlpha", "highLightContourPath", "", "highLightContourPathMd5", "shadowContourPath", "shadowContourPathMd5", "faceModel", "", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFaceModel", "()I", "getHighLightAlpha", "()F", "getHighLightContourPath", "()Ljava/lang/String;", "getHighLightContourPathMd5", "getShadowAlpha", "getShadowContourPath", "getShadowContourPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class d
  implements h
{
  public final int cGc;
  public final float cGt;
  public final float cGu;
  public final String cGv;
  private final String cGw;
  public final String cGx;
  private final String cGy;
  
  public d(float paramFloat1, float paramFloat2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(215931);
    this.cGt = paramFloat1;
    this.cGu = paramFloat2;
    this.cGv = paramString1;
    this.cGw = paramString2;
    this.cGx = paramString3;
    this.cGy = paramString4;
    this.cGc = paramInt;
    AppMethodBeat.o(215931);
  }
  
  public final String Qc()
  {
    AppMethodBeat.i(215930);
    String str = "FaceContourInfo(highLightContourPath='" + this.cGv + "', highLightContourPathMd5='" + this.cGw + "', shadowContourPath='" + this.cGx + "', shadowContourPathMd5='" + this.cGy + '\'' + ")";
    AppMethodBeat.o(215930);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215934);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((Float.compare(this.cGt, paramObject.cGt) != 0) || (Float.compare(this.cGu, paramObject.cGu) != 0) || (!p.j(this.cGv, paramObject.cGv)) || (!p.j(this.cGw, paramObject.cGw)) || (!p.j(this.cGx, paramObject.cGx)) || (!p.j(this.cGy, paramObject.cGy)) || (this.cGc != paramObject.cGc)) {}
      }
    }
    else
    {
      AppMethodBeat.o(215934);
      return true;
    }
    AppMethodBeat.o(215934);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(215933);
    int n = Float.floatToIntBits(this.cGt);
    int i1 = Float.floatToIntBits(this.cGu);
    String str = this.cGv;
    int i;
    int j;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cGw;
      if (str == null) {
        break label147;
      }
      j = str.hashCode();
      label60:
      str = this.cGx;
      if (str == null) {
        break label152;
      }
    }
    label147:
    label152:
    for (int k = str.hashCode();; k = 0)
    {
      str = this.cGy;
      if (str != null) {
        m = str.hashCode();
      }
      int i2 = this.cGc;
      AppMethodBeat.o(215933);
      return ((k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label60;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215932);
    String str = "FaceContourInfo(highLightAlpha=" + this.cGt + ", shadowAlpha=" + this.cGu + ", highLightContourPath=" + this.cGv + ", highLightContourPathMd5=" + this.cGw + ", shadowContourPath=" + this.cGx + ", shadowContourPathMd5=" + this.cGy + ", faceModel=" + this.cGc + ")";
    AppMethodBeat.o(215932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d
 * JD-Core Version:    0.7.0.1
 */