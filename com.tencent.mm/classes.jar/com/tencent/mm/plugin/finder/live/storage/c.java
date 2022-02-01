package com.tencent.mm.plugin.finder.live.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.c.a.a.a.d.a.b;
import com.tencent.c.a.a.a.d.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteGift", "", "giftId", "", "getLiveGiftInfo", "", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "insertGiftInfo", "giftInfo", "Companion", "plugin-finder-live_release"})
public final class c
  extends com.tencent.c.a.a.a.d.c
{
  public static final a yOg;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(233230);
    yOg = new a((byte)0);
    AppMethodBeat.o(233230);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.access$getInfo$cp(), "FinderLiveGiftInfo", cl.INDEX_CREATE);
    AppMethodBeat.i(233229);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(233229);
  }
  
  public final int a(b paramb)
  {
    AppMethodBeat.i(233226);
    p.k(paramb, "giftInfo");
    ContentValues localContentValues = paramb.convertTo();
    int i = (int)this.db.replace("FinderLiveGiftInfo", "rewardProductId", localContentValues);
    Log.i("Finder.FinderLiveGiftStorage", "insert gift " + paramb + ' ' + i);
    AppMethodBeat.o(233226);
    return i;
  }
  
  public final int aCH(String paramString)
  {
    AppMethodBeat.i(233227);
    int i = this.db.delete("FinderLiveGiftInfo", "rewardProductId=?", new String[] { String.valueOf(paramString) });
    AppMethodBeat.o(233227);
    return i;
  }
  
  public final List<b> dDN()
  {
    AppMethodBeat.i(233228);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT *, rowid FROM FinderLiveGiftInfo order by FinderLiveGiftInfo.giftIndex asc", null, 2);
    while (localCursor.moveToNext())
    {
      b localb = new b();
      localb.convertFrom(localCursor);
      ((ArrayList)localObject).add(localb);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(233228);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.c
 * JD-Core Version:    0.7.0.1
 */