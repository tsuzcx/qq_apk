package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.n.a;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.permission.d.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
  implements c.b
{
  private final n fxw;
  final f fxx;
  private final com.tencent.mm.plugin.appbrand.jsapi.n fxy = new com.tencent.mm.plugin.appbrand.jsapi.n();
  
  public c(n paramn, f paramf)
  {
    this.fxw = paramn;
    this.fxx = paramf;
  }
  
  public final String a(com.tencent.mm.plugin.appbrand.jsapi.i parami, String paramString, int paramInt, c.a parama)
  {
    com.tencent.mm.plugin.appbrand.jsapi.n localn = this.fxy;
    f localf = this.fxx;
    Object localObject = this.fxw.aad();
    if ((localObject == null) || (((com.tencent.mm.plugin.appbrand.page.n)localObject).getCurrentPage() == null)) {}
    for (localObject = "";; localObject = ((com.tencent.mm.plugin.appbrand.page.n)localObject).getCurrentPage().getCurrentUrl())
    {
      if (!com.tencent.mm.plugin.appbrand.report.model.i.we(parami.getName())) {
        localn.gfk.put(Integer.valueOf(paramInt), new n.a(localf, parami, paramString, System.currentTimeMillis(), (String)localObject));
      }
      paramString = this.fxw.fzB.a(this.fxx, parami, paramString, new c.1(this, parama, paramInt, parami));
      if (-2 != paramString.ret) {
        break;
      }
      return "";
    }
    if (paramString.ret != 0) {
      return parami.h(paramString.bHk, null);
    }
    return null;
  }
  
  public final void a(ac paramac, c.a parama)
  {
    Object localObject1;
    if (this.fxw != null)
    {
      localObject2 = this.fxw.fyy;
      localObject1 = localObject2;
      if (localObject2 == null) {
        break label39;
      }
      i = 1;
      localObject1 = localObject2;
      if (i != 0) {
        break label44;
      }
    }
    label39:
    label44:
    while (localObject1.fFN.fFV.get())
    {
      return;
      localObject1 = null;
      i = 0;
      break;
    }
    Object localObject2 = this.fxw.fzB;
    boolean bool1;
    label84:
    boolean bool3;
    boolean bool2;
    if (localObject1.fFN.acz() == com.tencent.mm.plugin.appbrand.b.b.fFK)
    {
      bool1 = true;
      bool3 = ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).a(this.fxx, paramac);
      if ((!bool1) && (!bool3)) {
        break label208;
      }
      bool2 = true;
      label109:
      if (a.a(t.gfr, paramac.getClass())) {
        break label214;
      }
    }
    label208:
    label214:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = ((com.tencent.mm.plugin.appbrand.permission.d)localObject2).a(this.fxx, paramac, null, false);
        y.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", new Object[] { Boolean.valueOf(bool2), paramac.getName(), Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      }
      if (!bool2) {
        break;
      }
      parama.proceed();
      return;
      bool1 = false;
      break label84;
      bool2 = false;
      break label109;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.i parami, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (((com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) || (com.tencent.mm.protocal.d.spe) || (com.tencent.mm.protocal.d.spd)) && ("fail:internal error invalid js component".equals(paramString))) {
        throw new ClassCastException(String.format("Mismatch api(%s) component", new Object[] { parami.getName() }));
      }
      this.fxy.F(paramInt, paramString);
    }
  }
  
  public final void x(int paramInt, String paramString)
  {
    this.fxy.F(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.c
 * JD-Core Version:    0.7.0.1
 */