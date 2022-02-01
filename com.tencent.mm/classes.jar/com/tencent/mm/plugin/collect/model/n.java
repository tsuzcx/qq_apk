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
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends q
  implements m
{
  private i callback;
  private final d rr;
  private wq tVm;
  private wr tVn;
  
  public n(String paramString, b paramb)
  {
    AppMethodBeat.i(277311);
    d.a locala = new d.a();
    locala.lBU = new wq();
    locala.lBV = new wr();
    locala.funcId = 4561;
    locala.uri = "/cgi-bin/mmpay-bin/report_qrcode_scan_identify_scene";
    this.rr = locala.bgN();
    this.tVm = ((wq)d.b.b(this.rr.lBR));
    this.tVm.url = paramString;
    this.tVm.SiS = paramb;
    AppMethodBeat.o(277311);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(277314);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(277314);
    return i;
  }
  
  public final int getType()
  {
    return 4561;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(277317);
    Log.i("MicroMsg.NetSceneF2fQrcodeScanIdentify", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.tVn = ((wr)d.c.b(((d)params).lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(277317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.n
 * JD-Core Version:    0.7.0.1
 */