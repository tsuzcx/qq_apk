package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends q
  implements m
{
  private i callback;
  public d rr;
  
  public j(String paramString)
  {
    AppMethodBeat.i(127838);
    d.a locala = new d.a();
    locala.iLN = new ehg();
    locala.iLO = new ehh();
    locala.uri = "/cgi-bin/micromsg-bin/thirdappverify";
    locala.funcId = 755;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    ((ehg)this.rr.iLK.iLR).Luy = paramString;
    ((ehg)this.rr.iLK.iLR).NgU = 1;
    ((ehg)this.rr.iLK.iLR).rBI = LocaleUtil.getApplicationLanguage();
    paramString = Util.getUuidRandom();
    ((ehg)this.rr.iLK.iLR).KPW = z.aC(paramString);
    this.rr.setRsaInfo(ac.gtT());
    this.rr.option = 1;
    this.rr.getReqObj().setPassKey(paramString);
    this.rr.getReqObj().setSceneStatus(1);
    AppMethodBeat.o(127838);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127839);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(127839);
    return i;
  }
  
  public final int getType()
  {
    return 755;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127840);
    Log.i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.j
 * JD-Core Version:    0.7.0.1
 */