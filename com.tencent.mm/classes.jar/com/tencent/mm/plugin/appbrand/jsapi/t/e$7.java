package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.os.RemoteException;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class e$7
  implements h.c
{
  e$7(e parame) {}
  
  public final void uL(String paramString)
  {
    try
    {
      if (e.h(this.gGA) != null)
      {
        e.h(this.gGA).a(paramString, new int[] { 3 }, 0, 0);
        return;
      }
      y.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
      return;
    }
    catch (RemoteException paramString)
    {
      y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e.7
 * JD-Core Version:    0.7.0.1
 */