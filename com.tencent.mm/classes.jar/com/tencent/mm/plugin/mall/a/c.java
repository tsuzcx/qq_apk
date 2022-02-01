package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends com.tencent.mm.ak.c<dil>
{
  public c(long paramLong, dil paramdil)
  {
    AppMethodBeat.i(65989);
    dik localdik = new dik();
    localdik.MMR = ((int)paramLong);
    localdik.MMS = b.bfZ("all_type");
    Object localObject = k.fQy();
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((bf)localObject).fuJ)) {
        localdik.MMT = b.bfZ(((bf)localObject).fuJ);
      }
      if (!Util.isNullOrNil(((bf)localObject).fuK)) {
        localdik.MMU = b.bfZ(((bf)localObject).fuK);
      }
    }
    localObject = (a)g.af(a.class);
    localdik.Llf = 0;
    if (localObject != null) {}
    for (localdik.Llg = 1;; localdik.Llg = 0)
    {
      localdik.MMV = 1;
      localdik.timestamp = System.currentTimeMillis();
      if (paramdil.BaseResponse == null)
      {
        paramdil.BaseResponse = new BaseResponse();
        paramdil.BaseResponse.ErrMsg = new dqi().bhy("");
        paramdil.BaseResponse.Ret = 0;
      }
      localdik.MMW = paramdil;
      paramdil = new d.a();
      paramdil.iLN = localdik;
      paramdil.iLO = new dil();
      paramdil.funcId = 2672;
      paramdil.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramdil.iLP = 0;
      paramdil.respCmdId = 0;
      c(paramdil.aXF());
      Log.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localdik.Llf), Integer.valueOf(localdik.Llg) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */