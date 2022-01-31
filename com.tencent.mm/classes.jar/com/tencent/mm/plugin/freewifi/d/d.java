package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.protocal.protobuf.sd;

public final class d
  extends c
{
  public d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7)
  {
    AppMethodBeat.i(20780);
    bAR();
    sc localsc = (sc)this.rr.fsV.fta;
    localsc.wKq = paramString1;
    localsc.wKr = paramString2;
    localsc.wKs = paramString3;
    localsc.wKt = paramString4;
    localsc.wKu = paramString5;
    localsc.wKv = paramLong;
    localsc.wKw = paramString6;
    localsc.wKx = paramString7;
    AppMethodBeat.o(20780);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20779);
    b.a locala = new b.a();
    locala.fsX = new sc();
    locala.fsY = new sd();
    locala.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20779);
  }
  
  public final sd bAX()
  {
    return (sd)this.rr.fsW.fta;
  }
  
  public final int getType()
  {
    return 1155;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.d
 * JD-Core Version:    0.7.0.1
 */