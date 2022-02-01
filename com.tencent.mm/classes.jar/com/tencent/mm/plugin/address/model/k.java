package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qj.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends IListener<qj>
  implements i
{
  private qj ksT;
  private c ksU;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = qj.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void K(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    Log.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.ksT.dWL.errCode = paramInt;
    if (paramInt != 0) {
      this.ksT.dWL.dWM = false;
    }
    for (;;)
    {
      if (this.ksT.callback != null) {
        this.ksT.callback.run();
      }
      bg.azz().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        g.l(this.ksU);
        this.ksT.dWL.dWM = false;
      }
      else
      {
        g.k(this.ksU);
        this.ksT.dWL.dWM = true;
        com.tencent.mm.plugin.address.a.a.bqb();
        Object localObject = com.tencent.mm.plugin.address.a.a.bqd().ksX;
        if (((com.tencent.mm.plugin.address.d.a)localObject).ktf.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).ktf.getFirst();
          this.ksT.dWL.dWN = ((b)localObject).kto;
          this.ksT.dWL.userName = ((b)localObject).ktm;
          this.ksT.dWL.dWO = ((b)localObject).ktn;
          this.ksT.dWL.dWP = ((b)localObject).ktk;
          this.ksT.dWL.dWQ = ((b)localObject).kth;
          this.ksT.dWL.dWR = ((b)localObject).kti;
          this.ksT.dWL.dWS = ((b)localObject).ktj;
          this.ksT.dWL.dWT = ((b)localObject).ktl;
        }
      }
    }
  }
  
  private boolean a(qj paramqj)
  {
    AppMethodBeat.i(20793);
    if ((paramqj instanceof qj))
    {
      this.ksT = paramqj;
      bg.azz().a(417, this);
      paramqj = new e(this.ksT.dWK.url, this.ksT.dWK.appId, 1);
      bg.azz().a(paramqj, 0);
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
        K(paramInt2, true);
        AppMethodBeat.o(20794);
        return;
      }
      K(paramInt2, false);
    }
    AppMethodBeat.o(20794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */