package com.tencent.mm.plugin.finder.feed.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache;", "", "()V", "CACHE_VAILD_DURATTION", "", "TAG", "", "createNoticeList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "kotlin.jvm.PlatformType", "", "userName2NoticeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$NoticeInfoCacheItem;", "add", "", "userName", "info", "addCreateNotice", "notice", "clear", "getNotice", "getNoticeSnapshot", "hasCreateNotice", "", "removeCreateNotice", "noticeId", "updateCreateNoticeList", "list", "Ljava/util/LinkedList;", "NoticeInfoCacheItem", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j BfL;
  private static final int BfM;
  private static final ConcurrentHashMap<String, a> BfN;
  private static final List<bkk> BfO;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(366027);
    BfL = new j();
    TAG = "FinderFeedLiveNoticeCache";
    BfM = 600000;
    BfN = new ConcurrentHashMap();
    BfO = Collections.synchronizedList((List)new ArrayList());
    AppMethodBeat.o(366027);
  }
  
  public static bkk Sv(String paramString)
  {
    AppMethodBeat.i(365983);
    s.u(paramString, "userName");
    synchronized (BfN)
    {
      a locala = (a)BfN.get(paramString);
      if (locala == null) {}
      for (paramString = null;; paramString = null)
      {
        AppMethodBeat.o(365983);
        return paramString;
        if (locala.eFO()) {
          break;
        }
        BfN.remove(paramString);
      }
      paramString = locala.ENx;
    }
  }
  
  public static void Sw(String paramString)
  {
    AppMethodBeat.i(366009);
    s.u(paramString, "noticeId");
    List localList = BfO;
    s.s(localList, "createNoticeList");
    d.a(localList, (b)new b(paramString));
    AppMethodBeat.o(366009);
  }
  
  public static void a(bkk parambkk)
  {
    AppMethodBeat.i(366001);
    Object localObject;
    if (parambkk != null)
    {
      localObject = BfO;
      s.s(localObject, "createNoticeList");
    }
    synchronized ((Iterable)localObject)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        boolean bool = Util.isEqual(((bkk)localObject).hAR, parambkk.hAR);
        if (bool)
        {
          if (localObject == null) {
            BfO.add(parambkk);
          }
          AppMethodBeat.o(366001);
          return;
        }
      }
      localObject = null;
    }
  }
  
  public static void b(String paramString, bkk parambkk)
  {
    AppMethodBeat.i(365972);
    s.u(paramString, "userName");
    s.u(parambkk, "info");
    for (;;)
    {
      int i;
      synchronized (BfN)
      {
        Log.i(TAG, s.X("[add] userName:", paramString));
        if (BfN.containsKey(paramString))
        {
          a locala = (a)BfN.get(paramString);
          if ((locala != null) && (!locala.eFO()))
          {
            i = 1;
            break label123;
          }
        }
        else
        {
          ((Map)BfN).put(paramString, new a(parambkk));
          paramString = ah.aiuX;
          AppMethodBeat.o(365972);
          return;
        }
        i = 0;
      }
      label123:
      if (i == 0) {}
    }
  }
  
  public static boolean bUo()
  {
    AppMethodBeat.i(366014);
    Collection localCollection = (Collection)BfO;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(366014);
      return true;
    }
    AppMethodBeat.o(366014);
    return false;
  }
  
  public static String chX()
  {
    AppMethodBeat.i(370899);
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized ((Map)BfN)
    {
      localObject3 = ((Map)???).entrySet().iterator();
      if (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        localStringBuffer.append("[").append((String)localEntry.getKey()).append(":").append(((a)localEntry.getValue()).ENx.status).append("]");
      }
    }
    Object localObject3 = ah.aiuX;
    ??? = localObject2.toString();
    s.s(???, "result.toString()");
    AppMethodBeat.o(370899);
    return ???;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(365991);
    synchronized (BfN)
    {
      BfN.clear();
      ah localah = ah.aiuX;
      AppMethodBeat.o(365991);
      return;
    }
  }
  
  public static void t(LinkedList<bkk> paramLinkedList)
  {
    AppMethodBeat.i(365994);
    BfO.clear();
    if (paramLinkedList != null) {
      BfO.addAll((Collection)paramLinkedList);
    }
    AppMethodBeat.o(365994);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedLiveNoticeCache$NoticeInfoCacheItem;", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "timeStamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;J)V", "getInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isVaild", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    bkk ENx;
    private long timeStamp;
    
    private a(bkk parambkk, long paramLong)
    {
      AppMethodBeat.i(370900);
      this.ENx = parambkk;
      this.timeStamp = paramLong;
      AppMethodBeat.o(370900);
    }
    
    public final boolean eFO()
    {
      AppMethodBeat.i(370902);
      if (System.currentTimeMillis() - this.timeStamp < j.edQ())
      {
        AppMethodBeat.o(370902);
        return true;
      }
      AppMethodBeat.o(370902);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(370905);
      if (this == paramObject)
      {
        AppMethodBeat.o(370905);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(370905);
        return false;
      }
      paramObject = (a)paramObject;
      if (!s.p(this.ENx, paramObject.ENx))
      {
        AppMethodBeat.o(370905);
        return false;
      }
      if (this.timeStamp != paramObject.timeStamp)
      {
        AppMethodBeat.o(370905);
        return false;
      }
      AppMethodBeat.o(370905);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(370904);
      int i = this.ENx.hashCode();
      int j = q.a..ExternalSyntheticBackport0.m(this.timeStamp);
      AppMethodBeat.o(370904);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(370903);
      String str = "NoticeInfoCacheItem(info=" + this.ENx + ", timeStamp=" + this.timeStamp + ')';
      AppMethodBeat.o(370903);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<bkk, Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.j
 * JD-Core Version:    0.7.0.1
 */