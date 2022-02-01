package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<bzx>
{
  public a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283826);
    Object localObject = new bzw();
    ((bzw)localObject).ihx = paramString1;
    ((bzw)localObject).CAf = paramString2;
    ((bzw)localObject).limit = 11;
    ((bzw)localObject).offset = paramInt1;
    ((bzw)localObject).msgType = 1;
    ((bzw)localObject).scene = paramInt2;
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = new bzx();
    locala.funcId = 4889;
    locala.uri = "/cgi-bin/mmpay-bin/foreignhbdetail";
    localObject = locala.bEF();
    ((c)localObject).setIsUserCmd(true);
    c((c)localObject);
    Log.i("MicroMsg.CgiHKHbDetail", "nativeurl: %s, sendid: %s, limit: %s, offset: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(283826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.a
 * JD-Core Version:    0.7.0.1
 */