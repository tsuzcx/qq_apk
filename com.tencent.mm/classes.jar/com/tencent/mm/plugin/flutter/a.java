package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(148836);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(148836);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(148836);
      return true;
    }
    paramArrayOfString = paramArrayOfString[1];
    int i = -1;
    switch (paramArrayOfString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(148836);
        return false;
        if (paramArrayOfString.equals("crash"))
        {
          i = 0;
          continue;
          if (paramArrayOfString.equals("statusbar"))
          {
            i = 1;
            continue;
            if (paramArrayOfString.equals("startnew"))
            {
              i = 2;
              continue;
              if (paramArrayOfString.equals("clean")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    AppMethodBeat.o(148836);
    return true;
    AppMethodBeat.o(148836);
    return true;
    paramArrayOfString = UUID.randomUUID().toString();
    paramContext = new c();
    paramContext.HjZ = "emotion";
    paramContext.hJP = "store";
    paramContext.Hkb = 2;
    paramContext.Hka = new HashMap();
    paramContext.Hka.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext())));
    paramContext.Hka.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.mo(MMApplicationContext.getContext())));
    paramContext.Hka.put("language", LocaleUtil.getApplicationLanguage());
    paramContext.Hka.put("sessionId", paramArrayOfString);
    paramArrayOfString = new Intent(MMApplicationContext.getContext(), MMFlutterActivity.class);
    paramArrayOfString.addFlags(268435456);
    paramArrayOfString.putExtra("route", paramContext.toJsonString());
    paramContext = MMApplicationContext.getContext();
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().cG(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfString.aYi(), "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(148836);
    return true;
    paramArrayOfString = new File(ah.v(new u(paramContext.getCacheDir() + "/flutter").jKT()));
    paramContext = new u(paramContext.getCacheDir() + "/flutter");
    paramArrayOfString.delete();
    paramContext.diJ();
    AppMethodBeat.o(148836);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a
 * JD-Core Version:    0.7.0.1
 */