package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.sdk.platformtools.y;

public final class aj
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public com.tencent.mm.bv.b inP;
  public boolean inQ;
  public String inn;
  
  public aj(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, com.tencent.mm.bv.b paramb)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new abm();
    ((b.a)localObject).ecI = new abn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getavailablecard";
    ((b.a)localObject).ecG = 664;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (abm)this.dmK.ecE.ecN;
    ((abm)localObject).app_id = paramString1;
    ((abm)localObject).ivC = paramInt1;
    ((abm)localObject).ivD = paramString2;
    ((abm)localObject).ivE = paramString3;
    ((abm)localObject).time_stamp = paramInt2;
    ((abm)localObject).ivF = paramString4;
    ((abm)localObject).iln = paramString5;
    ((abm)localObject).ivG = paramString6;
    ((abm)localObject).inP = paramb;
    if ("INVOICE".equalsIgnoreCase(paramString6))
    {
      ((abm)localObject).taO = 1;
      return;
    }
    ((abm)localObject).taO = 0;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (abn)this.dmK.ecF.ecN;
      this.inn = paramq.inn;
      this.inP = paramq.inP;
      if (paramq.taP == 0) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.inQ = bool;
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 664;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aj
 * JD-Core Version:    0.7.0.1
 */