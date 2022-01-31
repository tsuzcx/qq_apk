package com.tencent.mm.plugin.game.model;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

public final class m
  implements f
{
  private static boolean isRunning;
  private static int nmL;
  private static LinkedList<h> nmM;
  private static al nmN;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(111286);
    nmL = 20;
    isRunning = false;
    nmM = new LinkedList();
    AppMethodBeat.o(111286);
  }
  
  private void bGl()
  {
    AppMethodBeat.i(111284);
    isRunning = false;
    nmN.oNc.quit();
    g.Rc().b(1215, this);
    AppMethodBeat.o(111284);
  }
  
  public static void update()
  {
    AppMethodBeat.i(111282);
    if (!e.bFZ())
    {
      ab.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(111282);
      return;
    }
    if (isRunning)
    {
      ab.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(111282);
      return;
    }
    nmN = new al("GameListUpdate");
    nmM.clear();
    m localm = new m();
    g.Rc().a(1215, localm);
    g.Rc().a(new au(localm.offset, nmL), 0);
    isRunning = true;
    AppMethodBeat.o(111282);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(111283);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      bGl();
      AppMethodBeat.o(111283);
      return;
    }
    nmN.ac(new m.1(this, paramm));
    AppMethodBeat.o(111283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */