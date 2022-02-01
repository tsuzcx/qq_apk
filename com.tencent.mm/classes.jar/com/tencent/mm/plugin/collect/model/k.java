package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crw;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  public crx oxb;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(63825);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new crw();
    ((b.a)localObject).hvu = new crx();
    ((b.a)localObject).funcId = 1800;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (crw)this.rr.hvr.hvw;
    ((crw)localObject).FEz = paramString;
    ((crw)localObject).scene = paramInt;
    ac.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63825);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63826);
    this.oxb = ((crx)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.oxb.dae), this.oxb.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63826);
  }
  
  public final void e(q paramq)
  {
    paramq = (crx)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.k
 * JD-Core Version:    0.7.0.1
 */