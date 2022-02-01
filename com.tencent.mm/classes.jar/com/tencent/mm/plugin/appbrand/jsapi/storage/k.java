package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.thread.ThreadPool;

public class k
  extends c<j>
{
  public static final int CTRL_INDEX = 98;
  public static final String NAME = "removeStorage";
  
  private void a(j paramj, String paramString, int paramInt)
  {
    AppMethodBeat.i(147267);
    JsApiRemoveStorageTask localJsApiRemoveStorageTask = new JsApiRemoveStorageTask();
    localJsApiRemoveStorageTask.appId = F(paramj);
    localJsApiRemoveStorageTask.prw = paramInt;
    localJsApiRemoveStorageTask.key = paramString;
    localJsApiRemoveStorageTask.bsM();
    AppMethodBeat.o(147267);
  }
  
  private void b(final j paramj, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(147268);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(147266);
        ((a)com.tencent.luggage.a.e.K(a.class)).dX(paramj.getAppId()).m(paramInt, k.this.F(paramj), paramString);
        AppMethodBeat.o(147266);
      }
    }, "JsApiRemoveStorage");
    AppMethodBeat.o(147268);
  }
  
  protected String F(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(147269);
    parame = parame.getAppId();
    AppMethodBeat.o(147269);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.k
 * JD-Core Version:    0.7.0.1
 */