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
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", "listener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC
  extends UIComponent
{
  public static final FinderTouchMediaPreviewUIC.a sfp;
  
  static
  {
    AppMethodBeat.i(204696);
    sfp = new FinderTouchMediaPreviewUIC.a((byte)0);
    AppMethodBeat.o(204696);
  }
  
  public FinderTouchMediaPreviewUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(204695);
    AppMethodBeat.o(204695);
  }
  
  public final TouchMediaPreviewLayout cGj()
  {
    AppMethodBeat.i(204693);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = (TouchMediaPreviewLayout)getActivity().findViewById(2131306046);
    AppMethodBeat.o(204693);
    return localTouchMediaPreviewLayout;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(204694);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cGj();
    if ((localTouchMediaPreviewLayout != null) && (localTouchMediaPreviewLayout.JcV == true))
    {
      localTouchMediaPreviewLayout = cGj();
      if (localTouchMediaPreviewLayout != null) {
        localTouchMediaPreviewLayout.fuZ();
      }
      AppMethodBeat.o(204694);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(204694);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    AppMethodBeat.i(204691);
    k.h(paramb, "listener");
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cGj();
    if (localTouchMediaPreviewLayout != null)
    {
      localTouchMediaPreviewLayout.setScaleListener(paramb);
      AppMethodBeat.o(204691);
      return;
    }
    AppMethodBeat.o(204691);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$setScaleListener$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private TouchMediaPreviewLayout rfY;
    
    b()
    {
      AppMethodBeat.i(204690);
      TouchMediaPreviewLayout localTouchMediaPreviewLayout = localTouchMediaPreviewLayout.cGj();
      if (localTouchMediaPreviewLayout == null) {
        k.fOy();
      }
      this.rfY = localTouchMediaPreviewLayout;
      AppMethodBeat.o(204690);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(204689);
      k.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(204689);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(204687);
      k.h(paramScaleGestureDetector, "detector");
      Object localObject = a.IrY;
      localObject = ((FinderHomeUIC)a.q(this.sfq.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().getView();
      if (localObject != null)
      {
        localObject = (RefreshLoadMoreLayout)((View)localObject).findViewById(2131304203);
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(204687);
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
          if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.ly() == 2))
          {
            localObject = b.rCU;
            if (b.cyY())
            {
              paramScaleGestureDetector = paramScaleGestureDetector.asD.findViewById(2131299974);
              if (paramScaleGestureDetector != null)
              {
                this.rfY.gF(paramScaleGestureDetector);
                AppMethodBeat.o(204687);
                return true;
                paramScaleGestureDetector = null;
              }
            }
            else
            {
              AppMethodBeat.o(204687);
              return false;
            }
          }
          else if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.ly() == 4))
          {
            localObject = b.rCU;
            if (b.cyZ())
            {
              paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.asD.findViewById(2131299975);
              if (paramScaleGestureDetector != null)
              {
                localObject = paramScaleGestureDetector.getVideoView();
                if ((localObject != null) && (!((o)localObject).isPlaying()))
                {
                  AppMethodBeat.o(204687);
                  return false;
                }
                paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
                if (paramScaleGestureDetector != null)
                {
                  paramScaleGestureDetector.setPreview(true);
                  paramScaleGestureDetector.setInterceptDetach(true);
                  this.rfY.gF(paramScaleGestureDetector.getVideoView());
                  AppMethodBeat.o(204687);
                  return true;
                }
              }
            }
            else
            {
              AppMethodBeat.o(204687);
              return false;
            }
          }
        }
      }
      AppMethodBeat.o(204687);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(204688);
      k.h(paramScaleGestureDetector, "detector");
      if ((this.rfY.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.rfY.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(204688);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(204688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC
 * JD-Core Version:    0.7.0.1
 */