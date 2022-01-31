package com.tencent.kinda.framework.widget.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tenpay.android.wechat.MyKeyboardWindow;

class BaseFrActivity$1
  implements View.OnFocusChangeListener
{
  BaseFrActivity$1(BaseFrActivity paramBaseFrActivity, boolean paramBoolean1, View paramView1, boolean paramBoolean2, View paramView2, MyKeyboardWindow paramMyKeyboardWindow, EditText paramEditText, int paramInt) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(144642);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.this$0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new BaseFrActivity.1.1(this, paramView), 300L);
      AppMethodBeat.o(144642);
      return;
    }
    new ak().postDelayed(new BaseFrActivity.1.2(this), 200L);
    AppMethodBeat.o(144642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.1
 * JD-Core Version:    0.7.0.1
 */