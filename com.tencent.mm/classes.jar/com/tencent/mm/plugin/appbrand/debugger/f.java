package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  implements DebuggerShell.a
{
  public final void B(Intent paramIntent)
  {
    AppMethodBeat.i(129945);
    String str1 = paramIntent.getStringExtra("username");
    String str2 = paramIntent.getStringExtra("appId");
    String str3 = paramIntent.getStringExtra("path");
    int i = bo.getInt(paramIntent.getStringExtra("versionType"), 0);
    int j = bo.getInt(paramIntent.getStringExtra("scene"), 1030);
    paramIntent = paramIntent.getStringExtra("sceneNote");
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = j;
    localAppBrandStatObject.cmF = paramIntent;
    ((j)g.E(j.class)).a(ah.getContext(), str1, str2, i, 0, str3, localAppBrandStatObject);
    AppMethodBeat.o(129945);
  }
  
  public final String name()
  {
    return "LaunchApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.f
 * JD-Core Version:    0.7.0.1
 */