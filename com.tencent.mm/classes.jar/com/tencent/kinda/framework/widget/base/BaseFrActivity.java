package com.tencent.kinda.framework.widget.base;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import com.tenpay.android.wechat.TenpaySecureEditText.EditState;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.ListIterator;

public abstract class BaseFrActivity
  extends MMActivity
{
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  public static final String TAG = "MicroMsg.BaseFrActivity";
  private final int PWD_INPUT_VIEW_AND_KEYBOARD_GAP_PX = 26;
  private boolean isDestroyByThisFinish = false;
  protected boolean isVKBFirstTimeShown = false;
  public IWalletTenpayKBStateCallBackListener mTenpayKBStateCallBackListener;
  private com.tencent.mm.wallet_core.ui.a mTenpayKBStateListener;
  private View m_scrollViewBecouseOfKeyBoard = null;
  
  public static BaseFragment topShowFragmentOf(List<Fragment> paramList)
  {
    if (paramList == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "fragmentList == null.");
      paramList = null;
      return paramList;
    }
    ListIterator localListIterator = paramList.listIterator(paramList.size());
    for (;;)
    {
      if (!localListIterator.hasPrevious()) {
        break label83;
      }
      BaseFragment localBaseFragment = (BaseFragment)localListIterator.previous();
      if (!(localBaseFragment instanceof BaseFragment))
      {
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "not a BaseFragment.");
      }
      else
      {
        paramList = localBaseFragment;
        if (!localBaseFragment.isHidden()) {
          break;
        }
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "fragment is hidden, next.");
      }
    }
    label83:
    return null;
  }
  
  private boolean useKeyboardCoverMode(WeakReference<MMFragment> paramWeakReference)
  {
    if (paramWeakReference == null) {
      return false;
    }
    paramWeakReference = (MMFragment)paramWeakReference.get();
    if (paramWeakReference == null) {
      return false;
    }
    if (!(paramWeakReference instanceof BaseFragment)) {
      return false;
    }
    return ((BaseFragment)paramWeakReference).useKeyboardCoverMode();
  }
  
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
    BaseFragment localBaseFragment = topShowFragment();
    if (localBaseFragment == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "fragment == null.");
      return null;
    }
    return localBaseFragment.findViewById(R.id.tenpay_keyboard_layout);
  }
  
  protected View getKBLayout(MMFragment paramMMFragment)
  {
    if (paramMMFragment == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BaseFrActivity", "fragment == null");
      return getKBLayout();
    }
    return paramMMFragment.findViewById(R.id.tenpay_keyboard_layout);
  }
  
  protected MyKeyboardWindow getKeyboard()
  {
    BaseFragment localBaseFragment = topShowFragment();
    if (localBaseFragment == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "fragment == null.");
      return null;
    }
    return (MyKeyboardWindow)localBaseFragment.findViewById(R.id.tenpay_num_keyboard);
  }
  
  protected MyKeyboardWindow getKeyboard(MMFragment paramMMFragment)
  {
    if (paramMMFragment == null)
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.BaseFrActivity", "fragment == null");
      return getKeyboard();
    }
    return (MyKeyboardWindow)paramMMFragment.findViewById(R.id.tenpay_num_keyboard);
  }
  
  protected TenpaySecureEditText getTenpaySecureEditText()
  {
    Object localObject = topShowFragment();
    if (localObject == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BaseFrActivity", "fragment == null.");
      return null;
    }
    localObject = ((BaseFragment)localObject).findViewById(R.id.wallet_content);
    if ((localObject instanceof TenpaySecureEditText)) {
      return (TenpaySecureEditText)localObject;
    }
    return null;
  }
  
  public void hideTenpayKB()
  {
    hideTenpayKB(null, null);
  }
  
  public void hideTenpayKB(final View paramView, WeakReference<MMFragment> paramWeakReference)
  {
    if ((paramView != null) && (paramView.isShown()))
    {
      if (!useKeyboardCoverMode(paramWeakReference)) {
        break label75;
      }
      paramWeakReference = AnimationUtils.loadAnimation(getContext(), a.a.sight_slide_bottom_out);
      paramWeakReference.setDuration(200L);
      paramWeakReference.setInterpolator(new LinearInterpolator());
      paramWeakReference.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(226627);
          paramView.setVisibility(8);
          if (this.val$tempTenpayKBStateListener != null) {
            this.val$tempTenpayKBStateListener.onVisibleStateChange(false);
          }
          if (this.val$tempTenpayKBStateCallBackListener != null) {
            this.val$tempTenpayKBStateCallBackListener.onCallBackKinda(false, paramView.getHeight());
          }
          AppMethodBeat.o(226627);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      paramView.startAnimation(paramWeakReference);
    }
    label75:
    do
    {
      return;
      paramView.setVisibility(8);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
    } while (this.mTenpayKBStateCallBackListener == null);
    this.mTenpayKBStateCallBackListener.onCallBackKinda(false, paramView.getHeight());
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
      int j = com.tencent.mm.cd.a.mt(getContext());
      paramInt = j - i - com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(226619);
            paramView1.scrollBy(0, paramInt);
            AppMethodBeat.o(226619);
          }
        });
      }
    }
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean1, paramBoolean2, null, false);
  }
  
  public void setEditFocusListener(final View paramView, final int paramInt, final boolean paramBoolean1, final boolean paramBoolean2, final MMFragment paramMMFragment, boolean paramBoolean3)
  {
    final MyKeyboardWindow localMyKeyboardWindow = getKeyboard(paramMMFragment);
    final View localView1 = getKBLayout(paramMMFragment);
    if ((localMyKeyboardWindow == null) || (localView1 == null)) {}
    label182:
    label195:
    for (;;)
    {
      return;
      View localView2 = localView1.findViewById(R.id.tenpay_push_down);
      Object localObject = localView1.findViewById(R.id.tenpay_keyboard_top_line);
      if (paramBoolean3)
      {
        localView2.setVisibility(8);
        ((View)localObject).setVisibility(8);
        if (!(paramView instanceof TenpaySecureEditText)) {
          break label182;
        }
      }
      for (localObject = (EditText)paramView;; localObject = (EditText)paramView.findViewById(R.id.wallet_content))
      {
        if (localObject == null) {
          break label195;
        }
        i.setNoSystemInputOnEditText((EditText)localObject);
        paramMMFragment = new WeakReference(paramMMFragment);
        ((EditText)localObject).setOnFocusChangeListener(new View.OnFocusChangeListener()
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
                    BaseFrActivity.this.showTenpayKB(BaseFrActivity.1.this.val$mKBLayout, BaseFrActivity.1.this.val$weakFragment);
                  }
                  if (((BaseFrActivity.1.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
                  {
                    localObject = (WalletFormView)BaseFrActivity.1.this.val$parent;
                    if (((z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
                      break label339;
                    }
                    localObject = new c();
                    BaseFrActivity.1.this.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                    BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                  }
                  for (;;)
                  {
                    if (((BaseFrActivity.1.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                    {
                      localObject = new c();
                      BaseFrActivity.1.this.val$mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                      BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                    }
                    BaseFrActivity.1.this.val$mKeyboard.setXMode(BaseFrActivity.1.this.val$editMode);
                    BaseFrActivity.1.this.val$mKeyboard.setInputEditText((EditText)paramAnonymousView);
                    ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                    AppMethodBeat.o(18756);
                    return;
                    label339:
                    BaseFrActivity.1.this.val$mKeyboard.resetSecureAccessibility();
                    BaseFrActivity.1.this.val$hintTv.setAccessibilityDelegate(null);
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
                      BaseFrActivity.this.hideTenpayKB(BaseFrActivity.1.this.val$mKBLayout, BaseFrActivity.1.this.val$weakFragment);
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
        ((EditText)localObject).setOnClickListener(new View.OnClickListener()
        {
          private byte _hellAccFlag_;
          
          public void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(18759);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((!localView1.isShown()) && (!paramBoolean1))
            {
              BaseFrActivity.this.showTenpayKB(localView1, paramMMFragment);
              localMyKeyboardWindow.setXMode(paramInt);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/kinda/framework/widget/base/BaseFrActivity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(18759);
              return;
              if (paramBoolean1)
              {
                BaseFrActivity.this.hideTenpayKB(localView1, paramMMFragment);
                ((InputMethodManager)BaseFrActivity.this.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
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
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/kinda/framework/widget/base/BaseFrActivity$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            BaseFrActivity.this.hideTenpayKB(localView1, paramMMFragment);
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
        localView2.setVisibility(0);
        ((View)localObject).setVisibility(0);
        break;
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
  
  public void showTenpayKB(final View paramView, final WeakReference<MMFragment> paramWeakReference)
  {
    if ((paramView != null) && (!paramView.isShown()))
    {
      if (!useKeyboardCoverMode(paramWeakReference)) {
        break label110;
      }
      paramView.findViewById(R.id.tenpay_keyboard_top_line).setVisibility(8);
      paramView.findViewById(R.id.tenpay_push_down).setVisibility(8);
      paramView.setVisibility(0);
      paramWeakReference = this.mTenpayKBStateListener;
      final IWalletTenpayKBStateCallBackListener localIWalletTenpayKBStateCallBackListener = this.mTenpayKBStateCallBackListener;
      Animation localAnimation = AnimationUtils.loadAnimation(this, a.a.sight_slide_bottom_in);
      localAnimation.setInterpolator(new LinearInterpolator());
      localAnimation.setDuration(200L);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(226622);
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "keyboard anim end");
          if (paramWeakReference != null) {
            paramWeakReference.onVisibleStateChange(true);
          }
          if (localIWalletTenpayKBStateCallBackListener != null) {
            localIWalletTenpayKBStateCallBackListener.onCallBackKinda(true, paramView.getHeight());
          }
          AppMethodBeat.o(226622);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(226620);
          com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BaseFrActivity", "keyboard anim start");
          paramView.setVisibility(0);
          AppMethodBeat.o(226620);
        }
      });
      paramView.startAnimation(localAnimation);
    }
    label110:
    do
    {
      return;
      paramView.setVisibility(0);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    } while (this.mTenpayKBStateCallBackListener == null);
    paramView.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226623);
        BaseFrActivity.this.mTenpayKBStateCallBackListener.onCallBackKinda(true, paramView.getHeight());
        AppMethodBeat.o(226623);
      }
    });
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
  
  public BaseFragment topShowFragment()
  {
    return topShowFragmentOf(getSupportFragmentManager().getFragments());
  }
  
  public static abstract interface IWalletTenpayKBStateCallBackListener
  {
    public abstract void onCallBackKinda(boolean paramBoolean, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity
 * JD-Core Version:    0.7.0.1
 */