package com.tencent.mm.plugin.appbrand.v.c;

import android.content.ComponentName;
import android.content.Intent;

final class b$2
  extends a.b
{
  b$2(b paramb) {}
  
  protected final Intent aqC()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.oppo.launcher", "com.oppo.launcher.shortcut.ShortcutSettingsActivity"));
    localIntent.setAction("coloros.intent.action.launcher.SHORTCUT_SETTINGS");
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.b.2
 * JD-Core Version:    0.7.0.1
 */