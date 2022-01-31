package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axy;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private LinkedList<cce> lAO = new LinkedList();
  
  public d(LinkedList<cce> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new axy();
    locala.ecI = new axz();
    locala.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
    locala.ecG = 638;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lAO = paramLinkedList;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
    this.dmL = paramf;
    paramf = (axy)this.dmK.ecE.ecN;
    paramf.tup = this.lAO;
    paramf.tct = this.lAO.size();
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.d
 * JD-Core Version:    0.7.0.1
 */