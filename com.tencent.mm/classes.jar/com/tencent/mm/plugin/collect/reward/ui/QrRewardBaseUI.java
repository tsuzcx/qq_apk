package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI
  extends WalletBaseUI
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideActionbarLine();
    setBackBtn(new QrRewardBaseUI.1(this), 2131230737);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI
 * JD-Core Version:    0.7.0.1
 */