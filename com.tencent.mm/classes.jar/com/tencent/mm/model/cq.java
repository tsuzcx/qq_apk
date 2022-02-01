package com.tencent.mm.model;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.UUID;

public final class cq
{
  Map<String, String> izF;
  
  public cq(Map<String, String> paramMap)
  {
    this.izF = paramMap;
  }
  
  final PendingIntent F(String paramString, long paramLong)
  {
    AppMethodBeat.i(231538);
    String str;
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
      str = "com.tencent.mm.ui.LauncherUI";
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(MMApplicationContext.getContext(), str);
      localIntent.setFlags(536870912);
      localIntent.putExtra("LauncherUI.Show.Update.DialogMsg", (String)this.izF.get(".sysmsg.WakenPush.PushContent"));
      if (!paramString.equals("weixin://dl/update_newest_version")) {
        localIntent.putExtra("LauncherUI.Show.Update.Url", (String)this.izF.get(".sysmsg.WakenPush.Jump"));
      }
      h.CyF.idkeyStat(405L, 32L, 1L, true);
      paramString = PendingIntent.getActivity(MMApplicationContext.getContext(), UUID.randomUUID().hashCode(), localIntent, 134217728);
      AppMethodBeat.o(231538);
      return paramString;
      if (((0x4 & paramLong) == 4L) && (paramString.startsWith("weixin://dl/moments")))
      {
        str = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
      }
      else if (((0x40000 & paramLong) == 262144L) && (paramString.startsWith("weixin://dl/recommendation")))
      {
        str = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
      }
      else
      {
        Log.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { paramString });
        str = "com.tencent.mm.ui.LauncherUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cq
 * JD-Core Version:    0.7.0.1
 */