package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class a$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<a.b>, b<com.tencent.mm.vending.e.a>
{
  private final MMActivity gte;
  private j tMe;
  a.b uLE;
  final BaseMegaVideoLoader uLF;
  
  public a$a(MMActivity paramMMActivity, BaseMegaVideoLoader paramBaseMegaVideoLoader)
  {
    this.gte = paramMMActivity;
    this.uLF = paramBaseMegaVideoLoader;
    this.tMe = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(248465);
        Object localObject = this.uLG.uLE;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onChanged();
            AppMethodBeat.o(248465);
            return;
          }
        }
        AppMethodBeat.o(248465);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248466);
        Object localObject1 = this.uLG.uLE;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.uLG.uLE;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(248466);
              return;
            }
          }
        }
        AppMethodBeat.o(248466);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(248467);
        Object localObject1 = this.uLG.uLE;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.uLG.uLE;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(248467);
              return;
            }
          }
        }
        AppMethodBeat.o(248467);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248468);
        Object localObject1 = this.uLG.uLE;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).tLS;
          if (localObject1 != null)
          {
            Object localObject2 = this.uLG.uLE;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((g)localObject2).RqM.size();; i = 0)
            {
              ((j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(248468);
              return;
            }
          }
        }
        AppMethodBeat.o(248468);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(248469);
        Object localObject1 = this.uLG.uLE;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).tLS;
          if (localObject1 != null)
          {
            localObject2 = this.uLG.uLE;
            if (localObject2 == null) {
              break label105;
            }
            localObject2 = ((a.b)localObject2).getAdapter();
            if (localObject2 == null) {
              break label105;
            }
          }
        }
        label105:
        for (int i = ((g)localObject2).RqM.size();; i = 0)
        {
          ((j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.uLG.uLE;
          if (localObject1 == null) {
            break;
          }
          ((a.b)localObject1).dcv();
          AppMethodBeat.o(248469);
          return;
        }
        AppMethodBeat.o(248469);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248463);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uLG.uLE;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(248463);
            return;
          }
        }
        AppMethodBeat.o(248463);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248464);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uLG.uLE;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(248464);
            return;
          }
        }
        AppMethodBeat.o(248464);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(248462);
        p.h(paramAnonymousc, "reason");
        Object localObject = this.uLG.uLE;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).tLS;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(248462);
            return;
          }
        }
        AppMethodBeat.o(248462);
      }
    });
  }
  
  public void a(a.b paramb)
  {
    p.h(paramb, "callback");
    this.uLE = paramb;
    this.uLF.register(this.tMe);
    dcb();
  }
  
  public abstract void boE();
  
  public abstract void dcb();
  
  public abstract f dce();
  
  public void dcp() {}
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.uLF.unregister(this.tMe);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */