package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class d
  implements bj.c, DebuggerShell.a
{
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    i.cjb().u(str, i);
    AppMethodBeat.o(44946);
  }
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(243896);
    if (DebuggerShell.bLS())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = Util.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(243896);
        return;
      }
      i.cjb().u(paramString, i);
    }
    AppMethodBeat.o(243896);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */