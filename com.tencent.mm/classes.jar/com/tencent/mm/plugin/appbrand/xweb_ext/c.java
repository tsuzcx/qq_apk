package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/WCExtendPluginClientProxy;", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/DefaultExtendPluginClientProxy;", "()V", "canCreatePluginHandlerWhenHandleJsApi", "", "type", "", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.b.a
{
  private static final String[] rIc;
  public static final a rId;
  
  static
  {
    AppMethodBeat.i(274030);
    rId = new a((byte)0);
    rIc = new String[] { "video", "liveplayer", "livepusher" };
    AppMethodBeat.o(274030);
  }
  
  public final boolean b(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(274028);
    p.k(parama, "invokeContext");
    if (!kotlin.a.e.contains(rIc, paramString))
    {
      boolean bool = super.b(paramString, parama);
      AppMethodBeat.o(274028);
      return bool;
    }
    paramString = e.rIr;
    if ((!((Boolean)e.rIq.getValue()).booleanValue()) || (parama.SU()))
    {
      AppMethodBeat.o(274028);
      return true;
    }
    AppMethodBeat.o(274028);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/WCExtendPluginClientProxy$Companion;", "", "()V", "SUPPORT_PLUGIN_TYPES", "", "", "[Ljava/lang/String;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c
 * JD-Core Version:    0.7.0.1
 */