package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class t
{
  public static final t kSK;
  
  static
  {
    AppMethodBeat.i(50885);
    kSK = new t();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, q paramq)
  {
    AppMethodBeat.i(50884);
    d.g.b.k.h(paramStringBuilder, "sb");
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
      paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(paramq.Gg().use_command_buffer);
      paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(paramq.Gg().cmd_pool_type);
      StringBuilder localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (paramq.Gg().allow_antialias_)
      {
        paramq = "allowed";
        localStringBuilder.append(paramq);
        localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.l.jqp.ajp()).booleanValue()) {
          break label254;
        }
        paramq = "surfacetexture";
        label200:
        localStringBuilder.append(paramq);
        paramq = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
        if (!((Boolean)com.tencent.mm.plugin.appbrand.game.a.k.jqo.ajp()).booleanValue()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.t
 * JD-Core Version:    0.7.0.1
 */