package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.permission.e.a;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements c.b
{
  private final i gOM;
  private final e gON;
  final com.tencent.mm.plugin.appbrand.jsapi.c gOO;
  
  public c(i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc, e parame)
  {
    this.gOM = parami;
    this.gOO = paramc;
    this.gON = parame;
  }
  
  public void G(int paramInt, String paramString) {}
  
  public final void a(ai paramai, c.a parama)
  {
    AppMethodBeat.i(101711);
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (this.gOM != null)
        {
          Object localObject2 = this.gOM.gPL;
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            i = 1;
            localObject1 = localObject2;
            if (i != 0)
            {
              bool1 = ((com.tencent.mm.plugin.appbrand.b.c)localObject1).gYj.bIO.get();
              if (!bool1)
              {
                if (this.gOO.isRunning()) {
                  break label380;
                }
                i = 1;
                if (i != 0)
                {
                  ab.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], runtimeStopped[%b], envStopped[%b]", new Object[] { paramai.getName(), this.gOO.getAppId(), Boolean.valueOf(bool1), Boolean.TRUE });
                  AppMethodBeat.o(101711);
                  return;
                }
                localObject2 = this.gON;
                if (((com.tencent.mm.plugin.appbrand.b.c)localObject1).gYj.awr() != b.gYg) {
                  continue;
                }
                bool1 = true;
                boolean bool3 = ((e)localObject2).a(this.gOO, paramai);
                if (bool1) {
                  break label385;
                }
                if (!bool3) {
                  continue;
                }
                break label385;
                localObject1 = (g)this.gOO.q(g.class);
                if (localObject1 == null) {
                  break label391;
                }
                if (((g)localObject1).a(paramai)) {
                  continue;
                }
                break label391;
                if (i != 0)
                {
                  int j = ((e)localObject2).a(this.gOO, paramai, null, false);
                  ab.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[] { Boolean.valueOf(bool2), paramai.getName(), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
                  if ((i != 0) && (bp.dud())) {
                    ab.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", new Object[] { paramai.getName(), paramai.getData() });
                  }
                }
                if (bool2) {
                  parama.proceed();
                }
              }
            }
            AppMethodBeat.o(101711);
            return;
            boolean bool1 = false;
            continue;
            bool2 = false;
            continue;
            i = 0;
            continue;
          }
        }
        i = 0;
      }
      catch (NullPointerException parama)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", parama, "onDispatchImpl %s", new Object[] { paramai.getName() });
        AppMethodBeat.o(101711);
        return;
      }
      continue;
      label380:
      int i = 0;
      continue;
      label385:
      boolean bool2 = true;
      continue;
      label391:
      i = 1;
    }
  }
  
  public void a(m paramm, String paramString1, int paramInt, String paramString2) {}
  
  public boolean a(m paramm, String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(101710);
    paramString = this.gON.a(this.gOO, paramm, paramString, new c.1(this, parama, paramm));
    if (-2 == paramString.ret)
    {
      AppMethodBeat.o(101710);
      return true;
    }
    if (paramString.ret != 0)
    {
      parama.BI(paramm.j(paramString.bjm, null));
      AppMethodBeat.o(101710);
      return true;
    }
    AppMethodBeat.o(101710);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c
 * JD-Core Version:    0.7.0.1
 */