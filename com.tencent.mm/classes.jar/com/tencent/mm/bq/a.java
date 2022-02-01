package com.tencent.mm.bq;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.app.s.c;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  private static String Fbo = "";
  private static String ggt = "";
  
  public static void aMz(String paramString)
  {
    ggt = paramString;
  }
  
  public static String abK()
  {
    AppMethodBeat.i(116804);
    if (bu.isNullOrNil(ggt)) {
      ggt = com.tencent.mm.kernel.a.abL().getString("message_channel_id", "message_channel_new_id");
    }
    String str = ggt;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static s.c bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(116806);
    paramContext = new s.c(paramContext, paramString);
    AppMethodBeat.o(116806);
    return paramContext;
  }
  
  public static int dzu()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2131233500;
    }
    return 2131233502;
  }
  
  public static String fcs()
  {
    AppMethodBeat.i(116805);
    if (bu.isNullOrNil(Fbo)) {
      Fbo = com.tencent.mm.kernel.a.abL().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = Fbo;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String fct()
  {
    AppMethodBeat.i(116807);
    if (d.lA(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      ak.getContext();
      if (!com.tencent.mm.n.a.cr(i, j)) {
        ae.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = abK();
    AppMethodBeat.o(116807);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */