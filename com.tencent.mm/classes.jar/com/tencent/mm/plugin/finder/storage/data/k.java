package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage;", "", "()V", "Companion", "plugin-finder_release"})
public final class k
{
  private static final Integer[] Ano;
  private static final Integer[] Anp;
  private static final Integer[] Anq;
  private static final p Ans;
  private static p Ant;
  public static final a Anu;
  private static boolean DEBUG = false;
  private static final int MAX_CACHE_SIZE = 20;
  
  static
  {
    AppMethodBeat.i(167083);
    Anu = new a((byte)0);
    MAX_CACHE_SIZE = 20;
    Ano = new Integer[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(17), Integer.valueOf(18) };
    Anp = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(9), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(10), Integer.valueOf(17) };
    Anq = new Integer[] { Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13) };
    p localp = new p(new a[] { new a(0, "main_v3", new asx(), 0), new a(1, "profile_v3", new asx(), 0), new a(2, "like_v3", new asx(), 0), new a(3, "others_v3", new asx(), 0), new a(4, "prefetch_v3", new asx(), 0), new a(5, "friend_tab_v3", new asx(), 0), new a(6, "lbs_tab_v3", new asx(), 0), new a(7, "follow_v3", new asx(), 0), new a(8, "machine_v3", new asx(), 0), new a(9, "lbs_tab_section_v3", new asx(), 0), new a(10, "fav_v3", new asx(), 0), new a(11, "mega_video_like_v3", new asx(), 0), new a(12, "mega_video_fav_v3", new asx(), 0), new a(13, "mega_video_profile_v3", new asx(), 0), new a(14, "profile_at_feed_v3", new asx(), 0), new a(15, "nearby_live_v3", new asx(), 0), new a(16, "nearby_live_more_v3", new asx(), 0), new a(17, "music_v3", new asx(), 0), new a(18, "manage_at_feed_v3", new asx(), 0) });
    Ans = localp;
    Ant = localp;
    AppMethodBeat.o(167083);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderPage$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FILE_VERSION", "", "MAX_CACHE_SIZE", "", "getMAX_CACHE_SIZE", "()I", "TAG", "cache", "Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "defaultCache", "legalArray", "", "[Ljava/lang/Integer;", "megaVideoArray", "selfArray", "cacheLongTime", "fpPage", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "cacheToFile", "", "page", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "type", "username", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "cacheToFinderItemList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "cacheToRVFeedList", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "cacheToSectionList", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "clearAll", "deleteData", "typeFlag", "filter", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isFlush", "deleteMegaVideoPageData", "id", "", "pageName", "deletePageData", "svrId", "svrIds", "", "deletePageDataByLocalId", "localId", "deletePageDataByName", "userNames", "fileToCache", "filterLiveItem", "prefix", "getFinderFpList", "cachePage", "getLast", "getLastFinderItem", "getLastSection", "insertLocalIntoCache", "item", "readCache", "update", "updateLocalIntoCache", "updatePageData", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
  public static final class a
  {
    public static void MP(long paramLong)
    {
      AppMethodBeat.i(289562);
      Integer[] arrayOfInteger = k.dZx();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        a locala = k.Anu;
        S(paramLong, k);
        i += 1;
      }
      AppMethodBeat.o(289562);
    }
    
    public static void MQ(long paramLong)
    {
      AppMethodBeat.i(167079);
      Integer[] arrayOfInteger = k.dZw();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.Anu;
        Qp(k);
        localObject = k.dZv().Qq(k).AmO.ESJ;
        if (localObject != null)
        {
          localObject = (ath)j.M((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((ath)localObject).jmy;
            if (localObject != null)
            {
              h localh = h.Ang;
              if (h.b(paramLong, (LinkedList)localObject))
              {
                localObject = k.Anu;
                a(k.dZv().Qq(k));
              }
            }
          }
        }
        i += 1;
      }
      AppMethodBeat.o(167079);
    }
    
    private static a Qo(int paramInt)
    {
      a locala = null;
      AppMethodBeat.i(289552);
      for (;;)
      {
        try
        {
          localObject1 = new StringBuilder();
          localObject3 = aj.AGc;
          str = aj.QO(2) + '/' + k.dZv().Qq(paramInt).name + ".ext";
          localc = new com.tencent.mm.ae.c("file2Cache");
          arrayOfByte = u.aY(str, 0, -1);
          localObject1 = (com.tencent.mm.cd.a)new asx();
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject3;
          String str;
          com.tencent.mm.ae.c localc;
          byte[] arrayOfByte;
          StringBuilder localStringBuilder;
          Object localObject2;
          Log.printErrStackTrace("Finder.FinderPage", (Throwable)localException2, "", new Object[0]);
          continue;
        }
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom(arrayOfByte);
          localObject3 = (asx)localObject1;
          localStringBuilder = new StringBuilder("file2Cache ").append(paramInt).append("  ");
          localObject1 = locala;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
          Log.i("Finder.FinderPage", localObject1 + ' ' + str + ' ' + localc);
          locala = k.dZv().Qq(paramInt);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = new asx();
          }
          locala.a((asx)localObject1);
          k.dZv().Qq(paramInt).oJz = true;
          localObject1 = k.dZv().Qq(paramInt);
          AppMethodBeat.o(289552);
          return localObject1;
        }
        catch (Exception localException1)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
          localObject2 = null;
        }
      }
    }
    
    public static a Qp(int paramInt)
    {
      AppMethodBeat.i(289563);
      if (k.dZv().Qq(paramInt).oJz)
      {
        locala = k.dZv().Qq(paramInt);
        AppMethodBeat.o(289563);
        return locala;
      }
      k.dZv().a(paramInt, Qo(paramInt));
      a locala = k.dZv().Qq(paramInt);
      AppMethodBeat.o(289563);
      return locala;
    }
    
    public static void R(long paramLong, int paramInt)
    {
      AppMethodBeat.i(289557);
      Qp(paramInt);
      Object localObject = k.dZv().Qq(paramInt).AmO.ESJ;
      if (localObject != null)
      {
        localObject = (ath)j.M((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((ath)localObject).jmy;
          if (localObject != null)
          {
            h localh = h.Ang;
            if (h.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.Anu;
              a(k.dZv().Qq(paramInt));
            }
            AppMethodBeat.o(289557);
            return;
          }
        }
      }
      AppMethodBeat.o(289557);
    }
    
    public static void S(long paramLong, int paramInt)
    {
      AppMethodBeat.i(289561);
      Qp(paramInt);
      Object localObject = k.dZv().Qq(paramInt).AmO.ESJ;
      if (localObject != null)
      {
        localObject = (ath)j.M((List)localObject, 0);
        if (localObject != null)
        {
          localObject = ((ath)localObject).jmy;
          if (localObject != null)
          {
            o localo = o.Anz;
            if (o.a(paramLong, (LinkedList)localObject))
            {
              localObject = k.Anu;
              a(k.dZv().Qq(paramInt));
            }
            AppMethodBeat.o(289561);
            return;
          }
        }
      }
      AppMethodBeat.o(289561);
    }
    
    public static ath a(a parama, String paramString)
    {
      AppMethodBeat.i(289560);
      int i;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      }
      while ((i != 0) || (kotlin.g.b.p.h(paramString, z.bdh())))
      {
        if (parama != null)
        {
          parama = parama.AmO;
          if (parama != null)
          {
            parama = parama.ESJ;
            if (parama != null)
            {
              parama = (ath)j.M((List)parama, 0);
              AppMethodBeat.o(289560);
              return parama;
              i = 0;
              continue;
            }
          }
        }
        AppMethodBeat.o(289560);
        return null;
      }
      if (parama != null)
      {
        parama = parama.AmO;
        if (parama != null)
        {
          parama = parama.ESJ;
          if (parama != null)
          {
            Iterator localIterator = ((Iterable)parama).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              parama = localIterator.next();
            } while (!kotlin.g.b.p.h(((ath)parama).username, paramString));
            for (;;)
            {
              parama = (ath)parama;
              AppMethodBeat.o(289560);
              return parama;
              parama = null;
            }
          }
        }
      }
      AppMethodBeat.o(289560);
      return null;
    }
    
    public static void a(int paramInt, String paramString, final LinkedList<r> paramLinkedList)
    {
      AppMethodBeat.i(167073);
      kotlin.g.b.p.k(paramString, "username");
      kotlin.g.b.p.k(paramLinkedList, "list");
      final ath localath;
      if (e.contains(k.dZu(), Integer.valueOf(paramInt))) {
        try
        {
          localath = new ath();
          localObject1 = new LinkedList();
          localObject3 = (Iterable)paramLinkedList;
          localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).AnB);
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
      localath.jmy = ((LinkedList)localObject1);
      localath.username = paramString;
      localath.lLH = System.currentTimeMillis();
      Object localObject1 = k.dZv().Qq(paramInt);
      Object localObject2 = ((a)localObject1).AmO;
      Object localObject3 = ((asx)localObject2).ESJ;
      kotlin.g.b.p.j(localObject3, "it.infoList");
      d.a((LinkedList)localObject3, (kotlin.g.a.b)new a(paramString, localath, paramLinkedList));
      for (;;)
      {
        paramInt = ((asx)localObject2).ESJ.size();
        localObject3 = k.Anu;
        if (paramInt <= k.dZt()) {
          break;
        }
        localObject3 = ((asx)localObject2).ESJ;
        LinkedList localLinkedList = ((asx)localObject2).ESJ;
        kotlin.g.b.p.j(localLinkedList, "it.infoList");
        ((LinkedList)localObject3).remove(j.M((List)localLinkedList, 0));
      }
      ((asx)localObject2).ESJ.add(localath);
      Log.i("Finder.FinderPage", "total cache username " + paramString + " list " + paramLinkedList.size() + " totalCount: " + ((asx)localObject2).ESJ.size());
      a((a)localObject1);
      AppMethodBeat.o(167073);
    }
    
    public static void a(a parama)
    {
      AppMethodBeat.i(289550);
      try
      {
        byte[] arrayOfByte = parama.AmO.toByteArray();
        com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("cache2File");
        Object localObject = aj.AGc;
        localObject = new com.tencent.mm.vfs.q(aj.QO(2));
        if (!((com.tencent.mm.vfs.q)localObject).isDirectory()) {
          ((com.tencent.mm.vfs.q)localObject).cFq();
        }
        if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
          ((com.tencent.mm.vfs.q)localObject).ifL();
        }
        localObject = ((com.tencent.mm.vfs.q)localObject).bOF() + '/' + parama.name + ".ext";
        u.H((String)localObject, arrayOfByte);
        Log.i("Finder.FinderPage", "cache2File " + parama.name + ' ' + arrayOfByte.length + ' ' + (String)localObject + ' ' + localc);
        AppMethodBeat.o(289550);
        return;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("Finder.FinderPage", (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(289550);
      }
    }
    
    private static void a(String paramString, ath paramath)
    {
      AppMethodBeat.i(289567);
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
      if (paramath != null)
      {
        l1 = paramath.lLH;
        localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
        if (l2 - l1 <= ((Number)com.tencent.c.a.a.a.a.a.imv().aSr()).intValue() * 60000) {
          break label350;
        }
        i = 1;
        if (i == 0) {
          break label421;
        }
        if (paramath == null) {
          break label416;
        }
        localObject1 = paramath.jmy;
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
        asm localasm = (asm)localObject2;
        localObject1 = localasm.SFP;
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = ((FinderObject)localObject1).liveInfo;
        if (localObject1 == null) {
          break label355;
        }
        localObject1 = Long.valueOf(((bac)localObject1).liveId);
        if (localObject1 == null) {
          break label361;
        }
        i = 1;
        if (i != 0)
        {
          localStringBuilder = new StringBuilder().append(paramString).append(" filter live:");
          localObject1 = localasm.SFP;
          if (localObject1 == null) {
            break label366;
          }
          localObject1 = ((FinderObject)localObject1).liveInfo;
          if (localObject1 == null) {
            break label366;
          }
          localObject1 = Long.valueOf(((bac)localObject1).liveId);
          label223:
          localStringBuilder = localStringBuilder.append(localObject1).append(',');
          localObject1 = localasm.SFP;
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
          localObject1 = localasm.SFP;
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
      for (paramString = (List)localCollection; paramath != null; paramString = null)
      {
        paramath.jmy = new LinkedList((Collection)paramString);
        AppMethodBeat.o(289567);
        return;
      }
      label421:
      AppMethodBeat.o(289567);
    }
    
    public static LinkedList<com.tencent.mm.plugin.finder.model.c> aES(String paramString)
    {
      Object localObject2 = null;
      AppMethodBeat.i(289556);
      Object localObject1 = k.dZv().Qq(9).AmO;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      int i;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!kotlin.g.b.p.h(paramString, z.bdh()))) {
          break label201;
        }
        localObject1 = ((asx)localObject1).ESJ;
        kotlin.g.b.p.j(localObject1, "cache.infoList");
        localObject1 = j.M((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (ath)localObject1;
        if (localObject1 == null) {
          break label264;
        }
        localObject3 = ((ath)localObject1).jmy;
        if (localObject3 == null) {
          break label264;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (asm)((Iterator)localObject3).next();
          kotlin.g.b.p.j(localObject4, "it");
          localObject4 = new s((asm)localObject4);
          m localm = m.Any;
          localObject4 = m.b(((r)localObject4).AnB);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        i = 0;
        break;
        label201:
        localObject1 = ((asx)localObject1).ESJ;
        kotlin.g.b.p.j(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (kotlin.g.b.p.h(((ath)localObject1).username, paramString)) {
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
        localObject1 = ((ath)localObject1).jmy;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(289556);
      return localLinkedList;
    }
    
    public static void c(long paramLong, FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167078);
      Integer[] arrayOfInteger = k.dZw();
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject = k.Anu;
        Qp(k);
        localObject = k.dZv().Qq(k).AmO.ESJ;
        if (localObject != null)
        {
          localObject = (ath)j.M((List)localObject, 0);
          if (localObject != null)
          {
            localObject = ((ath)localObject).jmy;
            if (localObject != null)
            {
              h localh = h.Ang;
              if (h.a(paramLong, paramFinderItem, (LinkedList)localObject))
              {
                localObject = k.Anu;
                a(k.dZv().Qq(k));
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
      Object localObject = aj.AGc;
      localObject = aj.eea();
      if (u.agG((String)localObject))
      {
        u.deleteDir((String)localObject);
        u.bBD((String)localObject);
        Log.i("Finder.FinderPage", "del " + (String)localObject + " and ret " + u.agG((String)localObject));
      }
      k.a(k.dZy());
      k.dZv().reset();
      Log.i("Finder.FinderPage", "clearAll " + k.dZv() + ' ' + k.dZv().AnA.length);
      AppMethodBeat.o(167082);
    }
    
    public static void dZz()
    {
      AppMethodBeat.i(289558);
      k.dZv().Qq(1).AmO.ESJ.clear();
      AppMethodBeat.o(289558);
    }
    
    private static LinkedList<bu> eb(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(289553);
      Object localObject1 = k.dZv().Qq(paramInt).AmO;
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
          break label203;
        }
        localObject1 = ((asx)localObject1).ESJ;
        kotlin.g.b.p.j(localObject1, "cache.infoList");
        localObject1 = j.M((List)localObject1, 0);
        localObject3 = (ath)localObject1;
        a("cacheToRVFeedList", (ath)localObject3);
        if (localObject3 == null) {
          break label335;
        }
        localObject1 = ((ath)localObject3).jmy;
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
        localObject1 = (asm)localIterator.next();
        paramInt = ((asm)localObject1).dataType;
        Object localObject4 = h.Ang;
        if (paramInt == 0)
        {
          kotlin.g.b.p.j(localObject1, "it");
          localObject1 = (r)new q((asm)localObject1);
        }
        for (;;)
        {
          if (localObject1 == null) {
            break label333;
          }
          localObject1 = ((r)localObject1).dZA();
          if (localObject1 == null) {
            break label121;
          }
          localLinkedList.add(localObject1);
          break label121;
          paramInt = 0;
          break;
          localObject1 = ((asx)localObject1).ESJ;
          kotlin.g.b.p.j(localObject1, "cache.infoList");
          localObject3 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              localObject1 = ((Iterator)localObject3).next();
              if (kotlin.g.b.p.h(((ath)localObject1).username, paramString)) {
                break;
              }
            }
          }
          localObject1 = null;
          break label81;
          localObject4 = m.Any;
          if (paramInt == 1)
          {
            kotlin.g.b.p.j(localObject1, "it");
            localObject1 = (r)new s((asm)localObject1);
          }
          else
          {
            localObject4 = o.Anz;
            if (paramInt == 2)
            {
              kotlin.g.b.p.j(localObject1, "it");
              localObject1 = (r)new t((asm)localObject1);
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
        localObject3 = ((ath)localObject3).jmy;
        paramString = localObject2;
        if (localObject3 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject3).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(289553);
      return localLinkedList;
    }
    
    private static LinkedList<FinderItem> ec(String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(289555);
      Object localObject1 = k.dZv().Qq(paramInt).AmO;
      LinkedList localLinkedList = new LinkedList();
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache START------");
      }
      if (((CharSequence)paramString).length() == 0)
      {
        paramInt = 1;
        if ((paramInt == 0) && (!kotlin.g.b.p.h(paramString, z.bdh()))) {
          break label207;
        }
        localObject1 = ((asx)localObject1).ESJ;
        kotlin.g.b.p.j(localObject1, "cache.infoList");
        localObject1 = j.M((List)localObject1, 0);
      }
      for (;;)
      {
        localObject1 = (ath)localObject1;
        a("cacheToFinderItemList", (ath)localObject1);
        if (localObject1 == null) {
          break label270;
        }
        localObject3 = ((ath)localObject1).jmy;
        if (localObject3 == null) {
          break label270;
        }
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (asm)((Iterator)localObject3).next();
          kotlin.g.b.p.j(localObject4, "it");
          localObject4 = new q((asm)localObject4);
          h localh = h.Ang;
          localObject4 = h.a(((r)localObject4).AnB);
          if (localObject4 != null) {
            localLinkedList.add(localObject4);
          }
        }
        paramInt = 0;
        break;
        label207:
        localObject1 = ((asx)localObject1).ESJ;
        kotlin.g.b.p.j(localObject1, "cache.infoList");
        localObject3 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject1 = ((Iterator)localObject3).next();
            if (kotlin.g.b.p.h(((ath)localObject1).username, paramString)) {
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
        localObject1 = ((ath)localObject1).jmy;
        paramString = localObject2;
        if (localObject1 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject1).size());
        }
      }
      Log.i("Finder.FinderPage", paramString);
      if (k.access$getDEBUG$cp()) {
        Log.v("Finder.FinderPage", "-----file2Cache END------");
      }
      AppMethodBeat.o(289555);
      return localLinkedList;
    }
    
    public static void q(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167077);
      kotlin.g.b.p.k(paramFinderItem, "item");
      if (k.dZv().Qq(7).oJz)
      {
        Object localObject = k.dZv().Qq(7).AmO.ESJ;
        kotlin.g.b.p.j(localObject, "cache[ConstantsFinder.Lo…INE_FOLLOW].page.infoList");
        localObject = (ath)j.M((List)localObject, 0);
        if (localObject != null)
        {
          paramFinderItem = new q(2, paramFinderItem.getLocalId(), paramFinderItem.getFeedObject(), 7);
          ((ath)localObject).jmy.addFirst(paramFinderItem.AnB);
          AppMethodBeat.o(167077);
          return;
        }
      }
      AppMethodBeat.o(167077);
    }
    
    public final List<bu> bc(int paramInt, String paramString)
    {
      AppMethodBeat.i(289564);
      kotlin.g.b.p.k(paramString, "username");
      Qp(paramInt);
      paramString = (List)eb(paramString, paramInt);
      AppMethodBeat.o(289564);
      return paramString;
    }
    
    public final List<FinderItem> ed(String paramString, int paramInt)
    {
      AppMethodBeat.i(289566);
      kotlin.g.b.p.k(paramString, "username");
      Qp(paramInt);
      paramString = (List)ec(paramString, paramInt);
      AppMethodBeat.o(289566);
      return paramString;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderFpList;", "kotlin.jvm.PlatformType", "invoke", "com/tencent/mm/plugin/finder/storage/data/FinderPage$Companion$cacheToFile$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<ath, Boolean>
    {
      a(String paramString, ath paramath, LinkedList paramLinkedList)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.k
 * JD-Core Version:    0.7.0.1
 */