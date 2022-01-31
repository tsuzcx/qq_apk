package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CollectMainUI$16
  implements m.a
{
  CollectMainUI$16(CollectMainUI paramCollectMainUI) {}
  
  public final void aEP()
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.iLP.mController.uMN, CollectCreateQRCodeUI.class);
    localIntent.putExtra("key_currency_unit", this.iLP.iLk);
    this.iLP.startActivityForResult(localIntent, 4096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.16
 * JD-Core Version:    0.7.0.1
 */