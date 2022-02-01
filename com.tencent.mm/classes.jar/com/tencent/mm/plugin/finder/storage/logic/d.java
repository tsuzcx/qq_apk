package com.tencent.mm.plugin.finder.storage.logic;

import android.util.LongSparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.ae;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.report.bd;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a FND;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167103);
    FND = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    AppMethodBeat.o(167103);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "TAG", "", "collectSessionBufferAndJumpInfo", "", "feeds", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "includePostDb", "deleteMegaVideoFeed", "getBySenderLocal", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "", "endTime", "handleFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "handleMegaVideoFeedList", "megaVideoList", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "reportAvatarAssert", "id", "str", "saveBizCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "bizUsername", "saveCache", "isNeedClear", "saveToDb", "finderObj", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static BaseFinderFeed a(FinderItem paramFinderItem)
    {
      Object localObject = null;
      AppMethodBeat.i(167102);
      s.u(paramFinderItem, "finderObject");
      BaseFinderFeed localBaseFinderFeed;
      switch (paramFinderItem.getMediaType())
      {
      case 3: 
      case 5: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        localBaseFinderFeed = (BaseFinderFeed)new ae(paramFinderItem);
        paramFinderItem = paramFinderItem.getFeedObject().contact;
        if (paramFinderItem != null) {
          break;
        }
      }
      for (paramFinderItem = localObject;; paramFinderItem = c.a(paramFinderItem, null, false))
      {
        localBaseFinderFeed.contact = paramFinderItem;
        AppMethodBeat.o(167102);
        return localBaseFinderFeed;
        localBaseFinderFeed = (BaseFinderFeed)new v(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new ag(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.ah(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new ab(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new ae(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new x(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new ad(paramFinderItem);
        break;
        localBaseFinderFeed = (BaseFinderFeed)new ad(paramFinderItem);
        break;
      }
    }
    
    public static List<FinderItem> a(List<? extends FinderObject> paramList, int paramInt, bui parambui)
    {
      AppMethodBeat.i(339559);
      s.u(paramList, "feedList");
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      FinderObject localFinderObject;
      FinderItem localFinderItem;
      if (localIterator.hasNext())
      {
        localFinderObject = (FinderObject)localIterator.next();
        localObject1 = FinderItem.Companion;
        localFinderItem = FinderItem.a.e(localFinderObject, paramInt);
        localObject1 = o.ECp;
        o.f(localFinderItem);
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        if (!com.tencent.mm.plugin.finder.storage.data.e.a.s(localFinderItem)) {
          break label485;
        }
        i += 1;
      }
      label312:
      label485:
      for (;;)
      {
        Object localObject3;
        if (localFinderItem.getMegaVideo() != null)
        {
          localObject1 = d.FND;
          localObject1 = p.listOf(localFinderItem.getFeedObject());
          localObject2 = new bui();
          ((bui)localObject2).AJo = 45;
          localObject3 = kotlin.ah.aiuX;
          d((List)localObject1, (bui)localObject2);
        }
        localObject1 = localFinderItem.getFeedObject().contact;
        if (localObject1 != null) {
          com.tencent.mm.plugin.finder.api.d.a.a(com.tencent.mm.plugin.finder.api.d.AwY, (FinderContact)localObject1);
        }
        localObject1 = "";
        Object localObject2 = localFinderObject.likeList;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
            if (localObject1 != null) {
              if (((CharSequence)localObject1).length() <= 0) {
                break label312;
              }
            }
            for (int j = 1;; j = 0)
            {
              if ((j != 0) && (s.p(localObject1, ((FinderCommentInfo)localObject3).headUrl)))
              {
                a locala = d.FND;
                e(localFinderObject.id, ((FinderCommentInfo)localObject3).username, (String)localObject1);
              }
              localObject1 = ((FinderCommentInfo)localObject3).headUrl;
              break;
            }
          }
        }
        Log.i(d.access$getTAG$cp(), "insert item index id:" + localFinderObject.nickname + " obj=" + localFinderObject.id + " mediaType:" + localFinderItem.getMediaType() + " sourceType:" + paramInt + ' ');
        localCollection.add(localFinderItem);
        break;
        localArrayList.addAll((Collection)localCollection);
        c((List)localArrayList, parambui);
        Log.i(d.access$getTAG$cp(), "[insertFeedList] insert count=" + paramList.size() + " successfulCount=" + i + " sourceType=" + paramInt);
        paramList = (List)localArrayList;
        AppMethodBeat.o(339559);
        return paramList;
      }
    }
    
    public static void a(List<? extends cc> paramList, int paramInt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(339650);
      s.u(paramList, "list");
      s.u(paramString, "username");
      if (!paramBoolean)
      {
        AppMethodBeat.o(339650);
        return;
      }
      Object localObject1 = av.GiL;
      int j = av.Ug(paramInt);
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if ((i == 0) || (s.p(paramString, com.tencent.mm.model.z.bAW())) || (j != 1)) {
          break label191;
        }
      }
      label191:
      for (int i = 3;; i = j)
      {
        localObject1 = new LinkedList();
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            Object localObject2 = (cc)paramList.next();
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
        paramList = com.tencent.mm.plugin.finder.storage.data.k.FNg;
        k.a.a(i, paramString, (LinkedList)localObject1);
        AppMethodBeat.o(339650);
        return;
      }
    }
    
    public static LinkedList<FinderItem> an(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(339680);
      s.u(paramString, "username");
      paramString = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().an(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(339680);
      return paramString;
    }
    
    public static void c(List<? extends FinderItem> paramList, bui parambui)
    {
      AppMethodBeat.i(339589);
      if (paramList == null)
      {
        AppMethodBeat.o(339589);
        return;
      }
      if (parambui != null)
      {
        localObject1 = ((Iterable)paramList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderItem)((Iterator)localObject1).next();
          if (((FinderItem)localObject2).getFeedObject().sessionBuffer != null)
          {
            com.tencent.mm.plugin.finder.report.z localz = com.tencent.mm.plugin.finder.report.z.FrZ;
            com.tencent.mm.plugin.finder.report.z.a(((FinderItem)localObject2).getFeedObject(), parambui.AJo);
          }
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        i = parambui.AJo;
        Object localObject2 = (Iterable)paramList;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((FinderItem)((Iterator)localObject2).next()).getFeedObject());
        }
        com.tencent.mm.plugin.finder.storage.data.e.a.H(i, (List)localObject1);
      }
      Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.plugin.finder.feed.jumper.i)com.tencent.mm.ui.component.k.cn(com.tencent.mm.plugin.findersdk.a.cn.class).q(com.tencent.mm.plugin.finder.feed.jumper.i.class);
      if (parambui == null) {}
      for (int i = 0;; i = parambui.AJo)
      {
        ((com.tencent.mm.plugin.finder.feed.jumper.i)localObject1).F(paramList, i);
        AppMethodBeat.o(339589);
        return;
      }
    }
    
    public static dji d(FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(339781);
      s.u(paramFinderMedia, "feedMedia");
      paramFinderMedia = com.tencent.mm.plugin.finder.storage.data.i.c(paramFinderMedia);
      AppMethodBeat.o(339781);
      return paramFinderMedia;
    }
    
    public static void d(List<? extends FinderObject> paramList, bui parambui)
    {
      AppMethodBeat.i(339641);
      s.u(paramList, "megaVideoList");
      Object localObject4 = ((Iterable)paramList).iterator();
      Object localObject3;
      Object localObject1;
      label71:
      Object localObject5;
      Object localObject2;
      int i;
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (FinderObject)((Iterator)localObject4).next();
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        com.tencent.mm.plugin.finder.storage.data.e.a.r((FinderObject)localObject3);
        localObject1 = ((FinderObject)localObject3).attachmentList;
        long l1;
        label128:
        Object localObject6;
        long l2;
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((parambui != null) && (localObject1 != null))
          {
            localObject5 = ((dne)localObject1).sessionBuffer;
            if (localObject5 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
              i = parambui.AJo;
              s.u(localObject3, "finderObject");
              com.tencent.mm.plugin.finder.report.z.p((FinderObject)localObject3);
              localObject2 = ((FinderObject)localObject3).attachmentList;
              if (localObject2 != null) {
                break label491;
              }
              l1 = 0L;
              if ((localObject5 != null) && (kotlin.n.n.m((String)localObject5, ",", ";", false) != null))
              {
                localObject2 = new bd((String)localObject5);
                ((bd)localObject2).AJo = i;
                ((bd)localObject2).FuM.id = l1;
                localObject5 = ((bd)localObject2).FuM;
                localObject6 = ((FinderObject)localObject3).client_local_buffer;
                if (localObject6 != null) {
                  break label633;
                }
                l2 = 0L;
                label196:
                ((bra)localObject5).ZZb = l2;
              }
            }
          }
          switch (i)
          {
          default: 
            ((Map)com.tencent.mm.plugin.finder.report.z.eMX()).put(l1 + '_' + i, localObject2);
            label269:
            com.tencent.mm.plugin.finder.report.z.Fse.put(l1, Long.valueOf(com.tencent.mm.model.cn.bDw()));
            localObject5 = d.access$getTAG$cp();
            localObject6 = new StringBuilder("handleFeedList: insert mega video item index id:");
            localObject2 = ((FinderObject)localObject3).contact;
            if (localObject2 == null)
            {
              localObject2 = "";
              label315:
              localObject2 = ((StringBuilder)localObject6).append((String)localObject2).append(" obj=");
              if (localObject1 != null) {
                break label777;
              }
            }
            break;
          }
        }
        label777:
        for (localObject1 = "";; localObject1 = Long.valueOf(((dne)localObject1).id))
        {
          Log.i((String)localObject5, localObject1 + ' ');
          break;
          localObject1 = ((atr)localObject1).ZEi;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label71;
          }
          localObject2 = ((Iterable)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject2).next();
            localObject5 = (atq)localObject1;
            localObject6 = av.GiL;
            s.s(localObject5, "it");
          } while (!av.a((atq)localObject5));
          for (;;)
          {
            localObject1 = (atq)localObject1;
            if (localObject1 != null) {
              break label463;
            }
            localObject1 = null;
            break;
            localObject1 = null;
          }
          label463:
          localObject1 = ((atq)localObject1).ZEf;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label71;
          }
          localObject1 = ((byx)localObject1).ZXx;
          break label71;
          label491:
          localObject2 = ((atr)localObject2).ZEi;
          if (localObject2 == null)
          {
            l1 = 0L;
            break label128;
          }
          localObject6 = ((Iterable)localObject2).iterator();
          atq localatq;
          do
          {
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject2 = ((Iterator)localObject6).next();
            localatq = (atq)localObject2;
            av localav = av.GiL;
            s.s(localatq, "it");
          } while (!av.a(localatq));
          for (;;)
          {
            localObject2 = (atq)localObject2;
            if (localObject2 != null) {
              break label590;
            }
            l1 = 0L;
            break;
            localObject2 = null;
          }
          label590:
          localObject2 = ((atq)localObject2).ZEf;
          if (localObject2 == null)
          {
            l1 = 0L;
            break label128;
          }
          localObject2 = ((byx)localObject2).ZXx;
          if (localObject2 == null)
          {
            l1 = 0L;
            break label128;
          }
          l1 = ((dne)localObject2).id;
          break label128;
          label633:
          l2 = ((brb)localObject6).ZZf;
          break label196;
          ((Map)com.tencent.mm.plugin.finder.report.z.eMX()).put(l1 + "_46", localObject2);
          break label269;
          ((Map)com.tencent.mm.plugin.finder.report.z.eMX()).put(l1 + "_47", localObject2);
          break label269;
          ((Map)com.tencent.mm.plugin.finder.report.z.eMX()).put(l1 + "_48", localObject2);
          break label269;
          localObject3 = ((FinderContact)localObject2).nickname;
          localObject2 = localObject3;
          if (localObject3 != null) {
            break label315;
          }
          localObject2 = "";
          break label315;
        }
      }
      if (parambui != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        i = parambui.AJo;
        parambui = (Iterable)paramList;
        localObject2 = (Collection)new ArrayList(p.a(parambui, 10));
        localObject3 = parambui.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          parambui = ((FinderObject)((Iterator)localObject3).next()).attachmentList;
          if (parambui == null) {
            parambui = null;
          }
          for (;;)
          {
            localObject1 = parambui;
            if (parambui == null) {
              localObject1 = new dne();
            }
            ((Collection)localObject2).add(localObject1);
            break;
            parambui = parambui.ZEi;
            if (parambui == null)
            {
              parambui = null;
            }
            else
            {
              localObject1 = ((Iterable)parambui).iterator();
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                parambui = ((Iterator)localObject1).next();
                localObject4 = (atq)parambui;
                localObject5 = av.GiL;
                s.s(localObject4, "it");
              } while (!av.a((atq)localObject4));
              for (;;)
              {
                parambui = (atq)parambui;
                if (parambui != null) {
                  break label983;
                }
                parambui = null;
                break;
                parambui = null;
              }
              label983:
              parambui = parambui.ZEf;
              if (parambui == null) {
                parambui = null;
              } else {
                parambui = parambui.ZXx;
              }
            }
          }
        }
        com.tencent.mm.plugin.finder.storage.data.e.a.I(i, (List)localObject2);
      }
      Log.i(d.access$getTAG$cp(), s.X("[handleFeedList] insert mega video count=", Integer.valueOf(paramList.size())));
      AppMethodBeat.o(339641);
    }
    
    private static void e(long paramLong, String paramString1, final String paramString2)
    {
      AppMethodBeat.i(339605);
      com.tencent.mm.ae.e.a.a((com.tencent.mm.ae.e)b.HbT, "LikeAvatarException", false, null, false, (a)new a(paramLong, paramString1, paramString2), 28);
      AppMethodBeat.o(339605);
    }
    
    public static boolean pX(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().qc(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem qr(long paramLong)
    {
      AppMethodBeat.i(167097);
      Log.d(d.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().qc(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean qs(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage().qd(paramLong);
      Log.i(d.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
    
    public static void qt(long paramLong)
    {
      AppMethodBeat.i(339718);
      Object localObject = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      com.tencent.mm.plugin.finder.storage.data.e.a.qi(paramLong);
      localObject = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.qk(paramLong);
      AppMethodBeat.o(339718);
    }
    
    public static boolean qu(long paramLong)
    {
      AppMethodBeat.i(167099);
      boolean bool = com.tencent.mm.plugin.finder.storage.n.a(((PluginFinder)h.az(PluginFinder.class)).getFeedStorage(), paramLong);
      Log.i(d.access$getTAG$cp(), "Finder.PostLog delete feed localId " + paramLong + " success " + bool);
      AppMethodBeat.o(167099);
      return true;
    }
    
    public static void u(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(339750);
      s.u(paramFinderItem, "finderObj");
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.addAll((Collection)paramFinderItem.getClipListExt());
      paramFinderItem.setClipListExt(localLinkedList);
      v(paramFinderItem);
      AppMethodBeat.o(339750);
    }
    
    public static void v(List<? extends cc> paramList, String paramString)
    {
      AppMethodBeat.i(339673);
      s.u(paramList, "list");
      s.u(paramString, "bizUsername");
      if (kotlin.n.n.bp((CharSequence)paramString)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(339673);
        return;
      }
      Object localObject1 = av.GiL;
      i = av.Ug(33536);
      localObject1 = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (cc)paramList.next();
        if ((localObject2 instanceof BaseFinderFeed))
        {
          localObject2 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject();
          ((LinkedList)localObject1).add(new r(0, ((FinderObject)localObject2).id, (FinderObject)localObject2, 33536));
        }
      }
      paramList = com.tencent.mm.plugin.finder.storage.data.k.FNg;
      k.a.a(i, paramString, (LinkedList)localObject1);
      AppMethodBeat.o(339673);
    }
    
    public static boolean v(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167100);
      s.u(paramFinderItem, "feedObject");
      long l2 = paramFinderItem.field_id;
      long l3 = paramFinderItem.getLocalId();
      com.tencent.mm.plugin.finder.storage.n localn = ((PluginFinder)h.az(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      boolean bool;
      if (pX(l3)) {
        bool = localn.c(l3, paramFinderItem);
      }
      for (;;)
      {
        if (bool) {
          l1 = paramFinderItem.getLocalId();
        }
        Log.i(d.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
        AppMethodBeat.o(167100);
        return bool;
        if (l2 != 0L) {
          bool = localn.b(l2, paramFinderItem);
        } else {
          bool = false;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<String>
    {
      a(long paramLong, String paramString1, String paramString2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d
 * JD-Core Version:    0.7.0.1
 */