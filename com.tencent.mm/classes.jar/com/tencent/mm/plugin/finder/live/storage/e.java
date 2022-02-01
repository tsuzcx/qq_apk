package com.tencent.mm.plugin.finder.live.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.d.a.a.a.d.a.d;
import com.tencent.d.a.a.a.d.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.cs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveGiftStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "deleteGift", "", "giftId", "", "getLiveGiftInfo", "", "Lcom/tencent/plugin/finder/live/api/storage/model/FinderLiveGiftInfo;", "insertGiftInfo", "giftInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.d.a.a.a.d.e
{
  public static final a DHx;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351377);
    DHx = new a((byte)0);
    AppMethodBeat.o(351377);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.access$getInfo$cp(), "FinderLiveGiftInfo", cs.INDEX_CREATE);
    AppMethodBeat.i(351367);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(351367);
  }
  
  public final int a(d paramd)
  {
    AppMethodBeat.i(351390);
    s.u(paramd, "giftInfo");
    ContentValues localContentValues = paramd.convertTo();
    int i = (int)this.db.replace("FinderLiveGiftInfo", "rewardProductId", localContentValues);
    Log.i("Finder.FinderLiveGiftStorage", "insert gift " + paramd + ' ' + i);
    AppMethodBeat.o(351390);
    return i;
  }
  
  public final int axI(String paramString)
  {
    AppMethodBeat.i(351402);
    int i = this.db.delete("FinderLiveGiftInfo", "rewardProductId=?", new String[] { s.X("", paramString) });
    AppMethodBeat.o(351402);
    return i;
  }
  
  public final List<d> etX()
  {
    AppMethodBeat.i(351415);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT *, rowid FROM FinderLiveGiftInfo order by FinderLiveGiftInfo.giftIndex asc", null, 2);
    while (localCursor.moveToNext())
    {
      d locald = new d();
      locald.convertFrom(localCursor);
      ((ArrayList)localObject).add(locald);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(351415);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveGiftStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.e
 * JD-Core Version:    0.7.0.1
 */