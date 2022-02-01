package com.tencent.mm.plugin.gamelife.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-gamelife_release"})
public final class c
  extends MAutoStorage<a>
{
  private static final String[] SQL_CREATE;
  public static final a ycj;
  
  static
  {
    AppMethodBeat.i(241399);
    ycj = new a((byte)0);
    a.a locala = a.ych;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "AppMessage") };
    AppMethodBeat.o(241399);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "AppMessage", cy.INDEX_CREATE);
    AppMethodBeat.i(241398);
    AppMethodBeat.o(241398);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeAppMessageStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.g.c
 * JD-Core Version:    0.7.0.1
 */