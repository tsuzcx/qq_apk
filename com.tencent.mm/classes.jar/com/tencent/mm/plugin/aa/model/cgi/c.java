package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends com.tencent.mm.ak.c<aa>
{
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63373);
    d.a locala = new d.a();
    z localz = new z();
    localz.limit = paramInt1;
    localz.offset = paramInt2;
    localz.type = paramInt3;
    locala.iLN = localz;
    locala.iLO = new aa();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(63373);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(63372);
    d.a locala = new d.a();
    z localz = new z();
    localz.limit = paramInt1;
    localz.offset = paramInt2;
    localz.type = paramInt3;
    localz.KCg = paramString1;
    localz.KCh = paramInt4;
    localz.KCi = paramInt5;
    localz.KCj = paramString2;
    locala.iLN = localz;
    locala.iLO = new aa();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 });
    AppMethodBeat.o(63372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */