package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class aj
  extends MAutoStorage<cm>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a vFp;
  
  static
  {
    AppMethodBeat.i(251887);
    vFp = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    ao.a locala = ao.vFu;
    INDEX_CREATE = new String[] { ao.dyn() + " ON " + cm.fFi + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cm.fFh + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cm.fFi + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cm.fFi + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cm.fFi + "(commentId)" };
    localObject = ao.vFu;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ao.access$getInfo$cp(), cm.fFi) };
    AppMethodBeat.o(251887);
  }
  
  public aj(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ao.access$getInfo$cp(), cm.fFi, INDEX_CREATE);
    AppMethodBeat.i(251886);
    AppMethodBeat.o(251886);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderWxMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aj
 * JD-Core Version:    0.7.0.1
 */