package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.bhv;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends q
  implements m
{
  private i callback;
  private final d rr;
  public int zjs;
  private bhv zjt;
  private bhw zju;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(213540);
    d.a locala = new d.a();
    locala.iLN = new bhv();
    locala.iLO = new bhw();
    locala.funcId = 4362;
    locala.uri = "/cgi-bin/micromsg-bin/getallfunction";
    this.rr = locala.aXF();
    this.zjt = ((bhv)this.rr.iLK.iLR);
    this.zjs = paramInt;
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "walletRegion: %s", new Object[] { Integer.valueOf(this.zjs) });
    this.zjt.KOr = this.zjs;
    AppMethodBeat.o(213540);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(213541);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(213541);
    return i;
  }
  
  public final int getType()
  {
    return 4362;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213542);
    Log.i("MicroMsg.NetSceneGetPayFunctionListNew", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.zju = ((bhw)((d)params).iLL.iLR);
      if (this.zju != null) {
        b.a(this.zju);
      }
    }
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(213542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.g
 * JD-Core Version:    0.7.0.1
 */