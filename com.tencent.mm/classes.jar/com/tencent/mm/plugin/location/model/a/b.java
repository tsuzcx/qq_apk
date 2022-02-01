package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjm;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private g callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable hsF;
  public String jwH;
  public final com.tencent.mm.al.b rr;
  public String sOt;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.sOt = "";
    b.a locala = new b.a();
    locala.gUU = new bjm();
    locala.gUV = new bjn();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    ((bjm)this.rr.gUS.gUX).DHN = paramString;
    ad.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55788);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(55789);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(55789);
    return i;
  }
  
  public final int getType()
  {
    return 490;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55790);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    if (((com.tencent.mm.al.b)paramq).gUT.gUX != null) {}
    for (paramq = (bjn)((com.tencent.mm.al.b)paramq).gUT.gUX;; paramq = null)
    {
      ad.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (paramq != null))
      {
        this.sOt = paramq.Dek;
        ad.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.sOt });
      }
      if (paramq != null) {
        this.jwH = paramq.CEv;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.hsF != null) {
        this.hsF.run();
      }
      AppMethodBeat.o(55790);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.b
 * JD-Core Version:    0.7.0.1
 */