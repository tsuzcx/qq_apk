package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", "listener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC
  extends UIComponent
{
  public static final a LjI;
  
  static
  {
    AppMethodBeat.i(200566);
    LjI = new a((byte)0);
    AppMethodBeat.o(200566);
  }
  
  public FinderTouchMediaPreviewUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(200565);
    AppMethodBeat.o(200565);
  }
  
  public final TouchMediaPreviewLayout fXA()
  {
    AppMethodBeat.i(200563);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = (TouchMediaPreviewLayout)getActivity().findViewById(2131306046);
    AppMethodBeat.o(200563);
    return localTouchMediaPreviewLayout;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(200564);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = fXA();
    if ((localTouchMediaPreviewLayout != null) && (localTouchMediaPreviewLayout.HCz == true))
    {
      localTouchMediaPreviewLayout = fXA();
      if (localTouchMediaPreviewLayout != null) {
        localTouchMediaPreviewLayout.ffe();
      }
      AppMethodBeat.o(200564);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(200564);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    AppMethodBeat.i(200561);
    k.h(paramb, "listener");
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = fXA();
    if (localTouchMediaPreviewLayout != null)
    {
      localTouchMediaPreviewLayout.setScaleListener(paramb);
      AppMethodBeat.o(200561);
      return;
    }
    AppMethodBeat.o(200561);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$setScaleListener$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private TouchMediaPreviewLayout qum;
    
    b()
    {
      AppMethodBeat.i(200560);
      TouchMediaPreviewLayout localTouchMediaPreviewLayout = localTouchMediaPreviewLayout.fXA();
      if (localTouchMediaPreviewLayout == null) {
        k.fvU();
      }
      this.qum = localTouchMediaPreviewLayout;
      AppMethodBeat.o(200560);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(200559);
      k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(200559);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(200557);
      k.h(paramScaleGestureDetector, "detector");
      Object localObject = a.LCX;
      localObject = ((FinderHomeUIC)a.s(this.LjJ.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().getView();
      if (localObject != null)
      {
        localObject = (RefreshLoadMoreLayout)((View)localObject).findViewById(2131304203);
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(200557);
        return false;
      }
      paramScaleGestureDetector = ((RefreshLoadMoreLayout)localObject).getRecyclerView().o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      if (paramScaleGestureDetector != null) {
        paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);
      }
      while (paramScaleGestureDetector != null)
      {
        localObject = paramScaleGestureDetector.getPagerView();
        if (localObject != null)
        {
          paramScaleGestureDetector = ((RecyclerHorizontalViewPager)localObject).cj(paramScaleGestureDetector.getFocusPosition());
          if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lp() == 2))
          {
            localObject = b.qJA;
            if (b.cpB())
            {
              paramScaleGestureDetector = paramScaleGestureDetector.arI.findViewById(2131299974);
              if (paramScaleGestureDetector != null)
              {
                this.qum.gq(paramScaleGestureDetector);
                AppMethodBeat.o(200557);
                return true;
                paramScaleGestureDetector = null;
              }
            }
            else
            {
              AppMethodBeat.o(200557);
              return false;
            }
          }
          else if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lp() == 4))
          {
            localObject = b.qJA;
            if (b.cpC())
            {
              paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.arI.findViewById(2131299975);
              if (paramScaleGestureDetector != null)
              {
                localObject = paramScaleGestureDetector.getVideoView();
                if ((localObject != null) && (!((o)localObject).isPlaying()))
                {
                  AppMethodBeat.o(200557);
                  return false;
                }
                paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
                if (paramScaleGestureDetector != null)
                {
                  paramScaleGestureDetector.setPreview(true);
                  paramScaleGestureDetector.setInterceptDetach(true);
                  this.qum.gq(paramScaleGestureDetector.getVideoView());
                  AppMethodBeat.o(200557);
                  return true;
                }
              }
            }
            else
            {
              AppMethodBeat.o(200557);
              return false;
            }
          }
        }
      }
      AppMethodBeat.o(200557);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(200558);
      k.h(paramScaleGestureDetector, "detector");
      if ((this.qum.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.qum.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(200558);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(200558);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC
 * JD-Core Version:    0.7.0.1
 */