package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
public abstract class a$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<a.b>, b<com.tencent.mm.vending.e.a>
{
  private final MMActivity iXq;
  private j xvV;
  a.b zxf;
  final BaseMegaVideoLoader zxg;
  
  public a$a(MMActivity paramMMActivity, BaseMegaVideoLoader paramBaseMegaVideoLoader)
  {
    this.iXq = paramMMActivity;
    this.zxg = paramBaseMegaVideoLoader;
    this.xvV = ((j)new j()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(286905);
        Object localObject = this.zxh.zxf;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onChanged();
            AppMethodBeat.o(286905);
            return;
          }
        }
        AppMethodBeat.o(286905);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(286906);
        Object localObject1 = this.zxh.zxf;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.zxh.zxf;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(286906);
              return;
            }
          }
        }
        AppMethodBeat.o(286906);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(286907);
        Object localObject1 = this.zxh.zxf;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.zxh.zxf;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
              AppMethodBeat.o(286907);
              return;
            }
          }
        }
        AppMethodBeat.o(286907);
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(286908);
        Object localObject1 = this.zxh.zxf;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            Object localObject2 = this.zxh.zxf;
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).getAdapter();
              if (localObject2 == null) {}
            }
            for (int i = ((h)localObject2).YSk.size();; i = 0)
            {
              ((j)localObject1).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(286908);
              return;
            }
          }
        }
        AppMethodBeat.o(286908);
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(286909);
        Object localObject1 = this.zxh.zxf;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = (j)((a.b)localObject1).xvJ;
          if (localObject1 != null)
          {
            localObject2 = this.zxh.zxf;
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
        for (int i = ((h)localObject2).YSk.size();; i = 0)
        {
          ((j)localObject1).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject1 = this.zxh.zxf;
          if (localObject1 == null) {
            break;
          }
          ((a.b)localObject1).dsL();
          AppMethodBeat.o(286909);
          return;
        }
        AppMethodBeat.o(286909);
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(286903);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zxh.zxf;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMore(paramAnonymousc);
            AppMethodBeat.o(286903);
            return;
          }
        }
        AppMethodBeat.o(286903);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(286904);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zxh.zxf;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishLoadMoreSmooth(paramAnonymousc);
            AppMethodBeat.o(286904);
            return;
          }
        }
        AppMethodBeat.o(286904);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(286902);
        p.k(paramAnonymousc, "reason");
        Object localObject = this.zxh.zxf;
        if (localObject != null)
        {
          localObject = (j)((a.b)localObject).xvJ;
          if (localObject != null)
          {
            ((j)localObject).onPreFinishRefresh(paramAnonymousc);
            AppMethodBeat.o(286902);
            return;
          }
        }
        AppMethodBeat.o(286902);
      }
    });
  }
  
  public void a(a.b paramb)
  {
    p.k(paramb, "callback");
    this.zxf = paramb;
    this.zxg.register(this.xvV);
    dsr();
  }
  
  public abstract void byN();
  
  public void dsF() {}
  
  public abstract void dsr();
  
  public abstract f dsu();
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.zxg.unregister(this.xvV);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */