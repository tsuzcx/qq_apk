package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class ad$9
  implements n.b
{
  ad$9(ad paramad) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(19384);
    try
    {
      if (!aw.RG())
      {
        ab.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(19384);
        return;
      }
      if ((paramObject instanceof String)) {
        aw.RO().o(new ad.9.1(this, paramObject), 2000L);
      }
      AppMethodBeat.o(19384);
      return;
    }
    catch (Exception paramn)
    {
      ab.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramn.getMessage() });
      AppMethodBeat.o(19384);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9
 * JD-Core Version:    0.7.0.1
 */