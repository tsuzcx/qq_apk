package com.tencent.mm.plugin.finder.megavideo.multitask;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.megavideo.ui.h.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskPageAdapter;", "Lcom/tencent/mm/plugin/multitask/adapter/MultiTaskPageAdapter;", "activity", "Landroid/app/Activity;", "multiTaskRootView", "Lcom/tencent/mm/ui/base/CustomViewPager;", "mContentView", "Landroid/view/View;", "(Landroid/app/Activity;Lcom/tencent/mm/ui/base/CustomViewPager;Landroid/view/View;)V", "contentView", "getContentView", "()Landroid/view/View;", "isSupportSwipeToMultiTask", "", "()Z", "maskView", "getMaskView", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.multitask.a.b
{
  public f Ezo;
  private final View mContentView;
  
  public b(Activity paramActivity, CustomViewPager paramCustomViewPager, View paramView)
  {
    super(paramActivity, paramCustomViewPager);
    AppMethodBeat.i(341784);
    this.mContentView = paramView;
    AppMethodBeat.o(341784);
  }
  
  public final boolean cBZ()
  {
    return true;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(341800);
    if ((getActivity() instanceof MMActivity))
    {
      localView = super.getContentView();
      AppMethodBeat.o(341800);
      return localView;
    }
    View localView = this.mContentView;
    AppMethodBeat.o(341800);
    return localView;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(341812);
    if ((getActivity() instanceof MMActivity))
    {
      localObject1 = this.Ezo;
      if (localObject1 != null)
      {
        Object localObject2 = ((f)localObject1).EAL;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("viewCallback");
          localObject1 = null;
        }
        localObject1 = ((h.b)localObject1).getRecyclerView();
        localObject2 = ((RecyclerView)localObject1).getLayoutManager();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(341812);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((RecyclerView)localObject1).fU(((LinearLayoutManager)localObject2).Ju());
        if ((localObject1 instanceof j))
        {
          localObject1 = (j)localObject1;
          if (localObject1 == null) {
            break label132;
          }
        }
      }
      label132:
      for (localObject1 = ((j)localObject1).UH(e.e.media_banner);; localObject1 = null)
      {
        if (localObject1 != null) {
          break label137;
        }
        localObject1 = super.getMaskView();
        AppMethodBeat.o(341812);
        return localObject1;
        localObject1 = null;
        break;
      }
      label137:
      AppMethodBeat.o(341812);
      return localObject1;
    }
    Object localObject1 = getContentView();
    AppMethodBeat.o(341812);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.multitask.b
 * JD-Core Version:    0.7.0.1
 */