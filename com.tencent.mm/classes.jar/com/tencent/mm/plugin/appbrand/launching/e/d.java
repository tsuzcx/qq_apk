package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d
  extends a
{
  private static final Map<String, d> lRW;
  private final String lRX;
  private final String lRY;
  private final WeakReference<Context> mContextRef;
  
  static
  {
    AppMethodBeat.i(47452);
    lRW = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.lRX = paramString;
    this.lRY = paramContext.getClass().getName();
    this.mContextRef = new WeakReference(paramContext);
    this.lRK = paramBoolean;
    lRW.put(paramString, this);
    paramContext = new a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.ay(l, l);
    AppMethodBeat.o(47449);
  }
  
  public static d SH(String paramString)
  {
    AppMethodBeat.i(47448);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)lRW.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final Context bsJ()
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
      paramAppBrandStatObject = t.mwW;
      t.g(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
  }
  
  static final class a
    extends aw
  {
    a(String paramString)
    {
      super(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47446);
          d locald = d.SH(d.a.this);
          if (locald != null) {
            locald.bsG();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.d
 * JD-Core Version:    0.7.0.1
 */