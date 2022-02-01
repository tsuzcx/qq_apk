package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.thread.ThreadPool;

public class k
  extends d<com.tencent.mm.plugin.appbrand.jsapi.k>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  private void a(com.tencent.mm.plugin.appbrand.jsapi.k paramk, String paramString, int paramInt)
  {
    AppMethodBeat.i(147267);
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = C(paramk);
    localJsApiRemoveStorageTask.mtl = paramInt;
    localJsApiRemoveStorageTask.key = paramString;
    AppBrandMainProcessService.a(localJsApiRemoveStorageTask);
    AppMethodBeat.o(147267);
  }
  
  private void b(final com.tencent.mm.plugin.appbrand.jsapi.k paramk, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(147268);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147266);
        ((a)e.M(a.class)).dD(paramk.getAppId()).m(paramInt, k.this.C(paramk), paramString);
        AppMethodBeat.o(147266);
      }
    }, "JsApiRemoveStorage");
    AppMethodBeat.o(147268);
  }
  
  protected String C(f paramf)
  {
    AppMethodBeat.i(147269);
    paramf = paramf.getAppId();
    AppMethodBeat.o(147269);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.k
 * JD-Core Version:    0.7.0.1
 */