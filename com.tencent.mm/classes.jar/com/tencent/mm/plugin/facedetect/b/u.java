package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  extends q
  implements m, b
{
  private i callback;
  private d rr;
  private long sQh;
  private float sQi;
  private byte[] sQj;
  private byte[] sQk;
  
  public u(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186361);
    this.sQh = -1L;
    this.sQi = 0.5F;
    this.sQj = null;
    this.sQk = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bjh();
    ((d.a)localObject).iLO = new bji();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bjh)this.rr.iLK.iLR;
    ((bjh)localObject).oUv = 1;
    ((bjh)localObject).Scene = paramInt1;
    ((bjh)localObject).LSZ = paramInt2;
    ((bjh)localObject).dNI = paramString1;
    ((bjh)localObject).KRB = paramString2;
    ((bjh)localObject).LTa = com.tencent.mm.bw.b.cD(paramArrayOfByte);
    AppMethodBeat.o(186361);
  }
  
  public final long cSK()
  {
    return this.sQh;
  }
  
  public final byte[] cSL()
  {
    return this.sQj;
  }
  
  public final float cSM()
  {
    if ((this.sQi <= 0.0F) || (this.sQi > 1.0F)) {
      this.sQi = 0.5F;
    }
    return this.sQi;
  }
  
  public final byte[] cSN()
  {
    return this.sQk;
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
    params = (bji)((d)params).iLL.iLR;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.sQh = params.LTb;
      if (params.LTc != null) {
        this.sQj = params.LTc.zy;
      }
      this.sQi = params.LTf;
      if (params.LTa != null) {
        this.sQk = params.LTa.zy;
      }
      Log.i("MicroMsg.NetSceneGetBioConfig", "carson logic bioId:%s Config is:%s ratio:%s", new Object[] { Long.valueOf(this.sQh), this.sQj, Float.valueOf(this.sQi) });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.u
 * JD-Core Version:    0.7.0.1
 */