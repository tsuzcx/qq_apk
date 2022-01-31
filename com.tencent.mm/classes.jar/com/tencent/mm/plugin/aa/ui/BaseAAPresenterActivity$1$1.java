package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class BaseAAPresenterActivity$1$1
  implements Runnable
{
  BaseAAPresenterActivity$1$1(BaseAAPresenterActivity.1 param1, View paramView) {}
  
  public final void run()
  {
    Object localObject;
    if ((!BaseAAPresenterActivity.a(this.eYm.eYl).isShown()) && (this.val$view.isShown()))
    {
      if (this.eYm.eYh)
      {
        this.eYm.eYl.cNi();
        BaseAAPresenterActivity.c(this.eYm.eYl);
        BaseAAPresenterActivity.a(this.eYm.eYl, this.eYm.eYi);
      }
    }
    else if (((this.eYm.eYj instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
    {
      localObject = (WalletFormView)this.eYm.eYj;
      if (((q.Gw()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!q.Gw()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
        break label318;
      }
      localObject = new c();
      BaseAAPresenterActivity.d(this.eYm.eYl).setSecureAccessibility((View.AccessibilityDelegate)localObject);
      this.eYm.eYi.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    for (;;)
    {
      if (((this.eYm.eYj instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
      {
        localObject = new c();
        BaseAAPresenterActivity.f(this.eYm.eYl).setSecureAccessibility((View.AccessibilityDelegate)localObject);
        this.eYm.eYi.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
      }
      BaseAAPresenterActivity.a(this.eYm.eYl, this.eYm.eYk);
      BaseAAPresenterActivity.g(this.eYm.eYl).setInputEditText((EditText)this.val$view);
      ((InputMethodManager)this.eYm.eYl.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
      return;
      if (BaseAAPresenterActivity.b(this.eYm.eYl)) {
        break;
      }
      this.eYm.eYl.cNi();
      break;
      label318:
      BaseAAPresenterActivity.e(this.eYm.eYl).resetSecureAccessibility();
      this.eYm.eYi.setAccessibilityDelegate(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity.1.1
 * JD-Core Version:    0.7.0.1
 */