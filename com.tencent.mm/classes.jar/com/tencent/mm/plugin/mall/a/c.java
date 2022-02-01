package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
  extends com.tencent.mm.ak.a<cqm>
{
  public c(long paramLong, cqm paramcqm)
  {
    AppMethodBeat.i(65989);
    cql localcql = new cql();
    localcql.HCd = ((int)paramLong);
    localcql.HCe = b.aPw("all_type");
    Object localObject = k.eIV();
    if (localObject != null)
    {
      if (!bu.isNullOrNil(((bb)localObject).eRf)) {
        localcql.HCf = b.aPw(((bb)localObject).eRf);
      }
      if (!bu.isNullOrNil(((bb)localObject).eRg)) {
        localcql.HCg = b.aPw(((bb)localObject).eRg);
      }
    }
    localObject = (com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class);
    localcql.Gqn = 0;
    if (localObject != null) {}
    for (localcql.Gqo = 1;; localcql.Gqo = 0)
    {
      localcql.HCh = 1;
      localcql.timestamp = System.currentTimeMillis();
      if (paramcqm.BaseResponse == null)
      {
        paramcqm.BaseResponse = new BaseResponse();
        paramcqm.BaseResponse.ErrMsg = new cxn().aQV("");
        paramcqm.BaseResponse.Ret = 0;
      }
      localcql.HCi = paramcqm;
      paramcqm = new b.a();
      paramcqm.hQF = localcql;
      paramcqm.hQG = new cqm();
      paramcqm.funcId = 2672;
      paramcqm.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramcqm.hQH = 0;
      paramcqm.respCmdId = 0;
      c(paramcqm.aDS());
      ae.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localcql.Gqn), Integer.valueOf(localcql.Gqo) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */