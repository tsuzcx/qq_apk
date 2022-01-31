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
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  public int ino;
  public String inp;
  
  public o(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, bvk parambvk)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aj();
    ((b.a)localObject).ecI = new ak();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/acceptcarditem";
    ((b.a)localObject).ecG = 651;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aj)this.dmK.ecE.ecN;
    ((aj)localObject).bZc = paramString1;
    ((aj)localObject).imy = paramString2;
    ((aj)localObject).bZe = paramInt1;
    ((aj)localObject).bZd = paramString3;
    ((aj)localObject).stc = paramString4;
    ((aj)localObject).stb = paramString5;
    ((aj)localObject).std = paramInt2;
    ((aj)localObject).ste = paramInt3;
    ((aj)localObject).stf = parambvk;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ak)this.dmK.ecF.ecN;
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
      paramq = (ak)this.dmK.ecF.ecN;
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
    return 651;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.o
 * JD-Core Version:    0.7.0.1
 */