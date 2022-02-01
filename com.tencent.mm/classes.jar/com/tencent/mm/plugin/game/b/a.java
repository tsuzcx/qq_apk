package com.tencent.mm.plugin.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.di;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "Lcom/tencent/mm/autogen/table/BaseGameResourceDownload;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-game_release"})
public final class a
  extends di
{
  public static final a CzE;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(193138);
    CzE = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = di.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(BaseGameR…urceDownload::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(193138);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-game_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a
 * JD-Core Version:    0.7.0.1
 */