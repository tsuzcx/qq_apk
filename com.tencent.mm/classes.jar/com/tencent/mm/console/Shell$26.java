package com.tencent.mm.console;

import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

final class Shell$26
  implements Shell.a
{
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231519);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "OpenWeApp not coolassist or monkey env, disable hprof dump cmd.");
      AppMethodBeat.o(231519);
      return;
    }
    if (!MMApplicationContext.isMMProcess())
    {
      AppMethodBeat.o(231519);
      return;
    }
    paramIntent = paramIntent.getStringExtra("kContent");
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(231519);
      return;
    }
    Object localObject = XmlParser.parseXml(new String(Base64.decode(paramIntent, 0)), "sysmsg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(231519);
      return;
    }
    paramIntent = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
    String str = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
    int i = Util.getInt((String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), 0);
    int j = Util.getInt((String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), 0);
    localObject = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramIntent;
    localg.username = str;
    localg.iOo = i;
    localg.version = j;
    localg.kHw = ((String)localObject);
    localg.scene = 1030;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), localg);
    AppMethodBeat.o(231519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.Shell.26
 * JD-Core Version:    0.7.0.1
 */