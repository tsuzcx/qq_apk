package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class g
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public final b rr;
  public final boolean uGb;
  
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
    this.uGb = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new csr();
    ((b.a)localObject).hvu = new css();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).funcId = 106;
    ((b.a)localObject).reqCmdId = 34;
    ((b.a)localObject).respCmdId = 1000000034;
    this.rr = ((b.a)localObject).aAz();
    ac.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (csr)this.rr.hvr.hvw;
    ((csr)localObject).EuE = new crm().aJV(paramString);
    ((csr)localObject).FuY = paramInt1;
    ((csr)localObject).FEP = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final css dcj()
  {
    AppMethodBeat.i(94805);
    css localcss = (css)this.rr.hvs.hvw;
    if (localcss != null)
    {
      Iterator localIterator = localcss.ENR.iterator();
      while (localIterator.hasNext())
      {
        csq localcsq = (csq)localIterator.next();
        a.aRW().axc().lv(localcsq.EuE.FEm, localcsq.ELg);
      }
    }
    AppMethodBeat.o(94805);
    return localcss;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    paramq = (css)this.rr.hvs.hvw;
    if ((paramq != null) && (paramq.ENQ > 0)) {
      paramArrayOfByte = paramq.ENR.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (csq)paramArrayOfByte.next();
      ac.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((csq)localObject).EuE });
      i locali = new i();
      locali.username = z.a(((csq)localObject).EuE);
      locali.huF = ((csq)localObject).Eof;
      locali.huE = ((csq)localObject).Eog;
      locali.drx = -1;
      ac.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aBo(), locali.aBp() });
      locali.exK = 3;
      locali.ez(true);
      p.aBw().b(locali);
      continue;
      if ((paramq != null) && (!bs.isNullOrNil(z.a(paramq.EuE))))
      {
        paramArrayOfByte = z.a(paramq.EuE);
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte;
        ((i)localObject).huF = paramq.Eof;
        ((i)localObject).huE = paramq.Eog;
        ((i)localObject).drx = -1;
        ac.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aBo(), ((i)localObject).aBp() });
        ((i)localObject).exK = 3;
        ((i)localObject).ez(true);
        p.aBw().b((i)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.FEU.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (ctf)paramq.next();
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.ncR;
        ((i)localObject).huF = paramArrayOfByte.Eof;
        ((i)localObject).huE = paramArrayOfByte.Eog;
        ((i)localObject).drx = -1;
        ac.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aBo(), ((i)localObject).aBp() });
        ((i)localObject).exK = 3;
        ((i)localObject).ez(true);
        p.aBw().b((i)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.g
 * JD-Core Version:    0.7.0.1
 */