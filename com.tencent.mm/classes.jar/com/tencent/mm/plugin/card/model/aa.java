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
import com.tencent.mm.protocal.c.adi;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.protocal.c.bvk;
import com.tencent.mm.sdk.platformtools.y;

public final class aa
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  
  public aa(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, bvk parambvk)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new adi();
    ((b.a)localObject).ecI = new adj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
    ((b.a)localObject).ecG = 645;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (adi)this.dmK.ecE.ecN;
    ((adi)localObject).bZc = paramString1;
    ((adi)localObject).bZe = paramInt1;
    ((adi)localObject).imy = paramString2;
    ((adi)localObject).bZd = paramString3;
    ((adi)localObject).stc = paramString4;
    ((adi)localObject).stb = paramString5;
    ((adi)localObject).std = paramInt2;
    ((adi)localObject).tbG = paramString6;
    ((adi)localObject).stf = parambvk;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.inn = ((adj)this.dmK.ecF.ecN).inn;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 645;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.aa
 * JD-Core Version:    0.7.0.1
 */