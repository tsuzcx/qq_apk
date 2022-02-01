package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.f;
import com.tencent.mm.g.a.ox;
import com.tencent.mm.g.a.ox.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.sdk.b.c<ox>
  implements g
{
  private com.tencent.mm.api.c iyA;
  private ox iyz;
  
  public k()
  {
    AppMethodBeat.i(161286);
    this.__eventId = ox.class.getName().hashCode();
    AppMethodBeat.o(161286);
  }
  
  private void G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20795);
    ad.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    this.iyz.dup.errCode = paramInt;
    if (paramInt != 0) {
      this.iyz.dup.duq = false;
    }
    for (;;)
    {
      if (this.iyz.callback != null) {
        this.iyz.callback.run();
      }
      az.aeS().b(417, this);
      AppMethodBeat.o(20795);
      return;
      if (!paramBoolean)
      {
        f.k(this.iyA);
        this.iyz.dup.duq = false;
      }
      else
      {
        f.j(this.iyA);
        this.iyz.dup.duq = true;
        com.tencent.mm.plugin.address.a.a.aKO();
        Object localObject = com.tencent.mm.plugin.address.a.a.aKQ().iyD;
        if (((com.tencent.mm.plugin.address.d.a)localObject).iyM.size() > 0)
        {
          localObject = (b)((com.tencent.mm.plugin.address.d.a)localObject).iyM.getFirst();
          this.iyz.dup.dur = ((b)localObject).iyV;
          this.iyz.dup.userName = ((b)localObject).iyT;
          this.iyz.dup.dus = ((b)localObject).iyU;
          this.iyz.dup.dut = ((b)localObject).iyR;
          this.iyz.dup.duu = ((b)localObject).iyO;
          this.iyz.dup.duv = ((b)localObject).iyP;
          this.iyz.dup.duw = ((b)localObject).iyQ;
          this.iyz.dup.dux = ((b)localObject).iyS;
        }
      }
    }
  }
  
  private boolean a(ox paramox)
  {
    AppMethodBeat.i(20793);
    if ((paramox instanceof ox))
    {
      this.iyz = paramox;
      az.aeS().a(417, this);
      paramox = new e(this.iyz.duo.url, this.iyz.duo.appId, 1);
      az.aeS().a(paramox, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.k
 * JD-Core Version:    0.7.0.1
 */