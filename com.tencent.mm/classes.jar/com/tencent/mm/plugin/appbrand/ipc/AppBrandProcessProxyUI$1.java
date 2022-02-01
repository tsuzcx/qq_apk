package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessProxyUI$1
  extends ResultReceiver
{
  AppBrandProcessProxyUI$1(Handler paramHandler, AppBrandProxyUIProcessTask.b paramb)
  {
    super(paramHandler);
  }
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(45385);
    if (paramBundle == null)
    {
      this.jux.a(null);
      AppMethodBeat.o(45385);
      return;
    }
    paramBundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
    paramBundle = (AppBrandProxyUIProcessTask.ProcessResult)paramBundle.getParcelable("key_result_parcel");
    this.jux.a(paramBundle);
    AppMethodBeat.o(45385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.1
 * JD-Core Version:    0.7.0.1
 */