package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashMap;
import java.util.UUID;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(148836);
    if (ad.getLogLevel() > 1)
    {
      AppMethodBeat.o(148836);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(148836);
      return true;
    }
    paramContext = paramArrayOfString[1];
    int i = -1;
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(148836);
        return false;
        if (paramContext.equals("crash"))
        {
          i = 0;
          continue;
          if (paramContext.equals("statusbar"))
          {
            i = 1;
            continue;
            if (paramContext.equals("startnew")) {
              i = 2;
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
    paramContext.rdo = "emotion";
    paramContext.rdp = "store";
    paramContext.rds = 2;
    paramContext.rdr = new HashMap();
    paramContext.rdr.put("fontScale", Float.valueOf(com.tencent.mm.cd.a.dT(aj.getContext())));
    paramContext.rdr.put("layoutScale", Float.valueOf(com.tencent.mm.cd.a.hR(aj.getContext())));
    paramContext.rdr.put("language", ac.eFu());
    paramContext.rdr.put("sessionId", paramArrayOfString);
    paramArrayOfString = new Intent(aj.getContext(), MMFlutterActivity.class);
    paramArrayOfString.addFlags(268435456);
    paramArrayOfString.putExtra("route", paramContext.aOj());
    paramContext = aj.getContext();
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.adn(), "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(148836);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a
 * JD-Core Version:    0.7.0.1
 */