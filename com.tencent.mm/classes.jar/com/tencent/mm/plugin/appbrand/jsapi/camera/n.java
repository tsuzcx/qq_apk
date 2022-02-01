package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class n
  extends d
{
  private static final int CTRL_INDEX = 332;
  public static final String NAME = "operateCamera";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137480);
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data is null or nil", null));
      AppMethodBeat.o(137480);
      return;
    }
    MMHandlerThread.postToMainThread(new n.1(this, paramJSONObject, paramf, paramInt));
    AppMethodBeat.o(137480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.n
 * JD-Core Version:    0.7.0.1
 */