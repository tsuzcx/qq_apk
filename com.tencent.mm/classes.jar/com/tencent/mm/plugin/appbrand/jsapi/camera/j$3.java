package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class j$3
  implements android.support.v4.app.a.a
{
  j$3(j paramj, c paramc, e parame) {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(126242);
    if (paramInt == 16)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a.a.aCy().hIk = true;
        this.hJg.a(this.hza, this.hJf);
        AppMethodBeat.o(126242);
        return;
      }
      paramArrayOfString = new HashMap();
      paramArrayOfString.put("cameraId", Integer.valueOf(this.hJf.getCameraId()));
      paramArrayOfString = new JSONObject(paramArrayOfString).toString();
      new g().j(this.hza).BN(paramArrayOfString).aBz();
      a.a.aCy().hIk = false;
      AppMethodBeat.o(126242);
      return;
    }
    if (paramInt == 18)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        a.a.aCy().hIl = true;
        this.hJg.a(this.hza, this.hJf);
        AppMethodBeat.o(126242);
        return;
      }
      paramArrayOfString = new HashMap();
      paramArrayOfString.put("cameraId", Integer.valueOf(this.hJf.getCameraId()));
      paramArrayOfString = new JSONObject(paramArrayOfString).toString();
      new g().j(this.hza).BN(paramArrayOfString).aBz();
      a.a.aCy().hIl = false;
    }
    AppMethodBeat.o(126242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j.3
 * JD-Core Version:    0.7.0.1
 */