package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.protocal.protobuf.yr;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(24849);
    dNu();
    yq localyq = (yq)this.rr.iLK.iLR;
    localyq.LjI = paramString1;
    localyq.LjJ = paramString2;
    localyq.LjK = paramString3;
    localyq.LjL = paramString4;
    localyq.LjM = paramString5;
    localyq.LjN = paramLong;
    localyq.LjO = paramString6;
    localyq.LjP = paramString7;
    AppMethodBeat.o(24849);
  }
  
  public final yr dNA()
  {
    return (yr)this.rr.iLL.iLR;
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24848);
    d.a locala = new d.a();
    locala.iLN = new yq();
    locala.iLO = new yr();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24848);
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */