package com.tencent.mm.plugin.game.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.di;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.autogen.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "allowCleanPkg", "", "packageName", "", "delDownloadInfo", "getDownloadInfo", "getDownloadStage", "", "getMinCheckInterval", "", "()Ljava/lang/Long;", "getNeedCheckItems", "", "insertDownloadInfo", "", "appId", "interval", "expiredTime", "gameResDownloadList", "Lcom/tencent/mm/plugin/game/autogen/download/GameResDownloadList;", "updateDownloadTaskFinishedTime", "updateItemTime", "intervalTime", "checkCgiTime", "Companion", "plugin-game_release"})
public final class d
  extends MAutoStorage<a>
{
  public static final a CzN;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(205335);
    CzN = new a((byte)0);
    a.a locala = a.CzE;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameResourceDownload") };
    AppMethodBeat.o(205335);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameResourceDownload", di.INDEX_CREATE);
    AppMethodBeat.i(205334);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(205334);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, com.tencent.mm.plugin.game.autogen.a.d paramd)
  {
    AppMethodBeat.i(205330);
    p.k(paramString1, "packageName");
    p.k(paramString2, "appId");
    p.k(paramd, "gameResDownloadList");
    a locala = new a();
    locala.field_packageName = paramString1;
    locala.field_appId = paramString2;
    locala.field_intervalSeconds = paramInt1;
    locala.field_expiredSeconds = paramInt2;
    locala.field_createTime = Util.nowSecond();
    locala.field_checkCgiTime = Util.nowSecond();
    locala.field_finishDownloadTime = Util.nowSecond();
    locala.field_downloadItemList = paramd.toByteArray();
    paramString2 = h.ae(f.class);
    p.j(paramString2, "MMKernel.service(IGameStorage::class.java)");
    boolean bool = ((f)paramString2).evt().insert((IAutoDBItem)locala);
    Log.i("MicroMsg.GameResourceDownloadStorage", "insert db ret:" + bool + ", packageName:" + paramString1 + ", interval:" + paramInt1 + ", expiredTime:" + paramInt2);
    paramString1 = b.CzF;
    b.ewq();
    AppMethodBeat.o(205330);
  }
  
  public final a aJg(String paramString)
  {
    AppMethodBeat.i(205328);
    p.k(paramString, "packageName");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(205328);
      return null;
    }
    paramString = "select * from GameResourceDownload where packageName=\"" + paramString + '"';
    Log.i("MicroMsg.GameResourceDownloadStorage", "getDownloadStage, sql : %s", new Object[] { paramString });
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(205328);
      return null;
    }
    if (localCursor.moveToNext())
    {
      paramString = new a();
      paramString.convertFrom(localCursor);
    }
    for (;;)
    {
      localCursor.close();
      AppMethodBeat.o(205328);
      return paramString;
      paramString = null;
    }
  }
  
  public final int aJh(String paramString)
  {
    AppMethodBeat.i(205332);
    p.k(paramString, "packageName");
    paramString = aJg(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(205332);
      return 0;
    }
    Object localObject = new com.tencent.mm.plugin.game.autogen.a.d();
    for (;;)
    {
      try
      {
        ((com.tencent.mm.plugin.game.autogen.a.d)localObject).parseFrom(paramString.field_downloadItemList);
        paramString = ((com.tencent.mm.plugin.game.autogen.a.d)localObject).CqD;
        if (paramString == null) {
          break;
        }
        paramString = ((Iterable)paramString).iterator();
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (c)paramString.next();
        if (((c)localObject).Cqx == 0L)
        {
          AppMethodBeat.o(205332);
          return 1;
        }
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", "catch err:" + paramString.getMessage());
        AppMethodBeat.o(205332);
        return 0;
      }
      localObject = com.tencent.mm.plugin.downloader.model.d.IF(((c)localObject).Cqx);
      if (localObject != null)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", "downloadUrl:" + ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadUrl + ", status:" + ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status);
        switch (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status)
        {
        }
        AppMethodBeat.o(205332);
        return 1;
      }
    }
    AppMethodBeat.o(205332);
    return 2;
  }
  
  public final void aJi(String paramString)
  {
    AppMethodBeat.i(205333);
    p.k(paramString, "packageName");
    Log.i("MicroMsg.GameResourceDownloadStorage", "updateDownloadTaskFinishedTime, packageName:".concat(String.valueOf(paramString)));
    paramString = aJg(paramString);
    if (paramString != null)
    {
      paramString.field_finishDownloadTime = Util.nowSecond();
      update((IAutoDBItem)paramString, new String[0]);
      AppMethodBeat.o(205333);
      return;
    }
    AppMethodBeat.o(205333);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-game_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.d
 * JD-Core Version:    0.7.0.1
 */