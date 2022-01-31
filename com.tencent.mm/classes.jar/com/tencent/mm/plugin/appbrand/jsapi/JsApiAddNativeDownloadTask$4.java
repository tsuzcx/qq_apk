package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

final class JsApiAddNativeDownloadTask$4
  implements Runnable
{
  JsApiAddNativeDownloadTask$4(JsApiAddNativeDownloadTask paramJsApiAddNativeDownloadTask, JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask paramAddNativeDownloadTaskTask, r paramr, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(130378);
    this.hxn.aBk();
    HashMap localHashMap = new HashMap();
    switch (this.hxn.bsY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130378);
      return;
      this.bAW.h(this.bAX, this.hxm.j("fail:cancel", null));
      AppMethodBeat.o(130378);
      return;
      this.bAW.h(this.bAX, this.hxm.j("fail:download fail", null));
      AppMethodBeat.o(130378);
      return;
      localHashMap.put("download_id", Long.valueOf(this.hxn.cmm));
      this.bAW.h(this.bAX, this.hxm.j("ok", localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */