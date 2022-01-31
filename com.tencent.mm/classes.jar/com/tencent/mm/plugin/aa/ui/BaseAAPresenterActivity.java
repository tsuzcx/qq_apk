package com.tencent.mm.plugin.aa.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity
  extends WalletBaseUI
{
  private static final int eYf = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 300);
  private c dNd = new c();
  protected View eYe;
  
  public final <T extends com.tencent.mm.vending.app.a> T C(Class<? extends com.tencent.mm.vending.app.a> paramClass)
  {
    return this.dNd.b(this, paramClass);
  }
  
  public final void VH()
  {
    super.VH();
    if (this.eYe != null) {
      this.eYe.scrollTo(0, 0);
    }
  }
  
  protected final void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    EditText localEditText = (EditText)paramView.findViewById(a.f.wallet_content);
    if ((this.mKeyboard == null) || (localEditText == null) || (this.lMr == null)) {
      return;
    }
    this.lMr.setVisibility(8);
    e.setNoSystemInputOnEditText(localEditText);
    localEditText.setOnFocusChangeListener(new BaseAAPresenterActivity.1(this, paramBoolean1, paramBoolean2, localEditText, paramView, paramInt));
    localEditText.setOnClickListener(new BaseAAPresenterActivity.2(this, paramBoolean1, localEditText, paramInt));
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        BaseAAPresenterActivity.this.VH();
      }
    });
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dNd.B(getIntent(), this);
    this.wCm = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.dNd.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.dNd.a(3);
  }
  
  public void onResume()
  {
    super.onResume();
    this.dNd.a(2);
  }
  
  public final <T extends b<? extends com.tencent.mm.vending.app.a>> T z(Class<? extends b<? extends com.tencent.mm.vending.app.a>> paramClass)
  {
    return this.dNd.a(this, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.BaseAAPresenterActivity
 * JD-Core Version:    0.7.0.1
 */