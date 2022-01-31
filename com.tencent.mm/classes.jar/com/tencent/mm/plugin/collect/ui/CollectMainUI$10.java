package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.b.f.a;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class CollectMainUI$10
  implements f.a
{
  CollectMainUI$10(CollectMainUI paramCollectMainUI) {}
  
  public final void a(boolean paramBoolean, mw parammw)
  {
    y.i("MicroMsg.CollectMainUI", "get from cgi: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.iLP.iLi = parammw.url;
      this.iLP.iLj = parammw.qsJ;
      CollectMainUI.a(this.iLP, parammw.nzh);
      CollectMainUI.b(this.iLP, parammw.nzi);
      CollectMainUI.a(this.iLP, parammw.nzj);
      CollectMainUI.c(this.iLP, parammw.sKw);
      CollectMainUI.a(this.iLP, parammw.sKt);
      this.iLP.aY(parammw.sKs);
      CollectMainUI.b(this.iLP, parammw.sKx);
      CollectMainUI.a(this.iLP, parammw.sKy);
      y.d("MicroMsg.CollectMainUI", "flag: %s", new Object[] { Integer.valueOf(CollectMainUI.b(this.iLP)) });
      g.DQ();
      g.DP().Dz().c(ac.a.uym, Integer.valueOf(CollectMainUI.u(this.iLP)));
      g.DQ();
      g.DP().Dz().c(ac.a.uyn, CollectMainUI.a(this.iLP));
      this.iLP.aqU();
    }
  }
  
  public final void cD(String paramString1, String paramString2)
  {
    y.i("MicroMsg.CollectMainUI", "get cache: %s, %s", new Object[] { paramString1, paramString2 });
    this.iLP.iLi = paramString1;
    this.iLP.iLj = paramString2;
    paramString1 = CollectMainUI.aFm();
    paramString2 = CollectMainUI.aFn();
    CollectMainUI.a(this.iLP, paramString1);
    this.iLP.aY(paramString2);
    if (CollectMainUI.t(this.iLP) == 1)
    {
      paramString1 = this.iLP;
      g.DQ();
      CollectMainUI.a(paramString1, ((Integer)g.DP().Dz().get(ac.a.uym, Integer.valueOf(-1))).intValue());
      paramString1 = this.iLP;
      g.DQ();
      CollectMainUI.a(paramString1, (String)g.DP().Dz().get(ac.a.uyn, ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.10
 * JD-Core Version:    0.7.0.1
 */