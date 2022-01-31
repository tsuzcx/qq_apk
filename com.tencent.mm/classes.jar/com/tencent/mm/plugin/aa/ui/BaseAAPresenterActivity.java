package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity
  extends WalletBaseUI
{
  private static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 300);
  private c eKO = new c();
  protected View gqb;
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T P(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.eKO.a(this, paramClass);
  }
  
  public final <T extends com.tencent.mm.vending.app.a> T T(Class<? extends com.tencent.mm.vending.app.a> paramClass)
  {
    return this.eKO.b(this, paramClass);
  }
  
  public void hideTenpayKB()
  {
    super.hideTenpayKB();
    if (this.gqb != null) {
      this.gqb.scrollTo(0, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eKO.A(getIntent(), this);
    this.isVKBFirstTimeShown = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eKO.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.eKO.a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.eKO.a(2);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    View localView = findViewById(2131822420);
    EditText localEditText = (EditText)paramView.findViewById(2131820689);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.mKBLayout == null)) {
      return;
    }
    this.mKBLayout.setVisibility(8);
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new BaseAAPresenterActivity.1(this, paramBoolean1, paramBoolean2, localEditText, paramView, paramInt));
    localEditText.setOnClickListener(new BaseAAPresenterActivity.2(this, paramBoolean1, localEditText, paramInt));
    localView.setOnClickListener(new BaseAAPresenterActivity.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity
 * JD-Core Version:    0.7.0.1
 */