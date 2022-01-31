package com.tencent.mm.plugin.account.security.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.security.a.a;

final class SafeDeviceListPreference$1$1
  implements DialogInterface.OnCancelListener
{
  SafeDeviceListPreference$1$1(SafeDeviceListPreference.1 param1, a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.fkw);
    SafeDeviceListPreference.c(this.fkx.fkv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.1.1
 * JD-Core Version:    0.7.0.1
 */