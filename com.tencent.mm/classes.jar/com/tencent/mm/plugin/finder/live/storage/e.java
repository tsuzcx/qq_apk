package com.tencent.mm.plugin.finder.live.storage;

import android.database.Cursor;
import com.tencent.c.a.a.a.d.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.f.c.cn;
import com.tencent.mm.protocal.protobuf.bao;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveLuckyMoneyStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearCache", "", "liveId", "initCache", "isAvailableLuckyMoney", "", "sendId", "saveCache", "saveCacheInternal", "cacheSet", "", "updateCache", "Companion", "plugin-finder-live_release"})
public final class e
  extends com.tencent.c.a.a.a.d.e
{
  public static final a yOh;
  private final ISQLiteDatabase db;
  private final ConcurrentHashMap<Long, Set<String>> xHs;
  
  static
  {
    AppMethodBeat.i(232798);
    yOh = new a((byte)0);
    AppMethodBeat.o(232798);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.c.a.a.a.d.a.d.access$getInfo$cp(), "FinderLiveLuckyMoneyInfo", cn.INDEX_CREATE);
    AppMethodBeat.i(232797);
    this.db = paramISQLiteDatabase;
    this.xHs = new ConcurrentHashMap();
    AppMethodBeat.o(232797);
  }
  
  private final boolean a(long paramLong, Set<String> paramSet)
  {
    boolean bool = true;
    AppMethodBeat.i(232790);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", "saveCacheInternal: liveId:".concat(String.valueOf(paramLong)));
    Object localObject = "SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=" + com.tencent.mm.ae.d.Fw(paramLong);
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    int i;
    if (localCursor.moveToNext())
    {
      localObject = new com.tencent.c.a.a.a.d.a.d();
      ((com.tencent.c.a.a.a.d.a.d)localObject).convertFrom(localCursor);
      i = 0;
    }
    for (;;)
    {
      bao localbao = new bao();
      a locala = (a)localbao;
      byte[] arrayOfByte = ((com.tencent.c.a.a.a.d.a.d)localObject).field_luckyMoneyData;
      try
      {
        locala.parseFrom(arrayOfByte);
        localbao.SMx.addAll((Collection)paramSet);
        ((com.tencent.c.a.a.a.d.a.d)localObject).field_luckyMoneyData = localbao.toByteArray();
        localCursor.close();
        if (i != 0)
        {
          paramSet = ((com.tencent.c.a.a.a.d.a.d)localObject).convertTo();
          if (this.db.insert("FinderLiveLuckyMoneyInfo", "liveId", paramSet) > 0L)
          {
            Log.i("Finder.FinderLiveLuckyMoneyStorage", "saveCache result:".concat(String.valueOf(bool)));
            AppMethodBeat.o(232790);
            return bool;
            localObject = new com.tencent.c.a.a.a.d.a.d();
            ((com.tencent.c.a.a.a.d.a.d)localObject).field_liveId = com.tencent.mm.ae.d.Fw(paramLong);
            ((com.tencent.c.a.a.a.d.a.d)localObject).field_luckyMoneyData = new bao().toByteArray();
            Log.i("Finder.FinderLiveLuckyMoneyStorage", "create new luckyMoneyInfo:".concat(String.valueOf(localObject)));
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
  
  public final void Lh(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(232791);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", "initCache: liveId:".concat(String.valueOf(paramLong)));
    Object localObject1 = "SELECT * FROM FinderLiveLuckyMoneyInfo where FinderLiveLuckyMoneyInfo.liveId=" + com.tencent.mm.ae.d.Fw(paramLong);
    Cursor localCursor = this.db.rawQuery((String)localObject1, null, 2);
    if (localCursor.moveToNext())
    {
      localObject1 = new com.tencent.c.a.a.a.d.a.d();
      ((com.tencent.c.a.a.a.d.a.d)localObject1).convertFrom(localCursor);
    }
    for (;;)
    {
      bao localbao = new bao();
      a locala = (a)localbao;
      if (localObject1 != null) {
        localObject2 = ((com.tencent.c.a.a.a.d.a.d)localObject1).field_luckyMoneyData;
      }
      try
      {
        locala.parseFrom((byte[])localObject2);
        localObject1 = Collections.synchronizedSet((Set)new HashSet());
        localObject2 = localbao.SMx;
        p.j(localObject2, "luckyMoneyData.openedIdList");
        ((Set)localObject1).addAll((Collection)localObject2);
        localObject2 = (Map)this.xHs;
        p.j(localObject1, "set");
        ((Map)localObject2).put(Long.valueOf(paramLong), localObject1);
        localCursor.close();
        AppMethodBeat.o(232791);
        return;
        localObject1 = null;
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
  
  public final void Ls(long paramLong)
  {
    AppMethodBeat.i(232796);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", "clearCache liveId:".concat(String.valueOf(paramLong)));
    this.xHs.clear();
    this.db.delete("FinderLiveLuckyMoneyInfo", "liveId=?", new String[] { com.tencent.mm.ae.d.Fw(paramLong) });
    AppMethodBeat.o(232796);
  }
  
  public final void dDO()
  {
    AppMethodBeat.i(232789);
    Iterator localIterator = ((Map)this.xHs).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a(((Number)localEntry.getKey()).longValue(), (Set)localEntry.getValue());
    }
    AppMethodBeat.o(232789);
  }
  
  public final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(232792);
    Log.i("Finder.FinderLiveLuckyMoneyStorage", "updateCache liveId:" + paramLong + " sendId:" + paramString);
    if (paramString != null)
    {
      Set localSet = (Set)this.xHs.get(Long.valueOf(paramLong));
      if (localSet != null)
      {
        localSet.add(paramString);
        AppMethodBeat.o(232792);
        return;
      }
      AppMethodBeat.o(232792);
      return;
    }
    AppMethodBeat.o(232792);
  }
  
  public final boolean w(long paramLong, String paramString)
  {
    AppMethodBeat.i(232793);
    Set localSet = (Set)this.xHs.get(Long.valueOf(paramLong));
    if (localSet != null) {}
    for (boolean bool = j.a((Iterable)localSet, paramString); !bool; bool = false)
    {
      AppMethodBeat.o(232793);
      return true;
    }
    AppMethodBeat.o(232793);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveLuckyMoneyStorage$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.e
 * JD-Core Version:    0.7.0.1
 */