package com.tencent.d.a.a.a.d;

import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveVideoDefinitionStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveVideoDefinitionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "deleteAll", "", "deleteDefinition", "liveId", "", "initDefinition", "insertDefinition", "level", "", "saveDefinition", "selectDefinition", "updateDefinition", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
  extends MAutoStorage<com.tencent.d.a.a.a.d.a.i>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(com.tencent.d.a.a.a.d.a.i.access$getInfo$cp(), "FinderLiveVideoDefinitionInfo") };
  public static final a ahpK = new a((byte)0);
  
  static
  {
    com.tencent.d.a.a.a.d.a.i.a locala = com.tencent.d.a.a.a.d.a.i.ahpT;
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void W(long paramLong, int paramInt);
  
  public abstract void euc();
  
  public abstract void eud();
  
  public abstract int oD(long paramLong);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveVideoDefinitionStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.i
 * JD-Core Version:    0.7.0.1
 */