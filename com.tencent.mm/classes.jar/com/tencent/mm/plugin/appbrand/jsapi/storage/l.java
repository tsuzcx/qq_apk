package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.thread.ThreadPool;

public class l
  extends c<k>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  private void a(k paramk, String paramString, int paramInt)
  {
    AppMethodBeat.i(147267);
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = H(paramk);
    localJsApiRemoveStorageTask.svX = paramInt;
    localJsApiRemoveStorageTask.key = paramString;
    localJsApiRemoveStorageTask.bQt();
    AppMethodBeat.o(147267);
  }
  
  private void b(final k paramk, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(147268);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147266);
        n localn = paramk.getRuntime().asG();
        ((a)e.T(a.class)).f(paramk.getAppId(), localn.qYZ, localn.qLQ).o(paramInt, l.this.H(paramk), paramString);
        AppMethodBeat.o(147266);
      }
    }, "JsApiRemoveStorage");
    AppMethodBeat.o(147268);
  }
  
  protected String H(f paramf)
  {
    AppMethodBeat.i(147269);
    paramf = paramf.getAppId();
    AppMethodBeat.o(147269);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.l
 * JD-Core Version:    0.7.0.1
 */