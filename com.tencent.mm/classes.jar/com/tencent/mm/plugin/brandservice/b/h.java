package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.platformtools.ad;

public final class h
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public h(String paramString)
  {
    AppMethodBeat.i(5574);
    b.a locala = new b.a();
    locala.hNM = new bwp();
    locala.hNN = new bwq();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/getallrecvtmpmsgoption";
    locala.funcId = 1031;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    ((bwp)this.rr.hNK.hNQ).GJO = paramString;
    AppMethodBeat.o(5574);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5576);
    this.callback = paramf;
    ad.i("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(5576);
    return i;
  }
  
  public final int getType()
  {
    return 1031;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5575);
    ad.d("MicroMsg.brandservice.NetSceneGetAllRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(5575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.h
 * JD-Core Version:    0.7.0.1
 */