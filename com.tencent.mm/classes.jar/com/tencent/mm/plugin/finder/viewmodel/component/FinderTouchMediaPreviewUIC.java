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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "attach", "", "find", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setScaleListener", "listener", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "Companion", "plugin-finder_release"})
public final class FinderTouchMediaPreviewUIC
  extends UIComponent
{
  public static final a tdm;
  
  static
  {
    AppMethodBeat.i(205747);
    tdm = new a((byte)0);
    AppMethodBeat.o(205747);
  }
  
  public FinderTouchMediaPreviewUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205746);
    AppMethodBeat.o(205746);
  }
  
  public final TouchMediaPreviewLayout cOC()
  {
    AppMethodBeat.i(205744);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = (TouchMediaPreviewLayout)getActivity().findViewById(2131306046);
    AppMethodBeat.o(205744);
    return localTouchMediaPreviewLayout;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(205745);
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cOC();
    if ((localTouchMediaPreviewLayout != null) && (localTouchMediaPreviewLayout.KUd == true))
    {
      localTouchMediaPreviewLayout = cOC();
      if (localTouchMediaPreviewLayout != null) {
        localTouchMediaPreviewLayout.fLM();
      }
      AppMethodBeat.o(205745);
      return true;
    }
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(205745);
    return bool;
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final void setScaleListener(TouchMediaPreviewLayout.b paramb)
  {
    AppMethodBeat.i(205742);
    p.h(paramb, "listener");
    TouchMediaPreviewLayout localTouchMediaPreviewLayout = cOC();
    if (localTouchMediaPreviewLayout != null)
    {
      localTouchMediaPreviewLayout.setScaleListener(paramb);
      AppMethodBeat.o(205742);
      return;
    }
    AppMethodBeat.o(205742);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderTouchMediaPreviewUIC$setScaleListener$1", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "touchPhotoLayout", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "getTouchPhotoLayout", "()Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;", "setTouchPhotoLayout", "(Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout;)V", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
  public static final class b
    implements TouchMediaPreviewLayout.b
  {
    private TouchMediaPreviewLayout rTJ;
    
    b()
    {
      AppMethodBeat.i(205741);
      TouchMediaPreviewLayout localTouchMediaPreviewLayout = localTouchMediaPreviewLayout.cOC();
      if (localTouchMediaPreviewLayout == null) {
        p.gfZ();
      }
      this.rTJ = localTouchMediaPreviewLayout;
      AppMethodBeat.o(205741);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(205740);
      p.h(paramScaleGestureDetector, "detector");
      AppMethodBeat.o(205740);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(205738);
      p.h(paramScaleGestureDetector, "detector");
      Object localObject = a.KiD;
      localObject = ((FinderHomeUIC)a.s(this.tdn.getActivity()).get(FinderHomeUIC.class)).getActiveFragment().getView();
      if (localObject != null)
      {
        localObject = (RefreshLoadMoreLayout)((View)localObject).findViewById(2131304203);
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(205738);
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
            localObject = b.sxa;
            if (b.cFT())
            {
              paramScaleGestureDetector = paramScaleGestureDetector.auu.findViewById(2131299974);
              if (paramScaleGestureDetector != null)
              {
                this.rTJ.gW(paramScaleGestureDetector);
                AppMethodBeat.o(205738);
                return true;
                paramScaleGestureDetector = null;
              }
            }
            else
            {
              AppMethodBeat.o(205738);
              return false;
            }
          }
          else if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lQ() == 4))
          {
            localObject = b.sxa;
            if (b.cFU())
            {
              paramScaleGestureDetector = (FinderVideoLayout)paramScaleGestureDetector.auu.findViewById(2131299975);
              if (paramScaleGestureDetector != null)
              {
                localObject = paramScaleGestureDetector.getVideoView();
                if ((localObject != null) && (!((o)localObject).isPlaying()))
                {
                  AppMethodBeat.o(205738);
                  return false;
                }
                paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
                if (paramScaleGestureDetector != null)
                {
                  paramScaleGestureDetector.setPreview(true);
                  paramScaleGestureDetector.setInterceptDetach(true);
                  this.rTJ.gW(paramScaleGestureDetector.getVideoView());
                  AppMethodBeat.o(205738);
                  return true;
                }
              }
            }
            else
            {
              AppMethodBeat.o(205738);
              return false;
            }
          }
        }
      }
      AppMethodBeat.o(205738);
      return false;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(205739);
      p.h(paramScaleGestureDetector, "detector");
      if ((this.rTJ.getTouchView() instanceof o))
      {
        paramScaleGestureDetector = this.rTJ.getTouchView();
        if (paramScaleGestureDetector == null)
        {
          paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
          AppMethodBeat.o(205739);
          throw paramScaleGestureDetector;
        }
        paramScaleGestureDetector = (o)paramScaleGestureDetector;
        paramScaleGestureDetector.setInterceptDetach(false);
        paramScaleGestureDetector.setPreview(false);
      }
      AppMethodBeat.o(205739);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderTouchMediaPreviewUIC
 * JD-Core Version:    0.7.0.1
 */