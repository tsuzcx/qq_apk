package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.t.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;

public final class d$a
  extends g
  implements a
{
  private b bEZ;
  private Application iFG;
  
  private d$a(b paramb)
  {
    AppMethodBeat.i(132543);
    this.bEZ = paramb;
    this.bEZ.keep(this);
    this.iFG = paramb.getContext().getApplication();
    this.iFG.registerComponentCallbacks(this);
    AppMethodBeat.o(132543);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(132545);
    this.iFG.unregisterComponentCallbacks(this);
    this.bEZ = null;
    AppMethodBeat.o(132545);
  }
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(132544);
    if (this.bEZ == null)
    {
      AppMethodBeat.o(132544);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(132544);
      return;
      e.pt(paramInt);
      b localb = this.bEZ;
      ab.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { localb.mAppId, Boolean.valueOf(localb.mInitialized), Integer.valueOf(paramInt) });
      if (localb.mInitialized)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("level", Integer.valueOf(paramInt));
        new r().i(localb.ws()).w(localHashMap).aBz();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d.a
 * JD-Core Version:    0.7.0.1
 */