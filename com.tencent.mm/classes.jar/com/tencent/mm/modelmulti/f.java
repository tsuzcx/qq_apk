package com.tencent.mm.modelmulti;

import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.t.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ah.f dmL;
  private q edR;
  private byte[] esK;
  public long eso = -1L;
  private int uin = 0;
  
  public f(long paramLong, byte[] paramArrayOfByte)
  {
    this.eso = paramLong;
    this.esK = paramArrayOfByte;
  }
  
  public f(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.eso = paramLong;
    this.esK = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    if (bk.bE(this.esK))
    {
      y.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      return -1;
    }
    if (this.uin == 0) {
      this.edR = new f.a();
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.eso), bk.bC(this.esK) });
      ((t.a)this.edR.Kv()).eud = this.eso;
      ((t.a)this.edR.Kv()).bNE = this.esK;
      this.dmL = paramf;
      return a(parame, this.edR, this);
      this.edR = new f.b();
      ((f.b)this.edR).uin = this.uin;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 268369922;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f
 * JD-Core Version:    0.7.0.1
 */