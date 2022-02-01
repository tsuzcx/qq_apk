package com.tencent.mm.plugin.honey_pay.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class HoneyPayBaseUI
  extends WalletBaseUI
{
  protected final String TAG = "MicroMsg." + getClass().getSimpleName();
  protected int uRo = 2131101179;
  
  protected void deV()
  {
    setActionbarColor(getResources().getColor(this.uRo));
    hideActionbarLine();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    deV();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(64660);
        HoneyPayBaseUI.this.hideVKB();
        HoneyPayBaseUI.this.hideTenpayKB();
        HoneyPayBaseUI.this.finish();
        AppMethodBeat.o(64660);
        return false;
      }
    });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI
 * JD-Core Version:    0.7.0.1
 */