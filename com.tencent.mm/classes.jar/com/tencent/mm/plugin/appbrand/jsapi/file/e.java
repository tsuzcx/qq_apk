package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class e<T extends g>
  extends c
{
  static final ThreadPoolExecutor rXi = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T rXh;
  
  public e(T paramT)
  {
    this.rXh = paramT;
    this.rXh.rXl = this;
  }
  
  public void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    a(paramf, paramJSONObject, paramInt, paramf.getJsRuntime());
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt, final o paramo)
  {
    rXi.submit(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128848);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(128848);
          return;
        }
        try
        {
          i.a locala = e.a(e.this).a(paramf, paramo, paramJSONObject);
          paramf.callback(paramInt, e.this.a(paramf, locala.errMsg, locala.values));
          AppMethodBeat.o(128848);
          return;
        }
        finally
        {
          Log.printErrStackTrace("Luggage.BaseNFSApiAsync", localThrowable, "%s.invoke, appId=%s, callbackId=%d", new Object[] { e.a(e.this).getClass().getName(), paramf.getAppId(), Integer.valueOf(paramInt) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              throw localThrowable;
            }
          });
          paramf.callback(paramInt, e.this.ZP("fail:internal error"));
          AppMethodBeat.o(128848);
        }
      }
    });
  }
  
  public final boolean cpE()
  {
    return true;
  }
  
  public boolean cpN()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */