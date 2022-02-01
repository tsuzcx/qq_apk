package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class q
  extends j<cf>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final q.a rEs;
  
  static
  {
    AppMethodBeat.i(203001);
    rEs = new q.a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    u.a locala = u.rEy;
    INDEX_CREATE = new String[] { u.cAZ() + " ON " + cf.eHq + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cf.eHp + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cf.eHq + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cf.eHq + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cf.eHq + "(commentId)" };
    localObject = u.rEy;
    SQL_CREATE = new String[] { j.getCreateSQLs(u.access$getInfo$cp(), cf.eHq) };
    AppMethodBeat.o(203001);
  }
  
  public q(e parame)
  {
    super(parame, u.access$getInfo$cp(), cf.eHq, INDEX_CREATE);
    AppMethodBeat.i(203000);
    AppMethodBeat.o(203000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.q
 * JD-Core Version:    0.7.0.1
 */