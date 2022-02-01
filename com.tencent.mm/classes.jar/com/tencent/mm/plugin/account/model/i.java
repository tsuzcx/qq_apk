package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.fmq;
import com.tencent.mm.protocal.protobuf.fmr;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends p
  implements m
{
  private h callback;
  public c rr;
  
  public i(String paramString)
  {
    AppMethodBeat.i(127838);
    c.a locala = new c.a();
    locala.otE = new fmq();
    locala.otF = new fmr();
    locala.uri = "/cgi-bin/micromsg-bin/thirdappverify";
    locala.funcId = 755;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    ((fmq)c.b.b(this.rr.otB)).ZxK = paramString;
    ((fmq)c.b.b(this.rr.otB)).abMU = 1;
    ((fmq)c.b.b(this.rr.otB)).yts = LocaleUtil.getApplicationLanguage();
    paramString = Util.getUuidRandom();
    ((fmq)c.b.b(this.rr.otB)).YOj = w.aN(paramString);
    this.rr.setRsaInfo(ac.iQe());
    this.rr.option = 1;
    this.rr.getReqObj().setPassKey(paramString);
    this.rr.getReqObj().setSceneStatus(1);
    AppMethodBeat.o(127838);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(127839);
    this.callback = paramh;
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
 * Qualified Name:     com.tencent.mm.plugin.account.model.i
 * JD-Core Version:    0.7.0.1
 */