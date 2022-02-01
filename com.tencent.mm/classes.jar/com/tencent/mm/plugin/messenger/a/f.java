package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public final d rr;
  public final boolean zpn;
  
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
    this.zpn = paramBoolean;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new drs();
    ((d.a)localObject).iLO = new drt();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((d.a)localObject).funcId = 106;
    ((d.a)localObject).iLP = 34;
    ((d.a)localObject).respCmdId = 1000000034;
    this.rr = ((d.a)localObject).aXF();
    Log.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (drs)this.rr.iLK.iLR;
    ((drs)localObject).Lqk = new dqi().bhy(paramString);
    ((drs)localObject).MJj = paramInt1;
    ((drs)localObject).MUl = paramInt2;
    AppMethodBeat.o(94802);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(94803);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94803);
    return i;
  }
  
  public final drt eiq()
  {
    AppMethodBeat.i(94805);
    drt localdrt = (drt)this.rr.iLL.iLR;
    if (localdrt != null)
    {
      Iterator localIterator = localdrt.LUC.iterator();
      while (localIterator.hasNext())
      {
        drr localdrr = (drr)localIterator.next();
        a.bqE().aTp().mP(localdrr.Lqk.MTo, localdrr.LRO);
      }
    }
    AppMethodBeat.o(94805);
    return localdrt;
  }
  
  public final int getType()
  {
    return 106;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94804);
    params = (drt)this.rr.iLL.iLR;
    if ((params != null) && (params.LUB > 0)) {
      paramArrayOfByte = params.LUC.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (drr)paramArrayOfByte.next();
      Log.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((drr)localObject).Lqk });
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = z.a(((drr)localObject).Lqk);
      locali.iKX = ((drr)localObject).Lir;
      locali.iKW = ((drr)localObject).Lis;
      locali.cSx = -1;
      Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aYt(), locali.aYu() });
      locali.fuz = 3;
      locali.fv(true);
      p.aYB().b(locali);
      continue;
      if ((params != null) && (!Util.isNullOrNil(z.a(params.Lqk))))
      {
        paramArrayOfByte = z.a(params.Lqk);
        localObject = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject).username = paramArrayOfByte;
        ((com.tencent.mm.aj.i)localObject).iKX = params.Lir;
        ((com.tencent.mm.aj.i)localObject).iKW = params.Lis;
        ((com.tencent.mm.aj.i)localObject).cSx = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((com.tencent.mm.aj.i)localObject).getUsername(), ((com.tencent.mm.aj.i)localObject).aYt(), ((com.tencent.mm.aj.i)localObject).aYu() });
        ((com.tencent.mm.aj.i)localObject).fuz = 3;
        ((com.tencent.mm.aj.i)localObject).fv(true);
        p.aYB().b((com.tencent.mm.aj.i)localObject);
      }
    }
    if (params != null)
    {
      params = params.MUq.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (dsk)params.next();
        localObject = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject).username = paramArrayOfByte.UserName;
        ((com.tencent.mm.aj.i)localObject).iKX = paramArrayOfByte.Lir;
        ((com.tencent.mm.aj.i)localObject).iKW = paramArrayOfByte.Lis;
        ((com.tencent.mm.aj.i)localObject).cSx = -1;
        Log.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((com.tencent.mm.aj.i)localObject).getUsername(), ((com.tencent.mm.aj.i)localObject).aYt(), ((com.tencent.mm.aj.i)localObject).aYu() });
        ((com.tencent.mm.aj.i)localObject).fuz = 3;
        ((com.tencent.mm.aj.i)localObject).fv(true);
        p.aYB().b((com.tencent.mm.aj.i)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */