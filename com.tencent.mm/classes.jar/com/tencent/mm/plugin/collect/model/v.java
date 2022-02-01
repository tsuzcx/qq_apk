package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sm.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class v
  extends com.tencent.mm.sdk.b.c<sm>
{
  Dialog iVd;
  
  public v()
  {
    AppMethodBeat.i(160790);
    this.__eventId = sm.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(sm paramsm)
  {
    AppMethodBeat.i(63856);
    ad.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramsm.dGY.type) });
    if ((paramsm.dGY.aWN == null) || (paramsm.dGY.aWN.get() == null))
    {
      ad.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramsm.dGY.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    Context localContext = (Context)paramsm.dGY.aWN.get();
    Object localObject;
    if (paramsm.dGY.type == 0)
    {
      this.iVd = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
      localObject = new k(paramsm.dGY.dHa, paramsm.dGY.scene);
      com.tencent.mm.kernel.g.aiU().a(1800, new v.1(this, paramsm, localContext));
      com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramsm.dGY.type == 1)
      {
        this.iVd = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
        localObject = new com.tencent.mm.plugin.collect.reward.a.c(paramsm.dGY.dHa, paramsm.dGY.scene);
        com.tencent.mm.kernel.g.aiU().a(2811, new v.2(this, paramsm, localContext));
        com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      }
      else
      {
        ad.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramsm.dGY.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */