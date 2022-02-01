package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends n
  implements k
{
  private f callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable ips;
  public String kuP;
  public final com.tencent.mm.ak.b rr;
  public String vlA;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.vlA = "";
    b.a locala = new b.a();
    locala.hQF = new bsk();
    locala.hQG = new bsl();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    ((bsk)this.rr.hQD.hQJ).Hgj = paramString;
    ae.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55788);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(55789);
    this.callback = paramf;
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
    if (((com.tencent.mm.ak.b)paramq).hQE.hQJ != null) {}
    for (paramq = (bsl)((com.tencent.mm.ak.b)paramq).hQE.hQJ;; paramq = null)
    {
      ae.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (paramq != null))
      {
        this.vlA = paramq.GxB;
        ae.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.vlA });
      }
      if (paramq != null) {
        this.kuP = paramq.FUM;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.ips != null) {
        this.ips.run();
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