package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpi;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;

public final class g
  extends q
  implements m
{
  private boolean Ecm;
  private i callback;
  private final d lKU;
  
  public g(String paramString1, String paramString2, int paramInt, cpi paramcpi)
  {
    AppMethodBeat.i(251638);
    this.Ecm = false;
    d.a locala = new d.a();
    cpn localcpn = new cpn();
    cpo localcpo = new cpo();
    locala.lBU = localcpn;
    locala.lBV = localcpo;
    locala.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
    locala.funcId = 972;
    locala.lBW = 0;
    locala.respCmdId = 0;
    localcpn.SvX = paramString1;
    localcpn.Swi = paramString2;
    localcpn.Swk = false;
    localcpn.TwS = paramInt;
    localcpn.TwT = paramcpi;
    this.lKU = locala.bgN();
    AppMethodBeat.o(251638);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(251639);
    this.callback = parami;
    int i = dispatch(paramg, this.lKU, this);
    AppMethodBeat.o(251639);
    return i;
  }
  
  public final int getType()
  {
    return 972;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(251640);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(251640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.model.g
 * JD-Core Version:    0.7.0.1
 */