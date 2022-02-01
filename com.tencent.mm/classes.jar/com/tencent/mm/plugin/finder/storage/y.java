package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class y
  extends j<ci>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final y.a sKd;
  
  static
  {
    AppMethodBeat.i(204317);
    sKd = new y.a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    ac.a locala = ac.sKj;
    INDEX_CREATE = new String[] { ac.cLx() + " ON " + ci.fbd + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + ci.fbc + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + ci.fbd + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + ci.fbd + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + ci.fbd + "(commentId)" };
    localObject = ac.sKj;
    SQL_CREATE = new String[] { j.getCreateSQLs(ac.access$getInfo$cp(), ci.fbd) };
    AppMethodBeat.o(204317);
  }
  
  public y(e parame)
  {
    super(parame, ac.access$getInfo$cp(), ci.fbd, INDEX_CREATE);
    AppMethodBeat.i(204316);
    AppMethodBeat.o(204316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.y
 * JD-Core Version:    0.7.0.1
 */