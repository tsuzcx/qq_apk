package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  implements f
{
  private static aq handler;
  private static boolean isRunning;
  private static LinkedList<i> umA;
  private static int umz;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    umz = 20;
    isRunning = false;
    umA = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void dbD()
  {
    AppMethodBeat.i(41447);
    isRunning = false;
    handler.quit();
    g.ajj().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.dbr())
    {
      ae.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(41445);
      return;
    }
    if (isRunning)
    {
      ae.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(41445);
      return;
    }
    handler = new aq("GameListUpdate");
    umA.clear();
    n localn = new n();
    g.ajj().a(1215, localn);
    g.ajj().a(new at(localn.offset, umz), 0);
    isRunning = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      dbD();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.a(n.this) + n.umz);
        Object localObject = (czc)((at)paramn).gux.hQE.hQJ;
        if (localObject == null) {
          ae.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((czc)localObject).ucQ)
        {
          localObject = new i((String)localObject);
          ((i)localObject).dbA();
          n.bPa().add(localObject);
          int i = ((h)localObject).ump.optInt("remainingCount");
          ae.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          g.ajj().a(new at(n.a(n.this), n.umz), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.dbs();
        localObject = n.bPa();
        if (!bu.ht((List)localObject)) {
          g.ajU().aw(new i.1((LinkedList)localObject));
        }
        AppMethodBeat.o(41444);
      }
    });
    AppMethodBeat.o(41446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */