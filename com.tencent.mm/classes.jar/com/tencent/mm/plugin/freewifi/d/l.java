package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.protocal.protobuf.dcl;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24869);
    cRG();
    dck localdck = (dck)this.rr.hNK.hNQ;
    localdck.appId = paramString1;
    localdck.tqF = paramInt;
    localdck.dpf = paramString2;
    AppMethodBeat.o(24869);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24868);
    b.a locala = new b.a();
    locala.hNM = new dck();
    locala.hNN = new dcl();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
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