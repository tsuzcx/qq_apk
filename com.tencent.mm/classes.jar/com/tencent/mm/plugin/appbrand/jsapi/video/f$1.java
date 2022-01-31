package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class f$1
  implements b
{
  f$1(f paramf, c paramc) {}
  
  public final void aS(String paramString, int paramInt)
  {
    y.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", new Object[] { Integer.valueOf(paramInt), paramString });
    f.a(this.ggE, paramString, -5, paramInt);
  }
  
  public final void bN(String paramString1, String paramString2)
  {
    y.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", new Object[] { paramString2, paramString1 });
    paramString2 = this.ggE;
    HashMap localHashMap = new HashMap();
    localHashMap.put("resource", paramString1);
    paramString1 = new JSONObject(localHashMap).toString();
    new j.j().e(paramString2).tM(paramString1).dispatch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f.1
 * JD-Core Version:    0.7.0.1
 */