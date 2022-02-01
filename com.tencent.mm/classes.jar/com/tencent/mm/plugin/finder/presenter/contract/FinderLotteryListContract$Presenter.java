package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.ay;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.f.b;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "canAnchorSendMsg2User", "", "getCanAnchorSendMsg2User", "()Z", "setCanAnchorSendMsg2User", "(Z)V", "isAssistant", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLotteryId", "", "getObjectId", "", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLotteryListContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion EZe;
  public final boolean DUe;
  public boolean EZf;
  
  static
  {
    AppMethodBeat.i(343712);
    EZe = new Companion((byte)0);
    AppMethodBeat.o(343712);
  }
  
  public FinderLotteryListContract$Presenter(FinderLiveLotteryListLoader paramFinderLiveLotteryListLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryListLoader);
    AppMethodBeat.i(343706);
    this.EZf = true;
    paramFinderLiveLotteryListLoader = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    paramFinderLiveLotteryListLoader = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (paramFinderLiveLotteryListLoader != null)
    {
      paramFinderLiveLotteryListLoader = (e)paramFinderLiveLotteryListLoader.business(e.class);
      if ((paramFinderLiveLotteryListLoader == null) || (paramFinderLiveLotteryListLoader.DUe != true)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      this.DUe = bool;
      AppMethodBeat.o(343706);
      return;
    }
  }
  
  public final void a(final BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(343727);
    s.u(paramViewCallback, "callback");
    super.a(paramViewCallback);
    Object localObject = this.CNJ;
    if ((localObject instanceof FinderLiveLotteryListLoader)) {}
    for (localObject = (FinderLiveLotteryListLoader)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((FinderLiveLotteryListLoader)localObject).fetchEndCallback = ((b)new u(paramViewCallback) {});
      }
      paramViewCallback = this.EXq;
      if (paramViewCallback != null)
      {
        paramViewCallback = paramViewCallback.getRlLayout();
        if (paramViewCallback != null)
        {
          paramViewCallback = paramViewCallback.getRecyclerView();
          if (paramViewCallback != null) {
            com.tencent.mm.view.f.a(paramViewCallback, (e.a)new e.a()
            {
              private final HashSet<Long> AKl;
              
              public final void b(View paramAnonymousView, List<? extends RecyclerView.v> paramAnonymousList)
              {
                AppMethodBeat.i(343667);
                s.u(paramAnonymousView, "parent");
                s.u(paramAnonymousList, "exposedHolders");
                paramAnonymousView = (Iterable)paramAnonymousList;
                FinderLotteryListContract.Presenter localPresenter = this.EZg;
                Iterator localIterator = paramAnonymousView.iterator();
                while (localIterator.hasNext())
                {
                  paramAnonymousView = (RecyclerView.v)localIterator.next();
                  if ((paramAnonymousView instanceof j))
                  {
                    Object localObject1 = ((j)paramAnonymousView).CSA;
                    if (((localObject1 instanceof aw)) && (!this.AKl.contains(Long.valueOf(((aw)localObject1).hashCode()))))
                    {
                      paramAnonymousView = com.tencent.mm.plugin.finder.report.f.FnM;
                      Object localObject2 = com.tencent.mm.plugin.finder.report.f.eMn();
                      String str = z.bAW();
                      s.s(str, "getMyFinderUsername()");
                      paramAnonymousList = ((aw)localObject1).EDj.username;
                      paramAnonymousView = paramAnonymousList;
                      if (paramAnonymousList == null) {
                        paramAnonymousView = "";
                      }
                      ((f.b)localObject2).ak(str, paramAnonymousView, "");
                      paramAnonymousView = com.tencent.mm.plugin.finder.report.f.FnM;
                      paramAnonymousList = com.tencent.mm.plugin.finder.report.f.eMn();
                      paramAnonymousView = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
                      localObject2 = localPresenter.EXq;
                      s.checkNotNull(localObject2);
                      paramAnonymousView = paramAnonymousView.el((Context)((BaseFinderLotteryContract.ViewCallback)localObject2).activity);
                      if (paramAnonymousView == null) {}
                      for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.fou())
                      {
                        f.b.a(paramAnonymousList, paramAnonymousView, 4L);
                        this.AKl.add(Long.valueOf(((aw)localObject1).hashCode()));
                        break;
                      }
                    }
                  }
                }
                AppMethodBeat.o(343667);
              }
              
              public final boolean dXG()
              {
                return true;
              }
            });
          }
        }
      }
      AppMethodBeat.o(343727);
      return;
    }
  }
  
  public final WxRecyclerAdapter<cc> eHW()
  {
    AppMethodBeat.i(343720);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((g)new g()
    {
      public final com.tencent.mm.view.recyclerview.f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(343662);
        if (paramAnonymousInt == com.tencent.mm.plugin.finder.model.ax.class.hashCode())
        {
          localf = (com.tencent.mm.view.recyclerview.f)new ay();
          AppMethodBeat.o(343662);
          return localf;
        }
        com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.ax(this.EZg);
        AppMethodBeat.o(343662);
        return localf;
      }
    }, dwi());
    AppMethodBeat.o(343720);
    return localWxRecyclerAdapter;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter
 * JD-Core Version:    0.7.0.1
 */