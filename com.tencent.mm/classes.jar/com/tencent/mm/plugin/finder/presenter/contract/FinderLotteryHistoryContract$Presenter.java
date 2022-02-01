package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "anchorUsername", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "(IJJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "getAnchorUsername", "()Ljava/lang/String;", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "getScene", "()I", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
public final class FinderLotteryHistoryContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion uYc;
  final long hFK;
  final String hwd;
  final long liveId;
  final String objectNonceId;
  final int scene;
  
  static
  {
    AppMethodBeat.i(249863);
    uYc = new Companion((byte)0);
    AppMethodBeat.o(249863);
  }
  
  public FinderLotteryHistoryContract$Presenter(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, FinderLiveLotteryHistoryLoader paramFinderLiveLotteryHistoryLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryHistoryLoader);
    AppMethodBeat.i(249862);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.hFK = paramLong2;
    this.objectNonceId = paramString1;
    this.hwd = paramString2;
    AppMethodBeat.o(249862);
  }
  
  public final void a(final BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(249860);
    p.h(paramViewCallback, "callback");
    super.a(paramViewCallback);
    Object localObject2 = this.uWg;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof FinderLiveLotteryHistoryLoader)) {
      localObject1 = null;
    }
    localObject1 = (FinderLiveLotteryHistoryLoader)localObject1;
    if (localObject1 != null)
    {
      localObject2 = paramViewCallback.activity.getIntent();
      p.g(localObject2, "callback.getActivity().intent");
      ((FinderLiveLotteryHistoryLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderLiveLotteryHistoryLoader)localObject1).fetchEndCallback = ((b)new q((FinderLiveLotteryHistoryLoader)localObject1) {});
      AppMethodBeat.o(249860);
      return;
    }
    AppMethodBeat.o(249860);
  }
  
  public final WxRecyclerAdapter<bo> dlN()
  {
    AppMethodBeat.i(249859);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((f)new FinderLotteryHistoryContract.Presenter.generateAdapter.1(), cDk());
    localWxRecyclerAdapter.RqP = ((g.c)new g.c() {});
    AppMethodBeat.o(249859);
    return localWxRecyclerAdapter;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */