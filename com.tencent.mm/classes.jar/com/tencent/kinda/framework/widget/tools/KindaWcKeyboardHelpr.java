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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;

public class KindaWcKeyboardHelpr
{
  private static String TAG = "MicroMsg.KindaWcKeyboardHelper";
  
  public static WcPayKeyboard bind(UIPageFragmentActivity paramUIPageFragmentActivity, final EditText paramEditText, String paramString, final BaseFrActivity.IWalletTenpayKBStateCallBackListener paramIWalletTenpayKBStateCallBackListener)
  {
    AppMethodBeat.i(199540);
    final WcPayKeyboard localWcPayKeyboard = (WcPayKeyboard)paramUIPageFragmentActivity.grk.getCurrent().findViewById(2131308467);
    if (localWcPayKeyboard != null) {
      ad.i(TAG, "has exist keyboard");
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString)) {
        localWcPayKeyboard.setActionText(paramString);
      }
      e.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        private boolean firstTime = true;
        
        public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(199539);
          if (paramAnonymousBoolean)
          {
            ((InputMethodManager)this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
            new ap().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(199537);
                if ((!KindaWcKeyboardHelpr.1.this.val$finalKeyboard.isShown()) && (paramAnonymousView.isShown()))
                {
                  KindaWcKeyboardHelpr.1.this.val$finalKeyboard.showNormalStWcKb();
                  KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(true, 0.0F);
                  KindaWcKeyboardHelpr.1.access$002(KindaWcKeyboardHelpr.1.this, false);
                }
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard.setInputEditText(KindaWcKeyboardHelpr.1.this.val$editText);
                ((InputMethodManager)KindaWcKeyboardHelpr.1.this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                AppMethodBeat.o(199537);
              }
            }, 200L);
          }
          for (;;)
          {
            if (this.val$finalOrigFocusListener != null) {
              this.val$finalOrigFocusListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
            }
            AppMethodBeat.o(199539);
            return;
            new ap().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(199538);
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard1.hideWcKb();
                KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(false, 0.0F);
                AppMethodBeat.o(199538);
              }
            }, 200L);
          }
        }
      });
      AppMethodBeat.o(199540);
      return localWcPayKeyboard;
      localWcPayKeyboard = new WcPayKeyboard(paramUIPageFragmentActivity);
      localWcPayKeyboard.setId(2131308467);
      FrameLayout localFrameLayout = (FrameLayout)paramUIPageFragmentActivity.grk.getCurrent().findViewById(2131308264);
      if (localFrameLayout == null)
      {
        ad.w(TAG, "can not find content layout");
        AppMethodBeat.o(199540);
        return null;
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 80;
      localFrameLayout.addView(localWcPayKeyboard, localLayoutParams);
      localWcPayKeyboard.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaWcKeyboardHelpr
 * JD-Core Version:    0.7.0.1
 */