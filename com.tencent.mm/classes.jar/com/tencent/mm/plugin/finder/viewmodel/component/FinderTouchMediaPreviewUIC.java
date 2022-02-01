package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
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
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", "listener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC
  extends UIComponent
{
  public static final FinderTouchMediaPreviewUIC.a toe;
  
  static
  {
    AppMethodBeat.i(206361);
    toe = new FinderTouchMediaPreviewUIC.a((byte)0);
    AppMethodBeat.o(206361);
  }
  
  public FinderTouchMediaPreviewUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206360);
    AppMethodBeat.o(206360);
  }
  
  public final TouchMediaPreviewLayout cRh()
  {
    AppMethodBeat.i(206358);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = (TouchMediaPreviewLayout)getActivity().findViewById(2131306046);
    AppMethodBeat.o(206358);
    return localTouchMediaPreviewLayout;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(206359);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cRh();
    if ((localTouchMediaPreviewLayout != null) && (localTouchMediaPreviewLayout.LqB == true))
    {
      localTouchMediaPreviewLayout = cRh();
      if (localTouchMediaPreviewLayout != null) {
        localTouchMediaPreviewLayout.fQg();
      }
      AppMethodBeat.o(206359);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(206359);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    AppMethodBeat.i(206356);
    p.h(paramb, "listener");
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cRh();
    if (localTouchMediaPreviewLayout != null)
    {
      localTouchMediaPreviewLayout.setScaleListener(paramb);
      AppMethodBeat.o(206356);
      return;
    }
    AppMethodBeat.o(206356);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$setScaleListener$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private TouchMediaPreviewLayout scn;
    
    b()
    {
      AppMethodBeat.i(206355);
      TouchMediaPreviewLayout localTouchMediaPreviewLayout = localTouchMediaPreviewLayout.cRh();
      if (localTouchMediaPreviewLayout == null) {
        p.gkB();
      }
      this.scn = localTouchMediaPreviewLayout;
      AppMethodBeat.o(206355);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(206354);
      p.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(206354);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(206352);
      p.h(paramScaleGestureDetector, "detector");
      Object localObject = a.KEX;
      localObject = ((FinderHomeUIC)a.s(this.tof.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().getView();
      if (localObject != null)
      {
        localObject = (RefreshLoadMoreLayout)((View)localObject).findViewById(2131304203);
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(206352);
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
          paramScaleGestureDetector = ((RecyclerHorizontalViewPager)localObject).ci(paramScaleGestureDetector.getFocusPosition());
          if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 2))
          {
            localObject = b.sHP;
            if (b.cHQ())
            {
              paramScaleGestureDetector = paramScaleGestureDetector.auu.findViewById(2131299974);
              if (paramScaleGestureDetector != null)
              {
                this.scn.hb(paramScaleGestureDetector);
                AppMethodBeat.o(206352);
                return true;
                paramScaleGestureDetector = null;
              }
            }
            else
            {
              AppMethodBeat.o(206352);
              return false;
            }
          }
          else if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 4))
          {
            localObject = b.sHP;
            if (b.cHR())
            {
              paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.auu.findViewById(2131299975);
              if (paramScaleGestureDetector != null)
              {
                localObject = paramScaleGestureDetector.getVideoView();
                if ((localObject != null) && (!((o)localObject).isPlaying()))
                {
                  AppMethodBeat.o(206352);
                  return false;
                }
                paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
                if (paramScaleGestureDetector != null)
                {
                  paramScaleGestureDetector.setPreview(true);
                  paramScaleGestureDetector.setInterceptDetach(true);
                  this.scn.hb(paramScaleGestureDetector.getVideoView());
                  AppMethodBeat.o(206352);
                  return true;
                }
              }
            }
            else
            {
              AppMethodBeat.o(206352);
              return false;
            }
          }
        }
      }
      AppMethodBeat.o(206352);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(206353);
      p.h(paramScaleGestureDetector, "detector");
      if ((this.scn.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.scn.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(206353);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(206353);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC
 * JD-Core Version:    0.7.0.1
 */