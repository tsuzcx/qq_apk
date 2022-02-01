package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.bbw;
import com.tencent.mm.protocal.protobuf.bbx;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24860);
    cJr();
    bbw localbbw = (bbw)this.rr.hvr.hvw;
    localbbw.appId = paramString1;
    localbbw.sud = paramInt;
    localbbw.ddJ = paramString2;
    AppMethodBeat.o(24860);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24859);
    b.a locala = new b.a();
    locala.hvt = new bbw();
    locala.hvu = new bbx();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24859);
  }
  
  public final apy cJv()
  {
    bbx localbbx = (bbx)this.rr.hvs.hvw;
    if (localbbx != null) {
      return localbbx.DLO;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */