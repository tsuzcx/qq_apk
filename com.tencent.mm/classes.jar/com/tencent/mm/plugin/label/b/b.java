package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends n
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  public String vhQ;
  
  public b(String paramString)
  {
    AppMethodBeat.i(26146);
    this.vhQ = null;
    b.a locala = new b.a();
    locala.hQF = new adf();
    locala.hQG = new adg();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.funcId = 636;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.vhQ = paramString;
    AppMethodBeat.o(26146);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(26148);
    this.callback = paramf;
    adf localadf = (adf)this.rr.hQD.hQJ;
    localadf.GuH = this.vhQ;
    if ((this.vhQ != null) && (!bu.isNullOrNil(this.vhQ)))
    {
      localadf.GuH = this.vhQ;
      localadf.GuH = this.vhQ;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26148);
      return i;
    }
    ae.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    AppMethodBeat.o(26148);
    return 0;
  }
  
  public final int getType()
  {
    return 636;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26147);
    ae.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */