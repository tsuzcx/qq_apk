package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bo;

public final class ao
  implements n.a
{
  private static n muE = null;
  private static ao muF = null;
  public int cve;
  public int duration;
  public String path;
  
  public static ao bxf()
  {
    AppMethodBeat.i(102749);
    if (muF == null) {
      muF = new ao();
    }
    ao localao = muF;
    AppMethodBeat.o(102749);
    return localao;
  }
  
  public static n bxh()
  {
    return muE;
  }
  
  public final void bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(102751);
    ab.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bo.bf(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new lj();
      paramString.cBB.cBw = localBundle;
      paramString.cBB.type = 4;
      a.ymk.l(paramString);
      AppMethodBeat.o(102751);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void bxg()
  {
    AppMethodBeat.i(102750);
    if (muE == null) {
      muE = new n();
    }
    muE.a(this);
    muE.mtZ = true;
    n localn = muE;
    if (n.mub == null) {
      n.mub = new SensorController(ah.getContext());
    }
    if (localn.mtY == null) {
      localn.mtY = new bf(ah.getContext());
    }
    AppMethodBeat.o(102750);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(102752);
    muE.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    lj locallj = new lj();
    locallj.cBB.cBw = localBundle;
    locallj.cBB.type = 4;
    a.ymk.l(locallj);
    AppMethodBeat.o(102752);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(102753);
    muE.bwB();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    lj locallj = new lj();
    locallj.cBB.cBw = localBundle;
    locallj.cBB.type = 4;
    a.ymk.l(locallj);
    AppMethodBeat.o(102753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ao
 * JD-Core Version:    0.7.0.1
 */