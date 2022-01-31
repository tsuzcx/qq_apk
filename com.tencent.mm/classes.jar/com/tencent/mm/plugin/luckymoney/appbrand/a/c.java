package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;

public final class c
  extends a<bqr, bqs>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(41987);
    bqr localbqr = new bqr();
    localbqr.cwc = paramString1;
    localbqr.xxB = paramString2;
    localbqr.offset = paramInt;
    this.oin = localbqr;
    AppMethodBeat.o(41987);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */