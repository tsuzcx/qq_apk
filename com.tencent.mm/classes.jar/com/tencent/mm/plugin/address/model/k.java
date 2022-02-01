package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c;
import com.tencent.mm.f.a.rj;
import com.tencent.mm.f.a.rj.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends IListener<rj>
  implements i
{
  private rj nkA;
  private c nkB;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = rj.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    Log.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.nkA.fQx.errCode = paramInt;
    if (paramInt != 0) {
      this.nkA.fQx.fQy = false;
    }
    for (;;)
    {
      if (this.nkA.callback != null) {
        this.nkA.callback.run();
      }
      bh.aGY().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        g.l(this.nkB);
        this.nkA.fQx.fQy = false;
      }
      else
      {
        g.k(this.nkB);
        this.nkA.fQx.fQy = true;
        com.tencent.mm.plugin.address.a.a.bAn();
        Object localObject = com.tencent.mm.plugin.address.a.a.bAp().nkJ;
        if (((com.tencent.mm.plugin.address.d.a)localObject).nkS.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).nkS.getFirst();
          this.nkA.fQx.fQz = ((b)localObject).nlb;
          this.nkA.fQx.userName = ((b)localObject).nkZ;
          this.nkA.fQx.fQA = ((b)localObject).nla;
          this.nkA.fQx.fQB = ((b)localObject).nkX;
          this.nkA.fQx.fQC = ((b)localObject).nkU;
          this.nkA.fQx.fQD = ((b)localObject).nkV;
          this.nkA.fQx.fQE = ((b)localObject).nkW;
          this.nkA.fQx.fQF = ((b)localObject).nkY;
        }
      }
    }
  }
  
  private boolean a(rj paramrj)
  {
    AppMethodBeat.i(20793);
    if ((paramrj instanceof rj))
    {
      this.nkA = paramrj;
      bh.aGY().a(417, this);
      paramrj = new e(this.nkA.fQw.url, this.nkA.fQw.appId, 1);
      bh.aGY().a(paramrj, 0);
    }
    AppMethodBeat.o(20793);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(20794);
    Log.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof e))
    {
      if (paramInt2 == 0)
      {
        M(paramInt2, true);
        AppMethodBeat.o(20794);
        return;
      }
      M(paramInt2, false);
    }
    AppMethodBeat.o(20794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */