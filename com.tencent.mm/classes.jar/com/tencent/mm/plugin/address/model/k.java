package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.g;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.g.a.pq.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.sdk.b.c<pq>
  implements f
{
  private pq jrL;
  private com.tencent.mm.api.c jrM;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = pq.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    ad.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.jrL.dDU.errCode = paramInt;
    if (paramInt != 0) {
      this.jrL.dDU.dDV = false;
    }
    for (;;)
    {
      if (this.jrL.callback != null) {
        this.jrL.callback.run();
      }
      ba.aiU().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        g.k(this.jrM);
        this.jrL.dDU.dDV = false;
      }
      else
      {
        g.j(this.jrM);
        this.jrL.dDU.dDV = true;
        com.tencent.mm.plugin.address.a.a.aUR();
        Object localObject = com.tencent.mm.plugin.address.a.a.aUT().jrP;
        if (((com.tencent.mm.plugin.address.d.a)localObject).jrY.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).jrY.getFirst();
          this.jrL.dDU.dDW = ((b)localObject).jsh;
          this.jrL.dDU.userName = ((b)localObject).jsf;
          this.jrL.dDU.dDX = ((b)localObject).jsg;
          this.jrL.dDU.dDY = ((b)localObject).jsd;
          this.jrL.dDU.dDZ = ((b)localObject).jsa;
          this.jrL.dDU.dEa = ((b)localObject).jsb;
          this.jrL.dDU.dEb = ((b)localObject).jsc;
          this.jrL.dDU.dEc = ((b)localObject).jse;
        }
      }
    }
  }
  
  private boolean a(pq parampq)
  {
    AppMethodBeat.i(20793);
    if ((parampq instanceof pq))
    {
      this.jrL = parampq;
      ba.aiU().a(417, this);
      parampq = new e(this.jrL.dDT.url, this.jrL.dDT.appId, 1);
      ba.aiU().a(parampq, 0);
    }
    AppMethodBeat.o(20793);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20794);
    ad.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */