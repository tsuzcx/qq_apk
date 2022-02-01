package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.sdk.platformtools.ac;

public final class o
  extends y<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorageSync";
  
  private static String a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147287);
    long l = System.currentTimeMillis();
    try
    {
      JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
      localJsApiSetStorageTask.appId = paramh.getAppId();
      localJsApiSetStorageTask.kMr = paramInt;
      localJsApiSetStorageTask.D(paramString1, paramString2, paramString3);
      if (AppBrandMainProcessService.b(localJsApiSetStorageTask))
      {
        paramString3 = localJsApiSetStorageTask.result;
        return paramString3;
      }
      ac.e("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", new Object[] { paramh.getAppId(), paramString1 });
      return "fail";
    }
    finally
    {
      r.a(1, 1, s.co(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramh);
      AppMethodBeat.o(147287);
    }
  }
  
  private static String b(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(147288);
    long l = System.currentTimeMillis();
    try
    {
      paramString3 = p.a(((a)e.K(a.class)).ch(paramh.getAppId()).c(paramInt, paramh.getAppId(), paramString1, paramString2, paramString3));
      return paramString3;
    }
    finally
    {
      r.a(2, 1, s.co(paramString1, paramString2), 1, System.currentTimeMillis() - l, paramh);
      AppMethodBeat.o(147288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.o
 * JD-Core Version:    0.7.0.1
 */