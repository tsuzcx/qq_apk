package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteGift", "", "giftId", "", "getLiveGiftInfo", "", "insertGiftInfo", "giftInfo", "Companion", "plugin-finder_release"})
public final class t
  extends MAutoStorage<s>
{
  private static final String[] SQL_CREATE;
  public static final a vEj;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(251803);
    vEj = new a((byte)0);
    s.a locala = s.vEi;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(s.access$getInfo$cp(), "FinderLiveGiftInfo") };
    AppMethodBeat.o(251803);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, s.access$getInfo$cp(), "FinderLiveGiftInfo", cj.INDEX_CREATE);
    AppMethodBeat.i(251802);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(251802);
  }
  
  public final int b(s params)
  {
    AppMethodBeat.i(251800);
    p.h(params, "giftInfo");
    ContentValues localContentValues = params.convertTo();
    int i = (int)this.db.replace("FinderLiveGiftInfo", "rewardProductId", localContentValues);
    Log.i("Finder.FinderLiveGiftStorage", "insert gift " + params + ' ' + i);
    AppMethodBeat.o(251800);
    return i;
  }
  
  public final List<s> dxR()
  {
    AppMethodBeat.i(251801);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT *, rowid FROM FinderLiveGiftInfo order by FinderLiveGiftInfo.giftIndex asc", null, 2);
    while (localCursor.moveToNext())
    {
      s locals = new s();
      locals.convertFrom(localCursor);
      ((ArrayList)localObject).add(locals);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(251801);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderLiveGiftStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.t
 * JD-Core Version:    0.7.0.1
 */