package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(20783);
    b.a locala = new b.a();
    locala.hQF = new crq();
    locala.hQG = new crr();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
    locala.funcId = 419;
    locala.hQH = 204;
    locala.respCmdId = 1000000204;
    this.rr = locala.aDS();
    ((crq)this.rr.hQD.hQJ).id = paramInt;
    AppMethodBeat.o(20783);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(20785);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20785);
    return i;
  }
  
  public final int getType()
  {
    return 419;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20784);
    ae.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crr)((b)paramq).hQE.hQJ;
      if (paramq.HCE.HCH != null)
      {
        ae.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.g
 * JD-Core Version:    0.7.0.1
 */