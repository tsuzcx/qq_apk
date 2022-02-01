package com.tencent.mm.bx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.format.Time;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bu.a.a.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static String QRn = "";
  private static String jwn = "";
  
  public static String awc()
  {
    AppMethodBeat.i(116804);
    if (Util.isNullOrNil(jwn)) {
      jwn = com.tencent.mm.kernel.b.awd().getString("message_channel_id", "message_channel_new_id");
    }
    String str = jwn;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static void boS(String paramString)
  {
    jwn = paramString;
  }
  
  public static e.d cp(Context paramContext, String paramString)
  {
    AppMethodBeat.i(209708);
    paramContext = new e.d(paramContext, paramString);
    AppMethodBeat.o(209708);
    return paramContext;
  }
  
  public static int fkG()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return a.a.notification_icon;
    }
    return a.a.notification_icon_gray;
  }
  
  public static String hfu()
  {
    AppMethodBeat.i(116805);
    if (Util.isNullOrNil(QRn)) {
      QRn = com.tencent.mm.kernel.b.awd().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = QRn;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String hfv()
  {
    AppMethodBeat.i(116807);
    if (d.qV(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      MMApplicationContext.getContext();
      if (!com.tencent.mm.n.b.cL(i, j)) {
        Log.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = awc();
    AppMethodBeat.o(116807);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bx.a
 * JD-Core Version:    0.7.0.1
 */