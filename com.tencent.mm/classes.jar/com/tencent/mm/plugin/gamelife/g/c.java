package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ct;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-gamelife_release"})
public final class c
  extends j<a>
{
  private static final String[] SQL_CREATE;
  public static final a uJS;
  
  static
  {
    AppMethodBeat.i(212156);
    uJS = new a((byte)0);
    a.a locala = a.uJQ;
    SQL_CREATE = new String[] { j.getCreateSQLs(a.access$getInfo$cp(), "AppMessage") };
    AppMethodBeat.o(212156);
  }
  
  public c(e parame)
  {
    super(parame, a.access$getInfo$cp(), "AppMessage", ct.INDEX_CREATE);
    AppMethodBeat.i(212155);
    AppMethodBeat.o(212155);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.c
 * JD-Core Version:    0.7.0.1
 */