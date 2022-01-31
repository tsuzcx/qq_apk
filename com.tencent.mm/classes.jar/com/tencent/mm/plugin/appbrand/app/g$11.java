package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.j.1;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.v.b;
import com.tencent.mm.sdk.platformtools.al;

final class g$11
  implements a
{
  g$11(g paramg) {}
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(129251);
    if ((parami != null) && ((parami instanceof j.g)))
    {
      parami = j.axa();
      m.aNS().ac(new j.1(parami));
      aj.dJ(true);
    }
    if ((paramBoolean) && ((paramh instanceof j.a)) && (paramh.getSceneStatus() == 12)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aj.dJ(true);
      }
      if ((!(paramh instanceof j.f)) || (paramh.getSceneStatus() != 1))
      {
        i = j;
        if ((paramh instanceof j.a))
        {
          i = j;
          if (paramh.getSceneStatus() != 12) {}
        }
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        com.tencent.mm.plugin.appbrand.appusage.a.g.dN(true);
      }
      AppMethodBeat.o(129251);
      return;
    }
  }
  
  public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.11
 * JD-Core Version:    0.7.0.1
 */