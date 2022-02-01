package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class o
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public o(String paramString)
  {
    AppMethodBeat.i(12482);
    this.callback = null;
    b.a locala = new b.a();
    locala.hQF = new bng();
    locala.hQG = new bnh();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.funcId = 339;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((bng)this.rr.hQD.hQJ).uvF = paramString;
    ae.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(paramString)));
    AppMethodBeat.o(12482);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(12483);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12483);
    return i;
  }
  
  public final int getType()
  {
    return 339;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12484);
    ae.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + paramInt2 + " " + paramInt3 + "  " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12484);
      return;
    }
    paramInt1 = ((Integer)g.ajR().ajA().get(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      g.ajR().ajA().set(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.o
 * JD-Core Version:    0.7.0.1
 */