package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.model.az;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.auv;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

final class e$36
  implements g
{
  e$36(e parame, dw paramdw) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(23268);
    if ((paramn != null) && (paramn.getType() == 543))
    {
      az.aeS().b(543, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.oUU.dgl.dgn = true;
        this.oUU.dgl.dgo = null;
        if (this.oUU.callback != null) {
          this.oUU.callback.run();
        }
        AppMethodBeat.o(23268);
        return;
      }
      ad.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = (z)paramn;
      if ((paramString.fUF == null) || (paramString.fUF.gUT.gUX == null)) {}
      auv localauv;
      for (paramString = null;; paramString = (auu)paramString.fUF.gUT.gUX)
      {
        Iterator localIterator = paramString.Duw.iterator();
        paramInt1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label413;
          }
          localauv = (auv)localIterator.next();
          if (localauv != null)
          {
            paramn = null;
            paramString = null;
            if (localauv.CEX != null)
            {
              paramn = localauv.CEX.mAT;
              paramString = localauv.CEX.CBS;
            }
            if ((localauv.Ret == 0) && (!bt.isNullOrNil(localauv.Ddo))) {
              break;
            }
            ad.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", new Object[] { paramn, Integer.valueOf(localauv.Ret), localauv.Ddo });
          }
        }
      }
      ad.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", new Object[] { paramn, paramString, localauv.Ddo, Integer.valueOf(localauv.Dus) });
      this.oUU.dgl.dgn = true;
      this.oUU.dgl.dgo = localauv.Ddo;
      if (this.oUU.callback == null) {
        break label519;
      }
      this.oUU.callback.run();
      paramInt1 = 1;
    }
    label519:
    for (;;)
    {
      break;
      label413:
      if (paramInt1 == 0)
      {
        this.oUU.dgl.dgn = true;
        this.oUU.dgl.dgo = null;
        if (this.oUU.callback != null) {
          this.oUU.callback.run();
        }
      }
      AppMethodBeat.o(23268);
      return;
      this.oUU.dgl.dgn = true;
      this.oUU.dgl.dgo = null;
      if (this.oUU.callback != null) {
        this.oUU.callback.run();
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