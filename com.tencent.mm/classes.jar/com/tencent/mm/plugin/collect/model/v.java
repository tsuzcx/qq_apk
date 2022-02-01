package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.h;
import java.lang.ref.WeakReference;

public final class v
  extends IListener<tk>
{
  private Dialog jUV;
  
  public v()
  {
    AppMethodBeat.i(160790);
    this.__eventId = tk.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(tk paramtk)
  {
    AppMethodBeat.i(63856);
    Log.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramtk.dZQ.type) });
    if ((paramtk.dZQ.aWF == null) || (paramtk.dZQ.aWF.get() == null))
    {
      Log.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramtk.dZQ.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    Context localContext = (Context)paramtk.dZQ.aWF.get();
    Object localObject;
    if (paramtk.dZQ.type == 0)
    {
      this.jUV = h.a(localContext, false, null);
      localObject = new k(paramtk.dZQ.dZS, paramtk.dZQ.scene);
      g.azz().a(1800, new v.1(this, paramtk, localContext));
      g.azz().a((q)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramtk.dZQ.type == 1)
      {
        this.jUV = h.a(localContext, false, null);
        localObject = new c(paramtk.dZQ.dZS, paramtk.dZQ.scene);
        g.azz().a(2811, new v.2(this, paramtk, localContext));
        g.azz().a((q)localObject, 0);
      }
      else
      {
        Log.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramtk.dZQ.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.v
 * JD-Core Version:    0.7.0.1
 */