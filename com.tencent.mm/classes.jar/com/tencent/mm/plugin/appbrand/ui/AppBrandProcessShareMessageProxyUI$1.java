package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

final class AppBrandProcessShareMessageProxyUI$1
  extends ResultReceiver
{
  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(133009);
    if ((-1 == paramInt) && (this.iNh != null)) {
      if (paramBundle != null) {
        break label66;
      }
    }
    label66:
    for (paramBundle = null;; paramBundle = paramBundle.getString("message"))
    {
      this.iNh.a(true, paramBundle, 0);
      if ((-2 == paramInt) && (this.iNh != null)) {
        this.iNh.a(false, null, 0);
      }
      AppMethodBeat.o(133009);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProcessShareMessageProxyUI.1
 * JD-Core Version:    0.7.0.1
 */