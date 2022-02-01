package com.tencent.mm.model;

import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.UUID;

public final class cm
{
  Map<String, String> hFw;
  
  public cm(Map<String, String> paramMap)
  {
    this.hFw = paramMap;
  }
  
  final PendingIntent E(String paramString, long paramLong)
  {
    AppMethodBeat.i(186356);
    String str;
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
      str = "com.tencent.mm.ui.LauncherUI";
    }
    for (;;)
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(ak.getContext(), str);
      localIntent.setFlags(536870912);
      localIntent.putExtra("LauncherUI.Show.Update.DialogMsg", (String)this.hFw.get(".sysmsg.WakenPush.PushContent"));
      if (!paramString.equals("weixin://dl/update_newest_version")) {
        localIntent.putExtra("LauncherUI.Show.Update.Url", (String)this.hFw.get(".sysmsg.WakenPush.Jump"));
      }
      g.yxI.idkeyStat(405L, 32L, 1L, true);
      paramString = PendingIntent.getActivity(ak.getContext(), UUID.randomUUID().hashCode(), localIntent, 134217728);
      AppMethodBeat.o(186356);
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
        ae.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { paramString });
        str = "com.tencent.mm.ui.LauncherUI";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.cm
 * JD-Core Version:    0.7.0.1
 */