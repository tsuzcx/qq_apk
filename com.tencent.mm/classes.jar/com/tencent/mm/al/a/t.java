package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.sdk.platformtools.ac;

public final class t
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public t(String paramString)
  {
    AppMethodBeat.i(124313);
    b.a locala = new b.a();
    locala.hvt = new axg();
    locala.hvu = new axh();
    locala.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
    locala.funcId = 1367;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((axg)this.rr.hvr.hvw).Ebs = paramString;
    AppMethodBeat.o(124313);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(124315);
    this.callback = paramg;
    ac.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124315);
    return i;
  }
  
  public final int getType()
  {
    return 1367;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124314);
    ac.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.t
 * JD-Core Version:    0.7.0.1
 */