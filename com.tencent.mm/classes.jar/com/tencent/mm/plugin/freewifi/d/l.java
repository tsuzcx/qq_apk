package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;

public final class l
  extends c
{
  public l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24869);
    cJr();
    cwx localcwx = (cwx)this.rr.hvr.hvw;
    localcwx.appId = paramString1;
    localcwx.sud = paramInt;
    localcwx.ddJ = paramString2;
    AppMethodBeat.o(24869);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24868);
    b.a locala = new b.a();
    locala.hvt = new cwx();
    locala.hvu = new cwy();
    locala.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
    locala.funcId = 1761;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24868);
  }
  
  public final int getType()
  {
    return 1761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.l
 * JD-Core Version:    0.7.0.1
 */