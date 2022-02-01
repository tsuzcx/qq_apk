package com.tencent.c.a.a.a.d;

import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveActionRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "hadEverAction", "", "anchorUserName", "action", "Lcom/tencent/plugin/finder/live/api/constants/ConstantsFinderLive$FinderLiveAction;", "recordAction", "", "Companion", "plugin-finder-live-api_release"})
public abstract class a
  extends MAutoStorage<com.tencent.c.a.a.a.d.a.a>
{
  private static final String[] SQL_CREATE = { MAutoStorage.getCreateSQLs(com.tencent.c.a.a.a.d.a.a.access$getInfo$cp(), "FinderLiveActionRecord") };
  public static final a ZlL = new a((byte)0);
  
  static
  {
    com.tencent.c.a.a.a.d.a.a.a locala = com.tencent.c.a.a.a.d.a.a.ZlR;
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
  }
  
  public abstract void a(String paramString, com.tencent.c.a.a.a.b.a.a parama);
  
  public abstract boolean b(String paramString, com.tencent.c.a.a.a.b.a.a parama);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveActionRecordStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE_NAME", "plugin-finder-live-api_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.c.a.a.a.d.a
 * JD-Core Version:    0.7.0.1
 */