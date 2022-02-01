package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hf;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo;", "Lcom/tencent/mm/autogen/table/BaseWxaTokenInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "app_release"})
public final class b
  extends hf
{
  private static final c.a info;
  public static final a qsW;
  
  static
  {
    AppMethodBeat.i(39599);
    qsW = new a((byte)0);
    info = hf.Th();
    AppMethodBeat.o(39599);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(39598);
    c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(39598);
    return locala;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.b
 * JD-Core Version:    0.7.0.1
 */