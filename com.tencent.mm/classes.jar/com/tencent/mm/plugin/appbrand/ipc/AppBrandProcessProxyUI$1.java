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
    AppMethodBeat.i(73124);
    if (paramBundle == null)
    {
      this.hvY.c(null);
      AppMethodBeat.o(73124);
      return;
    }
    paramBundle.setClassLoader(AppBrandProcessProxyUI.class.getClassLoader());
    paramBundle = (AppBrandProxyUIProcessTask.ProcessResult)paramBundle.getParcelable("key_result_parcel");
    this.hvY.c(paramBundle);
    AppMethodBeat.o(73124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.1
 * JD-Core Version:    0.7.0.1
 */