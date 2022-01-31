package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.bsg;

public final class d
  extends a<bsf, bsg>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41989);
    bsf localbsf = new bsf();
    localbsf.cwc = paramString1;
    localbsf.xxB = paramString2;
    this.oin = localbsf;
    AppMethodBeat.o(41989);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.d
 * JD-Core Version:    0.7.0.1
 */