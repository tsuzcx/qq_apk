package com.tencent.kinda.framework.widget.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

class BaseFrActivity$2
  implements View.OnClickListener
{
  BaseFrActivity$2(BaseFrActivity paramBaseFrActivity, View paramView, boolean paramBoolean, MyKeyboardWindow paramMyKeyboardWindow, int paramInt, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(144643);
    if ((!this.val$mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.this$0.showTenpayKB();
      this.val$mKeyboard.setXMode(this.val$editMode);
      AppMethodBeat.o(144643);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.this$0.hideTenpayKB();
      ((InputMethodManager)this.this$0.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(144643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.2
 * JD-Core Version:    0.7.0.1
 */