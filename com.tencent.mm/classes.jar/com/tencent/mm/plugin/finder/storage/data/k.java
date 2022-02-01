package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.e;
import d.a.j;
import d.g.b.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class k
{
  private static boolean DEBUG = false;
  private static final int MAX_CACHE_SIZE = 20;
  private static final Integer[] sKX;
  private static final Integer[] sKY;
  private static final m sKZ;
  private static m sLa;
  public static final a sLb;
  
  static
  {
    AppMethodBeat.i(167083);
    sLb = new a((byte)0);
    MAX_CACHE_SIZE = 20;
    sKX = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    sKY = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    m localm = new m(new a[] { new a(0, "main_v3", new ani(), 0), new a(1, "profile_v3", new ani(), 0), new a(2, "like_v3", new ani(), 0), new a(3, "others_v3", new ani(), 0), new a(4, "prefetch_v3", new ani(), 0), new a(5, "friend_tab_v3", new ani(), 0), new a(6, "lbs_tab_v3", new ani(), 0), new a(7, "follow_v3", new ani(), 0), new a(8, "machine_v3", new ani(), 0), new a(9, "lbs_tab_section_v3", new ani(), 0), new a(10, "fav_v3", new ani(), 0) });
    sKZ = localm;
    sLa = localm;
    AppMethodBeat.o(167083);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "selfArray", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "cacheToFinderItemList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToRVFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cacheToSectionList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "clearAll", "deletePageData", "svrId", "", "pageName", "svrIds", "", "deletePageDataByLocalId", "localId", "fileToCache", "getLast", "typeFlag", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "plugin-finder_release"})
  public static final class a
  {
    private static a FP(int paramInt)
    {
      a locala = null;
      AppMethodBeat.i(204419);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject3 = com.tencent.mm.plugin.finder.utils.p.sXz;
          str = com.tencent.mm.plugin.finder.utils.p.Gi(2) + '/' + k.cLK().FS(paramInt).name + ".ext";
          localb = new com.tencent.mm.ac.b("file2Cache");
          arrayOfByte = com.tencent.mm.vfs.o.bb(str, 0, -1);
          localObject1 = (com.tencent.mm.bw.a)new ani();
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject3;
          String str;
          com.tencent.mm.ac.b localb;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          Object localObject2;
          ae.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
          continue;
        }
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom(arrayOfByte);
          localObject3 = (ani)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          localObject1 = locala;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
          ae.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localb);
          locala = k.cLK().FS(paramInt);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new ani();
          }
          locala.a((ani)localObject1);
          k.cLK().FS(paramInt).kIG = true;
          localObject1 = k.cLK().FS(paramInt);
          AppMethodBeat.o(204419);
          return localObject1;
        }
        catch (Exception localException1)
        {
          ae.l("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
      }
    }
    
    public static a FQ(int paramInt)
    {
      AppMethodBeat.i(204424);
      if (k.cLK().FS(paramInt).kIG)
      {
        locala = k.cLK().FS(paramInt);
        AppMethodBeat.o(204424);
        return locala;
      }
      k.cLK().a(paramInt, FP(paramInt));
      a locala = k.cLK().FS(paramInt);
      AppMethodBeat.o(204424);
      return locala;
    }
    
    public static List<am> FR(int paramInt)
    {
      AppMethodBeat.i(167081);
      FQ(paramInt);
      List localList = (List)dv("", paramInt);
      AppMethodBeat.o(167081);
      return localList;
    }
    
    public static void M(long paramLong, int paramInt)
    {
      AppMethodBeat.i(204423);
      FQ(paramInt);
      Object localObject = k.cLK().FS(paramInt).sKx.vTm;
      if (localObject != null)
      {
        localObject = (anq)j.F((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((anq)localObject).fXm;
          if (localObject != null)
          {
            h localh = h.sKR;
            if (h.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.sLb;
              a(k.cLK().FS(paramInt));
            }
            AppMethodBeat.o(204423);
            return;
          }
        }
      }
      AppMethodBeat.o(204423);
    }
    
    public static void a(int paramInt, String paramString, final LinkedList<o> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      d.g.b.p.h(paramString, "username");
      d.g.b.p.h(paramLinkedList, "list");
      final anq localanq;
      if (e.contains(k.cLJ(), Integer.valueOf(paramInt))) {
        try
        {
          localanq = new anq();
          localObject1 = new LinkedList();
          localObject3 = (Iterable)paramLinkedList;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(((o)((Iterator)localObject3).next()).sLi);
          }
          AppMethodBeat.o(167073);
        }
        catch (Exception paramString)
        {
          ae.printErrStackTrace("Finder.FinderPage", (Throwable)paramString, "", new Object[0]);
        }
      } else {
        return;
      }
      ((LinkedList)localObject1).addAll((Collection)localObject2);
      localanq.fXm = ((LinkedList)localObject1);
      localanq.username = paramString;
      Object localObject1 = k.cLK().FS(paramInt);
      Object localObject2 = ((a)localObject1).sKx;
      Object localObject3 = ((ani)localObject2).vTm;
      d.g.b.p.g(localObject3, "it.infoList");
      com.tencent.mm.ac.c.a((LinkedList)localObject3, (d.g.a.b)new a(paramString, localanq, paramLinkedList));
      for (;;)
      {
        paramInt = ((ani)localObject2).vTm.size();
        localObject3 = k.sLb;
        if (paramInt <= k.cLI()) {
          break;
        }
        localObject3 = ((ani)localObject2).vTm;
        LinkedList localLinkedList = ((ani)localObject2).vTm;
        d.g.b.p.g(localLinkedList, "it.infoList");
        ((LinkedList)localObject3).remove(j.F((List)localLinkedList, 0));
      }
      ((ani)localObject2).vTm.add(localanq);
      ae.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + ((ani)localObject2).vTm.size());
      a((a)localObject1);
      AppMethodBeat.o(167073);
    }
    
    public static void a(a parama)
    {
      AppMethodBeat.i(204418);
      try
      {
        byte[] arrayOfByte = parama.sKx.toByteArray();
        com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("cache2File");
        Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
        localObject = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.finder.utils.p.Gi(2));
        if (!((com.tencent.mm.vfs.k)localObject).isDirectory()) {
          ((com.tencent.mm.vfs.k)localObject).delete();
        }
        if (!((com.tencent.mm.vfs.k)localObject).exists()) {
          ((com.tencent.mm.vfs.k)localObject).mkdirs();
        }
        localObject = ((com.tencent.mm.vfs.k)localObject).getAbsolutePath() + '/' + parama.name + ".ext";
        com.tencent.mm.vfs.o.C((String)localObject, arrayOfByte);
        ae.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localb);
        AppMethodBeat.o(204418);
        return;
      }
      catch (Exception parama)
      {
        ae.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(204418);
      }
    }
    
    public static LinkedList<com.tencent.mm.plugin.finder.model.c> ajy(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(204422);
      Object localObject1 = k.cLK().FS(9).sKx;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!d.g.b.p.i(paramString, v.aAK()))) {
          break label201;
        }
        localObject1 = ((ani)localObject1).vTm;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.F((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (anq)localObject1;
        if (localObject1 == null) {
          break label264;
        }
        localObject3 = ((anq)localObject1).fXm;
        if (localObject3 == null) {
          break label264;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (ana)((Iterator)localObject3).next();
          d.g.b.p.g(localObject4, "it");
          localObject4 = new p((ana)localObject4);
          l locall = l.sLg;
          localObject4 = l.b(((o)localObject4).sLi);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        i = 0;
        break;
        label201:
        localObject1 = ((ani)localObject1).vTm;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (d.g.b.p.i(((anq)localObject1).username, paramString)) {
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
        localObject1 = ((anq)localObject1).fXm;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      ae.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(204422);
      return localLinkedList;
    }
    
    public static void c(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = k.cLL();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.sLb;
        FQ(k);
        localObject = k.cLK().FS(k).sKx.vTm;
        if (localObject != null)
        {
          localObject = (anq)j.F((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((anq)localObject).fXm;
            if (localObject != null)
            {
              h localh = h.sKR;
              if (h.a(paramLong, paramFinderItem, (LinkedList)localObject))
              {
                localObject = k.sLb;
                a(k.cLK().FS(k));
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
      Object localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      localObject = com.tencent.mm.plugin.finder.utils.p.cOg();
      if (com.tencent.mm.vfs.o.fB((String)localObject))
      {
        com.tencent.mm.vfs.o.deleteDir((String)localObject);
        com.tencent.mm.vfs.o.aZI((String)localObject);
        ae.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + com.tencent.mm.vfs.o.fB((String)localObject));
      }
      k.a(k.cLM());
      k.cLK().reset();
      ae.i("Finder.FinderPage", "clearAll " + k.cLK() + ' ' + k.cLK().sLh.length);
      AppMethodBeat.o(167082);
    }
    
    private static LinkedList<am> dv(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(204420);
      Object localObject1 = k.cLK().FS(paramInt).sKx;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache START------");
      }
      label91:
      Object localObject3;
      Iterator localIterator;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!d.g.b.p.i(paramString, v.aAK()))) {
          break label205;
        }
        localObject1 = ((ani)localObject1).vTm;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.F((List)localObject1, 0);
        localObject3 = (anq)localObject1;
        if (localObject3 == null) {
          break label305;
        }
        localObject1 = ((anq)localObject3).fXm;
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
        localObject1 = (ana)localIterator.next();
        paramInt = ((ana)localObject1).dataType;
        Object localObject4 = h.sKR;
        if (paramInt == 0)
        {
          d.g.b.p.g(localObject1, "it");
          localObject1 = (o)new n((ana)localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label303;
          }
          localObject1 = ((o)localObject1).cLN();
          if (localObject1 == null) {
            break label123;
          }
          localLinkedList.add(localObject1);
          break label123;
          paramInt = 0;
          break;
          label205:
          localObject1 = ((ani)localObject1).vTm;
          d.g.b.p.g(localObject1, "cache.infoList");
          localObject3 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (d.g.b.p.i(((anq)localObject1).username, paramString)) {
                break;
              }
            }
          }
          localObject1 = null;
          break label91;
          localObject4 = l.sLg;
          if (paramInt == 1)
          {
            d.g.b.p.g(localObject1, "it");
            localObject1 = (o)new p((ana)localObject1);
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
        localObject3 = ((anq)localObject3).fXm;
        paramString = localObject2;
        if (localObject3 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject3).size());
        }
      }
      ae.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(204420);
      return localLinkedList;
    }
    
    private static LinkedList<FinderItem> dw(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(204421);
      Object localObject1 = k.cLK().FS(paramInt).sKx;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache START------");
      }
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!d.g.b.p.i(paramString, v.aAK()))) {
          break label200;
        }
        localObject1 = ((ani)localObject1).vTm;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject1 = j.F((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (anq)localObject1;
        if (localObject1 == null) {
          break label263;
        }
        localObject3 = ((anq)localObject1).fXm;
        if (localObject3 == null) {
          break label263;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (ana)((Iterator)localObject3).next();
          d.g.b.p.g(localObject4, "it");
          localObject4 = new n((ana)localObject4);
          h localh = h.sKR;
          localObject4 = h.a(((o)localObject4).sLi);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        paramInt = 0;
        break;
        label200:
        localObject1 = ((ani)localObject1).vTm;
        d.g.b.p.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (d.g.b.p.i(((anq)localObject1).username, paramString)) {
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
        localObject1 = ((anq)localObject1).fXm;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      ae.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        ae.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(204421);
      return localLinkedList;
    }
    
    public static List<FinderItem> dx(String paramString, int paramInt)
    {
      AppMethodBeat.i(204425);
      d.g.b.p.h(paramString, "username");
      FQ(paramInt);
      paramString = (List)dw(paramString, paramInt);
      AppMethodBeat.o(204425);
      return paramString;
    }
    
    public static void h(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167077);
      d.g.b.p.h(paramFinderItem, "item");
      if (k.cLK().FS(0).kIG)
      {
        Object localObject = k.cLK().FS(0).sKx.vTm;
        d.g.b.p.g(localObject, "cache[ConstantsFinder.Lo…MELINE_ALL].page.infoList");
        localObject = (anq)j.F((List)localObject, 0);
        if (localObject != null)
        {
          paramFinderItem = new n(2, paramFinderItem.getLocalId(), paramFinderItem.getFeedObject(), 0);
          ((anq)localObject).fXm.addFirst(paramFinderItem.sLi);
          AppMethodBeat.o(167077);
          return;
        }
      }
      AppMethodBeat.o(167077);
    }
    
    public static void xv(long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = k.cLL();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.sLb;
        FQ(k);
        localObject = k.cLK().FS(k).sKx.vTm;
        if (localObject != null)
        {
          localObject = (anq)j.F((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((anq)localObject).fXm;
            if (localObject != null)
            {
              h localh = h.sKR;
              if (h.b(paramLong, (LinkedList)localObject))
              {
                localObject = k.sLb;
                a(k.cLK().FS(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
    static final class a
      extends q
      implements d.g.a.b<anq, Boolean>
    {
      a(String paramString, anq paramanq, LinkedList paramLinkedList)
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