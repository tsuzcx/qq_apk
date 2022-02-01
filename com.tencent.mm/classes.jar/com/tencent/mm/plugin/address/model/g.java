package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elz;
import com.tencent.mm.protocal.protobuf.ema;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(20783);
    c.a locala = new c.a();
    locala.otE = new elz();
    locala.otF = new ema();
    locala.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
    locala.funcId = 419;
    locala.otG = 204;
    locala.respCmdId = 1000000204;
    this.rr = locala.bEF();
    ((elz)c.b.b(this.rr.otB)).id = paramInt;
    AppMethodBeat.o(20783);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(20785);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20785);
    return i;
  }
  
  public final int getType()
  {
    return 419;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20784);
    Log.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ema)c.c.b(((c)params).otC);
      if (params.abqi.abql != null)
      {
        Log.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + params.abqi.abql.size());
        a.bZe();
        a.bZg().x(params.abqi.abql);
        a.bZe();
        a.bZg().bZj();
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.g
 * JD-Core Version:    0.7.0.1
 */