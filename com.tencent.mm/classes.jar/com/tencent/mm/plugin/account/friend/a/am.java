package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbj;

public final class am
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public am(String paramString)
  {
    AppMethodBeat.i(131142);
    b.a locala = new b.a();
    locala.hQF = new dbi();
    locala.hQG = new dbj();
    locala.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
    locala.funcId = 108;
    locala.hQH = 43;
    locala.respCmdId = 1000000043;
    this.rr = locala.aDS();
    ((dbi)this.rr.hQD.hQJ).GuF = new cxn().aQV(paramString);
    AppMethodBeat.o(131142);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131143);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131143);
    return i;
  }
  
  public final int getType()
  {
    return 108;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131144);
    updateDispatchId(paramInt1);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.am
 * JD-Core Version:    0.7.0.1
 */