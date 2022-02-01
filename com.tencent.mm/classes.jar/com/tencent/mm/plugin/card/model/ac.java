package com.tencent.mm.plugin.card.model;

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
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class ac
  extends n
  implements k
{
  private f callback;
  public LinkedList<String> oCZ;
  public int oDb;
  public int oDc;
  public int oDd;
  private final b rr;
  
  public ac(String paramString)
  {
    AppMethodBeat.i(112843);
    b.a locala = new b.a();
    locala.hQF = new azf();
    locala.hQG = new azg();
    locala.uri = "/cgi-bin/micromsg-bin/getcardserial";
    locala.funcId = 577;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((azf)this.rr.hQD.hQJ).dJb = paramString;
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
    ae.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (azg)this.rr.hQE.hQJ;
      this.oCZ = paramq.oCZ;
      this.oDb = paramq.oDb;
      this.oDc = paramq.oDc;
      this.oDd = paramq.oDd;
    }
    ae.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[] { Integer.valueOf(this.oDb), Integer.valueOf(this.oDc), Integer.valueOf(this.oDd) });
    if (this.oCZ != null) {
      ae.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.oCZ.size());
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(112845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ac
 * JD-Core Version:    0.7.0.1
 */