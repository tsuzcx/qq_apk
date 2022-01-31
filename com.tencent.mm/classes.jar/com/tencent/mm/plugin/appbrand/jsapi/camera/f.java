package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Base64;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends ac
{
  private static final int CTRL_INDEX = 455;
  public static final String NAME = "onCameraScanCode";
  public static f goZ = new f();
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cameraId", Integer.valueOf(paramInt));
    localHashMap.put("type", paramString1);
    localHashMap.put("result", paramString2);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramString1 = Base64.encodeToString(paramArrayOfByte, 2);
      localHashMap.put("charSet", "utf-8");
      localHashMap.put("rawData", paramString1);
    }
    paramString1 = new JSONObject(localHashMap).toString();
    com.tencent.luggage.j.c.d("MicroMsg.JsApiCameraScanCode", "onCameraScanCode:%s", new Object[] { paramString1 });
    paramc.a(goZ.getName(), paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.f
 * JD-Core Version:    0.7.0.1
 */