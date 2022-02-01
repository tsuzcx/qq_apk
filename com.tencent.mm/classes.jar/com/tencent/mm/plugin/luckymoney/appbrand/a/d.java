package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.cro;

public final class d
  extends a<crn, cro>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64877);
    crn localcrn = new crn();
    localcrn.duW = paramString1;
    localcrn.GZe = paramString2;
    this.viY = localcrn;
    AppMethodBeat.o(64877);
  }
  
  public final int getFuncId()
  {
    return 1828;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmbiz-bin/wxahb/receivewxaapphb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.d
 * JD-Core Version:    0.7.0.1
 */