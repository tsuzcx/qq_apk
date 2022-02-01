package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.g.a.pg.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.sdk.b.c<pg>
  implements g
{
  private pg iYC;
  private com.tencent.mm.api.c iYD;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = pg.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    ac.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.iYC.dsa.errCode = paramInt;
    if (paramInt != 0) {
      this.iYC.dsa.dsb = false;
    }
    for (;;)
    {
      if (this.iYC.callback != null) {
        this.iYC.callback.run();
      }
      az.agi().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        f.k(this.iYD);
        this.iYC.dsa.dsb = false;
      }
      else
      {
        f.j(this.iYD);
        this.iYC.dsa.dsb = true;
        com.tencent.mm.plugin.address.a.a.aRF();
        Object localObject = com.tencent.mm.plugin.address.a.a.aRH().iYG;
        if (((com.tencent.mm.plugin.address.d.a)localObject).iYP.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).iYP.getFirst();
          this.iYC.dsa.dsc = ((b)localObject).iYY;
          this.iYC.dsa.userName = ((b)localObject).iYW;
          this.iYC.dsa.dsd = ((b)localObject).iYX;
          this.iYC.dsa.dse = ((b)localObject).iYU;
          this.iYC.dsa.dsf = ((b)localObject).iYR;
          this.iYC.dsa.dsg = ((b)localObject).iYS;
          this.iYC.dsa.dsh = ((b)localObject).iYT;
          this.iYC.dsa.dsi = ((b)localObject).iYV;
        }
      }
    }
  }
  
  private boolean a(pg parampg)
  {
    AppMethodBeat.i(20793);
    if ((parampg instanceof pg))
    {
      this.iYC = parampg;
      az.agi().a(417, this);
      parampg = new e(this.iYC.drZ.url, this.iYC.drZ.appId, 1);
      az.agi().a(parampg, 0);
    }
    AppMethodBeat.o(20793);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20794);
    ac.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof e))
    {
      if (paramInt2 == 0)
      {
        G(paramInt2, true);
        AppMethodBeat.o(20794);
        return;
      }
      G(paramInt2, false);
    }
    AppMethodBeat.o(20794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */