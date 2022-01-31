package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.a.nk.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k
  extends c<nk>
  implements com.tencent.mm.ai.f
{
  private nk gKQ;
  private d gKR;
  
  public k()
  {
    AppMethodBeat.i(16751);
    this.__eventId = nk.class.getName().hashCode();
    AppMethodBeat.o(16751);
  }
  
  private void F(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(16754);
    ab.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.gKQ.cDN.errCode = paramInt;
    if (paramInt != 0) {
      this.gKQ.cDN.cDO = false;
    }
    for (;;)
    {
      if (this.gKQ.callback != null) {
        this.gKQ.callback.run();
      }
      aw.Rc().b(417, this);
      AppMethodBeat.o(16754);
      return;
      if (!paramBoolean)
      {
        com.tencent.mm.aj.f.i(this.gKR);
        this.gKQ.cDN.cDO = false;
      }
      else
      {
        com.tencent.mm.aj.f.h(this.gKR);
        this.gKQ.cDN.cDO = true;
        com.tencent.mm.plugin.address.a.a.asl();
        Object localObject = com.tencent.mm.plugin.address.a.a.asn().gKU;
        if (((com.tencent.mm.plugin.address.d.a)localObject).gLc.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).gLc.getFirst();
          this.gKQ.cDN.cDP = ((b)localObject).gLl;
          this.gKQ.cDN.userName = ((b)localObject).gLj;
          this.gKQ.cDN.cDQ = ((b)localObject).gLk;
          this.gKQ.cDN.cDR = ((b)localObject).gLh;
          this.gKQ.cDN.cDS = ((b)localObject).gLe;
          this.gKQ.cDN.cDT = ((b)localObject).gLf;
          this.gKQ.cDN.cDU = ((b)localObject).gLg;
          this.gKQ.cDN.cDV = ((b)localObject).gLi;
        }
      }
    }
  }
  
  private boolean a(nk paramnk)
  {
    AppMethodBeat.i(16752);
    if ((paramnk instanceof nk))
    {
      this.gKQ = paramnk;
      aw.Rc().a(417, this);
      paramnk = new e(this.gKQ.cDM.url, this.gKQ.cDM.appId, 1);
      aw.Rc().a(paramnk, 0);
    }
    AppMethodBeat.o(16752);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(16753);
    ab.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramm instanceof e))
    {
      if (paramInt2 == 0)
      {
        F(paramInt2, true);
        AppMethodBeat.o(16753);
        return;
      }
      F(paramInt2, false);
    }
    AppMethodBeat.o(16753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */