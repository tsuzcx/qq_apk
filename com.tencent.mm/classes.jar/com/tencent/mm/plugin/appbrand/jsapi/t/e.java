package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONObject;

public final class e
  extends a
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  e.c ifl;
  
  protected final void a(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145921);
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiStartPlayVoice", "playVoice invalid data");
      paramc1.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(145921);
      return;
    }
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (bo.isNullOrNil(paramJSONObject))
    {
      ab.e("MicroMsg.JsApiStartPlayVoice", "filePath is null", new Object[] { getName() });
      paramc1.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(145921);
      return;
    }
    paramJSONObject = paramc1.wX().zg(paramJSONObject);
    if ((paramJSONObject == null) || (!paramJSONObject.exists()))
    {
      ab.e("MicroMsg.JsApiStartPlayVoice", "file is null, return");
      paramc1.h(paramInt, j("file is not exist", null));
      AppMethodBeat.o(145921);
      return;
    }
    if (this.ifl == null)
    {
      localObject = paramc1.getAppId();
      this.ifl = new e.1(this, paramc, (String)localObject);
      com.tencent.mm.plugin.appbrand.e.a((String)localObject, this.ifl);
    }
    Object localObject = new e.2(this, paramc1, paramInt, paramc);
    paramc.a((c.b)localObject);
    paramJSONObject = paramc.CU(paramJSONObject.getAbsolutePath());
    ab.i("MicroMsg.JsApiStartPlayVoice", "play:%s", new Object[] { paramJSONObject });
    if (!paramJSONObject.isSuccess())
    {
      ab.e("MicroMsg.JsApiStartPlayVoice", "play fail %s", new Object[] { paramJSONObject });
      paramc1.h(paramInt, "fail:" + paramJSONObject.errMsg);
      paramc.b((c.b)localObject);
    }
    AppMethodBeat.o(145921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e
 * JD-Core Version:    0.7.0.1
 */