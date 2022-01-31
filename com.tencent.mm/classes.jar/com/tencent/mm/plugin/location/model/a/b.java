package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends m
  implements k
{
  private f callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable fQa;
  public String hxt;
  public String nZT;
  public final com.tencent.mm.ai.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(113412);
    this.nZT = "";
    b.a locala = new b.a();
    locala.fsX = new ayg();
    locala.fsY = new ayh();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((ayg)this.rr.fsV.fta).xoe = paramString;
    ab.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(113412);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(113413);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(113413);
    return i;
  }
  
  public final int getType()
  {
    return 490;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113414);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    if (((com.tencent.mm.ai.b)paramq).fsW.fta != null) {}
    for (paramq = (ayh)((com.tencent.mm.ai.b)paramq).fsW.fta;; paramq = null)
    {
      ab.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (paramq != null))
      {
        this.nZT = paramq.wQX;
        ab.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.nZT });
      }
      if (paramq != null) {
        this.hxt = paramq.wuE;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.fQa != null) {
        this.fQa.run();
      }
      AppMethodBeat.o(113414);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.a.b
 * JD-Core Version:    0.7.0.1
 */