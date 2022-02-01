package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getCommentScene", "()I", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<c.b>, b<com.tencent.mm.vending.e.a>
{
  final int AJo;
  public final BaseFinderFeedLoader ALH;
  public c.b ATE;
  private k ATF;
  final MMActivity lzt;
  
  public c$a(MMActivity paramMMActivity, int paramInt, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.lzt = paramMMActivity;
    this.AJo = paramInt;
    this.ALH = paramBaseFinderFeedLoader;
    this.ATF = ((k)new k()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(363500);
        c.b localb = this.ATG.ATE;
        if (localb != null) {
          ((k)localb.ATx).onChanged();
        }
        AppMethodBeat.o(363500);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(363505);
        Object localObject = this.ATG.ATE;
        c.b localb;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          localb = this.ATG.ATE;
          if (localb != null) {
            break label62;
          }
        }
        label62:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(363505);
          return;
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(363510);
        Object localObject = this.ATG.ATE;
        c.b localb;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          localb = this.ATG.ATE;
          if (localb != null) {
            break label65;
          }
        }
        label65:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(363510);
          return;
        }
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(363516);
        Object localObject = this.ATG.ATE;
        c.b localb;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          localb = this.ATG.ATE;
          if (localb != null) {
            break label62;
          }
        }
        label62:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(363516);
          return;
        }
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(363520);
        Object localObject = this.ATG.ATE;
        c.b localb;
        if (localObject != null)
        {
          localObject = (k)((c.b)localObject).ATx;
          localb = this.ATG.ATE;
          if (localb != null) {
            break label81;
          }
        }
        label81:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject = this.ATG.ATE;
          if (localObject != null) {
            ((c.b)localObject).dUO();
          }
          AppMethodBeat.o(363520);
          return;
        }
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363491);
        s.u(paramAnonymousd, "reason");
        c.b localb = this.ATG.ATE;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishLoadMore(paramAnonymousd);
        }
        AppMethodBeat.o(363491);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363496);
        s.u(paramAnonymousd, "reason");
        c.b localb = this.ATG.ATE;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishLoadMoreSmooth(paramAnonymousd);
        }
        AppMethodBeat.o(363496);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(363487);
        s.u(paramAnonymousd, "reason");
        c.b localb = this.ATG.ATE;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishRefresh(paramAnonymousd);
        }
        AppMethodBeat.o(363487);
      }
    });
  }
  
  public void a(c.b paramb)
  {
    s.u(paramb, "callback");
    this.ATE = paramb;
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    k localk = ebJ();
    paramb = localk;
    if (localk == null) {
      paramb = this.ATF;
    }
    localBaseFinderFeedLoader.register(paramb);
    dUM();
  }
  
  public abstract void bXB();
  
  public abstract g dUK();
  
  public void dUL() {}
  
  public abstract void dUM();
  
  public k ebJ()
  {
    return null;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public final boolean onBackPressed()
  {
    Object localObject = this.ATE;
    s.checkNotNull(localObject);
    localObject = ((c.b)localObject).ebF();
    s.checkNotNull(localObject);
    if (((FinderLikeDrawer)localObject).fkp())
    {
      localObject = this.ATE;
      s.checkNotNull(localObject);
      localObject = ((c.b)localObject).ebF();
      s.checkNotNull(localObject);
      ((FinderLikeDrawer)localObject).fdh();
      return true;
    }
    return false;
  }
  
  public void onDetach()
  {
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    k localk2 = ebJ();
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = this.ATF;
    }
    localBaseFinderFeedLoader.unregister(localk1);
  }
  
  public void onUIPause() {}
  
  public void onUIResume() {}
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.a
 * JD-Core Version:    0.7.0.1
 */