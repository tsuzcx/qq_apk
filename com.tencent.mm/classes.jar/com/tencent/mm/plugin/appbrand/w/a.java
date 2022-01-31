package com.tencent.mm.plugin.appbrand.w;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.as;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static final a.a jyb;
  
  static
  {
    AppMethodBeat.i(154368);
    jyb = new a.a((byte)0);
    AppMethodBeat.o(154368);
  }
  
  public static final void uD()
  {
    AppMethodBeat.i(154369);
    b.a((com.tencent.mm.pluginsdk.cmd.a)new a(), new String[] { "//skia" });
    AppMethodBeat.o(154369);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(154367);
    j.q(paramContext, "context");
    j.q(paramArrayOfString, "args");
    j.q(paramString, "username");
    if (j.e("//skia", paramArrayOfString[0]))
    {
      if (paramArrayOfString.length < 2)
      {
        AppMethodBeat.o(154367);
        return false;
      }
      paramContext = paramArrayOfString[1];
      switch (paramContext.hashCode())
      {
      default: 
        a.a.aSs().clear();
        a.a.aSs().commit();
      }
      for (;;)
      {
        AppMethodBeat.o(154367);
        return true;
        if (!paramContext.equals("true")) {
          break;
        }
        a.a.aSs().putBoolean("use_skia_canvas", true);
        a.a.aSs().commit();
        continue;
        if (!paramContext.equals("false")) {
          break;
        }
        a.a.aSs().putBoolean("use_skia_canvas", false);
        a.a.aSs().commit();
      }
    }
    AppMethodBeat.o(154367);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.a
 * JD-Core Version:    0.7.0.1
 */