package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.plugin.exdevice.j.k;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.List;

final class g$c
  implements Runnable
{
  List<b> ooG;
  
  public g$c(List<b> paramList)
  {
    Object localObject;
    this.ooG = localObject;
  }
  
  public final void run()
  {
    AppMethodBeat.i(23283);
    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
    if ((this.ooG != null) && (this.ooG.size() > 0))
    {
      Iterator localIterator = this.ooG.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b)localIterator.next();
        localObject = new k(((b)localObject).field_brandName, ((b)localObject).field_deviceType, ((b)localObject).field_deviceID, 1);
        u.dGE().a((ai)localObject);
      }
      this.yqO.mHandler.postDelayed(this, 300000L);
    }
    AppMethodBeat.o(23283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.c
 * JD-Core Version:    0.7.0.1
 */