package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "Lcom/tencent/mm/autogen/table/BaseAppBrandPrefetchWxaAttrsMarkTable;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends r
{
  public static final IAutoDBItem.MAutoDBInfo iBg;
  public static final String[] iBh;
  public static final a lhs;
  
  static
  {
    AppMethodBeat.i(228171);
    lhs = new a((byte)0);
    iBg = r.ajs();
    iBh = new String[] { MAutoStorage.getCreateSQLs(iBg, "AppBrandPrefetchWxaAttrsMarkTable") };
    AppMethodBeat.o(228171);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo$Companion;", "", "()V", "COL_PREFETCHUPDATETIME", "", "COL_USERNAME", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE_CREATE", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.a
 * JD-Core Version:    0.7.0.1
 */