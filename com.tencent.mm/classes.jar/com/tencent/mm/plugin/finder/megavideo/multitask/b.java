package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "mContentView", "Landroid/view/View;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;Landroid/view/View;)V", "contentView", "getContentView", "()Landroid/view/View;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  private final View mContentView;
  public f zvV;
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager, View paramView)
  {
    super(paramActivity, paramCustomViewPager);
    AppMethodBeat.i(267639);
    this.mContentView = paramView;
    AppMethodBeat.o(267639);
  }
  
  public final boolean cbG()
  {
    return true;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(267637);
    if ((getActivity() instanceof MMActivity))
    {
      localView = super.getContentView();
      AppMethodBeat.o(267637);
      return localView;
    }
    View localView = this.mContentView;
    AppMethodBeat.o(267637);
    return localView;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(267638);
    if ((getActivity() instanceof MMActivity))
    {
      Object localObject1 = this.zvV;
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).zxJ;
        if (localObject1 == null) {
          p.bGy("viewCallback");
        }
        localObject1 = ((h.b)localObject1).getRecyclerView();
        localObject2 = ((RecyclerView)localObject1).getLayoutManager();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(267638);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((RecyclerView)localObject1).cK(((LinearLayoutManager)localObject2).kJ());
        localObject1 = localObject2;
        if (!(localObject2 instanceof i)) {
          localObject1 = null;
        }
        localObject1 = (i)localObject1;
        if (localObject1 == null) {
          break label129;
        }
      }
      label129:
      for (localObject1 = ((i)localObject1).RD(b.f.media_banner);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject1 = super.getMaskView();
        AppMethodBeat.o(267638);
        return localObject1;
      }
    }
    Object localObject2 = getContentView();
    AppMethodBeat.o(267638);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.b
 * JD-Core Version:    0.7.0.1
 */