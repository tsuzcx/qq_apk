package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
  extends a<y>
{
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63373);
    b.a locala = new b.a();
    x localx = new x();
    localx.limit = paramInt1;
    localx.offset = paramInt2;
    localx.type = paramInt3;
    locala.hQF = localx;
    locala.hQG = new y();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(63373);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(63372);
    b.a locala = new b.a();
    x localx = new x();
    localx.limit = paramInt1;
    localx.offset = paramInt2;
    localx.type = paramInt3;
    localx.FIP = paramString1;
    localx.FIQ = paramInt4;
    localx.FIR = paramInt5;
    localx.FIS = paramString2;
    locala.hQF = localx;
    locala.hQG = new y();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    ae.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 });
    AppMethodBeat.o(63372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */