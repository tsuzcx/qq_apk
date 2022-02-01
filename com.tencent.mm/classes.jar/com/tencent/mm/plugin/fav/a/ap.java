package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class ap
  implements n.a
{
  private static n tbL = null;
  private static ap tbM = null;
  public int dLt;
  public int duration;
  public String path;
  
  public static ap cVm()
  {
    AppMethodBeat.i(103489);
    if (tbM == null) {
      tbM = new ap();
    }
    ap localap = tbM;
    AppMethodBeat.o(103489);
    return localap;
  }
  
  public static n cVo()
  {
    return tbL;
  }
  
  public final void cVn()
  {
    AppMethodBeat.i(103490);
    if (tbL == null) {
      tbL = new n();
    }
    tbL.a(this);
    tbL.tbh = true;
    n localn = tbL;
    if (n.qUq == null) {
      n.qUq = new SensorController(MMApplicationContext.getContext());
    }
    if (localn.qUp == null) {
      localn.qUp = new ShakeManager(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(103491);
    Log.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!Util.nullAs(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new od();
      paramString.dUq.dUl = localBundle;
      paramString.dUq.type = 4;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    tbL.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    od localod = new od();
    localod.dUq.dUl = localBundle;
    localod.dUq.type = 4;
    EventCenter.instance.publish(localod);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    tbL.cUJ();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    od localod = new od();
    localod.dUq.dUl = localBundle;
    localod.dUq.type = 4;
    EventCenter.instance.publish(localod);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */