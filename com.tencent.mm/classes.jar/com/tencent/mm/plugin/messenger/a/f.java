package com.tencent.mm.plugin.messenger.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public final boolean oCW;
  public final b rr;
  
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
    AppMethodBeat.i(111114);
    this.oCW = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bxg();
    ((b.a)localObject).fsY = new bxh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).funcId = 106;
    ((b.a)localObject).reqCmdId = 34;
    ((b.a)localObject).respCmdId = 1000000034;
    this.rr = ((b.a)localObject).ado();
    ab.d("MicroMsg.NetSceneSearchContact", "search username [%s], scene [%s]", new Object[] { paramString, Integer.valueOf(paramInt2) });
    localObject = (bxg)this.rr.fsV.fta;
    ((bxg)localObject).wOT = new bwc().aoF(paramString);
    ((bxg)localObject).xBG = paramInt1;
    ((bxg)localObject).xKg = paramInt2;
    AppMethodBeat.o(111114);
  }
  
  public final bxh bPI()
  {
    AppMethodBeat.i(111117);
    bxh localbxh = (bxh)this.rr.fsW.fta;
    if (localbxh != null)
    {
      Iterator localIterator = localbxh.xaT.iterator();
      while (localIterator.hasNext())
      {
        bxf localbxf = (bxf)localIterator.next();
        a.asD().Zb().in(localbxf.wOT.xJE, localbxf.wYu);
      }
    }
    AppMethodBeat.o(111117);
    return localbxh;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(111115);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(111115);
    return i;
  }
  
  public final int getType()
  {
    return 106;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(111116);
    paramq = (bxh)this.rr.fsW.fta;
    if ((paramq != null) && (paramq.xaS > 0)) {
      paramArrayOfByte = paramq.xaT.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (bxf)paramArrayOfByte.next();
      ab.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((bxf)localObject).wOT });
      h localh = new h();
      localh.username = aa.a(((bxf)localObject).wOT);
      localh.fsl = ((bxf)localObject).wJq;
      localh.fsk = ((bxf)localObject).wJr;
      localh.bsY = -1;
      ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.acX(), localh.acY() });
      localh.dqB = 3;
      localh.cM(true);
      o.adg().b(localh);
      continue;
      if ((paramq != null) && (!bo.isNullOrNil(aa.a(paramq.wOT))))
      {
        paramArrayOfByte = aa.a(paramq.wOT);
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte;
        ((h)localObject).fsl = paramq.wJq;
        ((h)localObject).fsk = paramq.wJr;
        ((h)localObject).bsY = -1;
        ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject).getUsername(), ((h)localObject).acX(), ((h)localObject).acY() });
        ((h)localObject).dqB = 3;
        ((h)localObject).cM(true);
        o.adg().b((h)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.xKl.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bxw)paramq.next();
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte.jJA;
        ((h)localObject).fsl = paramArrayOfByte.wJq;
        ((h)localObject).fsk = paramArrayOfByte.wJr;
        ((h)localObject).bsY = -1;
        ab.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject).getUsername(), ((h)localObject).acX(), ((h)localObject).acY() });
        ((h)localObject).dqB = 3;
        ((h)localObject).cM(true);
        o.adg().b((h)localObject);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(111116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */