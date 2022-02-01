package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;

public final class ap
  implements n.a
{
  private static n rtU = null;
  private static ap rtV = null;
  public int dtc;
  public int duration;
  public String path;
  
  public static ap cvH()
  {
    AppMethodBeat.i(103489);
    if (rtV == null) {
      rtV = new ap();
    }
    ap localap = rtV;
    AppMethodBeat.o(103489);
    return localap;
  }
  
  public static n cvJ()
  {
    return rtU;
  }
  
  public final void cvI()
  {
    AppMethodBeat.i(103490);
    if (rtU == null) {
      rtU = new n();
    }
    rtU.a(this);
    rtU.rtp = true;
    n localn = rtU;
    if (n.pyv == null) {
      n.pyv = new SensorController(aj.getContext());
    }
    if (localn.pyu == null) {
      localn.pyu = new bk(aj.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(103491);
    ad.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bt.bI(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new nk();
      paramString.dBv.dBq = localBundle;
      paramString.dBv.type = 4;
      a.IbL.l(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    rtU.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    nk localnk = new nk();
    localnk.dBv.dBq = localBundle;
    localnk.dBv.type = 4;
    a.IbL.l(localnk);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    rtU.cve();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    nk localnk = new nk();
    localnk.dBv.dBq = localBundle;
    localnk.dBv.type = 4;
    a.IbL.l(localnk);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */