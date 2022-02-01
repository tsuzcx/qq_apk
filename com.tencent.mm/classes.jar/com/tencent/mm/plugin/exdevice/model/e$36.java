package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.model.bg;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements i
{
  e$36(e parame, ee paramee) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23268);
    if ((paramq != null) && (paramq.getType() == 543))
    {
      bg.azz().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.rzl.dHu.dHw = true;
        this.rzl.dHu.dHx = null;
        if (this.rzl.callback != null) {
          this.rzl.callback.run();
        }
        AppMethodBeat.o(23268);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (z)paramq;
      if ((paramString.hhm == null) || (paramString.hhm.iLL.iLR == null)) {}
      bof localbof;
      for (paramString = null;; paramString = (boe)paramString.hhm.iLL.iLR)
      {
        Iterator localIterator = paramString.LWv.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          localbof = (bof)localIterator.next();
          if (localbof != null)
          {
            paramq = null;
            paramString = null;
            if (localbof.KOZ != null)
            {
              paramq = localbof.KOZ.oTH;
              paramString = localbof.KOZ.KLO;
            }
            if ((localbof.Ret == 0) && (!Util.isNullOrNil(localbof.Bri))) {
              break;
            }
            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramq, Integer.valueOf(localbof.Ret), localbof.Bri });
          }
        }
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramq, paramString, localbof.Bri, Integer.valueOf(localbof.LWr) });
      this.rzl.dHu.dHw = true;
      this.rzl.dHu.dHx = localbof.Bri;
      if (this.rzl.callback == null) {
        break label519;
      }
      this.rzl.callback.run();
      paramInt1 = 1;
    }
    label519:
    for (;;)
    {
      break;
      label413:
      if (paramInt1 == 0)
      {
        this.rzl.dHu.dHw = true;
        this.rzl.dHu.dHx = null;
        if (this.rzl.callback != null) {
          this.rzl.callback.run();
        }
      }
      AppMethodBeat.o(23268);
      return;
      this.rzl.dHu.dHw = true;
      this.rzl.dHu.dHx = null;
      if (this.rzl.callback != null) {
        this.rzl.callback.run();
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