package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.d.a.a.a.d.a.f;
import com.tencent.d.a.a.a.d.a.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.cu;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearCache", "", "liveId", "initCache", "isAvailableLuckyMoney", "", "sendId", "saveCache", "saveCacheInternal", "cacheSet", "", "updateCache", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.d.a.a.a.d.g
{
  public static final a DHy;
  private final ConcurrentHashMap<Long, Set<String>> Bgw;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(351446);
    DHy = new a((byte)0);
    AppMethodBeat.o(351446);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.access$getInfo$cp(), "FinderLiveLuckyMoneyInfo", cu.INDEX_CREATE);
    AppMethodBeat.i(351419);
    this.db = paramISQLiteDatabase;
    this.Bgw = new ConcurrentHashMap();
    AppMethodBeat.o(351419);
  }
  
  private final boolean a(long paramLong, Set<String> paramSet)
  {
    boolean bool = true;
    AppMethodBeat.i(351439);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", s.X("saveCacheInternal: liveId:", Long.valueOf(paramLong)));
    Object localObject = s.X("SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=", d.hF(paramLong));
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    int i;
    if (localCursor.moveToNext())
    {
      localObject = new f();
      ((f)localObject).convertFrom(localCursor);
      i = 0;
    }
    for (;;)
    {
      bjg localbjg = new bjg();
      a locala = (a)localbjg;
      byte[] arrayOfByte = ((f)localObject).field_luckyMoneyData;
      try
      {
        locala.parseFrom(arrayOfByte);
        localbjg.ZSU.addAll((Collection)paramSet);
        ((f)localObject).field_luckyMoneyData = localbjg.toByteArray();
        localCursor.close();
        if (i != 0)
        {
          paramSet = ((f)localObject).convertTo();
          if (this.db.insert("FinderLiveLuckyMoneyInfo", "liveId", paramSet) > 0L)
          {
            Log.i("Finder.FinderLiveLuckyMoneyStorage", s.X("saveCache result:", Boolean.valueOf(bool)));
            AppMethodBeat.o(351439);
            return bool;
            localObject = new f();
            ((f)localObject).field_liveId = d.hF(paramLong);
            ((f)localObject).field_luckyMoneyData = new bjg().toByteArray();
            Log.i("Finder.FinderLiveLuckyMoneyStorage", s.X("create new luckyMoneyInfo:", localObject));
            i = 1;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          continue;
          bool = false;
          continue;
          bool = replace((IAutoDBItem)localObject);
        }
      }
    }
  }
  
  public final void F(long paramLong, String paramString)
  {
    AppMethodBeat.i(351470);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", "updateCache liveId:" + paramLong + " sendId:" + paramString);
    if (paramString != null)
    {
      Set localSet = (Set)this.Bgw.get(Long.valueOf(paramLong));
      if (localSet != null) {
        localSet.add(paramString);
      }
    }
    AppMethodBeat.o(351470);
  }
  
  public final boolean G(long paramLong, String paramString)
  {
    AppMethodBeat.i(351476);
    Set localSet = (Set)this.Bgw.get(Long.valueOf(paramLong));
    if (localSet == null) {}
    for (boolean bool = false; !bool; bool = p.a((Iterable)localSet, paramString))
    {
      AppMethodBeat.o(351476);
      return true;
    }
    AppMethodBeat.o(351476);
    return false;
  }
  
  public final void etY()
  {
    AppMethodBeat.i(351454);
    Iterator localIterator = ((Map)this.Bgw).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(((Number)localEntry.getKey()).longValue(), (Set)localEntry.getValue());
    }
    AppMethodBeat.o(351454);
  }
  
  public final void nU(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(351464);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", s.X("initCache: liveId:", Long.valueOf(paramLong)));
    Object localObject1 = s.X("SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=", d.hF(paramLong));
    Cursor localCursor = this.db.rawQuery((String)localObject1, null, 2);
    if (localCursor.moveToNext())
    {
      localObject1 = new f();
      ((f)localObject1).convertFrom(localCursor);
    }
    for (;;)
    {
      bjg localbjg = new bjg();
      a locala = (a)localbjg;
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
      try
      {
        for (;;)
        {
          locala.parseFrom((byte[])localObject1);
          localObject1 = Collections.synchronizedSet((Set)new HashSet());
          localObject2 = localbjg.ZSU;
          s.s(localObject2, "luckyMoneyData.openedIdList");
          ((Set)localObject1).addAll((Collection)localObject2);
          localObject2 = (Map)this.Bgw;
          s.s(localObject1, "set");
          ((Map)localObject2).put(Long.valueOf(paramLong), localObject1);
          localCursor.close();
          AppMethodBeat.o(351464);
          return;
          localObject1 = null;
          break;
          localObject1 = ((f)localObject1).field_luckyMoneyData;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
  }
  
  public final void oz(long paramLong)
  {
    AppMethodBeat.i(351484);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", s.X("clearCache liveId:", Long.valueOf(paramLong)));
    this.Bgw.clear();
    this.db.delete("FinderLiveLuckyMoneyInfo", "liveId=?", new String[] { s.X("", d.hF(paramLong)) });
    AppMethodBeat.o(351484);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.g
 * JD-Core Version:    0.7.0.1
 */