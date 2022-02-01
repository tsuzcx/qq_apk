package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private final b rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new blz();
    ((b.a)localObject).gUV = new bma();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).funcId = 431;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (blz)this.rr.gUS.gUX;
    ((blz)localObject).Ddo = paramString;
    ((blz)localObject).DJw = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((blz)localObject).DJu = i;
      ((blz)localObject).DJx = new LinkedList();
      ((blz)localObject).DJv = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bt.isNullOrNil(paramList[2])) {
          ((blz)localObject).DJv.add(new cmf().aEE(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<bly> aJd()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((bma)this.rr.gUT.gUX).DJy;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bly localbly = (bly)((Iterator)localObject).next();
        a.aLf().aqn().kY(localbly.mAQ, localbly.Dqd);
      }
    }
    localObject = ((bma)this.rr.gUT.gUX).DJy;
    AppMethodBeat.o(131134);
    return localObject;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131133);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131133);
    return i;
  }
  
  public final int getType()
  {
    return 431;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, final q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131135);
    paramq = (bma)this.rr.gUT.gUX;
    com.tencent.mm.kernel.g.afE().a(new aq.a()
    {
      public final boolean aus()
      {
        AppMethodBeat.i(131130);
        if ((paramq != null) && (paramq.DJy.size() > 0))
        {
          Iterator localIterator = paramq.DJy.iterator();
          while (localIterator.hasNext())
          {
            bly localbly = (bly)localIterator.next();
            if (localbly.mBi == 1)
            {
              i locali = new i();
              locali.username = localbly.mAQ;
              locali.gUg = localbly.CVv;
              locali.gUf = localbly.CVw;
              locali.dtM = -1;
              ad.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aux(), locali.auy() });
              locali.evo = 3;
              locali.ee(true);
              p.auF().b(locali);
            }
          }
        }
        AppMethodBeat.o(131130);
        return true;
      }
      
      public final boolean aut()
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
    });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aj
 * JD-Core Version:    0.7.0.1
 */