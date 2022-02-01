package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.protocal.protobuf.bsm;
import com.tencent.mm.protocal.protobuf.bsn;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24860);
    dNu();
    bsm localbsm = (bsm)this.rr.iLK.iLR;
    localbsm.appId = paramString1;
    localbsm.wSx = paramInt;
    localbsm.dHx = paramString2;
    AppMethodBeat.o(24860);
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24859);
    d.a locala = new d.a();
    locala.iLN = new bsm();
    locala.iLO = new bsn();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24859);
  }
  
  public final bfr dNy()
  {
    bsn localbsn = (bsn)this.rr.iLL.iLR;
    if (localbsn != null) {
      return localbsn.KCJ;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */