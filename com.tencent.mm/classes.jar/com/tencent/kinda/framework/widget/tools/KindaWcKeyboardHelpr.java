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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.f;

public class KindaWcKeyboardHelpr
{
  private static String TAG = "MicroMsg.KindaWcKeyboardHelper";
  
  public static WcPayKeyboard bind(UIPageFragmentActivity paramUIPageFragmentActivity, final EditText paramEditText, String paramString, final BaseFrActivity.IWalletTenpayKBStateCallBackListener paramIWalletTenpayKBStateCallBackListener)
  {
    AppMethodBeat.i(214574);
    final WcPayKeyboard localWcPayKeyboard = (WcPayKeyboard)paramUIPageFragmentActivity.hgv.getCurrent().findViewById(2131310342);
    if (localWcPayKeyboard != null) {
      Log.i(TAG, "has exist keyboard");
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString)) {
        localWcPayKeyboard.setActionText(paramString);
      }
      f.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        private boolean firstTime = true;
        
        public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(214573);
          if (paramAnonymousBoolean)
          {
            ((InputMethodManager)this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
            new MMHandler().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(214571);
                if ((!KindaWcKeyboardHelpr.1.this.val$finalKeyboard.isShown()) && (paramAnonymousView.isShown()))
                {
                  KindaWcKeyboardHelpr.1.this.val$finalKeyboard.showNormalStWcKb();
                  KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(true, 0.0F);
                  KindaWcKeyboardHelpr.1.access$002(KindaWcKeyboardHelpr.1.this, false);
                }
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard.setInputEditText(KindaWcKeyboardHelpr.1.this.val$editText);
                ((InputMethodManager)KindaWcKeyboardHelpr.1.this.val$activity.getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                AppMethodBeat.o(214571);
              }
            }, 200L);
          }
          for (;;)
          {
            if (this.val$finalOrigFocusListener != null) {
              this.val$finalOrigFocusListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
            }
            AppMethodBeat.o(214573);
            return;
            new MMHandler().postDelayed(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(214572);
                KindaWcKeyboardHelpr.1.this.val$finalKeyboard1.hideWcKb();
                KindaWcKeyboardHelpr.1.this.val$keyboardListener.onCallBackKinda(false, 0.0F);
                AppMethodBeat.o(214572);
              }
            }, 200L);
          }
        }
      });
      AppMethodBeat.o(214574);
      return localWcPayKeyboard;
      localWcPayKeyboard = new WcPayKeyboard(paramUIPageFragmentActivity);
      localWcPayKeyboard.setId(2131310342);
      FrameLayout localFrameLayout = (FrameLayout)paramUIPageFragmentActivity.hgv.getCurrent().findViewById(2131299178);
      if (localFrameLayout == null)
      {
        Log.w(TAG, "can not find content layout");
        AppMethodBeat.o(214574);
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