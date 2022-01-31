package com.tencent.mm.plugin.appbrand.report;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b$1
  extends e
{
  public b$1(i parami) {}
  
  @SuppressLint({"SwitchIntDef"})
  public final void onTrimMemory(int paramInt)
  {
    if (this.fzd.mFinished)
    {
      ae.getContext().unregisterComponentCallbacks(this);
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    for (;;)
    {
      i locali = this.fzd;
      y.i("MicroMsg.AppBrandOnMemoryWarningReceiveEvent", "memory warning receive event dispatch, appId:%s, initialized:%b, level:%d", new Object[] { locali.mAppId, Boolean.valueOf(locali.dNk), Integer.valueOf(paramInt) });
      if (!locali.dNk) {
        break;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("level", Integer.valueOf(paramInt));
      new o().d(locali.Zy()).o(localHashMap).dispatch();
      return;
      if (paramInt == 10) {
        h.nFQ.a(386L, 8L, 1L, false);
      } else if (paramInt == 15) {
        h.nFQ.a(386L, 7L, 1L, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b.1
 * JD-Core Version:    0.7.0.1
 */