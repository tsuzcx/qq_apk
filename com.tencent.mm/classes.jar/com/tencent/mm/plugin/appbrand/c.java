package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.permission.d.1;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements f.b
{
  private final AppBrandRuntime kzp;
  private final com.tencent.mm.plugin.appbrand.permission.d kzq;
  final f kzr;
  
  public c(AppBrandRuntime paramAppBrandRuntime, f paramf, com.tencent.mm.plugin.appbrand.permission.d paramd)
  {
    this.kzp = paramAppBrandRuntime;
    this.kzr = paramf;
    this.kzq = paramd;
  }
  
  public void V(int paramInt, String paramString) {}
  
  public final void a(bc parambc, f.a parama)
  {
    AppMethodBeat.i(146924);
    Object localObject1 = null;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        if (this.kzp == null) {
          break label405;
        }
        localObject2 = this.kzp.kAH;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label405;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.appbrand.a.c)localObject2).kQM.kQW.get()) {
          break label405;
        }
        i = 1;
        if (i == 0)
        {
          parama.Zb("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
        if ((!this.kzr.isRunning()) && (!this.kzr.bsV()))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { parambc.getName(), this.kzr.getAppId() });
          parama.Zb("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
      }
      catch (NullPointerException parama)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { parambc.getName() });
        AppMethodBeat.o(146924);
        return;
      }
      i = 0;
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.a.c)localObject2).kQM.bwY();
    boolean bool2 = this.kzq.a(this.kzr, parambc.getClass());
    if (b.kQJ != localObject1)
    {
      if (!bool2) {
        break label425;
      }
      break label414;
      label219:
      localObject2 = (com.tencent.mm.plugin.appbrand.permission.k)this.kzr.M(com.tencent.mm.plugin.appbrand.permission.k.class);
      if (localObject2 == null) {
        break label420;
      }
      if (((com.tencent.mm.plugin.appbrand.permission.k)localObject2).a(parambc)) {
        break label431;
      }
      break label420;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), parambc.getName(), localObject1, Boolean.valueOf(bool2) });
        if (WeChatEnvironment.hasDebugger())
        {
          if (!parambc.getName().equals("onInitialRenderingCacheReady")) {
            break label365;
          }
          Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { parambc.getName(), Integer.valueOf(parambc.getData().length()) });
        }
      }
      while (!bool1)
      {
        parama.Zb("fail:access denied");
        AppMethodBeat.o(146924);
        return;
        label365:
        Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { parambc.getName(), parambc.getData() });
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
  
  public void a(p paramp, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(final p paramp, String arg2, int paramInt, final f.a parama)
  {
    AppMethodBeat.i(146923);
    com.tencent.mm.plugin.appbrand.permission.d locald = this.kzq;
    f localf = this.kzr;
    d.b local1 = new d.b()
    {
      public final void a(d.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((c.this.kzr == null) || (!c.this.kzr.isRunning()))
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
          parama.Zb(paramp.h(paramAnonymousa, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
    };
    if ((paramp == null) || (localf == null)) {
      ??? = d.a.bSZ();
    }
    while (-2 == ???.ret)
    {
      AppMethodBeat.o(146923);
      return true;
      b localb = locald.kEc.kAH.kQM.bwY();
      int i = locald.a(localf, paramp, ???, true);
      String str = localf.getAppId();
      if (i == 6) {
        com.tencent.mm.plugin.appbrand.permission.d.l(localf, paramp.getName());
      }
      do
      {
        ??? = d.a.bSZ();
        break;
        if (i == 1)
        {
          if (((localf instanceof s)) && (localb == b.kQJ) && (com.tencent.mm.compatible.loader.a.contains(com.tencent.mm.plugin.appbrand.permission.d.nxx, paramp.getName())))
          {
            ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramp.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
            break;
          }
          ??? = d.a.bSY();
          break;
        }
        if (i == 4)
        {
          if (com.tencent.mm.plugin.appbrand.permission.a.a.eG(str, paramp.getName()))
          {
            ??? = d.a.bSY();
            break;
          }
          if (com.tencent.mm.plugin.appbrand.permission.a.a.a((com.tencent.mm.plugin.appbrand.jsapi.k)localf, paramp.getName()))
          {
            ??? = d.a.bSY();
            break;
          }
          com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((d)localf, paramp.getName(), ???, paramInt), new d.1(locald, local1));
          ??? = d.a.bTc();
          break;
        }
        if (i == 7)
        {
          if (locald.kEc.kAH.kQM.bwZ())
          {
            ??? = d.a.bSY();
            break;
          }
          ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramp.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
          break;
        }
      } while (i != 8);
      synchronized (locald.nxr)
      {
        locald.nxr.addLast(local1);
        ??? = d.a.bTc();
      }
    }
    if (???.ret != 0)
    {
      parama.Zb(paramp.h(???.msg, null));
      AppMethodBeat.o(146923);
      return true;
    }
    AppMethodBeat.o(146923);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c
 * JD-Core Version:    0.7.0.1
 */