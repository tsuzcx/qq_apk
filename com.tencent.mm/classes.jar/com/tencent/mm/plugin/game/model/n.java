package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class n
  implements com.tencent.mm.ak.g
{
  private static ao handler;
  private static boolean isRunning;
  private static int tdH;
  private static LinkedList<i> tdI;
  private int offset = 0;
  
  static
  {
    AppMethodBeat.i(41449);
    tdH = 20;
    isRunning = false;
    tdI = new LinkedList();
    AppMethodBeat.o(41449);
  }
  
  private void cQo()
  {
    AppMethodBeat.i(41447);
    isRunning = false;
    handler.quit();
    com.tencent.mm.kernel.g.agi().b(1215, this);
    AppMethodBeat.o(41447);
  }
  
  public static void update()
  {
    AppMethodBeat.i(41445);
    if (!e.cQc())
    {
      ac.i("MicroMsg.GameListUpdater", "No need to update");
      AppMethodBeat.o(41445);
      return;
    }
    if (isRunning)
    {
      ac.e("MicroMsg.GameListUpdater", "Already running");
      AppMethodBeat.o(41445);
      return;
    }
    handler = new ao("GameListUpdate");
    tdI.clear();
    n localn = new n();
    com.tencent.mm.kernel.g.agi().a(1215, localn);
    com.tencent.mm.kernel.g.agi().a(new at(localn.offset, tdH), 0);
    isRunning = true;
    AppMethodBeat.o(41445);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(41446);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      cQo();
      AppMethodBeat.o(41446);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41444);
        n.a(n.this, n.a(n.this) + n.tdH);
        Object localObject = (csy)((at)paramn).fYA.hvs.hvw;
        if (localObject == null) {
          ac.e("MicroMsg.NetSceneSearchGameList", "resp == null");
        }
        for (localObject = null;; localObject = ((csy)localObject).sVu)
        {
          localObject = new i((String)localObject);
          ((i)localObject).cQl();
          n.bJK().add(localObject);
          int i = ((h)localObject).tdx.optInt("remainingCount");
          ac.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            break;
          }
          com.tencent.mm.kernel.g.agi().a(new at(n.a(n.this), n.tdH), 0);
          AppMethodBeat.o(41444);
          return;
        }
        n.b(n.this);
        e.cQd();
        localObject = n.bJK();
        if (!bs.gY((List)localObject)) {
          com.tencent.mm.kernel.g.agU().az(new i.1((LinkedList)localObject));
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