package com.tencent.mm.plugin.appbrand.xweb_ext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"})
public final class b
  implements a
{
  public static final a mQs;
  
  static
  {
    AppMethodBeat.i(51458);
    mQs = new a((byte)0);
    AppMethodBeat.o(51458);
  }
  
  public static final void AY()
  {
    AppMethodBeat.i(51459);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new b(), new String[] { "//skia" });
    AppMethodBeat.o(51459);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(51457);
    k.h(paramContext, "context");
    k.h(paramArrayOfString, "args");
    k.h(paramString, "username");
    if (k.g("//skia", paramArrayOfString[0]))
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
        a.bBL().clear();
        a.bBL().commit();
      }
      for (;;)
      {
        AppMethodBeat.o(51457);
        return true;
        if (!paramContext.equals("true")) {
          break;
        }
        a.bBL().putBoolean("use_skia_canvas", true);
        a.bBL().commit();
        continue;
        if (!paramContext.equals("false")) {
          break;
        }
        a.bBL().putBoolean("use_skia_canvas", false);
        a.bBL().commit();
      }
    }
    AppMethodBeat.o(51457);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static aw bBL()
    {
      AppMethodBeat.i(51455);
      aw localaw = aw.aKT("MicroMsg.UseXWebCanvas");
      k.g(localaw, "MultiProcessMMKV.getMMKV(TAG)");
      AppMethodBeat.o(51455);
      return localaw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.b
 * JD-Core Version:    0.7.0.1
 */