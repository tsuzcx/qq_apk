package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;

public final class k
  extends r
{
  public cxe paw;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(63825);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cxd();
    ((b.a)localObject).hNN = new cxe();
    ((b.a)localObject).funcId = 1800;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cxd)this.rr.hNK.hNQ;
    ((cxd)localObject).HoO = paramString;
    ((cxd)localObject).scene = paramInt;
    ad.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63825);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63826);
    this.paw = ((cxe)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.paw.dlw), this.paw.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63826);
  }
  
  public final void e(q paramq)
  {
    paramq = (cxe)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
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