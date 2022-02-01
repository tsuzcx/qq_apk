package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends com.tencent.mm.al.a<cps>
{
  public c(long paramLong, cps paramcps)
  {
    AppMethodBeat.i(65989);
    cpr localcpr = new cpr();
    localcpr.HiD = ((int)paramLong);
    localcpr.HiE = b.aNZ("all_type");
    Object localObject = k.eFo();
    if (localObject != null)
    {
      if (!bt.isNullOrNil(((bb)localObject).ePu)) {
        localcpr.HiF = b.aNZ(((bb)localObject).ePu);
      }
      if (!bt.isNullOrNil(((bb)localObject).ePv)) {
        localcpr.HiG = b.aNZ(((bb)localObject).ePv);
      }
    }
    localObject = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    localcpr.FXO = 0;
    if (localObject != null) {}
    for (localcpr.FXP = 1;; localcpr.FXP = 0)
    {
      localcpr.HiH = 1;
      localcpr.timestamp = System.currentTimeMillis();
      if (paramcps.BaseResponse == null)
      {
        paramcps.BaseResponse = new BaseResponse();
        paramcps.BaseResponse.ErrMsg = new cwt().aPy("");
        paramcps.BaseResponse.Ret = 0;
      }
      localcpr.HiI = paramcps;
      paramcps = new b.a();
      paramcps.hNM = localcpr;
      paramcps.hNN = new cps();
      paramcps.funcId = 2672;
      paramcps.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramcps.hNO = 0;
      paramcps.respCmdId = 0;
      c(paramcps.aDC());
      ad.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localcpr.FXO), Integer.valueOf(localcpr.FXP) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */