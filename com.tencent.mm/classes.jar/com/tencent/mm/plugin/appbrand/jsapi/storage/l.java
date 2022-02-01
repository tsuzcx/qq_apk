package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y;

public final class l
  extends y<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  private static void b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString, int paramInt)
  {
    AppMethodBeat.i(147271);
    ((a)e.K(a.class)).ch(paramh.getAppId()).l(paramInt, paramh.getAppId(), paramString);
    AppMethodBeat.o(147271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.l
 * JD-Core Version:    0.7.0.1
 */