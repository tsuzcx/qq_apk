package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.SensorManager;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.v.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class b$b$1
  implements g.a
{
  b$b$1(b.b paramb, f paramf) {}
  
  public final boolean i(Object... paramVarArgs)
  {
    y.v("MicroMsg.JsApiEnableCompass", "onAction.");
    paramVarArgs = new float[3];
    Object localObject = new float[9];
    SensorManager.getRotationMatrix((float[])localObject, null, b.b.a(this.gAN), b.b.b(this.gAN));
    SensorManager.getOrientation((float[])localObject, paramVarArgs);
    localObject = new HashMap();
    float f2 = (float)Math.toDegrees(paramVarArgs[0]);
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    ((Map)localObject).put("direction", Float.valueOf(f1));
    if (b.b.c(this.gAN).equalsIgnoreCase("unknow")) {
      ((Map)localObject).put("accuracy", b.b.c(this.gAN) + "{value:" + b.b.d(this.gAN) + "}");
    }
    for (;;)
    {
      this.gAN.gAM.o((Map)localObject);
      return h.ajW().a(this.gAN.gAM, this.gfy);
      ((Map)localObject).put("accuracy", b.b.c(this.gAN));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.b.1
 * JD-Core Version:    0.7.0.1
 */