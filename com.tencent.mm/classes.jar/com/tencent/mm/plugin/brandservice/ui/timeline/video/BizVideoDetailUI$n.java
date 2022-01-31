package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"})
final class BizVideoDetailUI$n
  implements View.OnTouchListener
{
  BizVideoDetailUI$n(BizVideoDetailUI paramBizVideoDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152820);
    boolean bool = this.kgi.aYg().dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(152820);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.BizVideoDetailUI.n
 * JD-Core Version:    0.7.0.1
 */