package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiGetABTestConfig
  extends ab<f>
{
  public static final int CTRL_INDEX = 527;
  public static final String NAME = "getABTestConfig";
  
  public final String a(f paramf, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(45480);
    Log.i("MicroMsg.JsApiGetABTestConfig", "JSONObject = ".concat(String.valueOf(paramJSONObject)));
    paramf = paramJSONObject.optString("experimentId");
    boolean bool = "Expt".equals(paramJSONObject.optString("experimentType"));
    if (TextUtils.isEmpty(paramf))
    {
      paramf = ZP("fail:experimentId is empty");
      AppMethodBeat.o(45480);
      return paramf;
    }
    if (bool)
    {
      paramJSONObject = new HashMap();
      paramJSONObject.put("testConfig", d.dNI().a(paramf, "", true, true));
      paramf = m("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return paramf;
    }
    paramJSONObject = a.a.mzH;
    paramf = a.Fd(paramf);
    paramJSONObject = new HashMap();
    if ((paramf != null) && (paramf.isValid())) {
      paramJSONObject.put("testConfig", paramf.iWZ());
    }
    for (;;)
    {
      paramf = m("ok", paramJSONObject);
      AppMethodBeat.o(45480);
      return paramf;
      paramJSONObject.put("testConfig", new HashMap(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig
 * JD-Core Version:    0.7.0.1
 */