package com.tencent.mm.plugin.appbrand.ipc;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class AppBrandProcessProxyUI$2
  extends ResultReceiver
{
  AppBrandProcessProxyUI$2(Handler paramHandler, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((-1 == paramInt) && (this.gec != null)) {
      this.gec.onClick(null, paramInt);
    }
    if ((-2 == paramInt) && (this.ged != null)) {
      this.ged.onClick(null, paramInt);
    }
    if ((-3 == paramInt) && (this.gee != null)) {
      this.gee.onClick(null, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */