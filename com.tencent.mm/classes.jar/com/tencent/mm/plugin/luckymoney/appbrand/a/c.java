package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dim;
import com.tencent.mm.protocal.protobuf.din;

public final class c
  extends a<dim, din>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(64875);
    dim localdim = new dim();
    localdim.dNI = paramString1;
    localdim.MBB = paramString2;
    localdim.offset = paramInt;
    this.yPr = localdim;
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