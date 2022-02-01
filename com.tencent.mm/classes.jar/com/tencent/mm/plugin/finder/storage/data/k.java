package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.profile.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private static boolean DEBUG;
  public static final a FNg;
  private static final int FNh;
  private static final Integer[] FNi;
  private static final Integer[] FNj;
  private static final Integer[] FNk;
  private static final q FNl;
  private static q FNm;
  
  static
  {
    AppMethodBeat.i(167083);
    FNg = new a((byte)0);
    FNh = 20;
    FNi = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(18), Integer.valueOf(20), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(21) };
    FNj = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(17), Integer.valueOf(19) };
    FNk = new Integer[] { Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13) };
    q localq = new q(new a[] { new a(0, "main_v3", new axl(), 0), new a(1, "profile_v3", new axl(), 0), new a(2, "like_v3", new axl(), 0), new a(3, "others_v3", new axl(), 0), new a(4, "prefetch_v3", new axl(), 0), new a(5, "friend_tab_v3", new axl(), 0), new a(6, "lbs_tab_v3", new axl(), 0), new a(7, "follow_v3", new axl(), 0), new a(8, "machine_v3", new axl(), 0), new a(9, "lbs_tab_section_v3", new axl(), 0), new a(10, "fav_v3", new axl(), 0), new a(11, "mega_video_like_v3", new axl(), 0), new a(12, "mega_video_fav_v3", new axl(), 0), new a(13, "mega_video_profile_v3", new axl(), 0), new a(14, "profile_at_feed_v3", new axl(), 0), new a(15, "nearby_live_v3", new axl(), 0), new a(16, "nearby_live_more_v3", new axl(), 0), new a(18, "manage_at_feed_v3", new axl(), 0), new a(20, "profile_poi_v3", new axl(), 0), new a(17, "music_v3", new axl(), 0), new a(19, "qq_music_v3", new axl(), 0), new a(18, "manage_at_feed_v3", new axl(), 0), new a(21, "biz_profile_v3", new axl(), 0) });
    FNl = localq;
    FNm = localq;
    AppMethodBeat.o(167083);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "megaVideoArray", "selfArray", "cacheLongTime", "fpPage", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "cacheToFinderItemList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToRVFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cacheToSectionList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "clearAll", "deleteData", "typeFlag", "filter", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isFlush", "deleteMegaVideoPageData", "id", "", "pageName", "deletePageData", "svrId", "svrIds", "", "deletePageDataByLocalId", "localId", "deletePageDataByName", "userNames", "fileToCache", "filterLiveItem", "prefix", "getFinderFpList", "cachePage", "getLast", "getLastFinderItem", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "updatePageData", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static a Tv(int paramInt)
    {
      a locala = null;
      AppMethodBeat.i(339401);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject2 = av.GiL;
          str = av.Ub(2) + '/' + k.faf().Tx(paramInt).name + ".ext";
          localc = new com.tencent.mm.ae.c("file2Cache");
          arrayOfByte = y.bi(str, 0, -1);
          localObject1 = (com.tencent.mm.bx.a)new axl();
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject2;
          String str;
          com.tencent.mm.ae.c localc;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          Integer localInteger;
          int i;
          Log.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
          continue;
        }
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(arrayOfByte);
          localObject2 = (axl)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          if (arrayOfByte == null)
          {
            localObject1 = locala;
            Log.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localc);
            locala = k.faf().Tx(paramInt);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new axl();
            }
            locala.a((axl)localObject1);
            k.faf().Tx(paramInt).rNn = true;
            localObject1 = k.faf().Tx(paramInt);
            AppMethodBeat.o(339401);
            return localObject1;
          }
        }
        catch (Exception localException1)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localInteger = null;
          continue;
          i = arrayOfByte.length;
          localInteger = Integer.valueOf(i);
        }
      }
    }
    
    public static a Tw(int paramInt)
    {
      AppMethodBeat.i(339488);
      if (k.faf().Tx(paramInt).rNn)
      {
        locala = k.faf().Tx(paramInt);
        AppMethodBeat.o(339488);
        return locala;
      }
      k.faf().a(paramInt, Tv(paramInt));
      a locala = k.faf().Tx(paramInt);
      AppMethodBeat.o(339488);
      return locala;
    }
    
    public static axv a(a parama, String paramString)
    {
      AppMethodBeat.i(339466);
      int i;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      }
      while ((i != 0) || (kotlin.g.b.s.p(paramString, z.bAW()))) {
        if (parama == null)
        {
          AppMethodBeat.o(339466);
          return null;
          i = 0;
        }
        else
        {
          parama = parama.FMI;
          if (parama == null)
          {
            AppMethodBeat.o(339466);
            return null;
          }
          parama = parama.KNn;
          if (parama == null)
          {
            AppMethodBeat.o(339466);
            return null;
          }
          parama = kotlin.a.p.ae((List)parama, 0);
        }
      }
      for (;;)
      {
        parama = (axv)parama;
        AppMethodBeat.o(339466);
        return parama;
        if (parama == null)
        {
          AppMethodBeat.o(339466);
          return null;
        }
        parama = parama.FMI;
        if (parama == null)
        {
          AppMethodBeat.o(339466);
          return null;
        }
        parama = parama.KNn;
        if (parama == null)
        {
          AppMethodBeat.o(339466);
          return null;
        }
        Iterator localIterator = ((Iterable)parama).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            parama = localIterator.next();
            if (kotlin.g.b.s.p(((axv)parama).username, paramString)) {
              break;
            }
          }
        }
        parama = null;
      }
    }
    
    public static void a(int paramInt, String paramString, LinkedList<s> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      kotlin.g.b.s.u(paramString, "username");
      kotlin.g.b.s.u(paramLinkedList, "list");
      axv localaxv;
      if (kotlin.a.k.contains(k.fae(), Integer.valueOf(paramInt))) {
        try
        {
          localaxv = new axv();
          localObject1 = new LinkedList();
          localObject3 = (Iterable)paramLinkedList;
          localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(((s)((Iterator)localObject3).next()).FNr);
          }
          AppMethodBeat.o(167073);
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("Finder.FinderPage", (Throwable)paramString, "", new Object[0]);
        }
      } else {
        return;
      }
      ((LinkedList)localObject1).addAll((Collection)localObject2);
      Object localObject2 = kotlin.ah.aiuX;
      localaxv.lPK = ((LinkedList)localObject1);
      localaxv.username = paramString;
      localaxv.oEj = System.currentTimeMillis();
      Object localObject1 = k.faf().Tx(paramInt);
      localObject2 = ((a)localObject1).FMI;
      Object localObject3 = ((axl)localObject2).KNn;
      kotlin.g.b.s.s(localObject3, "it.infoList");
      d.a((LinkedList)localObject3, (kotlin.g.a.b)new a(paramString));
      for (;;)
      {
        paramInt = ((axl)localObject2).KNn.size();
        localObject3 = k.FNg;
        if (paramInt <= k.fad()) {
          break;
        }
        localObject3 = ((axl)localObject2).KNn;
        LinkedList localLinkedList = ((axl)localObject2).KNn;
        kotlin.g.b.s.s(localLinkedList, "it.infoList");
        ((LinkedList)localObject3).remove(kotlin.a.p.ae((List)localLinkedList, 0));
      }
      ((axl)localObject2).KNn.add(localaxv);
      Log.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + ((axl)localObject2).KNn.size());
      a((a)localObject1);
      AppMethodBeat.o(167073);
    }
    
    public static void a(int paramInt, String paramString, kotlin.g.a.b<? super axb, Boolean> paramb)
    {
      AppMethodBeat.i(339458);
      kotlin.g.b.s.u(paramString, "username");
      kotlin.g.b.s.u(paramb, "filter");
      Log.i("Finder.FinderPage", "deleteData typeFlag: " + paramInt + ", username: " + paramString + " isFlush: true");
      Tw(paramInt);
      paramString = a(k.faf().Tx(paramInt), paramString);
      if (paramString != null)
      {
        paramString = paramString.lPK;
        if (paramString != null)
        {
          h localh = h.FMZ;
          if (h.b(paramString, paramb))
          {
            paramString = k.FNg;
            a(k.faf().Tx(paramInt));
          }
        }
      }
      AppMethodBeat.o(339458);
    }
    
    public static void a(a parama)
    {
      AppMethodBeat.i(339395);
      try
      {
        byte[] arrayOfByte = parama.FMI.toByteArray();
        com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("cache2File");
        Object localObject = av.GiL;
        localObject = new com.tencent.mm.vfs.u(av.Ub(2));
        if (!((com.tencent.mm.vfs.u)localObject).isDirectory()) {
          ((com.tencent.mm.vfs.u)localObject).diJ();
        }
        if (!((com.tencent.mm.vfs.u)localObject).jKS()) {
          ((com.tencent.mm.vfs.u)localObject).jKY();
        }
        localObject = com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject).jKT()) + '/' + parama.name + ".ext";
        y.f((String)localObject, arrayOfByte, arrayOfByte.length);
        Log.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localc);
        AppMethodBeat.o(339395);
        return;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(339395);
      }
    }
    
    private static void a(String paramString, axv paramaxv)
    {
      AppMethodBeat.i(339511);
      long l2 = System.currentTimeMillis();
      long l1;
      Object localObject1;
      int i;
      if (paramaxv == null)
      {
        l1 = 0L;
        localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
        if (l2 - l1 <= ((Number)com.tencent.d.a.a.a.a.a.jSX().bmg()).intValue() * 60000) {
          break label93;
        }
        i = 1;
        label49:
        if (i != 0)
        {
          if (paramaxv != null) {
            break label98;
          }
          paramString = null;
        }
      }
      for (;;)
      {
        if (paramaxv != null) {
          paramaxv.lPK = new LinkedList((Collection)paramString);
        }
        AppMethodBeat.o(339511);
        return;
        l1 = paramaxv.oEj;
        break;
        label93:
        i = 0;
        break label49;
        label98:
        localObject1 = paramaxv.lPK;
        if (localObject1 == null)
        {
          paramString = null;
        }
        else
        {
          localObject1 = (Iterable)localObject1;
          Collection localCollection = (Collection)new ArrayList();
          Iterator localIterator = ((Iterable)localObject1).iterator();
          if (localIterator.hasNext())
          {
            Object localObject2 = localIterator.next();
            axb localaxb = (axb)localObject2;
            localObject1 = localaxb.ZIo;
            label183:
            label190:
            StringBuilder localStringBuilder;
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject1 == null) {
                break label349;
              }
              i = 1;
              if (i != 0)
              {
                localStringBuilder = new StringBuilder().append(paramString).append(" filter live:");
                localObject1 = localaxb.ZIo;
                if (localObject1 != null) {
                  break label354;
                }
                localObject1 = null;
                label228:
                localStringBuilder = localStringBuilder.append(localObject1).append(',');
                localObject1 = localaxb.ZIo;
                if (localObject1 != null) {
                  break label385;
                }
                localObject1 = null;
                label257:
                localStringBuilder = localStringBuilder.append(localObject1).append(',');
                localObject1 = localaxb.ZIo;
                if (localObject1 != null) {
                  break label413;
                }
                localObject1 = null;
              }
            }
            for (;;)
            {
              Log.i("Finder.FinderPage", localObject1);
              if (i != 0) {
                break;
              }
              localCollection.add(localObject2);
              break;
              localObject1 = ((FinderObject)localObject1).liveInfo;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label183;
              }
              localObject1 = Long.valueOf(((bip)localObject1).liveId);
              break label183;
              label349:
              i = 0;
              break label190;
              label354:
              localObject1 = ((FinderObject)localObject1).liveInfo;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label228;
              }
              localObject1 = Long.valueOf(((bip)localObject1).liveId);
              break label228;
              label385:
              localObject1 = ((FinderObject)localObject1).objectDesc;
              if (localObject1 == null)
              {
                localObject1 = null;
                break label257;
              }
              localObject1 = ((FinderObjectDesc)localObject1).description;
              break label257;
              label413:
              localObject1 = ((FinderObject)localObject1).contact;
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((FinderContact)localObject1).nickname;
              }
            }
          }
          paramString = (List)localCollection;
        }
      }
    }
    
    public static LinkedList<com.tencent.mm.plugin.finder.model.c> aAL(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(339423);
      Object localObject1 = k.faf().Tx(9).FMI;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!kotlin.g.b.s.p(paramString, z.bAW()))) {
          break label201;
        }
        localObject1 = ((axl)localObject1).KNn;
        kotlin.g.b.s.s(localObject1, "cache.infoList");
        localObject1 = kotlin.a.p.ae((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (axv)localObject1;
        if (localObject1 == null) {
          break label264;
        }
        localObject3 = ((axv)localObject1).lPK;
        if (localObject3 == null) {
          break label264;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (axb)((Iterator)localObject3).next();
          kotlin.g.b.s.s(localObject4, "it");
          localObject4 = new t((axb)localObject4);
          m localm = m.FNo;
          localObject4 = m.b(((s)localObject4).FNr);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        i = 0;
        break;
        label201:
        localObject1 = ((axl)localObject1).KNn;
        kotlin.g.b.s.s(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (kotlin.g.b.s.p(((axv)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
      }
      label264:
      Object localObject3 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      if (localObject1 == null) {
        paramString = localObject2;
      }
      for (;;)
      {
        Log.i("Finder.FinderPage", paramString);
        if (k.access$getDEBUG$cp()) {
          Log.v("Finder.FinderPage", "-----file2Cache END------");
        }
        AppMethodBeat.o(339423);
        return localLinkedList;
        localObject1 = ((axv)localObject1).lPK;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
    }
    
    public static void ad(long paramLong, int paramInt)
    {
      AppMethodBeat.i(339436);
      Tw(paramInt);
      Object localObject = k.faf().Tx(paramInt).FMI.KNn;
      if (localObject != null)
      {
        localObject = (axv)kotlin.a.p.ae((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((axv)localObject).lPK;
          if (localObject != null)
          {
            h localh = h.FMZ;
            if (h.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.FNg;
              a(k.faf().Tx(paramInt));
            }
          }
        }
      }
      AppMethodBeat.o(339436);
    }
    
    public static void ae(long paramLong, int paramInt)
    {
      AppMethodBeat.i(339474);
      Tw(paramInt);
      Object localObject = k.faf().Tx(paramInt).FMI.KNn;
      if (localObject != null)
      {
        localObject = (axv)kotlin.a.p.ae((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((axv)localObject).lPK;
          if (localObject != null)
          {
            p localp = p.FNp;
            if (p.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.FNg;
              a(k.faf().Tx(paramInt));
            }
          }
        }
      }
      AppMethodBeat.o(339474);
    }
    
    public static void clearAll()
    {
      AppMethodBeat.i(167082);
      Object localObject = av.GiL;
      localObject = av.ffT();
      if (y.ZC((String)localObject))
      {
        y.ew((String)localObject, true);
        y.bDX((String)localObject);
        Log.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + y.ZC((String)localObject));
      }
      k.a(k.fai());
      k.faf().reset();
      Log.i("Finder.FinderPage", "clearAll " + k.faf() + ' ' + k.faf().FNq.length);
      AppMethodBeat.o(167082);
    }
    
    public static void d(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = k.fag();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.FNg;
        Tw(k);
        localObject = k.faf().Tx(k).FMI.KNn;
        if (localObject != null)
        {
          localObject = (axv)kotlin.a.p.ae((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((axv)localObject).lPK;
            if (localObject != null)
            {
              h localh = h.FMZ;
              if (h.a(paramLong, paramFinderItem, (LinkedList)localObject))
              {
                localObject = k.FNg;
                a(k.faf().Tx(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167078);
    }
    
    private static LinkedList<cc> eM(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(339411);
      Object localObject1 = k.faf().Tx(paramInt).FMI;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      label81:
      Object localObject3;
      Iterator localIterator;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label206;
        }
        localObject1 = ((axl)localObject1).KNn;
        kotlin.g.b.s.s(localObject1, "cache.infoList");
        localObject1 = kotlin.a.p.ae((List)localObject1, 0);
        localObject3 = (axv)localObject1;
        a("cacheToRVFeedList", (axv)localObject3);
        if (localObject3 == null) {
          break label376;
        }
        localObject1 = ((axv)localObject3).lPK;
        if (localObject1 == null) {
          break label376;
        }
        localIterator = ((Iterable)localObject1).iterator();
      }
      label206:
      label374:
      for (;;)
      {
        label121:
        if (!localIterator.hasNext()) {
          break label376;
        }
        localObject1 = (axb)localIterator.next();
        paramInt = ((axb)localObject1).dataType;
        Object localObject4 = h.FMZ;
        if (paramInt == h.fac())
        {
          kotlin.g.b.s.s(localObject1, "it");
          localObject1 = (s)new r((axb)localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label374;
          }
          localObject1 = ((s)localObject1).eIE();
          if (localObject1 == null) {
            break label121;
          }
          localLinkedList.add(localObject1);
          break label121;
          paramInt = 0;
          break;
          localObject1 = ((axl)localObject1).KNn;
          kotlin.g.b.s.s(localObject1, "cache.infoList");
          localObject3 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (kotlin.g.b.s.p(((axv)localObject1).username, paramString)) {
                break;
              }
            }
          }
          localObject1 = null;
          break label81;
          localObject4 = m.FNo;
          if (paramInt == m.fac())
          {
            kotlin.g.b.s.s(localObject1, "it");
            localObject1 = (s)new t((axb)localObject1);
          }
          else
          {
            localObject4 = p.FNp;
            if (paramInt == p.fac())
            {
              kotlin.g.b.s.s(localObject1, "it");
              localObject1 = (s)new u((axb)localObject1);
            }
            else
            {
              localObject4 = w.FNw;
              if (paramInt == w.fac())
              {
                kotlin.g.b.s.s(localObject1, "it");
                localObject1 = (s)new f((axb)localObject1);
              }
              else
              {
                localObject1 = null;
              }
            }
          }
        }
      }
      label376:
      localObject1 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      if (localObject3 == null) {
        paramString = localObject2;
      }
      for (;;)
      {
        Log.i("Finder.FinderPage", paramString);
        if (k.access$getDEBUG$cp()) {
          Log.v("Finder.FinderPage", "-----file2Cache END------");
        }
        AppMethodBeat.o(339411);
        return localLinkedList;
        localObject3 = ((axv)localObject3).lPK;
        paramString = localObject2;
        if (localObject3 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject3).size());
        }
      }
    }
    
    private static LinkedList<FinderItem> eN(String paramString, int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(339416);
      Object localObject4 = k.faf().Tx(paramInt).FMI;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      Object localObject1;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!kotlin.g.b.s.p(paramString, z.bAW()))) {
          break label274;
        }
        localObject1 = ((axl)localObject4).KNn;
        kotlin.g.b.s.s(localObject1, "cache.infoList");
        localObject1 = (axv)kotlin.a.p.ae((List)localObject1, 0);
        label97:
        if (localObject1 != null) {
          break label279;
        }
        localObject2 = null;
        label103:
        if (!kotlin.g.b.s.p(localObject2, paramString))
        {
          localObject1 = ((axl)localObject4).KNn;
          kotlin.g.b.s.s(localObject1, "cache.infoList");
          localObject2 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject2).next();
          } while (!kotlin.g.b.s.p(((axv)localObject1).username, paramString));
        }
      }
      for (;;)
      {
        localObject1 = (axv)localObject1;
        a("cacheToFinderItemList", (axv)localObject1);
        if (localObject1 == null) {
          break label292;
        }
        localObject2 = ((axv)localObject1).lPK;
        if (localObject2 == null) {
          break label292;
        }
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (axb)((Iterator)localObject2).next();
          kotlin.g.b.s.s(localObject4, "it");
          localObject4 = new r((axb)localObject4);
          h localh = h.FMZ;
          localObject4 = h.a(((s)localObject4).FNr);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        paramInt = 0;
        break;
        label274:
        localObject1 = null;
        break label97;
        label279:
        localObject2 = ((axv)localObject1).username;
        break label103;
        localObject1 = null;
      }
      label292:
      Object localObject2 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      if (localObject1 == null) {
        paramString = localObject3;
      }
      for (;;)
      {
        Log.i("Finder.FinderPage", paramString);
        if (k.access$getDEBUG$cp()) {
          Log.v("Finder.FinderPage", "-----file2Cache END------");
        }
        AppMethodBeat.o(339416);
        return localLinkedList;
        localObject1 = ((axv)localObject1).lPK;
        paramString = localObject3;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
    }
    
    public static void faj()
    {
      AppMethodBeat.i(339446);
      k.faf().Tx(1).FMI.KNn.clear();
      AppMethodBeat.o(339446);
    }
    
    public static void qk(long paramLong)
    {
      AppMethodBeat.i(339478);
      Integer[] arrayOfInteger = k.fah();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        a locala = k.FNg;
        ae(paramLong, k);
        i += 1;
      }
      AppMethodBeat.o(339478);
    }
    
    public static void ql(long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = k.fag();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.FNg;
        Tw(k);
        localObject = k.faf().Tx(k).FMI.KNn;
        if (localObject != null)
        {
          localObject = (axv)kotlin.a.p.ae((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((axv)localObject).lPK;
            if (localObject != null)
            {
              h localh = h.FMZ;
              if (h.b(paramLong, (LinkedList)localObject))
              {
                localObject = k.FNg;
                a(k.faf().Tx(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    public final List<cc> bE(int paramInt, String paramString)
    {
      AppMethodBeat.i(339525);
      kotlin.g.b.s.u(paramString, "username");
      Tw(paramInt);
      paramString = (List)eM(paramString, paramInt);
      AppMethodBeat.o(339525);
      return paramString;
    }
    
    public final List<FinderItem> eO(String paramString, int paramInt)
    {
      AppMethodBeat.i(339533);
      kotlin.g.b.s.u(paramString, "username");
      Tw(paramInt);
      paramString = (List)eN(paramString, paramInt);
      AppMethodBeat.o(339533);
      return paramString;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<axv, Boolean>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */