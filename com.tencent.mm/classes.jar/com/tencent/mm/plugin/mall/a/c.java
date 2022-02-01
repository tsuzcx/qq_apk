package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.c.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.protocal.protobuf.ekx;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.z;

public final class c
  extends z<eky>
{
  public c(long paramLong, eky parameky)
  {
    AppMethodBeat.i(65989);
    ekx localekx = new ekx();
    localekx.abpI = ((int)paramLong);
    localekx.abpJ = b.bsj("all_type");
    Object localObject = k.iis();
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((bi)localObject).province)) {
        localekx.abpK = b.bsj(((bi)localObject).province);
      }
      if (!Util.isNullOrNil(((bi)localObject).city)) {
        localekx.abpL = b.bsj(((bi)localObject).city);
      }
    }
    localObject = (a)h.ax(a.class);
    if ((localObject != null) && (((a)localObject).isRoot()))
    {
      localekx.ZkA = 1;
      if (localObject == null) {
        break label311;
      }
    }
    label311:
    for (localekx.ZkB = 1;; localekx.ZkB = 0)
    {
      localekx.abpM = 1;
      localekx.timestamp = System.currentTimeMillis();
      if (parameky.BaseResponse == null)
      {
        parameky.BaseResponse = new kd();
        parameky.BaseResponse.akjO = new etl().btH("");
        parameky.BaseResponse.Idd = 0;
      }
      localekx.abpN = parameky;
      parameky = new c.a();
      parameky.otE = localekx;
      parameky.otF = new eky();
      parameky.funcId = 2672;
      parameky.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      parameky.otG = 0;
      parameky.respCmdId = 0;
      c(parameky.bEF());
      Log.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localekx.ZkA), Integer.valueOf(localekx.ZkB) });
      AppMethodBeat.o(65989);
      return;
      localekx.ZkA = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */