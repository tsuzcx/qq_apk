package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "faceModel", "", "blendMode", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "path", "", "pathMd5", "(FILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getBlendMode", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "getFaceModel", "()I", "getPath", "()Ljava/lang/String;", "getPathMd5", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements i
{
  public final float alpha;
  public final int eAs;
  public final a eAt;
  private final String eAu;
  public final String path;
  
  public b(float paramFloat, int paramInt, a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220795);
    this.alpha = paramFloat;
    this.eAs = paramInt;
    this.eAt = parama;
    this.path = paramString1;
    this.eAu = paramString2;
    AppMethodBeat.o(220795);
  }
  
  public final String aui()
  {
    AppMethodBeat.i(220805);
    String str = "BlusherStickInfo(path='" + this.path + "', pathMd5='" + this.eAu + "')";
    AppMethodBeat.o(220805);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220831);
    if (this == paramObject)
    {
      AppMethodBeat.o(220831);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(220831);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(220831);
      return false;
    }
    if (this.eAs != paramObject.eAs)
    {
      AppMethodBeat.o(220831);
      return false;
    }
    if (this.eAt != paramObject.eAt)
    {
      AppMethodBeat.o(220831);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(220831);
      return false;
    }
    if (!s.p(this.eAu, paramObject.eAu))
    {
      AppMethodBeat.o(220831);
      return false;
    }
    AppMethodBeat.o(220831);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220823);
    int j = Float.floatToIntBits(this.alpha);
    int k = this.eAs;
    int m = this.eAt.hashCode();
    int n = this.path.hashCode();
    if (this.eAu == null) {}
    for (int i = 0;; i = this.eAu.hashCode())
    {
      AppMethodBeat.o(220823);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220813);
    String str = "BlusherStickInfo(alpha=" + this.alpha + ", faceModel=" + this.eAs + ", blendMode=" + this.eAt + ", path=" + this.path + ", pathMd5=" + this.eAu + ')';
    AppMethodBeat.o(220813);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
 * JD-Core Version:    0.7.0.1
 */