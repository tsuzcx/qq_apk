package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bs;

public final class ap
  implements n.a
{
  private static n qJS = null;
  private static ap qJT = null;
  public int dhE;
  public int duration;
  public String path;
  
  public static ap cqc()
  {
    AppMethodBeat.i(103489);
    if (qJT == null) {
      qJT = new ap();
    }
    ap localap = qJT;
    AppMethodBeat.o(103489);
    return localap;
  }
  
  public static n cqe()
  {
    return qJS;
  }
  
  public final void cqd()
  {
    AppMethodBeat.i(103490);
    if (qJS == null) {
      qJS = new n();
    }
    qJS.a(this);
    qJS.qJo = true;
    n localn = qJS;
    if (n.oUL == null) {
      n.oUL = new SensorController(ai.getContext());
    }
    if (localn.oUK == null) {
      localn.oUK = new bj(ai.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void cu(String paramString, int paramInt)
  {
    AppMethodBeat.i(103491);
    ac.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bs.bG(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new nc();
      paramString.dpI.dpD = localBundle;
      paramString.dpI.type = 4;
      a.GpY.l(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    qJS.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    nc localnc = new nc();
    localnc.dpI.dpD = localBundle;
    localnc.dpI.type = 4;
    a.GpY.l(localnc);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    qJS.cpz();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    nc localnc = new nc();
    localnc.dpI.dpD = localBundle;
    localnc.dpI.type = 4;
    a.GpY.l(localnc);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */