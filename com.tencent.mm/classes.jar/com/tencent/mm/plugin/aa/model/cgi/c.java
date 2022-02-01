package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class c
  extends z<ab>
{
  public c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(63373);
    c.a locala = new c.a();
    aa localaa = new aa();
    localaa.limit = paramInt1;
    localaa.offset = paramInt2;
    localaa.type = paramInt3;
    locala.otE = localaa;
    locala.otF = new ab();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    AppMethodBeat.o(63373);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(63372);
    c.a locala = new c.a();
    aa localaa = new aa();
    localaa.limit = paramInt1;
    localaa.offset = paramInt2;
    localaa.type = paramInt3;
    localaa.YAA = paramString1;
    localaa.YAB = paramInt4;
    localaa.YAC = paramInt5;
    localaa.YAD = paramString2;
    locala.otE = localaa;
    locala.otF = new ab();
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
    locala.funcId = 1676;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString1, paramString2 });
    AppMethodBeat.o(63372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.c
 * JD-Core Version:    0.7.0.1
 */