package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runnable", "Ljava/lang/Runnable;", "showGuideFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onCheckShowGuide", "", "onDestroy", "setRecyclerView", "setShowGuideFeed", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Companion", "plugin-finder_release"})
public final class FinderFullFeedGuideUIC
  extends UIComponent
{
  public static final a wws;
  private final Runnable dQN;
  private final MMHandler hAk;
  private RecyclerView hak;
  private BaseFinderFeed wwr;
  
  static
  {
    AppMethodBeat.i(255546);
    wws = new a((byte)0);
    AppMethodBeat.o(255546);
  }
  
  public FinderFullFeedGuideUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255544);
    this.dQN = ((Runnable)new b(this));
    this.hAk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(255544);
  }
  
  public FinderFullFeedGuideUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255545);
    this.dQN = ((Runnable)new b(this));
    this.hAk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(255545);
  }
  
  public final void dIc()
  {
    boolean bool = false;
    AppMethodBeat.i(255542);
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    if (!locale.azQ().getBoolean(ar.a.OjB, false)) {
      bool = true;
    }
    Log.i("Finder.FullFeedGuideUIC", "[onCheckShowGuide] isFirst=" + bool + ' ');
    if (bool) {
      this.hAk.postUIDelayed(this.dQN, 2000L);
    }
    AppMethodBeat.o(255542);
  }
  
  public final void e(bo parambo)
  {
    int i = 0;
    AppMethodBeat.i(255540);
    Object localObject1 = g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    if (!((e)localObject1).azQ().getBoolean(ar.a.OjB, false)) {
      i = 1;
    }
    if ((i != 0) && ((parambo instanceof BaseFinderFeed)))
    {
      ((BaseFinderFeed)parambo).isShowGuideTips = 1;
      this.wwr = ((BaseFinderFeed)parambo);
      localObject1 = this.hak;
      if (localObject1 != null) {}
      for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (!(localObject1 instanceof WxRecyclerAdapter)) {
          localObject2 = null;
        }
        localObject1 = (WxRecyclerAdapter)localObject2;
        if (localObject1 == null) {
          break;
        }
        ((WxRecyclerAdapter)localObject1).Or(parambo.lT());
        AppMethodBeat.o(255540);
        return;
      }
    }
    AppMethodBeat.o(255540);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255543);
    super.onDestroy();
    this.hAk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(255543);
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(255541);
    this.hak = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.a((RecyclerView.l)new c(this));
      AppMethodBeat.o(255541);
      return;
    }
    AppMethodBeat.o(255541);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderFullFeedGuideUIC paramFinderFullFeedGuideUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(255537);
      Object localObject1 = FinderFullFeedGuideUIC.c(this.wwt);
      if (localObject1 != null)
      {
        localObject1 = ((RecyclerView)localObject1).getAdapter();
        if (localObject1 == null) {}
      }
      for (int i = ((RecyclerView.a)localObject1).getItemCount();; i = 0)
      {
        Log.i("Finder.FullFeedGuideUIC", "[videoComplete] count=".concat(String.valueOf(i)));
        if (i <= 0) {
          break;
        }
        localObject1 = FinderFullFeedGuideUIC.c(this.wwt);
        if (localObject1 == null) {
          break;
        }
        if ((((RecyclerView)localObject1).getAdapter() instanceof WxRecyclerAdapter))
        {
          Object localObject2 = g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          ((e)localObject2).azQ().set(ar.a.OjB, Boolean.TRUE);
          localObject2 = ((RecyclerView)localObject1).getContext();
          p.g(localObject2, "it.context");
          ((RecyclerView)localObject1).smoothScrollBy(0, (int)((Context)localObject2).getResources().getDimension(2131165285));
        }
        AppMethodBeat.o(255537);
        return;
      }
      AppMethodBeat.o(255537);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isShouldDismiss", "", "()Z", "setShouldDismiss", "(Z)V", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private float offset = 100.0F;
    private View view;
    private boolean wwu;
    
    c(FinderFullFeedGuideUIC paramFinderFullFeedGuideUIC) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(255538);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        if (this.view == null)
        {
          paramRecyclerView = paramRecyclerView.getLayoutManager();
          if (paramRecyclerView != null)
          {
            paramRecyclerView = paramRecyclerView.findViewByPosition(1);
            if (paramRecyclerView != null)
            {
              paramRecyclerView = paramRecyclerView.findViewById(2131302228);
              this.view = paramRecyclerView;
              paramRecyclerView = this.view;
              if (paramRecyclerView != null) {
                paramRecyclerView.setVisibility(0);
              }
            }
          }
        }
      }
      for (;;)
      {
        if (paramInt == 1) {
          FinderFullFeedGuideUIC.b(this.wwt).removeCallbacksAndMessages(null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(255538);
        return;
        paramRecyclerView = null;
        break;
        if (this.wwu)
        {
          paramRecyclerView = this.view;
          if (paramRecyclerView != null) {
            paramRecyclerView.setVisibility(8);
          }
          paramRecyclerView = FinderFullFeedGuideUIC.a(this.wwt);
          if (paramRecyclerView != null)
          {
            paramRecyclerView.isShowGuideTips = -1;
            continue;
            if ((this.view != null) && (paramInt == 1)) {
              this.wwu = true;
            }
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(255539);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.view;
      if (paramRecyclerView != null)
      {
        this.offset -= paramInt2 / 5.0F;
        this.offset = android.support.v4.b.a.j(this.offset, 100.0F);
        paramRecyclerView.setAlpha(this.offset / 100.0F);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(255539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFullFeedGuideUIC
 * JD-Core Version:    0.7.0.1
 */