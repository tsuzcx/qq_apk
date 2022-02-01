package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be.c;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class d
  implements be.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    f.cc(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
    AppMethodBeat.o(44946);
  }
  
  public final void l(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(222247);
    if (DebuggerShell.bfe())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = bu.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(222247);
        return;
      }
      f.cc(paramString, i);
    }
    AppMethodBeat.o(222247);
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