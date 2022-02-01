package com.tencent.c.a.a.a.d;

import com.tencent.c.a.a.a.d.a.f;
import com.tencent.c.a.a.a.d.a.f.a;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "getBeautyConfig", "Lcom/tencent/mm/protocal/protobuf/LiveBeautyConfig;", "getFilterConfig", "Lcom/tencent/mm/protocal/protobuf/LiveFilterConfig;", "Companion", "plugin-finder-live-api_release"})
public abstract class b
  extends MAutoStorage<f>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(f.access$getInfo$cp(), "FinderLiveConfig") };
  public static final a ZlM = new a((byte)0);
  
  static
  {
    f.a locala = f.ZlW;
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract crp dDM();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage$Companion;", "", "()V", "KEY_BEAUTY_CONFIG", "", "KEY_FILTER_CONFIG", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.b
 * JD-Core Version:    0.7.0.1
 */