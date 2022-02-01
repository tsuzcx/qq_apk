package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "Lcom/tencent/mm/autogen/table/BaseGameResourceDownload;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-game_release"})
public final class a
  extends de
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a xvK;
  
  static
  {
    AppMethodBeat.i(204329);
    xvK = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = de.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(BaseGameR…urceDownload::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(204329);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-game_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.a
 * JD-Core Version:    0.7.0.1
 */