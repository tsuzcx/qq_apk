package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI
  extends WalletBaseUI
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czo();
    setBackBtn(new QrRewardBaseUI.1(this), a.h.actionbar_icon_dark_back);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI
 * JD-Core Version:    0.7.0.1
 */