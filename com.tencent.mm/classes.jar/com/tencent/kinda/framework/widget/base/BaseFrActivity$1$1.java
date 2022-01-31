package com.tencent.kinda.framework.widget.base;

import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

class BaseFrActivity$1$1
  implements Runnable
{
  BaseFrActivity$1$1(BaseFrActivity.1 param1, View paramView) {}
  
  public void run()
  {
    AppMethodBeat.i(144640);
    Object localObject = this.this$1.this$0.getKBLayout();
    if (this.this$1.val$mKBLayout == localObject) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(144640);
      return;
    }
    if ((!this.this$1.val$mKBLayout.isShown()) && (this.val$view.getVisibility() == 0) && ((this.this$1.val$isShowFirstTime) || (this.this$1.this$0.isVKBFirstTimeShown)))
    {
      this.this$1.this$0.isVKBFirstTimeShown = true;
      this.this$1.this$0.showTenpayKB();
    }
    if (((this.this$1.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
    {
      localObject = (WalletFormView)this.this$1.val$parent;
      if (((r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
        break label322;
      }
      localObject = new c();
      this.this$1.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      this.this$1.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    for (;;)
    {
      if (((this.this$1.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
      {
        localObject = new c();
        this.this$1.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
        this.this$1.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
      }
      this.this$1.val$mKeyboard.setXMode(this.this$1.val$editMode);
      this.this$1.val$mKeyboard.setInputEditText((EditText)this.val$view);
      ((InputMethodManager)this.this$1.this$0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
      AppMethodBeat.o(144640);
      return;
      label322:
      this.this$1.val$mKeyboard.resetSecureAccessibility();
      this.this$1.val$hintTv.setAccessibilityDelegate(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity.1.1
 * JD-Core Version:    0.7.0.1
 */