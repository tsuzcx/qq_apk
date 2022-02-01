package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "Finder.FinderFeedLogic";
  private static final f vGM;
  public static final a vGN;
  
  static
  {
    AppMethodBeat.i(167103);
    vGN = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    vGM = kotlin.g.ah((a)b.vGO);
    AppMethodBeat.o(167103);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "deleteMegaVideoFeed", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "handleFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "handleMegaVideoFeedList", "megaVideoList", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "saveCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isNeedClear", "saveToDb", "finderObj", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
  public static final class a
  {
    public static boolean FR(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem FS(long paramLong)
    {
      AppMethodBeat.i(167097);
      Log.d(c.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean FT(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().FA(paramLong);
      Log.i(c.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
    
    public static void FU(long paramLong)
    {
      AppMethodBeat.i(252066);
      Object localObject = e.vFX;
      e.a.FE(paramLong);
      localObject = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      l.a.FP(paramLong);
      AppMethodBeat.o(252066);
    }
    
    public static boolean FV(long paramLong)
    {
      AppMethodBeat.i(167099);
      boolean bool = com.tencent.mm.plugin.finder.storage.l.a(((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage(), paramLong);
      Log.i(c.access$getTAG$cp(), "Finder.PostLog delete feed localId " + paramLong + " success " + bool);
      AppMethodBeat.o(167099);
      return true;
    }
    
    public static List<FinderItem> a(List<? extends FinderObject> paramList, int paramInt, bbn parambbn)
    {
      AppMethodBeat.i(252060);
      p.h(paramList, "feedList");
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        FinderObject localFinderObject = (FinderObject)((Iterator)localObject1).next();
        Object localObject2 = FinderItem.Companion;
        localObject2 = FinderItem.a.a(localFinderObject, paramInt);
        Object localObject3 = n.uNU;
        n.d((FinderItem)localObject2);
        localObject3 = e.vFX;
        e.a.n((FinderItem)localObject2);
        i += 1;
        Object localObject4;
        if (((FinderItem)localObject2).getMegaVideo() != null)
        {
          localObject3 = c.vGN;
          localObject3 = kotlin.a.j.listOf(((FinderItem)localObject2).getFeedObject());
          localObject4 = new bbn();
          ((bbn)localObject4).tCE = 45;
          b((List)localObject3, (bbn)localObject4);
        }
        if (parambbn != null)
        {
          localObject3 = ((FinderItem)localObject2).getFeedObject().sessionBuffer;
          if (localObject3 != null)
          {
            localObject4 = k.vfA;
            k.e(((FinderItem)localObject2).getId(), parambbn.tCE, (String)localObject3);
          }
          localObject3 = e.vFX;
          e.a.k(parambbn.tCE, paramList);
        }
        localObject3 = ((FinderItem)localObject2).getFeedObject().contact;
        if (localObject3 != null)
        {
          localObject4 = com.tencent.mm.plugin.finder.api.c.tsp;
          com.tencent.mm.plugin.finder.api.c.a.b((FinderContact)localObject3);
        }
        Log.i(c.access$getTAG$cp(), "insert item index id:" + localFinderObject.nickname + " obj=" + localFinderObject.id + " sourceType " + paramInt + ' ');
        localCollection.add(localObject2);
      }
      localArrayList.addAll((Collection)localCollection);
      Log.i(c.access$getTAG$cp(), "[insertFeedList] insert count=" + paramList.size() + " successfulCount=" + i + " sourceType=" + paramInt);
      paramList = (List)localArrayList;
      AppMethodBeat.o(252060);
      return paramList;
    }
    
    public static void a(List<? extends bo> paramList, int paramInt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(252063);
      p.h(paramList, "list");
      p.h(paramString, "username");
      if (!paramBoolean)
      {
        AppMethodBeat.o(252063);
        return;
      }
      Object localObject1 = y.vXH;
      int j = y.LJ(paramInt);
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if ((i == 0) || (!(p.j(paramString, z.aUg()) ^ true)) || (j != 1)) {
          break label193;
        }
      }
      label193:
      for (int i = 3;; i = j)
      {
        localObject1 = new LinkedList();
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            Object localObject2 = (bo)paramList.next();
            if ((localObject2 instanceof BaseFinderFeed))
            {
              localObject2 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject();
              ((LinkedList)localObject1).add(new r(0, ((FinderObject)localObject2).id, (FinderObject)localObject2, paramInt));
              continue;
              i = 0;
              break;
            }
          }
        }
        paramList = com.tencent.mm.plugin.finder.storage.data.l.vGw;
        l.a.a(i, paramString, (LinkedList)localObject1);
        AppMethodBeat.o(252063);
        return;
      }
    }
    
    public static LinkedList<FinderItem> af(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(252065);
      p.h(paramString, "username");
      paramString = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().af(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(252065);
      return paramString;
    }
    
    public static cjl b(FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(252068);
      p.h(paramFinderMedia, "feedMedia");
      paramFinderMedia = com.tencent.mm.plugin.finder.storage.data.j.a(paramFinderMedia);
      AppMethodBeat.o(252068);
      return paramFinderMedia;
    }
    
    public static void b(List<? extends FinderObject> paramList, bbn parambbn)
    {
      AppMethodBeat.i(252062);
      p.h(paramList, "megaVideoList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      Object localObject2;
      Object localObject1;
      label103:
      Object localObject3;
      if (localIterator.hasNext())
      {
        localObject2 = (FinderObject)localIterator.next();
        localObject1 = e.vFX;
        e.a.j((FinderObject)localObject2);
        localObject1 = ((FinderObject)localObject2).attachmentList;
        Object localObject4;
        if (localObject1 != null)
        {
          localObject1 = ((aoq)localObject1).LAM;
          if (localObject1 != null)
          {
            localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
            if (localObject1 != null)
            {
              localObject1 = ((aop)localObject1).LAL;
              if (localObject1 != null)
              {
                localObject1 = ((bei)localObject1).LIA;
                if ((parambbn != null) && (localObject1 != null))
                {
                  localObject3 = ((cng)localObject1).sessionBuffer;
                  if (localObject3 != null)
                  {
                    localObject4 = k.vfA;
                    k.d(((cng)localObject1).id, parambbn.tCE, (String)localObject3);
                  }
                }
                localObject4 = c.access$getTAG$cp();
                StringBuilder localStringBuilder = new StringBuilder("handleFeedList: insert mega video item index id:");
                localObject2 = ((FinderObject)localObject2).contact;
                if (localObject2 != null)
                {
                  localObject3 = ((FinderContact)localObject2).nickname;
                  localObject2 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject2 = "";
                }
                localObject2 = localStringBuilder.append((String)localObject2).append(" obj=");
                if (localObject1 == null) {
                  break label244;
                }
              }
            }
          }
        }
        label244:
        for (localObject1 = Long.valueOf(((cng)localObject1).id);; localObject1 = "")
        {
          Log.i((String)localObject4, localObject1 + ' ');
          break;
          localObject1 = null;
          break label103;
        }
      }
      if (parambbn != null)
      {
        localObject1 = e.vFX;
        int i = parambbn.tCE;
        parambbn = (Iterable)paramList;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a(parambbn, 10));
        localObject3 = parambbn.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          parambbn = ((FinderObject)((Iterator)localObject3).next()).attachmentList;
          if (parambbn != null)
          {
            parambbn = parambbn.LAM;
            if (parambbn != null)
            {
              parambbn = (aop)kotlin.a.j.kt((List)parambbn);
              if (parambbn != null)
              {
                parambbn = parambbn.LAL;
                if (parambbn != null)
                {
                  localObject1 = parambbn.LIA;
                  parambbn = (bbn)localObject1;
                  if (localObject1 != null) {
                    break label375;
                  }
                }
              }
            }
          }
          parambbn = new cng();
          label375:
          ((Collection)localObject2).add(parambbn);
        }
        e.a.l(i, (List)localObject2);
      }
      Log.i(c.access$getTAG$cp(), "[handleFeedList] insert mega video count=" + paramList.size());
      AppMethodBeat.o(252062);
    }
    
    public static List<Integer> dyN()
    {
      AppMethodBeat.i(167092);
      Object localObject = c.dyM();
      a locala = c.vGN;
      localObject = (List)((f)localObject).getValue();
      AppMethodBeat.o(167092);
      return localObject;
    }
    
    public static void q(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(252067);
      p.h(paramFinderItem, "finderObj");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll((Collection)paramFinderItem.getClipListExt());
      paramFinderItem.setClipListExt(localLinkedList);
      r(paramFinderItem);
      AppMethodBeat.o(252067);
    }
    
    public static boolean r(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167100);
      p.h(paramFinderItem, "feedObject");
      long l2 = paramFinderItem.field_id;
      long l3 = paramFinderItem.getLocalId();
      com.tencent.mm.plugin.finder.storage.l locall = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      boolean bool;
      if (FR(l3)) {
        bool = locall.b(l3, paramFinderItem);
      }
      for (;;)
      {
        if (bool) {
          l1 = paramFinderItem.getLocalId();
        }
        Log.i(c.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
        AppMethodBeat.o(167100);
        return bool;
        if (l2 != 0L) {
          bool = locall.a(l2, paramFinderItem);
        } else {
          bool = false;
        }
      }
    }
    
    public static BaseFinderFeed s(FinderItem paramFinderItem)
    {
      Object localObject = null;
      AppMethodBeat.i(167102);
      p.h(paramFinderItem, "finderObject");
      BaseFinderFeed localBaseFinderFeed;
      switch (paramFinderItem.getMediaType())
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localBaseFinderFeed = (BaseFinderFeed)new ab(paramFinderItem);
      }
      for (;;)
      {
        FinderContact localFinderContact = paramFinderItem.getFeedObject().contact;
        paramFinderItem = localObject;
        if (localFinderContact != null) {
          paramFinderItem = b.a(localFinderContact, null);
        }
        localBaseFinderFeed.contact = paramFinderItem;
        AppMethodBeat.o(167102);
        return localBaseFinderFeed;
        localBaseFinderFeed = (BaseFinderFeed)new u(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new ac(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new ad(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new aa(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new ab(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new w(paramFinderItem);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "invoke"})
  static final class b
    extends q
    implements a<List<? extends Integer>>
  {
    public static final b vGO;
    
    static
    {
      AppMethodBeat.i(167090);
      vGO = new b();
      AppMethodBeat.o(167090);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */