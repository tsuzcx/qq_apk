package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.ayl;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(24862);
    cwf();
    ayk localayk = (ayk)this.rr.gUS.gUX;
    localayk.ddU = paramString1;
    localayk.rht = paramString2;
    localayk.rhu = paramString3;
    localayk.rhv = paramString4;
    localayk.dgo = paramString5;
    localayk.Ctm = paramString6;
    AppMethodBeat.o(24862);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24861);
    b.a locala = new b.a();
    locala.gUU = new ayk();
    locala.gUV = new ayl();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24861);
  }
  
  public final String cwo()
  {
    return ((ayl)this.rr.gUT.gUX).riz;
  }
  
  public final String cwp()
  {
    return ((ayl)this.rr.gUT.gUX).riA;
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */