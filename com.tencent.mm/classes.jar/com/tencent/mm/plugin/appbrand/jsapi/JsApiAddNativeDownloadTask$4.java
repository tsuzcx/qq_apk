package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class JsApiAddNativeDownloadTask$4
  implements Runnable
{
  JsApiAddNativeDownloadTask$4(JsApiAddNativeDownloadTask paramJsApiAddNativeDownloadTask, JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask paramAddNativeDownloadTaskTask, o paramo, int paramInt) {}
  
  public final void run()
  {
    this.gfB.ahD();
    HashMap localHashMap = new HashMap();
    switch (this.gfB.bcw)
    {
    default: 
      return;
    case 0: 
      this.gcp.C(this.dIS, this.gfA.h("fail:cancel", null));
      return;
    case 1: 
      this.gcp.C(this.dIS, this.gfA.h("fail:download fail", null));
      return;
    }
    localHashMap.put("download_id", Long.valueOf(this.gfB.bFb));
    this.gcp.C(this.dIS, this.gfA.h("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.4
 * JD-Core Version:    0.7.0.1
 */