package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.protocal.protobuf.crp;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24869);
    cwf();
    cro localcro = (cro)this.rr.gUS.gUX;
    localcro.appId = paramString1;
    localcro.rlk = paramInt;
    localcro.dgo = paramString2;
    AppMethodBeat.o(24869);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24868);
    b.a locala = new b.a();
    locala.gUU = new cro();
    locala.gUV = new crp();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24868);
  }
  
  public final int getType()
  {
    return 1761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.l
 * JD-Core Version:    0.7.0.1
 */