package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public final class f$a
  extends i
  implements com.tencent.mm.vending.e.a
{
  private d cpk;
  private Application mwb;
  
  private f$a(d paramd)
  {
    AppMethodBeat.i(48044);
    this.cpk = paramd;
    this.cpk.keep(this);
    this.mwb = com.tencent.mm.sdk.f.a.jw(paramd.mContext).getApplication();
    this.mwb.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.mwb.unregisterComponentCallbacks(this);
    this.cpk = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.cpk == null)
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
      if (this.cpk.Fg() != null) {
        h.v(this.cpk.Fg().Ee(), paramInt);
      }
      if (paramInt == 5)
      {
        d locald = this.cpk;
        ae.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { locald.mAppId, Boolean.valueOf(locald.mInitialized), Integer.valueOf(paramInt) });
        if (locald.mInitialized)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("level", Integer.valueOf(paramInt));
          new s().g(locald.Ey()).H(localHashMap).bja();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f.a
 * JD-Core Version:    0.7.0.1
 */