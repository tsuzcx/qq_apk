package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private g callback;
  public LinkedList<String> nTc;
  public int nTe;
  public int nTf;
  public int nTg;
  private final b rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    b.a locala = new b.a();
    locala.hvt = new aur();
    locala.hvu = new aus();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((aur)this.rr.hvr.hvw).dvO = paramString;
    AppMethodBeat.o(112843);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(112844);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(112844);
    return i;
  }
  
  public final int getType()
  {
    return 577;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(112845);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aus)this.rr.hvs.hvw;
      this.nTc = paramq.nTc;
      this.nTe = paramq.nTe;
      this.nTf = paramq.nTf;
      this.nTg = paramq.nTg;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.nTe), Integer.valueOf(this.nTf), Integer.valueOf(this.nTg) });
    if (this.nTc != null) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.nTc.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */