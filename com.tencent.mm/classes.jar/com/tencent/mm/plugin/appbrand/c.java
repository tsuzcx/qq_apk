package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.d.1;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements c.b
{
  private final AppBrandRuntime jvM;
  private final com.tencent.mm.plugin.appbrand.permission.d jvN;
  final com.tencent.mm.plugin.appbrand.jsapi.c jvO;
  
  public c(AppBrandRuntime paramAppBrandRuntime, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.permission.d paramd)
  {
    this.jvM = paramAppBrandRuntime;
    this.jvO = paramc;
    this.jvN = paramd;
  }
  
  public void S(int paramInt, String paramString) {}
  
  public final void a(at paramat, c.a parama)
  {
    AppMethodBeat.i(146924);
    Object localObject1 = null;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        if (this.jvM == null) {
          break label405;
        }
        localObject2 = this.jvM.jwS;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label405;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.appbrand.a.c)localObject2).jKT.jLd.get()) {
          break label405;
        }
        i = 1;
        if (i == 0)
        {
          parama.Pd("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
        if ((!this.jvO.isRunning()) && (!this.jvO.aXt()))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          ad.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { paramat.getName(), this.jvO.getAppId() });
          parama.Pd("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
      }
      catch (NullPointerException parama)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramat.getName() });
        AppMethodBeat.o(146924);
        return;
      }
      i = 0;
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.a.c)localObject2).jKT.bbg();
    boolean bool2 = this.jvN.a(this.jvO, paramat.getClass());
    if (com.tencent.mm.plugin.appbrand.a.b.jKQ != localObject1)
    {
      if (!bool2) {
        break label425;
      }
      break label414;
      label219:
      localObject2 = (i)this.jvO.K(i.class);
      if (localObject2 == null) {
        break label420;
      }
      if (((i)localObject2).a(paramat)) {
        break label431;
      }
      break label420;
    }
    for (;;)
    {
      if (i != 0)
      {
        ad.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), paramat.getName(), localObject1, Boolean.valueOf(bool2) });
        if (bu.flY())
        {
          if (!paramat.getName().equals("onInitialRenderingCacheReady")) {
            break label365;
          }
          ad.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramat.getName(), Integer.valueOf(paramat.getData().length()) });
        }
      }
      while (!bool1)
      {
        parama.Pd("fail:access denied");
        AppMethodBeat.o(146924);
        return;
        label365:
        ad.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramat.getName(), paramat.getData() });
      }
      parama.proceed();
      AppMethodBeat.o(146924);
      return;
      label405:
      i = 0;
      localObject2 = localObject1;
      break;
      label414:
      boolean bool1 = true;
      break label219;
      label420:
      i = 1;
      continue;
      label425:
      bool1 = false;
      break label219;
      label431:
      i = 0;
    }
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(final m paramm, String arg2, int paramInt, final c.a parama)
  {
    AppMethodBeat.i(146923);
    com.tencent.mm.plugin.appbrand.permission.d locald = this.jvN;
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.jvO;
    d.b local1 = new d.b()
    {
      public final void a(d.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((c.this.jvO == null) || (!c.this.jvO.isRunning()))
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
        if (TextUtils.isEmpty(paramAnonymousa.msg)) {}
        for (paramAnonymousa = "fail:internal error";; paramAnonymousa = paramAnonymousa.msg)
        {
          parama.Pd(paramm.e(paramAnonymousa, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
    };
    if ((paramm == null) || (localc == null)) {
      ??? = d.a.bvZ();
    }
    while (-2 == ???.ret)
    {
      AppMethodBeat.o(146923);
      return true;
      com.tencent.mm.plugin.appbrand.a.b localb = locald.jzY.jwS.jKT.bbg();
      int i = locald.a(localc, paramm, ???, true);
      String str = localc.getAppId();
      if (i == 6) {
        com.tencent.mm.plugin.appbrand.permission.d.k(localc, paramm.getName());
      }
      do
      {
        ??? = d.a.bvZ();
        break;
        if (i == 1)
        {
          if (((localc instanceof q)) && (localb == com.tencent.mm.plugin.appbrand.a.b.jKQ) && (com.tencent.mm.compatible.loader.a.contains(com.tencent.mm.plugin.appbrand.permission.d.mhZ, paramm.getName())))
          {
            ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramm.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
            break;
          }
          ??? = d.a.bvY();
          break;
        }
        if (i == 4)
        {
          if (com.tencent.mm.plugin.appbrand.permission.a.a.ek(str, paramm.getName()))
          {
            ??? = d.a.bvY();
            break;
          }
          if (com.tencent.mm.plugin.appbrand.permission.a.a.a((h)localc, paramm.getName()))
          {
            ??? = d.a.bvY();
            break;
          }
          com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((d)localc, paramm.getName(), ???, paramInt), new d.1(locald, local1));
          ??? = d.a.bwc();
          break;
        }
        if (i == 7)
        {
          if (locald.jzY.jwS.jKT.bbh())
          {
            ??? = d.a.bvY();
            break;
          }
          ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramm.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
          break;
        }
      } while (i != 8);
      synchronized (locald.mhT)
      {
        locald.mhT.addLast(local1);
        ??? = d.a.bwc();
      }
    }
    if (???.ret != 0)
    {
      parama.Pd(paramm.e(???.msg, null));
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