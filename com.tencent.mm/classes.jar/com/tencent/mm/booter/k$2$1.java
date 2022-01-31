package com.tencent.mm.booter;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.dp;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.apw;
import com.tencent.mm.protocal.c.aqb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class k$2$1
  implements f
{
  k$2$1(k.2 param2, com.tencent.mm.modelmulti.c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (acf)this.dij.esv.ecF.ecN;
      if (paramm.result == 0)
      {
        paramString = paramm.tbg;
        paramm = paramm.tbi;
        String str = paramString.title + "," + paramString.desc + "," + paramString.tlU + "," + paramString.tlV + "," + paramm.dCX + "," + paramm.major + "," + paramm.minor;
        au.Hx();
        String[] arrayOfString = bk.aM((String)com.tencent.mm.model.c.Dz().get(ac.a.urb, null), "").split(",");
        paramString = Boolean.valueOf(false);
        paramInt2 = arrayOfString.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          if (arrayOfString[paramInt1].equals(paramm.dCX + paramm.major + paramm.minor)) {
            paramString = Boolean.valueOf(true);
          }
          paramInt1 += 1;
        }
        if (!paramString.booleanValue())
        {
          h.nFQ.f(12653, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
          h.nFQ.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.ura, str);
        }
      }
    }
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.CY();
      paramString = new dp();
      a.udP.m(paramString);
      k.b(Boolean.valueOf(false));
      au.Dk().b(1708, this);
      return;
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
      continue;
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
      continue;
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.ura, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.k.2.1
 * JD-Core Version:    0.7.0.1
 */