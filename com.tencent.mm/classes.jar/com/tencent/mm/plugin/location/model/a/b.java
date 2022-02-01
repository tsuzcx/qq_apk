package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable jkz;
  public String qwG;
  public final d rr;
  public String yFs;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.yFs = "";
    d.a locala = new d.a();
    locala.iLN = new cfe();
    locala.iLO = new cff();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((cfe)this.rr.iLK.iLR).Mls = paramString;
    Log.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(55788);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(55789);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(55789);
    return i;
  }
  
  public final int getType()
  {
    return 490;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(55790);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    if (((d)params).iLL.iLR != null) {}
    for (params = (cff)((d)params).iLL.iLR;; params = null)
    {
      Log.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (params != null))
      {
        this.yFs = params.Ltk;
        Log.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.yFs });
      }
      if (params != null) {
        this.qwG = params.KOu;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.jkz != null) {
        this.jkz.run();
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