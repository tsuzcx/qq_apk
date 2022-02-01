package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

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
    locala.hNM = new bmo();
    locala.hNN = new bmp();
    locala.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
    locala.funcId = 339;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((bmo)this.rr.hNK.hNQ).uki = paramString;
    ad.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(paramString)));
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
    ad.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + paramInt2 + " " + paramInt3 + "  " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12484);
      return;
    }
    paramInt1 = ((Integer)g.ajC().ajl().get(135176, Integer.valueOf(0))).intValue();
    if (paramInt1 - 1 >= 0) {
      g.ajC().ajl().set(135176, Integer.valueOf(paramInt1 - 1));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.o
 * JD-Core Version:    0.7.0.1
 */