package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpt;
import com.tencent.mm.protocal.protobuf.cpu;

public final class c
  extends a<cpt, cpu>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64875);
    cpt localcpt = new cpt();
    localcpt.duW = paramString1;
    localcpt.GZe = paramString2;
    localcpt.offset = paramInt;
    this.viY = localcpt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */