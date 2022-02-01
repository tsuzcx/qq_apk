package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
  extends n
  implements k
{
  private g callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable hTh;
  public String jXd;
  public final com.tencent.mm.ak.b rr;
  public String tWG;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.tWG = "";
    b.a locala = new b.a();
    locala.hvt = new bng();
    locala.hvu = new bnh();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    ((bng)this.rr.hvr.hvw).Fdi = paramString;
    ac.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
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
    if (((com.tencent.mm.ak.b)paramq).hvs.hvw != null) {}
    for (paramq = (bnh)((com.tencent.mm.ak.b)paramq).hvs.hvw;; paramq = null)
    {
      ac.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (paramq != null))
      {
        this.tWG = paramq.Exq;
        ac.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.tWG });
      }
      if (paramq != null) {
        this.jXd = paramq.DWV;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.hTh != null) {
        this.hTh.run();
      }
      AppMethodBeat.o(55790);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.b
 * JD-Core Version:    0.7.0.1
 */