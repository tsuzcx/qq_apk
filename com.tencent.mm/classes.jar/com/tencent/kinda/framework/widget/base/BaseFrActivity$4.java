package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseFrActivity$4
  implements Runnable
{
  BaseFrActivity$4(BaseFrActivity paramBaseFrActivity, View paramView, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(144645);
    this.val$rootView.scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(144645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.4
 * JD-Core Version:    0.7.0.1
 */