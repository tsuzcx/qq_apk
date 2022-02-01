package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;

public final class ap
  implements n.a
{
  private static n rCg = null;
  private static ap rCh = null;
  public int dui;
  public int duration;
  public String path;
  
  public static ap cxi()
  {
    AppMethodBeat.i(103489);
    if (rCh == null) {
      rCh = new ap();
    }
    ap localap = rCh;
    AppMethodBeat.o(103489);
    return localap;
  }
  
  public static n cxk()
  {
    return rCg;
  }
  
  public final void cB(String paramString, int paramInt)
  {
    AppMethodBeat.i(103491);
    ae.d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", new Object[] { this.path, Integer.valueOf(this.duration), paramString });
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 1);
    if (!bu.bI(paramString, "").equals(this.path)) {
      localBundle.putBoolean("result", true);
    }
    for (;;)
    {
      localBundle.putInt("position", paramInt);
      paramString = new nl();
      paramString.dCA.dCv = localBundle;
      paramString.dCA.type = 4;
      a.IvT.l(paramString);
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void cxj()
  {
    AppMethodBeat.i(103490);
    if (rCg == null) {
      rCg = new n();
    }
    rCg.a(this);
    rCg.rBC = true;
    n localn = rCg;
    if (n.pEZ == null) {
      n.pEZ = new SensorController(ak.getContext());
    }
    if (localn.pEY == null) {
      localn.pEY = new bl(ak.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    rCg.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    nl localnl = new nl();
    localnl.dCA.dCv = localBundle;
    localnl.dCA.type = 4;
    a.IvT.l(localnl);
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    rCg.cwF();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    nl localnl = new nl();
    localnl.dCA.dCv = localBundle;
    localnl.dCA.type = 4;
    a.IvT.l(localnl);
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ap
 * JD-Core Version:    0.7.0.1
 */