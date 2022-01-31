package com.tencent.mm.plugin.collect.b;

import android.app.Dialog;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ox;
import com.tencent.mm.h.a.ox.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.wallet_core.c.n;

final class u$1
  implements f
{
  u$1(u paramu, ox paramox) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((this.iHS.eXA != null) && (this.iHS.eXA.isShowing()))
    {
      this.iHS.eXA.dismiss();
      this.iHS.eXA = null;
    }
    g.Dk().b(1800, this);
    paramString = (k)paramm;
    paramString.a(new u.1.3(this)).b(new u.1.2(this, paramString)).c(new u.1.1(this));
    this.iHR.bYx.bFJ.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.u.1
 * JD-Core Version:    0.7.0.1
 */