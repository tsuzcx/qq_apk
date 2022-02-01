package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private g callback;
  public LinkedList<String> nqc;
  public int nqe;
  public int nqf;
  public int nqg;
  private final b rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    b.a locala = new b.a();
    locala.gUU = new arn();
    locala.gUV = new aro();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((arn)this.rr.gUS.gUX).dyc = paramString;
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
    ad.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (aro)this.rr.gUT.gUX;
      this.nqc = paramq.nqc;
      this.nqe = paramq.nqe;
      this.nqf = paramq.nqf;
      this.nqg = paramq.nqg;
    }
    ad.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.nqe), Integer.valueOf(this.nqf), Integer.valueOf(this.nqg) });
    if (this.nqc != null) {
      ad.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.nqc.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */