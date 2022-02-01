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
import com.tencent.mm.plugin.appbrand.utils.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public final class e$a
  extends g
  implements com.tencent.mm.vending.e.a
{
  private c chU;
  private Application lpn;
  
  private e$a(c paramc)
  {
    AppMethodBeat.i(48044);
    this.chU = paramc;
    this.chU.keep(this);
    this.lpn = com.tencent.mm.sdk.f.a.iV(paramc.mContext).getApplication();
    this.lpn.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.lpn.unregisterComponentCallbacks(this);
    this.chU = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.chU == null)
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
      if (this.chU.DZ() != null) {
        h.u(this.chU.DZ().CZ(), paramInt);
      }
      if (paramInt == 5)
      {
        c localc = this.chU;
        ad.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { localc.mAppId, Boolean.valueOf(localc.mInitialized), Integer.valueOf(paramInt) });
        if (localc.mInitialized)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("level", Integer.valueOf(paramInt));
          new s().g(localc.Du()).B(localHashMap).aXQ();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e.a
 * JD-Core Version:    0.7.0.1
 */