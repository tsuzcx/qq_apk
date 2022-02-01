package com.tencent.mm.plugin.collect.reward.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class QrRewardBaseUI
  extends WalletBaseUI
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(63922);
        QrRewardBaseUI.this.hideVKB();
        QrRewardBaseUI.this.hideTenpayKB();
        QrRewardBaseUI.this.finish();
        AppMethodBeat.o(63922);
        return false;
      }
    }, 2131689490);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardBaseUI
 * JD-Core Version:    0.7.0.1
 */