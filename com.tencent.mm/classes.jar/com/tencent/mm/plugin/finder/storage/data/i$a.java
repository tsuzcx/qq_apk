package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.f;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "selfArray", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "cacheToList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToSectionList", "Lcom/tencent/mm/protocal/protobuf/FinderNearbySection;", "clearAll", "deletePageData", "svrId", "", "svrIds", "", "deletePageDataByLocalId", "localId", "fileToCache", "getLast", "typeFlag", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "plugin-finder_release"})
public final class i$a
{
  private static a Ej(int paramInt)
  {
    a locala = null;
    AppMethodBeat.i(203040);
    for (;;)
    {
      try
      {
        localObject1 = new StringBuilder();
        localObject3 = n.rPN;
        str = n.EA(2) + '/' + i.cBh().Em(paramInt).name + ".ext";
        localb = new com.tencent.mm.ac.b("file2Cache");
        arrayOfByte = com.tencent.mm.vfs.i.aU(str, 0, -1);
        localObject1 = (com.tencent.mm.bw.a)new ajy();
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
        ac.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
        continue;
      }
      try
      {
        ((com.tencent.mm.bw.a)localObject1).parseFrom(arrayOfByte);
        localObject3 = (ajy)localObject1;
        localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
        localObject1 = locala;
        if (arrayOfByte != null) {
          localObject1 = Integer.valueOf(arrayOfByte.length);
        }
        ac.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localb);
        locala = i.cBh().Em(paramInt);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ajy();
        }
        locala.a((ajy)localObject1);
        i.cBh().Em(paramInt).kkr = true;
        localObject1 = i.cBh().Em(paramInt);
        AppMethodBeat.o(203040);
        return localObject1;
      }
      catch (Exception localException1)
      {
        ac.l("safeParser", "", new Object[] { localException1 });
        localObject2 = null;
      }
    }
  }
  
  public static a Ek(int paramInt)
  {
    AppMethodBeat.i(203042);
    if (i.cBh().Em(paramInt).kkr)
    {
      locala = i.cBh().Em(paramInt);
      AppMethodBeat.o(203042);
      return locala;
    }
    i.cBh().a(paramInt, Ej(paramInt));
    a locala = i.cBh().Em(paramInt);
    AppMethodBeat.o(203042);
    return locala;
  }
  
  public static List<FinderItem> El(int paramInt)
  {
    AppMethodBeat.i(167081);
    Ek(paramInt);
    List localList = (List)dd("", paramInt);
    AppMethodBeat.o(167081);
    return localList;
  }
  
  public static void a(int paramInt, String paramString, LinkedList<ajr> paramLinkedList)
  {
    AppMethodBeat.i(167073);
    k.h(paramString, "username");
    k.h(paramLinkedList, "list");
    ake localake;
    a locala;
    ajy localajy;
    if (d.a.e.contains(i.cBg(), Integer.valueOf(paramInt))) {
      try
      {
        localake = new ake();
        localake.fBS = paramLinkedList;
        localake.username = paramString;
        locala = i.cBh().Em(paramInt);
        localajy = locala.rEA;
        Object localObject = localajy.uEi;
        k.g(localObject, "it.infoList");
        c.a((LinkedList)localObject, (d.g.a.b)new i.a.a(paramString, localake, paramLinkedList));
        for (;;)
        {
          paramInt = localajy.uEi.size();
          localObject = i.rEV;
          if (paramInt <= i.cBf()) {
            break;
          }
          localObject = localajy.uEi;
          LinkedList localLinkedList = localajy.uEi;
          k.g(localLinkedList, "it.infoList");
          ((LinkedList)localObject).remove(d.a.j.C((List)localLinkedList, 0));
        }
        AppMethodBeat.o(167073);
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("Finder.FinderPage", (Throwable)paramString, "", new Object[0]);
      }
    } else {
      return;
    }
    localajy.uEi.add(localake);
    ac.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + localajy.uEi.size());
    a(locala);
    AppMethodBeat.o(167073);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(203039);
    try
    {
      byte[] arrayOfByte = parama.rEA.toByteArray();
      com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("cache2File");
      Object localObject = n.rPN;
      localObject = new com.tencent.mm.vfs.e(n.EA(2));
      if (!((com.tencent.mm.vfs.e)localObject).isDirectory()) {
        ((com.tencent.mm.vfs.e)localObject).delete();
      }
      if (!((com.tencent.mm.vfs.e)localObject).exists()) {
        ((com.tencent.mm.vfs.e)localObject).mkdirs();
      }
      localObject = ((com.tencent.mm.vfs.e)localObject).getAbsolutePath() + '/' + parama.name + ".ext";
      com.tencent.mm.vfs.i.B((String)localObject, arrayOfByte);
      ac.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localb);
      AppMethodBeat.o(203039);
      return;
    }
    catch (Exception parama)
    {
      ac.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
      AppMethodBeat.o(203039);
    }
  }
  
  public static LinkedList<aml> aeg(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(203041);
    Object localObject1 = i.cBh().Em(9).rEA;
    LinkedList localLinkedList = new LinkedList();
    ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
    if (i.aor()) {
      ac.v("Finder.FinderPage", "-----file2Cache START------");
    }
    int i;
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if ((i == 0) && (!k.g(paramString, u.axE()))) {
        break label186;
      }
      localObject1 = ((ajy)localObject1).uEi;
      k.g(localObject1, "cache.infoList");
      localObject1 = d.a.j.C((List)localObject1, 0);
    }
    for (;;)
    {
      localObject1 = (ake)localObject1;
      if (localObject1 == null) {
        break label249;
      }
      localObject3 = ((ake)localObject1).fBS;
      if (localObject3 == null) {
        break label249;
      }
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ajr localajr = (ajr)((Iterator)localObject3).next();
        if (localajr.EEr != null) {
          localLinkedList.add(localajr.EEr);
        }
      }
      i = 0;
      break;
      label186:
      localObject1 = ((ajy)localObject1).uEi;
      k.g(localObject1, "cache.infoList");
      localObject3 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          if (k.g(((ake)localObject1).username, paramString)) {
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
      localObject1 = ((ake)localObject1).fBS;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = Integer.valueOf(((LinkedList)localObject1).size());
      }
    }
    ac.i("Finder.FinderPage", paramString);
    if (i.aor()) {
      ac.v("Finder.FinderPage", "-----file2Cache END------");
    }
    AppMethodBeat.o(203041);
    return localLinkedList;
  }
  
  public static void b(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167078);
    Integer[] arrayOfInteger = i.cBi();
    int k = arrayOfInteger.length;
    int i = 0;
    if (i < k)
    {
      int m = ((Number)arrayOfInteger[i]).intValue();
      Object localObject = i.rEV;
      Ek(m);
      localObject = i.cBh().Em(m).rEA.uEi;
      label111:
      int j;
      if (localObject != null)
      {
        localObject = (ake)d.a.j.C((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((ake)localObject).fBS;
          if (localObject != null)
          {
            Iterator localIterator = ((Iterable)localObject).iterator();
            if (!localIterator.hasNext()) {
              break label235;
            }
            localObject = localIterator.next();
            ajr localajr = (ajr)localObject;
            if ((localajr.type != 2) || (localajr.EEp.id != paramLong)) {
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
        localObject = (ajr)localObject;
        if (localObject != null)
        {
          ((ajr)localObject).type = 1;
          ((ajr)localObject).EEp.id = paramFinderItem.field_id;
          ((ajr)localObject).EEp = paramFinderItem.getFeedObject();
          localObject = i.rEV;
          a(i.cBh().Em(m));
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
  
  public static void clearAll()
  {
    AppMethodBeat.i(167082);
    Object localObject = n.rPN;
    localObject = n.cDj();
    if (com.tencent.mm.vfs.i.eA((String)localObject))
    {
      com.tencent.mm.vfs.i.deleteDir((String)localObject);
      com.tencent.mm.vfs.i.aSh((String)localObject);
      ac.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + com.tencent.mm.vfs.i.eA((String)localObject));
    }
    i.a(i.cBj());
    i.cBh().reset();
    ac.i("Finder.FinderPage", "clearAll " + i.cBh() + ' ' + i.cBh().rFd.length);
    AppMethodBeat.o(167082);
  }
  
  public static LinkedList<FinderItem> dd(String paramString, int paramInt)
  {
    AppMethodBeat.i(167076);
    Object localObject1 = i.cBh().Em(paramInt).rEA;
    LinkedList localLinkedList = new LinkedList();
    f localf = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
    if (i.aor()) {
      ac.v("Finder.FinderPage", "-----file2Cache START------");
    }
    label103:
    ake localake;
    label135:
    Object localObject2;
    if (((CharSequence)paramString).length() == 0)
    {
      paramInt = 1;
      if ((paramInt == 0) && (!k.g(paramString, u.axE()))) {
        break label308;
      }
      localObject1 = ((ajy)localObject1).uEi;
      k.g(localObject1, "cache.infoList");
      localObject1 = d.a.j.C((List)localObject1, 0);
      localake = (ake)localObject1;
      if (localake == null) {
        break label412;
      }
      localObject1 = localake.fBS;
      if (localObject1 == null) {
        break label412;
      }
      Iterator localIterator = ((Iterable)localObject1).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (ajr)localIterator.next();
      } while (((ajr)localObject1).EEp == null);
      switch (((ajr)localObject1).type)
      {
      default: 
        localObject2 = FinderItem.rDA;
        localObject2 = ((ajr)localObject1).EEp;
        k.g(localObject2, "it.`object`");
        localObject2 = FinderItem.a.a((FinderObject)localObject2, ((ajr)localObject1).EEq);
        localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
        localObject1 = ((FinderItem)localObject2).getFeedObject().contact.username;
        k.g(localObject1, "item.feedObject.contact.username");
        if (b.a.adh((String)localObject1) == null)
        {
          localObject1 = com.tencent.mm.plugin.finder.api.b.qWt;
          localObject1 = ((FinderItem)localObject2).getFeedObject().contact;
          k.g(localObject1, "item.feedObject.contact");
          b.a.b((FinderContact)localObject1);
        }
        localObject1 = d.rEF;
        localObject1 = localObject2;
        if (d.a.uS(((FinderItem)localObject2).field_id) == null)
        {
          localObject1 = d.rEF;
          d.a.f((FinderItem)localObject2);
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
      localObject1 = ((ajy)localObject1).uEi;
      k.g(localObject1, "cache.infoList");
      localObject2 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          if (k.g(((ake)localObject1).username, paramString)) {
            break;
          }
        }
      }
      localObject1 = null;
      break label103;
      localObject1 = localf.uO(((ajr)localObject1).id);
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
    if (localake != null)
    {
      paramString = localake.fBS;
      if (paramString == null) {}
    }
    for (paramString = Integer.valueOf(paramString.size());; paramString = null)
    {
      ac.i("Finder.FinderPage", paramString);
      if (i.aor()) {
        ac.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(167076);
      return localLinkedList;
    }
  }
  
  public static void g(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(167077);
    k.h(paramFinderItem, "item");
    if (i.cBh().Em(0).kkr)
    {
      Object localObject = i.cBh().Em(0).rEA.uEi;
      k.g(localObject, "cache[ConstantsFinder.Lo…MELINE_ALL].page.infoList");
      localObject = (ake)d.a.j.C((List)localObject, 0);
      if (localObject != null)
      {
        localObject = ((ake)localObject).fBS;
        ajr localajr = new ajr();
        localajr.EEq = 0;
        localajr.id = paramFinderItem.getLocalId();
        localajr.EEp = paramFinderItem.getFeedObject();
        localajr.type = 2;
        ((LinkedList)localObject).addFirst(localajr);
        AppMethodBeat.o(167077);
        return;
      }
    }
    AppMethodBeat.o(167077);
  }
  
  public static void vc(final long paramLong)
  {
    AppMethodBeat.i(167079);
    Integer[] arrayOfInteger = i.cBi();
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)arrayOfInteger[i]).intValue();
      Object localObject1 = i.rEV;
      Ek(k);
      localObject1 = new v.a();
      ((v.a)localObject1).KUL = false;
      Object localObject2 = i.cBh().Em(k).rEA.uEi;
      if (localObject2 != null)
      {
        localObject2 = (ake)d.a.j.C((List)localObject2, 0);
        if (localObject2 != null)
        {
          localObject2 = ((ake)localObject2).fBS;
          if (localObject2 != null) {
            c.a((LinkedList)localObject2, (d.g.a.b)new d((v.a)localObject1, paramLong));
          }
        }
      }
      if (((v.a)localObject1).KUL)
      {
        localObject1 = i.rEV;
        a(i.cBh().Em(k));
      }
      i += 1;
    }
    AppMethodBeat.o(167079);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageData$2$1"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.b<ajr, Boolean>
  {
    public c(v.a parama, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$deletePageDataByLocalId$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<ajr, Boolean>
  {
    d(v.a parama, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i.a
 * JD-Core Version:    0.7.0.1
 */