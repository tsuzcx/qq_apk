package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.ew;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

final class g$1
  implements h
{
  g$1(g paramg, ew paramew) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(274669);
    if ((paramp != null) && (paramp.getType() == 543))
    {
      bh.aZW().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.yqP.hEY.hFa = true;
        this.yqP.hEY.hFb = null;
        if (this.yqP.callback != null) {
          this.yqP.callback.run();
        }
        AppMethodBeat.o(274669);
        return;
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (ad)paramp;
      if ((paramString.mtC == null) || (c.c.b(paramString.mtC.otC) == null)) {}
      ckw localckw;
      for (paramString = null;; paramString = (ckv)c.c.b(paramString.mtC.otC))
      {
        Iterator localIterator = paramString.aasW.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label411;
          }
          localckw = (ckw)localIterator.next();
          if (localckw != null)
          {
            paramp = null;
            paramString = null;
            if (localckw.YNl != null)
            {
              paramp = localckw.YNl.vgV;
              paramString = localckw.YNl.YJY;
            }
            if ((localckw.Idd == 0) && (!Util.isNullOrNil(localckw.Njp))) {
              break;
            }
            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramp, Integer.valueOf(localckw.Idd), localckw.Njp });
          }
        }
      }
      Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramp, paramString, localckw.Njp, Integer.valueOf(localckw.aasS) });
      this.yqP.hEY.hFa = true;
      this.yqP.hEY.hFb = localckw.Njp;
      if (this.yqP.callback == null) {
        break label515;
      }
      this.yqP.callback.run();
      paramInt1 = 1;
    }
    label515:
    for (;;)
    {
      break;
      label411:
      if (paramInt1 == 0)
      {
        this.yqP.hEY.hFa = true;
        this.yqP.hEY.hFb = null;
        if (this.yqP.callback != null) {
          this.yqP.callback.run();
        }
      }
      AppMethodBeat.o(274669);
      return;
      this.yqP.hEY.hFa = true;
      this.yqP.hEY.hFb = null;
      if (this.yqP.callback != null) {
        this.yqP.callback.run();
      }
      AppMethodBeat.o(274669);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.1
 * JD-Core Version:    0.7.0.1
 */