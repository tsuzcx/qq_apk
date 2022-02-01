package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.cwt;
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
  private f callback;
  private final b rr;
  
  public aj(String paramString, List<String[]> paramList)
  {
    AppMethodBeat.i(131132);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new buk();
    ((b.a)localObject).hNN = new bul();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/listmfriend";
    ((b.a)localObject).funcId = 431;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (buk)this.rr.hNK.hNQ;
    ((buk)localObject).xbo = paramString;
    ((buk)localObject).GOv = 0;
    if (paramList == null) {}
    for (;;)
    {
      ((buk)localObject).GOt = i;
      ((buk)localObject).GOw = new LinkedList();
      ((buk)localObject).GOu = new LinkedList();
      if (paramList == null) {
        break;
      }
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (String[])paramString.next();
        if (!bt.isNullOrNil(paramList[2])) {
          ((buk)localObject).GOu.add(new cwt().aPy(paramList[2]));
        }
      }
      i = paramList.size();
    }
    AppMethodBeat.o(131132);
  }
  
  public final LinkedList<buj> aTg()
  {
    AppMethodBeat.i(131134);
    Object localObject = ((bul)this.rr.hNL.hNQ).GOx;
    if (localObject != null)
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        buj localbuj = (buj)((Iterator)localObject).next();
        a.aVi().azR().lU(localbuj.nDo, localbuj.Guj);
      }
    }
    localObject = ((bul)this.rr.hNL.hNQ).GOx;
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
    paramq = (bul)this.rr.hNL.hNQ;
    com.tencent.mm.kernel.g.ajF().a(new aq.a()
    {
      public final boolean aEm()
      {
        AppMethodBeat.i(131130);
        if ((paramq != null) && (paramq.GOx.size() > 0))
        {
          Iterator localIterator = paramq.GOx.iterator();
          while (localIterator.hasNext())
          {
            buj localbuj = (buj)localIterator.next();
            if (localbuj.nDG == 1)
            {
              i locali = new i();
              locali.username = localbuj.nDo;
              locali.hMX = localbuj.FVo;
              locali.hMW = localbuj.FVp;
              locali.dDp = -1;
              ad.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEq(), locali.aEr() });
              locali.ePj = 3;
              locali.eB(true);
              p.aEx().b(locali);
            }
          }
        }
        AppMethodBeat.o(131130);
        return true;
      }
      
      public final boolean aEn()
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