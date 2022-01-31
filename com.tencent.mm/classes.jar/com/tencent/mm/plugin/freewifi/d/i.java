package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.aoe;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(20792);
    bAR();
    aod localaod = (aod)this.rr.fsV.fta;
    localaod.coX = paramString1;
    localaod.mKo = paramString2;
    localaod.mKp = paramString3;
    localaod.mKq = paramString4;
    localaod.crs = paramString5;
    localaod.wkY = paramString6;
    AppMethodBeat.o(20792);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20791);
    b.a locala = new b.a();
    locala.fsX = new aod();
    locala.fsY = new aoe();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20791);
  }
  
  public final String bBa()
  {
    return ((aoe)this.rr.fsW.fta).mLv;
  }
  
  public final String bBb()
  {
    return ((aoe)this.rr.fsW.fta).mLw;
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */