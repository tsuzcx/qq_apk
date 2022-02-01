package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  public String Ejl;
  private i callback;
  public int errCode;
  public String errMsg;
  public int errType;
  private Runnable maA;
  public final d rr;
  public String tVH;
  
  public b(String paramString)
  {
    AppMethodBeat.i(55788);
    this.Ejl = "";
    d.a locala = new d.a();
    locala.lBU = new cnz();
    locala.lBV = new coa();
    locala.uri = "/cgi-bin/micromsg-bin/jointrackroom";
    locala.funcId = 490;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    ((cnz)d.b.b(this.rr.lBR)).Twk = paramString;
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
    if (d.c.b(((d)params).lBS) != null) {}
    for (params = (coa)d.c.b(((d)params).lBS);; params = null)
    {
      Log.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (((paramInt3 == 0) || (paramInt3 >= 1000)) && (params != null))
      {
        this.Ejl = params.SvI;
        Log.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[] { this.Ejl });
      }
      if (params != null) {
        this.tVH = params.RPs;
      }
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      if (this.maA != null) {
        this.maA.run();
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