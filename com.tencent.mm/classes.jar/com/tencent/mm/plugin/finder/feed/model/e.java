package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache;", "", "()V", "CACHE_VAILD_DURATTION", "", "TAG", "", "userName2NoticeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "add", "", "userName", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "clear", "getNotice", "noticeInfoCacheItem", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "FinderFeedLiveNoticeCache";
  private static final int tUW = 60000;
  private static final ConcurrentHashMap<String, a> tUX;
  public static final e tUY;
  
  static
  {
    AppMethodBeat.i(244586);
    tUY = new e();
    TAG = "FinderFeedLiveNoticeCache";
    tUW = 60000;
    tUX = new ConcurrentHashMap();
    AppMethodBeat.o(244586);
  }
  
  public static void a(String paramString, awt paramawt)
  {
    AppMethodBeat.i(244583);
    p.h(paramString, "userName");
    p.h(paramawt, "info");
    synchronized (tUX)
    {
      Log.i(TAG, "[add] userName:".concat(String.valueOf(paramString)));
      if (tUX.containsKey(paramString))
      {
        a locala = (a)tUX.get(paramString);
        if ((locala == null) || (locala.ddy())) {}
      }
      else
      {
        ((Map)tUX).put(paramString, new a(paramawt));
      }
      paramString = x.SXb;
      AppMethodBeat.o(244583);
      return;
    }
  }
  
  public static awt ato(String paramString)
  {
    AppMethodBeat.i(244584);
    p.h(paramString, "userName");
    synchronized (tUX)
    {
      a locala = (a)tUX.get(paramString);
      if (locala != null)
      {
        if (!locala.ddy()) {
          tUX.remove(paramString);
        }
        for (paramString = null;; paramString = locala.tUZ)
        {
          AppMethodBeat.o(244584);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static void clear()
  {
    AppMethodBeat.i(244585);
    synchronized (tUX)
    {
      tUX.clear();
      x localx = x.SXb;
      AppMethodBeat.o(244585);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "timeStamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;J)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isVaild", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    awt tUZ;
    private long timeStamp;
    
    private a(awt paramawt, long paramLong)
    {
      AppMethodBeat.i(244578);
      this.tUZ = paramawt;
      this.timeStamp = paramLong;
      AppMethodBeat.o(244578);
    }
    
    public final boolean ddy()
    {
      AppMethodBeat.i(244577);
      long l1 = System.currentTimeMillis();
      long l2 = this.timeStamp;
      e locale = e.tUY;
      if (l1 - l2 < e.ddx())
      {
        AppMethodBeat.o(244577);
        return true;
      }
      AppMethodBeat.o(244577);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(244582);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.j(this.tUZ, paramObject.tUZ)) || (this.timeStamp != paramObject.timeStamp)) {}
        }
      }
      else
      {
        AppMethodBeat.o(244582);
        return true;
      }
      AppMethodBeat.o(244582);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(244581);
      awt localawt = this.tUZ;
      if (localawt != null) {}
      for (int i = localawt.hashCode();; i = 0)
      {
        long l = this.timeStamp;
        int j = (int)(l ^ l >>> 32);
        AppMethodBeat.o(244581);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(244580);
      String str = "noticeInfoCacheItem(info=" + this.tUZ + ", timeStamp=" + this.timeStamp + ")";
      AppMethodBeat.o(244580);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.e
 * JD-Core Version:    0.7.0.1
 */