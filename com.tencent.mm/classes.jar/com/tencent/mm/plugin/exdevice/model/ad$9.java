package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;

final class ad$9
  implements MStorageEx.IOnStorageChange
{
  ad$9(ad paramad) {}
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(23452);
    try
    {
      if (!bg.aAc())
      {
        Log.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(23452);
        return;
      }
      if ((paramObject instanceof String)) {
        bg.aAk().postToWorkerDelayed(new ad.9.1(this, paramObject), 2000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9
 * JD-Core Version:    0.7.0.1
 */