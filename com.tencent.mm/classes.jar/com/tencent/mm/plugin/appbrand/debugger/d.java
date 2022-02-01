package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bj.c;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.Objects;

public final class d
  implements bj.c, DebuggerShell.a
{
  public final void D(Intent paramIntent)
  {
    AppMethodBeat.i(44946);
    String str = paramIntent.getStringExtra("appId");
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(44946);
      return;
    }
    int i = paramIntent.getIntExtra("versionType", 0);
    i.cJV().F((String)Objects.requireNonNull(str), i);
    AppMethodBeat.o(44946);
  }
  
  public final void k(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(319681);
    if (DebuggerShell.cls())
    {
      paramString = (String)paramMap.get(".sysmsg.AppBrandForceKill.AppId");
      int i = Util.getInt((String)paramMap.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(319681);
        return;
      }
      i.cJV().F(paramString, i);
    }
    AppMethodBeat.o(319681);
  }
  
  public final String name()
  {
    return "ForceKillAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.d
 * JD-Core Version:    0.7.0.1
 */