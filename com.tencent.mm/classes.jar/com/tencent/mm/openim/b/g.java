package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.sdk.platformtools.ab;

public final class g
  extends m
  implements k
{
  private f callback;
  private final String gfK;
  private final b rr;
  
  public g(String paramString)
  {
    AppMethodBeat.i(78852);
    b.a locala = new b.a();
    locala.fsX = new amz();
    locala.fsY = new ana();
    locala.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
    locala.funcId = 890;
    this.rr = locala.ado();
    this.gfK = paramString;
    ((amz)this.rr.fsV.fta).gfM = paramString;
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", new Object[] { paramString });
    AppMethodBeat.o(78852);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78854);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78854);
    return i;
  }
  
  public final int getType()
  {
    return 890;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78853);
    ab.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(78853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.b.g
 * JD-Core Version:    0.7.0.1
 */