package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

class BaseUI$1
  implements View.OnFocusChangeListener
{
  BaseUI$1(BaseUI paramBaseUI, boolean paramBoolean1, boolean paramBoolean2, View paramView, EditText paramEditText, int paramInt) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(144650);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)BaseUI.access$000(this.this$0).getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new BaseUI.1.1(this, paramView), 300L);
      AppMethodBeat.o(144650);
      return;
    }
    new ak().postDelayed(new BaseUI.1.2(this), 200L);
    AppMethodBeat.o(144650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI.1
 * JD-Core Version:    0.7.0.1
 */