package com.tencent.mm.plugin.appbrand.xweb_ext;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  public static final a uTq;
  
  static
  {
    AppMethodBeat.i(51458);
    uTq = new a((byte)0);
    AppMethodBeat.o(51458);
  }
  
  public static final void aoW()
  {
    AppMethodBeat.i(51459);
    com.tencent.mm.pluginsdk.cmd.b.a((a)new b(), new String[] { "//skia" });
    AppMethodBeat.o(51459);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(51457);
    s.u(paramContext, "context");
    s.u(paramArrayOfString, "args");
    s.u(paramString, "username");
    if (s.p("//skia", paramArrayOfString[0]))
    {
      if (paramArrayOfString.length < 2)
      {
        AppMethodBeat.o(51457);
        return false;
      }
      paramContext = paramArrayOfString[1];
      if (s.p(paramContext, "true"))
      {
        a.cTb().putBoolean("use_skia_canvas", true);
        a.cTb().commit();
      }
      for (;;)
      {
        AppMethodBeat.o(51457);
        return true;
        if (s.p(paramContext, "false"))
        {
          a.cTb().putBoolean("use_skia_canvas", false);
          a.cTb().commit();
        }
        else
        {
          a.cTb().clear();
          a.cTb().commit();
        }
      }
    }
    AppMethodBeat.o(51457);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static MultiProcessMMKV cTb()
    {
      AppMethodBeat.i(51455);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("MicroMsg.UseXWebCanvas");
      s.s(localMultiProcessMMKV, "getMMKV(TAG)");
      AppMethodBeat.o(51455);
      return localMultiProcessMMKV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.b
 * JD-Core Version:    0.7.0.1
 */