package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.aa;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.threadpool.i.h;

public class o
  extends c<k>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private a swl;
  
  public o()
  {
    AppMethodBeat.i(147281);
    this.swl = new a()
    {
      public final void a(String paramAnonymousString, k paramAnonymousk, int paramAnonymousInt)
      {
        AppMethodBeat.i(147278);
        paramAnonymousk.callback(paramAnonymousInt, o.this.ZP(paramAnonymousString));
        AppMethodBeat.o(147278);
      }
    };
    AppMethodBeat.o(147281);
  }
  
  private void a(final k paramk, final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final a parama)
  {
    AppMethodBeat.i(147282);
    final long l = System.currentTimeMillis();
    paramk.getRuntime().X(new h()
    {
      public final String getKey()
      {
        return "JsApiSetStorage";
      }
      
      public final void run()
      {
        AppMethodBeat.i(147279);
        Object localObject = paramk.getRuntime().asG();
        localObject = q.a(((a)e.T(a.class)).f(paramk.getAppId(), ((n)localObject).qYZ, ((n)localObject).qLQ).d(paramInt2, paramString4, paramString1, paramString2, paramString3));
        if (parama != null) {
          parama.a((String)localObject, paramk, paramInt1);
        }
        o.b(2, aa.dg(paramString1, paramString2), l, paramk);
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
    localJsApiSetStorageTask.svX = paramInt2;
    localJsApiSetStorageTask.J(paramString1, paramString2, paramString3);
    localJsApiSetStorageTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147280);
        if (parama != null) {
          parama.a(localJsApiSetStorageTask.result, paramk, paramInt1);
        }
        o.b(1, aa.dg(paramString1, paramString2), l, paramk);
        localJsApiSetStorageTask.cpx();
        AppMethodBeat.o(147280);
      }
    };
    localJsApiSetStorageTask.bQt();
    AppMethodBeat.o(147283);
  }
  
  protected String c(k paramk)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.o
 * JD-Core Version:    0.7.0.1
 */