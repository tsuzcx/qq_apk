package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class p
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  public int ino;
  public String inp;
  
  public p(LinkedList<lw> paramLinkedList, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new al();
    ((b.a)localObject).ecI = new am();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
    ((b.a)localObject).ecG = 687;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (al)this.dmK.ecE.ecN;
    ((al)localObject).stg = paramLinkedList;
    ((al)localObject).bZe = paramInt1;
    ((al)localObject).stc = paramString1;
    ((al)localObject).stb = paramString2;
    ((al)localObject).std = paramInt2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (am)this.dmK.ecF.ecN;
      this.inn = paramq.inn;
      this.ino = paramq.ino;
      this.inp = paramq.inp;
      y.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.ino + " ret_msg = " + this.inp);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.p
 * JD-Core Version:    0.7.0.1
 */