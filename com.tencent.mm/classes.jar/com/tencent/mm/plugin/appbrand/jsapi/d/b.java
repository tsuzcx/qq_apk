package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.xeffect.FaceTracker;
import com.tencent.mm.xeffect.XEffectLog;
import d.g.b.p;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 861;
  public static final String NAME = "faceDetect";
  private static String mSR = "Thread.AppBrand.JsApiFaceDetect";
  
  public final ByteBuffer a(String paramString, k paramk, int paramInt)
  {
    AppMethodBeat.i(221282);
    if ("frameBuffer".equalsIgnoreCase(paramString))
    {
      paramString = paramk.ak(paramInt, true);
      AppMethodBeat.o(221282);
      return paramString;
    }
    paramString = super.a(paramString, paramk, paramInt);
    AppMethodBeat.o(221282);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.b
 * JD-Core Version:    0.7.0.1
 */