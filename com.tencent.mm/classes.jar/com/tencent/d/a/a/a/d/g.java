package com.tencent.d.a.a.a.d;

import com.tencent.d.a.a.a.d.a.f;
import com.tencent.d.a.a.a.d.a.f.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveLuckyMoneyInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "clearCache", "", "liveId", "", "initCache", "isAvailableLuckyMoney", "", "sendId", "saveCache", "updateCache", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class g
  extends MAutoStorage<f>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(f.access$getInfo$cp(), "FinderLiveLuckyMoneyInfo") };
  public static final a ahpI = new a((byte)0);
  
  static
  {
    f.a locala = f.ahpQ;
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void F(long paramLong, String paramString);
  
  public abstract boolean G(long paramLong, String paramString);
  
  public abstract void etY();
  
  public abstract void nU(long paramLong);
  
  public abstract void oz(long paramLong);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.g
 * JD-Core Version:    0.7.0.1
 */