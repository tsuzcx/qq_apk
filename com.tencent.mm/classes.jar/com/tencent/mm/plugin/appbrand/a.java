package com.tencent.mm.plugin.appbrand;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.n.o;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHelper;", "", "()V", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a qqO;
  
  static
  {
    AppMethodBeat.i(316789);
    qqO = new a((byte)0);
    AppMethodBeat.o(316789);
  }
  
  public static final o g(m paramm)
  {
    AppMethodBeat.i(316786);
    paramm = a.g(paramm);
    AppMethodBeat.o(316786);
    return paramm;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHelper$Companion;", "", "()V", "convertToAdWorkerExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void a(ValueCallback paramValueCallback, String paramString, m.c paramc)
    {
      AppMethodBeat.i(316690);
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue(paramString);
      }
      AppMethodBeat.o(316690);
    }
    
    private static final void b(m paramm, String paramString, ValueCallback paramValueCallback)
    {
      AppMethodBeat.i(316695);
      s.u(paramm, "$engine");
      paramm.a(paramString, new a.a..ExternalSyntheticLambda0(paramValueCallback));
      AppMethodBeat.o(316695);
    }
    
    public static o g(m paramm)
    {
      AppMethodBeat.i(316685);
      s.u(paramm, "engine");
      paramm = (o)new a.a..ExternalSyntheticLambda1(paramm);
      AppMethodBeat.o(316685);
      return paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */