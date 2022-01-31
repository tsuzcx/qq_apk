package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.LauncherUI;
import java.util.Map;

public final class n
  implements f
{
  static n jMI;
  
  private static void GD(String paramString)
  {
    AppMethodBeat.i(18273);
    Context localContext = ah.getContext();
    Intent localIntent = new Intent(localContext, LauncherUI.class);
    localIntent.putExtra("Intro_Notify", true);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    String str = paramString;
    if (!bo.isNullOrNil(paramString))
    {
      str = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        str = paramString.substring(16);
      }
    }
    paramString = str;
    if (!bo.isNullOrNil(str))
    {
      paramString = str;
      if (str.startsWith("<"))
      {
        Map localMap = br.F(str, "e");
        paramString = str;
        if (localMap != null)
        {
          paramString = str;
          if (!bo.isNullOrNil((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
    }
    paramString = a.br(localContext, a.dkN()).e(paramString).f(null);
    paramString.ya = PendingIntent.getActivity(localContext, 0, localIntent, 268435456);
    paramString = paramString.build();
    paramString.icon = a.bYt();
    paramString.flags = 16;
    aw.getNotification().c(paramString);
    AppMethodBeat.o(18273);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(18272);
    if ((paramInt1 == 4) && (!aw.Rc().foreground)) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(18272);
      return;
    case -311: 
    case -310: 
    case -205: 
    case -72: 
    case -9: 
    case -6: 
    case -4: 
    case -3: 
      GD(ah.getContext().getString(2131301418));
      aw.hold();
      AppMethodBeat.o(18272);
      return;
    case -140: 
      ab.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[] { paramString });
      if (!bo.isNullOrNil(paramString)) {
        GD(paramString);
      }
      for (;;)
      {
        aw.hold();
        AppMethodBeat.o(18272);
        return;
        GD(ah.getContext().getString(2131301418));
      }
    case -100: 
      GD(ah.getContext().getString(2131301416));
      w.ct(ah.getContext());
      aw.hold();
      AppMethodBeat.o(18272);
      return;
    case -999999: 
      new ak().post(new n.1(this));
      AppMethodBeat.o(18272);
      return;
    }
    paramString = ah.getContext().getSharedPreferences("system_config_prefs", 0);
    long l = paramString.getLong("recomended_update_ignore", -1L);
    if ((l != -1L) && (bo.gz(l) < 86400L))
    {
      ab.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(l)));
      AppMethodBeat.o(18272);
      return;
    }
    if (paramInt2 == -17) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      paramm = ah.getContext();
      Object localObject = new Intent(paramm, LauncherUI.class);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("nofification_type", "update_nofification");
      ((Intent)localObject).putExtra("show_update_dialog", true);
      ((Intent)localObject).putExtra("update_type", paramInt1);
      localObject = PendingIntent.getActivity(paramm, 0, (Intent)localObject, 0);
      paramm = a.br(paramm, "reminder_channel_id").h(null).g(System.currentTimeMillis()).e(paramm.getString(2131297096)).f(paramm.getString(2131297053));
      paramm.ya = ((PendingIntent)localObject);
      paramm = paramm.build();
      paramm.flags |= 0x10;
      aw.getNotification().a(34, paramm, false);
      paramString.edit().putLong("recomended_update_ignore", bo.aox()).commit();
      h.qsU.idkeyStat(405L, 27L, 1L, true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.n
 * JD-Core Version:    0.7.0.1
 */