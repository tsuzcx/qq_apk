package com.tencent.d.a.a.a.d;

import com.tencent.d.a.a.a.d.a.e;
import com.tencent.d.a.a.a.d.a.e.a;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveLastRewardInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "delByLiveId", "", "liveId", "getByLiveId", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "insertOrUpdate", "infoList", "Companion", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
  extends MAutoStorage<e>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(e.access$getInfo$cp(), "FinderLiveLastRewardInfo") };
  public static final a ahpH = new a((byte)0);
  
  static
  {
    e.a locala = e.ahpP;
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract LinkedList<blq> axJ(String paramString);
  
  public abstract void axK(String paramString);
  
  public abstract void e(String paramString, LinkedList<blq> paramLinkedList);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.a.a.d.f
 * JD-Core Version:    0.7.0.1
 */