package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class c$b$1
  implements com.tencent.mm.plugin.appbrand.t.k.a
{
  c$b$1(c.b paramb, c paramc) {}
  
  public final boolean j(Object... paramVarArgs)
  {
    AppMethodBeat.i(126373);
    ab.v("MicroMsg.JsApiEnableCompass", "onAction.");
    paramVarArgs = new float[3];
    Object localObject = new float[9];
    SensorManager.getRotationMatrix((float[])localObject, null, c.b.a(this.hYG), c.b.b(this.hYG));
    SensorManager.getOrientation((float[])localObject, paramVarArgs);
    localObject = new HashMap();
    float f2 = (float)Math.toDegrees(paramVarArgs[0]);
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    ((Map)localObject).put("direction", Float.valueOf(f1));
    if (c.b.c(this.hYG).equalsIgnoreCase("unknow")) {
      ((Map)localObject).put("accuracy", c.b.c(this.hYG) + "{value:" + c.b.d(this.hYG) + "}");
    }
    for (;;)
    {
      this.hYG.hYF.x((Map)localObject);
      boolean bool = k.a.hZf.a(this.hYG.hYF, this.hxW);
      AppMethodBeat.o(126373);
      return bool;
      ((Map)localObject).put("accuracy", c.b.c(this.hYG));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.c.b.1
 * JD-Core Version:    0.7.0.1
 */