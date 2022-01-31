package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import java.util.Iterator;
import java.util.LinkedList;

final class ag$1
  implements al.a
{
  ag$1(ag paramag, bak parambak) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(108469);
    if ((this.gyp != null) && (this.gyp.xpC.size() > 0))
    {
      Iterator localIterator = this.gyp.xpC.iterator();
      while (localIterator.hasNext())
      {
        bai localbai = (bai)localIterator.next();
        if (localbai.jJS == 1)
        {
          h localh = new h();
          localh.username = localbai.jJA;
          localh.fsl = localbai.wJq;
          localh.fsk = localbai.wJr;
          localh.bsY = -1;
          ab.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.acX(), localh.acY() });
          localh.dqB = 3;
          localh.cM(true);
          o.adg().b(localh);
        }
      }
    }
    AppMethodBeat.o(108469);
    return true;
  }
  
  public final boolean acT()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(108470);
    String str = super.toString() + "|onGYNetEnd";
    AppMethodBeat.o(108470);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ag.1
 * JD-Core Version:    0.7.0.1
 */