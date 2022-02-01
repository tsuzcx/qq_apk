package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.bgh;

public final class i
  extends c
{
  public i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(24862);
    cRG();
    bgg localbgg = (bgg)this.rr.hNK.hNQ;
    localbgg.dmM = paramString1;
    localbgg.tmO = paramString2;
    localbgg.tmP = paramString3;
    localbgg.tmQ = paramString4;
    localbgg.dpf = paramString5;
    localbgg.FqI = paramString6;
    AppMethodBeat.o(24862);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24861);
    b.a locala = new b.a();
    locala.hNM = new bgg();
    locala.hNN = new bgh();
    locala.uri = "/cgi-bin/mmo2o-bin/getportalapinfo";
    locala.funcId = 1709;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24861);
  }
  
  public final String cRP()
  {
    return ((bgh)this.rr.hNL.hNQ).tnT;
  }
  
  public final String cRQ()
  {
    return ((bgh)this.rr.hNL.hNQ).tnU;
  }
  
  public final int getType()
  {
    return 1709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.i
 * JD-Core Version:    0.7.0.1
 */