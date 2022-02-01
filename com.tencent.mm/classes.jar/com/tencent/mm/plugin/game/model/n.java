package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.ebz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements com.tencent.mm.an.i
{
  private static int CIS;
  private static LinkedList<i> CIT;
  private static MMHandler handler;
  private static boolean isRunning;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    CIS = 20;
    isRunning = false;
    CIT = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void eys()
  {
    AppMethodBeat.i(41447);
    isRunning = false;
    handler.quit();
    h.aGY().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.eyf())
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
    CIT.clear();
    n localn = new n();
    h.aGY().a(1215, localn);
    h.aGY().a(new at(localn.offset, CIS), 0);
    isRunning = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      eys();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.a(n.this) + n.CIS);
        Object localObject = (ebz)d.c.b(((at)paramq).jTk.lBS);
        if (localObject == null) {
          Log.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((ebz)localObject).CqW)
        {
          localObject = new i((String)localObject);
          ((i)localObject).eyo();
          n.czK().add(localObject);
          int i = ((i)localObject).eyp();
          Log.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          h.aGY().a(new at(n.a(n.this), n.CIS), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.eyg();
        localObject = n.czK();
        if (!Util.isNullOrNil((List)localObject)) {
          h.aHJ().postToWorker(new i.1((LinkedList)localObject));
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