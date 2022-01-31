package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;

public final class e
  extends m
  implements k
{
  private f dmL = null;
  private q edR;
  private String lhw = null;
  private int uin = 0;
  
  public e(String paramString, int paramInt)
  {
    this.lhw = paramString;
    this.uin = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    this.edR = new e.a();
    ((e.a)this.edR).uin = this.uin;
    ((c.a)this.edR.Kv()).lhs.ssp = this.lhw;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 623;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.e
 * JD-Core Version:    0.7.0.1
 */