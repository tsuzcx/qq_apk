package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.permission.d.1;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  implements e.c
{
  private final AppBrandRuntime nsB;
  private final com.tencent.mm.plugin.appbrand.permission.d nsC;
  private final e nsD;
  
  public f(AppBrandRuntime paramAppBrandRuntime, e parame, com.tencent.mm.plugin.appbrand.permission.d paramd)
  {
    this.nsB = paramAppBrandRuntime;
    this.nsD = parame;
    this.nsC = paramd;
  }
  
  public void X(int paramInt, String paramString) {}
  
  public final void a(az paramaz, com.tencent.mm.plugin.appbrand.m.o paramo, e.b paramb)
  {
    AppMethodBeat.i(245795);
    Object localObject1 = null;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        if (this.nsB == null) {
          break label401;
        }
        localObject2 = this.nsB.ntR;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label401;
        }
        localObject1 = localObject2;
        if (((com.tencent.mm.plugin.appbrand.a.c)localObject2).nKU.nLe.get()) {
          break label401;
        }
        i = 1;
        if (i == 0)
        {
          paramb.agN("fail:interrupted");
          AppMethodBeat.o(245795);
          return;
        }
        if (!this.nsD.a(paramaz.getName(), paramo))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { paramaz.getName(), this.nsD.getAppId() });
          paramb.agN("fail:interrupted");
          AppMethodBeat.o(245795);
          return;
        }
      }
      catch (NullPointerException paramo)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", paramo, "onDispatchImpl %s", new Object[] { paramaz.getName() });
        AppMethodBeat.o(245795);
        return;
      }
      i = 0;
    }
    paramo = ((com.tencent.mm.plugin.appbrand.a.c)localObject2).nKU.bIg();
    boolean bool2 = this.nsC.a(this.nsD, paramaz.getClass());
    if (b.nKR != paramo)
    {
      if (!bool2) {
        break label423;
      }
      break label411;
      label215:
      localObject1 = (k)this.nsD.K(k.class);
      if (localObject1 == null) {
        break label417;
      }
      if (((k)localObject1).a(paramaz)) {
        break label429;
      }
      break label417;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), paramaz.getName(), paramo, Boolean.valueOf(bool2) });
        if (WeChatEnvironment.hasDebugger())
        {
          if (!paramaz.getName().equals("onInitialRenderingCacheReady")) {
            break label361;
          }
          Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { paramaz.getName(), Integer.valueOf(paramaz.getData().length()) });
        }
      }
      while (!bool1)
      {
        paramb.agN("fail:access denied");
        AppMethodBeat.o(245795);
        return;
        label361:
        Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramaz.getName(), paramaz.getData() });
      }
      paramb.proceed();
      AppMethodBeat.o(245795);
      return;
      label401:
      i = 0;
      localObject2 = localObject1;
      break;
      label411:
      boolean bool1 = true;
      break label215;
      label417:
      i = 1;
      continue;
      label423:
      bool1 = false;
      break label215;
      label429:
      i = 0;
    }
  }
  
  public void a(com.tencent.mm.plugin.appbrand.jsapi.o paramo, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(final com.tencent.mm.plugin.appbrand.jsapi.o paramo, String arg2, int paramInt, final e.b paramb)
  {
    AppMethodBeat.i(146923);
    com.tencent.mm.plugin.appbrand.permission.d locald = this.nsC;
    e locale = this.nsD;
    d.b local1 = new d.b()
    {
      public final void a(d.a paramAnonymousa)
      {
        AppMethodBeat.i(146922);
        if ((f.a(f.this) == null) || (!f.a(f.this).isRunning()))
        {
          AppMethodBeat.o(146922);
          return;
        }
        if (paramAnonymousa.ret == 0)
        {
          paramb.proceed();
          AppMethodBeat.o(146922);
          return;
        }
        if (TextUtils.isEmpty(paramAnonymousa.msg)) {}
        for (paramAnonymousa = "fail:internal error";; paramAnonymousa = paramAnonymousa.msg)
        {
          paramb.agN(paramo.h(paramAnonymousa, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
    };
    if ((paramo == null) || (locale == null)) {
      ??? = d.a.cgc();
    }
    for (;;)
    {
      if (-2 == ???.ret)
      {
        AppMethodBeat.o(146923);
        return true;
        b localb = locald.nxs.ntR.nKU.bIg();
        int i = locald.a(locale, paramo, ???, true);
        String str = locale.getAppId();
        if (i == 6) {
          com.tencent.mm.plugin.appbrand.permission.d.m(locale, paramo.getName());
        }
        do
        {
          ??? = d.a.cgc();
          break;
          if (i == 1)
          {
            if (((locale instanceof v)) && (localb == b.nKR) && (com.tencent.mm.compatible.loader.a.contains(com.tencent.mm.plugin.appbrand.permission.d.qzB, paramo.getName())))
            {
              ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramo.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }));
              break;
            }
            ??? = d.a.cgb();
            break;
          }
          if (i == 4)
          {
            if (com.tencent.mm.plugin.appbrand.permission.a.a.eU(str, paramo.getName()))
            {
              ??? = d.a.cgb();
              break;
            }
            if (com.tencent.mm.plugin.appbrand.permission.a.a.a((j)locale, paramo.getName()))
            {
              ??? = d.a.cgb();
              break;
            }
            com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((g)locale, paramo.getName(), ???, paramInt), new d.1(locald, local1));
            ??? = d.a.cgf();
            break;
          }
          if (i == 7)
          {
            if (locald.nxs.ntR.nKU.bIh())
            {
              ??? = d.a.cgb();
              break;
            }
            ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramo.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }));
            break;
          }
        } while (i != 8);
      }
      synchronized (locald.qzt)
      {
        locald.qzt.addLast(local1);
        ??? = d.a.cgf();
      }
    }
    AppMethodBeat.o(146923);
    return true;
    AppMethodBeat.o(146923);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f
 * JD-Core Version:    0.7.0.1
 */