package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.y;
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
  private static final Map<String, d> teA;
  private final WeakReference<Context> mContextRef;
  private final String teB;
  private final String teC;
  
  static
  {
    AppMethodBeat.i(47452);
    teA = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.teB = paramString;
    this.teC = paramContext.getClass().getName();
    this.mContextRef = new WeakReference(paramContext);
    this.teh = paramBoolean;
    teA.put(paramString, this);
    new a(paramString).startTimer(TimeUnit.SECONDS.toMillis(300L));
    AppMethodBeat.o(47449);
  }
  
  public static d adk(String paramString)
  {
    AppMethodBeat.i(47448);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)teA.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47450);
    super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    if (paramAppBrandInitConfigWC != null)
    {
      paramAppBrandStatObject = y.tOP;
      y.j(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
  }
  
  protected final Context cAR()
  {
    AppMethodBeat.i(47451);
    Context localContext = (Context)this.mContextRef.get();
    AppMethodBeat.o(47451);
    return localContext;
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
          d locald = d.adk(d.a.this);
          if (locald != null) {
            locald.cAO();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.d
 * JD-Core Version:    0.7.0.1
 */