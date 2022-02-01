package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.t;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class x
{
  public static final x qgm;
  
  static
  {
    AppMethodBeat.i(50885);
    qgm = new x();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, v paramv)
  {
    AppMethodBeat.i(50884);
    p.k(paramStringBuilder, "sb");
    if (!(paramv instanceof d)) {
      paramv = null;
    }
    for (;;)
    {
      paramv = (d)paramv;
      if (paramv != null) {}
      for (paramv = (b)paramv.R(b.class); paramv == null; paramv = null)
      {
        AppMethodBeat.o(50884);
        return;
      }
      paramv = paramv.getMagicBrush();
      if (paramv == null)
      {
        paramStringBuilder.append("\n[renderer] ").append("unknown");
        AppMethodBeat.o(50884);
        return;
      }
      paramStringBuilder.append("\n[renderer] ").append("mbruntime");
      paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(paramv.US().use_command_buffer);
      paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(paramv.US().cmd_pool_type);
      StringBuilder localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (paramv.US().allow_antialias_)
      {
        paramv = "allowed";
        localStringBuilder.append(paramv);
        localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
        if (!((Boolean)u.omQ.aUb()).booleanValue()) {
          break label254;
        }
        paramv = "surfacetexture";
        label200:
        localStringBuilder.append(paramv);
        paramv = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
        if (!((Boolean)t.omP.aUb()).booleanValue()) {
          break label260;
        }
      }
      label260:
      for (paramStringBuilder = "node";; paramStringBuilder = "j2v8")
      {
        paramv.append(paramStringBuilder);
        AppMethodBeat.o(50884);
        return;
        paramv = "disallowed";
        break;
        label254:
        paramv = "legacysurface";
        break label200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.x
 * JD-Core Version:    0.7.0.1
 */