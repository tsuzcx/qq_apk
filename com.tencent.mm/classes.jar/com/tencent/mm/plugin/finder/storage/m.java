package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"})
public final class m
  extends MAutoStorage<cm>
{
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  public static final a vDN;
  
  static
  {
    AppMethodBeat.i(251732);
    vDN = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    ao.a locala = ao.vFu;
    INDEX_CREATE = new String[] { ao.dyn() + " ON " + cm.fFh + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cm.fFh + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cm.fFh + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cm.fFh + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cm.fFh + "(commentId)" };
    localObject = ao.vFu;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ao.access$getInfo$cp(), cm.fFh) };
    AppMethodBeat.o(251732);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, ao.access$getInfo$cp(), cm.fFh, INDEX_CREATE);
    AppMethodBeat.i(251731);
    AppMethodBeat.o(251731);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.m
 * JD-Core Version:    0.7.0.1
 */