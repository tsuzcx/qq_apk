package com.tencent.mm.plugin.honey_pay.ui;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class HoneyPayBaseUI
  extends WalletBaseUI
{
  protected final String TAG = "MicroMsg." + getClass().getSimpleName();
  protected int lkb = a.c.white;
  
  protected void baU()
  {
    ta(getResources().getColor(this.lkb));
    czo();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    baU();
    setBackBtn(new HoneyPayBaseUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI
 * JD-Core Version:    0.7.0.1
 */