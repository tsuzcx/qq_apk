package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL = null;
  private q edR;
  private String lhw = null;
  private int uin = 0;
  
  public f(String paramString, int paramInt)
  {
    this.lhw = paramString;
    this.uin = paramInt;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    this.edR = new f.a();
    ((f.a)this.edR).uin = this.uin;
    ((d.a)this.edR.Kv()).lhu.ssp = this.lhw;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 624;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.f
 * JD-Core Version:    0.7.0.1
 */