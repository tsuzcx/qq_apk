package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.q;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class t
{
  public static final t luk;
  
  static
  {
    AppMethodBeat.i(50885);
    luk = new t();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, q paramq)
  {
    AppMethodBeat.i(50884);
    k.h(paramStringBuilder, "sb");
    if (!(paramq instanceof c)) {
      paramq = null;
    }
    for (;;)
    {
      paramq = (c)paramq;
      if (paramq != null) {}
      for (paramq = (b)paramq.Q(b.class); paramq == null; paramq = null)
      {
        AppMethodBeat.o(50884);
        return;
      }
      paramq = paramq.getMagicBrush();
      if (paramq == null)
      {
        paramStringBuilder.append("\n[renderer] ").append("unknown");
        AppMethodBeat.o(50884);
        return;
      }
      paramStringBuilder.append("\n[renderer] ").append("mbruntime");
      paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(paramq.FS().use_command_buffer);
      paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(paramq.FS().cmd_pool_type);
      StringBuilder localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (paramq.FS().allow_antialias_)
      {
        paramq = "allowed";
        localStringBuilder.append(paramq);
        localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
        if (!((Boolean)n.jQG.aqp()).booleanValue()) {
          break label254;
        }
        paramq = "surfacetexture";
        label200:
        localStringBuilder.append(paramq);
        paramq = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
        if (!((Boolean)m.jQF.aqp()).booleanValue()) {
          break label260;
        }
      }
      label260:
      for (paramStringBuilder = "node";; paramStringBuilder = "j2v8")
      {
        paramq.append(paramStringBuilder);
        AppMethodBeat.o(50884);
        return;
        paramq = "disallowed";
        break;
        label254:
        paramq = "legacysurface";
        break label200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */