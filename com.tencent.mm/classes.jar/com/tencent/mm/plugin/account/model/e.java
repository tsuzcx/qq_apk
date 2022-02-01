package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  private f callback;
  public String fhy;
  private b hZD;
  
  public e(String paramString)
  {
    AppMethodBeat.i(188393);
    b.a locala = new b.a();
    wb localwb = new wb();
    localwb.fhy = paramString;
    this.fhy = paramString;
    locala.hQF = localwb;
    locala.hQG = new wc();
    locala.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
    locala.funcId = getType();
    this.hZD = locala.aDS();
    AppMethodBeat.o(188393);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(188394);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
    AppMethodBeat.o(188394);
    return i;
  }
  
  public final int getType()
  {
    return 3516;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(188395);
    ae.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(188395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */