package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "faceModel", "", "alpha", "", "path", "", "pathMd5", "(IFLjava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getFaceModel", "()I", "getPath", "()Ljava/lang/String;", "getPathMd5", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements i
{
  public final float alpha;
  public final int eAs;
  private final String eAu;
  public final String path;
  
  public e(int paramInt, float paramFloat, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220793);
    this.eAs = paramInt;
    this.alpha = paramFloat;
    this.path = paramString1;
    this.eAu = paramString2;
    AppMethodBeat.o(220793);
  }
  
  public final String aui()
  {
    AppMethodBeat.i(220802);
    String str = "FaceContourInfo(path='" + this.path + "', pathMd5='" + this.eAu + "')";
    AppMethodBeat.o(220802);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220830);
    if (this == paramObject)
    {
      AppMethodBeat.o(220830);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(220830);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.eAs != paramObject.eAs)
    {
      AppMethodBeat.o(220830);
      return false;
    }
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(220830);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(220830);
      return false;
    }
    if (!s.p(this.eAu, paramObject.eAu))
    {
      AppMethodBeat.o(220830);
      return false;
    }
    AppMethodBeat.o(220830);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220818);
    int j = this.eAs;
    int k = Float.floatToIntBits(this.alpha);
    int m = this.path.hashCode();
    if (this.eAu == null) {}
    for (int i = 0;; i = this.eAu.hashCode())
    {
      AppMethodBeat.o(220818);
      return i + ((j * 31 + k) * 31 + m) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220810);
    String str = "FaceContourInfo(faceModel=" + this.eAs + ", alpha=" + this.alpha + ", path=" + this.path + ", pathMd5=" + this.eAu + ')';
    AppMethodBeat.o(220810);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e
 * JD-Core Version:    0.7.0.1
 */