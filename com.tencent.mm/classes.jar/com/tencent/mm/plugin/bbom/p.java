package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.br.a;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import java.util.Map;

public final class p
  implements f
{
  static p nOI;
  
  private static void Wy(String paramString)
  {
    AppMethodBeat.i(22379);
    Context localContext = aj.getContext();
    Intent localIntent = new Intent(localContext, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!bt.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!bt.isNullOrNil(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = bw.M(str, "e");
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!bt.isNullOrNil((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = a.bI(localContext, a.eYF()).f(paramString).g(null);
    paramString.Hl = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
    paramString = paramString.build();
    paramString.icon = a.dwe();
    paramString.flags = 16;
    ba.getNotification().c(paramString);
    AppMethodBeat.o(22379);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22378);
    if ((paramInt1 == 4) && (!ba.aiU().foreground)) {}
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
      Wy(aj.getContext().getString(2131761065));
      ba.hold();
      AppMethodBeat.o(22378);
      return;
    case -140: 
      ad.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!bt.isNullOrNil(paramString)) {
        Wy(paramString);
      }
      for (;;)
      {
        ba.hold();
        AppMethodBeat.o(22378);
        return;
        Wy(aj.getContext().getString(2131761065));
      }
    case -100: 
      Wy(aj.getContext().getString(2131761063));
      t.cV(aj.getContext());
      ba.hold();
      AppMethodBeat.o(22378);
      return;
    case -999999: 
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(22377);
          ba.hold();
          MMAppMgr.xm(true);
          AppMethodBeat.o(22377);
        }
      });
      AppMethodBeat.o(22378);
      return;
    }
    paramString = aj.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (bt.rM(l) < 86400L))
    {
      ad.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(l)));
      AppMethodBeat.o(22378);
      return;
    }
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramn = aj.getContext();
      Object localObject = new Intent(paramn, LauncherUI.class);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("nofification_type", "update_nofification");
      ((Intent)localObject).putExtra("show_update_dialog", true);
      ((Intent)localObject).putExtra("update_type", paramInt1);
      localObject = PendingIntent.getActivity(paramn, 0, (Intent)localObject, 0);
      paramn = a.bI(paramn, "reminder_channel_id").i(null).i(System.currentTimeMillis()).f(paramn.getString(2131755915)).g(paramn.getString(2131755870));
      paramn.Hl = ((PendingIntent)localObject);
      paramn = paramn.build();
      paramn.flags |= 0x10;
      ba.getNotification().a(34, paramn, false);
      paramString.edit().putLong("recomended_update_ignore", bt.aQJ()).commit();
      g.yhR.idkeyStat(405L, 27L, 1L, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.p
 * JD-Core Version:    0.7.0.1
 */