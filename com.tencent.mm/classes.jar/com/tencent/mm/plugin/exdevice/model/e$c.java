package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.List;

final class e$c
  implements Runnable
{
  List<b> gQs;
  
  public e$c(List<b> paramList)
  {
    Object localObject;
    this.gQs = localObject;
  }
  
  public final void run()
  {
    AppMethodBeat.i(23283);
    ad.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
    if ((this.gQs != null) && (this.gQs.size() > 0))
    {
      Iterator localIterator = this.gQs.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b)localIterator.next();
        localObject = new k(((b)localObject).field_brandName, ((b)localObject).field_deviceType, ((b)localObject).field_deviceID, 1);
        u.cai().a((ae)localObject);
      }
      this.oUT.mHandler.postDelayed(this, 300000L);
    }
    AppMethodBeat.o(23283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.e.c
 * JD-Core Version:    0.7.0.1
 */