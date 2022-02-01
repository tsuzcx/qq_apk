package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class BaseUI
  implements IExtendUI
{
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  public static final String TAG = "MicroMsg.BaseUI";
  protected boolean isVKBFirstTimeShown = false;
  protected View mKBLayout;
  protected MyKeyboardWindow mKeyboard;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private IBaseUIWrap wrap;
  
  static
  {
    AppMethodBeat.i(18778);
    HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 270);
    AppMethodBeat.o(18778);
  }
  
  public BaseUI(IBaseUIWrap paramIBaseUIWrap)
  {
    this.wrap = paramIBaseUIWrap;
  }
  
  public void hideTenpayKB()
  {
    AppMethodBeat.i(18773);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
    }
    AppMethodBeat.o(18773);
  }
  
  public void scrollTo(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18776);
    if (paramView != null) {
      paramView.scrollTo(paramInt1, paramInt2);
    }
    AppMethodBeat.o(18776);
  }
  
  public void scrollToFormEditPosAfterShowTenPay(final View paramView1, View paramView2, final int paramInt)
  {
    AppMethodBeat.i(18775);
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cc.a.ih(this.wrap.getContext());
      paramInt = j - i - com.tencent.mm.cc.a.fromDPToPix(this.wrap.getContext(), paramInt);
      ac.d("MicroMsg.BaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        ac.d("MicroMsg.BaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(18769);
            paramView1.scrollBy(0, paramInt);
            AppMethodBeat.o(18769);
          }
        });
      }
    }
    AppMethodBeat.o(18775);
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(18770);
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
    AppMethodBeat.o(18770);
  }
  
  @TargetApi(14)
  public void setEditFocusListener(final View paramView, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(18771);
    this.mKeyboard = ((MyKeyboardWindow)this.wrap.findViewById(2131305695));
    this.mKBLayout = this.wrap.findViewById(2131305693);
    View localView = this.wrap.findViewById(2131305696);
    if ((paramView instanceof TenpaySecureEditText)) {}
    for (final EditText localEditText = (EditText)paramView; (this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null); localEditText = (EditText)paramView.findViewById(2131306718))
    {
      AppMethodBeat.o(18771);
      return;
    }
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(18766);
        if ((paramAnonymousView.isFocused()) && (!paramBoolean1))
        {
          ((InputMethodManager)BaseUI.this.wrap.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new ao().postDelayed(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(18764);
              if ((!BaseUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown()) && ((BaseUI.1.this.val$isShowFirstTime) || (BaseUI.this.isVKBFirstTimeShown)))
              {
                BaseUI.this.isVKBFirstTimeShown = true;
                BaseUI.this.showTenpayKB();
              }
              Object localObject;
              if (((BaseUI.1.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
              {
                localObject = (WalletFormView)BaseUI.1.this.val$parent;
                if (((u.axL()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!u.axL()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
                  break label302;
                }
                localObject = new c();
                BaseUI.this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                BaseUI.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
              }
              for (;;)
              {
                if (((BaseUI.1.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                {
                  localObject = new c();
                  BaseUI.this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                  BaseUI.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                }
                BaseUI.this.setKBMode(BaseUI.1.this.val$editMode);
                BaseUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
                ((InputMethodManager)BaseUI.this.wrap.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                AppMethodBeat.o(18764);
                return;
                label302:
                BaseUI.this.mKeyboard.resetSecureAccessibility();
                BaseUI.1.this.val$hintTv.setAccessibilityDelegate(null);
              }
            }
          }, 300L);
          AppMethodBeat.o(18766);
          return;
        }
        new ao().postDelayed(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(18765);
            BaseUI.this.hideTenpayKB();
            ((InputMethodManager)BaseUI.this.wrap.getContext().getSystemService("input_method")).showSoftInput(BaseUI.1.this.val$hintTv, 0);
            AppMethodBeat.o(18765);
          }
        }, 200L);
        AppMethodBeat.o(18766);
      }
    });
    localEditText.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18767);
        if ((!BaseUI.this.mKBLayout.isShown()) && (!paramBoolean1))
        {
          BaseUI.this.showTenpayKB();
          BaseUI.this.setKBMode(paramInt);
          AppMethodBeat.o(18767);
          return;
        }
        if (paramBoolean1)
        {
          BaseUI.this.hideTenpayKB();
          ((InputMethodManager)BaseUI.this.wrap.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
        }
        AppMethodBeat.o(18767);
      }
    });
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18768);
        BaseUI.this.hideTenpayKB();
        AppMethodBeat.o(18768);
      }
    });
    AppMethodBeat.o(18771);
  }
  
  protected void setKBMode(int paramInt)
  {
    AppMethodBeat.i(18772);
    this.mKeyboard.setXMode(paramInt);
    AppMethodBeat.o(18772);
  }
  
  public void setTenpayKBStateListener(com.tencent.mm.wallet_core.ui.a parama)
  {
    this.mTenpayKBStateListener = parama;
  }
  
  public void showTenpayKB()
  {
    AppMethodBeat.i(18774);
    if ((this.mKBLayout != null) && (!this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(0);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
    AppMethodBeat.o(18774);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(18777);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.wrap.getContext().getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(18777);
      return;
    }
    View localView = this.wrap.getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(18777);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(18777);
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
    AppMethodBeat.o(18777);
  }
  
  public static abstract interface IBaseUIWrap
  {
    public abstract View findViewById(int paramInt);
    
    public abstract Context getContext();
    
    public abstract View getCurrentFocus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI
 * JD-Core Version:    0.7.0.1
 */