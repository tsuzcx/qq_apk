package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  final String path;
  final o.c uUa;
  
  public l(o.c paramc, String paramString)
  {
    AppMethodBeat.i(317074);
    this.uUa = paramc;
    this.path = paramString;
    AppMethodBeat.o(317074);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(317101);
    if (this == paramObject)
    {
      AppMethodBeat.o(317101);
      return true;
    }
    if (!(paramObject instanceof l))
    {
      AppMethodBeat.o(317101);
      return false;
    }
    paramObject = (l)paramObject;
    if (this.uUa != paramObject.uUa)
    {
      AppMethodBeat.o(317101);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(317101);
      return false;
    }
    AppMethodBeat.o(317101);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(317089);
    int i = this.uUa.hashCode();
    int j = this.path.hashCode();
    AppMethodBeat.o(317089);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(317080);
    String str = "StickerApplyParams(type=" + this.uUa + ", path=" + this.path + ')';
    AppMethodBeat.o(317080);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.l
 * JD-Core Version:    0.7.0.1
 */