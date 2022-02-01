package com.tencent.d.a.a.a.d;

import com.tencent.d.a.a.a.d.a.d;
import com.tencent.d.a.a.a.d.a.d.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "deleteGift", "", "giftId", "getLiveGiftInfo", "", "insertGiftInfo", "giftInfo", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  extends MAutoStorage<d>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(d.access$getInfo$cp(), "FinderLiveGiftInfo") };
  public static final e.a ahpG = new e.a((byte)0);
  
  static
  {
    d.a locala = d.ahpO;
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract int a(d paramd);
  
  public abstract int axI(String paramString);
  
  public abstract List<d> etX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.e
 * JD-Core Version:    0.7.0.1
 */