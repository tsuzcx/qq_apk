package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "mContentView", "Landroid/view/View;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;Landroid/view/View;)V", "contentView", "getContentView", "()Landroid/view/View;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  private final View mContentView;
  public f uKk;
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager, View paramView)
  {
    super(paramActivity, paramCustomViewPager);
    AppMethodBeat.i(248461);
    this.mContentView = paramView;
    AppMethodBeat.o(248461);
  }
  
  public final boolean bPp()
  {
    return true;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(248459);
    if ((getActivity() instanceof MMActivity))
    {
      localView = super.getContentView();
      AppMethodBeat.o(248459);
      return localView;
    }
    View localView = this.mContentView;
    AppMethodBeat.o(248459);
    return localView;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(248460);
    if ((getActivity() instanceof MMActivity))
    {
      Object localObject1 = this.uKk;
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).uLW;
        if (localObject1 == null) {
          p.btv("viewCallback");
        }
        localObject1 = ((h.b)localObject1).getRecyclerView();
        localObject2 = ((RecyclerView)localObject1).getLayoutManager();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(248460);
          throw ((Throwable)localObject1);
        }
        localObject2 = ((RecyclerView)localObject1).ch(((LinearLayoutManager)localObject2).ks());
        localObject1 = localObject2;
        if (!(localObject2 instanceof h)) {
          localObject1 = null;
        }
        localObject1 = (h)localObject1;
        if (localObject1 == null) {
          break label128;
        }
      }
      label128:
      for (localObject1 = ((h)localObject1).Mn(2131304549);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject1 = super.getMaskView();
        AppMethodBeat.o(248460);
        return localObject1;
      }
    }
    Object localObject2 = getContentView();
    AppMethodBeat.o(248460);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.b
 * JD-Core Version:    0.7.0.1
 */