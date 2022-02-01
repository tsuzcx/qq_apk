package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends a
  implements m, c
{
  private i callback;
  private d rr;
  private float wvR;
  private long wwf;
  private byte[] wwg;
  private byte[] wwh;
  
  public v(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190765);
    this.wwf = -1L;
    this.wvR = 0.5F;
    this.wwg = null;
    this.wwh = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bqq();
    ((d.a)localObject).lBV = new bqr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bqq)d.b.b(this.rr.lBR);
    ((bqq)localObject).rWu = 1;
    ((bqq)localObject).CPw = paramInt1;
    ((bqq)localObject).TbK = paramInt2;
    ((bqq)localObject).appid = paramString1;
    ((bqq)localObject).RSB = paramString2;
    ((bqq)localObject).TbL = b.cU(paramArrayOfByte);
    AppMethodBeat.o(190765);
  }
  
  public final long dhO()
  {
    return this.wwf;
  }
  
  public final byte[] dhP()
  {
    return this.wwg;
  }
  
  public final float dhQ()
  {
    if ((this.wvR <= 0.0F) || (this.wvR > 1.0F)) {
      this.wvR = 0.5F;
    }
    return this.wvR;
  }
  
  public final byte[] dhR()
  {
    return this.wwh;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(103635);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(103635);
    return i;
  }
  
  public final int getType()
  {
    return 732;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103636);
    params = (bqr)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.wwf = params.TbM;
      if (params.TbN != null) {
        this.wwg = params.TbN.UH;
      }
      this.wvR = params.TbQ;
      if (params.TbL != null) {
        this.wwh = params.TbL.UH;
      }
      Log.i("MicroMsg.NetSceneGetBioConfig", "carson logic bioId:%s Config is:%s ratio:%s", new Object[] { Long.valueOf(this.wwf), this.wwg, Float.valueOf(this.wvR) });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */