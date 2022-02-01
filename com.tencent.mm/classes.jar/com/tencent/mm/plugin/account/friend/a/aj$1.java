package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import java.util.Iterator;
import java.util.LinkedList;

final class aj$1
  implements MMHandlerThread.IWaitWorkThread
{
  aj$1(aj paramaj, cim paramcim) {}
  
  public final boolean doInBackground()
  {
    AppMethodBeat.i(131130);
    if ((this.kfy != null) && (this.kfy.Mnz.size() > 0))
    {
      Iterator localIterator = this.kfy.Mnz.iterator();
      while (localIterator.hasNext())
      {
        cik localcik = (cik)localIterator.next();
        if (localcik.oTW == 1)
        {
          i locali = new i();
          locali.username = localcik.UserName;
          locali.iKX = localcik.Lir;
          locali.iKW = localcik.Lis;
          locali.cSx = -1;
          Log.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aYt(), locali.aYu() });
          locali.fuz = 3;
          locali.fv(true);
          p.aYB().b(locali);
        }
      }
    }
    AppMethodBeat.o(131130);
    return true;
  }
  
  public final boolean onPostExecute()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(131131);
    String str = super.toString() + "|onGYNetEnd";
    AppMethodBeat.o(131131);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj.1
 * JD-Core Version:    0.7.0.1
 */