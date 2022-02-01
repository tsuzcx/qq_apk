package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class e<T extends g>
  extends d
{
  static final ThreadPoolExecutor lUJ = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T lUI;
  
  public e(T paramT)
  {
    this.lUI = paramT;
    this.lUI.lUM = this;
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    lUJ.submit(new Runnable()
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
          i.a locala = e.a(e.this).e(paramf, paramJSONObject);
          paramf.i(paramInt, e.this.a(paramf, locala.errMsg, locala.values));
          AppMethodBeat.o(128848);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("Luggage.BaseNFSApiAsync", localThrowable, "%s.invoke, appId=%s, callbackId=%d", new Object[] { e.a(e.this).getClass().getName(), paramf.getAppId(), Integer.valueOf(paramInt) });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              throw localThrowable;
            }
          });
          paramf.i(paramInt, e.this.h("fail:internal error", null));
          AppMethodBeat.o(128848);
        }
      }
    });
  }
  
  public final boolean bEa()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.e
 * JD-Core Version:    0.7.0.1
 */