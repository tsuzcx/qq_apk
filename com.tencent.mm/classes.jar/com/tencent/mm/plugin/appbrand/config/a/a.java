package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandPrefetchWxaAttrsMarkTable;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends r
{
  public static final c.a gLr;
  public static final String[] gLs;
  public static final a jfX;
  
  static
  {
    AppMethodBeat.i(196251);
    jfX = new a((byte)0);
    gLr = r.So();
    gLs = new String[] { j.getCreateSQLs(gLr, "AppBrandPrefetchWxaAttrsMarkTable") };
    AppMethodBeat.o(196251);
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo$Companion;", "", "()V", "COL_PREFETCHUPDATETIME", "", "COL_USERNAME", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a
 * JD-Core Version:    0.7.0.1
 */