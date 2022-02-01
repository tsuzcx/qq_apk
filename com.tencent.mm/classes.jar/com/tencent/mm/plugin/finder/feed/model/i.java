package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.bid;
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
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "getData", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visiblePosition", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lifeCycleKeeperStore", "Ljava/util/concurrent/CopyOnWriteArraySet;", "loadingList", "Ljava/util/Vector;", "", "scene", "cacheLevel2FirstAuthorComment", "Lcom/tencent/mm/autogen/events/FeedBulletSubtitleNotifyEvent;", "barrageCommentInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "feedId", "expandTopLevel2Comment", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "respList", "filterComment", "data", "itemList", "", "getFeedByPosToLoad", "", "pos", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "keep", "p0", "mergeLocalLevel2Comments", "localLevel2Comments", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "onAttach", "onDetach", "onEventHappen", "ev", "preloadComment", "objectNonceId", "oldVersion", "feedUsername", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullScene", "preloadFirstPageComment", "preloadNextPageComment", "lastBuf", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.plugin.finder.event.base.d
  implements com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a>
{
  private final String TAG;
  private int scene;
  private kotlin.g.a.b<? super Integer, ? extends bu> xGo;
  private Vector<Long> xGp;
  private final AppCompatActivity xGq;
  private int xkX;
  private final CopyOnWriteArraySet<com.tencent.mm.vending.e.a> xvE;
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    AppMethodBeat.i(288970);
    this.xGq = paramAppCompatActivity;
    this.TAG = "Finder.FinderCommentPreloader";
    this.xvE = new CopyOnWriteArraySet();
    this.scene = 2;
    this.xGp = new Vector();
    AppMethodBeat.o(288970);
  }
  
  private final hl b(LinkedList<FinderCommentInfo> arg1, long paramLong)
  {
    AppMethodBeat.i(288969);
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)???;
    ??? = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderCommentInfo)((Iterator)localObject2).next();
      localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.AnH;
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
        j.iBO();
      }
      localObject3 = (s)localObject3;
      ???.add(localObject3);
      if ((((s)localObject3).zAt.field_actionInfo.xbP == 0L) && (((s)localObject3).zAt.dYY().levelTwoComment.size() > 0) && ((i >= localList.size() - 1) || (((s)localList.get(i + 1)).zAt.field_actionInfo.xbP == 0L)))
      {
        int k = ((s)localObject3).zAt.dYY().levelTwoComment.size();
        i = 0;
        for (;;)
        {
          if (i >= k) {
            break label376;
          }
          localObject4 = (FinderCommentInfo)((s)localObject3).zAt.dYY().levelTwoComment.remove();
          com.tencent.mm.plugin.finder.storage.logic.a locala = com.tencent.mm.plugin.finder.storage.logic.a.AnH;
          p.j(localObject4, "level2CommentInfo");
          localObject4 = com.tencent.mm.plugin.finder.storage.logic.a.b((FinderCommentInfo)localObject4, paramLong, ((s)localObject3).mf());
          if (((s)localObject4).zAt.dZg())
          {
            ((s)localObject4).zAs = true;
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
    Object localObject3 = new hl();
    ((hl)localObject3).fEv.feedId = paramLong;
    if (!Util.isNullOrNil(???))
    {
      localObject2 = com.tencent.mm.plugin.finder.storage.data.f.Anc;
      localObject4 = (Iterable)???;
      ??? = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ???.add(((s)((Iterator)localObject4).next()).zAt);
      }
      localObject4 = (List)???;
      p.k(localObject4, "comments");
    }
    for (;;)
    {
      try
      {
        synchronized (com.tencent.mm.plugin.finder.storage.data.f.Anc)
        {
          com.tencent.mm.plugin.finder.storage.data.f.Anb.remove(new f.a(paramLong, 0L));
          com.tencent.mm.plugin.finder.storage.data.f.Anb.put(new f.a(paramLong, 0L), localObject4);
          Log.i(this.TAG, "add bullet subtitle cache succ, feedId: " + paramLong + ", size:" + localList.size());
          ((hl)localObject3).fEv.fEw = false;
          AppMethodBeat.o(288969);
          return localObject3;
        }
        ((hl)localObject3).fEv.fEw = true;
      }
      finally
      {
        AppMethodBeat.o(288969);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, kotlin.g.a.b<? super Integer, ? extends bu> paramb)
  {
    AppMethodBeat.i(288967);
    Log.i(this.TAG, "onAttach");
    this.xGo = paramb;
    this.scene = paramInt1;
    this.xkX = paramInt2;
    AppMethodBeat.o(288967);
  }
  
  public final void a(final long paramLong, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(288968);
    p.k(paramString2, "feedUsername");
    Object localObject1 = com.tencent.mm.kernel.h.ae(ae.class);
    p.j(localObject1, "MMKernel.service(IFinder…enModeConfig::class.java)");
    if (((ae)localObject1).dYT())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable for 青少年模式");
      AppMethodBeat.o(288968);
      return;
    }
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (!com.tencent.mm.plugin.finder.storage.d.dTg())
    {
      Log.i(this.TAG, "***preloadFirstPageComment disable");
      AppMethodBeat.o(288968);
      return;
    }
    if (paramLong == 0L)
    {
      Log.i(this.TAG, "***preloadFirstPageComment feedId is 0");
      AppMethodBeat.o(288968);
      return;
    }
    if ((!Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.Anc.Y(paramLong, 0L))) && (!Util.isNullOrNil(com.tencent.mm.plugin.finder.storage.data.f.Anc.MO(paramLong))))
    {
      Log.i(this.TAG, "***preloadFirstPageComment has cache");
      AppMethodBeat.o(288968);
      return;
    }
    if (this.xGp.contains(Long.valueOf(paramLong)))
    {
      Log.i(this.TAG, "***preloadFirstPageComment is loading");
      AppMethodBeat.o(288968);
      return;
    }
    final aa.f localf1 = new aa.f();
    localf1.aaBC = ((List)v.aaAd);
    aa.f localf2 = new aa.f();
    localf2.aaBC = ((List)v.aaAd);
    localf1.aaBC = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFinderActionStorage().MC(paramLong);
    if (!paramBoolean)
    {
      Object localObject2 = (Iterable)localf1.aaBC;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      label346:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((am)localObject3).field_actionInfo.xbP != 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label346;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf2.aaBC = ((List)localObject1);
      localObject2 = (Iterable)localf1.aaBC;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label452:
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((am)localObject3).field_actionInfo.xbP == 0L) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label452;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      localf1.aaBC = ((List)localObject1);
    }
    this.xGp.add(Long.valueOf(paramLong));
    int i = this.scene;
    localObject1 = aj.Bnu;
    localObject1 = aj.a.fZ((Context)this.xGq);
    if (localObject1 != null) {}
    for (localObject1 = ((aj)localObject1).ekY();; localObject1 = null)
    {
      new ag(paramLong, paramString1, paramInt, i, paramString2, false, null, null, 0L, null, false, false, null, (bid)localObject1, 3, null, 40928).bhW().h((com.tencent.mm.vending.c.a)new a(this, paramLong, localf2, localf1)).a((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(288968);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166034);
    p.k(paramb, "ev");
    int i;
    long l;
    String str;
    boolean bool;
    if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
    {
      i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrm;
      if (i < 0)
      {
        AppMethodBeat.o(166034);
        return;
      }
      paramb = this.xGo;
      if (paramb != null)
      {
        paramb = (bu)paramb.invoke(Integer.valueOf(i));
        if (paramb != null) {
          if ((paramb instanceof BaseFinderFeed))
          {
            l = ((BaseFinderFeed)paramb).feedObject.getId();
            str = ((BaseFinderFeed)paramb).feedObject.getObjectNonceId();
            i = this.xkX;
            bool = ((BaseFinderFeed)paramb).feedObject.isOldVersion();
            paramb = ((BaseFinderFeed)paramb).feedObject.getUserName();
          }
        }
      }
    }
    label229:
    for (;;)
    {
      a(l, str, i, bool, paramb);
      do
      {
        AppMethodBeat.o(166034);
        return;
      } while (!(paramb instanceof bs));
      l = ((bs)paramb).getFeedObject().id;
      str = ((bs)paramb).getFeedObject().objectNonceId;
      i = this.xkX;
      if (((bs)paramb).getFeedObject().secondaryShowFlag != 1) {}
      for (bool = true;; bool = false)
      {
        paramb = ((bs)paramb).getFeedObject().username;
        if (paramb != null) {
          break label229;
        }
        paramb = "";
        break;
      }
      AppMethodBeat.o(166034);
      return;
    }
  }
  
  public final boolean a(c paramc, com.tencent.mm.plugin.finder.event.base.b paramb)
  {
    AppMethodBeat.i(166035);
    p.k(paramc, "dispatcher");
    p.k(paramb, "event");
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
    this.xvE.add(parama);
    AppMethodBeat.o(166036);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(166033);
    Log.i(this.TAG, "onDetach");
    this.xGo = null;
    Iterator localIterator = ((Iterable)this.xvE).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.vending.e.a)localIterator.next()).dead();
    }
    this.xvE.clear();
    this.xGp.clear();
    AppMethodBeat.o(166033);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(i parami, long paramLong, aa.f paramf1, aa.f paramf2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.i
 * JD-Core Version:    0.7.0.1
 */