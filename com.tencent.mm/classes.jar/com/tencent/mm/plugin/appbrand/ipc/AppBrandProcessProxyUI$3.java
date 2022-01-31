package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessProxyUI$3
  extends ResultReceiver
{
  AppBrandProcessProxyUI$3(Handler paramHandler, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(73126);
    if ((-1 == paramInt) && (this.hwc != null)) {
      this.hwc.onClick(null, paramInt);
    }
    if ((-2 == paramInt) && (this.hwd != null)) {
      this.hwd.onClick(null, paramInt);
    }
    if ((-3 == paramInt) && (this.hwe != null)) {
      this.hwe.onClick(null, paramInt);
    }
    AppMethodBeat.o(73126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.3
 * JD-Core Version:    0.7.0.1
 */