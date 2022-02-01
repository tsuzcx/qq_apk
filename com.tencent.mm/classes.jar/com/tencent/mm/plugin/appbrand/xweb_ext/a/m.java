package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class m
{
  final String path;
  final m.c rIK;
  
  public m(m.c paramc, String paramString)
  {
    AppMethodBeat.i(267972);
    this.rIK = paramc;
    this.path = paramString;
    AppMethodBeat.o(267972);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(267975);
    if (this != paramObject)
    {
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
        if ((!p.h(this.rIK, paramObject.rIK)) || (!p.h(this.path, paramObject.path))) {}
      }
    }
    else
    {
      AppMethodBeat.o(267975);
      return true;
    }
    AppMethodBeat.o(267975);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(267974);
    Object localObject = this.rIK;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.path;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(267974);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267973);
    String str = "StickerApplyParams(type=" + this.rIK + ", path=" + this.path + ")";
    AppMethodBeat.o(267973);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.m
 * JD-Core Version:    0.7.0.1
 */