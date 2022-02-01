package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  public cxy pha;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(63825);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cxx();
    ((b.a)localObject).hQG = new cxy();
    ((b.a)localObject).funcId = 1800;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (cxx)this.rr.hQD.hQJ;
    ((cxx)localObject).HIq = paramString;
    ((cxx)localObject).scene = paramInt;
    ae.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63825);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63826);
    this.pha = ((cxy)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.pha.dmy), this.pha.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63826);
  }
  
  public final void e(q paramq)
  {
    paramq = (cxy)((b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.k
 * JD-Core Version:    0.7.0.1
 */