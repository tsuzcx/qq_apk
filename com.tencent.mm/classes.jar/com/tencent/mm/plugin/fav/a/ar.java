package com.tencent.mm.plugin.fav.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ShakeManager;
import com.tencent.mm.sdk.platformtools.Util;

public final class ar
  implements o.a
{
  private static o Aee = null;
  private static ar Aef = null;
  public int duration;
  public int hIY;
  public String path;
  
  public static ar dRe()
  {
    AppMethodBeat.i(103489);
    if (Aef == null) {
      Aef = new ar();
    }
    ar localar = Aef;
    AppMethodBeat.o(103489);
    return localar;
  }
  
  public static o dRg()
  {
    return Aee;
  }
  
  public final void dRf()
  {
    AppMethodBeat.i(103490);
    if (Aee == null) {
      Aee = new o();
    }
    Aee.a(this);
    Aee.Adv = true;
    o localo = Aee;
    if (o.xCV == null) {
      o.xCV = new SensorController(MMApplicationContext.getContext());
    }
    if (localo.xCU == null) {
      localo.xCU = new ShakeManager(MMApplicationContext.getContext());
    }
    AppMethodBeat.o(103490);
  }
  
  public final void es(String paramString, int paramInt)
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
      paramString = new qm();
      paramString.hTJ.hTF = localBundle;
      paramString.hTJ.type = 4;
      paramString.publish();
      AppMethodBeat.o(103491);
      return;
      localBundle.putBoolean("result", false);
    }
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(103492);
    Aee.stopPlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 2);
    qm localqm = new qm();
    localqm.hTJ.hTF = localBundle;
    localqm.hTJ.type = 4;
    localqm.publish();
    AppMethodBeat.o(103492);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(103493);
    Aee.pausePlay();
    Bundle localBundle = new Bundle();
    localBundle.putInt("actionCode", 3);
    qm localqm = new qm();
    localqm.hTJ.hTF = localBundle;
    localqm.hTJ.type = 4;
    localqm.publish();
    AppMethodBeat.o(103493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ar
 * JD-Core Version:    0.7.0.1
 */