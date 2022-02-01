package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class j
  extends com.tencent.mm.sdk.e.j<ci>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a sxV;
  
  static
  {
    AppMethodBeat.i(203663);
    sxV = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    ac.a locala = ac.szs;
    INDEX_CREATE = new String[] { ac.cIV() + " ON " + ci.eZp + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + ci.eZp + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + ci.eZp + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + ci.eZp + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + ci.eZp + "(commentId)" };
    localObject = ac.szs;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(ac.access$getInfo$cp(), ci.eZp) };
    AppMethodBeat.o(203663);
  }
  
  public j(e parame)
  {
    super(parame, ac.access$getInfo$cp(), ci.eZp, INDEX_CREATE);
    AppMethodBeat.i(203662);
    AppMethodBeat.o(203662);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.j
 * JD-Core Version:    0.7.0.1
 */