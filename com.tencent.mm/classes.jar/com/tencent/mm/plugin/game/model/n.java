package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  implements com.tencent.mm.al.g
{
  private static ap handler;
  private static boolean isRunning;
  private static int rVP;
  private static LinkedList<i> rVQ;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    rVP = 20;
    isRunning = false;
    rVQ = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void cDe()
  {
    AppMethodBeat.i(41447);
    isRunning = false;
    handler.quit();
    com.tencent.mm.kernel.g.aeS().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.cCS())
    {
      ad.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(41445);
      return;
    }
    if (isRunning)
    {
      ad.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(41445);
      return;
    }
    handler = new ap("GameListUpdate");
    rVQ.clear();
    n localn = new n();
    com.tencent.mm.kernel.g.aeS().a(1215, localn);
    com.tencent.mm.kernel.g.aeS().a(new at(localn.offset, rVP), 0);
    isRunning = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      cDe();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.a(n.this) + n.rVP);
        Object localObject = (cnr)((at)paramn).fUF.gUT.gUX;
        if (localObject == null) {
          ad.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((cnr)localObject).rNF)
        {
          localObject = new i((String)localObject);
          ((i)localObject).cDb();
          n.bCC().add(localObject);
          int i = ((h)localObject).rVF.optInt("remainingCount");
          ad.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          com.tencent.mm.kernel.g.aeS().a(new at(n.a(n.this), n.rVP), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.cCT();
        localObject = n.bCC();
        if (!bt.gL((List)localObject)) {
          com.tencent.mm.kernel.g.afE().ax(new i.1((LinkedList)localObject));
        }
        AppMethodBeat.o(41444);
      }
    });
    AppMethodBeat.o(41446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */