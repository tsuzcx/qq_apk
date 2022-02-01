package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.el;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.bvt;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements i
{
  e$36(e parame, el paramel) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(23268);
    if ((paramq != null) && (paramq.getType() == 543))
    {
      bh.aGY().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.veS.fAl.fAn = true;
        this.veS.fAl.fAo = null;
        if (this.veS.callback != null) {
          this.veS.callback.run();
        }
        AppMethodBeat.o(23268);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (aa)paramq;
      if ((paramString.jTk == null) || (d.c.b(paramString.jTk.lBS) == null)) {}
      bvu localbvu;
      for (paramString = null;; paramString = (bvt)d.c.b(paramString.jTk.lBS))
      {
        Iterator localIterator = paramString.TfC.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          localbvu = (bvu)localIterator.next();
          if (localbvu != null)
          {
            paramq = null;
            paramString = null;
            if (localbvu.RPX != null)
            {
              paramq = localbvu.RPX.rVF;
              paramString = localbvu.RPX.RMK;
            }
            if ((localbvu.CqV == 0) && (!Util.isNullOrNil(localbvu.HlB))) {
              break;
            }
            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramq, Integer.valueOf(localbvu.CqV), localbvu.HlB });
          }
        }
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramq, paramString, localbvu.HlB, Integer.valueOf(localbvu.Tfy) });
      this.veS.fAl.fAn = true;
      this.veS.fAl.fAo = localbvu.HlB;
      if (this.veS.callback == null) {
        break label519;
      }
      this.veS.callback.run();
      paramInt1 = 1;
    }
    label519:
    for (;;)
    {
      break;
      label413:
      if (paramInt1 == 0)
      {
        this.veS.fAl.fAn = true;
        this.veS.fAl.fAo = null;
        if (this.veS.callback != null) {
          this.veS.callback.run();
        }
      }
      AppMethodBeat.o(23268);
      return;
      this.veS.fAl.fAn = true;
      this.veS.fAl.fAo = null;
      if (this.veS.callback != null) {
        this.veS.callback.run();
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