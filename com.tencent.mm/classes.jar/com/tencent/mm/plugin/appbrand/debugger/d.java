package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class d
  implements be.c, DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    h.bWb().cl(str, i);
    AppMethodBeat.o(44946);
  }
  
  public final void l(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(226506);
    if (DebuggerShell.bAx())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = Util.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(226506);
        return;
      }
      h.bWb().cl(paramString, i);
    }
    AppMethodBeat.o(226506);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */