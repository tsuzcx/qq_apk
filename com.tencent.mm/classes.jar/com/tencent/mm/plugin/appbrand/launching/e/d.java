package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.w;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d
  extends a
{
  private static final Map<String, d> mZi;
  private final WeakReference<Context> mContextRef;
  private final String mZj;
  private final String mZk;
  
  static
  {
    AppMethodBeat.i(47452);
    mZi = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.mZj = paramString;
    this.mZk = paramContext.getClass().getName();
    this.mContextRef = new WeakReference(paramContext);
    this.mYV = paramBoolean;
    mZi.put(paramString, this);
    new a(paramString).startTimer(TimeUnit.SECONDS.toMillis(300L));
    AppMethodBeat.o(47449);
  }
  
  public static d acl(String paramString)
  {
    AppMethodBeat.i(47448);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)mZi.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final Context bOf()
  {
    AppMethodBeat.i(47451);
    Context localContext = (Context)this.mContextRef.get();
    AppMethodBeat.o(47451);
    return localContext;
  }
  
  protected final void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47450);
    super.c(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    if (paramAppBrandInitConfigWC != null)
    {
      paramAppBrandStatObject = w.nHZ;
      w.i(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
  }
  
  static final class a
    extends MTimerHandler
  {
    a(String paramString)
    {
      super(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47446);
          d locald = d.acl(d.a.this);
          if (locald != null) {
            locald.bOc();
          }
          AppMethodBeat.o(47446);
          return false;
        }
      }, false);
      AppMethodBeat.i(47447);
      AppMethodBeat.o(47447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.d
 * JD-Core Version:    0.7.0.1
 */