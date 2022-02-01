package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bc.c;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class c
  implements bc.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    f.bQ(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
    AppMethodBeat.o(44946);
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(195705);
    if (DebuggerShell.aTY())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = bt.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(195705);
        return;
      }
      f.bQ(paramString, i);
    }
    AppMethodBeat.o(195705);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.c
 * JD-Core Version:    0.7.0.1
 */