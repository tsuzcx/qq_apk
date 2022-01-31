package com.tencent.mm.plugin.appbrand.menu;

import a.f.b.j;
import a.l;
import com.tencent.luggage.game.e.a.a.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"})
public final class s
{
  public static final s irl;
  
  static
  {
    AppMethodBeat.i(134756);
    irl = new s();
    AppMethodBeat.o(134756);
  }
  
  public static void a(StringBuilder paramStringBuilder, r paramr)
  {
    AppMethodBeat.i(134755);
    j.q(paramStringBuilder, "sb");
    if (!(paramr instanceof c)) {
      paramr = null;
    }
    for (;;)
    {
      paramr = (c)paramr;
      if (paramr != null) {}
      for (paramr = (b)paramr.x(b.class); paramr == null; paramr = null)
      {
        AppMethodBeat.o(134755);
        return;
      }
      MBRuntime localMBRuntime = paramr.getMBRuntime();
      if (localMBRuntime == null)
      {
        paramStringBuilder.append("\n[renderer] ").append("unknown");
        AppMethodBeat.o(134755);
        return;
      }
      paramStringBuilder.append("\n[renderer] ").append("mbruntime");
      if (localMBRuntime.getParams().use_command_buffer) {
        paramStringBuilder.append(" commandbuffer");
      }
      paramr = paramStringBuilder.append("\n[renderer] ").append("antialias ");
      if (localMBRuntime.getParams().allow_antialias_) {}
      for (paramStringBuilder = "allowed";; paramStringBuilder = "disallowed")
      {
        paramr.append(paramStringBuilder);
        AppMethodBeat.o(134755);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.s
 * JD-Core Version:    0.7.0.1
 */