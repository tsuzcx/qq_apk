package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$7
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$7(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42061);
    if ((!this.ojQ.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.ojQ.mKBLayout.setVisibility(0);
      this.ojQ.mKeyboard.setInputEditText((EditText)paramView);
      WxaLuckyMoneyPrepareUI.b(this.ojQ, this.val$editMode);
      AppMethodBeat.o(42061);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.ojQ.mKBLayout.setVisibility(8);
      ((InputMethodManager)this.ojQ.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(42061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.7
 * JD-Core Version:    0.7.0.1
 */