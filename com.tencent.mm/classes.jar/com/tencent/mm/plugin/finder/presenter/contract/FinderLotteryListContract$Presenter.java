package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.convert.bb;
import com.tencent.mm.plugin.finder.convert.bc;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.d.b;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "canAnchorSendMsg2User", "", "getCanAnchorSendMsg2User", "()Z", "setCanAnchorSendMsg2User", "(Z)V", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLotteryId", "", "getObjectId", "", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
public final class FinderLotteryListContract$Presenter
  extends BaseFinderLotteryContract.Presenter
{
  public static final Companion zOw;
  public boolean zOv;
  
  static
  {
    AppMethodBeat.i(246925);
    zOw = new Companion((byte)0);
    AppMethodBeat.o(246925);
  }
  
  public FinderLotteryListContract$Presenter(FinderLiveLotteryListLoader paramFinderLiveLotteryListLoader)
  {
    super((BaseFeedLoader)paramFinderLiveLotteryListLoader);
    AppMethodBeat.i(246924);
    this.zOv = true;
    AppMethodBeat.o(246924);
  }
  
  public final void a(final BaseFinderLotteryContract.ViewCallback paramViewCallback)
  {
    AppMethodBeat.i(246922);
    p.k(paramViewCallback, "callback");
    super.a(paramViewCallback);
    BaseFeedLoader localBaseFeedLoader = this.zMw;
    Object localObject = localBaseFeedLoader;
    if (!(localBaseFeedLoader instanceof FinderLiveLotteryListLoader)) {
      localObject = null;
    }
    localObject = (FinderLiveLotteryListLoader)localObject;
    if (localObject != null) {
      ((FinderLiveLotteryListLoader)localObject).fetchEndCallback = ((b)new q(paramViewCallback) {});
    }
    paramViewCallback = this.zMv;
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
            private final HashSet<Long> xlV;
            
            public final void b(View paramAnonymousView, List<? extends RecyclerView.v> paramAnonymousList)
            {
              AppMethodBeat.i(271897);
              p.k(paramAnonymousView, "parent");
              p.k(paramAnonymousList, "exposedHolders");
              Iterator localIterator = ((Iterable)paramAnonymousList).iterator();
              while (localIterator.hasNext())
              {
                paramAnonymousView = (RecyclerView.v)localIterator.next();
                if ((paramAnonymousView instanceof i))
                {
                  Object localObject = ((i)paramAnonymousView).ihX();
                  if (((localObject instanceof as)) && (!this.xlV.contains(Long.valueOf(((as)localObject).hashCode()))))
                  {
                    paramAnonymousView = d.zUg;
                    d.b localb = d.dPh();
                    String str = z.bdh();
                    p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
                    paramAnonymousList = ((as)localObject).zAU.username;
                    paramAnonymousView = paramAnonymousList;
                    if (paramAnonymousList == null) {
                      paramAnonymousView = "";
                    }
                    localb.ae(str, paramAnonymousView, "");
                    paramAnonymousView = d.zUg;
                    paramAnonymousList = d.dPh();
                    paramAnonymousView = aj.Bnu;
                    paramAnonymousView = this.zOx.zMv;
                    if (paramAnonymousView == null) {
                      p.iCn();
                    }
                    paramAnonymousView = aj.a.fZ((Context)paramAnonymousView.activity);
                    if (paramAnonymousView != null) {}
                    for (paramAnonymousView = paramAnonymousView.ekY();; paramAnonymousView = null)
                    {
                      paramAnonymousList.a(paramAnonymousView, 4L);
                      this.xlV.add(Long.valueOf(((as)localObject).hashCode()));
                      break;
                    }
                  }
                }
              }
              AppMethodBeat.o(271897);
            }
            
            public final boolean dpC()
            {
              return true;
            }
          });
          AppMethodBeat.o(246922);
          return;
        }
      }
    }
    AppMethodBeat.o(246922);
  }
  
  public final WxRecyclerAdapter<bu> dMR()
  {
    AppMethodBeat.i(246919);
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new com.tencent.mm.view.recyclerview.f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(221727);
        if (paramAnonymousInt == at.class.hashCode())
        {
          locale = (e)new bc();
          AppMethodBeat.o(221727);
          return locale;
        }
        e locale = (e)new bb(this.zOx);
        AppMethodBeat.o(221727);
        return locale;
      }
    }, cRP());
    AppMethodBeat.o(246919);
    return localWxRecyclerAdapter;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract.Presenter
 * JD-Core Version:    0.7.0.1
 */