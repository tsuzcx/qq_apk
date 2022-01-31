package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a<anu>
{
  public b(int paramInt)
  {
    AppMethodBeat.i(43093);
    ant localant = new ant();
    localant.wuB = paramInt;
    localant.wuC = 0;
    localant.xdW = 1;
    b.a locala = new b.a();
    locala.fsX = localant;
    locala.fsY = new anu();
    locala.funcId = 2680;
    locala.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(43093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.b
 * JD-Core Version:    0.7.0.1
 */