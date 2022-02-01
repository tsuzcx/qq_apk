package com.tencent.mm.plugin.flutter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.a.c;
import com.tencent.mm.plugin.flutter.ui.MMFlutterActivity;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.File;
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
    paramContext.til = "emotion";
    paramContext.tim = "store";
    paramContext.tio = 2;
    paramContext.tin = new HashMap();
    paramContext.tin.put("fontScale", Float.valueOf(com.tencent.mm.cc.a.eb(aj.getContext())));
    paramContext.tin.put("layoutScale", Float.valueOf(com.tencent.mm.cc.a.il(aj.getContext())));
    paramContext.tin.put("language", ac.fks());
    paramContext.tin.put("sessionId", paramArrayOfString);
    paramArrayOfString = new Intent(aj.getContext(), MMFlutterActivity.class);
    paramArrayOfString.addFlags(268435456);
    paramArrayOfString.putExtra("route", paramContext.aYt());
    paramContext = aj.getContext();
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.ahp(), "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/flutter/FlutterCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(148836);
    return true;
    paramArrayOfString = new File(q.B(new e(paramContext.getCacheDir() + "/flutter").fOK()));
    paramContext = new e(paramContext.getCacheDir() + "/flutter");
    paramArrayOfString.delete();
    paramContext.delete();
    AppMethodBeat.o(148836);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.a
 * JD-Core Version:    0.7.0.1
 */