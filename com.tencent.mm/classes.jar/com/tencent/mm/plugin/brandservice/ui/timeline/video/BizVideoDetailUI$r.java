package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/MotionEvent;", "onTouch"})
final class BizVideoDetailUI$r
  implements View.OnTouchListener
{
  BizVideoDetailUI$r(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(7123);
    paramView = BizVideoDetailUI.f(this.pIu);
    View localView = (View)this.pIu.cpw();
    p.g(paramMotionEvent, "e");
    p.h(localView, "v");
    p.h(paramMotionEvent, "e");
    boolean bool;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = paramView.pOm;
    }
    for (;;)
    {
      if (bool)
      {
        BizVideoDetailUI.f(this.pIu).Q(paramMotionEvent);
        if (paramMotionEvent.getAction() == 1) {
          paramMotionEvent.setAction(3);
        }
      }
      AppMethodBeat.o(7123);
      return false;
      if ((!paramView.pOn) && (paramMotionEvent.getY() >= localView.getY()) && (paramMotionEvent.getY() <= localView.getY() + paramView.getHeight()) && (paramMotionEvent.getX() >= localView.getX()) && (paramMotionEvent.getX() <= localView.getX() + paramView.getWidth())) {
        paramView.pOm = true;
      }
      paramView.pOn = true;
      break;
      bool = paramView.pOm;
      paramView.pOm = false;
      paramView.pOn = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.r
 * JD-Core Version:    0.7.0.1
 */