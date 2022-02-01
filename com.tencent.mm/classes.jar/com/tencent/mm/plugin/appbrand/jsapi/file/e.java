package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class e<T extends g>
  extends c
{
  static final ThreadPoolExecutor oRI = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T oRH;
  
  public e(T paramT)
  {
    this.oRH = paramT;
    this.oRH.oRL = this;
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    a(parame, paramJSONObject, paramInt, parame.getJsRuntime());
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt, final com.tencent.mm.plugin.appbrand.m.o paramo)
  {
    oRI.submit(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128848);
        if (!parame.isRunning())
        {
          AppMethodBeat.o(128848);
          return;
        }
        try
        {
          i.a locala = e.a(e.this).a(parame, paramo, paramJSONObject);
          parame.j(paramInt, e.this.a(parame, locala.errMsg, locala.values));
          AppMethodBeat.o(128848);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("Luggage.BaseNFSApiAsync", localThrowable, "%s.invoke, appId=%s, callbackId=%d", new Object[] { e.a(e.this).getClass().getName(), parame.getAppId(), Integer.valueOf(paramInt) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              throw localThrowable;
            }
          });
          parame.j(paramInt, e.this.h("fail:internal error", null));
          AppMethodBeat.o(128848);
        }
      }
    });
  }
  
  public boolean bPG()
  {
    return true;
  }
  
  public final boolean bPy()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */