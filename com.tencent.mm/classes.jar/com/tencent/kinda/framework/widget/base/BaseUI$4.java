package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class BaseUI$4
  implements Runnable
{
  BaseUI$4(BaseUI paramBaseUI, View paramView, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(144653);
    this.val$rootView.scrollBy(0, this.val$scrollDistance);
    AppMethodBeat.o(144653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.4
 * JD-Core Version:    0.7.0.1
 */