package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache;", "", "()V", "CACHE_VAILD_DURATTION", "", "TAG", "", "userName2NoticeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "add", "", "userName", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "clear", "getNotice", "noticeInfoCacheItem", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "FinderFeedLiveNoticeCache";
  private static final int xGF = 60000;
  private static final ConcurrentHashMap<String, a> xGG;
  public static final j xGH;
  
  static
  {
    AppMethodBeat.i(243922);
    xGH = new j();
    TAG = "FinderFeedLiveNoticeCache";
    xGF = 60000;
    xGG = new ConcurrentHashMap();
    AppMethodBeat.o(243922);
  }
  
  public static void a(String paramString, bbh parambbh)
  {
    AppMethodBeat.i(243915);
    p.k(paramString, "userName");
    p.k(parambbh, "info");
    synchronized (xGG)
    {
      Log.i(TAG, "[add] userName:".concat(String.valueOf(paramString)));
      if (xGG.containsKey(paramString))
      {
        a locala = (a)xGG.get(paramString);
        if ((locala == null) || (locala.dup())) {}
      }
      else
      {
        ((Map)xGG).put(paramString, new a(parambbh));
      }
      paramString = x.aazN;
      AppMethodBeat.o(243915);
      return;
    }
  }
  
  public static bbh aBF(String paramString)
  {
    AppMethodBeat.i(243918);
    p.k(paramString, "userName");
    synchronized (xGG)
    {
      a locala = (a)xGG.get(paramString);
      if (locala != null)
      {
        if (!locala.dup()) {
          xGG.remove(paramString);
        }
        for (paramString = null;; paramString = locala.xGI)
        {
          AppMethodBeat.o(243918);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static void clear()
  {
    AppMethodBeat.i(243919);
    synchronized (xGG)
    {
      xGG.clear();
      x localx = x.aazN;
      AppMethodBeat.o(243919);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$noticeInfoCacheItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "timeStamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;J)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isVaild", "toString", "", "plugin-finder_release"})
  public static final class a
  {
    private long timeStamp;
    bbh xGI;
    
    private a(bbh parambbh, long paramLong)
    {
      AppMethodBeat.i(281577);
      this.xGI = parambbh;
      this.timeStamp = paramLong;
      AppMethodBeat.o(281577);
    }
    
    public final boolean dup()
    {
      AppMethodBeat.i(281575);
      long l1 = System.currentTimeMillis();
      long l2 = this.timeStamp;
      j localj = j.xGH;
      if (l1 - l2 < j.duo())
      {
        AppMethodBeat.o(281575);
        return true;
      }
      AppMethodBeat.o(281575);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(281581);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.xGI, paramObject.xGI)) || (this.timeStamp != paramObject.timeStamp)) {}
        }
      }
      else
      {
        AppMethodBeat.o(281581);
        return true;
      }
      AppMethodBeat.o(281581);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(281580);
      bbh localbbh = this.xGI;
      if (localbbh != null) {}
      for (int i = localbbh.hashCode();; i = 0)
      {
        long l = this.timeStamp;
        int j = (int)(l ^ l >>> 32);
        AppMethodBeat.o(281580);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(281579);
      String str = "noticeInfoCacheItem(info=" + this.xGI + ", timeStamp=" + this.timeStamp + ")";
      AppMethodBeat.o(281579);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.j
 * JD-Core Version:    0.7.0.1
 */