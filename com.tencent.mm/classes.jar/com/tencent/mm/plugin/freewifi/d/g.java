package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24858);
    cUl();
    bdc localbdc = (bdc)this.rr.hQD.hQJ;
    localbdc.txG = paramString1;
    localbdc.txH = paramString2;
    localbdc.txI = paramString3;
    localbdc.FJx = m.cTD();
    AppMethodBeat.o(24858);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24857);
    b.a locala = new b.a();
    locala.hQF = new bdc();
    locala.hQG = new bdd();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.funcId = 1746;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24857);
  }
  
  public final String cUt()
  {
    return ((bdd)this.rr.hQE.hQJ).GSE;
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */