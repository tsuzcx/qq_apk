package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public final class l
  extends ab<k>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  private static void b(k paramk, String paramString, int paramInt)
  {
    AppMethodBeat.i(147271);
    ((a)e.M(a.class)).dD(paramk.getAppId()).m(paramInt, paramk.getAppId(), paramString);
    AppMethodBeat.o(147271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.l
 * JD-Core Version:    0.7.0.1
 */