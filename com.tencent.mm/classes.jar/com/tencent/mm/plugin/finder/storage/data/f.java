package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.v.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class f
{
  private static boolean DEBUG = false;
  private static final j KXw;
  private static j KXx;
  private static final int MAX_CACHE_SIZE = 20;
  private static final Integer[] qKs;
  private static final Integer[] qKt;
  public static final a qKv;
  
  static
  {
    AppMethodBeat.i(167083);
    qKv = new a((byte)0);
    MAX_CACHE_SIZE = 20;
    qKs = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    qKt = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10) };
    j localj = new j(new g[] { new g(0, "main_v2", new aim(), 0), new g(1, "profile_v2", new aim(), 0), new g(2, "like_v2", new aim(), 0), new g(3, "others_v2", new aim(), 0), new g(4, "prefetch_v2", new aim(), 0), new g(5, "friend_tab_v2", new aim(), 0), new g(6, "lbs_tab_v2", new aim(), 0), new g(7, "follow_v2", new aim(), 0), new g(8, "machine_v2", new aim(), 0), new g(9, "lbs_tab_section_v2", new aim(), 0), new g(10, "fav_v2", new aim(), 0) });
    KXw = localj;
    KXx = localj;
    AppMethodBeat.o(167083);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "selfArray", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "cacheToList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToSectionList", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "clearAll", "deletePageData", "svrId", "", "svrIds", "", "deletePageDataByLocalId", "localId", "fileToCache", "getLast", "typeFlag", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "plugin-finder_release"})
  public static final class a
  {
    public static List<FinderItem> CV(int paramInt)
    {
      AppMethodBeat.i(167081);
      ahz(paramInt);
      List localList = (List)cX("", paramInt);
      AppMethodBeat.o(167081);
      return localList;
    }
    
    public static void a(int paramInt, String paramString, final LinkedList<aih> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      k.h(paramString, "username");
      k.h(paramLinkedList, "list");
      final ais localais;
      g localg;
      aim localaim;
      if (d.a.e.contains(f.cqH(), Integer.valueOf(paramInt))) {
        try
        {
          localais = new ais();
          localais.fyl = paramLinkedList;
          localais.username = paramString;
          localg = f.fVf().ahA(paramInt);
          localaim = localg.KXo;
          Object localObject = localaim.tvP;
          k.g(localObject, "it.infoList");
          c.a((LinkedList)localObject, (d.g.a.b)new b(paramString, localais, paramLinkedList));
          for (;;)
          {
            paramInt = localaim.tvP.size();
            localObject = f.qKv;
            if (paramInt <= f.cqF()) {
              break;
            }
            localObject = localaim.tvP;
            LinkedList localLinkedList = localaim.tvP;
            k.g(localLinkedList, "it.infoList");
            ((LinkedList)localObject).remove(d.a.j.C((List)localLinkedList, 0));
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
      localaim.tvP.add(localais);
      ad.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + localaim.tvP.size());
      a(localg);
      AppMethodBeat.o(167073);
    }
    
    public static void a(g paramg)
    {
      AppMethodBeat.i(199071);
      try
      {
        byte[] arrayOfByte = paramg.KXo.toByteArray();
        com.tencent.mm.ad.b localb = new com.tencent.mm.ad.b("cache2File");
        Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
        localObject = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.finder.utils.i.Dh(2));
        if (!((com.tencent.mm.vfs.e)localObject).isDirectory()) {
          ((com.tencent.mm.vfs.e)localObject).delete();
        }
        if (!((com.tencent.mm.vfs.e)localObject).exists()) {
          ((com.tencent.mm.vfs.e)localObject).mkdirs();
        }
        localObject = ((com.tencent.mm.vfs.e)localObject).getAbsolutePath() + '/' + paramg.name + ".ext";
        com.tencent.mm.vfs.i.B((String)localObject, arrayOfByte);
        ad.i("Finder.FinderPage", "cache2File " + paramg.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localb);
        AppMethodBeat.o(199071);
        return;
      }
      catch (Exception paramg)
      {
        ad.printErrStackTrace("Finder.FinderPage", (Throwable)paramg, "", new Object[0]);
        AppMethodBeat.o(199071);
      }
    }
    
    public static LinkedList<dzm> aVz(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(199073);
      Object localObject1 = f.fVf().ahA(9).KXo;
      LinkedList localLinkedList = new LinkedList();
      ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage();
      if (f.ahp()) {
        ad.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!k.g(paramString, u.aqO()))) {
          break label186;
        }
        localObject1 = ((aim)localObject1).tvP;
        k.g(localObject1, "cache.infoList");
        localObject1 = d.a.j.C((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (ais)localObject1;
        if (localObject1 == null) {
          break label249;
        }
        localObject3 = ((ais)localObject1).fyl;
        if (localObject3 == null) {
          break label249;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          aih localaih = (aih)((Iterator)localObject3).next();
          if (localaih.Lxr != null) {
            localLinkedList.add(localaih.Lxr);
          }
        }
        i = 0;
        break;
        label186:
        localObject1 = ((aim)localObject1).tvP;
        k.g(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (k.g(((ais)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
      }
      label249:
      Object localObject3 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      paramString = localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((ais)localObject1).fyl;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      ad.i("Finder.FinderPage", paramString);
      if (f.ahp()) {
        ad.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(199073);
      return localLinkedList;
    }
    
    private static g ahy(int paramInt)
    {
      g localg = null;
      AppMethodBeat.i(199072);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject3 = com.tencent.mm.plugin.finder.utils.i.qTa;
          str = com.tencent.mm.plugin.finder.utils.i.Dh(2) + '/' + f.fVf().ahA(paramInt).name + ".ext";
          localb = new com.tencent.mm.ad.b("file2Cache");
          arrayOfByte = com.tencent.mm.vfs.i.aR(str, 0, -1);
          localObject1 = (a)new aim();
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
          ((a)localObject1).parseFrom(arrayOfByte);
          localObject3 = (aim)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          localObject1 = localg;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
          ad.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localb);
          localg = f.fVf().ahA(paramInt);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new aim();
          }
          localg.a((aim)localObject1);
          f.fVf().ahA(paramInt).jJR = true;
          localObject1 = f.fVf().ahA(paramInt);
          AppMethodBeat.o(199072);
          return localObject1;
        }
        catch (Exception localException1)
        {
          ad.l("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
      }
    }
    
    public static g ahz(int paramInt)
    {
      AppMethodBeat.i(199074);
      if (f.fVf().ahA(paramInt).jJR)
      {
        localg = f.fVf().ahA(paramInt);
        AppMethodBeat.o(199074);
        return localg;
      }
      f.fVf().a(paramInt, ahy(paramInt));
      g localg = f.fVf().ahA(paramInt);
      AppMethodBeat.o(199074);
      return localg;
    }
    
    public static void b(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = f.cqI();
      int k = arrayOfInteger.length;
      int i = 0;
      if (i < k)
      {
        int m = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = f.qKv;
        ahz(m);
        localObject = f.fVf().ahA(m).KXo.tvP;
        label111:
        int j;
        if (localObject != null)
        {
          localObject = (ais)d.a.j.C((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((ais)localObject).fyl;
            if (localObject != null)
            {
              Iterator localIterator = ((Iterable)localObject).iterator();
              if (!localIterator.hasNext()) {
                break label235;
              }
              localObject = localIterator.next();
              aih localaih = (aih)localObject;
              if ((localaih.type != 2) || (localaih.DkX.id != paramLong)) {
                break label229;
              }
              j = 1;
              label162:
              if (j == 0) {
                break label233;
              }
            }
          }
        }
        for (;;)
        {
          localObject = (aih)localObject;
          if (localObject != null)
          {
            ((aih)localObject).type = 1;
            ((aih)localObject).DkX.id = paramFinderItem.field_id;
            ((aih)localObject).DkX = paramFinderItem.getFeedObject();
            localObject = f.qKv;
            a(f.fVf().ahA(m));
          }
          i += 1;
          break;
          label229:
          j = 0;
          break label162;
          label233:
          break label111;
          label235:
          localObject = null;
        }
      }
      AppMethodBeat.o(167078);
    }
    
    public static LinkedList<FinderItem> cX(String paramString, int paramInt)
    {
      AppMethodBeat.i(167076);
      Object localObject1 = f.fVf().ahA(paramInt).KXo;
      LinkedList localLinkedList = new LinkedList();
      com.tencent.mm.plugin.finder.storage.e locale = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage();
      if (f.ahp()) {
        ad.v("Finder.FinderPage", "-----file2Cache START------");
      }
      label103:
      ais localais;
      label135:
      Object localObject2;
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!k.g(paramString, u.aqO()))) {
          break label308;
        }
        localObject1 = ((aim)localObject1).tvP;
        k.g(localObject1, "cache.infoList");
        localObject1 = d.a.j.C((List)localObject1, 0);
        localais = (ais)localObject1;
        if (localais == null) {
          break label412;
        }
        localObject1 = localais.fyl;
        if (localObject1 == null) {
          break label412;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (aih)localIterator.next();
        } while (((aih)localObject1).DkX == null);
        switch (((aih)localObject1).type)
        {
        default: 
          localObject2 = FinderItem.qJU;
          localObject2 = ((aih)localObject1).DkX;
          k.g(localObject2, "it.`object`");
          localObject2 = FinderItem.a.a((FinderObject)localObject2, ((aih)localObject1).DkY);
          localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
          localObject1 = ((FinderItem)localObject2).getFeedObject().contact.username;
          k.g(localObject1, "item.feedObject.contact.username");
          if (com.tencent.mm.plugin.finder.api.b.a.YL((String)localObject1) == null)
          {
            localObject1 = com.tencent.mm.plugin.finder.api.b.qnX;
            localObject1 = ((FinderItem)localObject2).getFeedObject().contact;
            k.g(localObject1, "item.feedObject.contact");
            com.tencent.mm.plugin.finder.api.b.a.b((FinderContact)localObject1);
          }
          localObject1 = b.qKl;
          localObject1 = localObject2;
          if (b.a.qC(((FinderItem)localObject2).field_id) == null)
          {
            localObject1 = b.qKl;
            b.a.e((FinderItem)localObject2);
            localObject1 = localObject2;
          }
          break;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label135;
        }
        localLinkedList.add(localObject1);
        break label135;
        paramInt = 0;
        break;
        label308:
        localObject1 = ((aim)localObject1).tvP;
        k.g(localObject1, "cache.infoList");
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            if (k.g(((ais)localObject1).username, paramString)) {
              break;
            }
          }
        }
        localObject1 = null;
        break label103;
        localObject1 = locale.qy(((aih)localObject1).id);
        if (localObject1 != null)
        {
          if (((FinderItem)localObject1).getLocalId() != 0L) {}
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label405;
            }
            localObject1 = null;
            break;
          }
        }
        else
        {
          label405:
          localObject1 = null;
        }
      }
      label412:
      localObject1 = new StringBuilder("read cache username:").append(paramString).append(" size:");
      if (localais != null)
      {
        paramString = localais.fyl;
        if (paramString == null) {}
      }
      for (paramString = Integer.valueOf(paramString.size());; paramString = null)
      {
        ad.i("Finder.FinderPage", paramString);
        if (f.ahp()) {
          ad.v("Finder.FinderPage", "-----file2Cache END------");
        }
        AppMethodBeat.o(167076);
        return localLinkedList;
      }
    }
    
    public static void clearAll()
    {
      AppMethodBeat.i(167082);
      Object localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      localObject = com.tencent.mm.plugin.finder.utils.i.fWe();
      if (com.tencent.mm.vfs.i.eK((String)localObject))
      {
        com.tencent.mm.vfs.i.deleteDir((String)localObject);
        com.tencent.mm.vfs.i.aMF((String)localObject);
        ad.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + com.tencent.mm.vfs.i.eK((String)localObject));
      }
      f.a(f.fVg());
      f.fVf().reset();
      ad.i("Finder.FinderPage", "clearAll " + f.fVf() + ' ' + f.fVf().KXy.length);
      AppMethodBeat.o(167082);
    }
    
    public static void f(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167077);
      k.h(paramFinderItem, "item");
      if (f.fVf().ahA(0).jJR)
      {
        Object localObject = f.fVf().ahA(0).KXo.tvP;
        k.g(localObject, "cache[ConstantsFinder.Lo…MELINE_ALL].page.infoList");
        localObject = (ais)d.a.j.C((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((ais)localObject).fyl;
          aih localaih = new aih();
          localaih.DkY = 0;
          localaih.id = paramFinderItem.getLocalId();
          localaih.DkX = paramFinderItem.getFeedObject();
          localaih.type = 2;
          ((LinkedList)localObject).addFirst(localaih);
          AppMethodBeat.o(167077);
          return;
        }
      }
      AppMethodBeat.o(167077);
    }
    
    public static void qE(final long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = f.cqI();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject1 = f.qKv;
        ahz(k);
        localObject1 = new v.a();
        ((v.a)localObject1).Jhs = false;
        Object localObject2 = f.fVf().ahA(k).KXo.tvP;
        if (localObject2 != null)
        {
          localObject2 = (ais)d.a.j.C((List)localObject2, 0);
          if (localObject2 != null)
          {
            localObject2 = ((ais)localObject2).fyl;
            if (localObject2 != null) {
              c.a((LinkedList)localObject2, (d.g.a.b)new e((v.a)localObject1, paramLong));
            }
          }
        }
        if (((v.a)localObject1).Jhs)
        {
          localObject1 = f.qKv;
          a(f.fVf().ahA(k));
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
    static final class b
      extends d.g.b.l
      implements d.g.a.b<ais, Boolean>
    {
      b(String paramString, ais paramais, LinkedList paramLinkedList)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageData$1$1"})
    public static final class c
      extends d.g.b.l
      implements d.g.a.b<aih, Boolean>
    {
      public c(v.a parama, HashSet paramHashSet)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageData$2$1"})
    public static final class d
      extends d.g.b.l
      implements d.g.a.b<aih, Boolean>
    {
      public d(v.a parama, long paramLong)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageDataByLocalId$1$1"})
    static final class e
      extends d.g.b.l
      implements d.g.a.b<aih, Boolean>
    {
      e(v.a parama, long paramLong)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.f
 * JD-Core Version:    0.7.0.1
 */