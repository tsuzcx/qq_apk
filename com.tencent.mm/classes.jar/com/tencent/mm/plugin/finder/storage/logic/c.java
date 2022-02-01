package com.tencent.mm.plugin.finder.storage.logic;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.ae;
import com.tencent.mm.plugin.finder.model.af;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.ao;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a AnK;
  private static final String TAG = "Finder.FinderFeedLogic";
  
  static
  {
    AppMethodBeat.i(167103);
    AnK = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    AppMethodBeat.o(167103);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "", "includePostDb", "deleteMegaVideoFeed", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "", "endTime", "handleFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "handleMegaVideoFeedList", "megaVideoList", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "reportAvatarAssert", "id", "str", "saveCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isNeedClear", "saveToDb", "finderObj", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
  public static final class a
  {
    public static boolean MR(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().MI(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem MS(long paramLong)
    {
      AppMethodBeat.i(167097);
      Log.d(c.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().MI(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean MT(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().MJ(paramLong);
      Log.i(c.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
    
    public static void MU(long paramLong)
    {
      AppMethodBeat.i(289796);
      Object localObject = e.AmW;
      e.a.MN(paramLong);
      localObject = k.Anu;
      k.a.MP(paramLong);
      AppMethodBeat.o(289796);
    }
    
    public static boolean MV(long paramLong)
    {
      AppMethodBeat.i(167099);
      boolean bool = m.a(((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage(), paramLong);
      Log.i(c.access$getTAG$cp(), "Finder.PostLog delete feed localId " + paramLong + " success " + bool);
      AppMethodBeat.o(167099);
      return true;
    }
    
    public static BaseFinderFeed a(FinderItem paramFinderItem)
    {
      Object localObject = null;
      AppMethodBeat.i(167102);
      p.k(paramFinderItem, "finderObject");
      BaseFinderFeed localBaseFinderFeed;
      switch (paramFinderItem.getMediaType())
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localBaseFinderFeed = (BaseFinderFeed)new ac(paramFinderItem);
      }
      for (;;)
      {
        FinderContact localFinderContact = paramFinderItem.getFeedObject().contact;
        paramFinderItem = localObject;
        if (localFinderContact != null) {
          paramFinderItem = com.tencent.mm.plugin.finder.api.c.a(localFinderContact, null);
        }
        localBaseFinderFeed.contact = paramFinderItem;
        AppMethodBeat.o(167102);
        return localBaseFinderFeed;
        localBaseFinderFeed = (BaseFinderFeed)new u(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new ae(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new af(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new aa(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new ac(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new w(paramFinderItem);
      }
    }
    
    public static List<FinderItem> a(List<? extends FinderObject> paramList, int paramInt, bid parambid)
    {
      AppMethodBeat.i(289789);
      p.k(paramList, "feedList");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        FinderObject localFinderObject = (FinderObject)localIterator.next();
        localObject1 = FinderItem.Companion;
        FinderItem localFinderItem = FinderItem.a.b(localFinderObject, paramInt);
        localObject1 = com.tencent.mm.plugin.finder.model.n.zAi;
        com.tencent.mm.plugin.finder.model.n.e(localFinderItem);
        localObject1 = e.AmW;
        e.a.o(localFinderItem);
        if (localFinderItem.getMegaVideo() != null)
        {
          localObject1 = c.AnK;
          localObject1 = j.listOf(localFinderItem.getFeedObject());
          localObject2 = new bid();
          ((bid)localObject2).xkX = 45;
          b((List)localObject1, (bid)localObject2);
        }
        if (parambid != null)
        {
          if (localFinderItem.getFeedObject().sessionBuffer != null)
          {
            localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
            com.tencent.mm.plugin.finder.report.n.a(localFinderItem.getFeedObject(), parambid.xkX);
          }
          localObject1 = e.AmW;
          e.a.m(parambid.xkX, paramList);
        }
        localObject1 = localFinderItem.getFeedObject().contact;
        if (localObject1 != null)
        {
          localObject2 = d.wZQ;
          d.a.b((FinderContact)localObject1);
        }
        localObject1 = "";
        Object localObject2 = localFinderObject.likeList;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            FinderCommentInfo localFinderCommentInfo = (FinderCommentInfo)((Iterator)localObject2).next();
            if (localObject1 != null) {
              if (((CharSequence)localObject1).length() <= 0) {
                break label377;
              }
            }
            label377:
            for (int j = 1;; j = 0)
            {
              if ((j != 0) && (p.h(localObject1, localFinderCommentInfo.headUrl)))
              {
                Object localObject3 = c.AnK;
                long l = localFinderObject.id;
                localObject3 = localFinderCommentInfo.username;
                f.a.a(b.BuZ, "LikeAvatarException", false, false, (a)new a(l, (String)localObject3, (String)localObject1), 12);
              }
              localObject1 = localFinderCommentInfo.headUrl;
              break;
            }
          }
        }
        Log.i(c.access$getTAG$cp(), "insert item index id:" + localFinderObject.nickname + " obj=" + localFinderObject.id + " sourceType " + paramInt + ' ');
        localCollection.add(localFinderItem);
        i += 1;
      }
      localArrayList.addAll((Collection)localCollection);
      Log.i(c.access$getTAG$cp(), "[insertFeedList] insert count=" + paramList.size() + " successfulCount=" + i + " sourceType=" + paramInt);
      paramList = (List)localArrayList;
      AppMethodBeat.o(289789);
      return paramList;
    }
    
    public static void a(List<? extends bu> paramList, int paramInt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(289792);
      p.k(paramList, "list");
      p.k(paramString, "username");
      if (!paramBoolean)
      {
        AppMethodBeat.o(289792);
        return;
      }
      Object localObject1 = aj.AGc;
      int j = aj.QW(paramInt);
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if ((i == 0) || (!(p.h(paramString, z.bdh()) ^ true)) || (j != 1)) {
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
            Object localObject2 = (bu)paramList.next();
            if ((localObject2 instanceof BaseFinderFeed))
            {
              localObject2 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject();
              ((LinkedList)localObject1).add(new com.tencent.mm.plugin.finder.storage.data.q(0, ((FinderObject)localObject2).id, (FinderObject)localObject2, paramInt));
              continue;
              i = 0;
              break;
            }
          }
        }
        paramList = k.Anu;
        k.a.a(i, paramString, (LinkedList)localObject1);
        AppMethodBeat.o(289792);
        return;
      }
    }
    
    public static LinkedList<FinderItem> ai(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(289794);
      p.k(paramString, "username");
      paramString = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().ai(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(289794);
      return paramString;
    }
    
    public static void b(List<? extends FinderObject> paramList, bid parambid)
    {
      AppMethodBeat.i(289791);
      p.k(paramList, "megaVideoList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      Object localObject2;
      Object localObject1;
      label117:
      Object localObject3;
      int i;
      if (localIterator.hasNext())
      {
        localObject2 = (FinderObject)localIterator.next();
        localObject1 = e.AmW;
        e.a.o((FinderObject)localObject2);
        localObject1 = ((FinderObject)localObject2).attachmentList;
        Object localObject4;
        long l1;
        label232:
        long l2;
        if (localObject1 != null)
        {
          localObject1 = ((apx)localObject1).SDm;
          if (localObject1 != null)
          {
            localObject1 = (apw)j.lp((List)localObject1);
            if (localObject1 != null)
            {
              localObject1 = ((apw)localObject1).SDl;
              if (localObject1 != null)
              {
                localObject1 = ((blj)localObject1).SPm;
                Object localObject5;
                if ((parambid != null) && (localObject1 != null))
                {
                  localObject3 = ((cvy)localObject1).sessionBuffer;
                  if (localObject3 != null)
                  {
                    localObject4 = com.tencent.mm.plugin.finder.report.n.zWF;
                    i = parambid.xkX;
                    p.k(localObject2, "finderObject");
                    com.tencent.mm.plugin.finder.report.n.l((FinderObject)localObject2);
                    localObject4 = ((FinderObject)localObject2).attachmentList;
                    if (localObject4 == null) {
                      break label499;
                    }
                    localObject4 = ((apx)localObject4).SDm;
                    if (localObject4 == null) {
                      break label499;
                    }
                    localObject4 = (apw)j.lp((List)localObject4);
                    if (localObject4 == null) {
                      break label499;
                    }
                    localObject4 = ((apw)localObject4).SDl;
                    if (localObject4 == null) {
                      break label499;
                    }
                    localObject4 = ((blj)localObject4).SPm;
                    if (localObject4 == null) {
                      break label499;
                    }
                    l1 = ((cvy)localObject4).id;
                    if ((localObject3 != null) && (kotlin.n.n.l((String)localObject3, ",", ";", false) != null))
                    {
                      localObject3 = new ao((String)localObject3);
                      ((ao)localObject3).xkX = i;
                      ((ao)localObject3).zZQ.id = l1;
                      localObject4 = ((ao)localObject3).zZQ;
                      localObject5 = ((FinderObject)localObject2).client_local_buffer;
                      if (localObject5 == null) {
                        break label504;
                      }
                      l2 = ((bfu)localObject5).SQz;
                      label304:
                      ((bft)localObject4).SQw = l2;
                    }
                  }
                }
                switch (i)
                {
                default: 
                  ((Map)com.tencent.mm.plugin.finder.report.n.zWC).put(l1 + '_' + i, localObject3);
                  label377:
                  com.tencent.mm.plugin.finder.report.n.zWD.put(l1, Long.valueOf(cm.bfE()));
                  localObject4 = c.access$getTAG$cp();
                  localObject5 = new StringBuilder("handleFeedList: insert mega video item index id:");
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
                  localObject2 = ((StringBuilder)localObject5).append((String)localObject2).append(" obj=");
                  if (localObject1 == null) {
                    break;
                  }
                }
              }
            }
          }
        }
        for (localObject1 = Long.valueOf(((cvy)localObject1).id);; localObject1 = "")
        {
          Log.i((String)localObject4, localObject1 + ' ');
          break;
          localObject1 = null;
          break label117;
          label499:
          l1 = 0L;
          break label232;
          label504:
          l2 = 0L;
          break label304;
          ((Map)com.tencent.mm.plugin.finder.report.n.zWC).put(l1 + "_46", localObject3);
          break label377;
          ((Map)com.tencent.mm.plugin.finder.report.n.zWC).put(l1 + "_47", localObject3);
          break label377;
          ((Map)com.tencent.mm.plugin.finder.report.n.zWC).put(l1 + "_48", localObject3);
          break label377;
        }
      }
      if (parambid != null)
      {
        localObject1 = e.AmW;
        i = parambid.xkX;
        parambid = (Iterable)paramList;
        localObject2 = (Collection)new ArrayList(j.a(parambid, 10));
        localObject3 = parambid.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          parambid = ((FinderObject)((Iterator)localObject3).next()).attachmentList;
          if (parambid != null)
          {
            parambid = parambid.SDm;
            if (parambid != null)
            {
              parambid = (apw)j.lp((List)parambid);
              if (parambid != null)
              {
                parambid = parambid.SDl;
                if (parambid != null)
                {
                  localObject1 = parambid.SPm;
                  parambid = (bid)localObject1;
                  if (localObject1 != null) {
                    break label757;
                  }
                }
              }
            }
          }
          parambid = new cvy();
          label757:
          ((Collection)localObject2).add(parambid);
        }
        e.a.n(i, (List)localObject2);
      }
      Log.i(c.access$getTAG$cp(), "[handleFeedList] insert mega video count=" + paramList.size());
      AppMethodBeat.o(289791);
    }
    
    public static csg d(FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(289798);
      p.k(paramFinderMedia, "feedMedia");
      paramFinderMedia = i.c(paramFinderMedia);
      AppMethodBeat.o(289798);
      return paramFinderMedia;
    }
    
    public static void r(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(289797);
      p.k(paramFinderItem, "finderObj");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll((Collection)paramFinderItem.getClipListExt());
      paramFinderItem.setClipListExt(localLinkedList);
      s(paramFinderItem);
      AppMethodBeat.o(289797);
    }
    
    public static boolean s(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167100);
      p.k(paramFinderItem, "feedObject");
      long l2 = paramFinderItem.field_id;
      long l3 = paramFinderItem.getLocalId();
      m localm = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      boolean bool;
      if (MR(l3)) {
        bool = localm.b(l3, paramFinderItem);
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
          bool = localm.a(l2, paramFinderItem);
        } else {
          bool = false;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<String>
    {
      a(long paramLong, String paramString1, String paramString2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.c
 * JD-Core Version:    0.7.0.1
 */