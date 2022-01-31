package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.List;

public abstract class BaseFrActivity
  extends MMActivity
{
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 270);
  public static final String TAG = "MicroMsg.BaseFrActivity";
  private final int PWD_INPUT_VIEW_AND_KEYBOARD_GAP_PX = 26;
  private boolean isDestroyByThisFinish = false;
  protected boolean isVKBFirstTimeShown = false;
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
    ActivityController.attach(null);
    ab.i("MicroMsg.BaseFrActivity", "BaseFrActivity finish exec! the stack: " + Log.getStackTraceString(new Throwable()));
  }
  
  protected View getKBLayout()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return findViewById(2131822418);
    }
    return ((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131822418);
  }
  
  protected MyKeyboardWindow getKeyboard()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return (MyKeyboardWindow)findViewById(2131822419);
    }
    return (MyKeyboardWindow)((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131822419);
  }
  
  protected LinearLayout getMainContainer()
  {
    int i = getSupportFragmentManager().getFragments().size();
    if (i <= 0) {
      return null;
    }
    return (LinearLayout)((BaseFragment)getSupportFragmentManager().getFragments().get(i - 1)).findViewById(2131821084);
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
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ab.i("MicroMsg.BaseFrActivity", "onCreate");
    super.onCreate(paramBundle);
    ActivityController.attach(this);
  }
  
  public void onDestroy()
  {
    ab.i("MicroMsg.BaseFrActivity", "onDestroy");
    if (!this.isDestroyByThisFinish) {
      ActivityController.attach(null);
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
        i = (int)(KindaContext.get().getResources().getDisplayMetrics().density * 270.0F + 0.5F);
      }
      paramInt = paramView.getHeight();
      int k = getController().zay.getHeight();
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
  
  public void scrollToFormEditPosAfterShowTenPay(View paramView1, View paramView2, int paramInt)
  {
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cb.a.gx(getContext());
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
      ab.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        ab.d("MicroMsg.BaseFrActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new BaseFrActivity.4(this, paramView1, paramInt));
      }
    }
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
  }
  
  @TargetApi(14)
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    MyKeyboardWindow localMyKeyboardWindow = getKeyboard();
    View localView1 = getKBLayout();
    if ((localMyKeyboardWindow == null) || (localView1 == null)) {}
    for (;;)
    {
      return;
      View localView2 = localView1.findViewById(2131822420);
      if ((paramView instanceof TenpaySecureEditText)) {}
      for (EditText localEditText = (EditText)paramView; localEditText != null; localEditText = (EditText)paramView.findViewById(2131820689))
      {
        e.setNoSystemInputOnEditText(localEditText);
        localEditText.setOnFocusChangeListener(new BaseFrActivity.1(this, paramBoolean1, localView1, paramBoolean2, paramView, localMyKeyboardWindow, localEditText, paramInt));
        localEditText.setOnClickListener(new BaseFrActivity.2(this, localView1, paramBoolean1, localMyKeyboardWindow, paramInt, localEditText));
        localView2.setOnClickListener(new BaseFrActivity.3(this));
        return;
      }
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseFrActivity
 * JD-Core Version:    0.7.0.1
 */