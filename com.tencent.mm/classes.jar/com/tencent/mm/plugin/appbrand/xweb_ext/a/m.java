package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/StickerApplyParams;", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "path", "", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
public final class m
{
  final l.c oGU;
  final String path;
  
  public m(l.c paramc, String paramString)
  {
    AppMethodBeat.i(229748);
    this.oGU = paramc;
    this.path = paramString;
    AppMethodBeat.o(229748);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229751);
    if (this != paramObject)
    {
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
        if ((!p.j(this.oGU, paramObject.oGU)) || (!p.j(this.path, paramObject.path))) {}
      }
    }
    else
    {
      AppMethodBeat.o(229751);
      return true;
    }
    AppMethodBeat.o(229751);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(229750);
    Object localObject = this.oGU;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.path;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(229750);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229749);
    String str = "StickerApplyParams(type=" + this.oGU + ", path=" + this.path + ")";
    AppMethodBeat.o(229749);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.m
 * JD-Core Version:    0.7.0.1
 */