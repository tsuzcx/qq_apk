package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cku;

public final class c
  extends a<ckt, cku>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64875);
    ckt localckt = new ckt();
    localckt.djj = paramString1;
    localckt.Fpu = paramString2;
    localckt.offset = paramInt;
    this.ugo = localckt;
    AppMethodBeat.o(64875);
  }
  
  protected final int getFuncId()
  {
    return 2949;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/querywxaapphbdetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */