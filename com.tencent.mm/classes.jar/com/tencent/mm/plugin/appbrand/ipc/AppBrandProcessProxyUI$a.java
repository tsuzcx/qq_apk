package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.ResultReceiver;

final class AppBrandProcessProxyUI$a
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
{
  private boolean gei = false;
  
  private AppBrandProcessProxyUI$a(AppBrandProcessProxyUI paramAppBrandProcessProxyUI) {}
  
  private void ld(int paramInt)
  {
    if (this.gei) {}
    ResultReceiver localResultReceiver;
    do
    {
      return;
      this.gei = true;
      localResultReceiver = (ResultReceiver)this.geg.getIntent().getParcelableExtra("key_result_receiver");
    } while (localResultReceiver == null);
    localResultReceiver.send(paramInt, null);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ld(paramInt);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    ld(-2);
    this.geg.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.a
 * JD-Core Version:    0.7.0.1
 */