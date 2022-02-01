package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class e<T extends g>
  extends a
{
  static final ThreadPoolExecutor jQn = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T jQm;
  
  public e(T paramT)
  {
    this.jQm = paramT;
    this.jQm.jQq = this;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    jQn.submit(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128848);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128848);
          return;
        }
        try
        {
          i.a locala = e.a(e.this).e(paramc, paramJSONObject);
          paramc.h(paramInt, e.this.a(paramc, locala.errMsg, locala.values));
          AppMethodBeat.o(128848);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("Luggage.BaseNFSApiAsync", localThrowable, "%s.invoke, appId=%s, callbackId=%d", new Object[] { e.a(e.this).getClass().getName(), paramc.getAppId(), Integer.valueOf(paramInt) });
          aq.f(new Runnable()
          {
            public final void run()
            {
              throw localThrowable;
            }
          });
          paramc.h(paramInt, e.this.e("fail:internal error", null));
          AppMethodBeat.o(128848);
        }
      }
    });
  }
  
  public final boolean aXA()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */