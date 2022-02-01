package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class b$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<b.b>, b<com.tencent.mm.vending.e.a>
{
  final MMActivity fLP;
  public b.b rTQ;
  private com.tencent.mm.view.d rTR;
  public final BaseFinderFeedLoader rTS;
  
  public b$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    this.fLP = paramMMActivity;
    this.rTS = paramBaseFinderFeedLoader;
    this.rTR = ((com.tencent.mm.view.d)new com.tencent.mm.view.d()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201689);
        Object localObject1 = this.rTT.rTQ;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            Object localObject2 = this.rTT.rTQ;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).au(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(201689);
              return;
            }
          }
        }
        AppMethodBeat.o(201689);
      }
      
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201690);
        Object localObject1 = this.rTT.rTQ;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            localObject2 = this.rTT.rTQ;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((b.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
        {
          ((com.tencent.mm.view.d)localObject1).av(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.rTT.rTQ;
          if (localObject1 == null) {
            break;
          }
          ((b.b)localObject1).cAT();
          AppMethodBeat.o(201690);
          return;
        }
        AppMethodBeat.o(201690);
      }
      
      public final void c(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(201685);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.rTT.rTQ;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).rTF;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).c(paramAnonymousc);
            AppMethodBeat.o(201685);
            return;
          }
        }
        AppMethodBeat.o(201685);
      }
      
      public final void d(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(201686);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.rTT.rTQ;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).rTF;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).d(paramAnonymousc);
            AppMethodBeat.o(201686);
            return;
          }
        }
        AppMethodBeat.o(201686);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(201688);
        Object localObject1 = this.rTT.rTQ;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.view.d)((b.b)localObject1).rTF;
          if (localObject1 != null)
          {
            Object localObject2 = this.rTT.rTQ;
            if (localObject2 != null)
            {
              localObject2 = ((b.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((com.tencent.mm.view.recyclerview.d)localObject2).Lvi.size();; i = 0)
            {
              ((com.tencent.mm.view.d)localObject1).f(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(201688);
              return;
            }
          }
        }
        AppMethodBeat.o(201688);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(201687);
        Object localObject = this.rTT.rTQ;
        if (localObject != null)
        {
          localObject = (com.tencent.mm.view.d)((b.b)localObject).rTF;
          if (localObject != null)
          {
            ((com.tencent.mm.view.d)localObject).onChanged();
            AppMethodBeat.o(201687);
            return;
          }
        }
        AppMethodBeat.o(201687);
      }
    });
  }
  
  public void a(b.b paramb)
  {
    p.h(paramb, "callback");
    this.rTQ = paramb;
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    com.tencent.mm.view.d locald = cAN();
    paramb = locald;
    if (locald == null) {
      paramb = this.rTR;
    }
    localBaseFinderFeedLoader.register(paramb);
    cAA();
  }
  
  public abstract void aTt();
  
  public abstract void cAA();
  
  public abstract c cAE();
  
  public com.tencent.mm.view.d cAN()
  {
    return null;
  }
  
  public void cAO() {}
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.rTS.unregister(this.rTR);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.b.a
 * JD-Core Version:    0.7.0.1
 */