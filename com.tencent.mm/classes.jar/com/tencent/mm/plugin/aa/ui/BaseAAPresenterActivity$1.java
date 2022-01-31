package com.tencent.mm.plugin.aa.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class BaseAAPresenterActivity$1
  implements View.OnFocusChangeListener
{
  BaseAAPresenterActivity$1(BaseAAPresenterActivity paramBaseAAPresenterActivity, boolean paramBoolean1, boolean paramBoolean2, EditText paramEditText, View paramView, int paramInt) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(40777);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.gqc.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new BaseAAPresenterActivity.1.1(this, paramView), 300L);
      AppMethodBeat.o(40777);
      return;
    }
    new ak().postDelayed(new BaseAAPresenterActivity.1.2(this), 200L);
    AppMethodBeat.o(40777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1
 * JD-Core Version:    0.7.0.1
 */