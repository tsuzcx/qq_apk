package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;

final class ae$10
  implements MStorageEx.IOnStorageChange
{
  ae$10(ae paramae) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(23452);
    try
    {
      if (!bh.aHB())
      {
        Log.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(23452);
        return;
      }
      if ((paramObject instanceof String)) {
        bh.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23451);
            String str = (String)paramObject;
            if (ae.cZA().avC(str))
            {
              bh.beI();
              if (!c.bbL().bwd(str)) {
                bh.aGY().a(new h(str, null), 0);
              }
            }
            AppMethodBeat.o(23451);
          }
        }, 2000L);
      }
      AppMethodBeat.o(23452);
      return;
    }
    catch (Exception paramMStorageEx)
    {
      Log.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramMStorageEx.getMessage() });
      AppMethodBeat.o(23452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ae.10
 * JD-Core Version:    0.7.0.1
 */