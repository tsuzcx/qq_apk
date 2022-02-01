package com.tencent.mm.plugin.game.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ds;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "Lcom/tencent/mm/autogen/table/BaseGameResourceDownload;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends ds
{
  public static final a Itv;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(275320);
    Itv = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ds.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(BaseGameR…urceDownload::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(275320);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/download/GameResourceDownload$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a
 * JD-Core Version:    0.7.0.1
 */