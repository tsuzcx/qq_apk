package com.tencent.c.a.a.a.d;

import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.a.e.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveNotifyExposureInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveNotifyExposureInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "delAll", "", "delByMsgId", "msgId", "", "getByLiveId", "liveId", "getByMsgId", "getByRevokeId", "revokeId", "getLast48HourItem", "Ljava/util/ArrayList;", "getReplaceableNotify", "ifFinderNotifyExposure", "onFinderNotifyExpose", "", "onReceiveFinderNotify", "input", "updateLiveStatus", "liveStatus", "", "Companion", "plugin-finder-live-api_release"})
public abstract class f
  extends MAutoStorage<e>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(e.access$getInfo$cp(), "FinderLiveNotifyExposureInfo") };
  public static final a ZlQ = new a((byte)0);
  
  static
  {
    e.a locala = e.ZlV;
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void K(long paramLong, int paramInt);
  
  public abstract void Lt(long paramLong);
  
  public abstract boolean Lu(long paramLong);
  
  public abstract e Lv(long paramLong);
  
  public abstract void a(e parame);
  
  public abstract e aCK(String paramString);
  
  public abstract e aCL(String paramString);
  
  public abstract long dDP();
  
  public abstract boolean dDQ();
  
  public abstract ArrayList<e> dDR();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveNotifyExposureInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.f
 * JD-Core Version:    0.7.0.1
 */