package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adt;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class aj
  implements h
{
  IListener lsH;
  
  public aj()
  {
    AppMethodBeat.i(23477);
    this.lsH = new WearHardDeviceLogic.1(this, f.hfK);
    this.lsH.alive();
    AppMethodBeat.o(23477);
  }
  
  private static void bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23479);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    adt localadt = new adt();
    localadt.iie.hAf = 8;
    localadt.iie.isSuccess = paramBoolean;
    localadt.iie.hEl = paramString;
    localadt.publish();
    AppMethodBeat.o(23479);
  }
  
  private static void bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(23480);
    Log.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    adt localadt = new adt();
    localadt.iie.hAf = 5;
    localadt.iie.isSuccess = paramBoolean;
    localadt.iie.hEl = paramString;
    localadt.publish();
    AppMethodBeat.o(23480);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(23478);
    if ((paramp instanceof u))
    {
      bh.aZW().b(541, this);
      paramString = (u)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bh(paramString.ysc, true);
        AppMethodBeat.o(23478);
        return;
      }
      bh(paramString.ysc, false);
      AppMethodBeat.o(23478);
      return;
    }
    if ((paramp instanceof z))
    {
      bh.aZW().b(538, this);
      paramString = (z)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bi(paramString.yse, true);
        AppMethodBeat.o(23478);
        return;
      }
      bi(paramString.yse, false);
    }
    AppMethodBeat.o(23478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.aj
 * JD-Core Version:    0.7.0.1
 */