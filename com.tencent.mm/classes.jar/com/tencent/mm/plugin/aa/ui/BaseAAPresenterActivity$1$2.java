package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BaseAAPresenterActivity$1$2
  implements Runnable
{
  BaseAAPresenterActivity$1$2(BaseAAPresenterActivity.1 param1) {}
  
  public final void run()
  {
    this.eYm.eYl.VH();
    if (this.eYm.eYg) {
      ((InputMethodManager)this.eYm.eYl.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYm.eYi, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1.2
 * JD-Core Version:    0.7.0.1
 */