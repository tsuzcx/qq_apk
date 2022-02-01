package com.tencent.mm.model;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.UUID;

public final class ck
{
  Map<String, String> hCE;
  
  public ck(Map<String, String> paramMap)
  {
    this.hCE = paramMap;
  }
  
  final PendingIntent E(String paramString, long paramLong)
  {
    AppMethodBeat.i(193115);
    String str;
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
      str = "com.tencent.mm.ui.LauncherUI";
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(aj.getContext(), str);
      localIntent.setFlags(536870912);
      localIntent.putExtra("LauncherUI.Show.Update.DialogMsg", (String)this.hCE.get(".sysmsg.WakenPush.PushContent"));
      if (!paramString.equals("weixin://dl/update_newest_version")) {
        localIntent.putExtra("LauncherUI.Show.Update.Url", (String)this.hCE.get(".sysmsg.WakenPush.Jump"));
      }
      g.yhR.idkeyStat(405L, 32L, 1L, true);
      paramString = PendingIntent.getActivity(aj.getContext(), UUID.randomUUID().hashCode(), localIntent, 134217728);
      AppMethodBeat.o(193115);
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
        ad.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { paramString });
        str = "com.tencent.mm.ui.LauncherUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ck
 * JD-Core Version:    0.7.0.1
 */