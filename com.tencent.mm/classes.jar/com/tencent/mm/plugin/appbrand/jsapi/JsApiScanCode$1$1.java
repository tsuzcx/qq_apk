package com.tencent.mm.plugin.appbrand.jsapi;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.HashMap;

final class JsApiScanCode$1$1
  implements Runnable
{
  JsApiScanCode$1$1(JsApiScanCode.1 param1, JsApiScanCode.GetA8KeyTask paramGetA8KeyTask, HashMap paramHashMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(130555);
    this.hzF.aBk();
    if (this.hzF.actionCode == 26)
    {
      Uri localUri = Uri.parse(this.hzF.hzJ);
      String str = localUri.getQueryParameter("username");
      if (this.hzH.hxC.getRuntime().atS().username.equals(str)) {
        this.hzG.put("path", URLDecoder.decode(bo.nullAsNil(localUri.getQueryParameter("path"))));
      }
    }
    this.hzH.hxC.h(this.hzH.bAX, this.hzH.hzE.j("ok", this.hzG));
    AppMethodBeat.o(130555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1.1
 * JD-Core Version:    0.7.0.1
 */