package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.permission.e.a;
import com.tencent.mm.plugin.appbrand.permission.e.b;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements c.b
{
  private final AppBrandRuntime jcD;
  private final e jcE;
  final com.tencent.mm.plugin.appbrand.jsapi.c jcF;
  
  public c(AppBrandRuntime paramAppBrandRuntime, com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame)
  {
    this.jcD = paramAppBrandRuntime;
    this.jcF = paramc;
    this.jcE = parame;
  }
  
  public void Q(int paramInt, String paramString) {}
  
  public final void a(ar paramar, c.a parama)
  {
    AppMethodBeat.i(146924);
    Object localObject1 = null;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        if (this.jcD == null) {
          break label402;
        }
        localObject2 = this.jcD.jdK;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label402;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.appbrand.b.c)localObject2).jqZ.jrj.get()) {
          break label402;
        }
        i = 1;
        if (i == 0)
        {
          parama.LJ("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
        if ((!this.jcF.isRunning()) && (!this.jcF.aUk()))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          ac.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { paramar.getName(), this.jcF.getAppId() });
          parama.LJ("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
      }
      catch (NullPointerException parama)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramar.getName() });
        AppMethodBeat.o(146924);
        return;
      }
      i = 0;
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.b.c)localObject2).jqZ.aXJ();
    boolean bool2 = this.jcE.a(this.jcF, paramar);
    if (b.jqW != localObject1)
    {
      if (!bool2) {
        break label422;
      }
      break label411;
      label216:
      localObject2 = (h)this.jcF.K(h.class);
      if (localObject2 == null) {
        break label417;
      }
      if (((h)localObject2).a(paramar)) {
        break label428;
      }
      break label417;
    }
    for (;;)
    {
      if (i != 0)
      {
        ac.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), paramar.getName(), localObject1, Boolean.valueOf(bool2) });
        if (bt.eWo())
        {
          if (!paramar.getName().equals("onInitialRenderingCacheReady")) {
            break label362;
          }
          ac.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramar.getName(), Integer.valueOf(paramar.getData().length()) });
        }
      }
      while (!bool1)
      {
        parama.LJ("fail:access denied");
        AppMethodBeat.o(146924);
        return;
        label362:
        ac.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramar.getName(), paramar.getData() });
      }
      parama.proceed();
      AppMethodBeat.o(146924);
      return;
      label402:
      i = 0;
      localObject2 = localObject1;
      break;
      label411:
      boolean bool1 = true;
      break label216;
      label417:
      i = 1;
      continue;
      label422:
      bool1 = false;
      break label216;
      label428:
      i = 0;
    }
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(final m paramm, String paramString, int paramInt, final c.a parama)
  {
    AppMethodBeat.i(146923);
    paramString = this.jcE.a(this.jcF, paramm, paramString, new e.b()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((c.this.jcF == null) || (!c.this.jcF.isRunning()))
        {
          AppMethodBeat.o(146922);
          return;
        }
        if (paramAnonymousa.ret == 0)
        {
          parama.proceed();
          AppMethodBeat.o(146922);
          return;
        }
        if (TextUtils.isEmpty(paramAnonymousa.bIO)) {}
        for (paramAnonymousa = "fail:internal error";; paramAnonymousa = paramAnonymousa.bIO)
        {
          parama.LJ(paramm.e(paramAnonymousa, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
    });
    if (-2 == paramString.ret)
    {
      AppMethodBeat.o(146923);
      return true;
    }
    if (paramString.ret != 0)
    {
      parama.LJ(paramm.e(paramString.bIO, null));
      AppMethodBeat.o(146923);
      return true;
    }
    AppMethodBeat.o(146923);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c
 * JD-Core Version:    0.7.0.1
 */