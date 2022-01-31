package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends m
  implements k
{
  public String aox;
  public int bMC;
  public final b dmK;
  private com.tencent.mm.ah.f dmL;
  private Runnable eAk;
  public int errCode;
  public int errType;
  public String fTF;
  public boolean inQ = false;
  public byte[] lCW;
  public byte[] lCX = null;
  public String lCY = "";
  public int lCZ;
  public List<com.tencent.mm.plugin.location.ui.impl.f> list = new ArrayList();
  
  public h(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, double paramDouble4, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aig();
    ((b.a)localObject).ecI = new aih();
    ((b.a)localObject).ecI = new aih();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getpoilist";
    ((b.a)localObject).ecG = 457;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    aig localaig = (aig)this.dmK.ecE.ecN;
    if (paramArrayOfByte == null)
    {
      localObject = new bmk();
      localaig.teH = ((bmk)localObject);
      localaig.sYZ = paramString2;
      localaig.sDn = paramDouble1;
      localaig.sDm = paramDouble2;
      localaig.pyo = paramInt1;
      localaig.ssq = paramInt2;
      localaig.tfx = paramDouble4;
      localaig.tfw = paramDouble3;
      if (!paramBoolean) {
        break label329;
      }
    }
    label329:
    for (int i = 1;; i = 0)
    {
      localaig.teJ = i;
      this.bMC = localaig.ssq;
      this.lCY = paramString1;
      this.lCW = paramArrayOfByte;
      y.i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutuQuery %s" + paramArrayOfByte, new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Double.valueOf(paramDouble4), Double.valueOf(paramDouble3), Boolean.valueOf(paramBoolean) });
      return;
      localObject = new bmk().bs(paramArrayOfByte);
      break;
    }
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.NetSceneGetPoiList", "scene done");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + "errMsg:" + paramString);
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.aox = paramString;
    paramq = (aih)this.dmK.ecF.ecN;
    this.list.clear();
    y.d("MicroMsg.NetSceneGetPoiList", "url " + paramq.teQ + " " + paramq.sRA + " " + paramq.kSC + " " + paramq.sFF);
    y.d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", new Object[] { Integer.valueOf(paramq.teR) });
    this.fTF = paramq.sFF;
    this.lCZ = paramq.teR;
    if (paramq.tfz != null)
    {
      y.d("MicroMsg.NetSceneGetPoiList", "poi result %d ", new Object[] { Integer.valueOf(paramq.tfz.size()) });
      if (paramq.tfz.size() > 0) {
        y.d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", new Object[] { ((bco)paramq.tfz.get(0)).txR, ((bco)paramq.tfz.get(0)).ffi, ((bco)paramq.tfz.get(0)).sQi, ((bco)paramq.tfz.get(0)).ffj });
      }
      paramArrayOfByte = paramq.tfz.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.plugin.location.ui.impl.f localf = new com.tencent.mm.plugin.location.ui.impl.f((bco)paramArrayOfByte.next(), this.fTF);
        this.list.add(localf);
      }
    }
    if (paramq.teH != null) {
      this.lCX = aa.a(paramq.teH);
    }
    if (paramq.tfA == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.inQ = bool;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.eAk != null) {
        this.eAk.run();
      }
      return;
    }
  }
  
  public final int getType()
  {
    return 457;
  }
  
  public final boolean isFirst()
  {
    return this.lCW == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.h
 * JD-Core Version:    0.7.0.1
 */