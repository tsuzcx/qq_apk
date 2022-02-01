package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cpk;

public final class e
  extends q
  implements m
{
  private i callback;
  private final d lKU;
  
  public e(String paramString)
  {
    AppMethodBeat.i(251928);
    d.a locala = new d.a();
    cpj localcpj = new cpj();
    cpk localcpk = new cpk();
    locala.lBU = localcpj;
    locala.lBV = localcpk;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
    locala.funcId = 973;
    locala.lBW = 0;
    locala.respCmdId = 0;
    localcpj.SvX = paramString;
    this.lKU = locala.bgN();
    AppMethodBeat.o(251928);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(251929);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(251929);
    return i;
  }
  
  public final int getType()
  {
    return 973;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251930);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(251930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.e
 * JD-Core Version:    0.7.0.1
 */