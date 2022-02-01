package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "blendMode", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "path", "", "pathMd5", "shimmerPosPath", "shimmerPosPathMd5", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getBlendMode", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlendMode;", "getPath", "()Ljava/lang/String;", "getPathMd5", "getShimmerPosPath", "getShimmerPosPathMd5", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2$EyeShadowType;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfoV2$EyeShadowType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "", "toString", "EyeShadowType", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements i
{
  public final float alpha;
  public final a eAt;
  private final String eAu;
  public final String eAw;
  private final String eAx;
  private final d.a eAy;
  public final String path;
  
  public d(float paramFloat, a parama, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(220798);
    this.alpha = paramFloat;
    this.eAt = parama;
    this.path = paramString1;
    this.eAu = paramString2;
    this.eAw = paramString3;
    this.eAx = paramString4;
    parama = (CharSequence)this.eAw;
    int i;
    if ((parama == null) || (parama.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label104;
      }
    }
    label104:
    for (parama = d.a.eAz;; parama = d.a.eAA)
    {
      this.eAy = parama;
      AppMethodBeat.o(220798);
      return;
      i = 0;
      break;
    }
  }
  
  public final String aui()
  {
    AppMethodBeat.i(220806);
    String str = "EyeShadowInfoV1(path='" + this.path + "', pathMd5='" + this.eAu + "', shimmerPosPath=" + this.eAw + ", shimmerPosPathMd5='" + this.eAx + "')";
    AppMethodBeat.o(220806);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220838);
    if (this == paramObject)
    {
      AppMethodBeat.o(220838);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    if (this.eAt != paramObject.eAt)
    {
      AppMethodBeat.o(220838);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    if (!s.p(this.eAu, paramObject.eAu))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    if (!s.p(this.eAw, paramObject.eAw))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    if (!s.p(this.eAx, paramObject.eAx))
    {
      AppMethodBeat.o(220838);
      return false;
    }
    AppMethodBeat.o(220838);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(220826);
    int m = Float.floatToIntBits(this.alpha);
    int n = this.eAt.hashCode();
    int i1 = this.path.hashCode();
    int i;
    int j;
    if (this.eAu == null)
    {
      i = 0;
      if (this.eAw != null) {
        break label105;
      }
      j = 0;
      label52:
      if (this.eAx != null) {
        break label116;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220826);
      return (j + (i + ((m * 31 + n) * 31 + i1) * 31) * 31) * 31 + k;
      i = this.eAu.hashCode();
      break;
      label105:
      j = this.eAw.hashCode();
      break label52;
      label116:
      k = this.eAx.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220816);
    String str = "EyeShadowInfoV2(alpha=" + this.alpha + ", blendMode=" + this.eAt + ", path=" + this.path + ", pathMd5=" + this.eAu + ", shimmerPosPath=" + this.eAw + ", shimmerPosPathMd5=" + this.eAx + ')';
    AppMethodBeat.o(220816);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d
 * JD-Core Version:    0.7.0.1
 */