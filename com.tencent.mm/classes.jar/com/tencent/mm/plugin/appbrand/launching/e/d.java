package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.s;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d
  extends a
{
  private static final Map<String, d> lqa;
  private final String lqb;
  private final String lqc;
  private final WeakReference<Context> mContextRef;
  
  static
  {
    AppMethodBeat.i(47452);
    lqa = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.lqb = paramString;
    this.lqc = paramContext.getClass().getName();
    this.mContextRef = new WeakReference(paramContext);
    this.lpO = paramBoolean;
    lqa.put(paramString, this);
    paramContext = new a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.au(l, l);
    AppMethodBeat.o(47449);
  }
  
  public static d Oz(String paramString)
  {
    AppMethodBeat.i(47448);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)lqa.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47450);
    super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    if (paramAppBrandInitConfigWC != null)
    {
      paramAppBrandStatObject = s.lSi;
      s.h(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
  }
  
  protected final Context bof()
  {
    AppMethodBeat.i(47451);
    Context localContext = (Context)this.mContextRef.get();
    AppMethodBeat.o(47451);
    return localContext;
  }
  
  static final class a
    extends au
  {
    a(String paramString)
    {
      super(new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47446);
          d locald = d.Oz(d.a.this);
          if (locald != null) {
            locald.boc();
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