package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.aye;
import com.tencent.mm.protocal.protobuf.ayf;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24860);
    cwf();
    aye localaye = (aye)this.rr.gUS.gUX;
    localaye.appId = paramString1;
    localaye.rlk = paramInt;
    localaye.dgo = paramString2;
    AppMethodBeat.o(24860);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24859);
    b.a locala = new b.a();
    locala.gUU = new aye();
    locala.gUV = new ayf();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24859);
  }
  
  public final amu cwj()
  {
    ayf localayf = (ayf)this.rr.gUT.gUX;
    if (localayf != null) {
      return localayf.Ctx;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */