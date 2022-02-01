package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  implements DebuggerShell.a
{
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44950);
    String str1 = paramIntent.getStringExtra("username");
    String str2 = paramIntent.getStringExtra("appId");
    String str3 = paramIntent.getStringExtra("path");
    int i = bu.getInt(paramIntent.getStringExtra("versionType"), 0);
    int j = bu.getInt(paramIntent.getStringExtra("scene"), 1030);
    paramIntent = paramIntent.getStringExtra("sceneNote");
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = j;
    localAppBrandStatObject.dlj = paramIntent;
    ((p)com.tencent.mm.kernel.g.ab(p.class)).a(ak.getContext(), str1, str2, i, 0, str3, localAppBrandStatObject);
    AppMethodBeat.o(44950);
  }
  
  public final String name()
  {
    return "LaunchApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g
 * JD-Core Version:    0.7.0.1
 */