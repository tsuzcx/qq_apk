package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.protocal.c.auc;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class ag$1
  implements ai.a
{
  ag$1(ag paramag, aue paramaue) {}
  
  public final boolean JS()
  {
    if ((this.fgH != null) && (this.fgH.tpF.size() > 0))
    {
      Iterator localIterator = this.fgH.tpF.iterator();
      while (localIterator.hasNext())
      {
        auc localauc = (auc)localIterator.next();
        if (localauc.hQq == 1)
        {
          h localh = new h();
          localh.username = localauc.hPY;
          localh.ebT = localauc.sLD;
          localh.ebS = localauc.sLE;
          localh.bcw = -1;
          y.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.JX(), localh.JY() });
          localh.cCq = 3;
          localh.bK(true);
          o.Kh().a(localh);
        }
      }
    }
    return true;
  }
  
  public final boolean JT()
  {
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|onGYNetEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag.1
 * JD-Core Version:    0.7.0.1
 */