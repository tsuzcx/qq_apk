package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;

final class ah$2
  implements MStorageEx.IOnStorageChange
{
  ah$2(ah paramah) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(274588);
    try
    {
      if (!bh.baz())
      {
        Log.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(274588);
        return;
      }
      if ((paramObject instanceof String)) {
        bh.baH().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274651);
            String str = (String)paramObject;
            if (ah.dFT().apC(str))
            {
              bh.bCz();
              if (!c.bzA().bxr(str)) {
                bh.aZW().a(new h(str, null), 0);
              }
            }
            AppMethodBeat.o(274651);
          }
        }, 2000L);
      }
      AppMethodBeat.o(274588);
      return;
    }
    catch (Exception paramMStorageEx)
    {
      Log.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramMStorageEx.getMessage() });
      AppMethodBeat.o(274588);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ah.2
 * JD-Core Version:    0.7.0.1
 */