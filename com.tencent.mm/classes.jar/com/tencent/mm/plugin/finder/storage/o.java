package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cz;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderMention;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends MAutoStorage<cz>
{
  public static final a FKK;
  private static final String[] INDEX_CREATE;
  private static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(339206);
    FKK = new a((byte)0);
    Object localObject = new StringBuilder("CREATE INDEX IF NOT EXISTS ");
    av.a locala = av.FMF;
    INDEX_CREATE = new String[] { av.eZU() + " ON " + cz.ktM + " ( id, flag, type, userVersion)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Id_Create_Time ON " + cz.ktM + "(createTime, id)", "CREATE INDEX IF NOT EXISTS Finder_Mention_Type ON " + cz.ktM + "(type)", "CREATE INDEX IF NOT EXISTS Finder_Object_Id ON " + cz.ktM + "(objectId)", "CREATE INDEX IF NOT EXISTS Finder_Comment_Id ON " + cz.ktM + "(commentId)" };
    localObject = av.FMF;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(av.access$getInfo$cp(), cz.ktM) };
    AppMethodBeat.o(339206);
  }
  
  public o(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, av.access$getInfo$cp(), cz.ktM, INDEX_CREATE);
    AppMethodBeat.i(339196);
    AppMethodBeat.o(339196);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderFinderMentionStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "getSQL_CREATE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.o
 * JD-Core Version:    0.7.0.1
 */