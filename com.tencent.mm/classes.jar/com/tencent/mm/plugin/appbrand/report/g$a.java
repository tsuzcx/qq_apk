package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;

public final class g$a
  extends com.tencent.mm.plugin.appbrand.utils.i
  implements a
{
  private d cBE;
  private Application nGZ;
  
  private g$a(d paramd)
  {
    AppMethodBeat.i(48044);
    this.cBE = paramd;
    this.cBE.keep(this);
    this.nGZ = ((Application)paramd.mContext.getApplicationContext());
    this.nGZ.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.nGZ.unregisterComponentCallbacks(this);
    this.cBE = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.cBE == null)
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
      if (this.cBE.ON() != null) {
        i.v(this.cBE.ON().NA(), paramInt);
      }
      if (paramInt == 5)
      {
        d locald = this.cBE;
        Log.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { locald.mAppId, Boolean.valueOf(locald.mInitialized), Integer.valueOf(paramInt) });
        if (locald.mInitialized)
        {
          HashMap localHashMap = new HashMap();
          localHashMap.put("level", Integer.valueOf(paramInt));
          new v().g(locald.NY()).K(localHashMap).bEo();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g.a
 * JD-Core Version:    0.7.0.1
 */