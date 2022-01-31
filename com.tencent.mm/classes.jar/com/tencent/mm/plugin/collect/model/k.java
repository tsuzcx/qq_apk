package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class k
  extends p
{
  public bwn kNt;
  
  public k(String paramString, int paramInt)
  {
    AppMethodBeat.i(40973);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bwm();
    ((b.a)localObject).fsY = new bwn();
    ((b.a)localObject).funcId = 1800;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bwm)this.rr.fsV.fta;
    ((bwm)localObject).xJR = paramString;
    ((bwm)localObject).scene = paramInt;
    ab.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", new Object[] { paramString, Integer.valueOf(paramInt) });
    AppMethodBeat.o(40973);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(40974);
    this.kNt = ((bwn)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.kNt.cnK), this.kNt.kNv });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(40974);
  }
  
  public final void e(q paramq)
  {
    paramq = (bwn)((b)paramq).fsW.fta;
    this.AXb = paramq.cnK;
    this.AXc = paramq.kNv;
  }
  
  public final int getType()
  {
    return 1800;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.k
 * JD-Core Version:    0.7.0.1
 */