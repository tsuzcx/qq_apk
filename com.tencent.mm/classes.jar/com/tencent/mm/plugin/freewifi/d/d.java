package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(24849);
    cUl();
    xg localxg = (xg)this.rr.hQD.hQJ;
    localxg.GoX = paramString1;
    localxg.GoY = paramString2;
    localxg.GoZ = paramString3;
    localxg.Gpa = paramString4;
    localxg.Gpb = paramString5;
    localxg.Gpc = paramLong;
    localxg.Gpd = paramString6;
    localxg.Gpe = paramString7;
    AppMethodBeat.o(24849);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24848);
    b.a locala = new b.a();
    locala.hQF = new xg();
    locala.hQG = new xh();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24848);
  }
  
  public final xh cUr()
  {
    return (xh)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */