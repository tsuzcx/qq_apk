package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class c$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<c.b>, b<com.tencent.mm.vending.e.a>
{
  final MMActivity iMV;
  public c.b rgf;
  private com.tencent.mm.view.d rgg;
  final BaseFinderFeedLoader rgh;
  
  public c$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.iMV = paramMMActivity;
    this.rgh = paramBaseFinderFeedLoader;
    this.rgg = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201524);
        Object localObject1 = this.rgi.rgf;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((c.b)localObject1).rfT;
          if (localObject1 != null)
          {
            Object localObject2 = this.rgi.rgf;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).JCb.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).at(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(201524);
              return;
            }
          }
        }
        AppMethodBeat.o(201524);
      }
      
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201525);
        Object localObject1 = this.rgi.rgf;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((c.b)localObject1).rfT;
          if (localObject1 != null)
          {
            localObject2 = this.rgi.rgf;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((c.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).JCb.size();; i = 0)
        {
          ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.rgi.rgf;
          if (localObject1 == null) {
            break;
          }
          ((c.b)localObject1).cuH();
          AppMethodBeat.o(201525);
          return;
        }
        AppMethodBeat.o(201525);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(201520);
        k.h(paramAnonymousc, "reason");
        Object localObject = this.rgi.rgf;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((c.b)localObject).rfT;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).c(paramAnonymousc);
            AppMethodBeat.o(201520);
            return;
          }
        }
        AppMethodBeat.o(201520);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(201521);
        k.h(paramAnonymousc, "reason");
        Object localObject = this.rgi.rgf;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((c.b)localObject).rfT;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
            AppMethodBeat.o(201521);
            return;
          }
        }
        AppMethodBeat.o(201521);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(201523);
        Object localObject1 = this.rgi.rgf;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((c.b)localObject1).rfT;
          if (localObject1 != null)
          {
            Object localObject2 = this.rgi.rgf;
            if (localObject2 != null)
            {
              localObject2 = ((c.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).JCb.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(201523);
              return;
            }
          }
        }
        AppMethodBeat.o(201523);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(201522);
        Object localObject = this.rgi.rgf;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((c.b)localObject).rfT;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).onChanged();
            AppMethodBeat.o(201522);
            return;
          }
        }
        AppMethodBeat.o(201522);
      }
    });
  }
  
  public void a(c.b paramb)
  {
    k.h(paramb, "callback");
    this.rgf = paramb;
    this.rgh.register(this.rgg, this.iMV);
    cur();
  }
  
  public abstract void aQh();
  
  public void cuB() {}
  
  public abstract void cur();
  
  public abstract c cut();
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.rgh.unregister(this.rgg, this.iMV);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c.a
 * JD-Core Version:    0.7.0.1
 */