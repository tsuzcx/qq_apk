package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "Lcom/tencent/mm/autogen/table/BaseGameLifeAppMessage;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "toWxAppMessage", "Lcom/tencent/mm/message/AppMessage;", "Companion", "plugin-gamelife_release"})
public final class a
  extends ct
{
  private static final c.a info;
  public static final a uJQ;
  
  static
  {
    AppMethodBeat.i(212148);
    uJQ = new a((byte)0);
    info = ct.VD();
    AppMethodBeat.o(212148);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(212147);
    c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(212147);
    return locala;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage$Companion;", "", "()V", "TABLE_NAME", "", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.a
 * JD-Core Version:    0.7.0.1
 */