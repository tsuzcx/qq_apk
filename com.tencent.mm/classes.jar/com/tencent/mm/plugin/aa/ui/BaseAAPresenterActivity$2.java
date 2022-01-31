package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class BaseAAPresenterActivity$2
  implements View.OnClickListener
{
  BaseAAPresenterActivity$2(BaseAAPresenterActivity paramBaseAAPresenterActivity, boolean paramBoolean, EditText paramEditText, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if ((!BaseAAPresenterActivity.h(this.eYl).isShown()) && (!this.eYg))
    {
      this.eYl.cNi();
      BaseAAPresenterActivity.a(this.eYl, this.eYi);
      BaseAAPresenterActivity.b(this.eYl, this.eYk);
    }
    while (!this.eYg) {
      return;
    }
    this.eYl.VH();
    ((InputMethodManager)this.eYl.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.2
 * JD-Core Version:    0.7.0.1
 */