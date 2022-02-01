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
  private static final Map<String, d> lNv;
  private final String lNw;
  private final String lNx;
  private final WeakReference<Context> mContextRef;
  
  static
  {
    AppMethodBeat.i(47452);
    lNv = new ConcurrentHashMap();
    AppMethodBeat.o(47452);
  }
  
  d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47449);
    this.lNw = paramString;
    this.lNx = paramContext.getClass().getName();
    this.mContextRef = new WeakReference(paramContext);
    this.lNj = paramBoolean;
    lNv.put(paramString, this);
    paramContext = new a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.az(l, l);
    AppMethodBeat.o(47449);
  }
  
  public static d RY(String paramString)
  {
    AppMethodBeat.i(47448);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(47448);
      return null;
    }
    paramString = (d)lNv.remove(paramString);
    AppMethodBeat.o(47448);
    return paramString;
  }
  
  protected final Context brY()
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
      paramAppBrandStatObject = t.mrY;
      t.g(paramAppBrandInitConfigWC);
    }
    AppMethodBeat.o(47450);
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
          d locald = d.RY(d.a.this);
          if (locald != null) {
            locald.brV();
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