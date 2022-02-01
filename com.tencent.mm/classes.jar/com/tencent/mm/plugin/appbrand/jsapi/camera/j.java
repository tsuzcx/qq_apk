package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends at
{
  private static final int CTRL_INDEX = 455;
  public static final String NAME = "onCameraScanCode";
  public static j kLs;
  
  static
  {
    AppMethodBeat.i(46221);
    kLs = new j();
    AppMethodBeat.o(46221);
  }
  
  public static void a(c paramc, int paramInt1, String paramString1, int paramInt2, String paramString2, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(222427);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(paramInt1));
    localHashMap.put("type", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("codeVersion", Integer.valueOf(paramInt2));
    if (paramQBarPoint != null) {
      localHashMap.put("scanArea", new float[] { g.aI(paramQBarPoint.x0), g.aI(paramQBarPoint.y0), g.aI(paramQBarPoint.x1 - paramQBarPoint.x0), g.aI(paramQBarPoint.y3 - paramQBarPoint.y0) });
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = Base64.encodeToString(paramArrayOfByte, 2);
      localHashMap.put("charSet", "utf-8");
      localHashMap.put("rawData", paramString1);
    }
    paramString1 = new JSONObject(localHashMap).toString();
    ae.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new Object[] { paramString1 });
    paramc.b(kLs.getName(), paramString1, null);
    AppMethodBeat.o(222427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j
 * JD-Core Version:    0.7.0.1
 */