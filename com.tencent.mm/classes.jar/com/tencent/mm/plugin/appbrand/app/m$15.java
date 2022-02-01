package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appusage.a.g;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;

final class m$15
  implements b
{
  m$15(m paramm)
  {
    AppMethodBeat.i(160578);
    AppMethodBeat.o(160578);
  }
  
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(250031);
    if ((parami != null) && ((parami instanceof j.g)))
    {
      j.bJf().bJg();
      aw.hs(true);
    }
    if ((paramBoolean) && ((paramh instanceof j.a)) && (paramh.getSceneStatus() == 12)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        aw.hs(true);
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
        g.hy(true);
      }
      AppMethodBeat.o(250031);
      return;
    }
  }
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m.15
 * JD-Core Version:    0.7.0.1
 */