package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;

final class e$7
  implements h.c
{
  e$7(e parame) {}
  
  public final void Dd(String paramString)
  {
    AppMethodBeat.i(17035);
    try
    {
      if (e.i(this.ihi) != null)
      {
        e.i(this.ihi).a(paramString, new int[] { 3 }, 0, 0);
        AppMethodBeat.o(17035);
        return;
      }
      ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
      AppMethodBeat.o(17035);
      return;
    }
    catch (RemoteException paramString)
    {
      ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
      AppMethodBeat.o(17035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e.7
 * JD-Core Version:    0.7.0.1
 */