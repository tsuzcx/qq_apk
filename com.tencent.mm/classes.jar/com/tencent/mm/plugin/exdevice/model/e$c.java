package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;

final class e$c
  implements Runnable
{
  List<b> foQ;
  
  public e$c(List<b> paramList)
  {
    Object localObject;
    this.foQ = localObject;
  }
  
  public final void run()
  {
    AppMethodBeat.i(19215);
    ab.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
    if ((this.foQ != null) && (this.foQ.size() > 0))
    {
      Iterator localIterator = this.foQ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b)localIterator.next();
        localObject = new k(((b)localObject).field_brandName, ((b)localObject).field_deviceType, ((b)localObject).field_deviceID, 1);
        u.bqA().a((ae)localObject);
      }
      this.lEh.mHandler.postDelayed(this, 300000L);
    }
    AppMethodBeat.o(19215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.c
 * JD-Core Version:    0.7.0.1
 */