package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.bry;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  public int ino;
  public String inp;
  
  public g(int paramInt1, LinkedList<brj> paramLinkedList, String paramString1, String paramString2, bry parambry, int paramInt2, bvk parambvk)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new brh();
    ((b.a)localObject).ecI = new bri();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sharecarditem";
    ((b.a)localObject).ecG = 902;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (brh)this.dmK.ecE.ecN;
    ((brh)localObject).tId = paramInt1;
    ((brh)localObject).dTx = paramLinkedList;
    ((brh)localObject).tIe = paramString1;
    ((brh)localObject).tbG = paramString2;
    y.i("MicroMsg.NetSceneShareCardItem", "list length is " + paramLinkedList.size());
    ((brh)localObject).tIf = parambry;
    ((brh)localObject).bZe = paramInt2;
    ((brh)localObject).stf = parambvk;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(902), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      y.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
      paramq = (bri)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        this.inn = paramq.inn;
        this.ino = paramq.ino;
        this.inp = paramq.inp;
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramq = (bri)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        this.inn = paramq.inn;
        this.ino = paramq.ino;
        this.inp = paramq.inp;
      }
    }
  }
  
  public final int getType()
  {
    return 902;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.g
 * JD-Core Version:    0.7.0.1
 */