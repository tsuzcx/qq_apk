package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;

public final class ap
  implements n.a
{
  private static n qbm = null;
  private static ap qbn = null;
  public int dkj;
  public int duration;
  public String path;
  
  public static ap civ()
  {
    AppMethodBeat.i(103489);
    if (qbn == null) {
      qbn = new ap();
    }
    ap localap = qbn;
    AppMethodBeat.o(103489);
    return localap;
  }
  
  public static n cix()
  {
    return qbm;
  }
  
  public final void ciw()
  {
    AppMethodBeat.i(103490);
    if (qbm == null) {
      qbm = new n();
    }
    qbm.a(this);
    qbm.qaI = true;
    n localn = qbm;
    if (n.orl == null) {
      n.orl = new SensorController(aj.getContext());
    }
    if (localn.ork == null) {
      localn.ork = new bk(aj.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void cp(String paramString, int paramInt)
  {
    AppMethodBeat.i(103491);
    ad.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bt.by(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new mt();
      paramString.drX.drS = localBundle;
      paramString.drX.type = 4;
      a.ESL.l(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    qbm.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    mt localmt = new mt();
    localmt.drX.drS = localBundle;
    localmt.drX.type = 4;
    a.ESL.l(localmt);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    qbm.chS();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    mt localmt = new mt();
    localmt.drX.drS = localBundle;
    localmt.drX.type = 4;
    a.ESL.l(localmt);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */