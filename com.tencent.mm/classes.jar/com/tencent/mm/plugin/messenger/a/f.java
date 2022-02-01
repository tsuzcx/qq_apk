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
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  public final b rr;
  public final boolean vVi;
  
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
    this.vVi = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cyv();
    ((b.a)localObject).hQG = new cyw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).funcId = 106;
    ((b.a)localObject).hQH = 34;
    ((b.a)localObject).respCmdId = 1000000034;
    this.rr = ((b.a)localObject).aDS();
    ae.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (cyv)this.rr.hQD.hQJ;
    ((cyv)localObject).GuF = new cxn().aQV(paramString);
    ((cyv)localObject).HyD = paramInt1;
    ((cyv)localObject).HIQ = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final cyw doB()
  {
    AppMethodBeat.i(94805);
    cyw localcyw = (cyw)this.rr.hQE.hQJ;
    if (localcyw != null)
    {
      Iterator localIterator = localcyw.GQv.iterator();
      while (localIterator.hasNext())
      {
        cyu localcyu = (cyu)localIterator.next();
        a.aVH().aAh().mb(localcyu.GuF.HId, localcyu.GNI);
      }
    }
    AppMethodBeat.o(94805);
    return localcyw;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    paramq = (cyw)this.rr.hQE.hQJ;
    if ((paramq != null) && (paramq.GQu > 0)) {
      paramArrayOfByte = paramq.GQv.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (cyu)paramArrayOfByte.next();
      ae.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((cyu)localObject).GuF });
      i locali = new i();
      locali.username = z.a(((cyu)localObject).GuF);
      locali.hPQ = ((cyu)localObject).GnN;
      locali.hPP = ((cyu)localObject).GnO;
      locali.dEu = -1;
      ae.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEG(), locali.aEH() });
      locali.eQU = 3;
      locali.eD(true);
      p.aEN().b(locali);
      continue;
      if ((paramq != null) && (!bu.isNullOrNil(z.a(paramq.GuF))))
      {
        paramArrayOfByte = z.a(paramq.GuF);
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte;
        ((i)localObject).hPQ = paramq.GnN;
        ((i)localObject).hPP = paramq.GnO;
        ((i)localObject).dEu = -1;
        ae.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aEG(), ((i)localObject).aEH() });
        ((i)localObject).eQU = 3;
        ((i)localObject).eD(true);
        p.aEN().b((i)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.HIV.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (czj)paramq.next();
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.nIJ;
        ((i)localObject).hPQ = paramArrayOfByte.GnN;
        ((i)localObject).hPP = paramArrayOfByte.GnO;
        ((i)localObject).dEu = -1;
        ae.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((i)localObject).getUsername(), ((i)localObject).aEG(), ((i)localObject).aEH() });
        ((i)localObject).eQU = 3;
        ((i)localObject).eD(true);
        p.aEN().b((i)localObject);
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