package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/WCExtendPluginClientProxy;", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/DefaultExtendPluginClientProxy;", "()V", "canCreatePluginHandlerWhenHandleJsApi", "", "type", "", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.luggage.xweb_ext.extendplugin.b.a
{
  public static final a uTr;
  private static final String[] uTs;
  
  static
  {
    AppMethodBeat.i(317046);
    uTr = new a((byte)0);
    uTs = new String[] { "video", "liveplayer", "livepusher" };
    AppMethodBeat.o(317046);
  }
  
  public final boolean b(String paramString, com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(317052);
    s.u(parama, "invokeContext");
    if (!k.contains(uTs, paramString))
    {
      boolean bool = super.b(paramString, parama);
      AppMethodBeat.o(317052);
      return bool;
    }
    paramString = e.uTu;
    if ((!e.cTy()) || (parama.atz()))
    {
      AppMethodBeat.o(317052);
      return true;
    }
    AppMethodBeat.o(317052);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/WCExtendPluginClientProxy$Companion;", "", "()V", "SUPPORT_PLUGIN_TYPES", "", "", "[Ljava/lang/String;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.c
 * JD-Core Version:    0.7.0.1
 */