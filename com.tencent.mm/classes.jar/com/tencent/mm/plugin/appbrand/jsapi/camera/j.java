package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative.QBarPoint;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class j
  extends bc
{
  private static final int CTRL_INDEX = 455;
  public static final String NAME = "onCameraScanCode";
  public static j lQe;
  
  static
  {
    AppMethodBeat.i(46221);
    lQe = new j();
    AppMethodBeat.o(46221);
  }
  
  public static void a(f paramf, int paramInt1, String paramString1, int paramInt2, String paramString2, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(226731);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(paramInt1));
    localHashMap.put("type", paramString1);
    localHashMap.put("result", paramString2);
    localHashMap.put("codeVersion", Integer.valueOf(paramInt2));
    if (paramQBarPoint != null) {
      localHashMap.put("scanArea", new float[] { g.aS(paramQBarPoint.x0), g.aS(paramQBarPoint.y0), g.aS(paramQBarPoint.x1 - paramQBarPoint.x0), g.aS(paramQBarPoint.y3 - paramQBarPoint.y0) });
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = Base64.encodeToString(paramArrayOfByte, 2);
      localHashMap.put("charSet", "utf-8");
      localHashMap.put("rawData", paramString1);
    }
    paramString1 = new JSONObject(localHashMap).toString();
    Log.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new Object[] { paramString1 });
    paramf.b(lQe.getName(), paramString1, null);
    AppMethodBeat.o(226731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j
 * JD-Core Version:    0.7.0.1
 */