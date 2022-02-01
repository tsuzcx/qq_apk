package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private f callback;
  public int owA;
  public int owB;
  public LinkedList<String> owx;
  public int owz;
  private final b rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    b.a locala = new b.a();
    locala.hNM = new ayp();
    locala.hNN = new ayq();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((ayp)this.rr.hNK.hNQ).dHX = paramString;
    AppMethodBeat.o(112843);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(112844);
    this.callback = paramf;
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
      paramq = (ayq)this.rr.hNL.hNQ;
      this.owx = paramq.owx;
      this.owz = paramq.owz;
      this.owA = paramq.owA;
      this.owB = paramq.owB;
    }
    ad.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.owz), Integer.valueOf(this.owA), Integer.valueOf(this.owB) });
    if (this.owx != null) {
      ad.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.owx.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */