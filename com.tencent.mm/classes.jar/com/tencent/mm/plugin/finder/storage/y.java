package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class y
  extends j<ci>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a szm;
  
  static
  {
    AppMethodBeat.i(203750);
    szm = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    ac.a locala = ac.szs;
    INDEX_CREATE = new String[] { ac.cIV() + " ON " + ci.eZq + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + ci.eZp + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + ci.eZq + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + ci.eZq + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + ci.eZq + "(commentId)" };
    localObject = ac.szs;
    SQL_CREATE = new String[] { j.getCreateSQLs(ac.access$getInfo$cp(), ci.eZq) };
    AppMethodBeat.o(203750);
  }
  
  public y(e parame)
  {
    super(parame, ac.access$getInfo$cp(), ci.eZq, INDEX_CREATE);
    AppMethodBeat.i(203749);
    AppMethodBeat.o(203749);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.y
 * JD-Core Version:    0.7.0.1
 */