package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.aoa;

public final class h
  extends c
{
  public h(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(20790);
    bAR();
    anz localanz = (anz)this.rr.fsV.fta;
    localanz.appId = paramString1;
    localanz.mOs = paramInt;
    localanz.crs = paramString2;
    AppMethodBeat.o(20790);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20789);
    b.a locala = new b.a();
    locala.fsX = new anz();
    locala.fsY = new aoa();
    locala.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
    locala.funcId = 1760;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20789);
  }
  
  public final aeg bAV()
  {
    aoa localaoa = (aoa)this.rr.fsW.fta;
    if (localaoa != null) {
      return localaoa.wlj;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.h
 * JD-Core Version:    0.7.0.1
 */