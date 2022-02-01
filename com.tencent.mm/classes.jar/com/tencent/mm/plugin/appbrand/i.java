package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandFakeNativeCheckXWebConfig;", "", "()V", "DEFAULT_CONFIG", "", "kotlin.jvm.PlatformType", "checkIfXWebRequired", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i qrr;
  private static final String qrs;
  
  static
  {
    AppMethodBeat.i(175098);
    qrr = new i();
    qrs = org.apache.commons.c.i.a(new String[] { "wxfe02ecfe70800f46", "wx1d9b0b103d81d15d", "wx162102d2ff543cb2" }, ',', 3);
    AppMethodBeat.o(175098);
  }
  
  public static final boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175097);
    s.u(paramAppBrandInitConfigWC, "config");
    Object localObject1 = ((c)h.ax(c.class)).a(c.a.yPo, qrs);
    s.s(localObject1, "service(IExptService::cl…required, DEFAULT_CONFIG)");
    Object localObject2 = (Iterable)n.a((CharSequence)localObject1, new String[] { "," });
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label134:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((CharSequence)localObject3).length() == 0) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label134;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localObject3 == null)
      {
        paramAppBrandInitConfigWC = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(175097);
        throw paramAppBrandInitConfigWC;
      }
      ((Collection)localObject1).add(n.bq((CharSequence)localObject3).toString());
    }
    boolean bool = ((List)localObject1).contains(paramAppBrandInitConfigWC.appId);
    AppMethodBeat.o(175097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i
 * JD-Core Version:    0.7.0.1
 */