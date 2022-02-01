package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.emt;
import com.tencent.mm.protocal.protobuf.emu;

public final class d
  extends a<emt, emu>
{
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64877);
    emt localemt = new emt();
    localemt.appid = paramString1;
    localemt.abdB = paramString2;
    a(localemt);
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