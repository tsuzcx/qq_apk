package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24858);
    dNu();
    boq localboq = (boq)this.rr.iLK.iLR;
    localboq.wOK = paramString1;
    localboq.wOL = paramString2;
    localboq.wOM = paramString3;
    localboq.KCP = m.dMM();
    AppMethodBeat.o(24858);
  }
  
  public final String dNC()
  {
    return ((bor)this.rr.iLL.iLR).LWQ;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24857);
    d.a locala = new d.a();
    locala.iLN = new boq();
    locala.iLO = new bor();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.funcId = 1746;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24857);
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */