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
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements c.b
{
  private final AppBrandRuntime jyH;
  private final com.tencent.mm.plugin.appbrand.permission.d jyI;
  final com.tencent.mm.plugin.appbrand.jsapi.c jyJ;
  
  public c(AppBrandRuntime paramAppBrandRuntime, com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.permission.d paramd)
  {
    this.jyH = paramAppBrandRuntime;
    this.jyJ = paramc;
    this.jyI = paramd;
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
        if (this.jyH == null) {
          break label405;
        }
        localObject2 = this.jyH.jzQ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label405;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.appbrand.a.c)localObject2).jOf.jOp.get()) {
          break label405;
        }
        i = 1;
        if (i == 0)
        {
          parama.PL("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
        if ((!this.jyJ.isRunning()) && (!this.jyJ.aXO()))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          ae.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { paramat.getName(), this.jyJ.getAppId() });
          parama.PL("fail:interrupted");
          AppMethodBeat.o(146924);
          return;
        }
      }
      catch (NullPointerException parama)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramat.getName() });
        AppMethodBeat.o(146924);
        return;
      }
      i = 0;
    }
    localObject1 = ((com.tencent.mm.plugin.appbrand.a.c)localObject2).jOf.bbI();
    boolean bool2 = this.jyI.a(this.jyJ, paramat.getClass());
    if (com.tencent.mm.plugin.appbrand.a.b.jOc != localObject1)
    {
      if (!bool2) {
        break label425;
      }
      break label414;
      label219:
      localObject2 = (k)this.jyJ.K(k.class);
      if (localObject2 == null) {
        break label420;
      }
      if (((k)localObject2).a(paramat)) {
        break label431;
      }
      break label420;
    }
    for (;;)
    {
      if (i != 0)
      {
        ae.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), paramat.getName(), localObject1, Boolean.valueOf(bool2) });
        if (bv.fpT())
        {
          if (!paramat.getName().equals("onInitialRenderingCacheReady")) {
            break label365;
          }
          ae.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramat.getName(), Integer.valueOf(paramat.getData().length()) });
        }
      }
      while (!bool1)
      {
        parama.PL("fail:access denied");
        AppMethodBeat.o(146924);
        return;
        label365:
        ae.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramat.getName(), paramat.getData() });
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
    com.tencent.mm.plugin.appbrand.permission.d locald = this.jyI;
    com.tencent.mm.plugin.appbrand.jsapi.c localc = this.jyJ;
    d.b local1 = new d.b()
    {
      public final void a(d.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((c.this.jyJ == null) || (!c.this.jyJ.isRunning()))
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
          parama.PL(paramm.e(paramAnonymousa, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
    };
    if ((paramm == null) || (localc == null)) {
      ??? = d.a.bwQ();
    }
    while (-2 == ???.ret)
    {
      AppMethodBeat.o(146923);
      return true;
      com.tencent.mm.plugin.appbrand.a.b localb = locald.jDb.jzQ.jOf.bbI();
      int i = locald.a(localc, paramm, ???, true);
      String str = localc.getAppId();
      if (i == 6) {
        com.tencent.mm.plugin.appbrand.permission.d.k(localc, paramm.getName());
      }
      do
      {
        ??? = d.a.bwQ();
        break;
        if (i == 1)
        {
          if (((localc instanceof r)) && (localb == com.tencent.mm.plugin.appbrand.a.b.jOc) && (com.tencent.mm.compatible.loader.a.contains(com.tencent.mm.plugin.appbrand.permission.d.mmX, paramm.getName())))
          {
            ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramm.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
            break;
          }
          ??? = d.a.bwP();
          break;
        }
        if (i == 4)
        {
          if (com.tencent.mm.plugin.appbrand.permission.a.a.en(str, paramm.getName()))
          {
            ??? = d.a.bwP();
            break;
          }
          if (com.tencent.mm.plugin.appbrand.permission.a.a.a((h)localc, paramm.getName()))
          {
            ??? = d.a.bwP();
            break;
          }
          com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((d)localc, paramm.getName(), ???, paramInt), new d.1(locald, local1));
          ??? = d.a.bwT();
          break;
        }
        if (i == 7)
        {
          if (locald.jDb.jzQ.jOf.bbJ())
          {
            ??? = d.a.bwP();
            break;
          }
          ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramm.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
          break;
        }
      } while (i != 8);
      synchronized (locald.mmR)
      {
        locald.mmR.addLast(local1);
        ??? = d.a.bwT();
      }
    }
    if (???.ret != 0)
    {
      parama.PL(paramm.e(???.msg, null));
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