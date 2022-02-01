package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.az;
import com.tencent.mm.plugin.finder.convert.ba;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.aq;
import com.tencent.mm.plugin.finder.model.ar;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "canAnchorSendMsg2User", "", "getCanAnchorSendMsg2User", "()Z", "setCanAnchorSendMsg2User", "(Z)V", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLotteryId", "", "getObjectId", "", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
public final class FinderLotteryListContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion uYi;
  public boolean uYh;
  
  static
  {
    AppMethodBeat.i(249875);
    uYi = new Companion((byte)0);
    AppMethodBeat.o(249875);
  }
  
  public FinderLotteryListContract$Presenter(FinderLiveLotteryListLoader paramFinderLiveLotteryListLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryListLoader);
    AppMethodBeat.i(249874);
    this.uYh = true;
    AppMethodBeat.o(249874);
  }
  
  public final void a(final BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(249872);
    p.h(paramViewCallback, "callback");
    super.a(paramViewCallback);
    BaseFeedLoader localBaseFeedLoader = this.uWg;
    Object localObject = localBaseFeedLoader;
    if (!(localBaseFeedLoader instanceof FinderLiveLotteryListLoader)) {
      localObject = null;
    }
    localObject = (FinderLiveLotteryListLoader)localObject;
    if (localObject != null) {
      ((FinderLiveLotteryListLoader)localObject).fetchEndCallback = ((b)new q(paramViewCallback) {});
    }
    paramViewCallback = this.uWf;
    if (paramViewCallback != null)
    {
      paramViewCallback = paramViewCallback.getRlLayout();
      if (paramViewCallback != null)
      {
        paramViewCallback = paramViewCallback.getRecyclerView();
        if (paramViewCallback != null)
        {
          com.tencent.mm.view.f.a(paramViewCallback, (e.a)new e.a()
          {
            private final HashSet<Long> tDu;
            
            public final void b(View paramAnonymousView, List<? extends RecyclerView.v> paramAnonymousList)
            {
              AppMethodBeat.i(249869);
              p.h(paramAnonymousView, "parent");
              p.h(paramAnonymousList, "exposedHolders");
              Iterator localIterator = ((Iterable)paramAnonymousList).iterator();
              while (localIterator.hasNext())
              {
                paramAnonymousView = (RecyclerView.v)localIterator.next();
                if ((paramAnonymousView instanceof h))
                {
                  Object localObject = ((h)paramAnonymousView).hgv();
                  if (((localObject instanceof aq)) && (!this.tDu.contains(Long.valueOf(((aq)localObject).hashCode()))))
                  {
                    paramAnonymousView = d.vdp;
                    d.b localb = d.dnK();
                    String str = z.aUg();
                    p.g(str, "ConfigStorageLogic.getMyFinderUsername()");
                    paramAnonymousList = ((aq)localObject).uOC.username;
                    paramAnonymousView = paramAnonymousList;
                    if (paramAnonymousList == null) {
                      paramAnonymousView = "";
                    }
                    localb.ah(str, paramAnonymousView, "");
                    paramAnonymousView = d.vdp;
                    paramAnonymousList = d.dnK();
                    paramAnonymousView = FinderReporterUIC.wzC;
                    paramAnonymousView = this.uYj.uWf;
                    if (paramAnonymousView == null) {
                      p.hyc();
                    }
                    paramAnonymousView = FinderReporterUIC.a.fH((Context)paramAnonymousView.activity);
                    if (paramAnonymousView != null) {}
                    for (paramAnonymousView = paramAnonymousView.dIx();; paramAnonymousView = null)
                    {
                      paramAnonymousList.a(paramAnonymousView, 4L);
                      this.tDu.add(Long.valueOf(((aq)localObject).hashCode()));
                      break;
                    }
                  }
                }
              }
              AppMethodBeat.o(249869);
            }
          });
          AppMethodBeat.o(249872);
          return;
        }
      }
    }
    AppMethodBeat.o(249872);
  }
  
  public final WxRecyclerAdapter<bo> dlN()
  {
    AppMethodBeat.i(249871);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new com.tencent.mm.view.recyclerview.f()
    {
      public final e<?> EC(int paramAnonymousInt)
      {
        AppMethodBeat.i(249866);
        if (paramAnonymousInt == ar.class.hashCode())
        {
          locale = (e)new ba();
          AppMethodBeat.o(249866);
          return locale;
        }
        e locale = (e)new az(this.uYj);
        AppMethodBeat.o(249866);
        return locale;
      }
    }, cDk());
    AppMethodBeat.o(249871);
    return localWxRecyclerAdapter;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter
 * JD-Core Version:    0.7.0.1
 */