package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cfr;

public final class c
  extends a<cfq, cfr>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64875);
    cfq localcfq = new cfq();
    localcfq.dlB = paramString1;
    localcfq.DSY = paramString2;
    localcfq.offset = paramInt;
    this.sYa = localcfq;
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