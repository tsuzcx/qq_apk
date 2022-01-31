package com.tencent.mm.plugin.appbrand.v.c;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;

final class b$1
  extends a.b
{
  b$1(b paramb) {}
  
  protected final Intent aqC()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
    localIntent.putExtra("extra_pkgname", ae.getPackageName());
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.b.1
 * JD-Core Version:    0.7.0.1
 */