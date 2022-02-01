package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.protocal.protobuf.evq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class n
  implements com.tencent.mm.am.h
{
  private static int IDd;
  private static LinkedList<i> IDe;
  private static boolean Uz;
  private static MMHandler handler;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    IDd = 20;
    Uz = false;
    IDe = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void fGo()
  {
    AppMethodBeat.i(41447);
    Uz = false;
    handler.quit();
    com.tencent.mm.kernel.h.aZW().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.fGb())
    {
      Log.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(41445);
      return;
    }
    if (Uz)
    {
      Log.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(41445);
      return;
    }
    handler = new MMHandler("GameListUpdate");
    IDe.clear();
    n localn = new n();
    com.tencent.mm.kernel.h.aZW().a(1215, localn);
    com.tencent.mm.kernel.h.aZW().a(new at(localn.offset, IDd), 0);
    Uz = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      fGo();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.IDd);
        Object localObject = (evq)c.c.b(((at)paramp).mtC.otC);
        if (localObject == null) {
          Log.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((evq)localObject).Ide)
        {
          localObject = new i((String)localObject);
          ((i)localObject).fGk();
          n.dcC().add(localObject);
          int i = ((i)localObject).fGl();
          Log.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          com.tencent.mm.kernel.h.aZW().a(new at(n.a(n.this), n.IDd), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.fGc();
        localObject = n.dcC();
        if (!Util.isNullOrNil((List)localObject)) {
          com.tencent.mm.kernel.h.baH().postToWorker(new i.1((LinkedList)localObject));
        }
        AppMethodBeat.o(41444);
      }
    });
    AppMethodBeat.o(41446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */