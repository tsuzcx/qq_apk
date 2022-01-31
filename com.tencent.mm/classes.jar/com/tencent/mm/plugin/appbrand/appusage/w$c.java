package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import java.util.ArrayList;
import java.util.Locale;

public final class w$c
{
  private w$c(w paramw) {}
  
  public final ArrayList<AppBrandRecentTaskInfo> hs(long paramLong)
  {
    AppMethodBeat.i(129674);
    Object localObject = w.a(this.hcq);
    String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
    String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(30) });
    localObject = w.d(((h)localObject).a("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
    AppMethodBeat.o(129674);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w.c
 * JD-Core Version:    0.7.0.1
 */