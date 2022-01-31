package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blh;
import com.tencent.mm.protocal.c.bli;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  
  public a(int paramInt, LinkedList<bml> paramLinkedList, bml parambml1, bml parambml2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new blh();
    ((b.a)localObject).ecI = new bli();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
    ((b.a)localObject).ecG = 228;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (blh)this.dmK.ecE.ecN;
    ((blh)localObject).tER = paramInt;
    ((blh)localObject).tES = paramLinkedList;
    ((blh)localObject).tET = parambml1;
    ((blh)localObject).tEU = parambml2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 228;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.b.a
 * JD-Core Version:    0.7.0.1
 */