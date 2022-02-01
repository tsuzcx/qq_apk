package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.df;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseGameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSelfUsername", "", "getSessionId", "getTalker", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends df
  implements e
{
  public static final a DhY;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(203210);
    DhY = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = df.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(203210);
  }
  
  public final String apJ()
  {
    AppMethodBeat.i(203206);
    String str = this.field_talker;
    p.j(str, "field_talker");
    AppMethodBeat.o(203206);
    return str;
  }
  
  public final c eAq()
  {
    return this.field_extInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getSelfUsername()
  {
    AppMethodBeat.i(203203);
    String str = this.field_selfUserName;
    p.j(str, "field_selfUserName");
    AppMethodBeat.o(203203);
    return str;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(203205);
    String str = this.field_sessionId;
    p.j(str, "field_sessionId");
    AppMethodBeat.o(203205);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203208);
    String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
    AppMethodBeat.o(203208);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.a
 * JD-Core Version:    0.7.0.1
 */