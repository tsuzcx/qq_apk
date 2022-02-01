package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/AppBrandFakeNativeCheckXWebConfig;", "", "()V", "DEFAULT_CONFIG", "", "kotlin.jvm.PlatformType", "checkIfXWebRequired", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"})
public final class f
{
  private static final String jvX;
  public static final f jvY;
  
  static
  {
    AppMethodBeat.i(175098);
    jvY = new f();
    jvX = org.apache.commons.b.g.a(new String[] { "wxfe02ecfe70800f46", "wx1d9b0b103d81d15d", "wx162102d2ff543cb2" }, ',', 3);
    AppMethodBeat.o(175098);
  }
  
  public static final boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(175097);
    p.h(paramAppBrandInitConfigWC, "config");
    Object localObject1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.quV, jvX);
    p.g(localObject1, "MMKernel.service(IExptSe…required, DEFAULT_CONFIG)");
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
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localObject3 == null)
      {
        paramAppBrandInitConfigWC = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(175097);
        throw paramAppBrandInitConfigWC;
      }
      ((Collection)localObject1).add(n.trim((CharSequence)localObject3).toString());
    }
    boolean bool = ((List)localObject1).contains(paramAppBrandInitConfigWC.appId);
    AppMethodBeat.o(175097);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f
 * JD-Core Version:    0.7.0.1
 */