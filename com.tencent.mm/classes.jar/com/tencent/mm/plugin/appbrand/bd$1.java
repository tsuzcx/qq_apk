package com.tencent.mm.plugin.appbrand;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.sdk.platformtools.Log;

public final class bd$1
  extends k.c
{
  public bd$1(String paramString, t paramt) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180179);
    Log.i("MicroMsg.SinglePageModeLogic", "onDestroy appid:%s", new Object[] { this.nzB });
    k.b(this.nzB, this);
    t localt = this.nsw;
    String str = localt.mAppId;
    int i = localt.bDx().nYS;
    h.ZvG.d(new bd.2(str, i), "SinglePageMode#cleanData");
    AppMethodBeat.o(180179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bd.1
 * JD-Core Version:    0.7.0.1
 */