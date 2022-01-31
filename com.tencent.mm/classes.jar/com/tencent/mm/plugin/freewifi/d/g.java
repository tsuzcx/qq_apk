package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.aln;

public final class g
  extends c
{
  public g(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20788);
    bAR();
    alm localalm = (alm)this.rr.fsV.fta;
    localalm.mKo = paramString1;
    localalm.mKp = paramString2;
    localalm.mKq = paramString3;
    localalm.wlp = m.bAj();
    AppMethodBeat.o(20788);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20787);
    b.a locala = new b.a();
    locala.fsX = new alm();
    locala.fsY = new aln();
    locala.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
    locala.funcId = 1746;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20787);
  }
  
  public final String bAZ()
  {
    return ((aln)this.rr.fsW.fta).xcl;
  }
  
  public final int getType()
  {
    return 1746;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.g
 * JD-Core Version:    0.7.0.1
 */