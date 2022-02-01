package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/storage/OpenIMArchiveStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/openim/storage/OpenIMArchive;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends MAutoStorage<e>
{
  public static final a ptS;
  private static final String ptT;
  private static final String[] ptU;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(235761);
    ptS = new a((byte)0);
    ptT = "OpenIMArchive";
    ptU = new String[] { MAutoStorage.getCreateSQLs(e.dbInfo, "OpenIMArchive") };
    AppMethodBeat.o(235761);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.dbInfo, "OpenIMArchive", null);
    AppMethodBeat.i(235757);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(235757);
  }
  
  public static final String[] bSq()
  {
    return ptU;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/storage/OpenIMArchiveStorage$Companion;", "", "()V", "TABLE", "", "getTABLE", "()Ljava/lang/String;", "TABLE_CREATE_SQL", "", "kotlin.jvm.PlatformType", "getTABLE_CREATE_SQL$annotations", "getTABLE_CREATE_SQL", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.f
 * JD-Core Version:    0.7.0.1
 */