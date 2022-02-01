package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runnable", "Ljava/lang/Runnable;", "showGuideFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "onCheckShowGuide", "", "onDestroy", "setRecyclerView", "setShowGuideFeed", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Companion", "plugin-finder_release"})
public final class y
  extends UIComponent
{
  public static final a BkG;
  private BaseFinderFeed BkF;
  private final Runnable fKd;
  private RecyclerView jLl;
  private final MMHandler knk;
  
  static
  {
    AppMethodBeat.i(289296);
    BkG = new a((byte)0);
    AppMethodBeat.o(289296);
  }
  
  public y(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289295);
    this.fKd = ((Runnable)new b(this));
    this.knk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(289295);
  }
  
  public y(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(289294);
    this.fKd = ((Runnable)new b(this));
    this.knk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(289294);
  }
  
  public final void ekI()
  {
    boolean bool3 = true;
    AppMethodBeat.i(289292);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    boolean bool1;
    boolean bool2;
    if (!((f)localObject).aHp().getBoolean(ar.a.VxR, false))
    {
      bool1 = true;
      localObject = this.jLl;
      if (localObject == null) {
        break label141;
      }
      aj localaj = aj.AGc;
      bool2 = aj.t((RecyclerView)localObject);
      label58:
      localObject = new StringBuilder("[onCheckShowGuide] isFirst=").append(bool1).append(", liveListIsVisible:").append(bool2).append(",recyclerView is null:");
      if (this.jLl != null) {
        break label146;
      }
    }
    for (;;)
    {
      Log.i("Finder.FullFeedGuideUIC", bool3);
      if ((bool1) && (!bool2)) {
        this.knk.postUIDelayed(this.fKd, 2000L);
      }
      AppMethodBeat.o(289292);
      return;
      bool1 = false;
      break;
      label141:
      bool2 = false;
      break label58;
      label146:
      bool3 = false;
    }
  }
  
  public final void h(bu parambu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(289290);
    Object localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    boolean bool1;
    Object localObject2;
    if (!((f)localObject1).aHp().getBoolean(ar.a.VxR, false))
    {
      bool1 = true;
      localObject1 = this.jLl;
      if (localObject1 != null)
      {
        localObject2 = aj.AGc;
        bool2 = aj.t((RecyclerView)localObject1);
      }
      Log.i("Finder.FullFeedGuideUIC", "setShowGuideFeed isFirst:" + bool1 + ",liveListIsVisible:" + bool2);
      if ((!bool1) || (bool2) || (!(parambu instanceof BaseFinderFeed))) {
        break label192;
      }
      ((BaseFinderFeed)parambu).isShowGuideTips = 1;
      this.BkF = ((BaseFinderFeed)parambu);
      localObject1 = this.jLl;
      if (localObject1 == null) {
        break label186;
      }
    }
    label186:
    for (localObject1 = ((RecyclerView)localObject1).getAdapter();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof WxRecyclerAdapter)) {
        localObject2 = null;
      }
      localObject1 = (WxRecyclerAdapter)localObject2;
      if (localObject1 == null) {
        break label192;
      }
      ((WxRecyclerAdapter)localObject1).WF(parambu.mf());
      AppMethodBeat.o(289290);
      return;
      bool1 = false;
      break;
    }
    label192:
    AppMethodBeat.o(289290);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(289293);
    super.onDestroy();
    this.knk.removeCallbacksAndMessages(null);
    AppMethodBeat.o(289293);
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(289291);
    this.jLl = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView.a((RecyclerView.l)new c(this));
      AppMethodBeat.o(289291);
      return;
    }
    AppMethodBeat.o(289291);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(y paramy) {}
    
    public final void run()
    {
      AppMethodBeat.i(289260);
      Object localObject1 = y.c(this.BkH);
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
        localObject1 = y.c(this.BkH);
        if (localObject1 == null) {
          break;
        }
        if ((((RecyclerView)localObject1).getAdapter() instanceof WxRecyclerAdapter))
        {
          Object localObject2 = h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          ((f)localObject2).aHp().set(ar.a.VxR, Boolean.TRUE);
          localObject2 = ((RecyclerView)localObject1).getContext();
          p.j(localObject2, "it.context");
          ((RecyclerView)localObject1).ax(0, (int)((Context)localObject2).getResources().getDimension(b.d.Edge_15A));
        }
        AppMethodBeat.o(289260);
        return;
      }
      AppMethodBeat.o(289260);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isShouldDismiss", "", "()Z", "setShouldDismiss", "(Z)V", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    private boolean BkI;
    private float offset = 100.0F;
    private View view;
    
    c(y paramy) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(283877);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
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
              paramRecyclerView = paramRecyclerView.findViewById(b.f.guide_layout_parent);
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
          y.b(this.BkH).removeCallbacksAndMessages(null);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(283877);
        return;
        paramRecyclerView = null;
        break;
        if (this.BkI)
        {
          paramRecyclerView = this.view;
          if (paramRecyclerView != null) {
            paramRecyclerView.setVisibility(8);
          }
          paramRecyclerView = y.a(this.BkH);
          if (paramRecyclerView != null)
          {
            paramRecyclerView.isShowGuideTips = -1;
            continue;
            if ((this.view != null) && (paramInt == 1)) {
              this.BkI = true;
            }
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(283878);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      paramRecyclerView = this.view;
      if (paramRecyclerView != null)
      {
        this.offset -= paramInt2 / 5.0F;
        this.offset = androidx.core.b.a.c(this.offset, 0.0F, 100.0F);
        paramRecyclerView.setAlpha(this.offset / 100.0F);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderFullFeedGuideUIC$setRecyclerView$$inlined$let$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(283878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.y
 * JD-Core Version:    0.7.0.1
 */