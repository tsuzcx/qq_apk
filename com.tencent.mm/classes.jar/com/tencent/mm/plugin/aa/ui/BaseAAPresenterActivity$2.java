package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseAAPresenterActivity$2
  implements View.OnClickListener
{
  BaseAAPresenterActivity$2(BaseAAPresenterActivity paramBaseAAPresenterActivity, boolean paramBoolean, EditText paramEditText, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40778);
    if ((!BaseAAPresenterActivity.h(this.gqc).isShown()) && (!this.val$isShowSysKB))
    {
      this.gqc.showTenpayKB();
      BaseAAPresenterActivity.a(this.gqc, this.val$hintTv);
      BaseAAPresenterActivity.b(this.gqc, this.val$editMode);
      AppMethodBeat.o(40778);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.gqc.hideTenpayKB();
      ((InputMethodManager)this.gqc.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(40778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.2
 * JD-Core Version:    0.7.0.1
 */