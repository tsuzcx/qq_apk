package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.y.a;

class AppBrandProcessShareMessageProxyUI$1
  extends ResultReceiver
{
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48686);
    if ((-1 == paramInt) && (this.ubV != null)) {
      if (paramBundle != null) {
        break label66;
      }
    }
    label66:
    for (paramBundle = null;; paramBundle = paramBundle.getString("message"))
    {
      this.ubV.onDialogClick(true, paramBundle, 0);
      if ((-2 == paramInt) && (this.ubV != null)) {
        this.ubV.onDialogClick(false, null, 0);
      }
      AppMethodBeat.o(48686);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.1
 * JD-Core Version:    0.7.0.1
 */