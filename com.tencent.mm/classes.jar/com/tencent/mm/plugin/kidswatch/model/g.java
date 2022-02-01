package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;

public final class g
  extends q
  implements m
{
  private i callback;
  private final d iUB;
  private boolean yAX;
  
  public g(String paramString1, String paramString2, int paramInt, cgm paramcgm)
  {
    AppMethodBeat.i(256404);
    this.yAX = false;
    d.a locala = new d.a();
    cgr localcgr = new cgr();
    cgs localcgs = new cgs();
    locala.iLN = localcgr;
    locala.iLO = localcgs;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.iLP = 0;
    locala.respCmdId = 0;
    localcgr.LtA = paramString1;
    localcgr.LtL = paramString2;
    localcgr.LtN = false;
    localcgr.MlY = paramInt;
    localcgr.MlZ = paramcgm;
    this.iUB = locala.aXF();
    AppMethodBeat.o(256404);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(256405);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(256405);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(256406);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(256406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.g
 * JD-Core Version:    0.7.0.1
 */