package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.e.i.h;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.jsapi.o;

public class n
  extends c<j>
{
  public static final int CTRL_INDEX = 16;
  public static final String NAME = "setStorage";
  private a prH;
  
  public n()
  {
    AppMethodBeat.i(147281);
    this.prH = new a()
    {
      public final void a(String paramAnonymousString, j paramAnonymousj, int paramAnonymousInt)
      {
        AppMethodBeat.i(147278);
        paramAnonymousj.j(paramAnonymousInt, n.this.h(paramAnonymousString, null));
        AppMethodBeat.o(147278);
      }
    };
    AppMethodBeat.o(147281);
  }
  
  private void a(final j paramj, final int paramInt1, final int paramInt2, final String paramString1, final String paramString2, final String paramString3, final String paramString4, final a parama)
  {
    AppMethodBeat.i(147282);
    final long l = System.currentTimeMillis();
    paramj.getRuntime().R(new h()
    {
      public final String getKey()
      {
        return "JsApiSetStorage";
      }
      
      public final void run()
      {
        AppMethodBeat.i(147279);
        String str = p.a(((a)e.K(a.class)).dX(paramj.getAppId()).d(paramInt2, paramString4, paramString1, paramString2, paramString3));
        if (parama != null) {
          parama.a(str, paramj, paramInt1);
        }
        n.b(2, v.cP(paramString1, paramString2), l, paramj);
        AppMethodBeat.o(147279);
      }
    });
    AppMethodBeat.o(147282);
  }
  
  private void b(final j paramj, final int paramInt1, int paramInt2, final String paramString1, final String paramString2, String paramString3, String paramString4, final a parama)
  {
    AppMethodBeat.i(147283);
    final long l = System.currentTimeMillis();
    final JsApiSetStorageTask localJsApiSetStorageTask = new JsApiSetStorageTask();
    localJsApiSetStorageTask.appId = paramString4;
    localJsApiSetStorageTask.prw = paramInt2;
    localJsApiSetStorageTask.F(paramString1, paramString2, paramString3);
    localJsApiSetStorageTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147280);
        if (parama != null) {
          parama.a(localJsApiSetStorageTask.result, paramj, paramInt1);
        }
        n.b(1, v.cP(paramString1, paramString2), l, paramj);
        localJsApiSetStorageTask.bPk();
        AppMethodBeat.o(147280);
      }
    };
    localJsApiSetStorageTask.bsM();
    AppMethodBeat.o(147283);
  }
  
  protected String e(j paramj)
  {
    AppMethodBeat.i(147284);
    paramj = paramj.getRuntime().mAppId;
    AppMethodBeat.o(147284);
    return paramj;
  }
  
  static abstract interface a
  {
    public abstract void a(String paramString, j paramj, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.n
 * JD-Core Version:    0.7.0.1
 */