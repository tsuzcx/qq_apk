package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public long fIb = -1L;
  private byte[] fIx;
  private q ftU;
  private int uin = 0;
  
  public f(long paramLong, byte[] paramArrayOfByte)
  {
    this.fIb = paramLong;
    this.fIx = paramArrayOfByte;
  }
  
  public f(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    this.fIb = paramLong;
    this.fIx = paramArrayOfByte;
    this.uin = paramInt;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(58373);
    if (bo.ce(this.fIx))
    {
      ab.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[] { "get keyBuf failed" });
      AppMethodBeat.o(58373);
      return -1;
    }
    if (this.uin == 0) {
      this.ftU = new f.a();
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[] { Long.valueOf(this.fIb), bo.cc(this.fIx) });
      ((u.a)this.ftU.getReqObj()).fJQ = this.fIb;
      ((u.a)this.ftU.getReqObj()).cuW = this.fIx;
      this.callback = paramf;
      int i = dispatch(parame, this.ftU, this);
      AppMethodBeat.o(58373);
      return i;
      this.ftU = new f.b();
      ((f.b)this.ftU).uin = this.uin;
    }
  }
  
  public final int getType()
  {
    return 268369922;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58374);
    ab.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(58374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.f
 * JD-Core Version:    0.7.0.1
 */