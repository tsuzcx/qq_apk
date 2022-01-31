package com.tencent.mm.ag;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqg;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class j
  extends m
  implements k
{
  private f dmL;
  LinkedList<bml> ebX = null;
  LinkedList<aqg> ebY = null;
  
  public j(LinkedList<bml> paramLinkedList)
  {
    this.ebX = paramLinkedList;
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final int a(e parame, f paramf)
  {
    if ((this.ebX == null) || (this.ebX.size() <= 0))
    {
      y.e("MicroMsg.NetSceneBatchGetHeadImg", g.zI() + "doScene ReqSize==0");
      return -1;
    }
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new gw();
    paramf.ecI = new gx();
    paramf.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
    paramf.ecG = 123;
    paramf.ecJ = 15;
    paramf.ecK = 1000000015;
    paramf = paramf.Kt();
    gw localgw = (gw)paramf.ecE.ecN;
    localgw.svn = this.ebX;
    localgw.hPS = this.ebX.size();
    return a(parame, paramf, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    this.ebY = ((gx)((b)paramq).ecF.ecN).sAB;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 123;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.j
 * JD-Core Version:    0.7.0.1
 */