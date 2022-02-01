package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseGameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSelfUsername", "", "getSessionId", "getTalker", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends db
  implements e
{
  private static final IAutoDBItem.MAutoDBInfo info;
  public static final a yct;
  
  static
  {
    AppMethodBeat.i(241418);
    yct = new a((byte)0);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = db.ajs();
    p.g(localMAutoDBInfo, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
    info = localMAutoDBInfo;
    AppMethodBeat.o(241418);
  }
  
  public final String ajO()
  {
    AppMethodBeat.i(241416);
    String str = this.field_talker;
    p.g(str, "field_talker");
    AppMethodBeat.o(241416);
    return str;
  }
  
  public final c dXh()
  {
    return this.field_extInfo;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final String getSelfUsername()
  {
    AppMethodBeat.i(241414);
    String str = this.field_selfUserName;
    p.g(str, "field_selfUserName");
    AppMethodBeat.o(241414);
    return str;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(241415);
    String str = this.field_sessionId;
    p.g(str, "field_sessionId");
    AppMethodBeat.o(241415);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241417);
    String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
    AppMethodBeat.o(241417);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.a
 * JD-Core Version:    0.7.0.1
 */