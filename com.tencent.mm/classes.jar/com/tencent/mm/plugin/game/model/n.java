package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  implements com.tencent.mm.ak.i
{
  private static MMHandler handler;
  private static boolean isRunning;
  private static int xER;
  private static LinkedList<i> xES;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    xER = 20;
    isRunning = false;
    xES = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void dVk()
  {
    AppMethodBeat.i(41447);
    isRunning = false;
    handler.quit();
    g.azz().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.dUY())
    {
      Log.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(41445);
      return;
    }
    if (isRunning)
    {
      Log.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(41445);
      return;
    }
    handler = new MMHandler("GameListUpdate");
    xES.clear();
    n localn = new n();
    g.azz().a(1215, localn);
    g.azz().a(new at(localn.offset, xER), 0);
    isRunning = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      dVk();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.a(n.this) + n.xER);
        Object localObject = (dsd)((at)paramq).hhm.iLL.iLR;
        if (localObject == null) {
          Log.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((dsd)localObject).xuE)
        {
          localObject = new i((String)localObject);
          ((i)localObject).dVh();
          n.cmg().add(localObject);
          int i = ((h)localObject).xEH.optInt("remainingCount");
          Log.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          g.azz().a(new at(n.a(n.this), n.xER), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.dUZ();
        localObject = n.cmg();
        if (!Util.isNullOrNil((List)localObject)) {
          g.aAk().postToWorker(new i.1((LinkedList)localObject));
        }
        AppMethodBeat.o(41444);
      }
    });
    AppMethodBeat.o(41446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */