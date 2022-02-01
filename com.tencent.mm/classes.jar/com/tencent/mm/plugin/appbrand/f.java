package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.permission.d.2;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.plugin.appbrand.permission.d.b;
import com.tencent.mm.plugin.appbrand.permission.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
  implements f.c
{
  private final com.tencent.mm.plugin.appbrand.permission.d qri;
  private final com.tencent.mm.plugin.appbrand.b.c qrj;
  private final com.tencent.mm.plugin.appbrand.jsapi.f qrk;
  
  public f(AppBrandRuntime paramAppBrandRuntime, com.tencent.mm.plugin.appbrand.jsapi.f paramf, com.tencent.mm.plugin.appbrand.permission.d paramd)
  {
    AppMethodBeat.i(316793);
    this.qrk = ((com.tencent.mm.plugin.appbrand.jsapi.f)Objects.requireNonNull(paramf));
    this.qri = ((com.tencent.mm.plugin.appbrand.permission.d)Objects.requireNonNull(paramd));
    this.qrj = ((com.tencent.mm.plugin.appbrand.b.c)Objects.requireNonNull(paramAppBrandRuntime.qsB));
    AppMethodBeat.o(316793);
  }
  
  public final void a(bc parambc, o paramo, f.b paramb)
  {
    AppMethodBeat.i(316810);
    Object localObject;
    int i;
    for (;;)
    {
      try
      {
        localObject = this.qrj;
        if (((com.tencent.mm.plugin.appbrand.b.c)localObject).qKC.qKN.get())
        {
          paramb.ZJ("fail:interrupted");
          AppMethodBeat.o(316810);
          return;
        }
        if (!this.qrk.a(parambc.getName(), paramo))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          Log.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], envStopped", new Object[] { parambc.getName(), this.qrk.getAppId() });
          paramb.ZJ("fail:interrupted");
          AppMethodBeat.o(316810);
          return;
        }
      }
      catch (NullPointerException paramo)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", paramo, "onDispatchImpl %s", new Object[] { parambc.getName() });
        AppMethodBeat.o(316810);
        return;
      }
      i = 0;
    }
    paramo = ((com.tencent.mm.plugin.appbrand.b.c)localObject).qKC.chD();
    boolean bool2 = this.qri.a(this.qrk, parambc.getClass());
    if (b.qKy != paramo)
    {
      if (!bool2) {
        break label379;
      }
      break label367;
      localObject = (l)this.qrk.T(l.class);
      if (localObject == null) {
        break label373;
      }
      if (((l)localObject).a(parambc)) {
        break label385;
      }
      break label373;
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, state %s, hasPermission %b", new Object[] { Boolean.valueOf(bool1), parambc.getName(), paramo, Boolean.valueOf(bool2) });
        if (WeChatEnvironment.hasDebugger())
        {
          if (!parambc.getName().equals("onInitialRenderingCacheReady")) {
            break label327;
          }
          Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %d, ", new Object[] { parambc.getName(), Integer.valueOf(parambc.getData().length()) });
        }
      }
      while (!bool1)
      {
        paramb.ZJ("fail:access denied");
        AppMethodBeat.o(316810);
        return;
        label327:
        Log.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { parambc.getName(), parambc.getData() });
      }
      paramb.proceed();
      AppMethodBeat.o(316810);
      return;
      label367:
      boolean bool1 = true;
      break;
      label373:
      i = 1;
      continue;
      label379:
      bool1 = false;
      break;
      label385:
      i = 0;
    }
  }
  
  protected void a(p paramp, int paramInt1, int paramInt2) {}
  
  public void a(p paramp, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  public boolean a(final p paramp, String arg2, final String paramString2, final int paramInt, final f.b paramb)
  {
    AppMethodBeat.i(316800);
    com.tencent.mm.plugin.appbrand.permission.d locald = this.qri;
    com.tencent.mm.plugin.appbrand.jsapi.f localf = this.qrk;
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
        a.d locald = paramAnonymousa.rKn;
        if (TextUtils.isEmpty(paramAnonymousa.msg)) {}
        for (paramAnonymousa = "fail:internal error";; paramAnonymousa = paramAnonymousa.msg)
        {
          paramb.ZJ(paramp.a(paramAnonymousa, locald, null));
          AppMethodBeat.o(146922);
          return;
        }
      }
      
      public final void yS(int paramAnonymousInt)
      {
        AppMethodBeat.i(316936);
        f.this.a(paramp, paramInt, paramAnonymousInt);
        AppMethodBeat.o(316936);
      }
    };
    if ((paramp == null) || (localf == null)) {
      ??? = d.a.cGQ();
    }
    for (;;)
    {
      if (-2 == ???.ret)
      {
        AppMethodBeat.o(316800);
        return true;
        b localb = locald.qwG.qsB.qKC.chD();
        int i = locald.a(localf, paramp.getClass(), ???, paramString2, com.tencent.mm.plugin.appbrand.permission.d.aX(paramp.getClass()), true);
        String str = localf.getAppId();
        local1.yS(i);
        if (i == 6) {
          com.tencent.mm.plugin.appbrand.permission.d.l(localf, paramp.getName());
        }
        do
        {
          ??? = d.a.cGQ();
          break;
          if (i == 1)
          {
            if (((localf instanceof y)) && (localb == b.qKy) && (com.tencent.mm.compatible.loader.a.contains(com.tencent.mm.plugin.appbrand.permission.d.tEz, paramp.getName())))
            {
              ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramp.getName(), localb.name().toLowerCase(), "permission ok", "network api interrupted in suspend state" }), a.e.rVD);
              break;
            }
            ??? = d.a.cGP();
            break;
          }
          if (i == 4)
          {
            if (com.tencent.mm.plugin.appbrand.permission.a.a.fl(str, paramp.getName()))
            {
              ??? = d.a.cGP();
              break;
            }
            if (com.tencent.mm.plugin.appbrand.permission.a.a.a((k)localf, paramp.getName()))
            {
              ??? = d.a.cGP();
              break;
            }
            com.tencent.mm.plugin.appbrand.permission.a.a.a(new com.tencent.mm.plugin.appbrand.permission.a.c((g)localf, paramp.getName(), ???, paramString2, paramInt), new d.2(locald, local1));
            ??? = d.a.cGT();
            break;
          }
          if (i == 7)
          {
            if (locald.qwG.qsB.qKC.chE())
            {
              ??? = d.a.cGP();
              break;
            }
            ??? = new d.a(-1, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[] { paramp.getName(), localb.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state" }), a.e.rVD);
            break;
          }
        } while (i != 8);
      }
      synchronized (locald.tEq)
      {
        locald.tEq.addLast(local1);
        ??? = d.a.cGT();
      }
    }
    AppMethodBeat.o(316800);
    return true;
    AppMethodBeat.o(316800);
    return false;
  }
  
  public void af(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f
 * JD-Core Version:    0.7.0.1
 */