package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  extends a<x>
{
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(40642);
    b.a locala = new b.a();
    w localw = new w();
    localw.limit = paramInt1;
    localw.offset = paramInt2;
    localw.type = paramInt3;
    locala.fsX = localw;
    locala.fsY = new x();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(40642);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(40641);
    b.a locala = new b.a();
    w localw = new w();
    localw.limit = paramInt1;
    localw.offset = paramInt2;
    localw.type = paramInt3;
    localw.wkK = paramString1;
    localw.wkL = paramInt4;
    localw.wkM = paramInt5;
    localw.wkN = paramString2;
    locala.fsX = localw;
    locala.fsY = new x();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ab.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 });
    AppMethodBeat.o(40641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.a.c
 * JD-Core Version:    0.7.0.1
 */