package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class l
  extends w
{
  private h callback;
  private final c rr;
  private yh wYG;
  private yg wYH;
  
  public l(int paramInt1, int paramInt2, String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(293527);
    c.a locala = new c.a();
    locala.otE = new yg();
    locala.otF = new yh();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.bEF();
    this.wYH = ((yg)c.b.b(this.rr.otB));
    this.wYH.ZgV = paramInt1;
    this.wYH.amount = paramInt2;
    this.wYH.ZgW = paramString1;
    this.wYH.url = paramString2;
    this.wYH.ZgX = ((int)(System.currentTimeMillis() / 1000L));
    this.wYH.Zgu = paramb;
    AppMethodBeat.o(293527);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(293529);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(293529);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(293533);
    Log.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.wYG = ((yh)c.c.b(((c)params).otC));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(293533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.l
 * JD-Core Version:    0.7.0.1
 */