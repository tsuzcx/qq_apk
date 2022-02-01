package com.tencent.kinda.framework.widget.tools;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

class MMKViewUtil$1
  implements Runnable
{
  MMKViewUtil$1(View paramView, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    AppMethodBeat.i(226444);
    View localView = (View)this.val$view.getParent();
    if (localView == null)
    {
      AppMethodBeat.o(226444);
      return;
    }
    Rect localRect = new Rect();
    this.val$view.getHitRect(localRect);
    float f1 = a.fromDPToPix(this.val$view.getContext(), this.val$width);
    float f2 = a.fromDPToPix(this.val$view.getContext(), this.val$height);
    localRect.inset((int)(-f1 / 2.0F), (int)(-f2 / 2.0F));
    TouchDelegate localTouchDelegate = localView.getTouchDelegate();
    if ((localTouchDelegate instanceof KindaTouchDelegate))
    {
      ((KindaTouchDelegate)localTouchDelegate).addDelegate(localRect, this.val$view);
      AppMethodBeat.o(226444);
      return;
    }
    localView.setTouchDelegate(new KindaTouchDelegate(localRect, this.val$view));
    AppMethodBeat.o(226444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.MMKViewUtil.1
 * JD-Core Version:    0.7.0.1
 */