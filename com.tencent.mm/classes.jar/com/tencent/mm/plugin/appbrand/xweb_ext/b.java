package com.tencent.mm.plugin.appbrand.xweb_ext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final a rIb;
  
  static
  {
    AppMethodBeat.i(51458);
    rIb = new a((byte)0);
    AppMethodBeat.o(51458);
  }
  
  public static final void OO()
  {
    AppMethodBeat.i(51459);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new b(), new String[] { "//skia" });
    AppMethodBeat.o(51459);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(51457);
    p.k(paramContext, "context");
    p.k(paramArrayOfString, "args");
    p.k(paramString, "username");
    if (p.h("//skia", paramArrayOfString[0]))
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
        a.cqu().clear();
        a.cqu().commit();
      }
      for (;;)
      {
        AppMethodBeat.o(51457);
        return true;
        if (!paramContext.equals("true")) {
          break;
        }
        a.cqu().putBoolean("use_skia_canvas", true);
        a.cqu().commit();
        continue;
        if (!paramContext.equals("false")) {
          break;
        }
        a.cqu().putBoolean("use_skia_canvas", false);
        a.cqu().commit();
      }
    }
    AppMethodBeat.o(51457);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static MultiProcessMMKV cqu()
    {
      AppMethodBeat.i(51455);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.UseXWebCanvas");
      p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(TAG)");
      AppMethodBeat.o(51455);
      return localMultiProcessMMKV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.b
 * JD-Core Version:    0.7.0.1
 */