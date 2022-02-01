package com.tencent.mm.plugin.aa.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.k;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity
  extends WalletBaseUI
{
  private static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 300);
  private com.tencent.mm.vending.app.c mGc = new com.tencent.mm.vending.app.c();
  protected View pKd;
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T aI(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.mGc.a(this, paramClass);
  }
  
  public final <T extends com.tencent.mm.vending.app.a> T aM(Class<? extends com.tencent.mm.vending.app.a> paramClass)
  {
    return this.mGc.b(this, paramClass);
  }
  
  public void hideTenpayKB()
  {
    super.hideTenpayKB();
    if (this.pKd != null) {
      this.pKd.scrollTo(0, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mGc.z(getIntent(), this);
    this.isVKBFirstTimeShown = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mGc.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mGc.aFE(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mGc.aFE(2);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setEditFocusListener(final View paramView, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    final EditText localEditText = (EditText)paramView.findViewById(a.f.wallet_content);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null)) {
      return;
    }
    this.mKBLayout.setVisibility(8);
    i.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63569);
        if ((paramAnonymousView.isFocused()) && (!paramBoolean1))
        {
          ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63567);
              Object localObject;
              if ((!BaseAAPresenterActivity.a(BaseAAPresenterActivity.this).isShown()) && (paramAnonymousView.isShown()))
              {
                if (BaseAAPresenterActivity.1.this.val$isShowFirstTime)
                {
                  BaseAAPresenterActivity.this.showTenpayKB();
                  BaseAAPresenterActivity.c(BaseAAPresenterActivity.this);
                  BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, BaseAAPresenterActivity.1.this.val$hintTv);
                }
              }
              else if (((BaseAAPresenterActivity.1.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
              {
                localObject = (WalletFormView)BaseAAPresenterActivity.1.this.val$parent;
                if (((z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
                  break label325;
                }
                localObject = new com.tencent.mm.wallet_core.c();
                BaseAAPresenterActivity.d(BaseAAPresenterActivity.this).setSecureAccessibility((View.AccessibilityDelegate)localObject);
                BaseAAPresenterActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
              }
              for (;;)
              {
                if (((BaseAAPresenterActivity.1.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                {
                  localObject = new com.tencent.mm.wallet_core.c();
                  BaseAAPresenterActivity.f(BaseAAPresenterActivity.this).setSecureAccessibility((View.AccessibilityDelegate)localObject);
                  BaseAAPresenterActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                }
                BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, BaseAAPresenterActivity.1.this.val$editMode);
                BaseAAPresenterActivity.g(BaseAAPresenterActivity.this).setInputEditText((EditText)paramAnonymousView);
                ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                AppMethodBeat.o(63567);
                return;
                if (BaseAAPresenterActivity.b(BaseAAPresenterActivity.this)) {
                  break;
                }
                BaseAAPresenterActivity.this.showTenpayKB();
                break;
                label325:
                BaseAAPresenterActivity.e(BaseAAPresenterActivity.this).resetSecureAccessibility();
                BaseAAPresenterActivity.1.this.val$hintTv.setAccessibilityDelegate(null);
              }
            }
          }, 300L);
          AppMethodBeat.o(63569);
          return;
        }
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(63568);
            BaseAAPresenterActivity.this.hideTenpayKB();
            if (BaseAAPresenterActivity.1.this.val$isShowSysKB) {
              ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).showSoftInput(BaseAAPresenterActivity.1.this.val$hintTv, 0);
            }
            AppMethodBeat.o(63568);
          }
        }, 200L);
        AppMethodBeat.o(63569);
      }
    });
    localEditText.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(268506);
        if ((!BaseAAPresenterActivity.h(BaseAAPresenterActivity.this).isShown()) && (!paramBoolean1))
        {
          BaseAAPresenterActivity.this.showTenpayKB();
          BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, localEditText);
          BaseAAPresenterActivity.b(BaseAAPresenterActivity.this, paramInt);
          AppMethodBeat.o(268506);
          return;
        }
        if (paramBoolean1)
        {
          BaseAAPresenterActivity.this.hideTenpayKB();
          ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
        }
        AppMethodBeat.o(268506);
      }
    });
    localView.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(268524);
        BaseAAPresenterActivity.this.hideTenpayKB();
        AppMethodBeat.o(268524);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity
 * JD-Core Version:    0.7.0.1
 */