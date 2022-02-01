package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(24862);
    dNu();
    bsu localbsu = (bsu)this.rr.iLK.iLR;
    localbsu.dFd = paramString1;
    localbsu.wOK = paramString2;
    localbsu.wOL = paramString3;
    localbsu.wOM = paramString4;
    localbsu.dHx = paramString5;
    localbsu.KCy = paramString6;
    AppMethodBeat.o(24862);
  }
  
  public final String dND()
  {
    return ((bsv)this.rr.iLL.iLR).wPO;
  }
  
  public final String dNE()
  {
    return ((bsv)this.rr.iLL.iLR).extend;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24861);
    d.a locala = new d.a();
    locala.iLN = new bsu();
    locala.iLO = new bsv();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24861);
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */