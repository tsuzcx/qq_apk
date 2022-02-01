package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends ar
{
  private static final int CTRL_INDEX = 455;
  public static final String NAME = "onCameraScanCode";
  public static j knd;
  
  static
  {
    AppMethodBeat.i(46221);
    knd = new j();
    AppMethodBeat.o(46221);
  }
  
  public static void a(c paramc, int paramInt1, String paramString1, int paramInt2, String paramString2, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(186581);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(paramInt1));
    localHashMap.put("type", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("codeVersion", Integer.valueOf(paramInt2));
    if (paramQBarPoint != null) {
      localHashMap.put("scanArea", new float[] { g.aF(paramQBarPoint.x0), g.aF(paramQBarPoint.y0), g.aF(paramQBarPoint.x1 - paramQBarPoint.x0), g.aF(paramQBarPoint.y3 - paramQBarPoint.y0) });
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = Base64.encodeToString(paramArrayOfByte, 2);
      localHashMap.put("charSet", "utf-8");
      localHashMap.put("rawData", paramString1);
    }
    paramString1 = new JSONObject(localHashMap).toString();
    ac.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new Object[] { paramString1 });
    paramc.b(knd.getName(), paramString1, null);
    AppMethodBeat.o(186581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j
 * JD-Core Version:    0.7.0.1
 */