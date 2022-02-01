package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.q;
import com.tencent.mm.plugin.appbrand.r;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class v
{
  public static final v lXW;
  
  static
  {
    AppMethodBeat.i(50885);
    lXW = new v();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, r paramr)
  {
    AppMethodBeat.i(50884);
    d.g.b.p.h(paramStringBuilder, "sb");
    if (!(paramr instanceof c)) {
      paramr = null;
    }
    for (;;)
    {
      paramr = (c)paramr;
      if (paramr != null) {}
      for (paramr = (b)paramr.Q(b.class); paramr == null; paramr = null)
      {
        AppMethodBeat.o(50884);
        return;
      }
      paramr = paramr.getMagicBrush();
      if (paramr == null)
      {
        paramStringBuilder.append("\n[renderer] ").append("unknown");
        AppMethodBeat.o(50884);
        return;
      }
      paramStringBuilder.append("\n[renderer] ").append("mbruntime");
      paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(paramr.Hs().use_command_buffer);
      paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(paramr.Hs().cmd_pool_type);
      StringBuilder localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (paramr.Hs().allow_antialias_)
      {
        paramr = "allowed";
        localStringBuilder.append(paramr);
        localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
        if (!((Boolean)q.kol.att()).booleanValue()) {
          break label254;
        }
        paramr = "surfacetexture";
        label200:
        localStringBuilder.append(paramr);
        paramr = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.p.kok.att()).booleanValue()) {
          break label260;
        }
      }
      label260:
      for (paramStringBuilder = "node";; paramStringBuilder = "j2v8")
      {
        paramr.append(paramStringBuilder);
        AppMethodBeat.o(50884);
        return;
        paramr = "disallowed";
        break;
        label254:
        paramr = "legacysurface";
        break label200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.v
 * JD-Core Version:    0.7.0.1
 */