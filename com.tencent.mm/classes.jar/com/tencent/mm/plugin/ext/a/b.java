package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.id;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo;", "Lcom/tencent/mm/autogen/table/BaseWxaTokenInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "app_release"})
public final class b
  extends id
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a sMw;
  
  static
  {
    AppMethodBeat.i(39599);
    sMw = new a((byte)0);
    info = id.ajs();
    AppMethodBeat.o(39599);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(39598);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(39598);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.b
 * JD-Core Version:    0.7.0.1
 */