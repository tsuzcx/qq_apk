package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ag.b;
import com.tencent.mm.h.a.hf;
import com.tencent.mm.h.a.rp;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(i.f paramf, i.g paramg, boolean paramBoolean)
  {
    if ((paramg.spz.tPu & 0x2) != 0)
    {
      paramf = paramg.spz.tPw;
      if (!paramBoolean)
      {
        au.Hx();
        c.gf(paramf.stP);
      }
      paramg = b.jZ(q.Gj());
      at.dVC.iF(paramg);
      if (paramf.stM != 0)
      {
        au.Hx();
        c.FE().bX(paramf.stM + "@qqim", 3);
      }
      b.c(paramf.stM, 3);
    }
    for (;;)
    {
      o.jl(1);
      if (!paramBoolean) {
        break;
      }
      paramf = new hf();
      paramf.bPc.bPd = false;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      paramf = new rp();
      paramf.cbe.cbf = true;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      return;
      y.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    au.DS().O(new a.1(this));
  }
  
  public final void a(u.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    paramString1 = b.jZ(q.Gj());
    at.dVC.iF(paramString1);
    b.c(paramInt1, 3);
    au.Hx();
    c.FE().bX(paramb.sqm.tvf, 2);
    if (paramInt1 != 0)
    {
      au.Hx();
      c.FE().bX(paramInt1 + "@qqim", 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */