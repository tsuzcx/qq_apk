package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.g;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.pr.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.sdk.b.c<pr>
  implements f
{
  private pr juE;
  private com.tencent.mm.api.c juF;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = pr.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    ae.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.juE.dEZ.errCode = paramInt;
    if (paramInt != 0) {
      this.juE.dEZ.dFa = false;
    }
    for (;;)
    {
      if (this.juE.callback != null) {
        this.juE.callback.run();
      }
      bc.ajj().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        g.k(this.juF);
        this.juE.dEZ.dFa = false;
      }
      else
      {
        g.j(this.juF);
        this.juE.dEZ.dFa = true;
        com.tencent.mm.plugin.address.a.a.aVq();
        Object localObject = com.tencent.mm.plugin.address.a.a.aVs().juI;
        if (((com.tencent.mm.plugin.address.d.a)localObject).juR.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).juR.getFirst();
          this.juE.dEZ.dFb = ((b)localObject).jva;
          this.juE.dEZ.userName = ((b)localObject).juY;
          this.juE.dEZ.dFc = ((b)localObject).juZ;
          this.juE.dEZ.dFd = ((b)localObject).juW;
          this.juE.dEZ.dFe = ((b)localObject).juT;
          this.juE.dEZ.dFf = ((b)localObject).juU;
          this.juE.dEZ.dFg = ((b)localObject).juV;
          this.juE.dEZ.dFh = ((b)localObject).juX;
        }
      }
    }
  }
  
  private boolean a(pr parampr)
  {
    AppMethodBeat.i(20793);
    if ((parampr instanceof pr))
    {
      this.juE = parampr;
      bc.ajj().a(417, this);
      parampr = new e(this.juE.dEY.url, this.juE.dEY.appId, 1);
      bc.ajj().a(parampr, 0);
    }
    AppMethodBeat.o(20793);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20794);
    ae.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */