package com.tencent.mm.plugin.finder.live.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.cw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveVideoDefinitionStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveVideoDefinitionStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "definitionCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "", "deleteAll", "", "deleteDefinition", "liveId", "initDefinition", "insertDefinition", "level", "saveCacheInternal", "saveDefinition", "selectDefinition", "updateDefinition", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.d.a.a.a.d.i
{
  public static final a DHz;
  private final LruCache<Long, Integer> DHA;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351410);
    DHz = new a((byte)0);
    AppMethodBeat.o(351410);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.d.a.a.a.d.a.i.access$getInfo$cp(), "FinderLiveVideoDefinitionInfo", cw.INDEX_CREATE);
    AppMethodBeat.i(351403);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = aw.Gjk;
    if (aw.bgV()) {}
    for (int i = 5;; i = 100)
    {
      this.DHA = new LruCache(i);
      AppMethodBeat.o(351403);
      return;
    }
  }
  
  public final void W(long paramLong, int paramInt)
  {
    AppMethodBeat.i(351449);
    this.DHA.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    a locala = a.DJT;
    a.hQ("FinderLiveVideoDefinitionStorage", "updateDefinition liveId:" + paramLong + ",level:" + paramInt + ",cache size:" + this.DHA.size());
    AppMethodBeat.o(351449);
  }
  
  public final void euc()
  {
    AppMethodBeat.i(351427);
    boolean bool = this.DHA.entrySet().isEmpty();
    if (bool)
    {
      Cursor localCursor = this.db.rawQuery("SELECT * FROM FinderLiveVideoDefinitionInfo", null, 2);
      while (localCursor.moveToNext())
      {
        com.tencent.d.a.a.a.d.a.i locali = new com.tencent.d.a.a.a.d.a.i();
        locali.convertFrom(localCursor);
        this.DHA.put(Long.valueOf(locali.field_liveId), Integer.valueOf(locali.field_definition));
      }
      localCursor.close();
    }
    Log.i("FinderLiveVideoDefinitionStorage", "initDefinition: " + z.bAM() + ", isEmpty:" + bool + ", cache size:" + this.DHA.size());
    AppMethodBeat.o(351427);
  }
  
  public final void eud()
  {
    AppMethodBeat.i(351443);
    Object localObject1 = this.DHA.entrySet();
    s.s(localObject1, "definitionCache.entrySet()");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    long l;
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = ((Map.Entry)localObject1).getKey();
      s.s(localObject2, "it.key");
      l = ((Number)localObject2).longValue();
      localObject1 = ((Map.Entry)localObject1).getValue();
      s.s(localObject1, "it.value");
      i = ((Number)localObject1).intValue();
      localObject1 = s.X("SELECT * FROM FinderLiveVideoDefinitionInfo where FinderLiveVideoDefinitionInfo.liveId=", d.hF(l));
      localObject2 = this.db.rawQuery((String)localObject1, null, 2);
      if (((Cursor)localObject2).moveToNext())
      {
        localObject1 = new com.tencent.d.a.a.a.d.a.i();
        ((com.tencent.d.a.a.a.d.a.i)localObject1).convertFrom((Cursor)localObject2);
        if (((com.tencent.d.a.a.a.d.a.i)localObject1).field_definition == i) {
          break label416;
        }
      }
    }
    label416:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.d.a.a.a.d.a.i)localObject1).field_definition = i;
      boolean bool2 = false;
      boolean bool3 = bool1;
      label185:
      ((Cursor)localObject2).close();
      if (bool3) {
        bool1 = replace((IAutoDBItem)localObject1);
      }
      for (;;)
      {
        Log.i("FinderLiveVideoDefinitionStorage", "saveCache " + ((com.tencent.d.a.a.a.d.a.i)localObject1).field_liveId + ',' + ((com.tencent.d.a.a.a.d.a.i)localObject1).field_definition + ",needReplay:" + bool3 + ", needInsert:" + bool2 + ", result:" + bool1);
        break;
        localObject1 = new com.tencent.d.a.a.a.d.a.i();
        ((com.tencent.d.a.a.a.d.a.i)localObject1).field_liveId = l;
        ((com.tencent.d.a.a.a.d.a.i)localObject1).field_definition = i;
        Log.i("FinderLiveVideoDefinitionStorage", s.X("create new video definition info:", localObject1));
        bool2 = true;
        bool3 = false;
        break label185;
        if (bool2)
        {
          localObject2 = ((com.tencent.d.a.a.a.d.a.i)localObject1).convertTo();
          if (this.db.insert("FinderLiveVideoDefinitionInfo", "liveId", (ContentValues)localObject2) > 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      Log.i("FinderLiveVideoDefinitionStorage", "saveDefinition finish size:" + this.DHA.size() + '!');
      AppMethodBeat.o(351443);
      return;
    }
  }
  
  public final int oD(long paramLong)
  {
    AppMethodBeat.i(351459);
    Object localObject = (Integer)this.DHA.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (int i = -1;; i = ((Integer)localObject).intValue())
    {
      localObject = a.DJT;
      a.hQ("FinderLiveVideoDefinitionStorage", "selectDefinition liveId:" + paramLong + ",level:" + i + ",cache size:" + this.DHA.size());
      AppMethodBeat.o(351459);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveVideoDefinitionStorage$Companion;", "", "()V", "RELEASENUM", "", "TAG", "", "TESTNUM", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.i
 * JD-Core Version:    0.7.0.1
 */