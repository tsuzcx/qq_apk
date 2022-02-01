package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.ayi;
import com.tencent.mm.protocal.protobuf.ayj;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24858);
    cJr();
    ayi localayi = (ayi)this.rr.hvr.hvw;
    localayi.sqm = paramString1;
    localayi.sqn = paramString2;
    localayi.sqo = paramString3;
    localayi.DLU = m.cIJ();
    AppMethodBeat.o(24858);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24857);
    b.a locala = new b.a();
    locala.hvt = new ayi();
    locala.hvu = new ayj();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.funcId = 1746;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24857);
  }
  
  public final String cJz()
  {
    return ((ayj)this.rr.hvs.hvw).EPN;
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */