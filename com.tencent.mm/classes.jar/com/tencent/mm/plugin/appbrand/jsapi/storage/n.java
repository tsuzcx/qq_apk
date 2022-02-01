package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public class n
  extends d<k>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private a mtw;
  
  public n()
  {
    AppMethodBeat.i(147281);
    this.mtw = new a()
    {
      public final void a(String paramAnonymousString, k paramAnonymousk, int paramAnonymousInt)
      {
        AppMethodBeat.i(147278);
        paramAnonymousk.i(paramAnonymousInt, n.this.h(paramAnonymousString, null));
        AppMethodBeat.o(147278);
      }
    };
    AppMethodBeat.o(147281);
  }
  
  private void a(final k paramk, final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final a parama)
  {
    AppMethodBeat.i(147282);
    final long l = System.currentTimeMillis();
    paramk.getRuntime().Q(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "JsApiSetStorage";
      }
      
      public final void run()
      {
        AppMethodBeat.i(147279);
        String str = p.a(((a)e.M(a.class)).dD(paramk.getAppId()).c(paramInt2, paramString4, paramString1, paramString2, paramString3));
        if (parama != null) {
          parama.a(str, paramk, paramInt1);
        }
        n.b(2, t.cF(paramString1, paramString2), l, paramk);
        AppMethodBeat.o(147279);
      }
    });
    AppMethodBeat.o(147282);
  }
  
  private void b(final k paramk, final int paramInt1, int paramInt2, final String paramString1, final String paramString2, String paramString3, String paramString4, final a parama)
  {
    AppMethodBeat.i(147283);
    final long l = System.currentTimeMillis();
    final JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = paramString4;
    localJsApiSetStorageTask.mtl = paramInt2;
    localJsApiSetStorageTask.E(paramString1, paramString2, paramString3);
    localJsApiSetStorageTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147280);
        if (parama != null) {
          parama.a(localJsApiSetStorageTask.result, paramk, paramInt1);
        }
        n.b(1, t.cF(paramString1, paramString2), l, paramk);
        localJsApiSetStorageTask.bDK();
        AppMethodBeat.o(147280);
      }
    };
    localJsApiSetStorageTask.bDJ();
    AppBrandMainProcessService.a(localJsApiSetStorageTask);
    AppMethodBeat.o(147283);
  }
  
  protected String e(k paramk)
  {
    AppMethodBeat.i(147284);
    paramk = paramk.getRuntime().mAppId;
    AppMethodBeat.o(147284);
    return paramk;
  }
  
  static abstract interface a
  {
    public abstract void a(String paramString, k paramk, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n
 * JD-Core Version:    0.7.0.1
 */