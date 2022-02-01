package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class n
  extends MAutoStorage<cr>
{
  public static final a Alk;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(290267);
    Alk = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    an.a locala = an.AmM;
    INDEX_CREATE = new String[] { an.dZl() + " ON " + cr.hUn + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cr.hUn + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cr.hUn + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cr.hUn + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cr.hUn + "(commentId)" };
    localObject = an.AmM;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(an.access$getInfo$cp(), cr.hUn) };
    AppMethodBeat.o(290267);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, an.access$getInfo$cp(), cr.hUn, INDEX_CREATE);
    AppMethodBeat.i(290266);
    AppMethodBeat.o(290266);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.n
 * JD-Core Version:    0.7.0.1
 */