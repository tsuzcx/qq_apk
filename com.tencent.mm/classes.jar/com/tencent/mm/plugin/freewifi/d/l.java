package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.protocal.protobuf.dwi;
import com.tencent.mm.protocal.protobuf.dwj;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24869);
    dNu();
    dwi localdwi = (dwi)this.rr.iLK.iLR;
    localdwi.appId = paramString1;
    localdwi.wSx = paramInt;
    localdwi.dHx = paramString2;
    AppMethodBeat.o(24869);
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24868);
    d.a locala = new d.a();
    locala.iLN = new dwi();
    locala.iLO = new dwj();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24868);
  }
  
  public final int getType()
  {
    return 1761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.l
 * JD-Core Version:    0.7.0.1
 */