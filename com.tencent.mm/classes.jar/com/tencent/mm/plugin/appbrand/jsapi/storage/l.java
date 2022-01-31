package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;

public final class l
  extends u<h>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  private static void b(h paramh, String paramString, int paramInt)
  {
    AppMethodBeat.i(102065);
    ((b)e.q(b.class)).cc(paramh.getAppId()).l(paramInt, paramh.getAppId(), paramString);
    AppMethodBeat.o(102065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.l
 * JD-Core Version:    0.7.0.1
 */