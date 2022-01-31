package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.protocal.c.mh;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class t
  extends m
  implements k
{
  private final b dmK;
  private com.tencent.mm.ah.f dmL;
  public LinkedList<CardInfo> inv = new LinkedList();
  
  public t(LinkedList<mh> paramLinkedList, bvk parambvk, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new go();
    ((b.a)localObject).ecI = new gp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
    ((b.a)localObject).ecG = 699;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (go)this.dmK.ecE.ecN;
    ((go)localObject).dTx = paramLinkedList;
    ((go)localObject).stf = parambvk;
    ((go)localObject).bZe = paramInt;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramq = ((gp)this.dmK.ecF.ecN).inn;
    if (TextUtils.isEmpty(paramq))
    {
      y.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
      this.dmL.onSceneEnd(4, -1, null, this);
      return;
    }
    paramq = com.tencent.mm.plugin.card.d.f.yK(paramq);
    if (paramq != null)
    {
      l.aDc();
      this.inv.addAll(paramq);
    }
    this.dmL.onSceneEnd(0, 0, paramString, this);
  }
  
  public final int getType()
  {
    return 699;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.t
 * JD-Core Version:    0.7.0.1
 */