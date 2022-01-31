package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandProcessProxyUI$2
  implements Runnable
{
  AppBrandProcessProxyUI$2(Class paramClass, Context paramContext, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(73125);
    if ((AppBrandProcessProxyUI.class != this.hvZ) && ((this.hwa instanceof Activity)))
    {
      ((Activity)this.hwa).startActivityForResult(this.hwb, 0);
      AppMethodBeat.o(73125);
      return;
    }
    this.hwa.startActivity(this.hwb);
    AppMethodBeat.o(73125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI.2
 * JD-Core Version:    0.7.0.1
 */