package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;
import java.util.List;

public abstract class BaseFrActivity
  extends MMActivity
{
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  public static final String TAG = "MicroMsg.BaseFrActivity";
  private final int PWD_INPUT_VIEW_AND_KEYBOARD_GAP_PX = 26;
  private boolean isDestroyByThisFinish = false;
  protected boolean isVKBFirstTimeShown = false;
  public IWalletTenpayKBStateCallBackListener mTenpayKBStateCallBackListener;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private View m_scrollViewBecouseOfKeyBoard = null;
  
  public View findViewById(int paramInt)
  {
    return super.findViewById(paramInt);
  }
  
  public void finish()
  {
    super.finish();
    this.isDestroyByThisFinish = true;
    ActivityController.detach(this);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BaseFrActivity", "BaseFrActivity finish exec! " + android.util.Log.getStackTraceString(new Throwable("the stack of finish: ")));
  }
  
  protected View getKBLayout()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return findViewById(2131308960);
    }
    return ((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131308960);
  }
  
  protected MyKeyboardWindow getKeyboard()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return (MyKeyboardWindow)findViewById(2131308962);
    }
    return (MyKeyboardWindow)((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131308962);
  }
  
  protected LinearLayout getMainContainer()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return null;
    }
    return (LinearLayout)((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131299174);
  }
  
  protected TenpaySecureEditText getTenpaySecureEditText()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {}
    for (View localView = findViewById(2131310180); (localView instanceof TenpaySecureEditText); localView = ((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131310180)) {
      return (TenpaySecureEditText)localView;
    }
    return null;
  }
  
  public void hideTenpayKB()
  {
    View localView = getKBLayout();
    if ((localView != null) && (localView.isShown()))
    {
      localView.setVisibility(8);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
      if (this.mTenpayKBStateCallBackListener != null) {
        this.mTenpayKBStateCallBackListener.onCallBackKinda(false, localView.getHeight());
      }
    }
  }
  
  public boolean needToShowClearIcon(TenpaySecureEditText paramTenpaySecureEditText)
  {
    return (!paramTenpaySecureEditText.getText().toString().equals("")) && (TenpaySecureEditText.EditState.PASSWORD != paramTenpaySecureEditText.getEditState()) && (TenpaySecureEditText.EditState.CVV_PAYMENT != paramTenpaySecureEditText.getEditState()) && (TenpaySecureEditText.EditState.CVV_4_PAYMENT != paramTenpaySecureEditText.getEditState());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BaseFrActivity", "onCreate");
    super.onCreate(paramBundle);
    ActivityController.attach(this);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BaseFrActivity", "onDestroy");
    if (!this.isDestroyByThisFinish) {
      ActivityController.detach(this);
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    ActivityController.attach(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void scrollPwdInputViewOnTopOfKeyBoard(View paramView, int paramInt)
  {
    if ((paramView instanceof TenpaySecureEditText))
    {
      int i = paramInt;
      if (paramInt <= 0) {
        i = (int)(getResources().getDisplayMetrics().density * 270.0F + 0.5F);
      }
      paramInt = paramView.getHeight();
      int k = getController().GDE.getHeight();
      Object localObject1 = new int[2];
      paramView.getLocationOnScreen((int[])localObject1);
      int j = localObject1[1];
      k -= j + paramInt;
      if (k < i)
      {
        paramView = getMainContainer();
        if (paramView != null)
        {
          View localView = paramView.getChildAt(0);
          Object localObject2 = null;
          paramView = localObject2;
          localObject1 = localView;
          if (localView != null)
          {
            paramView = localObject2;
            localObject1 = localView;
            if ((localView instanceof YogaLayout))
            {
              paramView = (YogaLayout)localView;
              localObject1 = localView;
            }
          }
          while ((paramView != null) && (paramView.getHeight() < j + paramInt))
          {
            localView = paramView.getChildAt(0);
            localObject1 = localView;
            if (localView != null)
            {
              localObject1 = localView;
              if ((localView instanceof YogaLayout))
              {
                paramView = (YogaLayout)localView;
                localObject1 = localView;
              }
            }
          }
          if (localObject1 != null)
          {
            ((View)localObject1).scrollTo(0, i - k + 26);
            this.m_scrollViewBecouseOfKeyBoard = ((View)localObject1);
          }
        }
      }
    }
  }
  
  public void scrollTo(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null) {
      paramView.scrollTo(paramInt1, paramInt2);
    }
  }
  
  public void scrollToFormEditPosAfterShowTenPay(final View paramView1, View paramView2, final int paramInt)
  {
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cb.a.jo(getContext());
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(18761);
            paramView1.scrollBy(0, paramInt);
            AppMethodBeat.o(18761);
          }
        });
      }
    }
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
  }
  
  @TargetApi(14)
  public void setEditFocusListener(final View paramView, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    final MyKeyboardWindow localMyKeyboardWindow = getKeyboard();
    final View localView1 = getKBLayout();
    if ((localMyKeyboardWindow == null) || (localView1 == null)) {}
    for (;;)
    {
      return;
      View localView2 = localView1.findViewById(2131308963);
      if ((paramView instanceof TenpaySecureEditText)) {}
      for (final EditText localEditText = (EditText)paramView; localEditText != null; localEditText = (EditText)paramView.findViewById(2131310180))
      {
        f.setNoSystemInputOnEditText(localEditText);
        localEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(18758);
            if ((paramAnonymousView.isFocused()) && (!paramBoolean1))
            {
              ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              new MMHandler().postDelayed(new Runnable()
              {
                public void run()
                {
                  AppMethodBeat.i(18756);
                  Object localObject = BaseFrActivity.this.getKBLayout();
                  if (BaseFrActivity.1.this.val$mKBLayout == localObject) {}
                  for (int i = 1; i == 0; i = 0)
                  {
                    AppMethodBeat.o(18756);
                    return;
                  }
                  if ((!BaseFrActivity.1.this.val$mKBLayout.isShown()) && (paramAnonymousView.getVisibility() == 0) && ((BaseFrActivity.1.this.val$isShowFirstTime) || (BaseFrActivity.this.isVKBFirstTimeShown)))
                  {
                    BaseFrActivity.this.isVKBFirstTimeShown = true;
                    BaseFrActivity.this.showTenpayKB();
                  }
                  if (((BaseFrActivity.1.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
                  {
                    localObject = (WalletFormView)BaseFrActivity.1.this.val$parent;
                    if (((!z.aUo()) && (((WalletFormView)localObject).getEncrptType() != 100)) || ((z.aUo()) && (((WalletFormView)localObject).getEncrptType() != 0)))
                    {
                      localObject = new com.tencent.mm.ui.a.d();
                      BaseFrActivity.1.this.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                      BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                    }
                  }
                  else if (((BaseFrActivity.1.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                  {
                    localObject = new com.tencent.mm.ui.a.d();
                    BaseFrActivity.1.this.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                    BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scK, 1) != 1) {
                      break label423;
                    }
                  }
                  label423:
                  for (i = 1;; i = 0)
                  {
                    if ((i != 0) && (com.tencent.mm.compatible.util.d.oD(30)) && (a.a.gKe().gKc()))
                    {
                      h.CyF.dN(1624, 11);
                      localObject = new c();
                      BaseFrActivity.1.this.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                    }
                    BaseFrActivity.1.this.val$mKeyboard.setXMode(BaseFrActivity.1.this.val$editMode);
                    BaseFrActivity.1.this.val$mKeyboard.setInputEditText((EditText)paramAnonymousView);
                    ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                    AppMethodBeat.o(18756);
                    return;
                    BaseFrActivity.1.this.val$mKeyboard.resetSecureAccessibility();
                    BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate(null);
                    break;
                  }
                }
              }, 300L);
            }
            while ((paramAnonymousView instanceof TenpaySecureEditText))
            {
              paramAnonymousView = (TenpaySecureEditText)paramAnonymousView;
              if ((paramAnonymousView.getTag() instanceof MMKEditText))
              {
                MMKEditText localMMKEditText = (MMKEditText)paramAnonymousView.getTag();
                if (!paramAnonymousView.isFocused())
                {
                  localMMKEditText.setVisibleClearIcon(false);
                  localMMKEditText.callBackKindaTextEndEditing();
                  AppMethodBeat.o(18758);
                  return;
                  new MMHandler().postDelayed(new Runnable()
                  {
                    public void run()
                    {
                      AppMethodBeat.i(18757);
                      BaseFrActivity.this.hideTenpayKB();
                      if (BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard != null)
                      {
                        BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard.scrollTo(0, 0);
                        BaseFrActivity.access$002(BaseFrActivity.this, null);
                      }
                      if (BaseFrActivity.1.this.val$isShowSysKB) {
                        ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).showSoftInput(BaseFrActivity.1.this.val$hintTv, 0);
                      }
                      AppMethodBeat.o(18757);
                    }
                  }, 200L);
                }
                else
                {
                  if (BaseFrActivity.this.needToShowClearIcon(paramAnonymousView)) {
                    localMMKEditText.setVisibleClearIcon(true);
                  }
                  AppMethodBeat.o(18758);
                }
              }
              else
              {
                if ((paramAnonymousView.getTag() instanceof KindaSecureEditTextImpl))
                {
                  if (!paramAnonymousView.isFocused())
                  {
                    ((KindaSecureEditTextImpl)paramAnonymousView.getTag()).setVisibleClearIcon(false);
                    AppMethodBeat.o(18758);
                    return;
                  }
                  if (BaseFrActivity.this.needToShowClearIcon(paramAnonymousView)) {
                    ((KindaSecureEditTextImpl)paramAnonymousView.getTag()).setVisibleClearIcon(true);
                  }
                  AppMethodBeat.o(18758);
                  return;
                }
                if (!paramAnonymousView.isFocused())
                {
                  paramAnonymousView.setCompoundDrawables(paramAnonymousView.getCompoundDrawables()[0], paramAnonymousView.getCompoundDrawables()[1], null, paramAnonymousView.getCompoundDrawables()[3]);
                  AppMethodBeat.o(18758);
                  return;
                }
                if (BaseFrActivity.this.needToShowClearIcon(paramAnonymousView)) {
                  paramAnonymousView.setCompoundDrawables(paramAnonymousView.getCompoundDrawables()[0], paramAnonymousView.getCompoundDrawables()[1], paramAnonymousView.getClearBtnDrawable(), paramAnonymousView.getCompoundDrawables()[3]);
                }
              }
            }
            AppMethodBeat.o(18758);
          }
        });
        localEditText.setOnClickListener(new View.OnClickListener()
        {
          private byte _hellAccFlag_;
          
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(18759);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if ((!localView1.isShown()) && (!paramBoolean1))
            {
              BaseFrActivity.this.showTenpayKB();
              localMyKeyboardWindow.setXMode(paramInt);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(18759);
              return;
              if (paramBoolean1)
              {
                BaseFrActivity.this.hideTenpayKB();
                ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).showSoftInput(localEditText, 0);
              }
            }
          }
        });
        localView2.setOnClickListener(new View.OnClickListener()
        {
          private byte _hellAccFlag_;
          
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(18760);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/kinda/framework/widget/base/BaseFrActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            BaseFrActivity.this.hideTenpayKB();
            if (BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard != null)
            {
              BaseFrActivity.this.m_scrollViewBecouseOfKeyBoard.scrollTo(0, 0);
              BaseFrActivity.access$002(BaseFrActivity.this, null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseFrActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(18760);
          }
        });
        return;
      }
    }
  }
  
  public void setTenpayKBStateCallBackListener(IWalletTenpayKBStateCallBackListener paramIWalletTenpayKBStateCallBackListener)
  {
    this.mTenpayKBStateCallBackListener = paramIWalletTenpayKBStateCallBackListener;
  }
  
  public void setTenpayKBStateListener(com.tencent.mm.wallet_core.ui.a parama)
  {
    this.mTenpayKBStateListener = parama;
  }
  
  public void showTenpayKB()
  {
    View localView = getKBLayout();
    if ((localView != null) && (!localView.isShown()))
    {
      localView.setVisibility(0);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
      if (this.mTenpayKBStateCallBackListener != null) {
        this.mTenpayKBStateCallBackListener.onCallBackKinda(true, localView.getHeight());
      }
    }
  }
  
  public void showVKB()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (localInputMethodManager == null) {}
    View localView;
    do
    {
      return;
      localView = getCurrentFocus();
    } while ((localView == null) || (localView.getWindowToken() == null));
    localInputMethodManager.toggleSoftInput(0, 2);
  }
  
  public static abstract interface IWalletTenpayKBStateCallBackListener
  {
    public abstract void onCallBackKinda(boolean paramBoolean, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity
 * JD-Core Version:    0.7.0.1
 */