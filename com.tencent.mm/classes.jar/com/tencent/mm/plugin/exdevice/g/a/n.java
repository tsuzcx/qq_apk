package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dsb;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  private f callback;
  public int opType;
  public int qlY;
  public int qlZ;
  private b rr;
  
  public n(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(23540);
    this.callback = null;
    this.rr = null;
    this.opType = paramInt1;
    this.qlY = paramInt2;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dsb();
    ((b.a)localObject).hQG = new dsc();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
    ((b.a)localObject).funcId = 1044;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dsb)this.rr.hQD.hQJ;
    ((dsb)localObject).dGO = this.opType;
    ((dsb)localObject).dEu = this.qlY;
    AppMethodBeat.o(23540);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23541);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23541);
    return i;
  }
  
  public final int getType()
  {
    return 1044;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23542);
    ae.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.qlZ = ((dsc)this.rr.hQE.hQJ).dEu;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.n
 * JD-Core Version:    0.7.0.1
 */