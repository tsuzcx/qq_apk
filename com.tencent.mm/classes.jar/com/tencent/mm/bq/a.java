package com.tencent.mm.bq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
{
  private static String DeX = "";
  private static String fKK = "";
  
  public static String Zb()
  {
    AppMethodBeat.i(116804);
    if (bs.isNullOrNil(fKK)) {
      fKK = com.tencent.mm.kernel.a.Zc().getString("message_channel_id", "message_channel_new_id");
    }
    String str = fKK;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static void aFD(String paramString)
  {
    fKK = paramString;
  }
  
  public static s.c bE(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116806);
    paramContext = new s.c(paramContext, paramString);
    AppMethodBeat.o(116806);
    return paramContext;
  }
  
  public static int dlN()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public static String eJQ()
  {
    AppMethodBeat.i(116805);
    if (bs.isNullOrNil(DeX)) {
      DeX = com.tencent.mm.kernel.a.Zc().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = DeX;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String eJR()
  {
    AppMethodBeat.i(116807);
    if (d.kZ(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      ai.getContext();
      if (!com.tencent.mm.m.a.cp(i, j)) {
        ac.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = Zb();
    AppMethodBeat.o(116807);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */