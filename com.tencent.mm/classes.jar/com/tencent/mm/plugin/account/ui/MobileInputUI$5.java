package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.normsg.a.b;

final class MobileInputUI$5
  implements View.OnFocusChangeListener
{
  MobileInputUI$5(MobileInputUI paramMobileInputUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.foI[0] = true;
      return;
    }
    b.mGK.JX("ie_reg_eu");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.5
 * JD-Core Version:    0.7.0.1
 */