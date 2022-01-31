package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.ajw;

public final class n
  extends m
  implements k
{
  private f dmL;
  public final b esv;
  
  public n()
  {
    b.a locala = new b.a();
    locala.ecH = new ajv();
    locala.ecI = new ajw();
    locala.uri = "/cgi-bin/micromsg-bin/getremind";
    locala.ecG = 866;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.esv = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.esv, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 866;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelsimple.n
 * JD-Core Version:    0.7.0.1
 */