package com.tencent.mm.plugin.appbrand.xweb_ext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final a nqR;
  
  static
  {
    AppMethodBeat.i(51458);
    nqR = new a((byte)0);
    AppMethodBeat.o(51458);
  }
  
  public static final void Cx()
  {
    AppMethodBeat.i(51459);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new b(), new String[] { "//skia" });
    AppMethodBeat.o(51459);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(51457);
    p.h(paramContext, "context");
    p.h(paramArrayOfString, "args");
    p.h(paramString, "username");
    if (p.i("//skia", paramArrayOfString[0]))
    {
      if (paramArrayOfString.length < 2)
      {
        AppMethodBeat.o(51457);
        return false;
      }
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        a.bFO().clear();
        a.bFO().commit();
      }
      for (;;)
      {
        AppMethodBeat.o(51457);
        return true;
        if (!paramContext.equals("true")) {
          break;
        }
        a.bFO().putBoolean("use_skia_canvas", true);
        a.bFO().commit();
        continue;
        if (!paramContext.equals("false")) {
          break;
        }
        a.bFO().putBoolean("use_skia_canvas", false);
        a.bFO().commit();
      }
    }
    AppMethodBeat.o(51457);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static ax bFO()
    {
      AppMethodBeat.i(51455);
      ax localax = ax.aQz("MicroMsg.UseXWebCanvas");
      p.g(localax, "MultiProcessMMKV.getMMKV(TAG)");
      AppMethodBeat.o(51455);
      return localax;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.b
 * JD-Core Version:    0.7.0.1
 */