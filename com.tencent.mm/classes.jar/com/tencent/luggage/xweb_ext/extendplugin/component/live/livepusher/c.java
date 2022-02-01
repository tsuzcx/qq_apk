package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "faceModel", "", "blendMode", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "path", "", "pathMd5", "shrinkRate", "(FILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;Ljava/lang/String;Ljava/lang/String;F)V", "getAlpha", "()F", "getBlendMode", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "getFaceModel", "()I", "getPath", "()Ljava/lang/String;", "getPathMd5", "getShrinkRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements i
{
  public final float alpha;
  public final int eAs;
  public final a eAt;
  private final String eAu;
  public final float eAv;
  public final String path;
  
  public c(float paramFloat1, int paramInt, a parama, String paramString1, String paramString2, float paramFloat2)
  {
    AppMethodBeat.i(220799);
    this.alpha = paramFloat1;
    this.eAs = paramInt;
    this.eAt = parama;
    this.path = paramString1;
    this.eAu = paramString2;
    this.eAv = paramFloat2;
    AppMethodBeat.o(220799);
  }
  
  public final String aui()
  {
    AppMethodBeat.i(220807);
    String str = "EyeBrowInfo(path='" + this.path + "', pathMd5='" + this.eAu + "')";
    AppMethodBeat.o(220807);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220836);
    if (this == paramObject)
    {
      AppMethodBeat.o(220836);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(220836);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(220836);
      return false;
    }
    if (this.eAs != paramObject.eAs)
    {
      AppMethodBeat.o(220836);
      return false;
    }
    if (this.eAt != paramObject.eAt)
    {
      AppMethodBeat.o(220836);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(220836);
      return false;
    }
    if (!s.p(this.eAu, paramObject.eAu))
    {
      AppMethodBeat.o(220836);
      return false;
    }
    if (!s.p(Float.valueOf(this.eAv), Float.valueOf(paramObject.eAv)))
    {
      AppMethodBeat.o(220836);
      return false;
    }
    AppMethodBeat.o(220836);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220824);
    int j = Float.floatToIntBits(this.alpha);
    int k = this.eAs;
    int m = this.eAt.hashCode();
    int n = this.path.hashCode();
    if (this.eAu == null) {}
    for (int i = 0;; i = this.eAu.hashCode())
    {
      int i1 = Float.floatToIntBits(this.eAv);
      AppMethodBeat.o(220824);
      return (i + (((j * 31 + k) * 31 + m) * 31 + n) * 31) * 31 + i1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220815);
    String str = "EyeBrowInfo(alpha=" + this.alpha + ", faceModel=" + this.eAs + ", blendMode=" + this.eAt + ", path=" + this.path + ", pathMd5=" + this.eAu + ", shrinkRate=" + this.eAv + ')';
    AppMethodBeat.o(220815);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c
 * JD-Core Version:    0.7.0.1
 */