package com.tencent.mm.plugin.gamelife.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseGameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getSelfUsername", "", "getSessionId", "getTalker", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends cw
  implements d
{
  private static final c.a info;
  public static final a uyv;
  
  static
  {
    AppMethodBeat.i(211399);
    uyv = new a((byte)0);
    c.a locala = cw.Vv();
    p.g(locala, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
    info = locala;
    AppMethodBeat.o(211399);
  }
  
  public final String VS()
  {
    AppMethodBeat.i(211397);
    String str = this.field_talker;
    p.g(str, "field_talker");
    AppMethodBeat.o(211397);
    return str;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSelfUsername()
  {
    AppMethodBeat.i(211395);
    String str = this.field_selfUserName;
    p.g(str, "field_selfUserName");
    AppMethodBeat.o(211395);
    return str;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(211396);
    String str = this.field_sessionId;
    p.g(str, "field_sessionId");
    AppMethodBeat.o(211396);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(211398);
    String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
    AppMethodBeat.o(211398);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.a
 * JD-Core Version:    0.7.0.1
 */