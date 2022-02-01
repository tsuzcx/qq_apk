package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements f
{
  e$36(e parame, ea paramea) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23268);
    if ((paramn != null) && (paramn.getType() == 543))
    {
      ba.aiU().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.qbK.dpc.dpe = true;
        this.qbK.dpc.dpf = null;
        if (this.qbK.callback != null) {
          this.qbK.callback.run();
        }
        AppMethodBeat.o(23268);
        return;
      }
      ad.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (z)paramn;
      if ((paramString.grW == null) || (paramString.grW.hNL.hNQ == null)) {}
      bcd localbcd;
      for (paramString = null;; paramString = (bcc)paramString.grW.hNL.hNQ)
      {
        Iterator localIterator = paramString.GyQ.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          localbcd = (bcd)localIterator.next();
          if (localbcd != null)
          {
            paramn = null;
            paramString = null;
            if (localbcd.FCT != null)
            {
              paramn = localbcd.FCT.nDr;
              paramString = localbcd.FCT.FzJ;
            }
            if ((localbcd.Ret == 0) && (!bt.isNullOrNil(localbcd.xbo))) {
              break;
            }
            ad.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramn, Integer.valueOf(localbcd.Ret), localbcd.xbo });
          }
        }
      }
      ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramn, paramString, localbcd.xbo, Integer.valueOf(localbcd.GyM) });
      this.qbK.dpc.dpe = true;
      this.qbK.dpc.dpf = localbcd.xbo;
      if (this.qbK.callback == null) {
        break label519;
      }
      this.qbK.callback.run();
      paramInt1 = 1;
    }
    label519:
    for (;;)
    {
      break;
      label413:
      if (paramInt1 == 0)
      {
        this.qbK.dpc.dpe = true;
        this.qbK.dpc.dpf = null;
        if (this.qbK.callback != null) {
          this.qbK.callback.run();
        }
      }
      AppMethodBeat.o(23268);
      return;
      this.qbK.dpc.dpe = true;
      this.qbK.dpc.dpf = null;
      if (this.qbK.callback != null) {
        this.qbK.callback.run();
      }
      AppMethodBeat.o(23268);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.36
 * JD-Core Version:    0.7.0.1
 */