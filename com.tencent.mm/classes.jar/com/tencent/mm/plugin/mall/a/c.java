package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends com.tencent.mm.an.c<dsd>
{
  public c(long paramLong, dsd paramdsd)
  {
    AppMethodBeat.i(65989);
    dsc localdsc = new dsc();
    localdsc.TYL = ((int)paramLong);
    localdsc.TYM = b.bss("all_type");
    Object localObject = k.gJe();
    if (localObject != null)
    {
      if (!Util.isNullOrNil(((bd)localObject).province)) {
        localdsc.TYN = b.bss(((bd)localObject).province);
      }
      if (!Util.isNullOrNil(((bd)localObject).city)) {
        localdsc.TYO = b.bss(((bd)localObject).city);
      }
    }
    localObject = (a)h.ae(a.class);
    localdsc.Smo = 0;
    if (localObject != null) {}
    for (localdsc.Smp = 1;; localdsc.Smp = 0)
    {
      localdsc.TYP = 1;
      localdsc.timestamp = System.currentTimeMillis();
      if (paramdsd.BaseResponse == null)
      {
        paramdsd.BaseResponse = new jh();
        paramdsd.BaseResponse.Tef = new eaf().btQ("");
        paramdsd.BaseResponse.CqV = 0;
      }
      localdsc.TYQ = paramdsd;
      paramdsd = new d.a();
      paramdsd.lBU = localdsc;
      paramdsd.lBV = new dsd();
      paramdsd.funcId = 2672;
      paramdsd.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
      paramdsd.lBW = 0;
      paramdsd.respCmdId = 0;
      c(paramdsd.bgN());
      Log.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(localdsc.Smo), Integer.valueOf(localdsc.Smp) });
      AppMethodBeat.o(65989);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.c
 * JD-Core Version:    0.7.0.1
 */