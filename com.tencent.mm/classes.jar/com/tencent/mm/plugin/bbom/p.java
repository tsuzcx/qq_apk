package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.bq.a;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import java.util.Map;

public final class p
  implements com.tencent.mm.am.h
{
  private static p vtb;
  
  private static void aif(String paramString)
  {
    AppMethodBeat.i(22379);
    Context localContext = MMApplicationContext.getContext();
    Intent localIntent = new Intent(localContext, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!Util.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!Util.isNullOrNil(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = XmlParser.parseXml(str, "e", null);
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!Util.isNullOrNil((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = a.cA(localContext, a.iGp()).l(paramString).m(null);
    paramString.bor = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
    paramString = paramString.DA();
    paramString.icon = a.guX();
    paramString.flags = 16;
    bh.getNotification().d(paramString);
    AppMethodBeat.o(22379);
  }
  
  public static void dax()
  {
    AppMethodBeat.i(260641);
    com.tencent.mm.kernel.h.aZW().b(138, vtb);
    com.tencent.mm.kernel.h.aZW().b(39, vtb);
    com.tencent.mm.kernel.h.aZW().b(268369922, vtb);
    if (vtb == null) {
      vtb = new p();
    }
    com.tencent.mm.kernel.h.aZW().a(138, vtb);
    com.tencent.mm.kernel.h.aZW().a(39, vtb);
    com.tencent.mm.kernel.h.aZW().a(268369922, vtb);
    AppMethodBeat.o(260641);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(22378);
    if ((paramInt1 == 4) && (!bh.aZW().foreground)) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(22378);
      return;
    case -311: 
    case -310: 
    case -205: 
    case -72: 
    case -9: 
    case -6: 
    case -4: 
    case -3: 
      aif(MMApplicationContext.getContext().getString(R.l.main_err_relogin));
      bh.aZH();
      AppMethodBeat.o(22378);
      return;
    case -140: 
      Log.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!Util.isNullOrNil(paramString)) {
        aif(paramString);
      }
      for (;;)
      {
        bh.aZH();
        AppMethodBeat.o(22378);
        return;
        aif(MMApplicationContext.getContext().getString(R.l.main_err_relogin));
      }
    case -2023: 
    case -100: 
      aif(MMApplicationContext.getContext().getString(R.l.main_err_another_place));
      bh.aZH();
      AppMethodBeat.o(22378);
      return;
    case -999999: 
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22377);
          bh.aZH();
          MMAppMgr.Lj(true);
          AppMethodBeat.o(22377);
        }
      });
      AppMethodBeat.o(22378);
      return;
    }
    paramString = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (Util.secondsToNow(l) < 86400L))
    {
      Log.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(l)));
      AppMethodBeat.o(22378);
      return;
    }
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramp = MMApplicationContext.getContext();
      Object localObject = new Intent(paramp, LauncherUI.class);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("nofification_type", "update_nofification");
      ((Intent)localObject).putExtra("show_update_dialog", true);
      ((Intent)localObject).putExtra("update_type", paramInt1);
      localObject = PendingIntent.getActivity(paramp, 0, (Intent)localObject, 0);
      paramp = a.cA(paramp, "reminder_channel_id").o(null).bt(System.currentTimeMillis()).l(paramp.getString(R.l.app_update_package_notify)).m(paramp.getString(R.l.app_recommend_update));
      paramp.bor = ((PendingIntent)localObject);
      paramp = paramp.DA();
      paramp.flags |= 0x10;
      bh.getNotification().a(34, paramp, false);
      paramString.edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 27L, 1L, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */