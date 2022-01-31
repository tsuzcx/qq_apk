package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appcache.ap.c;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class b
  implements ap.c, DebuggerShell.a
{
  public final void l(Intent paramIntent)
  {
    g.aZ(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
  
  public final void q(Map<String, String> paramMap)
  {
    String str;
    int i;
    if (DebuggerShell.aeu())
    {
      str = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      i = bk.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (!bk.bl(str)) {}
    }
    else
    {
      return;
    }
    g.aZ(str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */