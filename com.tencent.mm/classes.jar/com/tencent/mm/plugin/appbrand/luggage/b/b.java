package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfigResUpdateListener;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import junit.framework.Assert;
import kotlin.ah;
import kotlin.g.b.s;

@Deprecated
public final class b
  implements com.tencent.luggage.sdk.customize.a
{
  public final g aqR()
  {
    AppMethodBeat.i(47479);
    g localg = n.aqR();
    AppMethodBeat.o(47479);
    return localg;
  }
  
  public final e aqS()
  {
    AppMethodBeat.i(47481);
    e locale = n.aqS();
    AppMethodBeat.o(47481);
    return locale;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.b.b aqT()
  {
    AppMethodBeat.i(319886);
    com.tencent.mm.plugin.appbrand.appstorage.b.b localb = (com.tencent.mm.plugin.appbrand.appstorage.b.b)n.ag(com.tencent.mm.plugin.appbrand.appstorage.b.b.class);
    AppMethodBeat.o(319886);
    return localb;
  }
  
  public final void aqU()
  {
    AppMethodBeat.i(47482);
    AppBrandGlobalSystemConfigResUpdateListener.ckE();
    AppMethodBeat.o(47482);
  }
  
  public final v f(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(319870);
    switch (paramInt)
    {
    case 3: 
    default: 
      paramString1 = l.jA(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue());
      AppMethodBeat.o(319870);
      return paramString1;
    case 4: 
      Object localObject = l.qMo;
      localObject = l.a.jA(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue());
      paramString1 = com.tencent.mm.plugin.appbrand.appstorage.c.a(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue(), paramString1, paramString2, (l)localObject);
      AppMethodBeat.o(319870);
      return paramString1;
    case 5: 
      paramString1 = com.tencent.mm.plugin.appbrand.appstorage.c.a(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue(), paramString1, paramString2, null);
      AppMethodBeat.o(319870);
      return paramString1;
    }
    paramString1 = l.jA(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString1)).longValue());
    AppMethodBeat.o(319870);
    return paramString1;
  }
  
  public final void fn(String paramString)
  {
    AppMethodBeat.i(319877);
    n.aqR().VW(paramString);
    l.jA(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString)).longValue()).VW(paramString);
    Object localObject = com.tencent.mm.plugin.appbrand.appstorage.c.qLN;
    long l = new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a)h.ax(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).WE(paramString)).longValue();
    s.u(paramString, "appId");
    new com.tencent.mm.plugin.appbrand.appstorage.c(l, paramString, "", null, (byte)0).chU();
    localObject = aqT();
    if (localObject != null)
    {
      s.u(paramString, "appId");
      Assert.assertTrue(MMApplicationContext.isMainProcess());
      com.tencent.mm.plugin.appbrand.appstorage.b.c localc = new com.tencent.mm.plugin.appbrand.appstorage.b.c();
      localc.field_appId = paramString;
      paramString = ah.aiuX;
      ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject).delete((IAutoDBItem)localc, new String[] { "appId" });
    }
    AppMethodBeat.o(319877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */