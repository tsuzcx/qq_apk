package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.ht;

public final class d
  extends m
  implements k
{
  public static int fju = 1;
  public static int fjv = 2;
  private b dmK;
  private f dmL;
  
  public d(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new hs();
    ((b.a)localObject).ecI = new ht();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindemail";
    ((b.a)localObject).ecG = 256;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (hs)this.dmK.ecE.ecN;
    ((hs)localObject).ssq = paramInt;
    ((hs)localObject).sAY = paramString;
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
    return 256;
  }
  
  public final int rN()
  {
    return ((hs)this.dmK.ecE.ecN).ssq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.d
 * JD-Core Version:    0.7.0.1
 */