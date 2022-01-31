package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhs;
import com.tencent.mm.protocal.c.bht;

public final class r
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public int ezR = 1;
  public int ezS;
  
  public r(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bhs();
    locala.ecI = new bht();
    locala.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
    locala.ecG = 255;
    locala.ecJ = 132;
    locala.ecK = 1000000132;
    this.dmK = locala.Kt();
    ((bhs)this.dmK.ecE.ecN).pyo = paramInt;
    this.ezS = paramInt;
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
    return 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.r
 * JD-Core Version:    0.7.0.1
 */