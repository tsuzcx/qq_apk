package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftMaskPath", "", "leftMaskPathMd5", "rightMaskPath", "rightMaskPathMd5", "shimmerPosPath", "shimmerPosPathMd5", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getLeftMaskPath", "()Ljava/lang/String;", "getLeftMaskPathMd5", "getRightMaskPath", "getRightMaskPathMd5", "getShimmerPosPath", "getShimmerPosPathMd5", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "", "toString", "EyeShadowType", "luggage-xweb-ext_release"})
public final class c
  implements h
{
  public final float alpha;
  private final c.a cGj;
  public final String cGk;
  private final String cGl;
  public final String cGm;
  private final String cGn;
  public final String cGo;
  private final String cGp;
  
  public c(float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(215926);
    this.alpha = paramFloat;
    this.cGk = paramString1;
    this.cGl = paramString2;
    this.cGm = paramString3;
    this.cGn = paramString4;
    this.cGo = paramString5;
    this.cGp = paramString6;
    paramString1 = (CharSequence)this.cGo;
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label124;
      }
    }
    label124:
    for (paramString1 = c.a.cGq;; paramString1 = c.a.cGr)
    {
      this.cGj = paramString1;
      AppMethodBeat.o(215926);
      return;
      i = 0;
      break;
    }
  }
  
  public final String Qc()
  {
    AppMethodBeat.i(215925);
    String str = "EyeShadowInfo(leftMaskPath='" + this.cGk + "', leftMaskPathMd5='" + this.cGl + "', rightMaskPath='" + this.cGm + "', rightMaskPathMd5='" + this.cGn + "', shimmerPosPath=" + this.cGo + ", shimmerPosPathMd5='" + this.cGp + '\'' + ")";
    AppMethodBeat.o(215925);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215929);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.j(this.cGk, paramObject.cGk)) || (!p.j(this.cGl, paramObject.cGl)) || (!p.j(this.cGm, paramObject.cGm)) || (!p.j(this.cGn, paramObject.cGn)) || (!p.j(this.cGo, paramObject.cGo)) || (!p.j(this.cGp, paramObject.cGp))) {}
      }
    }
    else
    {
      AppMethodBeat.o(215929);
      return true;
    }
    AppMethodBeat.o(215929);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(215928);
    int i2 = Float.floatToIntBits(this.alpha);
    String str = this.cGk;
    int i;
    int j;
    label51:
    int k;
    label68:
    int m;
    if (str != null)
    {
      i = str.hashCode();
      str = this.cGl;
      if (str == null) {
        break label168;
      }
      j = str.hashCode();
      str = this.cGm;
      if (str == null) {
        break label173;
      }
      k = str.hashCode();
      str = this.cGn;
      if (str == null) {
        break label178;
      }
      m = str.hashCode();
      label86:
      str = this.cGo;
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
      str = this.cGp;
      if (str != null) {
        i1 = str.hashCode();
      }
      AppMethodBeat.o(215928);
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
    AppMethodBeat.i(215927);
    String str = "EyeShadowInfo(alpha=" + this.alpha + ", leftMaskPath=" + this.cGk + ", leftMaskPathMd5=" + this.cGl + ", rightMaskPath=" + this.cGm + ", rightMaskPathMd5=" + this.cGn + ", shimmerPosPath=" + this.cGo + ", shimmerPosPathMd5=" + this.cGp + ")";
    AppMethodBeat.o(215927);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c
 * JD-Core Version:    0.7.0.1
 */