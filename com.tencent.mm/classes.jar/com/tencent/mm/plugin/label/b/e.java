package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class e
  extends n
  implements k
{
  private g callback;
  private final b rr;
  private bol tTD;
  
  public e(int paramInt, String paramString)
  {
    AppMethodBeat.i(26155);
    this.tTD = null;
    b.a locala = new b.a();
    locala.hvt = new dlh();
    locala.hvu = new dli();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.funcId = 637;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    if ((paramInt >= 0) && (!bs.isNullOrNil(paramString)))
    {
      this.tTD = new bol();
      this.tTD.FdL = paramInt;
      this.tTD.FdK = paramString;
    }
    AppMethodBeat.o(26155);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(26157);
    this.callback = paramg;
    dlh localdlh = (dlh)this.rr.hvr.hvw;
    if (this.tTD != null)
    {
      localdlh.FTX = this.tTD;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26157);
      return i;
    }
    ac.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    paramg.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
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
    ac.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */