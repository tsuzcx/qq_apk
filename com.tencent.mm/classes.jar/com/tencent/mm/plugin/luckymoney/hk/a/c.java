package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class c
  extends com.tencent.mm.wallet_core.model.z<cac>
{
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(283827);
    Object localObject1 = new cab();
    ((cab)localObject1).ihx = paramString1;
    ((cab)localObject1).CAf = paramString2;
    ((cab)localObject1).msgType = 1;
    ((cab)localObject1).aaiZ = paramInt;
    Object localObject2 = com.tencent.mm.model.z.bAM();
    localObject2 = ((n)h.ax(n.class)).bzA().JE((String)localObject2);
    if (localObject2 != null)
    {
      ((cab)localObject1).province = ((au)localObject2).iZJ();
      ((cab)localObject1).city = ((au)localObject2).getCityCode();
    }
    localObject2 = new c.a();
    ((c.a)localObject2).otE = ((a)localObject1);
    ((c.a)localObject2).otF = new cac();
    ((c.a)localObject2).funcId = 4787;
    ((c.a)localObject2).uri = "/cgi-bin/mmpay-bin/foreignhbreceive";
    localObject1 = ((c.a)localObject2).bEF();
    ((com.tencent.mm.am.c)localObject1).setIsUserCmd(true);
    c((com.tencent.mm.am.c)localObject1);
    Log.i("MicroMsg.CgiHKHbReceive", "nativeUrl: %s, sendId: %s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(283827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.c
 * JD-Core Version:    0.7.0.1
 */