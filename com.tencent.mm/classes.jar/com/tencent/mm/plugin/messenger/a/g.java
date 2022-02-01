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
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  public final b rr;
  public final boolean txD;
  
  public g(String paramString)
  {
    this(paramString, 0);
  }
  
  public g(String paramString, int paramInt)
  {
    this(paramString, paramInt, (byte)0);
  }
  
  private g(String paramString, int paramInt, byte paramByte)
  {
    this(paramString, 1, paramInt, false);
  }
  
  public g(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(94802);
    this.txD = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cnk();
    ((b.a)localObject).gUV = new cnl();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).funcId = 106;
    ((b.a)localObject).reqCmdId = 34;
    ((b.a)localObject).respCmdId = 1000000034;
    this.rr = ((b.a)localObject).atI();
    ad.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (cnk)this.rr.gUS.gUX;
    ((cnk)localObject).Dby = new cmf().aEE(paramString);
    ((cnk)localObject).DYe = paramInt1;
    ((cnk)localObject).EhR = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final cnl cOA()
  {
    AppMethodBeat.i(94805);
    cnl localcnl = (cnl)this.rr.gUT.gUX;
    if (localcnl != null)
    {
      Iterator localIterator = localcnl.DsN.iterator();
      while (localIterator.hasNext())
      {
        cnj localcnj = (cnj)localIterator.next();
        a.aLf().aqn().kY(localcnj.Dby.Ehn, localcnj.Dqd);
      }
    }
    AppMethodBeat.o(94805);
    return localcnl;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(94803);
    this.callback = paramg;
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
    paramq = (cnl)this.rr.gUT.gUX;
    if ((paramq != null) && (paramq.DsM > 0)) {
      paramArrayOfByte = paramq.DsN.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cnj)paramArrayOfByte.next();
      ad.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((cnj)localObject).Dby });
      i locali = new i();
      locali.username = z.a(((cnj)localObject).Dby);
      locali.gUg = ((cnj)localObject).CVv;
      locali.gUf = ((cnj)localObject).CVw;
      locali.dtM = -1;
      ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aux(), locali.auy() });
      locali.evo = 3;
      locali.ee(true);
      p.auF().b(locali);
      continue;
      if ((paramq != null) && (!bt.isNullOrNil(z.a(paramq.Dby))))
      {
        paramArrayOfByte = z.a(paramq.Dby);
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte;
        ((i)localObject).gUg = paramq.CVv;
        ((i)localObject).gUf = paramq.CVw;
        ((i)localObject).dtM = -1;
        ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aux(), ((i)localObject).auy() });
        ((i)localObject).evo = 3;
        ((i)localObject).ee(true);
        p.auF().b((i)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.EhW.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (cny)paramq.next();
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.mAQ;
        ((i)localObject).gUg = paramArrayOfByte.CVv;
        ((i)localObject).gUf = paramArrayOfByte.CVw;
        ((i)localObject).dtM = -1;
        ad.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aux(), ((i)localObject).auy() });
        ((i)localObject).evo = 3;
        ((i)localObject).ee(true);
        p.auF().b((i)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */