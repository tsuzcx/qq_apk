package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;

public enum i
{
  private volatile boolean gXP = false;
  private volatile f<Void> gXQ;
  
  static
  {
    AppMethodBeat.i(129490);
    gXO = new i("INSTANCE");
    gXR = new i[] { gXO };
    AppMethodBeat.o(129490);
  }
  
  private i() {}
  
  public final void awn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(129487);
        if (this.gXP)
        {
          ab.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
          AppMethodBeat.o(129487);
          return;
        }
        if (!com.tencent.mm.kernel.g.RJ().eHg)
        {
          ab.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
          AppMethodBeat.o(129487);
          continue;
        }
        ab.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
      }
      finally {}
      this.gXP = true;
      this.gXQ = com.tencent.mm.cm.g.dTg();
      this.gXQ.i(new i.1(this));
      AppMethodBeat.o(129487);
    }
  }
  
  public final void cleanup()
  {
    try
    {
      AppMethodBeat.i(129488);
      if (this.gXQ != null) {
        this.gXQ.dQo();
      }
      this.gXP = false;
      AppMethodBeat.o(129488);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.i
 * JD-Core Version:    0.7.0.1
 */