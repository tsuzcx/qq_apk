package com.tencent.mm.plugin.account.ui;

import android.os.Build.VERSION;
import android.widget.ListView;

final class RegByMobileWaitingSMSUI$3$1
  implements Runnable
{
  RegByMobileWaitingSMSUI$3$1(RegByMobileWaitingSMSUI.3 param3) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      RegByMobileWaitingSMSUI.f(this.frG.frF).smoothScrollToPosition(RegByMobileWaitingSMSUI.e(this.frG.frF).getCount() - 1);
      return;
    }
    RegByMobileWaitingSMSUI.f(this.frG.frF).setSelection(RegByMobileWaitingSMSUI.e(this.frG.frF).getCount() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileWaitingSMSUI.3.1
 * JD-Core Version:    0.7.0.1
 */