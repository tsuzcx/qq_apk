package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.av;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "anchorUsername", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "(IJJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "getAnchorUsername", "()Ljava/lang/String;", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "getScene", "()I", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLotteryHistoryContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion EZa;
  final long hKN;
  final long liveId;
  final String mIC;
  final String objectNonceId;
  final int scene;
  
  static
  {
    AppMethodBeat.i(343501);
    EZa = new Companion((byte)0);
    AppMethodBeat.o(343501);
  }
  
  public FinderLotteryHistoryContract$Presenter(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, FinderLiveLotteryHistoryLoader paramFinderLiveLotteryHistoryLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryHistoryLoader);
    AppMethodBeat.i(343496);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.hKN = paramLong2;
    this.objectNonceId = paramString1;
    this.mIC = paramString2;
    AppMethodBeat.o(343496);
  }
  
  public final void a(BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(343516);
    s.u(paramViewCallback, "callback");
    super.a(paramViewCallback);
    Object localObject = this.CNJ;
    if ((localObject instanceof FinderLiveLotteryHistoryLoader)) {}
    for (localObject = (FinderLiveLotteryHistoryLoader)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        paramViewCallback = paramViewCallback.activity.getIntent();
        s.s(paramViewCallback, "callback.getActivity().intent");
        ((FinderLiveLotteryHistoryLoader)localObject).initFromCache(paramViewCallback);
        ((FinderLiveLotteryHistoryLoader)localObject).fetchEndCallback = ((b)new u((FinderLiveLotteryHistoryLoader)localObject) {});
      }
      AppMethodBeat.o(343516);
      return;
    }
  }
  
  public final WxRecyclerAdapter<cc> eHW()
  {
    AppMethodBeat.i(343507);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((g)new g()
    {
      public final f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(343651);
        if (paramAnonymousInt == com.tencent.mm.plugin.finder.model.au.class.hashCode())
        {
          localf = (f)new av();
          AppMethodBeat.o(343651);
          return localf;
        }
        f localf = (f)new com.tencent.mm.plugin.finder.convert.au();
        AppMethodBeat.o(343651);
        return localf;
      }
    }, dwi());
    localWxRecyclerAdapter.agOe = ((i.c)new i.c() {});
    AppMethodBeat.o(343507);
    return localWxRecyclerAdapter;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */