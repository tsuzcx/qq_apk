package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends a<bqq>
{
  public c(long paramLong)
  {
    AppMethodBeat.i(43094);
    bqp localbqp = new bqp();
    localbqp.xEF = ((int)paramLong);
    localbqp.xEG = b.ank("all_type");
    Object localObject = m.cTC();
    if (localObject != null)
    {
      if (!bo.isNullOrNil(((aw)localObject).province)) {
        localbqp.xEH = b.ank(((aw)localObject).province);
      }
      if (!bo.isNullOrNil(((aw)localObject).city)) {
        localbqp.xEI = b.ank(((aw)localObject).city);
      }
    }
    localObject = (l)g.E(l.class);
    localbqp.wLD = 0;
    if (localObject != null) {}
    for (localbqp.wLE = 1;; localbqp.wLE = 0)
    {
      localbqp.xEJ = 1;
      localbqp.timestamp = System.currentTimeMillis();
      localObject = new b.a();
      ((b.a)localObject).fsX = localbqp;
      ((b.a)localObject).fsY = new bqq();
      ((b.a)localObject).funcId = 2672;
      ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).ado();
      ab.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localbqp.wLD), Integer.valueOf(localbqp.wLE) });
      AppMethodBeat.o(43094);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */