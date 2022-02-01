package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandPrefetchWxaAttrsMarkTable;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends r
{
  public static final c.a hEe;
  public static final String[] hEf;
  public static final a kav;
  
  static
  {
    AppMethodBeat.i(189010);
    kav = new a((byte)0);
    hEe = r.Vv();
    hEf = new String[] { j.getCreateSQLs(hEe, "AppBrandPrefetchWxaAttrsMarkTable") };
    AppMethodBeat.o(189010);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo$Companion;", "", "()V", "COL_PREFETCHUPDATETIME", "", "COL_USERNAME", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a
 * JD-Core Version:    0.7.0.1
 */