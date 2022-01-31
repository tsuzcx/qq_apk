package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.cf.h;
import java.util.ArrayList;
import java.util.Locale;

public final class w$c
{
  private w$c(w paramw) {}
  
  public final ArrayList<AppBrandRecentTaskInfo> cu(long paramLong)
  {
    h localh = w.a(this.fJx);
    String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
    String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(30) });
    return w.f(localh.a("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w.c
 * JD-Core Version:    0.7.0.1
 */