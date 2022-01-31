package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseAAPresenterActivity$1$2
  implements Runnable
{
  BaseAAPresenterActivity$1$2(BaseAAPresenterActivity.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(40776);
    this.gqd.gqc.hideTenpayKB();
    if (this.gqd.val$isShowSysKB) {
      ((InputMethodManager)this.gqd.gqc.getContext().getSystemService("input_method")).showSoftInput(this.gqd.val$hintTv, 0);
    }
    AppMethodBeat.o(40776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1.2
 * JD-Core Version:    0.7.0.1
 */