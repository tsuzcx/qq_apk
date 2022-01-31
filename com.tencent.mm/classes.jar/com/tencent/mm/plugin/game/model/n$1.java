package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

final class n$1
  implements Runnable
{
  n$1(n paramn, m paramm) {}
  
  public final void run()
  {
    n.a(this.kOS, n.a(this.kOS) + n.access$100());
    Object localObject = (bns)((av)this.bEe).jvQ.ecF.ecN;
    if (localObject == null)
    {
      y.e("MicroMsg.NetSceneSearchGameList", "resp == null");
      localObject = null;
      localObject = new i((String)localObject);
      ((i)localObject).aZh();
      n.axF().add(localObject);
      int i = ((h)localObject).kOE.optInt("remainingCount");
      y.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[] { Integer.valueOf(i) });
      if (i <= 0) {
        break label139;
      }
      g.Dk().a(new av(n.a(this.kOS), n.access$100()), 0);
    }
    label139:
    do
    {
      return;
      localObject = ((bns)localObject).sZc;
      break;
      n.b(this.kOS);
      f.aZb();
      localObject = n.axF();
    } while (bk.dk((List)localObject));
    g.DS().O(new i.1((LinkedList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n.1
 * JD-Core Version:    0.7.0.1
 */