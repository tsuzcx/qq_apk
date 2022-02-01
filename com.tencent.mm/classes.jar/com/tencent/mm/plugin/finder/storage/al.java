package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.de;
import com.tencent.mm.plugin.finder.conv.p;
import com.tencent.mm.plugin.finder.conv.p.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderShareInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderShareInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteShareInfo", "", "shareInfo", "getByUserName", "username", "", "query", "", "offset", "", "nextCount", "queryLimit", "limitCount", "updateShareInfos", "userNames", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends MAutoStorage<p>
{
  public static final a FMu;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339408);
    FMu = new a((byte)0);
    p.a locala = p.AHe;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(p.access$getInfo$cp(), "FinderShareInfo") };
    AppMethodBeat.o(339408);
  }
  
  public al(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, p.access$getInfo$cp(), "FinderShareInfo", de.INDEX_CREATE);
    AppMethodBeat.i(339399);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(339399);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderShareInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.al
 * JD-Core Version:    0.7.0.1
 */