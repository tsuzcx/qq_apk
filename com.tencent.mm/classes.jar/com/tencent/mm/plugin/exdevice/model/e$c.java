package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class e$c
  implements Runnable
{
  List<b> dYN;
  
  public e$c(List<b> paramList)
  {
    Object localObject;
    this.dYN = localObject;
  }
  
  public final void run()
  {
    y.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
    if ((this.dYN != null) && (this.dYN.size() > 0))
    {
      Iterator localIterator = this.dYN.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b)localIterator.next();
        localObject = new k(((b)localObject).field_brandName, ((b)localObject).field_deviceType, ((b)localObject).field_deviceID, 1);
        u.aMn().a((ae)localObject);
      }
      this.juI.mHandler.postDelayed(this, 300000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.c
 * JD-Core Version:    0.7.0.1
 */