package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.b.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class k
{
  private static boolean DEBUG = false;
  private static final int MAX_CACHE_SIZE = 20;
  private static final Integer[] sAa;
  private static final Integer[] sAb;
  private static final m sAc;
  private static m sAd;
  public static final a sAe;
  
  static
  {
    AppMethodBeat.i(167083);
    sAe = new a((byte)0);
    MAX_CACHE_SIZE = 20;
    sAa = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    sAb = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    m localm = new m(new a[] { new a(0, "main_v3", new amw(), 0), new a(1, "profile_v3", new amw(), 0), new a(2, "like_v3", new amw(), 0), new a(3, "others_v3", new amw(), 0), new a(4, "prefetch_v3", new amw(), 0), new a(5, "friend_tab_v3", new amw(), 0), new a(6, "lbs_tab_v3", new amw(), 0), new a(7, "follow_v3", new amw(), 0), new a(8, "machine_v3", new amw(), 0), new a(9, "lbs_tab_section_v3", new amw(), 0), new a(10, "fav_v3", new amw(), 0) });
    sAc = localm;
    sAd = localm;
    AppMethodBeat.o(167083);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "selfArray", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "cacheToFinderItemList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToRVFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cacheToSectionList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "clearAll", "deletePageData", "svrId", "", "pageName", "svrIds", "", "deletePageDataByLocalId", "localId", "fileToCache", "getLast", "typeFlag", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "plugin-finder_release"})
  public static final class a
  {
    private static a Fs(int paramInt)
    {
      a locala = null;
      AppMethodBeat.i(203828);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sMo;
          str = com.tencent.mm.plugin.finder.utils.p.FK(2) + '/' + k.cJh().Fv(paramInt).name + ".ext";
          localb = new com.tencent.mm.ad.b("file2Cache");
          arrayOfByte = i.aY(str, 0, -1);
          localObject1 = (com.tencent.mm.bx.a)new amw();
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject3;
          String str;
          com.tencent.mm.ad.b localb;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          Object localObject2;
          ad.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
          continue;
        }
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(arrayOfByte);
          localObject3 = (amw)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          localObject1 = locala;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
          ad.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localb);
          locala = k.cJh().Fv(paramInt);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new amw();
          }
          locala.a((amw)localObject1);
          k.cJh().Fv(paramInt).kFr = true;
          localObject1 = k.cJh().Fv(paramInt);
          AppMethodBeat.o(203828);
          return localObject1;
        }
        catch (Exception localException1)
        {
          ad.l("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
      }
    }
    
    public static a Ft(int paramInt)
    {
      AppMethodBeat.i(203833);
      if (k.cJh().Fv(paramInt).kFr)
      {
        locala = k.cJh().Fv(paramInt);
        AppMethodBeat.o(203833);
        return locala;
      }
      k.cJh().a(paramInt, Fs(paramInt));
      a locala = k.cJh().Fv(paramInt);
      AppMethodBeat.o(203833);
      return locala;
    }
    
    public static List<al> Fu(int paramInt)
    {
      AppMethodBeat.i(167081);
      Ft(paramInt);
      List localList = (List)dq("", paramInt);
      AppMethodBeat.o(167081);
      return localList;
    }
    
    public static void M(long paramLong, int paramInt)
    {
      AppMethodBeat.i(203832);
      Ft(paramInt);
      Object localObject = k.cJh().Fv(paramInt).szD.vHi;
      if (localObject != null)
      {
        localObject = (and)j.E((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((and)localObject).fVg;
          if (localObject != null)
          {
            h localh = h.szU;
            if (h.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.sAe;
              a(k.cJh().Fv(paramInt));
            }
            AppMethodBeat.o(203832);
            return;
          }
        }
      }
      AppMethodBeat.o(203832);
    }
    
    public static void a(int paramInt, String paramString, final LinkedList<o> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      d.g.b.p.h(paramString, "username");
      d.g.b.p.h(paramLinkedList, "list");
      final and localand;
      if (d.a.e.contains(k.cJg(), Integer.valueOf(paramInt))) {
        try
        {
          localand = new and();
          localObject1 = new LinkedList();
          localObject3 = (Iterable)paramLinkedList;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(((o)((Iterator)localObject3).next()).sAk);
          }
          AppMethodBeat.o(167073);
        }
        catch (Exception paramString)
        {
          ad.printErrStackTrace("Finder.FinderPage", (Throwable)paramString, "", new Object[0]);
        }
      } else {
        return;
      }
      ((LinkedList)localObject1).addAll((Collection)localObject2);
      localand.fVg = ((LinkedList)localObject1);
      localand.username = paramString;
      Object localObject1 = k.cJh().Fv(paramInt);
      Object localObject2 = ((a)localObject1).szD;
      Object localObject3 = ((amw)localObject2).vHi;
      d.g.b.p.g(localObject3, "it.infoList");
      com.tencent.mm.ad.c.a((LinkedList)localObject3, (d.g.a.b)new a(paramString, localand, paramLinkedList));
      for (;;)
      {
        paramInt = ((amw)localObject2).vHi.size();
        localObject3 = k.sAe;
        if (paramInt <= k.cJf()) {
          break;
        }
        localObject3 = ((amw)localObject2).vHi;
        LinkedList localLinkedList = ((amw)localObject2).vHi;
        d.g.b.p.g(localLinkedList, "it.infoList");
        ((LinkedList)localObject3).remove(j.E((List)localLinkedList, 0));
      }
      ((amw)localObject2).vHi.add(localand);
      ad.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + ((amw)localObject2).vHi.size());
      a((a)localObject1);
      AppMethodBeat.o(167073);
    }
    
    public static void a(a parama)
    {
      AppMethodBeat.i(203827);
      try
      {
        byte[] arrayOfByte = parama.szD.toByteArray();
        com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("cache2File");
        Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
        localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.finder.utils.p.FK(2));
        if (!((com.tencent.mm.vfs.e)localObject).isDirectory()) {
          ((com.tencent.mm.vfs.e)localObject).delete();
        }
        if (!((com.tencent.mm.vfs.e)localObject).exists()) {
          ((com.tencent.mm.vfs.e)localObject).mkdirs();
        }
        localObject = ((com.tencent.mm.vfs.e)localObject).getAbsolutePath() + '/' + parama.name + ".ext";
        i.C((String)localObject, arrayOfByte);
        ad.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localb);
        AppMethodBeat.o(203827);
        return;
      }
      catch (Exception parama)
      {
        ad.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(203827);
      }
    }
    
    public static LinkedList<com.tencent.mm.plugin.finder.model.c> aiB(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(203831);
      Object localObject1 = k.cJh().Fv(9).szD;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!d.g.b.p.i(paramString, u.aAu()))) {
          break label201;
        }
        localObject1 = ((amw)localObject1).vHi;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.E((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (and)localObject1;
        if (localObject1 == null) {
          break label264;
        }
        localObject3 = ((and)localObject1).fVg;
        if (localObject3 == null) {
          break label264;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (amo)((Iterator)localObject3).next();
          d.g.b.p.g(localObject4, "it");
          localObject4 = new p((amo)localObject4);
          l locall = l.sAi;
          localObject4 = l.b(((o)localObject4).sAk);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        i = 0;
        break;
        label201:
        localObject1 = ((amw)localObject1).vHi;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (d.g.b.p.i(((and)localObject1).username, paramString)) {
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
        localObject1 = ((and)localObject1).fVg;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      ad.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(203831);
      return localLinkedList;
    }
    
    public static void c(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = k.cJi();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.sAe;
        Ft(k);
        localObject = k.cJh().Fv(k).szD.vHi;
        if (localObject != null)
        {
          localObject = (and)j.E((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((and)localObject).fVg;
            if (localObject != null)
            {
              h localh = h.szU;
              if (h.a(paramLong, paramFinderItem, (LinkedList)localObject))
              {
                localObject = k.sAe;
                a(k.cJh().Fv(k));
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
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      localObject = com.tencent.mm.plugin.finder.utils.p.cLA();
      if (i.fv((String)localObject))
      {
        i.deleteDir((String)localObject);
        i.aYg((String)localObject);
        ad.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + i.fv((String)localObject));
      }
      k.a(k.cJj());
      k.cJh().reset();
      ad.i("Finder.FinderPage", "clearAll " + k.cJh() + ' ' + k.cJh().sAj.length);
      AppMethodBeat.o(167082);
    }
    
    private static LinkedList<al> dq(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(203829);
      Object localObject1 = k.cJh().Fv(paramInt).szD;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache START------");
      }
      label91:
      Object localObject3;
      Iterator localIterator;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!d.g.b.p.i(paramString, u.aAu()))) {
          break label205;
        }
        localObject1 = ((amw)localObject1).vHi;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.E((List)localObject1, 0);
        localObject3 = (and)localObject1;
        if (localObject3 == null) {
          break label305;
        }
        localObject1 = ((and)localObject3).fVg;
        if (localObject1 == null) {
          break label305;
        }
        localIterator = ((Iterable)localObject1).iterator();
      }
      label303:
      for (;;)
      {
        label123:
        if (!localIterator.hasNext()) {
          break label305;
        }
        localObject1 = (amo)localIterator.next();
        paramInt = ((amo)localObject1).dataType;
        Object localObject4 = h.szU;
        if (paramInt == 0)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = (o)new n((amo)localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label303;
          }
          localObject1 = ((o)localObject1).cJk();
          if (localObject1 == null) {
            break label123;
          }
          localLinkedList.add(localObject1);
          break label123;
          paramInt = 0;
          break;
          label205:
          localObject1 = ((amw)localObject1).vHi;
          d.g.b.p.g(localObject1, "cache.infoList");
          localObject3 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (d.g.b.p.i(((and)localObject1).username, paramString)) {
                break;
              }
            }
          }
          localObject1 = null;
          break label91;
          localObject4 = l.sAi;
          if (paramInt == 1)
          {
            d.g.b.p.g(localObject1, "it");
            localObject1 = (o)new p((amo)localObject1);
          }
          else
          {
            localObject1 = null;
          }
        }
      }
      label305:
      localObject1 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((and)localObject3).fVg;
        paramString = localObject2;
        if (localObject3 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject3).size());
        }
      }
      ad.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(203829);
      return localLinkedList;
    }
    
    private static LinkedList<FinderItem> dr(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(203830);
      Object localObject1 = k.cJh().Fv(paramInt).szD;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache START------");
      }
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!d.g.b.p.i(paramString, u.aAu()))) {
          break label200;
        }
        localObject1 = ((amw)localObject1).vHi;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.E((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (and)localObject1;
        if (localObject1 == null) {
          break label263;
        }
        localObject3 = ((and)localObject1).fVg;
        if (localObject3 == null) {
          break label263;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (amo)((Iterator)localObject3).next();
          d.g.b.p.g(localObject4, "it");
          localObject4 = new n((amo)localObject4);
          h localh = h.szU;
          localObject4 = h.a(((o)localObject4).sAk);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        paramInt = 0;
        break;
        label200:
        localObject1 = ((amw)localObject1).vHi;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (d.g.b.p.i(((and)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
      }
      label263:
      Object localObject3 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((and)localObject1).fVg;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      ad.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ad.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(203830);
      return localLinkedList;
    }
    
    public static List<FinderItem> ds(String paramString, int paramInt)
    {
      AppMethodBeat.i(203834);
      d.g.b.p.h(paramString, "username");
      Ft(paramInt);
      paramString = (List)dr(paramString, paramInt);
      AppMethodBeat.o(203834);
      return paramString;
    }
    
    public static void h(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167077);
      d.g.b.p.h(paramFinderItem, "item");
      if (k.cJh().Fv(0).kFr)
      {
        Object localObject = k.cJh().Fv(0).szD.vHi;
        d.g.b.p.g(localObject, "cache[ConstantsFinder.Lo…MELINE_ALL].page.infoList");
        localObject = (and)j.E((List)localObject, 0);
        if (localObject != null)
        {
          paramFinderItem = new n(2, paramFinderItem.getLocalId(), paramFinderItem.getFeedObject(), 0);
          ((and)localObject).fVg.addFirst(paramFinderItem.sAk);
          AppMethodBeat.o(167077);
          return;
        }
      }
      AppMethodBeat.o(167077);
    }
    
    public static void xe(long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = k.cJi();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.sAe;
        Ft(k);
        localObject = k.cJh().Fv(k).szD.vHi;
        if (localObject != null)
        {
          localObject = (and)j.E((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((and)localObject).fVg;
            if (localObject != null)
            {
              h localh = h.szU;
              if (h.b(paramLong, (LinkedList)localObject))
              {
                localObject = k.sAe;
                a(k.cJh().Fv(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
    static final class a
      extends q
      implements d.g.a.b<and, Boolean>
    {
      a(String paramString, and paramand, LinkedList paramLinkedList)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */