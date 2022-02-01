package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(148836);
    if (ae.getLogLevel() > 1)
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
    paramContext.ttd = "emotion";
    paramContext.tte = "store";
    paramContext.ttg = 2;
    paramContext.ttf = new HashMap();
    paramContext.ttf.put("fontScale", Float.valueOf(com.tencent.mm.cb.a.ef(ak.getContext())));
    paramContext.ttf.put("layoutScale", Float.valueOf(com.tencent.mm.cb.a.iq(ak.getContext())));
    paramContext.ttf.put("language", ad.fom());
    paramContext.ttf.put("sessionId", paramArrayOfString);
    paramArrayOfString = new Intent(ak.getContext(), MMFlutterActivity.class);
    paramArrayOfString.addFlags(268435456);
    paramArrayOfString.putExtra("route", paramContext.aYO());
    paramContext = ak.getContext();
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.ahE(), "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(148836);
    return true;
    paramArrayOfString = new File(w.B(new k(paramContext.getCacheDir() + "/flutter").fTh()));
    paramContext = new k(paramContext.getCacheDir() + "/flutter");
    paramArrayOfString.delete();
    paramContext.delete();
    AppMethodBeat.o(148836);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a
 * JD-Core Version:    0.7.0.1
 */