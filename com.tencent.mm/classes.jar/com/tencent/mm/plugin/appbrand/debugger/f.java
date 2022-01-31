package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class f
  implements DebuggerShell.a
{
  public final void l(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("username");
    String str2 = paramIntent.getStringExtra("appId");
    String str3 = paramIntent.getStringExtra("path");
    int i = bk.getInt(paramIntent.getStringExtra("versionType"), 0);
    int j = bk.getInt(paramIntent.getStringExtra("scene"), 1030);
    paramIntent = paramIntent.getStringExtra("sceneNote");
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = j;
    localAppBrandStatObject.bFv = paramIntent;
    ((d)g.r(d.class)).a(ae.getContext(), str1, str2, i, 0, str3, localAppBrandStatObject);
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