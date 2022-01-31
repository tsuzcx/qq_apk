package com.tencent.kinda.framework.widget.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.ui.e;
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
  private BaseUI.IBaseUIWrap wrap;
  
  static
  {
    AppMethodBeat.i(144662);
    HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 270);
    AppMethodBeat.o(144662);
  }
  
  public BaseUI(BaseUI.IBaseUIWrap paramIBaseUIWrap)
  {
    this.wrap = paramIBaseUIWrap;
  }
  
  public void hideTenpayKB()
  {
    AppMethodBeat.i(144657);
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
    }
    AppMethodBeat.o(144657);
  }
  
  public void scrollTo(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144660);
    if (paramView != null) {
      paramView.scrollTo(paramInt1, paramInt2);
    }
    AppMethodBeat.o(144660);
  }
  
  public void scrollToFormEditPosAfterShowTenPay(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(144659);
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cb.a.gx(this.wrap.getContext());
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(this.wrap.getContext(), paramInt);
      ab.d("MicroMsg.BaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        ab.d("MicroMsg.BaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new BaseUI.4(this, paramView1, paramInt));
      }
    }
    AppMethodBeat.o(144659);
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(144654);
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
    AppMethodBeat.o(144654);
  }
  
  @TargetApi(14)
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(144655);
    this.mKeyboard = ((MyKeyboardWindow)this.wrap.findViewById(2131822419));
    this.mKBLayout = this.wrap.findViewById(2131822418);
    View localView = this.wrap.findViewById(2131822420);
    if ((paramView instanceof TenpaySecureEditText)) {}
    for (EditText localEditText = (EditText)paramView; (this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null); localEditText = (EditText)paramView.findViewById(2131820689))
    {
      AppMethodBeat.o(144655);
      return;
    }
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new BaseUI.1(this, paramBoolean1, paramBoolean2, paramView, localEditText, paramInt));
    localEditText.setOnClickListener(new BaseUI.2(this, paramBoolean1, paramInt, localEditText));
    localView.setOnClickListener(new BaseUI.3(this));
    AppMethodBeat.o(144655);
  }
  
  protected void setKBMode(int paramInt)
  {
    AppMethodBeat.i(144656);
    this.mKeyboard.setXMode(paramInt);
    AppMethodBeat.o(144656);
  }
  
  public void setTenpayKBStateListener(com.tencent.mm.wallet_core.ui.a parama)
  {
    this.mTenpayKBStateListener = parama;
  }
  
  public void showTenpayKB()
  {
    AppMethodBeat.i(144658);
    if ((this.mKBLayout != null) && (!this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(0);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
    AppMethodBeat.o(144658);
  }
  
  public void showVKB()
  {
    AppMethodBeat.i(144661);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.wrap.getContext().getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(144661);
      return;
    }
    View localView = this.wrap.getCurrentFocus();
    if (localView == null)
    {
      AppMethodBeat.o(144661);
      return;
    }
    if (localView.getWindowToken() == null)
    {
      AppMethodBeat.o(144661);
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
    AppMethodBeat.o(144661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.BaseUI
 * JD-Core Version:    0.7.0.1
 */