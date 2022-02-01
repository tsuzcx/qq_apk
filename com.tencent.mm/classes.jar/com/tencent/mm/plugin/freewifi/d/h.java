package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24860);
    cRG();
    bga localbga = (bga)this.rr.hNK.hNQ;
    localbga.appId = paramString1;
    localbga.tqF = paramInt;
    localbga.dpf = paramString2;
    AppMethodBeat.o(24860);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24859);
    b.a locala = new b.a();
    locala.hNM = new bga();
    locala.hNN = new bgb();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24859);
  }
  
  public final ats cRK()
  {
    bgb localbgb = (bgb)this.rr.hNL.hNQ;
    if (localbgb != null) {
      return localbgb.FqT;
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