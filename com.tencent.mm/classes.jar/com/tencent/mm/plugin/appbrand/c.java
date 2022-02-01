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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements c.b
{
  private final AppBrandRuntime iCD;
  private final e iCE;
  final com.tencent.mm.plugin.appbrand.jsapi.c iCF;
  
  public c(AppBrandRuntime paramAppBrandRuntime, com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame)
  {
    this.iCD = paramAppBrandRuntime;
    this.iCF = paramc;
    this.iCE = parame;
  }
  
  public void P(int paramInt, String paramString) {}
  
  public final void a(ar paramar, c.a parama)
  {
    AppMethodBeat.i(146924);
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (this.iCD != null)
        {
          Object localObject2 = this.iCD.iDK;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            i = 1;
            localObject1 = localObject2;
            if (i != 0)
            {
              bool1 = ((com.tencent.mm.plugin.appbrand.b.c)localObject1).iQP.iQZ.get();
              if (!bool1)
              {
                if ((this.iCF.isRunning()) || (this.iCF.aNu())) {
                  break label438;
                }
                i = 1;
                if (i != 0)
                {
                  ad.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], runtimeStopped[%b], envStopped[%b]", new Object[] { paramar.getName(), this.iCF.getAppId(), Boolean.valueOf(bool1), Boolean.TRUE });
                  AppMethodBeat.o(146924);
                  return;
                }
                localObject2 = this.iCE;
                if (((com.tencent.mm.plugin.appbrand.b.c)localObject1).iQP.aQO() != b.iQM) {
                  continue;
                }
                bool1 = true;
                boolean bool3 = ((e)localObject2).a(this.iCF, paramar);
                if (bool1) {
                  break label443;
                }
                if (!bool3) {
                  continue;
                }
                break label443;
                localObject1 = (h)this.iCF.K(h.class);
                if (localObject1 == null) {
                  break label449;
                }
                if (((h)localObject1).a(paramar)) {
                  continue;
                }
                break label449;
                if (i != 0)
                {
                  int j = ((e)localObject2).a(this.iCF, paramar, null, false);
                  ad.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[] { Boolean.valueOf(bool2), paramar.getName(), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
                  if ((i != 0) && (bu.eGT()))
                  {
                    if (!paramar.getName().equals("onInitialRenderingCacheReady")) {
                      continue;
                    }
                    ad.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramar.getName(), Integer.valueOf(paramar.getData().length()) });
                  }
                }
                if (bool2) {
                  parama.proceed();
                }
              }
            }
            AppMethodBeat.o(146924);
            return;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            i = 0;
            continue;
            ad.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramar.getName(), paramar.getData() });
            continue;
          }
        }
        i = 0;
      }
      catch (NullPointerException parama)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramar.getName() });
        AppMethodBeat.o(146924);
        return;
      }
      continue;
      label438:
      int i = 0;
      continue;
      label443:
      boolean bool2 = true;
      continue;
      label449:
      i = 1;
    }
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(final m paramm, String paramString, int paramInt, final c.a parama)
  {
    AppMethodBeat.i(146923);
    paramString = this.iCE.a(this.iCF, paramm, paramString, new e.b()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((c.this.iCF == null) || (!c.this.iCF.isRunning()))
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
        if (TextUtils.isEmpty(paramAnonymousa.bLg)) {}
        for (paramAnonymousa = "fail:internal error";; paramAnonymousa = paramAnonymousa.bLg)
        {
          parama.HF(paramm.e(paramAnonymousa, null));
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
      parama.HF(paramm.e(paramString.bLg, null));
      AppMethodBeat.o(146923);
      return true;
    }
    AppMethodBeat.o(146923);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c
 * JD-Core Version:    0.7.0.1
 */