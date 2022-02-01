package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.xe;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(24849);
    cRG();
    xd localxd = (xd)this.rr.hNK.hNQ;
    localxd.FWy = paramString1;
    localxd.FWz = paramString2;
    localxd.FWA = paramString3;
    localxd.FWB = paramString4;
    localxd.FWC = paramString5;
    localxd.FWD = paramLong;
    localxd.FWE = paramString6;
    localxd.FWF = paramString7;
    AppMethodBeat.o(24849);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24848);
    b.a locala = new b.a();
    locala.hNM = new xd();
    locala.hNN = new xe();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24848);
  }
  
  public final xe cRM()
  {
    return (xe)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */