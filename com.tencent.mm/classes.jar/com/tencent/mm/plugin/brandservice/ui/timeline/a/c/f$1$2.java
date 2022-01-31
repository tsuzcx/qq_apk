package com.tencent.mm.plugin.brandservice.ui.timeline.a.c;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class f$1$2
  implements a<String, Void>
{
  f$1$2(f.1 param1, boolean paramBoolean, String paramString, Map paramMap) {}
  
  private String ayB()
  {
    if (!this.iiO)
    {
      y.i("MicroMsg.Preload.TmplDownloader", "not do getA8Key, return");
      return this.val$downloadUrl;
    }
    Object localObject = com.tencent.mm.vending.g.f.cLc();
    final h localh = new h(this.val$downloadUrl, "", 0, 8, (int)System.currentTimeMillis(), new byte[0]);
    localObject = new com.tencent.mm.ah.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        g.Dk().b(233, this);
        y.i("MicroMsg.Preload.TmplDownloader", "[processTmplInfo]errType:%d, errCode:%dm errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          paramAnonymousString = localh.Qf();
          paramAnonymousm = localh.Qm();
          if (!bk.dk(paramAnonymousm))
          {
            paramAnonymousm = paramAnonymousm.iterator();
            while (paramAnonymousm.hasNext())
            {
              apm localapm = (apm)paramAnonymousm.next();
              if ((!bk.bl(localapm.sCH)) && (!bk.bl(localapm.nFs))) {
                f.1.2.this.iiM.put(localapm.sCH, localapm.nFs);
              }
            }
          }
          this.dYC.x(new Object[] { paramAnonymousString });
          return;
        }
        this.dYC.x(new Object[] { "" });
      }
    };
    g.Dk().a(233, (com.tencent.mm.ah.f)localObject);
    g.Dk().a(localh, 0);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c.f.1.2
 * JD-Core Version:    0.7.0.1
 */