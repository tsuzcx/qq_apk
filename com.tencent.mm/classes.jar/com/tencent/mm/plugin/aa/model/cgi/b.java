package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class b
  extends z<w>
{
  public b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63371);
    c.a locala = new c.a();
    v localv = new v();
    localv.YzL = paramString1;
    localv.YzM = paramString2;
    localv.scene = paramInt;
    locala.otE = localv;
    locala.otF = new w();
    locala.uri = "/cgi-bin/mmpay-bin/newaapayurge";
    locala.funcId = 1644;
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    Log.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(63371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.b
 * JD-Core Version:    0.7.0.1
 */