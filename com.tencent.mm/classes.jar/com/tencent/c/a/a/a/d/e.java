package com.tencent.c.a.a.a.d;

import com.tencent.c.a.a.a.d.a.d;
import com.tencent.c.a.a.a.d.a.d.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveLuckyMoneyInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "clearCache", "", "liveId", "", "initCache", "isAvailableLuckyMoney", "", "sendId", "saveCache", "updateCache", "Companion", "plugin-finder-live-api_release"})
public abstract class e
  extends MAutoStorage<d>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(d.access$getInfo$cp(), "FinderLiveLuckyMoneyInfo") };
  public static final a ZlP = new a((byte)0);
  
  static
  {
    d.a locala = d.ZlU;
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void Lh(long paramLong);
  
  public abstract void Ls(long paramLong);
  
  public abstract void dDO();
  
  public abstract void v(long paramLong, String paramString);
  
  public abstract boolean w(long paramLong, String paramString);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.e
 * JD-Core Version:    0.7.0.1
 */