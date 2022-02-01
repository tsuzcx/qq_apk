package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class n<CONTEXT extends f>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 37;
  public static final String NAME = "getLocation";
  
  protected a.b a(CONTEXT paramCONTEXT, a.b paramb)
  {
    return paramb;
  }
  
  public final void d(final CONTEXT paramCONTEXT, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(143632);
    Object localObject2 = Util.nullAsNil(paramJSONObject.optString("type", "wgs84")).trim();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = "wgs84";
    }
    final boolean bool = paramJSONObject.optBoolean("altitude", false);
    Log.i("MicroMsg.JsApiGetLocation", "getLocation data:%s", new Object[] { paramJSONObject });
    if ((!"wgs84".equals(localObject1)) && (!"gcj02".equals(localObject1)))
    {
      Log.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[] { localObject1 });
      paramJSONObject = new HashMap(1);
      paramJSONObject.put("errCode", Integer.valueOf(-1));
      paramCONTEXT.callback(paramInt, m("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(143632);
      return;
    }
    if (!u(paramCONTEXT))
    {
      paramJSONObject = new HashMap(1);
      paramJSONObject.put("errCode", Integer.valueOf(-2));
      paramCONTEXT.callback(paramInt, m("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(143632);
      return;
    }
    w(paramCONTEXT);
    paramJSONObject = f(paramCONTEXT, paramJSONObject);
    localObject2 = (com.tencent.mm.plugin.appbrand.utils.b.a)paramCONTEXT.T(com.tencent.mm.plugin.appbrand.utils.b.a.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.utils.b.a)localObject2).a((String)localObject1, a(paramCONTEXT, new a.b()
      {
        public final void a(int paramAnonymousInt, String paramAnonymousString, a.a paramAnonymousa)
        {
          AppMethodBeat.i(143631);
          Log.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, paramAnonymousa });
          n.this.x(paramCONTEXT);
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = new HashMap(4);
            paramAnonymousString.put("type", this.sad);
            paramAnonymousString.put("latitude", Double.valueOf(paramAnonymousa.latitude));
            paramAnonymousString.put("longitude", Double.valueOf(paramAnonymousa.longitude));
            paramAnonymousString.put("speed", Double.valueOf(paramAnonymousa.huN));
            paramAnonymousString.put("accuracy", Double.valueOf(paramAnonymousa.usi));
            if (bool) {
              paramAnonymousString.put("altitude", Double.valueOf(paramAnonymousa.altitude));
            }
            paramAnonymousString.put("provider", paramAnonymousa.provider);
            paramAnonymousString.put("verticalAccuracy", Integer.valueOf(0));
            paramAnonymousString.put("horizontalAccuracy", Double.valueOf(paramAnonymousa.usi));
            if (!Util.isNullOrNil(paramAnonymousa.buildingId))
            {
              paramAnonymousString.put("buildingId", paramAnonymousa.buildingId);
              paramAnonymousString.put("floorName", paramAnonymousa.floorName);
            }
            paramAnonymousString.put("indoorLocationType", Integer.valueOf(paramAnonymousa.usj));
            paramAnonymousString.put("direction", Float.valueOf(paramAnonymousa.usk));
            paramAnonymousString.put("steps", Double.valueOf(paramAnonymousa.usl));
            paramCONTEXT.callback(paramInt, n.this.m("ok", paramAnonymousString));
            AppMethodBeat.o(143631);
            return;
          }
          paramAnonymousa = new HashMap(1);
          paramAnonymousa.put("errCode", Integer.valueOf(paramAnonymousInt));
          paramCONTEXT.callback(paramInt, n.this.m("fail:".concat(String.valueOf(paramAnonymousString)), paramAnonymousa));
          AppMethodBeat.o(143631);
        }
      }), paramJSONObject);
    }
    AppMethodBeat.o(143632);
  }
  
  protected Bundle f(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    AppMethodBeat.i(143633);
    Bundle localBundle = new Bundle();
    boolean bool2 = paramJSONObject.optBoolean("isHighAccuracy", false);
    int i = paramJSONObject.optInt("highAccuracyExpireTime", 3000);
    localBundle.putBoolean("isHighAccuracy", bool2);
    localBundle.putInt("highAccuracyExpireTime", i);
    if (paramCONTEXT.getAppState() != b.qKw) {
      bool1 = true;
    }
    localBundle.putBoolean("useCache", bool1);
    AppMethodBeat.o(143633);
    return localBundle;
  }
  
  protected void w(CONTEXT paramCONTEXT) {}
  
  protected void x(CONTEXT paramCONTEXT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.n
 * JD-Core Version:    0.7.0.1
 */