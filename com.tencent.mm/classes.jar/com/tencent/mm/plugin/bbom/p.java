package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bq.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import java.util.Map;

public final class p
  implements i
{
  static p pfc;
  
  private static void ahd(String paramString)
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
    paramString = a.cd(localContext, a.glE()).f(paramString).g(null);
    paramString.Hv = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
    paramString = paramString.build();
    paramString.icon = a.ezb();
    paramString.flags = 16;
    bg.getNotification().c(paramString);
    AppMethodBeat.o(22379);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(22378);
    if ((paramInt1 == 4) && (!bg.azz().foreground)) {}
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
      ahd(MMApplicationContext.getContext().getString(2131762851));
      bg.hold();
      AppMethodBeat.o(22378);
      return;
    case -140: 
      Log.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!Util.isNullOrNil(paramString)) {
        ahd(paramString);
      }
      for (;;)
      {
        bg.hold();
        AppMethodBeat.o(22378);
        return;
        ahd(MMApplicationContext.getContext().getString(2131762851));
      }
    case -2023: 
    case -100: 
      ahd(MMApplicationContext.getContext().getString(2131762849));
      com.tencent.mm.platformtools.t.ds(MMApplicationContext.getContext());
      bg.hold();
      AppMethodBeat.o(22378);
      return;
    case -999999: 
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22377);
          bg.hold();
          MMAppMgr.Bj(true);
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
      paramq = MMApplicationContext.getContext();
      Object localObject = new Intent(paramq, LauncherUI.class);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("nofification_type", "update_nofification");
      ((Intent)localObject).putExtra("show_update_dialog", true);
      ((Intent)localObject).putExtra("update_type", paramInt1);
      localObject = PendingIntent.getActivity(paramq, 0, (Intent)localObject, 0);
      paramq = a.cd(paramq, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(paramq.getString(2131756007)).g(paramq.getString(2131755959));
      paramq.Hv = ((PendingIntent)localObject);
      paramq = paramq.build();
      paramq.flags |= 0x10;
      bg.getNotification().a(34, paramq, false);
      paramString.edit().putLong("recomended_update_ignore", Util.nowSecond()).commit();
      h.CyF.idkeyStat(405L, 27L, 1L, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */