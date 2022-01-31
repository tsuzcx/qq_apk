package com.tencent.luggage.sdk.d;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.a;
import com.tencent.mm.plugin.appbrand.config.a.a.b;

final class a$3
  implements a.a
{
  a$3(a parama, String paramString) {}
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(140796);
    d.i("Luggage.AppBrandRuntimeContainerLU", "tryRequestOrientation, onOrientationChanged, appId[%s] orientation[%s] success[%b]", new Object[] { this.val$appId, paramb, Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(140796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a.3
 * JD-Core Version:    0.7.0.1
 */