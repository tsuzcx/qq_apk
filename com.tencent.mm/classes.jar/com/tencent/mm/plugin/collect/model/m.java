package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private i callback;
  private final d rr;
  private wp tVk;
  private wo tVl;
  
  public m(int paramInt1, int paramInt2, String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(215329);
    d.a locala = new d.a();
    locala.lBU = new wo();
    locala.lBV = new wp();
    locala.funcId = 3781;
    locala.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
    this.rr = locala.bgN();
    this.tVl = ((wo)d.b.b(this.rr.lBR));
    this.tVl.SiP = paramInt1;
    this.tVl.amount = paramInt2;
    this.tVl.SiQ = paramString1;
    this.tVl.url = paramString2;
    this.tVl.SiR = ((int)(System.currentTimeMillis() / 1000L));
    this.tVl.Sio = paramb;
    AppMethodBeat.o(215329);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(215332);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(215332);
    return i;
  }
  
  public final int getType()
  {
    return 3781;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215334);
    Log.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tVk = ((wp)d.c.b(((d)params).lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.m
 * JD-Core Version:    0.7.0.1
 */