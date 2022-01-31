package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class v
  extends m
  implements k
{
  public long bIt = -1L;
  public b dmK;
  private f dmL;
  private final long eAj = 60000L;
  private Runnable eAk;
  public int errCode;
  public int errType;
  
  public v(float paramFloat1, float paramFloat2, long paramLong)
  {
    bfa localbfa = new bfa();
    localbfa.sGJ = paramFloat1;
    localbfa.sGK = paramFloat2;
    localbfa.sUq = 1;
    localbfa.sUn = 0;
    a(localbfa, 1, -10000.0F, -10000.0F);
    this.bIt = paramLong;
  }
  
  public v(bfa parambfa, float paramFloat1, float paramFloat2)
  {
    a(parambfa, 0, paramFloat1, paramFloat2);
  }
  
  public v(bmy parambmy)
  {
    b.a locala = new b.a();
    locala.ecH = parambmy;
    locala.ecI = new bmz();
    locala.uri = "/cgi-bin/micromsg-bin/scanstreetview";
    locala.ecG = 424;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  private void a(bfa parambfa, int paramInt, float paramFloat1, float paramFloat2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bmy();
    ((b.a)localObject).ecI = new bmz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/scanstreetview";
    ((b.a)localObject).ecG = 424;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bmy)this.dmK.ecE.ecN;
    ((bmy)localObject).tGc = parambfa;
    ((bmy)localObject).pyo = paramInt;
    ((bmy)localObject).tGd = paramFloat1;
    ((bmy)localObject).tGe = paramFloat2;
  }
  
  public static String nf(String paramString)
  {
    paramString = bn.s(paramString, "streetview");
    if (paramString == null) {
      return null;
    }
    return (String)paramString.get(".streetview.link");
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final bmz QP()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (bmz)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[] { QP().sDW });
      if (this.eAk != null) {
        this.eAk.run();
      }
      return;
      y.e("MicroMsg.NetSceneScanStreetView", "callback null");
    }
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(q paramq)
  {
    if (((bmy)((b)paramq).ecE.ecN).tGc == null)
    {
      y.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 424;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.v
 * JD-Core Version:    0.7.0.1
 */