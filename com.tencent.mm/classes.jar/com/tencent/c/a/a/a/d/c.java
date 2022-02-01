package com.tencent.c.a.a.a.d;

import com.tencent.c.a.a.a.d.a.b;
import com.tencent.c.a.a.a.d.a.b.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "deleteGift", "", "giftId", "getLiveGiftInfo", "", "insertGiftInfo", "giftInfo", "Companion", "plugin-finder-live-api_release"})
public abstract class c
  extends MAutoStorage<b>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(b.access$getInfo$cp(), "FinderLiveGiftInfo") };
  public static final a ZlN = new a((byte)0);
  
  static
  {
    b.a locala = b.ZlS;
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract int a(b paramb);
  
  public abstract int aCH(String paramString);
  
  public abstract List<b> dDN();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.c
 * JD-Core Version:    0.7.0.1
 */