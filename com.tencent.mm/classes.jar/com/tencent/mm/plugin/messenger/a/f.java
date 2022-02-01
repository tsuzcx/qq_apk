package com.tencent.mm.plugin.messenger.a;

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
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  public final b rr;
  public final boolean vJe;
  
  public f(String paramString)
  {
    this(paramString, 0);
  }
  
  public f(String paramString, int paramInt)
  {
    this(paramString, paramInt, (byte)0);
  }
  
  private f(String paramString, int paramInt, byte paramByte)
  {
    this(paramString, 1, paramInt, false);
  }
  
  public f(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(94802);
    this.vJe = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cyb();
    ((b.a)localObject).hNN = new cyc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).funcId = 106;
    ((b.a)localObject).hNO = 34;
    ((b.a)localObject).respCmdId = 1000000034;
    this.rr = ((b.a)localObject).aDC();
    ad.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (cyb)this.rr.hNK.hNQ;
    ((cyb)localObject).GbY = new cwt().aPy(paramString);
    ((cyb)localObject).Hfd = paramInt1;
    ((cyb)localObject).Hpo = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final cyc dlC()
  {
    AppMethodBeat.i(94805);
    cyc localcyc = (cyc)this.rr.hNL.hNQ;
    if (localcyc != null)
    {
      Iterator localIterator = localcyc.GwV.iterator();
      while (localIterator.hasNext())
      {
        cya localcya = (cya)localIterator.next();
        a.aVi().azR().lU(localcya.GbY.HoB, localcya.Guj);
      }
    }
    AppMethodBeat.o(94805);
    return localcyc;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(94803);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94803);
    return i;
  }
  
  public final int getType()
  {
    return 106;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94804);
    paramq = (cyc)this.rr.hNL.hNQ;
    if ((paramq != null) && (paramq.GwU > 0)) {
      paramArrayOfByte = paramq.GwV.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cya)paramArrayOfByte.next();
      ad.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((cya)localObject).GbY });
      i locali = new i();
      locali.username = z.a(((cya)localObject).GbY);
      locali.hMX = ((cya)localObject).FVo;
      locali.hMW = ((cya)localObject).FVp;
      locali.dDp = -1;
      ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEq(), locali.aEr() });
      locali.ePj = 3;
      locali.eB(true);
      p.aEx().b(locali);
      continue;
      if ((paramq != null) && (!bt.isNullOrNil(z.a(paramq.GbY))))
      {
        paramArrayOfByte = z.a(paramq.GbY);
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte;
        ((i)localObject).hMX = paramq.FVo;
        ((i)localObject).hMW = paramq.FVp;
        ((i)localObject).dDp = -1;
        ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aEq(), ((i)localObject).aEr() });
        ((i)localObject).ePj = 3;
        ((i)localObject).eB(true);
        p.aEx().b((i)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.Hpt.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (cyp)paramq.next();
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.nDo;
        ((i)localObject).hMX = paramArrayOfByte.FVo;
        ((i)localObject).hMW = paramArrayOfByte.FVp;
        ((i)localObject).dDp = -1;
        ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aEq(), ((i)localObject).aEr() });
        ((i)localObject).ePj = 3;
        ((i)localObject).eB(true);
        p.aEx().b((i)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */