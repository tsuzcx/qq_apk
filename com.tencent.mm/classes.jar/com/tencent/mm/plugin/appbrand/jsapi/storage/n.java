package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.m;

public class n
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.jsapi.h>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private a klk;
  
  public n()
  {
    AppMethodBeat.i(147281);
    this.klk = new a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.plugin.appbrand.jsapi.h paramAnonymoush, int paramAnonymousInt)
      {
        AppMethodBeat.i(147278);
        paramAnonymoush.h(paramAnonymousInt, n.this.e(paramAnonymousString, null));
        AppMethodBeat.o(147278);
      }
    };
    AppMethodBeat.o(147281);
  }
  
  private void a(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final a parama)
  {
    AppMethodBeat.i(147282);
    final long l = System.currentTimeMillis();
    paramh.getRuntime().M(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "JsApiSetStorage";
      }
      
      public final void run()
      {
        AppMethodBeat.i(147279);
        String str = p.a(((com.tencent.luggage.sdk.customize.a)e.K(com.tencent.luggage.sdk.customize.a.class)).cs(paramh.getAppId()).c(paramInt2, paramString4, paramString1, paramString2, paramString3));
        if (parama != null) {
          parama.a(str, paramh, paramInt1);
        }
        n.b(2, s.cf(paramString1, paramString2), l, paramh);
        AppMethodBeat.o(147279);
      }
    });
    AppMethodBeat.o(147282);
  }
  
  private void b(final com.tencent.mm.plugin.appbrand.jsapi.h paramh, final int paramInt1, int paramInt2, final String paramString1, final String paramString2, String paramString3, String paramString4, final a parama)
  {
    AppMethodBeat.i(147283);
    final long l = System.currentTimeMillis();
    final JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = paramString4;
    localJsApiSetStorageTask.kkZ = paramInt2;
    localJsApiSetStorageTask.D(paramString1, paramString2, paramString3);
    localJsApiSetStorageTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147280);
        if (parama != null) {
          parama.a(localJsApiSetStorageTask.result, paramh, paramInt1);
        }
        n.b(1, s.cf(paramString1, paramString2), l, paramh);
        localJsApiSetStorageTask.aXn();
        AppMethodBeat.o(147280);
      }
    };
    localJsApiSetStorageTask.aXm();
    AppBrandMainProcessService.a(localJsApiSetStorageTask);
    AppMethodBeat.o(147283);
  }
  
  protected String f(com.tencent.mm.plugin.appbrand.jsapi.h paramh)
  {
    AppMethodBeat.i(147284);
    paramh = paramh.getRuntime().mAppId;
    AppMethodBeat.o(147284);
    return paramh;
  }
  
  static abstract interface a
  {
    public abstract void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n
 * JD-Core Version:    0.7.0.1
 */