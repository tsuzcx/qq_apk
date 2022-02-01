package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rr.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

public final class v
  extends com.tencent.mm.sdk.b.c<rr>
{
  Dialog ibM;
  
  public v()
  {
    AppMethodBeat.i(160790);
    this.__eventId = rr.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(rr paramrr)
  {
    AppMethodBeat.i(63856);
    ad.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramrr.dxk.type) });
    if ((paramrr.dxk.aLG == null) || (paramrr.dxk.aLG.get() == null))
    {
      ad.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramrr.dxk.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    Context localContext = (Context)paramrr.dxk.aLG.get();
    Object localObject;
    if (paramrr.dxk.type == 0)
    {
      this.ibM = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
      localObject = new k(paramrr.dxk.dxm, paramrr.dxk.scene);
      com.tencent.mm.kernel.g.aeS().a(1800, new v.1(this, paramrr, localContext));
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramrr.dxk.type == 1)
      {
        this.ibM = com.tencent.mm.wallet_core.ui.g.a(localContext, false, null);
        localObject = new com.tencent.mm.plugin.collect.reward.a.c(paramrr.dxk.dxm, paramrr.dxk.scene);
        com.tencent.mm.kernel.g.aeS().a(2811, new v.2(this, paramrr, localContext));
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      }
      else
      {
        ad.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramrr.dxk.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */