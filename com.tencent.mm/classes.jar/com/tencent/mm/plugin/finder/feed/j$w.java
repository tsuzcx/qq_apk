package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout;
import com.tencent.mm.ui.widget.TouchMediaPreviewLayout.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/FinderTimelinePresenter$onAttach$4", "Lcom/tencent/mm/ui/widget/TouchMediaPreviewLayout$OnScaleListener;", "focusBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getFocusBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setFocusBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "plugin-finder_release"})
public final class j$w
  implements TouchMediaPreviewLayout.b
{
  private final RecyclerView fPw;
  private FinderMediaBanner qus;
  
  j$w(TouchMediaPreviewLayout paramTouchMediaPreviewLayout, i.b paramb)
  {
    AppMethodBeat.i(198064);
    this.fPw = paramb.getRecyclerView();
    AppMethodBeat.o(198064);
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(198063);
    k.h(paramScaleGestureDetector, "detector");
    AppMethodBeat.o(198063);
    return true;
  }
  
  public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(198061);
    k.h(paramScaleGestureDetector, "detector");
    paramScaleGestureDetector = this.fPw.o(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    if (paramScaleGestureDetector != null) {}
    Object localObject;
    for (paramScaleGestureDetector = (FinderMediaBanner)paramScaleGestureDetector.findViewById(2131302203);; paramScaleGestureDetector = null)
    {
      this.qus = paramScaleGestureDetector;
      paramScaleGestureDetector = this.qus;
      if (paramScaleGestureDetector == null) {
        break label262;
      }
      paramScaleGestureDetector = paramScaleGestureDetector.getPagerView();
      if (paramScaleGestureDetector == null) {
        break label262;
      }
      localObject = this.qus;
      if (localObject == null) {
        k.fvU();
      }
      paramScaleGestureDetector = paramScaleGestureDetector.cj(((FinderMediaBanner)localObject).getFocusPosition());
      if ((paramScaleGestureDetector == null) || (paramScaleGestureDetector.lp() != 2)) {
        break label148;
      }
      localObject = b.qJA;
      if (!b.cpB()) {
        break;
      }
      paramScaleGestureDetector = paramScaleGestureDetector.arI.findViewById(2131299974);
      if (paramScaleGestureDetector == null) {
        break label262;
      }
      this.qxe.gq(paramScaleGestureDetector);
      AppMethodBeat.o(198061);
      return true;
    }
    AppMethodBeat.o(198061);
    return false;
    label148:
    if ((paramScaleGestureDetector != null) && (paramScaleGestureDetector.lp() == 4))
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
            AppMethodBeat.o(198061);
            return false;
          }
          paramScaleGestureDetector = paramScaleGestureDetector.getVideoView();
          if (paramScaleGestureDetector != null)
          {
            paramScaleGestureDetector.setPreview(true);
            paramScaleGestureDetector.setInterceptDetach(true);
            this.qxe.gq(paramScaleGestureDetector.getVideoView());
            AppMethodBeat.o(198061);
            return true;
          }
        }
      }
      else
      {
        AppMethodBeat.o(198061);
        return false;
      }
    }
    label262:
    AppMethodBeat.o(198061);
    return false;
  }
  
  public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(198062);
    k.h(paramScaleGestureDetector, "detector");
    if ((this.qxe.getTouchView() instanceof o))
    {
      paramScaleGestureDetector = this.qxe.getTouchView();
      if (paramScaleGestureDetector == null)
      {
        paramScaleGestureDetector = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.IFinderVideoView");
        AppMethodBeat.o(198062);
        throw paramScaleGestureDetector;
      }
      paramScaleGestureDetector = (o)paramScaleGestureDetector;
      paramScaleGestureDetector.setInterceptDetach(false);
      paramScaleGestureDetector.setPreview(false);
    }
    AppMethodBeat.o(198062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.w
 * JD-Core Version:    0.7.0.1
 */