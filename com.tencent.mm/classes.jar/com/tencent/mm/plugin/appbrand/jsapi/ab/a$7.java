package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;
import java.util.Iterator;

final class a$7
  implements e.b
{
  a$7(a parama) {}
  
  public final void C(ArrayList<IDKey> paramArrayList)
  {
    AppMethodBeat.i(188538);
    g.yhR.b(paramArrayList, false);
    try
    {
      o localo = a.b(this.lvn).getRuntime();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        IDKey localIDKey = (IDKey)paramArrayList.next();
        long l1 = localIDKey.GetID();
        long l2 = localIDKey.GetKey();
        h.a(this.lvn.getAppId(), localo.aXc().aDD, localo.jwG.dPf, l1, l2, 1L);
      }
      AppMethodBeat.o(188538);
    }
    catch (NullPointerException paramArrayList)
    {
      AppMethodBeat.o(188538);
      return;
    }
  }
  
  public final void tH(int paramInt)
  {
    AppMethodBeat.i(188537);
    g.yhR.dD(1097, paramInt);
    try
    {
      o localo = a.b(this.lvn).getRuntime();
      h.b(this.lvn.getAppId(), localo.aXc().aDD, localo.jwG.dPf, 1097, paramInt);
      AppMethodBeat.o(188537);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(188537);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a.7
 * JD-Core Version:    0.7.0.1
 */