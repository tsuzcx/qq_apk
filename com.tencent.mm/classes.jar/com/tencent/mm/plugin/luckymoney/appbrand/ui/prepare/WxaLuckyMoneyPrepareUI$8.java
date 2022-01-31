package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$8
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$8(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42063);
    if ((this.ojQ.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      if (this.ojQ.mKeyboard != null)
      {
        this.ojQ.mKeyboard.setInputEditText(this.val$hintTv);
        AppMethodBeat.o(42063);
      }
    }
    else
    {
      if ((!this.ojQ.mKBLayout.isShown()) && (!this.val$isShowSysKB))
      {
        ((InputMethodManager)this.ojQ.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        new ak().postDelayed(new WxaLuckyMoneyPrepareUI.8.1(this), 200L);
        AppMethodBeat.o(42063);
        return;
      }
      if (this.val$isShowSysKB)
      {
        this.ojQ.mKBLayout.setVisibility(8);
        ((InputMethodManager)this.ojQ.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
      }
    }
    AppMethodBeat.o(42063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */