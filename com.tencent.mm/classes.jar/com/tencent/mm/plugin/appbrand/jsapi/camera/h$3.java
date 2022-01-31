package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class h$3
  implements android.support.v4.app.a.a
{
  h$3(h paramh, c paramc, d paramd) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 16) {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a.a.aiD().gon = true;
        this.gpc.a(this.ggE, this.gpb);
      }
    }
    while (paramInt != 18)
    {
      return;
      paramArrayOfString = new HashMap();
      paramArrayOfString.put("cameraId", Integer.valueOf(this.gpb.getCameraId()));
      paramArrayOfString = new JSONObject(paramArrayOfString).toString();
      new e().e(this.ggE).tM(paramArrayOfString).dispatch();
      a.a.aiD().gon = false;
      return;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      a.a.aiD().goo = true;
      this.gpc.a(this.ggE, this.gpb);
      return;
    }
    paramArrayOfString = new HashMap();
    paramArrayOfString.put("cameraId", Integer.valueOf(this.gpb.getCameraId()));
    paramArrayOfString = new JSONObject(paramArrayOfString).toString();
    new e().e(this.ggE).tM(paramArrayOfString).dispatch();
    a.a.aiD().goo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.h.3
 * JD-Core Version:    0.7.0.1
 */