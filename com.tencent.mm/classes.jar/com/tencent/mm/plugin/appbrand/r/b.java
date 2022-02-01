package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exu;
import com.tencent.mm.protocal.protobuf.exv;
import com.tencent.mm.protocal.protobuf.exw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Locale;

public final class b
  extends q
  implements m
{
  private i heq;
  private d iIu;
  private exv nhv;
  
  public b()
  {
    AppMethodBeat.i(47749);
    d.a locala = new d.a();
    locala.iLN = new exu();
    locala.iLO = new exv();
    locala.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iIu = locala.aXF();
    AppMethodBeat.o(47749);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(47750);
    Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.iIu, this);
    AppMethodBeat.o(47750);
    return i;
  }
  
  public final int getType()
  {
    return 1170;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(47751);
    Log.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.nhv = ((exv)this.iIu.iLL.iLR);
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.nhv.Nvb == null)
    {
      AppMethodBeat.o(47751);
      return;
    }
    paramString = com.tencent.mm.kernel.g.aAh().azQ();
    paramString.set(ar.a.Oai, Locale.getDefault().getLanguage());
    paramString.set(ar.a.Oaj, this.nhv.Nvb.xJH);
    paramString.set(ar.a.Oam, this.nhv.Nvb.Nve);
    paramString.set(ar.a.Oan, Long.valueOf(System.currentTimeMillis()));
    paramString.set(ar.a.Oak, this.nhv.Nvc.xJH);
    paramString.set(ar.a.Oal, this.nhv.Nvd.xJH);
    AppMethodBeat.o(47751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.b
 * JD-Core Version:    0.7.0.1
 */