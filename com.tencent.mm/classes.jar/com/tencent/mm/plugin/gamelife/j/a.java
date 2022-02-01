package com.tencent.mm.plugin.gamelife.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "Lcom/tencent/mm/autogen/table/BaseGameLifeSessionInfo;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getExtInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSelfUsername", "", "getSessionId", "getTalker", "toString", "Companion", "plugin-gamelife_release"})
public final class a
  extends cw
  implements e
{
  private static final c.a info;
  public static final a uJY;
  
  static
  {
    AppMethodBeat.i(212177);
    uJY = new a((byte)0);
    c.a locala = cw.VD();
    p.g(locala, "initAutoDBInfo(GameLifeSessionInfo::class.java)");
    info = locala;
    AppMethodBeat.o(212177);
  }
  
  public final String Wa()
  {
    AppMethodBeat.i(212175);
    String str = this.field_talker;
    p.g(str, "field_talker");
    AppMethodBeat.o(212175);
    return str;
  }
  
  public final c ddw()
  {
    return this.field_extInfo;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final String getSelfUsername()
  {
    AppMethodBeat.i(212173);
    String str = this.field_selfUserName;
    p.g(str, "field_selfUserName");
    AppMethodBeat.o(212173);
    return str;
  }
  
  public final String getSessionId()
  {
    AppMethodBeat.i(212174);
    String str = this.field_sessionId;
    p.g(str, "field_sessionId");
    AppMethodBeat.o(212174);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(212176);
    String str = "GameLifeSessionInfo(self:" + this.field_selfUserName + " talker:" + this.field_talker + " sessionId:" + this.field_sessionId + ')';
    AppMethodBeat.o(212176);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.a
 * JD-Core Version:    0.7.0.1
 */