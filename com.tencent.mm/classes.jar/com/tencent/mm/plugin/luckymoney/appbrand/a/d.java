package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;

public final class d
  extends a<chj, chk>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64877);
    chj localchj = new chj();
    localchj.dlB = paramString1;
    localchj.DSY = paramString2;
    this.sYa = localchj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.d
 * JD-Core Version:    0.7.0.1
 */