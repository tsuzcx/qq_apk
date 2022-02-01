package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.ddf;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24869);
    cUl();
    dde localdde = (dde)this.rr.hQD.hQJ;
    localdde.appId = paramString1;
    localdde.tBw = paramInt;
    localdde.dqk = paramString2;
    AppMethodBeat.o(24869);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24868);
    b.a locala = new b.a();
    locala.hQF = new dde();
    locala.hQG = new ddf();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
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