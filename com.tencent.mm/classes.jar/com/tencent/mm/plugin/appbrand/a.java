package com.tencent.mm.plugin.appbrand;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.m.o;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHelper;", "", "()V", "Companion", "luggage-wxa-app_release"})
public final class a
{
  public static final a nsj;
  
  static
  {
    AppMethodBeat.i(244007);
    nsj = new a((byte)0);
    AppMethodBeat.o(244007);
  }
  
  public static final o b(m paramm)
  {
    AppMethodBeat.i(244010);
    paramm = a.b(paramm);
    AppMethodBeat.o(244010);
    return paramm;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/AppBrandAdWorkerHelper$Companion;", "", "()V", "convertToAdWorkerExecutable", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "engine", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine;", "luggage-wxa-app_release"})
  public static final class a
  {
    public static o b(m paramm)
    {
      AppMethodBeat.i(244019);
      p.k(paramm, "engine");
      paramm = (o)new a(paramm);
      AppMethodBeat.o(244019);
      return paramm;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "script", "", "kotlin.jvm.PlatformType", "cb", "Landroid/webkit/ValueCallback;", "evaluateJavascript"})
    static final class a
      implements c
    {
      a(m paramm) {}
      
      public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
      {
        AppMethodBeat.i(242763);
        this.nsk.a(paramString, (m.b)new m.b()
        {
          public final void a(String paramAnonymousString, m.c paramAnonymousc)
          {
            AppMethodBeat.i(244468);
            paramAnonymousc = this.nsl;
            if (paramAnonymousc != null)
            {
              paramAnonymousc.onReceiveValue(paramAnonymousString);
              AppMethodBeat.o(244468);
              return;
            }
            AppMethodBeat.o(244468);
          }
        });
        AppMethodBeat.o(242763);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a
 * JD-Core Version:    0.7.0.1
 */