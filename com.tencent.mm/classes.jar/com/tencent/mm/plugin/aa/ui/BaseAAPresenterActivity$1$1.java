package com.tencent.mm.plugin.aa.ui;

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

final class BaseAAPresenterActivity$1$1
  implements Runnable
{
  BaseAAPresenterActivity$1$1(BaseAAPresenterActivity.1 param1, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(40775);
    Object localObject;
    if ((!BaseAAPresenterActivity.a(this.gqd.gqc).isShown()) && (this.val$view.isShown()))
    {
      if (this.gqd.val$isShowFirstTime)
      {
        this.gqd.gqc.showTenpayKB();
        BaseAAPresenterActivity.c(this.gqd.gqc);
        BaseAAPresenterActivity.a(this.gqd.gqc, this.gqd.val$hintTv);
      }
    }
    else if (((this.gqd.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
    {
      localObject = (WalletFormView)this.gqd.val$parent;
      if (((r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
        break label325;
      }
      localObject = new c();
      BaseAAPresenterActivity.d(this.gqd.gqc).setSecureAccessibility((View.AccessibilityDelegate)localObject);
      this.gqd.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    for (;;)
    {
      if (((this.gqd.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
      {
        localObject = new c();
        BaseAAPresenterActivity.f(this.gqd.gqc).setSecureAccessibility((View.AccessibilityDelegate)localObject);
        this.gqd.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
      }
      BaseAAPresenterActivity.a(this.gqd.gqc, this.gqd.val$editMode);
      BaseAAPresenterActivity.g(this.gqd.gqc).setInputEditText((EditText)this.val$view);
      ((InputMethodManager)this.gqd.gqc.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
      AppMethodBeat.o(40775);
      return;
      if (BaseAAPresenterActivity.b(this.gqd.gqc)) {
        break;
      }
      this.gqd.gqc.showTenpayKB();
      break;
      label325:
      BaseAAPresenterActivity.e(this.gqd.gqc).resetSecureAccessibility();
      this.gqd.val$hintTv.setAccessibilityDelegate(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1.1
 * JD-Core Version:    0.7.0.1
 */