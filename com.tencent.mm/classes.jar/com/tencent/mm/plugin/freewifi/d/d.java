package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.uv;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(24849);
    cwf();
    uu localuu = (uu)this.rr.gUS.gUX;
    localuu.CWD = paramString1;
    localuu.CWE = paramString2;
    localuu.CWF = paramString3;
    localuu.CWG = paramString4;
    localuu.CWH = paramString5;
    localuu.CWI = paramLong;
    localuu.CWJ = paramString6;
    localuu.CWK = paramString7;
    AppMethodBeat.o(24849);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24848);
    b.a locala = new b.a();
    locala.gUU = new uu();
    locala.gUV = new uv();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24848);
  }
  
  public final uv cwl()
  {
    return (uv)this.rr.gUT.gUX;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */