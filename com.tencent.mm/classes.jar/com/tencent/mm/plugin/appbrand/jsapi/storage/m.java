package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public final class m
  extends ab<k>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorageSync";
  
  private static void b(k paramk, String paramString, int paramInt)
  {
    AppMethodBeat.i(147271);
    n localn = paramk.getRuntime().asG();
    ((a)e.T(a.class)).f(paramk.getAppId(), localn.qYZ, localn.qLQ).o(paramInt, paramk.getAppId(), paramString);
    AppMethodBeat.o(147271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.m
 * JD-Core Version:    0.7.0.1
 */