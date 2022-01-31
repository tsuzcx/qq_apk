package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  public final boolean mcu;
  
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
    this.mcu = paramBoolean;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bnl();
    ((b.a)localObject).ecI = new bnm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/searchcontact";
    ((b.a)localObject).ecG = 106;
    ((b.a)localObject).ecJ = 34;
    ((b.a)localObject).ecK = 1000000034;
    this.dmK = ((b.a)localObject).Kt();
    y.d("MicroMsg.NetSceneSearchContact", "search username [%s]", new Object[] { paramString });
    localObject = (bnl)this.dmK.ecE.ecN;
    ((bnl)localObject).sQs = new bml().YI(paramString);
    ((bnl)localObject).tAd = paramInt1;
    ((bnl)localObject).tGr = paramInt2;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (bnm)this.dmK.ecF.ecN;
    if ((paramq != null) && (paramq.tcA > 0)) {
      paramArrayOfByte = paramq.tcB.iterator();
    }
    Object localObject;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (bnk)paramArrayOfByte.next();
      y.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", new Object[] { ((bnk)localObject).sQs });
      h localh = new h();
      localh.username = aa.a(((bnk)localObject).sQs);
      localh.ebT = ((bnk)localObject).sLD;
      localh.ebS = ((bnk)localObject).sLE;
      localh.bcw = -1;
      y.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.JX(), localh.JY() });
      localh.cCq = 3;
      localh.bK(true);
      o.Kh().a(localh);
      continue;
      if ((paramq != null) && (!bk.bl(aa.a(paramq.sQs))))
      {
        paramArrayOfByte = aa.a(paramq.sQs);
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte;
        ((h)localObject).ebT = paramq.sLD;
        ((h)localObject).ebS = paramq.sLE;
        ((h)localObject).bcw = -1;
        y.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject).getUsername(), ((h)localObject).JX(), ((h)localObject).JY() });
        ((h)localObject).cCq = 3;
        ((h)localObject).bK(true);
        o.Kh().a((h)localObject);
      }
    }
    if (paramq != null)
    {
      paramq = paramq.tGw.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bob)paramq.next();
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte.hPY;
        ((h)localObject).ebT = paramArrayOfByte.sLD;
        ((h)localObject).ebS = paramArrayOfByte.sLE;
        ((h)localObject).bcw = -1;
        y.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", new Object[] { ((h)localObject).getUsername(), ((h)localObject).JX(), ((h)localObject).JY() });
        ((h)localObject).cCq = 3;
        ((h)localObject).bK(true);
        o.Kh().a((h)localObject);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final bnm bhH()
  {
    bnm localbnm = (bnm)this.dmK.ecF.ecN;
    if (localbnm != null)
    {
      Iterator localIterator = localbnm.tcB.iterator();
      while (localIterator.hasNext())
      {
        bnk localbnk = (bnk)localIterator.next();
        a.YT().Ga().gm(localbnk.sQs.tFO, localbnk.tac);
      }
    }
    return localbnm;
  }
  
  public final int getType()
  {
    return 106;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.f
 * JD-Core Version:    0.7.0.1
 */