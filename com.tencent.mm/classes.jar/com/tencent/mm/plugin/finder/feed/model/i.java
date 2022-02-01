package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.hw;
import com.tencent.mm.autogen.a.hy;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "finderHomeCheckPlay", "", "getFeedByPosToLoad", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "notifyPos", "preloadNextPageComment", "lastBuf", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  public static final a Bfg;
  private static boolean Bfj;
  private int AJo;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> ATq;
  private kotlin.g.a.b<? super Integer, ? extends cc> Bfh;
  private Vector<Long> Bfi;
  private final String TAG;
  final AppCompatActivity activity;
  private int scene;
  
  static
  {
    AppMethodBeat.i(366187);
    Bfg = new a((byte)0);
    AppMethodBeat.o(366187);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(366015);
    this.activity = paramAppCompatActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.ATq = new CopyOnWriteArraySet();
    this.scene = 2;
    this.Bfi = new Vector();
    AppMethodBeat.o(366015);
  }
  
  private static final ah a(i parami, long paramLong, ah.f paramf1, ah.f paramf2, int paramInt, b.a parama)
  {
    AppMethodBeat.i(366166);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramf1, "$localLevel2Comments");
    kotlin.g.b.s.u(paramf2, "$localComments");
    boolean bool2;
    int i;
    try
    {
      com.tencent.mm.bx.b localb;
      Object localObject2;
      Object localObject1;
      if ((parama.errType == 0) && (parama.errCode == 0) && (parama.ott != null))
      {
        localb = ((ayl)parama.ott).lastBuffer;
        localObject2 = parami.TAG;
        if (localb == null) {
          localObject1 = "null";
        }
      }
      for (;;)
      {
        Log.d((String)localObject2, kotlin.g.b.s.X("---refreshData lastBuffer ", localObject1));
        boolean bool1;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (((ayl)parama.ott).ZJm == 1)
        {
          bool1 = true;
          if (((ayl)parama.ott).upContinueFlag == 1)
          {
            bool2 = true;
            i = ((ayl)parama.ott).commentCount;
            Log.d(parami.TAG, kotlin.g.b.s.X("---first fetch, svrCount:", Integer.valueOf(i)));
            localObject1 = (ayl)parama.ott;
            if (localObject1 != null)
            {
              localObject1 = ((ayl)localObject1).ZJr;
              if (localObject1 != null) {
                com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda1(parami, paramLong, (LinkedList)localObject1));
              }
            }
            localObject2 = (List)new ArrayList();
            localObject1 = ((ayl)parama.ott).ZJl;
            kotlin.g.b.s.s(localObject1, "it.resp.commentInfo");
            localObject3 = (Iterable)localObject1;
            localObject1 = (Collection)localObject2;
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (FinderCommentInfo)((Iterator)localObject3).next();
              localObject5 = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
              kotlin.g.b.s.s(localObject4, "commentInfo");
              ((Collection)localObject1).add(com.tencent.mm.plugin.finder.storage.logic.a.a((FinderCommentInfo)localObject4, paramLong));
            }
          }
        }
        else
        {
          try
          {
            Log.printErrStackTrace(parami.TAG, paramf1, "preloadFirstPageComment exception", new Object[0]);
            parami.Bfi.remove(Long.valueOf(paramLong));
            return parami;
            localObject1 = MD5Util.getMD5String(localb.toByteArray());
            continue;
            localObject1 = ((ayl)parama.ott).ZJo;
            kotlin.g.b.s.s(localObject1, "it.resp.barrageCommentInfo");
            localObject1 = parami.b((LinkedList)localObject1, paramLong);
            parami.a((List)paramf1.aqH, (List)localObject2, paramLong);
            localObject2 = d((List)localObject2, paramLong);
            paramf2 = ((Iterable)paramf2.aqH).iterator();
            while (paramf2.hasNext())
            {
              localObject3 = (au)paramf2.next();
              localObject4 = ((Iterable)localObject2).iterator();
              if (!((Iterator)localObject4).hasNext()) {
                break label1330;
              }
              paramf1 = ((Iterator)localObject4).next();
              localObject5 = (t)paramf1;
              if ((((t)localObject5).ECu.eZM() == null) || (!kotlin.g.b.s.p(((t)localObject5).ECu.eZM(), ((au)localObject3).eZM()))) {
                break label1324;
              }
              i = 1;
              break label1316;
              if ((t)paramf1 == null)
              {
                Log.d(parami.TAG, kotlin.g.b.s.X("---merge local item: ", ((au)localObject3).eZM()));
                paramf1 = new t((au)localObject3);
                paramf1.ECw = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)((au)localObject3).getContent());
                localObject3 = ah.aiuX;
                ((List)localObject2).add(paramf1);
              }
            }
            Log.i(parami.TAG, "---merge respCount:" + ((ayl)parama.ott).commentCount + ", preSize: " + ((ayl)parama.ott).ZJl.size() + ", afterSize:" + ((List)localObject2).size());
            if (Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.FMT.aw(paramLong, 0L)))
            {
              paramf1 = com.tencent.mm.plugin.finder.storage.data.f.FMT;
              localObject3 = (Iterable)localObject2;
              paramf2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                paramf2.add(((t)((Iterator)localObject3).next()).ECu);
              }
              paramf1.a(paramLong, 0L, (List)paramf2);
              com.tencent.mm.plugin.finder.storage.data.f.FMT.a(paramLong, 0L, 0, localb, bool2, bool1, false);
              Log.i(parami.TAG, "add cache succ, feedId: " + com.tencent.mm.ae.d.hF(paramLong) + ", size:" + ((List)localObject2).size());
              ((hw)localObject1).publish();
              if (paramInt >= 0)
              {
                paramf1 = parami.Bfh;
                if (paramf1 != null) {
                  break label1105;
                }
                paramf1 = null;
                if (((paramf1 instanceof BaseFinderFeed)) && (((BaseFinderFeed)paramf1).feedObject.getId() == paramLong) && ((((BaseFinderFeed)paramf1).feedObject.getMediaType() == 2) || (((BaseFinderFeed)paramf1).feedObject.getMediaType() == 4)))
                {
                  paramf2 = ((ayl)parama.ott).feedObject;
                  if (paramf2 != null)
                  {
                    if ((!((BaseFinderFeed)paramf1).isHistoryFeed) || (((BaseFinderFeed)paramf1).feedObject.getMediaType() != 4) || (((BaseFinderFeed)paramf1).feedObject.isUrlValid())) {
                      break label1123;
                    }
                    Log.i(parami.TAG, kotlin.g.b.s.X("preloadFirstPageComment: notify feed full update, feedId = ", com.tencent.mm.ae.d.hF(paramLong)));
                    paramf1 = e.FMN;
                    paramf1 = FinderItem.Companion;
                    e.a.s(FinderItem.a.e(paramf2, 1));
                    paramf1 = new if();
                    paramf1.hJB.id = paramLong;
                    paramf1.hJB.hJH = 1;
                    paramf1.hJB.type = 0;
                    paramf1.publish();
                    if ((parami.activity instanceof FinderHomeUI)) {
                      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(parami));
                    }
                  }
                }
              }
            }
            do
            {
              for (;;)
              {
                parami.Bfi.remove(Long.valueOf(paramLong));
                break;
                Log.i(parami.TAG, "---cache exist or list is empty, feedId:" + com.tencent.mm.ae.d.hF(paramLong) + ", list size: " + ((List)localObject2).size());
                break label821;
                paramf1 = (cc)paramf1.invoke(Integer.valueOf(paramInt));
                break label843;
                ((BaseFinderFeed)paramf1).feedObject.setCommentCount(paramf2.commentCount);
                ((BaseFinderFeed)paramf1).feedObject.setLikeCount(paramf2.likeCount);
                ((BaseFinderFeed)paramf1).feedObject.setForwardCount(paramf2.forwardCount);
                paramf1 = new if();
                paramf1.hJB.id = paramLong;
                paramf1.hJB.type = 20;
                paramf1.publish();
              }
            } while ((parama.errCode != -4011) && (parama.errCode != -4033) && (parama.errCode != -4036));
            paramf1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
            d.a.qs(paramLong);
            paramf1 = new hy();
            paramf1.hJo.id = paramLong;
            paramf1.publish();
            Log.i(parami.TAG, kotlin.g.b.s.X("CgiGetFinderFeedComment onCgiEnd: deleteItem by id ", Long.valueOf(paramLong)));
          }
          finally
          {
            parami.Bfi.remove(Long.valueOf(paramLong));
            AppMethodBeat.o(366166);
          }
        }
      }
    }
    finally {}
    for (;;)
    {
      label821:
      label843:
      label1105:
      label1123:
      bool2 = false;
      break;
      for (;;)
      {
        label1316:
        if (i == 0) {
          break label1328;
        }
        break;
        label1324:
        i = 0;
      }
      label1328:
      continue;
      label1330:
      paramf1 = null;
    }
  }
  
  private void a(long paramLong, String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(366045);
    kotlin.g.b.s.u(paramString2, "feedUsername");
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable for 青少年模式");
      AppMethodBeat.o(366045);
      return;
    }
    if (Bfj)
    {
      Log.i(this.TAG, kotlin.g.b.s.X("preloadFirstPageComment disable commentScene=", Integer.valueOf(paramInt1)));
      AppMethodBeat.o(366045);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (!com.tencent.mm.plugin.finder.storage.d.eRv())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(366045);
      return;
    }
    if (paramLong == 0L)
    {
      Log.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(366045);
      return;
    }
    localObject1 = this.Bfh;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!(localObject1 instanceof BaseFinderFeed)) {
        break label256;
      }
      localObject1 = (BaseFinderFeed)localObject1;
      label159:
      if ((localObject1 == null) || (((BaseFinderFeed)localObject1).isHistoryFeed != true)) {
        break label262;
      }
    }
    label256:
    label262:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.data.f.FMT.aw(paramLong, 0L);
      if ((bool) || (Util.isNullOrNil((List)localObject1)) || (Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.FMT.qj(paramLong)))) {
        break label268;
      }
      Log.i(this.TAG, kotlin.g.b.s.X("***preloadFirstPageComment has cache, feedId = ", com.tencent.mm.ae.d.hF(paramLong)));
      AppMethodBeat.o(366045);
      return;
      localObject1 = (cc)((kotlin.g.a.b)localObject1).invoke(Integer.valueOf(paramInt2));
      break;
      localObject1 = null;
      break label159;
    }
    label268:
    if (this.Bfi.contains(Long.valueOf(paramLong)))
    {
      Log.i(this.TAG, kotlin.g.b.s.X("***preloadFirstPageComment is loading, feedId = ", com.tencent.mm.ae.d.hF(paramLong)));
      AppMethodBeat.o(366045);
      return;
    }
    ah.f localf1 = new ah.f();
    localf1.aqH = ((List)ab.aivy);
    ah.f localf2 = new ah.f();
    localf2.aqH = ((List)ab.aivy);
    localf1.aqH = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFinderActionStorage().pU(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.aqH;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label463:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((au)localObject3).field_actionInfo.ABa != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label463;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.aqH = ((List)localObject1);
      localObject2 = (Iterable)localf1.aqH;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label566:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((au)localObject3).field_actionInfo.ABa == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label566;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.aqH = ((List)localObject1);
    }
    this.Bfi.add(Long.valueOf(paramLong));
    Log.i(this.TAG, "***preloadFirstPageComment start request, pos = " + paramInt2 + ", feedId = " + com.tencent.mm.ae.d.hF(paramLong) + ", isHistoryFeed = " + bool);
    int i = this.scene;
    localObject1 = as.GSQ;
    localObject1 = as.a.hu((Context)this.activity);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      new az(paramLong, paramString1, paramInt1, i, paramString2, false, null, null, 0L, null, false, false, null, (bui)localObject1, 3, null, 40928).bFJ().h(new i..ExternalSyntheticLambda0(this, paramLong, localf2, localf1, paramInt2)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(366045);
      return;
    }
  }
  
  private static final void a(i parami, long paramLong, LinkedList paramLinkedList)
  {
    AppMethodBeat.i(366121);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramLinkedList, "$it");
    k localk = k.aeZF;
    parami = (com.tencent.mm.plugin.finder.viewmodel.component.s)k.d(parami.activity).cp(com.tencent.mm.plugin.finder.viewmodel.component.s.class);
    if (parami != null)
    {
      parami = parami.rg(paramLong);
      if (parami != null) {
        parami.t(paramLinkedList);
      }
    }
    AppMethodBeat.o(366121);
  }
  
  private final void a(List<au> paramList, List<t> paramList1, long paramLong)
  {
    AppMethodBeat.i(366098);
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)paramList).iterator();
    FinderCommentInfo localFinderCommentInfo;
    Object localObject1;
    int i;
    label86:
    int j;
    label160:
    label173:
    while (localIterator.hasNext())
    {
      localFinderCommentInfo = ((au)localIterator.next()).field_actionInfo.ZDG;
      if (localFinderCommentInfo != null)
      {
        localObject1 = localList2.iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext()) {
          if (((FinderCommentInfo)((Iterator)localObject1).next()).commentId == localFinderCommentInfo.commentId)
          {
            j = 1;
            label121:
            if (j == 0) {
              break label160;
            }
          }
        }
        for (;;)
        {
          if ((i >= 0) || (localFinderCommentInfo.commentId == 0L)) {
            break label173;
          }
          localList2.add(localFinderCommentInfo);
          break;
          j = 0;
          break label121;
          i += 1;
          break label86;
          i = -1;
        }
      }
    }
    localIterator = ((Iterable)localList2).iterator();
    if (localIterator.hasNext())
    {
      localFinderCommentInfo = (FinderCommentInfo)localIterator.next();
      localObject1 = paramList1.iterator();
      i = 0;
      label220:
      if (((Iterator)localObject1).hasNext()) {
        if (((t)((Iterator)localObject1).next()).ECu.eZI().commentId == localFinderCommentInfo.commentId)
        {
          j = 1;
          if (j == 0) {
            break label442;
          }
        }
      }
      for (;;)
      {
        label261:
        if (i >= 0)
        {
          paramList1.remove(i);
          Log.i(this.TAG, "mergeLocalLevel2Comments, remove level1ExistIndex:" + i + ", id:" + localFinderCommentInfo.commentId);
        }
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
        localList1.add(com.tencent.mm.plugin.finder.storage.logic.a.a(localFinderCommentInfo, paramLong));
        localObject1 = ((Iterable)paramList).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (au)((Iterator)localObject1).next();
          if (((au)localObject2).field_actionInfo.ABa == localFinderCommentInfo.commentId)
          {
            t localt = new t((au)localObject2);
            localt.ECw = com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)((au)localObject2).getContent());
            localObject2 = ah.aiuX;
            localList1.add(localt);
          }
        }
        break;
        j = 0;
        break label261;
        label442:
        i += 1;
        break label220;
        i = -1;
      }
    }
    if (localList1.size() > 0) {
      Log.i(this.TAG, "mergeLocalLevel2Comments, total local size: " + localList1.size() + ", level1 size:" + localList2.size());
    }
    paramList1.addAll((Collection)localList1);
    AppMethodBeat.o(366098);
  }
  
  private final hw b(LinkedList<FinderCommentInfo> arg1, long paramLong)
  {
    AppMethodBeat.i(366082);
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)???;
    ??? = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
      ???.add(com.tencent.mm.plugin.finder.storage.logic.a.a((FinderCommentInfo)localObject3, paramLong));
    }
    localList.addAll((Collection)???);
    ??? = (List)new ArrayList();
    localObject2 = (Iterable)localList;
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    int j;
    int k;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (t)localObject3;
      ???.add(localObject3);
      if ((((t)localObject3).ECu.field_actionInfo.ABa == 0L) && (((t)localObject3).ECu.eZI().levelTwoComment.size() > 0) && ((i >= localList.size() - 1) || (((t)localList.get(i + 1)).ECu.field_actionInfo.ABa == 0L)))
      {
        k = ((t)localObject3).ECu.eZI().levelTwoComment.size();
        i = 0;
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = (FinderCommentInfo)((t)localObject3).ECu.eZI().levelTwoComment.remove();
      com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
      kotlin.g.b.s.s(localObject4, "level2CommentInfo");
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject4, paramLong, ((t)localObject3).bZA());
      if (((t)localObject4).ECu.eZP())
      {
        ((t)localObject4).ECC = true;
        localObject3 = ah.aiuX;
        ???.add(localObject4);
        i = j;
        break;
      }
      if (i >= k)
      {
        i = j;
        break;
        localObject3 = new hw();
        ((hw)localObject3).hJl.feedId = paramLong;
        if (!Util.isNullOrNil(???))
        {
          localObject2 = com.tencent.mm.plugin.finder.storage.data.f.FMT;
          localObject4 = (Iterable)???;
          ??? = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext()) {
            ???.add(((t)((Iterator)localObject4).next()).ECu);
          }
          localObject4 = (List)???;
          kotlin.g.b.s.u(localObject4, "comments");
        }
        for (;;)
        {
          try
          {
            synchronized (com.tencent.mm.plugin.finder.storage.data.f.FMT)
            {
              com.tencent.mm.plugin.finder.storage.data.f.FMW.remove(new f.a(paramLong, 0L));
              com.tencent.mm.plugin.finder.storage.data.f.FMW.put(new f.a(paramLong, 0L), localObject4);
              Log.i(this.TAG, "add bullet subtitle cache succ, feedId: " + paramLong + ", size:" + localList.size());
              ((hw)localObject3).hJl.hJm = false;
              AppMethodBeat.o(366082);
              return localObject3;
            }
            ((hw)localObject3).hJl.hJm = true;
          }
          finally
          {
            AppMethodBeat.o(366082);
          }
        }
      }
    }
  }
  
  private static List<t> d(List<t> paramList, long paramLong)
  {
    AppMethodBeat.i(366108);
    List localList = (List)new ArrayList();
    Object localObject1 = (Iterable)paramList;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    Object localObject3;
    int k;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (t)localObject2;
      localList.add(localObject2);
      if ((((t)localObject2).ECu.field_actionInfo.ABa == 0L) && (((t)localObject2).ECu.eZI().levelTwoComment.size() > 0) && ((i >= paramList.size() - 1) || (((t)paramList.get(i + 1)).ECu.field_actionInfo.ABa == 0L)))
      {
        localObject3 = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.eRS().bmg()).intValue() == 1)
        {
          k = ((t)localObject2).ECu.eZI().levelTwoComment.size();
          j = 0;
          if (k <= 0) {}
        }
      }
    }
    for (;;)
    {
      j += 1;
      localObject3 = (FinderCommentInfo)((t)localObject2).ECu.eZI().levelTwoComment.remove();
      Object localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.FNx;
      kotlin.g.b.s.s(localObject3, "level2Comment");
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject3, paramLong, ((t)localObject2).bZA());
      ((t)localObject3).ECC = true;
      localObject4 = ah.aiuX;
      localList.add(localObject3);
      if (j >= k)
      {
        ((t)localObject2).ECB -= k;
        if (((t)localObject2).ECB < 0) {
          ((t)localObject2).ECB = 0;
        }
        i += 1;
        break;
        AppMethodBeat.o(366108);
        return localList;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, kotlin.g.a.b<? super Integer, ? extends cc> paramb)
  {
    AppMethodBeat.i(366227);
    Log.i(this.TAG, "onAttach");
    this.Bfh = paramb;
    this.scene = paramInt1;
    this.AJo = paramInt2;
    AppMethodBeat.o(366227);
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    boolean bool = true;
    AppMethodBeat.i(166034);
    kotlin.g.b.s.u(paramb, "ev");
    int i;
    long l;
    String str2;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOw;
      if (i < 0)
      {
        AppMethodBeat.o(166034);
        return;
      }
      paramb = this.Bfh;
      if (paramb != null)
      {
        paramb = (cc)paramb.invoke(Integer.valueOf(i));
        if (paramb != null)
        {
          if ((paramb instanceof BaseFinderFeed))
          {
            a(((BaseFinderFeed)paramb).feedObject.getId(), ((BaseFinderFeed)paramb).feedObject.getObjectNonceId(), this.AJo, ((BaseFinderFeed)paramb).feedObject.isOldVersion(), ((BaseFinderFeed)paramb).feedObject.getUserName(), i);
            AppMethodBeat.o(166034);
            return;
          }
          if ((paramb instanceof ca))
          {
            l = ((ca)paramb).getFeedObject().id;
            str2 = ((ca)paramb).getFeedObject().objectNonceId;
            i = this.AJo;
            if (((ca)paramb).getFeedObject().secondaryShowFlag == 1) {
              break label223;
            }
          }
        }
      }
    }
    for (;;)
    {
      String str1 = ((ca)paramb).getFeedObject().username;
      paramb = str1;
      if (str1 == null) {
        paramb = "";
      }
      a(this, l, str2, i, bool, paramb);
      AppMethodBeat.o(166034);
      return;
      label223:
      bool = false;
    }
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166035);
    kotlin.g.b.s.u(paramc, "dispatcher");
    kotlin.g.b.s.u(paramb, "event");
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      if ((((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 0) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 5) || (((com.tencent.mm.plugin.finder.event.base.h)paramb).type == 4))
      {
        AppMethodBeat.o(166035);
        return true;
      }
      AppMethodBeat.o(166035);
      return false;
    }
    AppMethodBeat.o(166035);
    return false;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166036);
    this.ATq.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    Log.i(this.TAG, "onDetach");
    this.Bfh = null;
    Iterator localIterator = ((Iterable)this.ATq).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    Bfj = false;
    this.ATq.clear();
    this.Bfi.clear();
    AppMethodBeat.o(166033);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader$Companion;", "", "()V", "isIgnoreFirstPreload", "", "()Z", "setIgnoreFirstPreload", "(Z)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.i
 * JD-Core Version:    0.7.0.1
 */