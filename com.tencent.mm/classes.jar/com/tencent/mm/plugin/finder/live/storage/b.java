package com.tencent.mm.plugin.finder.live.storage;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.cp;
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
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage;", "Lcom/tencent/plugin/finder/live/api/storage/ApiFinderLiveChargeInfoStorage;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "chargeInfoCache", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage$ChargeInfo;", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "hasInit", "", "deleteAll", "", "deleteChargeInfo", "liveId", "havePayForLive", "initChargeInfo", "insertLiveChargeInfo", "time", "", "insertReplayChargeInfo", "saveCacheInternal", "chargeInfo", "saveChargeInfo", "selectLiveTime", "selectReplayChargeInfo", "setPayForLive", "updateLiveChargeInfo", "updateReplayChargeInfo", "ChargeInfo", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.d.a.a.a.d.b
{
  public static final b DHo;
  private final LruCache<Long, a> DHp;
  private final ISQLiteDatabase db;
  private volatile boolean hasInit;
  
  static
  {
    AppMethodBeat.i(351417);
    DHo = new b((byte)0);
    AppMethodBeat.o(351417);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.d.a.a.a.d.a.b.access$getInfo$cp(), "FinderLiveChargeInfo", cp.INDEX_CREATE);
    AppMethodBeat.i(351384);
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = aw.Gjk;
    if (aw.bgV()) {}
    for (int i = 5;; i = 600)
    {
      this.DHp = new LruCache(i);
      AppMethodBeat.o(351384);
      return;
    }
  }
  
  private final void a(long paramLong, a parama)
  {
    boolean bool4 = false;
    AppMethodBeat.i(351407);
    Object localObject = s.X("SELECT * FROM FinderLiveChargeInfo where FinderLiveChargeInfo.liveId=", d.hF(paramLong));
    Cursor localCursor = this.db.rawQuery((String)localObject, null, 2);
    if (localCursor.moveToNext())
    {
      localObject = new com.tencent.d.a.a.a.d.a.b();
      ((com.tencent.d.a.a.a.d.a.b)localObject).convertFrom(localCursor);
      if ((((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForLive == parama.DHq) && (((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForReplay == parama.DHr) && (((com.tencent.d.a.a.a.d.a.b)localObject).field_payForLive == parama.DHs)) {
        break label365;
      }
    }
    label365:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForLive = parama.DHq;
      ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForReplay = parama.DHr;
      ((com.tencent.d.a.a.a.d.a.b)localObject).field_payForLive = parama.DHs;
      boolean bool2 = false;
      boolean bool3 = bool1;
      parama = (a)localObject;
      localCursor.close();
      if (bool3) {
        bool1 = replace((IAutoDBItem)parama);
      }
      for (;;)
      {
        Log.i("FinderLiveChargeInfoStorage", "saveCache " + parama.field_liveId + ",liveTime:" + parama.field_freeTimeForLive + ",replay:" + parama.field_freeTimeForReplay + ",payForLive:" + parama.field_payForLive + ", needReplace:" + bool3 + ",needInsert:" + bool2 + ",result:" + bool1);
        AppMethodBeat.o(351407);
        return;
        localObject = new com.tencent.d.a.a.a.d.a.b();
        ((com.tencent.d.a.a.a.d.a.b)localObject).field_liveId = paramLong;
        ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForLive = parama.DHq;
        ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForReplay = parama.DHr;
        ((com.tencent.d.a.a.a.d.a.b)localObject).field_payForLive = parama.DHs;
        Log.i("FinderLiveChargeInfoStorage", s.X("create new charge info:", localObject));
        bool2 = true;
        bool3 = false;
        parama = (a)localObject;
        break;
        bool1 = bool4;
        if (bool2)
        {
          localObject = parama.convertTo();
          bool1 = bool4;
          if (this.db.insert("FinderLiveChargeInfo", "liveId", (ContentValues)localObject) > 0L) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  public final void S(long paramLong, int paramInt)
  {
    AppMethodBeat.i(351447);
    if (!this.hasInit) {
      etU();
    }
    Object localObject = (a)this.DHp.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        this.DHp.put(Long.valueOf(paramLong), new a(paramLong, paramInt, 0, 8, (byte)0));
      }
      localObject = this.DHp.get(Long.valueOf(paramLong));
      s.s(localObject, "chargeInfoCache.get(liveId)");
      a(paramLong, (a)localObject);
      localObject = a.DJT;
      a.hQ("FinderLiveChargeInfoStorage", "insertLiveChargeInfo liveId:" + paramLong + ",time:" + paramInt + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351447);
      return;
      ((a)localObject).DHq = paramInt;
    }
  }
  
  public final void T(long paramLong, int paramInt)
  {
    AppMethodBeat.i(351457);
    if (!this.hasInit) {
      etU();
    }
    Object localObject = (a)this.DHp.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        this.DHp.put(Long.valueOf(paramLong), new a(paramLong, paramInt, 0, 8, (byte)0));
      }
      localObject = a.DJT;
      a.hQ("FinderLiveChargeInfoStorage", "updateLiveChargeInfo liveId:" + paramLong + ",time:" + paramInt + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351457);
      return;
      ((a)localObject).DHq = paramInt;
    }
  }
  
  public final void U(long paramLong, int paramInt)
  {
    AppMethodBeat.i(351485);
    if (!this.hasInit) {
      etU();
    }
    Object localObject = (a)this.DHp.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        this.DHp.put(Long.valueOf(paramLong), new a(paramLong, 0, paramInt, 8, (byte)0));
      }
      localObject = a.DJT;
      a.hQ("FinderLiveChargeInfoStorage", "updateReplayChargeInfo liveId:" + paramLong + ",time:" + paramInt + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351485);
      return;
      ((a)localObject).DHr = paramInt;
    }
  }
  
  public final void etU()
  {
    AppMethodBeat.i(351429);
    boolean bool = this.DHp.entrySet().isEmpty();
    if (bool)
    {
      Cursor localCursor = this.db.rawQuery("SELECT * FROM FinderLiveChargeInfo", null, 2);
      while (localCursor.moveToNext())
      {
        Object localObject = new com.tencent.d.a.a.a.d.a.b();
        ((com.tencent.d.a.a.a.d.a.b)localObject).convertFrom(localCursor);
        a locala = new a(((com.tencent.d.a.a.a.d.a.b)localObject).field_liveId, ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForLive, ((com.tencent.d.a.a.a.d.a.b)localObject).field_freeTimeForReplay, 8, (byte)0);
        this.DHp.put(Long.valueOf(((com.tencent.d.a.a.a.d.a.b)localObject).field_liveId), locala);
        localObject = a.DJT;
        a.hQ("FinderLiveChargeInfoStorage", String.valueOf(locala));
      }
      localCursor.close();
    }
    this.hasInit = true;
    Log.i("FinderLiveChargeInfoStorage", "initChargeInfo: " + z.bAM() + ", isEmpty:" + bool + ", cache size:" + this.DHp.size());
    AppMethodBeat.o(351429);
  }
  
  public final void etV()
  {
    AppMethodBeat.i(351440);
    Object localObject1 = this.DHp.entrySet();
    s.s(localObject1, "chargeInfoCache.entrySet()");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject3 = ((Map.Entry)localObject2).getKey();
      s.s(localObject3, "it.key");
      long l = ((Number)localObject3).longValue();
      localObject2 = ((Map.Entry)localObject2).getValue();
      s.s(localObject2, "it.value");
      a(l, (a)localObject2);
    }
    Log.i("FinderLiveChargeInfoStorage", "saveChargeInfo finish size:" + this.DHp.size() + '!');
    AppMethodBeat.o(351440);
  }
  
  public final int ov(long paramLong)
  {
    AppMethodBeat.i(351466);
    if (!this.hasInit) {
      etU();
    }
    a locala = (a)this.DHp.get(Long.valueOf(paramLong));
    if (locala == null) {}
    for (int i = 0;; i = locala.DHq)
    {
      Log.i("FinderLiveChargeInfoStorage", "selectLiveChargeInfo liveId:" + paramLong + ",time:" + i + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351466);
      return i;
    }
  }
  
  public final void ow(long paramLong)
  {
    AppMethodBeat.i(351472);
    if (!this.hasInit) {
      etU();
    }
    Object localObject = (a)this.DHp.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        this.DHp.put(Long.valueOf(paramLong), new a(paramLong, 0, 0, 1));
      }
      localObject = this.DHp.get(Long.valueOf(paramLong));
      s.s(localObject, "chargeInfoCache.get(liveId)");
      a(paramLong, (a)localObject);
      Log.i("FinderLiveChargeInfoStorage", "setPayForLive liveId:" + paramLong + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351472);
      return;
      ((a)localObject).DHs = 1;
    }
  }
  
  public final boolean ox(long paramLong)
  {
    AppMethodBeat.i(351475);
    if (!this.hasInit) {
      etU();
    }
    a locala = (a)this.DHp.get(Long.valueOf(paramLong));
    if ((locala != null) && (locala.DHs == 1))
    {
      AppMethodBeat.o(351475);
      return true;
    }
    AppMethodBeat.o(351475);
    return false;
  }
  
  public final int oy(long paramLong)
  {
    AppMethodBeat.i(351490);
    if (!this.hasInit) {
      etU();
    }
    a locala = (a)this.DHp.get(Long.valueOf(paramLong));
    if (locala == null) {}
    for (int i = -1;; i = locala.DHr)
    {
      Log.i("FinderLiveChargeInfoStorage", "selectReplayChargeInfo liveId:" + paramLong + ",time:" + i + ",cache size:" + this.DHp.size());
      AppMethodBeat.o(351490);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage$ChargeInfo;", "", "liveId", "", "liveTime", "", "replayTime", "payForLive", "(JIII)V", "getLiveId", "()J", "setLiveId", "(J)V", "getLiveTime", "()I", "setLiveTime", "(I)V", "getPayForLive", "setPayForLive", "getReplayTime", "setReplayTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int DHq;
    int DHr;
    int DHs;
    private long liveId;
    
    public a()
    {
      this(0L, 0, 0, 15, (byte)0);
    }
    
    public a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
    {
      this.liveId = paramLong;
      this.DHq = paramInt1;
      this.DHr = paramInt2;
      this.DHs = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.liveId != paramObject.liveId) {
          return false;
        }
        if (this.DHq != paramObject.DHq) {
          return false;
        }
        if (this.DHr != paramObject.DHr) {
          return false;
        }
      } while (this.DHs == paramObject.DHs);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(351458);
      int i = q.a..ExternalSyntheticBackport0.m(this.liveId);
      int j = this.DHq;
      int k = this.DHr;
      int m = this.DHs;
      AppMethodBeat.o(351458);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(351450);
      String str = "liveId:" + this.liveId + ",time:(" + this.DHq + ", " + this.DHr + "),payForLive:" + this.DHs;
      AppMethodBeat.o(351450);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/storage/FinderLiveChargeInfoStorage$Companion;", "", "()V", "RELEASENUM", "", "TAG", "", "TESTNUM", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.storage.b
 * JD-Core Version:    0.7.0.1
 */