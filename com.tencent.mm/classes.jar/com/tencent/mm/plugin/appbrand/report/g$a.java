package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;

public final class g$a
  extends k
  implements a
{
  private d cBh;
  private Application qJk;
  
  private g$a(d paramd)
  {
    AppMethodBeat.i(48044);
    this.cBh = paramd;
    this.cBh.keep(this);
    this.qJk = ((Application)paramd.mContext.getApplicationContext());
    this.qJk.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.qJk.unregisterComponentCallbacks(this);
    this.cBh = null;
    AppMethodBeat.o(48046);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.cBh == null)
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
      if (this.cBh.Sk() != null) {
        j.y(this.cBh.Sk().Qv(), paramInt);
      }
      d locald = this.cBh;
      Log.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { locald.mAppId, Boolean.valueOf(locald.mInitialized), Integer.valueOf(paramInt) });
      if (locald.mInitialized)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("level", Integer.valueOf(paramInt));
        new u().i(locald.QW()).D(localHashMap).bPO();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g.a
 * JD-Core Version:    0.7.0.1
 */