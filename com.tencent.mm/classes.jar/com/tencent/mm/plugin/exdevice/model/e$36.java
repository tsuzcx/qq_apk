package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.dn;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements f
{
  e$36(e parame, dn paramdn) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm != null) && (paramm.getType() == 543))
    {
      au.Dk().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.juJ.bJV.bJX = true;
        this.juJ.bJV.bJY = null;
        if (this.juJ.bFJ != null) {
          this.juJ.bFJ.run();
        }
      }
    }
    label176:
    label496:
    for (;;)
    {
      return;
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (z)paramm;
      if ((paramString.jvQ == null) || (paramString.jvQ.ecF.ecN == null)) {}
      agm localagm;
      for (paramString = null;; paramString = (agl)paramString.jvQ.ecF.ecN)
      {
        Iterator localIterator = paramString.tee.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label401;
          }
          localagm = (agm)localIterator.next();
          if (localagm != null)
          {
            paramm = null;
            paramString = null;
            if (localagm.sAL != null)
            {
              paramm = localagm.sAL.hQb;
              paramString = localagm.sAL.syI;
            }
            if ((localagm.sze == 0) && (!bk.bl(localagm.sRr))) {
              break;
            }
            y.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramm, Integer.valueOf(localagm.sze), localagm.sRr });
          }
        }
      }
      y.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramm, paramString, localagm.sRr, Integer.valueOf(localagm.tea) });
      this.juJ.bJV.bJX = true;
      this.juJ.bJV.bJY = localagm.sRr;
      if (this.juJ.bFJ != null)
      {
        this.juJ.bFJ.run();
        paramInt1 = 1;
      }
      for (;;)
      {
        break label176;
        if (paramInt1 != 0) {
          break label496;
        }
        this.juJ.bJV.bJX = true;
        this.juJ.bJV.bJY = null;
        if (this.juJ.bFJ == null) {
          break;
        }
        this.juJ.bFJ.run();
        return;
        this.juJ.bJV.bJX = true;
        this.juJ.bJV.bJY = null;
        if (this.juJ.bFJ == null) {
          break;
        }
        this.juJ.bFJ.run();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.36
 * JD-Core Version:    0.7.0.1
 */