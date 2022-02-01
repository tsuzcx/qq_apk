package com.tencent.mm.plugin.game.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ds;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.autogen.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/download/GameResourceDownload;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "allowCleanPkg", "", "packageName", "", "delDownloadInfo", "getDownloadInfo", "getDownloadStage", "", "getMinCheckInterval", "", "()Ljava/lang/Long;", "getNeedCheckItems", "", "insertDownloadInfo", "", "appId", "interval", "expiredTime", "gameResDownloadList", "Lcom/tencent/mm/plugin/game/autogen/download/GameResDownloadList;", "updateDownloadTaskFinishedTime", "updateItemTime", "intervalTime", "checkCgiTime", "Companion", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MAutoStorage<a>
{
  public static final d.a Ity;
  private static final String[] SQL_CREATE;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(275338);
    Ity = new d.a((byte)0);
    a.a locala = a.Itv;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameResourceDownload") };
    AppMethodBeat.o(275338);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameResourceDownload", ds.INDEX_CREATE);
    AppMethodBeat.i(275325);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(275325);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, com.tencent.mm.plugin.game.autogen.a.d paramd)
  {
    AppMethodBeat.i(275330);
    s.u(paramString1, "packageName");
    s.u(paramString2, "appId");
    s.u(paramd, "gameResDownloadList");
    a locala = new a();
    locala.field_packageName = paramString1;
    locala.field_appId = paramString2;
    locala.field_intervalSeconds = paramInt1;
    locala.field_expiredSeconds = paramInt2;
    locala.field_createTime = Util.nowSecond();
    locala.field_checkCgiTime = Util.nowSecond();
    locala.field_finishDownloadTime = Util.nowSecond();
    locala.field_downloadItemList = paramd.toByteArray();
    boolean bool = ((f)h.ax(f.class)).fCm().insert((IAutoDBItem)locala);
    Log.i("MicroMsg.GameResourceDownloadStorage", "insert db ret:" + bool + ", packageName:" + paramString1 + ", interval:" + paramInt1 + ", expiredTime:" + paramInt2);
    paramString1 = b.Itw;
    b.fEh();
    AppMethodBeat.o(275330);
  }
  
  public final a aFS(String paramString)
  {
    AppMethodBeat.i(275342);
    s.u(paramString, "packageName");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275342);
      return null;
    }
    paramString = "select * from GameResourceDownload where packageName=\"" + paramString + '"';
    Log.i("MicroMsg.GameResourceDownloadStorage", "getDownloadStage, sql : %s", new Object[] { paramString });
    Cursor localCursor = rawQuery(paramString, new String[0]);
    if (localCursor == null)
    {
      AppMethodBeat.o(275342);
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
      AppMethodBeat.o(275342);
      return paramString;
      paramString = null;
    }
  }
  
  public final int aFT(String paramString)
  {
    AppMethodBeat.i(275350);
    s.u(paramString, "packageName");
    paramString = aFS(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(275350);
      return 0;
    }
    Object localObject = new com.tencent.mm.plugin.game.autogen.a.d();
    for (;;)
    {
      try
      {
        ((com.tencent.mm.plugin.game.autogen.a.d)localObject).parseFrom(paramString.field_downloadItemList);
        paramString = ((com.tencent.mm.plugin.game.autogen.a.d)localObject).IcM;
        if (paramString == null) {
          break;
        }
        paramString = ((Iterable)paramString).iterator();
        if (!paramString.hasNext()) {
          break;
        }
        localObject = (c)paramString.next();
        if (((c)localObject).IcG == 0L)
        {
          AppMethodBeat.o(275350);
          return 1;
        }
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", s.X("catch err:", paramString.getMessage()));
        AppMethodBeat.o(275350);
        return 0;
      }
      localObject = com.tencent.mm.plugin.downloader.model.d.la(((c)localObject).IcG);
      if (localObject != null)
      {
        Log.i("MicroMsg.GameResourceDownloadStorage", "downloadUrl:" + ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadUrl + ", status:" + ((com.tencent.mm.plugin.downloader.f.a)localObject).field_status);
        switch (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status)
        {
        }
        AppMethodBeat.o(275350);
        return 1;
      }
    }
    AppMethodBeat.o(275350);
    return 2;
  }
  
  public final void aFU(String paramString)
  {
    AppMethodBeat.i(275358);
    s.u(paramString, "packageName");
    Log.i("MicroMsg.GameResourceDownloadStorage", s.X("updateDownloadTaskFinishedTime, packageName:", paramString));
    paramString = aFS(paramString);
    if (paramString != null)
    {
      paramString.field_finishDownloadTime = Util.nowSecond();
      update((IAutoDBItem)paramString, new String[0]);
    }
    AppMethodBeat.o(275358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.d
 * JD-Core Version:    0.7.0.1
 */