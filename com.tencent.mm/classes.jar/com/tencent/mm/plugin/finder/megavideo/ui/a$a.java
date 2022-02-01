package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<a.b>, b<com.tencent.mm.vending.e.a>
{
  private k ATF;
  a.b EAa;
  final BaseMegaVideoLoader EzZ;
  private final MMActivity lzt;
  
  public a$a(MMActivity paramMMActivity, BaseMegaVideoLoader paramBaseMegaVideoLoader)
  {
    this.lzt = paramMMActivity;
    this.EzZ = paramBaseMegaVideoLoader;
    this.ATF = ((k)new k()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(342034);
        a.b localb = this.EAb.EAa;
        if (localb != null) {
          ((k)localb.ATx).onChanged();
        }
        AppMethodBeat.o(342034);
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342039);
        Object localObject = this.EAb.EAa;
        a.b localb;
        if (localObject != null)
        {
          localObject = (k)((a.b)localObject).ATx;
          localb = this.EAb.EAa;
          if (localb != null) {
            break label62;
          }
        }
        label62:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(342039);
          return;
        }
      }
      
      public final void onItemRangeChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(342041);
        Object localObject = this.EAb.EAa;
        a.b localb;
        if (localObject != null)
        {
          localObject = (k)((a.b)localObject).ATx;
          localb = this.EAb.EAa;
          if (localb != null) {
            break label65;
          }
        }
        label65:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeChanged(i + paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          AppMethodBeat.o(342041);
          return;
        }
      }
      
      public final void onItemRangeInserted(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342044);
        Object localObject = this.EAb.EAa;
        a.b localb;
        if (localObject != null)
        {
          localObject = (k)((a.b)localObject).ATx;
          localb = this.EAb.EAa;
          if (localb != null) {
            break label62;
          }
        }
        label62:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeInserted(i + paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(342044);
          return;
        }
      }
      
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(342052);
        Object localObject = this.EAb.EAa;
        a.b localb;
        if (localObject != null)
        {
          localObject = (k)((a.b)localObject).ATx;
          localb = this.EAb.EAa;
          if (localb != null) {
            break label81;
          }
        }
        label81:
        for (int i = 0;; i = localb.getAdapter().agOb.size())
        {
          ((k)localObject).onItemRangeRemoved(i + paramAnonymousInt1, paramAnonymousInt2);
          localObject = this.EAb.EAa;
          if (localObject != null) {
            ((a.b)localObject).dUO();
          }
          AppMethodBeat.o(342052);
          return;
        }
      }
      
      public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(342021);
        s.u(paramAnonymousd, "reason");
        a.b localb = this.EAb.EAa;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishLoadMore(paramAnonymousd);
        }
        AppMethodBeat.o(342021);
      }
      
      public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(342027);
        s.u(paramAnonymousd, "reason");
        a.b localb = this.EAb.EAa;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishLoadMoreSmooth(paramAnonymousd);
        }
        AppMethodBeat.o(342027);
      }
      
      public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(342011);
        s.u(paramAnonymousd, "reason");
        a.b localb = this.EAb.EAa;
        if (localb != null) {
          ((k)localb.ATx).onPreFinishRefresh(paramAnonymousd);
        }
        AppMethodBeat.o(342011);
      }
    });
  }
  
  public static boolean onBackPressed()
  {
    return false;
  }
  
  public void a(a.b paramb)
  {
    s.u(paramb, "callback");
    this.EAa = paramb;
    this.EzZ.register(this.ATF);
    dUM();
  }
  
  public abstract void bXB();
  
  public abstract g dUK();
  
  public void dUL() {}
  
  public abstract void dUM();
  
  public void keep(com.tencent.mm.vending.e.a parama) {}
  
  public void onDetach()
  {
    this.EzZ.unregister(this.ATF);
  }
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.a.a
 * JD-Core Version:    0.7.0.1
 */