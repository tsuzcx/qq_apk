package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class e
  extends n
  implements k
{
  private f callback;
  private final b rr;
  private bts vhS;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(26155);
    this.vhS = null;
    b.a locala = new b.a();
    locala.hQF = new drv();
    locala.hQG = new drw();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.funcId = 637;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    if ((paramInt >= 0) && (!bu.isNullOrNil(paramString)))
    {
      this.vhS = new bts();
      this.vhS.HgP = paramInt;
      this.vhS.HgO = paramString;
    }
    AppMethodBeat.o(26155);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26157);
    this.callback = paramf;
    drv localdrv = (drv)this.rr.hQD.hQJ;
    if (this.vhS != null)
    {
      localdrv.HYy = this.vhS;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26157);
      return i;
    }
    ae.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
    AppMethodBeat.o(26157);
    return 0;
  }
  
  public final int getType()
  {
    return 637;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26156);
    ae.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */