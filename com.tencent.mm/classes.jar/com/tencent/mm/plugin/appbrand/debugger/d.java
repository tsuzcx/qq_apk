package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bd.c;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class d
  implements bd.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    f.bY(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
    AppMethodBeat.o(44946);
  }
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188122);
    if (DebuggerShell.bew())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = bt.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188122);
        return;
      }
      f.bY(paramString, i);
    }
    AppMethodBeat.o(188122);
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