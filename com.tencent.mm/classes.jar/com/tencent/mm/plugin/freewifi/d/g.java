package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.avc;
import com.tencent.mm.protocal.protobuf.avd;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24858);
    cwf();
    avc localavc = (avc)this.rr.gUS.gUX;
    localavc.rht = paramString1;
    localavc.rhu = paramString2;
    localavc.rhv = paramString3;
    localavc.CtD = m.cvx();
    AppMethodBeat.o(24858);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24857);
    b.a locala = new b.a();
    locala.gUU = new avc();
    locala.gUV = new avd();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.funcId = 1746;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24857);
  }
  
  public final String cwn()
  {
    return ((avd)this.rr.gUT.gUX).DuE;
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */