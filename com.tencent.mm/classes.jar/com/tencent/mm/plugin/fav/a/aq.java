package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class aq
  implements o.a
{
  private static o wHQ = null;
  private static aq wHR = null;
  public int duration;
  public int fEi;
  public String path;
  
  public static aq dks()
  {
    AppMethodBeat.i(103489);
    if (wHR == null) {
      wHR = new aq();
    }
    aq localaq = wHR;
    AppMethodBeat.o(103489);
    return localaq;
  }
  
  public static o dku()
  {
    return wHQ;
  }
  
  public final void dO(String paramString, int paramInt)
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
      paramString = new pa();
      paramString.fNS.fNN = localBundle;
      paramString.fNS.type = 4;
      EventCenter.instance.publish(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void dkt()
  {
    AppMethodBeat.i(103490);
    if (wHQ == null) {
      wHQ = new o();
    }
    wHQ.a(this);
    wHQ.wHm = true;
    o localo = wHQ;
    if (o.uww == null) {
      o.uww = new SensorController(MMApplicationContext.getContext());
    }
    if (localo.uwv == null) {
      localo.uwv = new ShakeManager(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    wHQ.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    pa localpa = new pa();
    localpa.fNS.fNN = localBundle;
    localpa.fNS.type = 4;
    EventCenter.instance.publish(localpa);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    wHQ.djP();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    pa localpa = new pa();
    localpa.fNS.fNN = localBundle;
    localpa.fNS.type = 4;
    EventCenter.instance.publish(localpa);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.aq
 * JD-Core Version:    0.7.0.1
 */