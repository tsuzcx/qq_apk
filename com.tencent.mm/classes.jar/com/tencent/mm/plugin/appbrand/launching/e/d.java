package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.t;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class d
  extends a
{
  private static final Map<String, d> kOB;
  private final WeakReference<Context> avO;
  private final String kOC;
  private final String kOD;
  
  static
  {
    AppMethodBeat.i(47452);
    kOB = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.kOC = paramString;
    this.kOD = paramContext.getClass().getName();
    this.avO = new WeakReference(paramContext);
    this.kOp = paramBoolean;
    kOB.put(paramString, this);
    paramContext = new a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.av(l, l);
    AppMethodBeat.o(47449);
  }
  
  public static d Ks(String paramString)
  {
    AppMethodBeat.i(47448);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)kOB.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(47450);
    super.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
    if (paramAppBrandInitConfigWC != null)
    {
      paramAppBrandStatObject = t.lqn;
      t.h(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
  }
  
  protected final Context bhl()
  {
    AppMethodBeat.i(47451);
    Context localContext = (Context)this.avO.get();
    AppMethodBeat.o(47451);
    return localContext;
  }
  
  static final class a
    extends av
  {
    a(String paramString)
    {
      super(new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47446);
          d locald = d.Ks(d.a.this);
          if (locald != null) {
            locald.bhi();
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