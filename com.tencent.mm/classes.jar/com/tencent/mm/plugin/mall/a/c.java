package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  extends com.tencent.mm.al.c<cfp>
{
  public c(long paramLong, cfp paramcfp)
  {
    AppMethodBeat.i(65989);
    cfo localcfo = new cfo();
    localcfo.EbD = ((int)paramLong);
    localcfo.EbE = b.aDf("all_type");
    Object localObject = k.ebS();
    if (localObject != null)
    {
      if (!bt.isNullOrNil(((az)localObject).evz)) {
        localcfo.EbF = b.aDf(((az)localObject).evz);
      }
      if (!bt.isNullOrNil(((az)localObject).evA)) {
        localcfo.EbG = b.aDf(((az)localObject).evA);
      }
    }
    localObject = (a)g.ab(a.class);
    localcfo.CXV = 0;
    if (localObject != null) {}
    for (localcfo.CXW = 1;; localcfo.CXW = 0)
    {
      localcfo.EbH = 1;
      localcfo.timestamp = System.currentTimeMillis();
      if (paramcfp.BaseResponse == null)
      {
        paramcfp.BaseResponse = new BaseResponse();
        paramcfp.BaseResponse.ErrMsg = new cmf().aEE("");
        paramcfp.BaseResponse.Ret = 0;
      }
      localcfo.EbI = paramcfp;
      paramcfp = new b.a();
      paramcfp.gUU = localcfo;
      paramcfp.gUV = new cfp();
      paramcfp.funcId = 2672;
      paramcfp.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramcfp.reqCmdId = 0;
      paramcfp.respCmdId = 0;
      this.rr = paramcfp.atI();
      ad.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localcfo.CXV), Integer.valueOf(localcfo.CXW) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */