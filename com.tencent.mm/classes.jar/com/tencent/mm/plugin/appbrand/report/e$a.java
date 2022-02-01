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
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public final class e$a
  extends h
  implements com.tencent.mm.vending.e.a
{
  private c ceP;
  private Application lRn;
  
  private e$a(c paramc)
  {
    AppMethodBeat.i(48044);
    this.ceP = paramc;
    this.ceP.keep(this);
    this.lRn = com.tencent.mm.sdk.f.a.jg(paramc.mContext).getApplication();
    this.lRn.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.lRn.unregisterComponentCallbacks(this);
    this.ceP = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.ceP == null)
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
      if (this.ceP.DC() != null) {
        g.v(this.ceP.DC().CC(), paramInt);
      }
      if (paramInt == 5)
      {
        c localc = this.ceP;
        ac.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { localc.mAppId, Boolean.valueOf(localc.mInitialized), Integer.valueOf(paramInt) });
        if (localc.mInitialized)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("level", Integer.valueOf(paramInt));
          new s().g(localc.CX()).A(localHashMap).beN();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e.a
 * JD-Core Version:    0.7.0.1
 */