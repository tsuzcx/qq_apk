package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bo;

final class AppBrandProcessShareMessageProxyUI$a
  implements DialogInterface.OnDismissListener, q.a
{
  private boolean hwi = false;
  
  AppBrandProcessShareMessageProxyUI$a(AppBrandProcessShareMessageProxyUI paramAppBrandProcessShareMessageProxyUI) {}
  
  private void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(133016);
    if (this.hwi)
    {
      AppMethodBeat.o(133016);
      return;
    }
    this.hwi = true;
    ResultReceiver localResultReceiver = (ResultReceiver)this.iNi.getIntent().getParcelableExtra("key_result_receiver");
    if (localResultReceiver != null)
    {
      Bundle localBundle = null;
      if (!bo.isNullOrNil(paramString))
      {
        localBundle = new Bundle();
        localBundle.putString("message", paramString);
      }
      localResultReceiver.send(paramInt, localBundle);
    }
    AppMethodBeat.o(133016);
  }
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(133014);
    if (paramBoolean)
    {
      ad(-1, paramString);
      AppMethodBeat.o(133014);
      return;
    }
    ad(-2, null);
    AppMethodBeat.o(133014);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(133015);
    this.iNi.finish();
    AppMethodBeat.o(133015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.a
 * JD-Core Version:    0.7.0.1
 */