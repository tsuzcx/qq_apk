package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.sdk.platformtools.Log;

public final class v
  extends a
  implements m, c
{
  private h callback;
  private com.tencent.mm.am.c rr;
  private float zRW;
  private long zSm;
  private byte[] zSn;
  private byte[] zSo;
  
  public v(int paramInt1, int paramInt2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(271897);
    this.zSm = -1L;
    this.zRW = 0.5F;
    this.zSn = null;
    this.zSo = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cfh();
    ((c.a)localObject).otF = new cfi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getbioconfig";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cfh)c.b.b(this.rr.otB);
    ((cfh)localObject).vhJ = 1;
    ((cfh)localObject).IJG = paramInt1;
    ((cfh)localObject).aaoW = paramInt2;
    ((cfh)localObject).appid = paramString1;
    ((cfh)localObject).YQb = paramString2;
    ((cfh)localObject).aaoX = b.cX(paramArrayOfByte);
    AppMethodBeat.o(271897);
  }
  
  public final byte[] dOA()
  {
    return this.zSn;
  }
  
  public final float dOB()
  {
    if ((this.zRW <= 0.0F) || (this.zRW > 1.0F)) {
      this.zRW = 0.5F;
    }
    return this.zRW;
  }
  
  public final byte[] dOC()
  {
    return this.zSo;
  }
  
  public final long dOz()
  {
    return this.zSm;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(103635);
    this.callback = paramh;
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
    params = (cfi)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.zSm = params.aaoY;
      if (params.aaoZ != null) {
        this.zSn = params.aaoZ.Op;
      }
      this.zRW = params.aapc;
      if (params.aaoX != null) {
        this.zSo = params.aaoX.Op;
      }
      Log.i("MicroMsg.NetSceneGetBioConfig", "carson logic bioId:%s Config is:%s ratio:%s", new Object[] { Long.valueOf(this.zSm), this.zSn, Float.valueOf(this.zRW) });
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(103636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.v
 * JD-Core Version:    0.7.0.1
 */