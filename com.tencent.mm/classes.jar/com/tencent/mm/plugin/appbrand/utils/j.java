package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandPermissionDelegateLogic;", "", "()V", "SystemAuthFrequencyLimitFlagLocation", "", "SystemAuthFrequencyLimitFlagNone", "TAG", "", "delegate", "com/tencent/mm/plugin/appbrand/utils/AppBrandPermissionDelegateLogic$delegate$2$1", "getDelegate", "()Lcom/tencent/mm/plugin/appbrand/utils/AppBrandPermissionDelegateLogic$delegate$2$1;", "delegate$delegate", "Lkotlin/Lazy;", "installDelegate", "", "requestPermission", "activity", "Landroid/content/Context;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "permission", "onGrant", "Ljava/lang/Runnable;", "onDenied", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j uqy;
  private static final kotlin.j uqz;
  
  static
  {
    AppMethodBeat.i(317321);
    uqy = new j();
    uqz = k.cm((a)a.uqA);
    AppMethodBeat.o(317321);
  }
  
  public static void a(Context paramContext, f paramf, String paramString, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(317313);
    s.u(paramContext, "activity");
    s.u(paramf, "component");
    s.u(paramString, "permission");
    if (!(paramContext instanceof Activity))
    {
      if (paramRunnable2 != null) {
        paramRunnable2.run();
      }
      AppMethodBeat.o(317313);
      return;
    }
    cNx().a((Activity)paramContext, paramf, paramString, new j..ExternalSyntheticLambda0(paramRunnable1, paramRunnable2));
    AppMethodBeat.o(317313);
  }
  
  private static final void a(Runnable paramRunnable1, Runnable paramRunnable2, int paramInt)
  {
    AppMethodBeat.i(317317);
    c.uiThread((a)new j.b(paramInt, paramRunnable1, paramRunnable2));
    AppMethodBeat.o(317317);
  }
  
  public static j.a.1 cNx()
  {
    AppMethodBeat.i(317307);
    j.a.1 local1 = (j.a.1)uqz.getValue();
    AppMethodBeat.o(317307);
    return local1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/utils/AppBrandPermissionDelegateLogic$delegate$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<j.a.1>
  {
    public static final a uqA;
    
    static
    {
      AppMethodBeat.i(317383);
      uqA = new a();
      AppMethodBeat.o(317383);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.j
 * JD-Core Version:    0.7.0.1
 */