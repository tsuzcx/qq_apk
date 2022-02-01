package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.model.bc;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements f
{
  e$36(e parame, eb parameb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23268);
    if ((paramn != null) && (paramn.getType() == 543))
    {
      bc.ajj().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.qip.dqh.dqj = true;
        this.qip.dqh.dqk = null;
        if (this.qip.callback != null) {
          this.qip.callback.run();
        }
        AppMethodBeat.o(23268);
        return;
      }
      ae.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (z)paramn;
      if ((paramString.gux == null) || (paramString.gux.hQE.hQJ == null)) {}
      bct localbct;
      for (paramString = null;; paramString = (bcs)paramString.gux.hQE.hQJ)
      {
        Iterator localIterator = paramString.GSq.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          localbct = (bct)localIterator.next();
          if (localbct != null)
          {
            paramn = null;
            paramString = null;
            if (localbct.FVo != null)
            {
              paramn = localbct.FVo.nIM;
              paramString = localbct.FVo.FSh;
            }
            if ((localbct.Ret == 0) && (!bu.isNullOrNil(localbct.xrf))) {
              break;
            }
            ae.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramn, Integer.valueOf(localbct.Ret), localbct.xrf });
          }
        }
      }
      ae.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramn, paramString, localbct.xrf, Integer.valueOf(localbct.GSm) });
      this.qip.dqh.dqj = true;
      this.qip.dqh.dqk = localbct.xrf;
      if (this.qip.callback == null) {
        break label519;
      }
      this.qip.callback.run();
      paramInt1 = 1;
    }
    label519:
    for (;;)
    {
      break;
      label413:
      if (paramInt1 == 0)
      {
        this.qip.dqh.dqj = true;
        this.qip.dqh.dqk = null;
        if (this.qip.callback != null) {
          this.qip.callback.run();
        }
      }
      AppMethodBeat.o(23268);
      return;
      this.qip.dqh.dqj = true;
      this.qip.dqh.dqk = null;
      if (this.qip.callback != null) {
        this.qip.callback.run();
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