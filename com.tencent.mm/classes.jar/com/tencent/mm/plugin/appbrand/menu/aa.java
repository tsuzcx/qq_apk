package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.luggage.game.d.a.a.b;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.magicbrush.MBRuntime.MBParams;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.u;
import com.tencent.mm.plugin.appbrand.game.a.v;
import com.tencent.mm.plugin.appbrand.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/menu/ShowPkgInfoKt;", "", "()V", "showWAGameInfoIfNeeded", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa tkX;
  
  static
  {
    AppMethodBeat.i(50885);
    tkX = new aa();
    AppMethodBeat.o(50885);
  }
  
  public static void a(StringBuilder paramStringBuilder, y paramy)
  {
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(50884);
    s.u(paramStringBuilder, "sb");
    if ((paramy instanceof d))
    {
      paramy = (d)paramy;
      if (paramy != null) {
        break label46;
      }
    }
    label46:
    for (paramy = localStringBuilder;; paramy = (b)paramy.aa(b.class))
    {
      if (paramy != null) {
        break label59;
      }
      AppMethodBeat.o(50884);
      return;
      paramy = null;
      break;
    }
    label59:
    paramy = paramy.getMagicBrush();
    if (paramy == null)
    {
      paramStringBuilder.append("\n[renderer] ").append("unknown");
      AppMethodBeat.o(50884);
      return;
    }
    paramStringBuilder.append("\n[renderer] ").append("mbruntime");
    paramStringBuilder.append("\n[renderer] ").append("commandbuffer ").append(paramy.avv().use_command_buffer);
    paramStringBuilder.append("\n[renderer] ").append("cmd pool ").append(paramy.avv().cmd_pool_type);
    localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("antialias ");
    if (paramy.avv().allow_antialias_)
    {
      paramy = "allowed";
      localStringBuilder.append(paramy);
      localStringBuilder = paramStringBuilder.append("\n[renderer] ").append("surface ");
      if (!((Boolean)v.rqA.boF()).booleanValue()) {
        break label259;
      }
      paramy = "surfacetexture";
      label205:
      localStringBuilder.append(paramy);
      paramy = paramStringBuilder.append("\n[renderer] ").append("jsengine ");
      if (!((Boolean)u.rqz.boF()).booleanValue()) {
        break label265;
      }
    }
    label259:
    label265:
    for (paramStringBuilder = "node";; paramStringBuilder = "j2v8")
    {
      paramy.append(paramStringBuilder);
      AppMethodBeat.o(50884);
      return;
      paramy = "disallowed";
      break;
      paramy = "legacysurface";
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.aa
 * JD-Core Version:    0.7.0.1
 */