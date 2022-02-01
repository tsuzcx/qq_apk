package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.r;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class v
{
  public static final v nfC;
  
  static
  {
    AppMethodBeat.i(50885);
    nfC = new v();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, com.tencent.mm.plugin.appbrand.s params)
  {
    AppMethodBeat.i(50884);
    p.h(paramStringBuilder, "sb");
    if (!(params instanceof d)) {
      params = null;
    }
    for (;;)
    {
      params = (d)params;
      if (params != null) {}
      for (params = (b)params.S(b.class); params == null; params = null)
      {
        AppMethodBeat.o(50884);
        return;
      }
      params = params.getMagicBrush();
      if (params == null)
      {
        paramStringBuilder.append("\n[renderer] ").append("unknown");
        AppMethodBeat.o(50884);
        return;
      }
      paramStringBuilder.append("\n[renderer] ").append("mbruntime");
      paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(params.Rk().use_command_buffer);
      paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(params.Rk().cmd_pool_type);
      StringBuilder localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (params.Rk().allow_antialias_)
      {
        params = "allowed";
        localStringBuilder.append(params);
        localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.s.lrT.aLT()).booleanValue()) {
          break label254;
        }
        params = "surfacetexture";
        label200:
        localStringBuilder.append(params);
        params = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
        if (!((Boolean)r.lrS.aLT()).booleanValue()) {
          break label260;
        }
      }
      label260:
      for (paramStringBuilder = "node";; paramStringBuilder = "j2v8")
      {
        params.append(paramStringBuilder);
        AppMethodBeat.o(50884);
        return;
        params = "disallowed";
        break;
        label254:
        params = "legacysurface";
        break label200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.v
 * JD-Core Version:    0.7.0.1
 */