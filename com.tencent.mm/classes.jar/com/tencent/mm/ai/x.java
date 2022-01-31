package com.tencent.mm.ai;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkr;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.protocal.c.bkt;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class x
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public x(LinkedList<bkr> paramLinkedList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bks();
    ((b.a)localObject).ecI = new bkt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportcommand";
    ((b.a)localObject).ecG = 2592;
    ((b.a)localObject).ecJ = 176;
    ((b.a)localObject).ecK = 1000000176;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bks)this.dmK.ecE.ecN;
    ((bks)localObject).sOn = paramLinkedList;
    y.i("MicroMsg.NetSceneReportBrandSession", "reportcommand MsgReport size %d", new Object[] { Integer.valueOf(((bks)localObject).sOn.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2592;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.x
 * JD-Core Version:    0.7.0.1
 */