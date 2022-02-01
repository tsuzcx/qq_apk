package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.h;

final class FreeWifiPcUI$2$1
  implements MTimerHandler.CallBack
{
  FreeWifiPcUI$2$1(FreeWifiPcUI.2 param2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(25121);
    FreeWifiPcUI.a(this.wSA.wSz, h.a(this.wSA.wSz.getContext(), this.wSA.wSz.getString(2131757798), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    }));
    AppMethodBeat.o(25121);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.2.1
 * JD-Core Version:    0.7.0.1
 */