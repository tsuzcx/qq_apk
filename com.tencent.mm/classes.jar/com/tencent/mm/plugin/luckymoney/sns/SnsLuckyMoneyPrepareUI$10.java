package com.tencent.mm.plugin.luckymoney.sns;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$10
  implements View.OnFocusChangeListener
{
  SnsLuckyMoneyPrepareUI$10(SnsLuckyMoneyPrepareUI paramSnsLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onFocusChange(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(283871);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.Kwc.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(283880);
          if ((!SnsLuckyMoneyPrepareUI.10.this.Kwc.mKBLayout.isShown()) && (paramView.isShown())) {
            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.10.this.Kwc);
          }
          SnsLuckyMoneyPrepareUI.b(SnsLuckyMoneyPrepareUI.10.this.Kwc, SnsLuckyMoneyPrepareUI.10.this.val$editMode);
          SnsLuckyMoneyPrepareUI.10.this.Kwc.mKeyboard.setInputEditText((EditText)paramView);
          ((InputMethodManager)SnsLuckyMoneyPrepareUI.10.this.Kwc.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
          AppMethodBeat.o(283880);
        }
      }, 300L);
      AppMethodBeat.o(283871);
      return;
    }
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283878);
        SnsLuckyMoneyPrepareUI.10.this.Kwc.hideTenpayKB();
        ((InputMethodManager)SnsLuckyMoneyPrepareUI.10.this.Kwc.getContext().getSystemService("input_method")).showSoftInput(SnsLuckyMoneyPrepareUI.10.this.val$hintTv, 0);
        AppMethodBeat.o(283878);
      }
    }, 200L);
    AppMethodBeat.o(283871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */