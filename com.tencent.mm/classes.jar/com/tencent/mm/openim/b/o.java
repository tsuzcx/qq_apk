package com.tencent.mm.openim.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.sdk.platformtools.y;

public final class o
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private String ePQ;
  
  public o(String paramString1, String paramString2, String paramString3)
  {
    this.ePQ = paramString1;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bpe();
    ((b.a)localObject).ecI = new bpf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
    ((b.a)localObject).ecG = 243;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bpe)this.dmK.ecE.ecN;
    ((bpe)localObject).ePQ = paramString1;
    ((bpe)localObject).tHi = paramString2;
    ((bpe)localObject).svT = paramString3;
    y.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[] { paramString1, paramString3 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.ePQ });
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 243;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.o
 * JD-Core Version:    0.7.0.1
 */