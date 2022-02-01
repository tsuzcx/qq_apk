package com.tencent.mm.bq;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.format.Time;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bn.a.a.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  private static String XNd = "";
  private static String XNe = "";
  private static String lZF = "";
  
  public static void DG(String paramString)
  {
    AppMethodBeat.i(230938);
    lZF = paramString;
    com.tencent.mm.k.b.DG(paramString);
    AppMethodBeat.o(230938);
  }
  
  public static String aQB()
  {
    AppMethodBeat.i(116804);
    if (Util.isNullOrNil(lZF)) {
      lZF = com.tencent.mm.kernel.b.aQC().getString("message_channel_id", "message_channel_new_id");
    }
    String str = lZF;
    AppMethodBeat.o(116804);
    return str;
  }
  
  public static void boM(String paramString)
  {
    XNe = paramString;
  }
  
  public static f.d cA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(230940);
    paramContext = new f.d(paramContext, paramString);
    AppMethodBeat.o(230940);
    return paramContext;
  }
  
  public static int guX()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return a.a.notification_icon;
    }
    return a.a.notification_icon_gray;
  }
  
  public static String iGo()
  {
    AppMethodBeat.i(116805);
    if (Util.isNullOrNil(XNd)) {
      XNd = com.tencent.mm.kernel.b.aQC().getString("voip_notify_channel_new_id", "voip_notify_channel_new_id");
    }
    String str = XNd;
    AppMethodBeat.o(116805);
    return str;
  }
  
  public static String iGp()
  {
    AppMethodBeat.i(116807);
    if (d.rb(26))
    {
      localObject = new Time();
      ((Time)localObject).setToNow();
      int i = ((Time)localObject).hour;
      int j = ((Time)localObject).minute;
      MMApplicationContext.getContext();
      if (!com.tencent.mm.k.b.dB(i, j)) {
        Log.w("MicroMsg.NotificationHelper", "no shake & sound notification during background deactive time");
      }
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(116807);
        return "message_dnd_mode_channel_id";
      }
    }
    Object localObject = aQB();
    AppMethodBeat.o(116807);
    return localObject;
  }
  
  public static String iGq()
  {
    AppMethodBeat.i(230941);
    String str;
    if (Util.isNullOrNil(XNe))
    {
      str = com.tencent.mm.kernel.b.aQC().getString("login_channel_id", "");
      XNe = str;
      if (!Util.isNullOrNil(str)) {
        break label62;
      }
      ((com.tencent.mm.plugin.notification.b.a)h.ax(com.tencent.mm.plugin.notification.b.a.class)).aKX();
    }
    for (;;)
    {
      str = XNe;
      AppMethodBeat.o(230941);
      return str;
      label62:
      if (((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(XNe) == null) {
        ((com.tencent.mm.plugin.notification.b.a)h.ax(com.tencent.mm.plugin.notification.b.a.class)).aKX();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bq.a
 * JD-Core Version:    0.7.0.1
 */