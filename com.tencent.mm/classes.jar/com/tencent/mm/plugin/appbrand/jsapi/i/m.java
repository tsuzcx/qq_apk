package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.b.a.a;
import com.tencent.mm.plugin.appbrand.utils.b.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class m<CONTEXT extends f>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 37;
  public static final String NAME = "getLocation";
  
  protected void bGF() {}
  
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
      paramCONTEXT.i(paramInt, n("fail:invalid data", paramJSONObject));
      AppMethodBeat.o(143632);
      return;
    }
    if (!q(paramCONTEXT))
    {
      paramJSONObject = new HashMap(1);
      paramJSONObject.put("errCode", Integer.valueOf(-2));
      paramCONTEXT.i(paramInt, n("fail:system permission denied", paramJSONObject));
      AppMethodBeat.o(143632);
      return;
    }
    s(paramCONTEXT);
    paramJSONObject = g(paramCONTEXT, paramJSONObject);
    localObject2 = (com.tencent.mm.plugin.appbrand.utils.b.a)paramCONTEXT.M(com.tencent.mm.plugin.appbrand.utils.b.a.class);
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.appbrand.utils.b.a)localObject2).a((String)localObject1, new a.b()
      {
        public final void a(int paramAnonymousInt, String paramAnonymousString, a.a paramAnonymousa)
        {
          AppMethodBeat.i(143631);
          Log.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, paramAnonymousa });
          m.this.bGF();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = new HashMap(4);
            paramAnonymousString.put("type", this.lXf);
            paramAnonymousString.put("latitude", Double.valueOf(paramAnonymousa.latitude));
            paramAnonymousString.put("longitude", Double.valueOf(paramAnonymousa.longitude));
            paramAnonymousString.put("speed", Double.valueOf(paramAnonymousa.dxQ));
            paramAnonymousString.put("accuracy", Double.valueOf(paramAnonymousa.ohZ));
            if (bool) {
              paramAnonymousString.put("altitude", Double.valueOf(paramAnonymousa.altitude));
            }
            paramAnonymousString.put("provider", paramAnonymousa.provider);
            paramAnonymousString.put("verticalAccuracy", Integer.valueOf(0));
            paramAnonymousString.put("horizontalAccuracy", Double.valueOf(paramAnonymousa.ohZ));
            if (!Util.isNullOrNil(paramAnonymousa.buildingId))
            {
              paramAnonymousString.put("buildingId", paramAnonymousa.buildingId);
              paramAnonymousString.put("floorName", paramAnonymousa.floorName);
            }
            paramAnonymousString.put("indoorLocationType", Integer.valueOf(paramAnonymousa.oia));
            paramAnonymousString.put("direction", Float.valueOf(paramAnonymousa.oib));
            paramAnonymousString.put("steps", Double.valueOf(paramAnonymousa.oic));
            paramCONTEXT.i(paramInt, m.this.n("ok", paramAnonymousString));
            AppMethodBeat.o(143631);
            return;
          }
          paramAnonymousa = new HashMap(1);
          paramAnonymousa.put("errCode", Integer.valueOf(paramAnonymousInt));
          paramCONTEXT.i(paramInt, m.this.n("fail:".concat(String.valueOf(paramAnonymousString)), paramAnonymousa));
          AppMethodBeat.o(143631);
        }
      }, paramJSONObject);
    }
    AppMethodBeat.o(143632);
  }
  
  protected Bundle g(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143633);
    paramCONTEXT = new Bundle();
    boolean bool = paramJSONObject.optBoolean("isHighAccuracy", false);
    int i = paramJSONObject.optInt("highAccuracyExpireTime", 3000);
    paramCONTEXT.putBoolean("isHighAccuracy", bool);
    paramCONTEXT.putInt("highAccuracyExpireTime", i);
    AppMethodBeat.o(143633);
    return paramCONTEXT;
  }
  
  protected void s(CONTEXT paramCONTEXT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.m
 * JD-Core Version:    0.7.0.1
 */