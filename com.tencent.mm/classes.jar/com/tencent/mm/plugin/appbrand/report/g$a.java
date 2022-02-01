package com.tencent.mm.plugin.appbrand.report;

import android.app.Application;
import android.content.Context;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;

public final class g$a
  extends o
  implements a
{
  private d etN;
  private Application tNN;
  
  private g$a(d paramd)
  {
    AppMethodBeat.i(48044);
    this.etN = paramd;
    this.etN.keep(this);
    this.tNN = ((Application)paramd.mContext.getApplicationContext());
    this.tNN.registerComponentCallbacks(this);
    AppMethodBeat.o(48044);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(48046);
    this.tNN.unregisterComponentCallbacks(this);
    this.etN = null;
    AppMethodBeat.o(48046);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(48045);
    if (this.etN == null)
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
      if (this.etN.asA() != null) {
        j.w(this.etN.asA().aqJ(), paramInt);
      }
      d locald = this.etN;
      Log.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { locald.mAppId, Boolean.valueOf(locald.mInitialized), Integer.valueOf(paramInt) });
      if (locald.mInitialized)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("level", Integer.valueOf(paramInt));
        new w().h(locald.ari()).K(localHashMap).cpV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.g.a
 * JD-Core Version:    0.7.0.1
 */