package com.tencent.d.a.a.a.d;

import com.tencent.d.a.a.a.d.a.g;
import com.tencent.d.a.a.a.d.a.g.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveNotifyExposureInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "delAll", "", "delByMsgId", "msgId", "", "getByLiveId", "liveId", "getByMsgId", "getByRevokeId", "revokeId", "getLast48HourItem", "Ljava/util/ArrayList;", "getReplaceableNotify", "ifFinderNotifyExposure", "onFinderNotifyExpose", "", "onReceiveFinderNotify", "input", "filterByLiveId", "updateLiveStatus", "liveStatus", "", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h
  extends MAutoStorage<g>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(g.access$getInfo$cp(), "FinderLiveNotifyExposureInfo") };
  public static final h.a ahpJ = new h.a((byte)0);
  
  static
  {
    g.a locala = g.ahpR;
  }
  
  public h(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void V(long paramLong, int paramInt);
  
  public abstract void a(g paramg, boolean paramBoolean);
  
  public abstract g axL(String paramString);
  
  public abstract long etZ();
  
  public abstract boolean eua();
  
  public abstract ArrayList<g> eub();
  
  public abstract void oA(long paramLong);
  
  public abstract boolean oB(long paramLong);
  
  public abstract g oC(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.h
 * JD-Core Version:    0.7.0.1
 */