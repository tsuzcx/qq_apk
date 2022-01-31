package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public g(LinkedList<jb> paramLinkedList, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkp();
    ((b.a)localObject).ecI = new bkq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((b.a)localObject).ecG = 2645;
    ((b.a)localObject).ecJ = 176;
    ((b.a)localObject).ecK = 1000000176;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bkp)this.dmK.ecE.ecN;
    ((bkp)localObject).tEl = paramLinkedList;
    ((bkp)localObject).tEm = paramInt1;
    ((bkp)localObject).tEn = paramInt2;
    ((bkp)localObject).sOo = paramInt3;
    y.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d", new Object[] { Integer.valueOf(((bkp)localObject).tEl.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    return 2645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.g
 * JD-Core Version:    0.7.0.1
 */