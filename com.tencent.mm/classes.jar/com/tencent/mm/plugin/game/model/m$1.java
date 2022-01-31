package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.p;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

final class m$1
  implements Runnable
{
  m$1(m paramm, com.tencent.mm.ai.m paramm1) {}
  
  public final void run()
  {
    AppMethodBeat.i(111281);
    m.a(this.nmO, m.a(this.nmO) + m.access$100());
    Object localObject = (bxn)((au)this.ckS).lFp.fsW.fta;
    if (localObject == null) {
      ab.e("MicroMsg.NetSceneSearchGameList", "resp == null");
    }
    for (localObject = null;; localObject = ((bxn)localObject).niO)
    {
      localObject = new h((String)localObject);
      ((h)localObject).bGg();
      m.aWC().add(localObject);
      int i = ((g)localObject).nmB.optInt("remainingCount");
      ab.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break;
      }
      com.tencent.mm.kernel.g.Rc().a(new au(m.a(this.nmO), m.access$100()), 0);
      AppMethodBeat.o(111281);
      return;
    }
    m.b(this.nmO);
    e.bGa();
    localObject = m.aWC();
    if (!bo.es((List)localObject)) {
      com.tencent.mm.kernel.g.RO().ac(new h.1((LinkedList)localObject));
    }
    AppMethodBeat.o(111281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m.1
 * JD-Core Version:    0.7.0.1
 */