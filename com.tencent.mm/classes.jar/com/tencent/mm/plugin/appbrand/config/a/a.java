package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandPrefetchWxaAttrsMarkTable;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends r
{
  public static final c.a hGW;
  public static final String[] hGX;
  public static final a kdM;
  
  static
  {
    AppMethodBeat.i(223269);
    kdM = new a((byte)0);
    hGW = r.VD();
    hGX = new String[] { j.getCreateSQLs(hGW, "AppBrandPrefetchWxaAttrsMarkTable") };
    AppMethodBeat.o(223269);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo$Companion;", "", "()V", "COL_PREFETCHUPDATETIME", "", "COL_USERNAME", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a
 * JD-Core Version:    0.7.0.1
 */