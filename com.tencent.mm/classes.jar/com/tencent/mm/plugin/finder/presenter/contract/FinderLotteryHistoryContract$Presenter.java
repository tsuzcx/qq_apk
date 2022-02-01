package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ay;
import com.tencent.mm.plugin.finder.convert.az;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "anchorUsername", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "(IJJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "getAnchorUsername", "()Ljava/lang/String;", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "getScene", "()I", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
public final class FinderLotteryHistoryContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion zOq;
  final String kig;
  final long liveId;
  final String objectNonceId;
  final int scene;
  final long xbk;
  
  static
  {
    AppMethodBeat.i(243028);
    zOq = new Companion((byte)0);
    AppMethodBeat.o(243028);
  }
  
  public FinderLotteryHistoryContract$Presenter(int paramInt, long paramLong1, long paramLong2, String paramString1, String paramString2, FinderLiveLotteryHistoryLoader paramFinderLiveLotteryHistoryLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryHistoryLoader);
    AppMethodBeat.i(243027);
    this.scene = paramInt;
    this.liveId = paramLong1;
    this.xbk = paramLong2;
    this.objectNonceId = paramString1;
    this.kig = paramString2;
    AppMethodBeat.o(243027);
  }
  
  public final void a(final BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(243023);
    p.k(paramViewCallback, "callback");
    super.a(paramViewCallback);
    Object localObject2 = this.zMw;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof FinderLiveLotteryHistoryLoader)) {
      localObject1 = null;
    }
    localObject1 = (FinderLiveLotteryHistoryLoader)localObject1;
    if (localObject1 != null)
    {
      localObject2 = paramViewCallback.activity.getIntent();
      p.j(localObject2, "callback.getActivity().intent");
      ((FinderLiveLotteryHistoryLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderLiveLotteryHistoryLoader)localObject1).fetchEndCallback = ((b)new q((FinderLiveLotteryHistoryLoader)localObject1) {});
      AppMethodBeat.o(243023);
      return;
    }
    AppMethodBeat.o(243023);
  }
  
  public final WxRecyclerAdapter<bu> dMR()
  {
    AppMethodBeat.i(243021);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((f)new f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(220832);
        if (paramAnonymousInt == aq.class.hashCode())
        {
          locale = (e)new az();
          AppMethodBeat.o(220832);
          return locale;
        }
        e locale = (e)new ay();
        AppMethodBeat.o(220832);
        return locale;
      }
    }, cRP());
    localWxRecyclerAdapter.YSn = ((h.c)new h.c() {});
    AppMethodBeat.o(243021);
    return localWxRecyclerAdapter;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract.Presenter
 * JD-Core Version:    0.7.0.1
 */