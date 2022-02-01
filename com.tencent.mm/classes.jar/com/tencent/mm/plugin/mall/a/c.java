package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.protocal.protobuf.cks;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  extends com.tencent.mm.ak.c<cks>
{
  public c(long paramLong, cks paramcks)
  {
    AppMethodBeat.i(65989);
    ckr localckr = new ckr();
    localckr.Fyy = ((int)paramLong);
    localckr.Fyz = b.aIw("all_type");
    Object localObject = k.ero();
    if (localObject != null)
    {
      if (!bs.isNullOrNil(((bb)localObject).exV)) {
        localckr.FyA = b.aIw(((bb)localObject).exV);
      }
      if (!bs.isNullOrNil(((bb)localObject).exW)) {
        localckr.FyB = b.aIw(((bb)localObject).exW);
      }
    }
    localObject = (a)g.ab(a.class);
    localckr.EqE = 0;
    if (localObject != null) {}
    for (localckr.EqF = 1;; localckr.EqF = 0)
    {
      localckr.FyC = 1;
      localckr.timestamp = System.currentTimeMillis();
      if (paramcks.BaseResponse == null)
      {
        paramcks.BaseResponse = new BaseResponse();
        paramcks.BaseResponse.ErrMsg = new crm().aJV("");
        paramcks.BaseResponse.Ret = 0;
      }
      localckr.FyD = paramcks;
      paramcks = new b.a();
      paramcks.hvt = localckr;
      paramcks.hvu = new cks();
      paramcks.funcId = 2672;
      paramcks.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramcks.reqCmdId = 0;
      paramcks.respCmdId = 0;
      this.rr = paramcks.aAz();
      ac.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localckr.EqE), Integer.valueOf(localckr.EqF) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */