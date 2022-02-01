package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private wn qwl;
  private wm qwm;
  private final d rr;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(213150);
    d.a locala = new d.a();
    locala.iLN = new wm();
    locala.iLO = new wn();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.aXF();
    this.qwm = ((wm)this.rr.iLK.iLR);
    this.qwm.LhC = paramInt1;
    this.qwm.yRL = paramInt2;
    this.qwm.LhD = paramString1;
    this.qwm.url = paramString2;
    this.qwm.LhE = ((int)(System.currentTimeMillis() / 1000L));
    this.qwm.Lha = paramb;
    AppMethodBeat.o(213150);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(213151);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(213151);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(213152);
    Log.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.qwl = ((wn)((d)params).iLL.iLR);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(213152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */