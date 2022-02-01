package com.tencent.mm.plugin.game.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.b.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "allowCleanPkg", "", "packageName", "", "delDownloadInfo", "getDownloadInfo", "getDownloadStage", "", "getMinCheckInterval", "", "()Ljava/lang/Long;", "getNeedCheckItems", "", "insertDownloadInfo", "", "appId", "interval", "expiredTime", "gameResDownloadList", "Lcom/tencent/mm/plugin/game/autogen/download/GameResDownloadList;", "updateDownloadTaskFinishedTime", "updateItemTime", "intervalTime", "checkCgiTime", "Companion", "plugin-game_release"})
public final class d
  extends MAutoStorage<a>
{
  private static final String[] SQL_CREATE;
  public static final d.a xvT;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(204358);
    xvT = new d.a((byte)0);
    a.a locala = a.xvK;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameResourceDownload") };
    AppMethodBeat.o(204358);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameResourceDownload", de.INDEX_CREATE);
    AppMethodBeat.i(204357);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(204357);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, com.tencent.mm.plugin.game.b.a.d paramd)
  {
    AppMethodBeat.i(204354);
    p.h(paramString1, "packageName");
    p.h(paramString2, "appId");
    p.h(paramd, "gameResDownloadList");
    a locala = new a();
    locala.field_packageName = paramString1;
    locala.field_appId = paramString2;
    locala.field_intervalSeconds = paramInt1;
    locala.field_expiredSeconds = paramInt2;
    locala.field_createTime = Util.nowSecond();
    locala.field_checkCgiTime = Util.nowSecond();
    locala.field_finishDownloadTime = Util.nowSecond();
    locala.field_downloadItemList = paramd.toByteArray();
    paramString2 = g.af(f.class);
    p.g(paramString2, "MMKernel.service(IGameStorage::class.java)");
    boolean bool = ((f)paramString2).dSP().insert((IAutoDBItem)locala);
    Log.i("MicroMsg.GameResourceDownloadStorage", "insert db ret:" + bool + ", packageName:" + paramString1 + ", interval:" + paramInt1 + ", expiredTime:" + paramInt2);
    paramString1 = b.xvL;
    b.dTh();
    AppMethodBeat.o(204354);
  }
  
  public final a azw(String paramString)
  {
    AppMethodBeat.i(204353);
    p.h(paramString, "packageName");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204353);
      return null;
    }
    paramString = "select * from GameResourceDownload where packageName=\"" + paramString + '"';
    Log.i("MicroMsg.GameResourceDownloadStorage", "getDownloadStage, sql : %s", new Object[] { paramString });
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(204353);
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
      AppMethodBeat.o(204353);
      return paramString;
      paramString = null;
    }
  }
  
  public final int azx(String paramString)
  {
    AppMethodBeat.i(204355);
    p.h(paramString, "packageName");
    paramString = azw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(204355);
      return 0;
    }
    Object localObject = new com.tencent.mm.plugin.game.b.a.d();
    for (;;)
    {
      try
      {
        ((com.tencent.mm.plugin.game.b.a.d)localObject).parseFrom(paramString.field_downloadItemList);
        paramString = ((com.tencent.mm.plugin.game.b.a.d)localObject).xum;
        if (paramString == null) {
          break;
        }
        paramString = ((Iterable)paramString).iterator();
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (c)paramString.next();
        if (((c)localObject).xug == 0L)
        {
          AppMethodBeat.o(204355);
          return 1;
        }
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", "catch err:" + paramString.getMessage());
        AppMethodBeat.o(204355);
        return 0;
      }
      localObject = com.tencent.mm.plugin.downloader.model.d.Cw(((c)localObject).xug);
      if (localObject != null)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", "downloadUrl:" + ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadUrl + ", status:" + ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status);
        switch (((com.tencent.mm.plugin.downloader.g.a)localObject).field_status)
        {
        }
        AppMethodBeat.o(204355);
        return 1;
      }
    }
    AppMethodBeat.o(204355);
    return 2;
  }
  
  public final void azy(String paramString)
  {
    AppMethodBeat.i(204356);
    p.h(paramString, "packageName");
    Log.i("MicroMsg.GameResourceDownloadStorage", "updateDownloadTaskFinishedTime, packageName:".concat(String.valueOf(paramString)));
    paramString = azw(paramString);
    if (paramString != null)
    {
      paramString.field_finishDownloadTime = Util.nowSecond();
      update((IAutoDBItem)paramString, new String[0]);
      AppMethodBeat.o(204356);
      return;
    }
    AppMethodBeat.o(204356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.d
 * JD-Core Version:    0.7.0.1
 */