package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bve;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aj
  extends n
  implements k
{
  private f callback;
  private final b rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bve();
    ((b.a)localObject).hQG = new bvf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).funcId = 431;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bve)this.rr.hQD.hQJ;
    ((bve)localObject).xrf = paramString;
    ((bve)localObject).HhV = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((bve)localObject).HhT = i;
      ((bve)localObject).HhW = new LinkedList();
      ((bve)localObject).HhU = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bu.isNullOrNil(paramList[2])) {
          ((bve)localObject).HhU.add(new cxn().aQV(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<bvd> aTF()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((bvf)this.rr.hQE.hQJ).HhX;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bvd localbvd = (bvd)((Iterator)localObject).next();
        a.aVH().aAh().mb(localbvd.nIJ, localbvd.GNI);
      }
    }
    localObject = ((bvf)this.rr.hQE.hQJ).HhX;
    AppMethodBeat.o(131134);
    return localObject;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131133);
    this.callback = paramf;
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
    paramq = (bvf)this.rr.hQE.hQJ;
    com.tencent.mm.kernel.g.ajU().a(new ar.a()
    {
      public final boolean aEC()
      {
        AppMethodBeat.i(131130);
        if ((paramq != null) && (paramq.HhX.size() > 0))
        {
          Iterator localIterator = paramq.HhX.iterator();
          while (localIterator.hasNext())
          {
            bvd localbvd = (bvd)localIterator.next();
            if (localbvd.nJb == 1)
            {
              i locali = new i();
              locali.username = localbvd.nIJ;
              locali.hPQ = localbvd.GnN;
              locali.hPP = localbvd.GnO;
              locali.dEu = -1;
              ae.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEG(), locali.aEH() });
              locali.eQU = 3;
              locali.eD(true);
              p.aEN().b(locali);
            }
          }
        }
        AppMethodBeat.o(131130);
        return true;
      }
      
      public final boolean aED()
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