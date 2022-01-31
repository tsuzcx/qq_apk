package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.av.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class c
  implements av.c, DebuggerShell.a
{
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(129941);
    h.bt(paramIntent.getStringExtra("appId"), paramIntent.getIntExtra("versionType", 0));
    AppMethodBeat.o(129941);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
  
  public final void t(Map<String, String> paramMap)
  {
    AppMethodBeat.i(129940);
    if (DebuggerShell.ayQ())
    {
      String str = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = bo.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(129940);
        return;
      }
      h.bt(str, i);
    }
    AppMethodBeat.o(129940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.c
 * JD-Core Version:    0.7.0.1
 */