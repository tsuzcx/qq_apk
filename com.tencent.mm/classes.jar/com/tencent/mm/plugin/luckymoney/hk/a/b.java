package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class b
  extends com.tencent.mm.wallet_core.model.z<bzz>
{
  public b(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(283824);
    bzy localbzy = new bzy();
    localbzy.ihx = paramString1;
    localbzy.CAf = paramString2;
    localbzy.aaiY = paramString3;
    localbzy.msgType = 1;
    localbzy.aaiZ = paramInt;
    localbzy.KuX = paramString4;
    paramString4 = com.tencent.mm.model.z.bAM();
    paramString4 = ((n)h.ax(n.class)).bzA().JE(paramString4);
    if (paramString4 != null)
    {
      localbzy.province = paramString4.iZJ();
      localbzy.city = paramString4.getCityCode();
    }
    paramString4 = new c.a();
    paramString4.otE = localbzy;
    paramString4.otF = new bzz();
    paramString4.funcId = 4583;
    paramString4.uri = "/cgi-bin/mmpay-bin/foreignhbopen";
    paramString4 = paramString4.bEF();
    paramString4.setIsUserCmd(true);
    c(paramString4);
    Log.i("MicroMsg.CgiHKHbOpen", "nativeUrl: %s, sendId: %s, username: %s", new Object[] { paramString1, paramString2, paramString3 });
    AppMethodBeat.o(283824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.b
 * JD-Core Version:    0.7.0.1
 */