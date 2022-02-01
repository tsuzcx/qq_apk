package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class l
{
  private static boolean DEBUG = false;
  private static final int MAX_CACHE_SIZE = 20;
  private static final Integer[] vGr;
  private static final Integer[] vGs;
  private static final Integer[] vGt;
  private static final q vGu;
  private static q vGv;
  public static final a vGw;
  
  static
  {
    AppMethodBeat.i(167083);
    vGw = new a((byte)0);
    MAX_CACHE_SIZE = 20;
    vGr = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14) };
    vGs = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    vGt = new Integer[] { Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13) };
    q localq = new q(new a[] { new a(0, "main_v3", new arb(), 0), new a(1, "profile_v3", new arb(), 0), new a(2, "like_v3", new arb(), 0), new a(3, "others_v3", new arb(), 0), new a(4, "prefetch_v3", new arb(), 0), new a(5, "friend_tab_v3", new arb(), 0), new a(6, "lbs_tab_v3", new arb(), 0), new a(7, "follow_v3", new arb(), 0), new a(8, "machine_v3", new arb(), 0), new a(9, "lbs_tab_section_v3", new arb(), 0), new a(10, "fav_v3", new arb(), 0), new a(11, "mega_video_like_v3", new arb(), 0), new a(12, "mega_video_fav_v3", new arb(), 0), new a(13, "mega_video_profile_v3", new arb(), 0), new a(14, "profile_at_feed_v3", new arb(), 0), new a(15, "nearby_live_v3", new arb(), 0), new a(16, "nearby_live_more_v3", new arb(), 0) });
    vGu = localq;
    vGv = localq;
    AppMethodBeat.o(167083);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "megaVideoArray", "selfArray", "cacheLongTime", "fpPage", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "cacheToFinderItemList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToRVFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cacheToSectionList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "clearAll", "deleteMegaVideoPageData", "id", "", "pageName", "deletePageData", "svrId", "svrIds", "", "deletePageDataByLocalId", "localId", "fileToCache", "filterLiveItem", "prefix", "getLast", "typeFlag", "getLastFinderItem", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "updatePageData", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
  public static final class a
  {
    public static void FP(long paramLong)
    {
      AppMethodBeat.i(252017);
      Integer[] arrayOfInteger = l.dyF();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        a locala = l.vGw;
        M(paramLong, k);
        i += 1;
      }
      AppMethodBeat.o(252017);
    }
    
    public static void FQ(long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = l.dyE();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = l.vGw;
        Lf(k);
        localObject = l.dyD().Lg(k).vFP.zns;
        if (localObject != null)
        {
          localObject = (arl)j.L((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((arl)localObject).gCs;
            if (localObject != null)
            {
              i locali = i.vGl;
              if (i.b(paramLong, (LinkedList)localObject))
              {
                localObject = l.vGw;
                a(l.dyD().Lg(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    public static void L(long paramLong, int paramInt)
    {
      AppMethodBeat.i(252015);
      Lf(paramInt);
      Object localObject = l.dyD().Lg(paramInt).vFP.zns;
      if (localObject != null)
      {
        localObject = (arl)j.L((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((arl)localObject).gCs;
          if (localObject != null)
          {
            i locali = i.vGl;
            if (i.a(paramLong, (LinkedList)localObject))
            {
              localObject = l.vGw;
              a(l.dyD().Lg(paramInt));
            }
            AppMethodBeat.o(252015);
            return;
          }
        }
      }
      AppMethodBeat.o(252015);
    }
    
    private static a Le(int paramInt)
    {
      a locala = null;
      AppMethodBeat.i(252011);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject3 = y.vXH;
          str = y.LA(2) + '/' + l.dyD().Lg(paramInt).name + ".ext";
          localc = new com.tencent.mm.ac.c("file2Cache");
          arrayOfByte = com.tencent.mm.vfs.s.aW(str, 0, -1);
          localObject1 = (com.tencent.mm.bw.a)new arb();
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject3;
          String str;
          com.tencent.mm.ac.c localc;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          Object localObject2;
          Log.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
          continue;
        }
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom(arrayOfByte);
          localObject3 = (arb)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          localObject1 = locala;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
          Log.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localc);
          locala = l.dyD().Lg(paramInt);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new arb();
          }
          locala.a((arb)localObject1);
          l.dyD().Lg(paramInt).lNl = true;
          localObject1 = l.dyD().Lg(paramInt);
          AppMethodBeat.o(252011);
          return localObject1;
        }
        catch (Exception localException1)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
      }
    }
    
    public static a Lf(int paramInt)
    {
      AppMethodBeat.i(252018);
      if (l.dyD().Lg(paramInt).lNl)
      {
        locala = l.dyD().Lg(paramInt);
        AppMethodBeat.o(252018);
        return locala;
      }
      l.dyD().a(paramInt, Le(paramInt));
      a locala = l.dyD().Lg(paramInt);
      AppMethodBeat.o(252018);
      return locala;
    }
    
    public static void M(long paramLong, int paramInt)
    {
      AppMethodBeat.i(252016);
      Lf(paramInt);
      Object localObject = l.dyD().Lg(paramInt).vFP.zns;
      if (localObject != null)
      {
        localObject = (arl)j.L((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((arl)localObject).gCs;
          if (localObject != null)
          {
            p localp = p.vGB;
            if (p.a(paramLong, (LinkedList)localObject))
            {
              localObject = l.vGw;
              a(l.dyD().Lg(paramInt));
            }
            AppMethodBeat.o(252016);
            return;
          }
        }
      }
      AppMethodBeat.o(252016);
    }
    
    public static void a(int paramInt, String paramString, final LinkedList<s> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      kotlin.g.b.p.h(paramString, "username");
      kotlin.g.b.p.h(paramLinkedList, "list");
      final arl localarl;
      if (e.contains(l.dyC(), Integer.valueOf(paramInt))) {
        try
        {
          localarl = new arl();
          localObject1 = new LinkedList();
          localObject3 = (Iterable)paramLinkedList;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(((s)((Iterator)localObject3).next()).vGD);
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
      localarl.gCs = ((LinkedList)localObject1);
      localarl.username = paramString;
      localarl.iVn = System.currentTimeMillis();
      Object localObject1 = l.dyD().Lg(paramInt);
      Object localObject2 = ((a)localObject1).vFP;
      Object localObject3 = ((arb)localObject2).zns;
      kotlin.g.b.p.g(localObject3, "it.infoList");
      d.a((LinkedList)localObject3, (kotlin.g.a.b)new a(paramString, localarl, paramLinkedList));
      for (;;)
      {
        paramInt = ((arb)localObject2).zns.size();
        localObject3 = l.vGw;
        if (paramInt <= l.dyB()) {
          break;
        }
        localObject3 = ((arb)localObject2).zns;
        LinkedList localLinkedList = ((arb)localObject2).zns;
        kotlin.g.b.p.g(localLinkedList, "it.infoList");
        ((LinkedList)localObject3).remove(j.L((List)localLinkedList, 0));
      }
      ((arb)localObject2).zns.add(localarl);
      Log.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + ((arb)localObject2).zns.size());
      a((a)localObject1);
      AppMethodBeat.o(167073);
    }
    
    public static void a(a parama)
    {
      AppMethodBeat.i(252010);
      try
      {
        byte[] arrayOfByte = parama.vFP.toByteArray();
        com.tencent.mm.ac.c localc = new com.tencent.mm.ac.c("cache2File");
        Object localObject = y.vXH;
        localObject = new o(y.LA(2));
        if (!((o)localObject).isDirectory()) {
          ((o)localObject).delete();
        }
        if (!((o)localObject).exists()) {
          ((o)localObject).mkdirs();
        }
        localObject = ((o)localObject).getAbsolutePath() + '/' + parama.name + ".ext";
        com.tencent.mm.vfs.s.C((String)localObject, arrayOfByte);
        Log.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localc);
        AppMethodBeat.o(252010);
        return;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(252010);
      }
    }
    
    private static void a(String paramString, arl paramarl)
    {
      AppMethodBeat.i(252022);
      long l2 = System.currentTimeMillis();
      long l1;
      int i;
      label52:
      Collection localCollection;
      label99:
      Object localObject2;
      label159:
      label166:
      StringBuilder localStringBuilder;
      if (paramarl != null)
      {
        l1 = paramarl.iVn;
        localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (l2 - l1 <= ((Number)com.tencent.mm.plugin.finder.storage.c.dvs().value()).intValue() * 60000) {
          break label350;
        }
        i = 1;
        if (i == 0) {
          break label421;
        }
        if (paramarl == null) {
          break label416;
        }
        localObject1 = paramarl.gCs;
        if (localObject1 == null) {
          break label416;
        }
        localObject1 = (Iterable)localObject1;
        localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label384;
        }
        localObject2 = localIterator.next();
        aqq localaqq = (aqq)localObject2;
        localObject1 = localaqq.LCD;
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = ((FinderObject)localObject1).liveInfo;
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = Long.valueOf(((awe)localObject1).liveId);
        if (localObject1 == null) {
          break label361;
        }
        i = 1;
        if (i != 0)
        {
          localStringBuilder = new StringBuilder().append(paramString).append(" filter live:");
          localObject1 = localaqq.LCD;
          if (localObject1 == null) {
            break label366;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label366;
          }
          localObject1 = Long.valueOf(((awe)localObject1).liveId);
          label223:
          localStringBuilder = localStringBuilder.append(localObject1).append(',');
          localObject1 = localaqq.LCD;
          if (localObject1 == null) {
            break label372;
          }
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 == null) {
            break label372;
          }
          localObject1 = ((FinderObjectDesc)localObject1).description;
          label268:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(',');
          localObject1 = localaqq.LCD;
          if (localObject1 == null) {
            break label378;
          }
          localObject1 = ((FinderObject)localObject1).contact;
          if (localObject1 == null) {
            break label378;
          }
        }
      }
      label350:
      label355:
      label361:
      label366:
      label372:
      label378:
      for (Object localObject1 = ((FinderContact)localObject1).nickname;; localObject1 = null)
      {
        Log.i("Finder.FinderPage", (String)localObject1);
        if (i != 0) {
          break label99;
        }
        localCollection.add(localObject2);
        break label99;
        l1 = 0L;
        break;
        i = 0;
        break label52;
        localObject1 = null;
        break label159;
        i = 0;
        break label166;
        localObject1 = null;
        break label223;
        localObject1 = null;
        break label268;
      }
      label384:
      label416:
      for (paramString = (List)localCollection; paramarl != null; paramString = null)
      {
        paramarl.gCs = new LinkedList((Collection)paramString);
        AppMethodBeat.o(252022);
        return;
      }
      label421:
      AppMethodBeat.o(252022);
    }
    
    public static LinkedList<com.tencent.mm.plugin.finder.model.c> avF(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(252014);
      Object localObject1 = l.dyD().Lg(9).vFP;
      LinkedList localLinkedList = new LinkedList();
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!kotlin.g.b.p.j(paramString, z.aUg()))) {
          break label201;
        }
        localObject1 = ((arb)localObject1).zns;
        kotlin.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.L((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (arl)localObject1;
        if (localObject1 == null) {
          break label264;
        }
        localObject3 = ((arl)localObject1).gCs;
        if (localObject3 == null) {
          break label264;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (aqq)((Iterator)localObject3).next();
          kotlin.g.b.p.g(localObject4, "it");
          localObject4 = new t((aqq)localObject4);
          n localn = n.vGA;
          localObject4 = n.b(((s)localObject4).vGD);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        i = 0;
        break;
        label201:
        localObject1 = ((arb)localObject1).zns;
        kotlin.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (kotlin.g.b.p.j(((arl)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
      }
      label264:
      Object localObject3 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((arl)localObject1).gCs;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(252014);
      return localLinkedList;
    }
    
    public static void c(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = l.dyE();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = l.vGw;
        Lf(k);
        localObject = l.dyD().Lg(k).vFP.zns;
        if (localObject != null)
        {
          localObject = (arl)j.L((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((arl)localObject).gCs;
            if (localObject != null)
            {
              i locali = i.vGl;
              if (i.a(paramLong, paramFinderItem, (LinkedList)localObject))
              {
                localObject = l.vGw;
                a(l.dyD().Lg(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167078);
    }
    
    public static void clearAll()
    {
      AppMethodBeat.i(167082);
      Object localObject = y.vXH;
      localObject = y.dCD();
      if (com.tencent.mm.vfs.s.YS((String)localObject))
      {
        com.tencent.mm.vfs.s.deleteDir((String)localObject);
        com.tencent.mm.vfs.s.boN((String)localObject);
        Log.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + com.tencent.mm.vfs.s.YS((String)localObject));
      }
      l.a(l.dyG());
      l.dyD().reset();
      Log.i("Finder.FinderPage", "clearAll " + l.dyD() + ' ' + l.dyD().vGC.length);
      AppMethodBeat.o(167082);
    }
    
    private static LinkedList<bo> dE(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(252012);
      Object localObject1 = l.dyD().Lg(paramInt).vFP;
      LinkedList localLinkedList = new LinkedList();
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      label81:
      Object localObject3;
      Iterator localIterator;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label203;
        }
        localObject1 = ((arb)localObject1).zns;
        kotlin.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.L((List)localObject1, 0);
        localObject3 = (arl)localObject1;
        a("cacheToRVFeedList", (arl)localObject3);
        if (localObject3 == null) {
          break label335;
        }
        localObject1 = ((arl)localObject3).gCs;
        if (localObject1 == null) {
          break label335;
        }
        localIterator = ((Iterable)localObject1).iterator();
      }
      label203:
      label333:
      for (;;)
      {
        label121:
        if (!localIterator.hasNext()) {
          break label335;
        }
        localObject1 = (aqq)localIterator.next();
        paramInt = ((aqq)localObject1).dataType;
        Object localObject4 = i.vGl;
        if (paramInt == 0)
        {
          kotlin.g.b.p.g(localObject1, "it");
          localObject1 = (s)new r((aqq)localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label333;
          }
          localObject1 = ((s)localObject1).dyH();
          if (localObject1 == null) {
            break label121;
          }
          localLinkedList.add(localObject1);
          break label121;
          paramInt = 0;
          break;
          localObject1 = ((arb)localObject1).zns;
          kotlin.g.b.p.g(localObject1, "cache.infoList");
          localObject3 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (kotlin.g.b.p.j(((arl)localObject1).username, paramString)) {
                break;
              }
            }
          }
          localObject1 = null;
          break label81;
          localObject4 = n.vGA;
          if (paramInt == 1)
          {
            kotlin.g.b.p.g(localObject1, "it");
            localObject1 = (s)new t((aqq)localObject1);
          }
          else
          {
            localObject4 = p.vGB;
            if (paramInt == 2)
            {
              kotlin.g.b.p.g(localObject1, "it");
              localObject1 = (s)new u((aqq)localObject1);
            }
            else
            {
              localObject1 = null;
            }
          }
        }
      }
      label335:
      localObject1 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((arl)localObject3).gCs;
        paramString = localObject2;
        if (localObject3 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject3).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(252012);
      return localLinkedList;
    }
    
    private static LinkedList<FinderItem> dF(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(252013);
      Object localObject1 = l.dyD().Lg(paramInt).vFP;
      LinkedList localLinkedList = new LinkedList();
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!kotlin.g.b.p.j(paramString, z.aUg()))) {
          break label207;
        }
        localObject1 = ((arb)localObject1).zns;
        kotlin.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.L((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (arl)localObject1;
        a("cacheToFinderItemList", (arl)localObject1);
        if (localObject1 == null) {
          break label270;
        }
        localObject3 = ((arl)localObject1).gCs;
        if (localObject3 == null) {
          break label270;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (aqq)((Iterator)localObject3).next();
          kotlin.g.b.p.g(localObject4, "it");
          localObject4 = new r((aqq)localObject4);
          i locali = i.vGl;
          localObject4 = i.a(((s)localObject4).vGD);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        paramInt = 0;
        break;
        label207:
        localObject1 = ((arb)localObject1).zns;
        kotlin.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (kotlin.g.b.p.j(((arl)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
      }
      label270:
      Object localObject3 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((arl)localObject1).gCs;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (l.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(252013);
      return localLinkedList;
    }
    
    public static void p(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167077);
      kotlin.g.b.p.h(paramFinderItem, "item");
      if (l.dyD().Lg(7).lNl)
      {
        Object localObject = l.dyD().Lg(7).vFP.zns;
        kotlin.g.b.p.g(localObject, "cache[ConstantsFinder.Lo…INE_FOLLOW].page.infoList");
        localObject = (arl)j.L((List)localObject, 0);
        if (localObject != null)
        {
          paramFinderItem = new r(2, paramFinderItem.getLocalId(), paramFinderItem.getFeedObject(), 7);
          ((arl)localObject).gCs.addFirst(paramFinderItem.vGD);
          AppMethodBeat.o(167077);
          return;
        }
      }
      AppMethodBeat.o(167077);
    }
    
    public final List<bo> bc(int paramInt, String paramString)
    {
      AppMethodBeat.i(252019);
      kotlin.g.b.p.h(paramString, "username");
      Lf(paramInt);
      paramString = (List)dE(paramString, paramInt);
      AppMethodBeat.o(252019);
      return paramString;
    }
    
    public final List<FinderItem> dG(String paramString, int paramInt)
    {
      AppMethodBeat.i(252021);
      kotlin.g.b.p.h(paramString, "username");
      Lf(paramInt);
      paramString = (List)dF(paramString, paramInt);
      AppMethodBeat.o(252021);
      return paramString;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<arl, Boolean>
    {
      a(String paramString, arl paramarl, LinkedList paramLinkedList)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.l
 * JD-Core Version:    0.7.0.1
 */