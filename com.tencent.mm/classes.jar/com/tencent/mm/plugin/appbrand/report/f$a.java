package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class f$a
  extends com.tencent.mm.plugin.appbrand.utils.h
  implements com.tencent.mm.vending.e.a
{
  private c cpg;
  private Application mrd;
  
  private f$a(c paramc)
  {
    AppMethodBeat.i(48044);
    this.cpg = paramc;
    this.cpg.keep(this);
    this.mrd = com.tencent.mm.sdk.f.a.jq(paramc.mContext).getApplication();
    this.mrd.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.mrd.unregisterComponentCallbacks(this);
    this.cpg = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.cpg == null)
    {
      AppMethodBeat.o(48045);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48045);
      return;
      if (this.cpg.Fb() != null) {
        h.u(this.cpg.Fb().Eb(), paramInt);
      }
      if (paramInt == 5)
      {
        c localc = this.cpg;
        ad.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { localc.mAppId, Boolean.valueOf(localc.mInitialized), Integer.valueOf(paramInt) });
        if (localc.mInitialized)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("level", Integer.valueOf(paramInt));
          new s().g(localc.Ew()).A(localHashMap).bir();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f.a
 * JD-Core Version:    0.7.0.1
 */