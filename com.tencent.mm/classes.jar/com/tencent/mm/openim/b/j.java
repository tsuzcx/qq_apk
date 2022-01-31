package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
  extends m
  implements k
{
  public String cCk;
  private f callback;
  private final b rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(78862);
    b.a locala = new b.a();
    locala.fsX = new anh();
    locala.fsY = new ani();
    locala.uri = "/cgi-bin/micromsg-bin/getopenurl";
    locala.funcId = 913;
    this.rr = locala.ado();
    ab.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", new Object[] { paramString });
    ((anh)this.rr.fsV.fta).userName = paramString;
    AppMethodBeat.o(78862);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78863);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78863);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78864);
    ab.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(78864);
      return;
    }
    this.cCk = ((ani)this.rr.fsW.fta).cCk;
    ab.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", new Object[] { this.cCk });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.j
 * JD-Core Version:    0.7.0.1
 */