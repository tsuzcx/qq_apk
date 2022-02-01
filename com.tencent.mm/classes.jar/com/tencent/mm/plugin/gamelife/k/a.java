package com.tencent.mm.plugin.gamelife.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dp;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseGameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSelfUsername", "", "getSessionId", "getTalker", "toString", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends dp
  implements e
{
  public static final a JbP;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(267988);
    JbP = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = dp.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(267988);
  }
  
  public final String aJK()
  {
    AppMethodBeat.i(268013);
    String str = this.field_talker;
    s.s(str, "field_talker");
    AppMethodBeat.o(268013);
    return str;
  }
  
  public final c fIq()
  {
    return this.field_extInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getSelfUsername()
  {
    AppMethodBeat.i(268000);
    String str = this.field_selfUserName;
    s.s(str, "field_selfUserName");
    AppMethodBeat.o(268000);
    return str;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(268006);
    String str = this.field_sessionId;
    s.s(str, "field_sessionId");
    AppMethodBeat.o(268006);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(268032);
    String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
    AppMethodBeat.o(268032);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.k.a
 * JD-Core Version:    0.7.0.1
 */