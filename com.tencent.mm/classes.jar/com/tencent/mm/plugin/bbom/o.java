package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bq.a;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import java.util.Map;

public final class o
  implements g
{
  static o nnU;
  
  private static void Tb(String paramString)
  {
    AppMethodBeat.i(22379);
    Context localContext = ai.getContext();
    Intent localIntent = new Intent(localContext, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!bs.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!bs.isNullOrNil(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = bv.L(str, "e");
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!bs.isNullOrNil((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = a.bE(localContext, a.eJR()).f(paramString).g(null);
    paramString.Fu = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
    paramString = paramString.build();
    paramString.icon = a.dlN();
    paramString.flags = 16;
    az.getNotification().c(paramString);
    AppMethodBeat.o(22379);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22378);
    if ((paramInt1 == 4) && (!az.agi().foreground)) {}
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
      Tb(ai.getContext().getString(2131761065));
      az.hold();
      AppMethodBeat.o(22378);
      return;
    case -140: 
      ac.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!bs.isNullOrNil(paramString)) {
        Tb(paramString);
      }
      for (;;)
      {
        az.hold();
        AppMethodBeat.o(22378);
        return;
        Tb(ai.getContext().getString(2131761065));
      }
    case -100: 
      Tb(ai.getContext().getString(2131761063));
      t.cX(ai.getContext());
      az.hold();
      AppMethodBeat.o(22378);
      return;
    case -999999: 
      new ao().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22377);
          az.hold();
          MMAppMgr.wA(true);
          AppMethodBeat.o(22377);
        }
      });
      AppMethodBeat.o(22378);
      return;
    }
    paramString = ai.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (bs.pN(l) < 86400L))
    {
      ac.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(l)));
      AppMethodBeat.o(22378);
      return;
    }
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramn = ai.getContext();
      Object localObject = new Intent(paramn, LauncherUI.class);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("nofification_type", "update_nofification");
      ((Intent)localObject).putExtra("show_update_dialog", true);
      ((Intent)localObject).putExtra("update_type", paramInt1);
      localObject = PendingIntent.getActivity(paramn, 0, (Intent)localObject, 0);
      paramn = a.bE(paramn, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(paramn.getString(2131755915)).g(paramn.getString(2131755870));
      paramn.Fu = ((PendingIntent)localObject);
      paramn = paramn.build();
      paramn.flags |= 0x10;
      az.getNotification().a(34, paramn, false);
      paramString.edit().putLong("recomended_update_ignore", bs.aNx()).commit();
      h.wUl.idkeyStat(405L, 27L, 1L, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.o
 * JD-Core Version:    0.7.0.1
 */