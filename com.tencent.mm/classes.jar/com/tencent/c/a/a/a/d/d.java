package com.tencent.c.a.a.a.d;

import com.tencent.c.a.a.a.d.a.c;
import com.tencent.c.a.a.a.d.a.c.a;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveLastRewardInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "delByLiveId", "", "liveId", "getByLiveId", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "insertOrUpdate", "infoList", "Companion", "plugin-finder-live-api_release"})
public abstract class d
  extends MAutoStorage<c>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(c.access$getInfo$cp(), "FinderLiveLastRewardInfo") };
  public static final a ZlO = new a((byte)0);
  
  static
  {
    c.a locala = c.ZlT;
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract LinkedList<bbv> aCI(String paramString);
  
  public abstract void aCJ(String paramString);
  
  public abstract void e(String paramString, LinkedList<bbv> paramLinkedList);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLastRewardInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.d
 * JD-Core Version:    0.7.0.1
 */