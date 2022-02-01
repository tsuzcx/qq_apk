package com.tencent.mm.bq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.n.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static String JSi = "";
  private static String gLY = "";
  
  public static String apJ()
  {
    AppMethodBeat.i(116804);
    if (Util.isNullOrNil(gLY)) {
      gLY = com.tencent.mm.kernel.a.apK().getString("message_channel_id", "message_channel_new_id");
    }
    String str = gLY;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static void bcS(String paramString)
  {
    gLY = paramString;
  }
  
  public static s.c cd(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116806);
    paramContext = new s.c(paramContext, paramString);
    AppMethodBeat.o(116806);
    return paramContext;
  }
  
  public static int ezb()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131234303;
    }
    return 2131234305;
  }
  
  public static String glD()
  {
    AppMethodBeat.i(116805);
    if (Util.isNullOrNil(JSi)) {
      JSi = com.tencent.mm.kernel.a.apK().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = JSi;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String glE()
  {
    AppMethodBeat.i(116807);
    if (d.oD(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      MMApplicationContext.getContext();
      if (!b.ct(i, j)) {
        Log.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = apJ();
    AppMethodBeat.o(116807);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */