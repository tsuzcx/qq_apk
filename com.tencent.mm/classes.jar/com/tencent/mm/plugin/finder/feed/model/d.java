package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.af;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "getFeedByPosToLoad", "", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "preloadNextPageComment", "lastBuf", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  final String TAG;
  private int scene;
  private int tCE;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> tLP;
  private kotlin.g.a.b<? super Integer, ? extends bo> tUO;
  Vector<Long> tUP;
  private final AppCompatActivity tUQ;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(244559);
    this.tUQ = paramAppCompatActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.tLP = new CopyOnWriteArraySet();
    this.scene = 2;
    this.tUP = new Vector();
    AppMethodBeat.o(244559);
  }
  
  private final void IM(int paramInt)
  {
    AppMethodBeat.i(244556);
    Object localObject = this.tUO;
    long l;
    String str;
    boolean bool;
    if (localObject != null)
    {
      localObject = (bo)((kotlin.g.a.b)localObject).invoke(Integer.valueOf(paramInt));
      if (localObject != null) {
        if ((localObject instanceof BaseFinderFeed))
        {
          l = ((BaseFinderFeed)localObject).feedObject.getId();
          str = ((BaseFinderFeed)localObject).feedObject.getObjectNonceId();
          paramInt = this.tCE;
          bool = ((BaseFinderFeed)localObject).feedObject.isOldVersion();
          localObject = ((BaseFinderFeed)localObject).feedObject.getUserName();
        }
      }
    }
    label212:
    for (;;)
    {
      a(l, str, paramInt, bool, (String)localObject);
      do
      {
        AppMethodBeat.o(244556);
        return;
      } while (!(localObject instanceof bm));
      l = ((bm)localObject).getFeedObject().id;
      str = ((bm)localObject).getFeedObject().objectNonceId;
      paramInt = this.tCE;
      if (((bm)localObject).getFeedObject().secondaryShowFlag != 1) {}
      for (bool = true;; bool = false)
      {
        localObject = ((bm)localObject).getFeedObject().username;
        if (localObject != null) {
          break label212;
        }
        localObject = "";
        break;
      }
      AppMethodBeat.o(244556);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, kotlin.g.a.b<? super Integer, ? extends bo> paramb)
  {
    AppMethodBeat.i(244555);
    Log.i(this.TAG, "onAttach");
    this.tUO = paramb;
    this.scene = paramInt1;
    this.tCE = paramInt2;
    AppMethodBeat.o(244555);
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(244557);
    p.h(paramString2, "feedUsername");
    Object localObject1 = g.af(ad.class);
    p.g(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ad)localObject1).dxX())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable for 青少年模式");
      AppMethodBeat.o(244557);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (!com.tencent.mm.plugin.finder.storage.c.drQ())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(244557);
      return;
    }
    if (paramLong == 0L)
    {
      Log.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(244557);
      return;
    }
    if ((!Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.vGd.T(paramLong, 0L))) && (!Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.vGd.FG(paramLong))))
    {
      Log.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(244557);
      return;
    }
    if (this.tUP.contains(Long.valueOf(paramLong)))
    {
      Log.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(244557);
      return;
    }
    final z.f localf1 = new z.f();
    localf1.SYG = ((List)v.SXr);
    z.f localf2 = new z.f();
    localf2.SYG = ((List)v.SXr);
    localf1.SYG = ((PluginFinder)g.ah(PluginFinder.class)).getFinderActionStorage().Ft(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.SYG;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label346:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((an)localObject3).field_actionInfo.tuf != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label346;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.SYG = ((List)localObject1);
      localObject2 = (Iterable)localf1.SYG;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label452:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((an)localObject3).field_actionInfo.tuf == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label452;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.SYG = ((List)localObject1);
    }
    this.tUP.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = FinderReporterUIC.wzC;
    localObject1 = FinderReporterUIC.a.fH((Context)this.tUQ);
    if (localObject1 != null) {}
    for (localObject1 = ((FinderReporterUIC)localObject1).dIx();; localObject1 = null)
    {
      new af(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (bbn)localObject1, 3, 8160).aYI().h((com.tencent.mm.vending.c.a)new a(this, paramLong, localf2, localf1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(244557);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166034);
    p.h(paramb, "ev");
    if ((paramb instanceof h))
    {
      int k = ((h)paramb).tIy;
      int m = ((h)paramb).tIA;
      if (k > m)
      {
        AppMethodBeat.o(166034);
        return;
      }
      int j = ((h)paramb).tID;
      if (j <= m)
      {
        i = j;
        for (;;)
        {
          IM(i);
          if (i == m) {
            break;
          }
          i += 1;
        }
      }
      int i = j - 1;
      if (i >= k) {
        for (;;)
        {
          IM(i);
          if (i == k) {
            break;
          }
          i -= 1;
        }
      }
    }
    AppMethodBeat.o(166034);
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.event.base.c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166035);
    p.h(paramc, "dispatcher");
    p.h(paramb, "event");
    if ((paramb instanceof h))
    {
      if ((((h)paramb).type == 0) || (((h)paramb).type == 5) || (((h)paramb).type == 4))
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
  
  final he b(LinkedList<FinderCommentInfo> arg1, long paramLong)
  {
    AppMethodBeat.i(244558);
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)???;
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
      ???.add(com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject3, paramLong));
    }
    localList.addAll((Collection)???);
    ??? = (List)new ArrayList();
    localObject2 = (Iterable)localList;
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.hxH();
      }
      localObject3 = (s)localObject3;
      ???.add(localObject3);
      if ((((s)localObject3).uOf.field_actionInfo.tuf == 0L) && (((s)localObject3).uOf.dyb().levelTwoComment.size() > 0) && ((i >= localList.size() - 1) || (((s)localList.get(i + 1)).uOf.field_actionInfo.tuf == 0L)))
      {
        int k = ((s)localObject3).uOf.dyb().levelTwoComment.size();
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label376;
          }
          localObject4 = (FinderCommentInfo)((s)localObject3).uOf.dyb().levelTwoComment.remove();
          com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
          p.g(localObject4, "level2CommentInfo");
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject4, paramLong, ((s)localObject3).lT());
          if (((s)localObject4).uOf.dyj())
          {
            ((s)localObject4).uOe = true;
            ???.add(localObject4);
            i = j;
            break;
          }
          i += 1;
        }
      }
      label376:
      i = j;
    }
    Object localObject3 = new he();
    ((he)localObject3).dLG.feedId = paramLong;
    if (!Util.isNullOrNil(???))
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.data.f.vGd;
      localObject4 = (Iterable)???;
      ??? = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ???.add(((s)((Iterator)localObject4).next()).uOf);
      }
      localObject4 = (List)???;
      p.h(localObject4, "comments");
    }
    for (;;)
    {
      try
      {
        synchronized (com.tencent.mm.plugin.finder.storage.data.f.vGd)
        {
          com.tencent.mm.plugin.finder.storage.data.f.vGc.remove(new f.a(paramLong, 0L));
          com.tencent.mm.plugin.finder.storage.data.f.vGc.put(new f.a(paramLong, 0L), localObject4);
          Log.i(this.TAG, "add bullet subtitle cache succ, feedId: " + paramLong + ", size:" + localList.size());
          ((he)localObject3).dLG.dLH = false;
          AppMethodBeat.o(244558);
          return localObject3;
        }
        ((he)localObject3).dLG.dLH = true;
      }
      finally
      {
        AppMethodBeat.o(244558);
      }
    }
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(166036);
    this.tLP.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    Log.i(this.TAG, "onDetach");
    this.tUO = null;
    Iterator localIterator = ((Iterable)this.tLP).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.tLP.clear();
    this.tUP.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(d paramd, long paramLong, z.f paramf1, z.f paramf2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */