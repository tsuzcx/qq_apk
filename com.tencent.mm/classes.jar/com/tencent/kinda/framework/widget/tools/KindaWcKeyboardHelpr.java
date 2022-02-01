package com.tencent.kinda.framework.widget.tools;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.kinda.framework.widget.base.BaseFrActivity.IWalletTenpayKBStateCallBackListener;
import com.tencent.kinda.framework.widget.base.BaseFragment;
import com.tencent.kinda.framework.widget.base.FrLifeController;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f;

public class KindaWcKeyboardHelpr
{
  private static String TAG = "MicroMsg.KindaWcKeyboardHelper";
  
  public static WcPayKeyboard bind(UIPageFragmentActivity paramUIPageFragmentActivity, final EditText paramEditText, String paramString, final BaseFrActivity.IWalletTenpayKBStateCallBackListener paramIWalletTenpayKBStateCallBackListener)
  {
    AppMethodBeat.i(193257);
    final WcPayKeyboard localWcPayKeyboard = (WcPayKeyboard)paramUIPageFragmentActivity.gtK.getCurrent().findViewById(2131308467);
    if (localWcPayKeyboard != null) {
      ae.i(TAG, "has exist keyboard");
    }
    for (;;)
    {
      if (!bu.isNullOrNil(paramString)) {
        localWcPayKeyboard.setActionText(paramString);
      }
      f.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        private boolean firstTime = true;
        
        public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(193256);
          if (paramAnonymousBoolean)
          {
            ((InputMethodManager)this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
            new aq().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(193254);
                if ((!KindaWcKeyboardHelpr.1.this.val$finalKeyboard.isShown()) && (paramAnonymousView.isShown()))
                {
                  KindaWcKeyboardHelpr.1.this.val$finalKeyboard.showNormalStWcKb();
                  KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(true, 0.0F);
                  KindaWcKeyboardHelpr.1.access$002(KindaWcKeyboardHelpr.1.this, false);
                }
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard.setInputEditText(KindaWcKeyboardHelpr.1.this.val$editText);
                ((InputMethodManager)KindaWcKeyboardHelpr.1.this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                AppMethodBeat.o(193254);
              }
            }, 200L);
          }
          for (;;)
          {
            if (this.val$finalOrigFocusListener != null) {
              this.val$finalOrigFocusListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
            }
            AppMethodBeat.o(193256);
            return;
            new aq().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(193255);
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard1.hideWcKb();
                KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(false, 0.0F);
                AppMethodBeat.o(193255);
              }
            }, 200L);
          }
        }
      });
      AppMethodBeat.o(193257);
      return localWcPayKeyboard;
      localWcPayKeyboard = new WcPayKeyboard(paramUIPageFragmentActivity);
      localWcPayKeyboard.setId(2131308467);
      FrameLayout localFrameLayout = (FrameLayout)paramUIPageFragmentActivity.gtK.getCurrent().findViewById(2131308264);
      if (localFrameLayout == null)
      {
        ae.w(TAG, "can not find content layout");
        AppMethodBeat.o(193257);
        return null;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 80;
      localFrameLayout.addView(localWcPayKeyboard, localLayoutParams);
      localWcPayKeyboard.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr
 * JD-Core Version:    0.7.0.1
 */