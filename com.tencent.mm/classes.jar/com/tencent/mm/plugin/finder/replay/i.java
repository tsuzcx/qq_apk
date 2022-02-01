package com.tencent.mm.plugin.finder.replay;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.loader.FinderLivePurchaseListLoader;
import com.tencent.mm.plugin.finder.live.loader.FinderProfileLiveUserPageLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPresenter;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayContract$Presenter;", "context", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "(Landroid/app/Activity;Landroid/content/Intent;)V", "getContext", "()Landroid/app/Activity;", "feedChangeListener", "com/tencent/mm/plugin/finder/replay/FinderLiveReplayPresenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPresenter$feedChangeListener$1;", "getIntent", "()Landroid/content/Intent;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "viewCallback", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayContract$ViewCallback;", "initData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/ArrayList;", "loadMoreData", "", "onAttach", "callback", "onDetach", "restart", "liveId", "", "updateFinderLiveDataList", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "prefix", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements f.a
{
  public static final i.a Fkp;
  private BaseFeedLoader<cc> CNJ;
  f.b Fkq;
  private final FinderLiveReplayPresenter.feedChangeListener.1 Fkr;
  private final Activity hHU;
  private final Intent intent;
  
  static
  {
    AppMethodBeat.i(332637);
    Fkp = new i.a((byte)0);
    AppMethodBeat.o(332637);
  }
  
  public i(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(332620);
    this.hHU = paramActivity;
    this.intent = paramIntent;
    this.Fkr = new FinderLiveReplayPresenter.feedChangeListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(332620);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(332646);
    s.u(paramb, "callback");
    int i = this.intent.getIntExtra("KEY_PARAMS_SOURCE_TYPE", 0);
    switch (i)
    {
    }
    for (;;)
    {
      this.Fkq = paramb;
      this.Fkr.alive();
      Log.i("FinderLiveReplayPresenter", s.X("init sourceType:", Integer.valueOf(i)));
      AppMethodBeat.o(332646);
      return;
      Object localObject1 = new FinderLivePurchaseListLoader();
      ((FinderLivePurchaseListLoader)localObject1).fetchEndCallback = ((b)new b(this));
      Object localObject2 = ah.aiuX;
      this.CNJ = ((BaseFeedLoader)localObject1);
      localObject1 = this.CNJ;
      if (localObject1 != null)
      {
        ((BaseFeedLoader)localObject1).register(paramb.ecd());
        continue;
        localObject2 = this.intent.getStringExtra("finder_username");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = z.bAW();
        s.s(localObject2, "getMyFinderUsername()");
        localObject1 = new FinderProfileLiveUserPageLoader((String)localObject1, (String)localObject2, null);
        ((FinderProfileLiveUserPageLoader)localObject1).fetchEndCallback = ((b)new c(this));
        localObject2 = ah.aiuX;
        this.CNJ = ((BaseFeedLoader)localObject1);
        localObject1 = this.CNJ;
        if (localObject1 != null) {
          ((BaseFeedLoader)localObject1).register(paramb.ecd());
        }
      }
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(332682);
    BaseFeedLoader localBaseFeedLoader = this.CNJ;
    if (localBaseFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default(localBaseFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(332682);
  }
  
  public final ArrayList<com.tencent.mm.plugin.finder.live.viewmodel.data.f> eLv()
  {
    boolean bool = false;
    AppMethodBeat.i(332674);
    Object localObject2 = this.intent.getByteArrayExtra("KEY_PARAMS_KEY_VALUE");
    int i;
    label60:
    long l1;
    label93:
    long l2;
    if (localObject2 == null)
    {
      localObject1 = null;
      localObject2 = com.tencent.mm.plugin.finder.replay.model.c.FlS;
      if (localObject1 == null) {
        break label302;
      }
      int j = ((bug)localObject1).aabZ;
      if (j < 0) {
        break label297;
      }
      if (j >= ((bug)localObject1).ZIQ.size()) {
        break label292;
      }
      i = 1;
      if (i == 0) {
        break label302;
      }
      localObject2 = ((FinderObject)((bug)localObject1).ZIQ.get(j)).liveInfo;
      if (localObject2 == null) {
        break label302;
      }
      l1 = ((bip)localObject2).liveId;
      localObject2 = (com.tencent.mm.plugin.finder.replay.viewmodel.c)k.Fky.eLF().business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class);
      if (localObject2 != null) {
        break label308;
      }
      l2 = 0L;
      label118:
      if ((localObject1 == null) || (l1 == 0L) || (l1 == l2)) {
        break label321;
      }
      k.Fky.eLF().a(l2, (bug)localObject1, false);
      label152:
      localObject1 = k.Fky.eLF().Fkz;
      if (localObject1 == null) {
        break label350;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.replay.model.c)localObject1).Ebx;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty() != true)) {
        break label350;
      }
      i = 1;
      label191:
      if (i == 0) {
        break label355;
      }
      Log.e("FinderLiveReplayPresenter", "replay_step2:loadData prepareData error,data is empty!");
      this.hHU.finish();
      localObject1 = k.Fky.eLF().Fkz;
      if (localObject1 != null) {
        break label557;
      }
    }
    label292:
    label297:
    label557:
    for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.replay.model.c)localObject1).Ebx)
    {
      if (localObject1 != null) {
        break label567;
      }
      localObject1 = new ArrayList();
      AppMethodBeat.o(332674);
      return localObject1;
      localObject1 = new bug();
      ((bug)localObject1).parseFrom((byte[])localObject2);
      localObject2 = this.CNJ;
      if (localObject2 != null) {
        ((BaseFeedLoader)localObject2).setLastBuffer(((bug)localObject1).ZEQ);
      }
      break;
      i = 0;
      break label60;
      i = 0;
      break label60;
      label302:
      l1 = 0L;
      break label93;
      label308:
      l2 = ((com.tencent.mm.plugin.finder.replay.viewmodel.c)localObject2).getLiveInfo().liveId;
      break label118;
      label321:
      if (l2 == 0L) {
        break label152;
      }
      k.Fky.eLF().a(l2, new bug(), true);
      break label152;
      label350:
      i = 0;
      break label191;
      label355:
      localObject1 = k.Fky.eLF().Fkz;
      if (localObject1 == null)
      {
        i = 0;
        label373:
        localObject1 = k.Fky.eLF().Fkz;
        if (localObject1 != null) {
          break label522;
        }
        localObject1 = null;
        localObject2 = new StringBuilder("replay_step2:loadData finish,initPos:").append(i).append(",hasMore:");
        if ((localObject1 == null) || (((bug)localObject1).BeA != 0)) {
          break label532;
        }
        i = 1;
        label429:
        if (i == 0) {
          bool = true;
        }
        Object localObject3 = ((StringBuilder)localObject2).append(bool).append(",lastBuffer:");
        if (localObject1 != null) {
          break label537;
        }
        localObject2 = null;
        label457:
        localObject2 = ((StringBuilder)localObject3).append(localObject2).append(',');
        localObject3 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
        if (localObject1 != null) {
          break label547;
        }
      }
      for (localObject1 = null;; localObject1 = ((bug)localObject1).ZIQ)
      {
        Log.i("FinderLiveReplayPresenter", com.tencent.mm.plugin.finder.live.view.convert.a.gK((List)localObject1) + '!');
        break;
        i = ((com.tencent.mm.plugin.finder.replay.model.c)localObject1).CEY;
        break label373;
        localObject1 = ((com.tencent.mm.plugin.finder.replay.model.c)localObject1).FlT;
        break label392;
        i = 0;
        break label429;
        localObject2 = ((bug)localObject1).ZEQ;
        break label457;
      }
    }
    label392:
    label522:
    label532:
    label537:
    label547:
    label567:
    AppMethodBeat.o(332674);
    return localObject1;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(332652);
    Object localObject = this.Fkq;
    if (localObject != null)
    {
      localObject = ((f.b)localObject).ecd();
      if (localObject != null)
      {
        BaseFeedLoader localBaseFeedLoader = this.CNJ;
        if (localBaseFeedLoader != null) {
          localBaseFeedLoader.unregister((com.tencent.mm.view.k)localObject);
        }
      }
    }
    this.Fkr.dead();
    AppMethodBeat.o(332652);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<IResponse<cc>, ah>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<IResponse<cc>, ah>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(IResponse<cc> paramIResponse, String paramString, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.i
 * JD-Core Version:    0.7.0.1
 */