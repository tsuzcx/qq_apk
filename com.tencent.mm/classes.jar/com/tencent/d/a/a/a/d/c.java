package com.tencent.d.a.a.a.d;

import com.tencent.d.a.a.a.d.a.h;
import com.tencent.d.a.a.a.d.a.h.a;
import com.tencent.mm.protocal.protobuf.din;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveConfigStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveSetting;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "getBeautyConfig", "Lcom/tencent/mm/protocal/protobuf/LiveBeautyConfig;", "getFilterConfig", "Lcom/tencent/mm/protocal/protobuf/LiveFilterConfig;", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  extends MAutoStorage<h>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(h.access$getInfo$cp(), "FinderLiveConfig") };
  public static final c.a ahpE = new c.a((byte)0);
  
  static
  {
    h.a locala = h.ahpS;
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract din etW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.c
 * JD-Core Version:    0.7.0.1
 */