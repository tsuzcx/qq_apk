package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity
  extends WalletBaseUI
{
  private static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 300);
  private com.tencent.mm.vending.app.c gEm = new com.tencent.mm.vending.app.c();
  protected View iVL;
  
  public final <T extends com.tencent.mm.vending.c.b<? extends com.tencent.mm.vending.app.a>> T am(Class<? extends com.tencent.mm.vending.c.b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.gEm.a(this, paramClass);
  }
  
  public final <T extends com.tencent.mm.vending.app.a> T aq(Class<? extends com.tencent.mm.vending.app.a> paramClass)
  {
    return this.gEm.b(this, paramClass);
  }
  
  public void hideTenpayKB()
  {
    super.hideTenpayKB();
    if (this.iVL != null) {
      this.iVL.scrollTo(0, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.gEm.B(getIntent(), this);
    this.isVKBFirstTimeShown = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.gEm.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.gEm.afP(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.gEm.afP(2);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131305695));
    this.mKBLayout = findViewById(2131305693);
    View localView = findViewById(2131305696);
    final EditText localEditText = (EditText)paramView.findViewById(2131306718);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null)) {
      return;
    }
    this.mKBLayout.setVisibility(8);
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(63569);
        if ((paramAnonymousView.isFocused()) && (!paramBoolean1))
        {
          ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ap().postDelayed(new Runnable()
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
                if (((u.aAB()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!u.aAB()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
                  break label325;
                }
                localObject = new com.tencent.mm.ui.a.c();
                BaseAAPresenterActivity.d(BaseAAPresenterActivity.this).setSecureAccessibility((View.AccessibilityDelegate)localObject);
                BaseAAPresenterActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
              }
              for (;;)
              {
                if (((BaseAAPresenterActivity.1.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                {
                  localObject = new com.tencent.mm.ui.a.c();
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
        new ap().postDelayed(new Runnable()
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
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63570);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!BaseAAPresenterActivity.h(BaseAAPresenterActivity.this).isShown()) && (!paramBoolean1))
        {
          BaseAAPresenterActivity.this.showTenpayKB();
          BaseAAPresenterActivity.a(BaseAAPresenterActivity.this, localEditText);
          BaseAAPresenterActivity.b(BaseAAPresenterActivity.this, paramInt);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(63570);
          return;
          if (paramBoolean1)
          {
            BaseAAPresenterActivity.this.hideTenpayKB();
            ((InputMethodManager)BaseAAPresenterActivity.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
          }
        }
      }
    });
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(63571);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        BaseAAPresenterActivity.this.hideTenpayKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/aa/ui/BaseAAPresenterActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(63571);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity
 * JD-Core Version:    0.7.0.1
 */