package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bqu;
import com.tencent.mm.protocal.c.bqv;
import com.tencent.mm.sdk.platformtools.bk;

public final class y
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  
  public y(String paramString1, String paramString2, int paramInt, bmk parambmk)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bqu();
    ((b.a)localObject).ecI = new bqv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newsetpasswd";
    ((b.a)localObject).ecG = 383;
    ((b.a)localObject).ecJ = 180;
    ((b.a)localObject).ecK = 1000000180;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bqu)this.dmK.ecE.ecN;
    ((bqu)localObject).jwZ = bk.ZK(paramString1);
    ((bqu)localObject).sRr = paramString2;
    ((bqu)localObject).tHG = paramInt;
    ((bqu)localObject).syi = parambmk;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), bk.bD(aa.a(parambmk)) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 383;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.y
 * JD-Core Version:    0.7.0.1
 */