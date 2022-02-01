package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.bgr;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24860);
    cUl();
    bgq localbgq = (bgq)this.rr.hQD.hQJ;
    localbgq.appId = paramString1;
    localbgq.tBw = paramInt;
    localbgq.dqk = paramString2;
    AppMethodBeat.o(24860);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24859);
    b.a locala = new b.a();
    locala.hQF = new bgq();
    locala.hQG = new bgr();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24859);
  }
  
  public final aui cUp()
  {
    bgr localbgr = (bgr)this.rr.hQE.hQJ;
    if (localbgr != null) {
      return localbgr.FJr;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */