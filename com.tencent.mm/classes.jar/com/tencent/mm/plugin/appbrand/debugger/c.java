package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bc.c;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class c
  implements bc.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    f.bV(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
    AppMethodBeat.o(44946);
  }
  
  public final void i(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(186426);
    if (DebuggerShell.baW())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = bs.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(186426);
        return;
      }
      f.bV(paramString, i);
    }
    AppMethodBeat.o(186426);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.c
 * JD-Core Version:    0.7.0.1
 */